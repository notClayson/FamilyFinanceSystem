package data;

public class DetailedExpense {
	
	public DetailedExpense(String i, double a, String D, String c) {
		this.itemDescription=i;
		this.itemAmount = a;
		this.itemDate = D;
		this.itemCategory = c;
	}

	private String itemDate;

	private String itemDescription;

	private double itemAmount;
	
	private String itemCategory;

	public String getItemDate() {
	 	 return itemDate; 
	}

	public void setItemDate(String itemDate) { 
		 this.itemDate = itemDate; 
	}

	public String getItemDescription() {
	 	 return itemDescription; 
	}

	public void setItemDescription(String itemDescription) { 
		 this.itemDescription = itemDescription; 
	}

	public double getItemAmount() {
	 	 return itemAmount; 
	}

	public void setItemAmount(double a) { 
		 this.itemAmount = a; 
	}

	public String getItemCategory() {
	 	 return itemCategory; 
	}


	public void setItemCategory(String itemCategory) { 
		 this.itemCategory = itemCategory; 
	}
//	public void setitemName(String name) {
//		// TODO Auto-generated method stub
//		
//	} 

}
