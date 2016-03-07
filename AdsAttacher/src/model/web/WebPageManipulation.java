package model.web;

import java.util.Iterator;

import com.gargoylesoftware.htmlunit.html.DomElement;
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
	public Iterator<DomElement> getAllElements(HtmlForm form){
		return (Iterator<DomElement>)form.getChildElements(); 
	}
	
	public HtmlSubmitInput getSubmitButton(HtmlForm form){
		
		HtmlSubmitInput btn = null;
		Iterator<DomElement> itr = this.getAllElements(form);

		for(DomElement element; itr.hasNext();){
			element = itr.next();
			if(element.getAttribute("type").equals("submit")){
				btn = (HtmlSubmitInput)element;
			}
		}
		return btn;
	}
	
}
