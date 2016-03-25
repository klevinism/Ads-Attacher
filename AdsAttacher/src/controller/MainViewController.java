package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;

import model.MainViewInputObject;
import model.globals.Globals;
import model.web.WebConnection;
import model.web.WebPageManipulation;

public class MainViewController extends Controller{
	
	private WebConnection connection;
	private WebPageManipulation webPageManipulation;
	private MainViewInputObject InputObject;
	private String EmbedCode = "<iframe width='560' height='315' src='#' frameborder='0' allowfullscreen></iframe>";
	private String AdCode = "<style>div.wrax { width: 100%; height: 100%; overflow: auto; }"
			+ "img.bg { min-height: 100%; min-width: 1024px; width: 100%; height: 100%; position: "
			+ "fixed; top: 0; left: 0; z-index: 0; }"
			+ "@media screen and (max-width: 1024px) { img.bg { left: 50%; margin-left: -512px; } }"
			+ "#mis { text-align: center; position: absolute; width: 100%; height: 100%; top: 0; "
			+ "left: 0; color: #fff; font-family: 'palatino linotype', palatino; font-weight: normal;"
			+ " text-align: left; text-shadow: 0 1px 0 #000; z-index: 10; }#mis .description "
			+ "{ position: relative; width: 580px; left: 50%; margin-left: -290px; }"
			+ "#mis .description h1 { font-size: 32px; }"
			+ "#mis .description .warning { color: #f00; }"
			+ "#mis .description .link, #mis .description a { font-size: 22px; color: #fff; text-decoration: underline; }"
			+ "#mis .description .footer, #mis .description .footer a { font-size: 10px; }</style>"
			+ "<span id='link' class='link'><!-- Assume Website CONTENT is HERE -->"
			+ "<div id='wrax' style='position: absolute; opacity: 0; filter: alpha(opacity = 50); "
			+ "margin-left: 9px; z-index: 100;'>"
			+ "<script async src='//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js'></script>"
			+ "<!-- Altervista-interestingfacts-336X280 -->"
			+ "<ins class='adsbygoogle' style='display:inline-block;width:336px;height:280px' "
			+ "data-ad-client='ca-pub-7183438764234855' data-ad-slot='9005268128'></ins><script>"
			+ "(adsbygoogle = window.adsbygoogle || []).push({});</script> </div><script type='text/javascript'>"
			+ "jQuery( document ).ready( function() {$('#link').mousemove( function( e ) {"
			+ " $( '#wrax' ).css( { top: e.pageY - 17, left: e.pageX - 8} );} );} )</script></span>";
	
	public MainViewController(){
	}
	
	@Override
	public void setActionPerformed(String actionPerformer, MainViewInputObject inputObject){
		InputObject = inputObject;
		if(actionPerformer.equals(Globals.actions.MainView_AttachAd)){
			
			//TODO
			//1. Create instance of internet connection
			connection = new WebConnection();
			try{
				connection.connect("http://interestingfacts.altervista.org/wp-admin");
				//Take this url from SettingViewInputObject
			}catch(Exception e){
				//Get Default Dialog used for exceptions, & add exception
				//Show Dialog
			}
			
			if(this.login()){//Login to site
				
				try {
					connection.connect("http://interestingfacts.altervista.org/wp-admin/post-new.php");
				} catch (Exception e) {
					//Get Default Dialog used for exceptions, & add exception
					//Show Dialog
				}
				
				String postUrl = this.post();//Post to site
				
				System.out.println(postUrl);
			}
		}
	}

	private boolean login(){
		webPageManipulation = new WebPageManipulation(connection.getStartPage());
		
		HtmlForm form = webPageManipulation.getFormByNr(0);
		Iterator<DomElement> itr = webPageManipulation.getAllElements(form).iterator();
		String[] str = {"","ourbusiness12"};
		int cnt=0;
		
		while(itr.hasNext()){
			DomElement elem = itr.next();
			if(elem.hasChildNodes()){
				DomElement childElem = elem.getFirstElementChild();
				if(childElem.getNodeName().equals("input")&&cnt==1){
					webPageManipulation.setElement(childElem,str[cnt]);
				}
				cnt++;
			}
		}

		HtmlButton btnSubmit = webPageManipulation.getSubmitButton(form);
		try {
			btnSubmit.click();
			return true;
		} catch (IOException e) {
			//Get Default Dialog used for exceptions, & add exception
			//Show Dialog
			return false;
		}
	}
	
	private String post(){
		String postedUrl = null;
		
		webPageManipulation = new WebPageManipulation(connection.getStartPage());
		DomElement titleElement = webPageManipulation.getElementById("title");
		HtmlTextArea contentElement =(HtmlTextArea) webPageManipulation.getElementById("content");
		HtmlSubmitInput publishButton = (HtmlSubmitInput)webPageManipulation.getElementById("publish");
		
		webPageManipulation.setElement(titleElement, InputObject.getTitle());
		contentElement.setText(AdCode+"\n"+EmbedCode.replaceFirst("#", InputObject.getVideoUrl().replace("watch?v=", "/embed/"))+
				"\n"+EmbedCode.replaceFirst("#", InputObject.getVideoUrl().replace("watch?v=", "/embed/"))+"\n"+InputObject.getDescription());
		
		
		try {
			HtmlPage nxt = publishButton.click();
			webPageManipulation.setPage(nxt);
			
			DomElement url_posted = webPageManipulation.getElementById("editable-post-name");
			JOptionPane.showMessageDialog(null, "http://interestingfacts.altervista.org/"+url_posted.getTextContent());
			StringSelection selection = new StringSelection("http://interestingfacts.altervista.org/"+url_posted.getTextContent());
		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    clipboard.setContents(selection, selection);
		} catch (IOException e) {
			//Get Default Dialog used for exceptions, & add exception
			//Show Dialog
		}
		
		/*
		 * TODO 
		 * 1- set title 
		 * 2- set description
		 * 3- get url of post
		 * 4- publish
		 */
		return postedUrl;
	}
	
}
