package model;

public class PostObject{
	private int Id; 
	private String Title;
	private String Author;
	private String Category;
	private String Date;	
	 
	public PostObject(){
		
	}
	
	public PostObject(int id, String title, String author, String category, String date){
		Id = id;
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
}
