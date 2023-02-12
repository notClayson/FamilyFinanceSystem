package data;

public class Allowance 
{
	private String name;
	private double amount;
	
	public Allowance(String n,double f)
	{
		this.name=n;
		this.amount=f;
	}

	public String getName()
	{
		return name;
	}
	public Double getAmount() 
	{
	 	 return amount; 
	}
	public void setAmount(double amount) 
	{
		 this.amount = amount; 
	} 
	public void setName(String name) 
	{ 
		 this.name = name; 
	}

}
