package model;

import java.util.List;

public class UpdaterObject {
	
	private String Version;
	private String Description;
	private String Url;
	private String[] Arr;
	
	public UpdaterObject(){
		
	}
	
	public UpdaterObject(String[] arr){
		Arr = arr;
	}
	
	public UpdaterObject(List<String> str){
		Arr = new String[]{str.get(0)};
	}
	
	public void setCurrentVersion(String version){
		Version = version;
	}
	
	public String getCurrentVersion(int x){
		return Arr[x];
	}
	
}
