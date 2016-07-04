package model.web;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class WebConnection{
	private WebClient webClient;
	private HtmlPage startPage;
	private WebPageManipulation webPageManipulation;
	
	public WebConnection(){
		webClient = new WebClient();
		webClient.setJavaScriptTimeout(1000);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setActiveXNative(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setAppletEnabled(false);
		webClient.getOptions().setDoNotTrackEnabled(false);
		webClient.getOptions().setPopupBlockerEnabled(false);
	}
	
	public void connect(String url) throws MalformedURLException, IOException{
		startPage = webClient.getPage(url);
	}
	
	public HtmlPage getStartPage(){
		return startPage;
	}
	
	public boolean login(){
		webPageManipulation = new WebPageManipulation(getStartPage());
		
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
	
}
