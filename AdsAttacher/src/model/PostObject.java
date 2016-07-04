package model;

import java.util.LinkedList;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.javascript.host.Element;

import model.web.WebConnection;
import model.web.WebPageManipulation;

public class PostObject{
	private int Id; 
	private String Url;
	private String Title;
	private String Author;
	private String Category;
	private String Date;	
	 
	public PostObject(){
	}
	
	public PostObject(int id, String url, String title, String author, String category, String date){
		Id = id;
		Url = url;
		Title = title;
		Author = author;
		Category = category;
		Date = date;
	}
	
	public void setId(int id){
		Id = id;
	}
	
	public int getId(){
		return Id;
	}
	
	public void setUrl(String url){
		Url = url;
	}
	
	public String getUrl(){
		return Url;
	}
	
	public void setTitle(String title){
		Title = title;
	}
	
	public String getTitle(){
		return Title;
	}
	
	public void setAuthor(String author){
		Author = author;
	}
	
	public String getAuthor(){
		return Author;
	}
	
	public void setCategory(String category){
		Category = category;
	}
	
	public String getCategory(){
		return Category;
	}

	public void setDate(String date){
		Date = date;
	}
	
	public String getDate(){
		return Date;
	}
	
	public LinkedList<PostObject> getAllPosts(){
		//TODO
		//1 connect to page
		WebConnection conn = new WebConnection();
		try {
			conn.connect("http://interestingfacts.altervista.org/wp-admin");

			if(conn.login()){
				conn.connect("http://interestingfacts.altervista.org/wp-admin/edit.php");
			}

		} catch (Exception e) {
			// TODO Handle this
			e.printStackTrace();
		}
		
		//2 get all posts
		WebPageManipulation wpManipulation = new WebPageManipulation(conn.getStartPage());

		List<DomElement> listId =  (List<DomElement>) wpManipulation.getByXPath("//input[@name='post[]']");
		List<DomElement> listUrl =  (List<DomElement>) wpManipulation.getByXPath("//a[@class='row-title']");
		List<DomElement> listTitle =  (List<DomElement>) wpManipulation.getByXPath("//a[@class='row-title']");
		List<DomElement> listAuthor =  (List<DomElement>) wpManipulation.getByXPath("//td[@class='author column-author']");
		List<DomElement> listCategory =  (List<DomElement>) wpManipulation.getByXPath("//td[@class='categories column-categories']");
		List<DomElement> listDate =  wpManipulation.getElementsByTagName("abbr");

		LinkedList<PostObject> linkedPosts = new LinkedList<PostObject>();
		
		for(int x=0; x<listId.size();x++){
			PostObject singlePost = new PostObject();

			singlePost.setId(Integer.parseInt(listId.get(x).getAttribute("value")));
			singlePost.setUrl(listTitle.get(x).getAttribute("href"));
			singlePost.setTitle(listTitle.get(x).asText());
			singlePost.setAuthor(listAuthor.get(x).asText());
			singlePost.setCategory(listCategory.get(x).asText());
			singlePost.setDate(listDate.get(x).asText());
			
			linkedPosts.add(singlePost);
		}
		
		//3 return them all
		return linkedPosts;
	}
}
