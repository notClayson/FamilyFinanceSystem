package data;

import java.util.Vector;

public class User {
	private Vector<DetailedExpense> UserExpense = new Vector<DetailedExpense>();
	private Vector<Allowance> UserAllowance = new Vector<Allowance>();
	private Vector<User> Users;
	private double amount;
	private double amount2;
	private double amt;
	
	public User[] getUsers()
	{
		 User[] Arr = new User[this.Users.size()];
		 this.Users.toArray(Arr); //make vector into an array
		 return Arr; //return array
	}
	
	public String pwd;

	public String name;

	
	// user
	public User(String n,String p) 
	{
		this.name=n;
		this.pwd=p;
		
	}
	
	public User(double amount2, String n,String p)// allowance, name, password
	{
		this.name=n;
		this.pwd=p;
		this.amount2 = amount2;
		
	}
	
	public String getPwd()
	{
	 	 return pwd; 
	}

	public void setPwd(String pwd) 
	{ 
		 this.pwd = pwd; 
	}

	public String getName() 
	{
	 	 return name; 
	}
	
	public void setName(String name) 
	{ 
		 this.name = name; 
	} 
	
	
	// allowance
	public Allowance[] getAllAllo() 
	{ 
		Allowance[] opArr = new Allowance[this.UserAllowance.size()];
		this.UserAllowance.toArray(opArr);
		return opArr;
	}
	

	public void addAllowance(String n,double f)
	{
		Allowance allo = new Allowance(n,f);
		this.UserAllowance.add(allo);
	}
	
	public void deleteAllowance(int index2, Allowance allo)
	{
		this.UserAllowance.remove(index2);
		this.UserAllowance.remove(allo);
	}
	
	public void editAllowance(int index2, Allowance newAllo)
	{
		this.UserAllowance.setElementAt(newAllo, index2);
	}
	
//	public double getAllowance()
//	{
//		return amount;
//	}

	public void setuserAllowance(double amount2) //sets user allowance for a specific user
	{
		this.amount2 = amount2;
	}

	public double getUserAllowance() //gets user allowance for a specific user
	{
		return amount2;
	}
	
	
	// expense
	public DetailedExpense[] getAllExpense()
	{
		 DetailedExpense[] opArr = new DetailedExpense[this.UserExpense.size()];
		 this.UserExpense.toArray(opArr); //make vector into an array
		 return opArr; //return array
	}
	
	public void addDExpense(String i, double a, String D, String c)
	{
		DetailedExpense e = new DetailedExpense(i,a,D,c);
		e.setItemDescription(i);
		e.setItemAmount(a);
		e.setItemDate(D);
		e.setItemCategory(c);
		this.UserExpense.add(e);
	}


	public void deleteExpense(int numRow, DetailedExpense e )
	{
		this.UserExpense.remove(numRow);
		this.UserExpense.remove(e);
	}
	
	public void editExpense(int index, DetailedExpense newDEX) 
	{
		this.UserExpense.setElementAt(newDEX, index);//update selected expense using index
	}

	
//	public double getAllowance()
//	{
//		return amount;
//	}
//
//	public void setuserAllowance(double amount2) //sets user allowance for a specific user
//	{
//		this.amount2 = amount2;
//	}
//
//	public double getUserAllowance() //gets user allowance for a specific user
//	{
//		return amount2;
//	}
	public double getBaller(){ // get user with highest expense
		return amt;
	}







	

}