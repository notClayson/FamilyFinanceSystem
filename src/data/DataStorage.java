package data;

import java.util.Vector;

public class DataStorage {
	private Vector<Allowance> allowanceList;
	private Vector<Category> categoryList;
	Vector<User> storage = new Vector<User>();
	Vector<CurrentUser> cuser = new Vector<CurrentUser>();
	
	
	public DataStorage()
	{
		 this.categoryList=new Vector<Category>();
		 this.allowanceList=new Vector<Allowance>();
	}
	
	
	// category
	public void editCat(Category cat, int index) 
	{ 
		this.categoryList.set(index, cat);
	 }
	
	public void deleteCat(int index) 
	{ 
		this.categoryList.remove(index);
	 }
	
	public Category[] getAllCat() 
	{ 
		Category[] opArr= new Category[this.categoryList.size()];
		this.categoryList.toArray(opArr);
		return opArr;
	 }
	
	public void addCat(Category cat) 
	{ 
		this.categoryList.add(cat);
	 } 
	
	
	// user
	public void storeUser(User u) 
	{
		this.storage.add(u);
		for(int i=0; i<storage.size(); i++)
		{
			User temp = storage.get(i);
		}
	 }
	
	public User getUser(String n) 
	{
		for(int i=0; i<storage.size(); i++)	
		{
			User temp = storage.get(i);
			if (temp.getName().equals(n))
			{
			return temp;
			}
	      }
		return null;
	}

	
	public void currentUser(CurrentUser u)
	{
        if(cuser.size()>0)
        {
            for(int i=0;i<cuser.size();i++)
            {
            	cuser.remove(i);
            }
        }
        this.cuser.add(u);
    }
	
	public String getCurrentUser(String rqst)
	{
        if (cuser.size()> 0){
            CurrentUser t = cuser.get(0);
            if(rqst == "name")
            {
                return t.getName();
            }
            else if(rqst == "pwd")
            {
                return t.getPwd();
            }
        }
        return null;
    }
	
	public User[] getUsers()
	{
		 User[] Arr = new User[this.storage.size()];
		 this.storage.toArray(Arr); //make vector into an array
		 return Arr; //return array
	}
	
	public double getUserMonth(String n, String m)
	{
		User u = null;
		double total = 0;
		for(int i =0;i<storage.size();i++)
		{
			u = this.storage.get(i);
			if(u.getName().equals(n))
			{
				DetailedExpense ex[]= u.getAllExpense(); 
				for(int x = 0;x<ex.length;x++)
				{
					StringBuilder sb = new StringBuilder(ex[x].getItemDate().substring(2,5));// to cut month(ddmmmyyyy)(start index,end index)
					
					System.out.println(sb);
					
					if(sb.toString().equals(m)) // check if substring was set correctly
					{
						total += ex[x].getItemAmount();
						System.out.println(total); // check total
					}
				}
				break;
			}
		}
		return total;
	}
	
	
	// allowance
	public void editAllo(Allowance allo, int index2) 
	{ 
		this.allowanceList.set(index2, allo);
	 }
	
	public void deleteAllo(int index2) 
	{ 
		this.allowanceList.remove(index2);
	 }
	
	public Allowance[] getAllAllo()
	{ 
		Allowance[] opArr= new Allowance[this.allowanceList.size()];
		this.allowanceList.toArray(opArr);
		return opArr;
	 }
	
	public void addAllo(Allowance allo) 
	{ 
	this.allowanceList.add(allo);
	}
	
	public Allowance getAllowance(Double f) 
	{
		for(int i=0; i<allowanceList.size(); i++)	
		{
			Allowance temp = allowanceList.get(i);
			if (temp.getAmount().equals(f)){
			return temp;
			}
	      }
		return null;
	}
	
	// expense
	private Vector<DetailedExpense> expenseList = new Vector<DetailedExpense>();

	public DetailedExpense[] getAllExpense()
	{
		 DetailedExpense[] opArr = new DetailedExpense[this.expenseList.size()];
		 this.expenseList.toArray(opArr); //make vector into an array
		 return opArr; //return array
		 
	 }
	
	public void addExpenseList(DetailedExpense expense) 
	{
		this.expenseList.add(expense);
		for(int i=0; i<expenseList.size();i++)
		{
			DetailedExpense temp = expenseList.get(i);
		}
		
		
	}
	
	public void deleteExpense(int numRow, DetailedExpense e )
	{
		this.expenseList.remove(numRow);
		this.expenseList.remove(e);
	}


	public void editExpense(int index, DetailedExpense newDEX) 
	{
		this.expenseList.setElementAt(newDEX, index);//update selected expense using index
	}
	
	public double calculateUserExpense(String n)
	{
		User u = null;
		double total = 0;
		for(int i=0;i<storage.size();i++)
		{
			u = this.storage.get(i);
			if(u.getName().equals(n))
			{
				break;
			}
			}
			DetailedExpense ex[] = u.getAllExpense();
			for(int x=0;x<u.getAllExpense().length;x++)
			{
				total += ex[x].getItemAmount();
			}
			return total;
		}


}

	
		
		
	

