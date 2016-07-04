package model.web;

import java.util.Iterator;

import org.cyberneko.html.HTMLElements.Element;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

public class WebPageManipulation{
	private HtmlPage Page;
	
	public WebPageManipulation(HtmlPage page){
		Page = page;
	}
	
	public HtmlForm getFormByNr(int nr){
		return Page.getForms().get(nr);
	}
	
	public HtmlForm getFormByName(String name){
		return Page.getFormByName(name);
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<DomElement> getAllElements(HtmlForm form){
		return (Iterable<DomElement>)form.getChildElements(); 
	}
	
	public DomElement getElementById(String id){
		return Page.getElementById(id);
	}

	public DomElement getElementByName(String name){
		return Page.getElementByName(name);
	}
	
	public void setPage(HtmlPage page){
		Page = page;
	}

	public void setElement(DomElement element, String text){
		element.setAttribute("value",text);
	}
	
	public HtmlButton getSubmitButton(HtmlForm form){
		
		HtmlButton btn = null;
		Iterator<DomElement> itr = this.getAllElements(form).iterator();

		for(DomElement element; itr.hasNext();){
			element = itr.next();
			if(element.hasChildNodes()){
				if(element.getFirstChild().getNodeName().equals("button")){
					btn = (HtmlButton)element.getFirstChild();
				}
			}
		}
		
		return btn;
	}
	
}
