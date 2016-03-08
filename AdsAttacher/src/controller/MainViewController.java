package controller;

import java.util.Iterator;

import org.cyberneko.html.HTMLElements.Element;

import com.gargoylesoftware.htmlunit.html.DomElement;

import model.MainViewInputObject;
import model.globals.Globals;
import model.web.WebConnection;
import model.web.WebPageManipulation;

public class MainViewController extends Controller{
	
	private WebConnection connection;
	private WebPageManipulation webPageManipulation;
	
	public MainViewController(){
	}
	
	@Override
	public void setActionPerformed(String actionPerformer, MainViewInputObject inputObject){
		if(actionPerformer.equals(Globals.actions.MainView_AttachAd)){
			
			//TODO
			//1. Create instance of internet connection
			connection = new WebConnection();
			
			//2. Get url & credentials from SettingsObject
			
			//3. Connect with website 
			try{
				connection.connect("http://interestingfacts.altervista.org/wp-admin");//Take this url from SettingViewInputObject
			}catch(Exception e){
				//Get Default Dialog used for exceptions, & add exception
				//Show Dialog
			}
			
			webPageManipulation = new WebPageManipulation(connection.getStartPage());
			Iterator<DomElement> itr = webPageManipulation.getAllElements(webPageManipulation.getFormByNr(0)).iterator();
			while(itr.hasNext()){
				DomElement elem = itr.next();
				
				//(Read-Write XML) must be ok before this 'todo'
				
				/* TODO
				 * For each element we iterate, we get the corresponding value for 
				 * that input from MainViewInputObject, and from 
				 * webPageManipulation.setElement(element,text) set the value inside 
				 * the element
				 */
			}
			
			
			//4. Write code, title, description. Get from 
		}
	}
	
}
