package controller;

import model.MainViewInputObject;
import model.globals.Globals;
import model.web.WebConnection;

public class MainViewController extends Controller{
	
	public MainViewController(){
	}
	
	@Override
	public void setActionPerformed(String actionPerformer, MainViewInputObject inputObject){
		if(actionPerformer.equals(Globals.actions.MainView_AttachAd)){
			
			//TODO
			//1. Create instance of internet connection
			WebConnection connection = new WebConnection();
			
			//2. Get url & credentials from SettingsObject
			//3. Connect with website 
			//4. Write code, title, description. Get from 
		}
	}
	
}
