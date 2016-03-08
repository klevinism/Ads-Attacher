package model.web;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.*;
import com.gargoylesoftware.htmlunit.html.*;

public class WebConnection{
	private WebClient webClient;
	private HtmlPage startPage;
	
	public WebConnection(){
		webClient = new WebClient();
		webClient.getOptions().setJavaScriptEnabled(false);
	}
	
	public void connect(String url) throws MalformedURLException, IOException{
		startPage = webClient.getPage(url);
	}
	
	public HtmlPage getStartPage(){
		return startPage;
	}
	
}
