package data;

public class Category {

	
	private String categoryName;
	
	public Category()
	{
		this.categoryName=null;
	}
	
	public Category(String categoryName)
	{
		this.categoryName= categoryName;
	}

	public void setCategoryName(String categoryName)
	{ 
		 this.categoryName = categoryName; 
	} 
	
	public String getCategoryName() 
	{
	 	 return categoryName; 
	}

}