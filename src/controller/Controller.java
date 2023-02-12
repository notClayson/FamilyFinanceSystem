package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.Allowance;
import data.Category;
import data.CurrentUser;
import data.DataStorage;
import data.DetailedExpense;
import data.User;

public class Controller {
	private String ss = "", aa = "", bb = "", cc = "", dd = "", read = ""; // text file declarations
	private double p = 0.0, np = 0.0;

	public DataStorage ds;

	public Controller() {
		this.ds = new DataStorage();

	}

	// text filer writer
	public void writeExpense(String u, String i, double p, String d, String c) throws Exception {
		ss = u;
		aa = i;
		bb = d;
		dd = c;
		p = p;
		String fn = "src/data/EX.txt";
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fn));// text file writer
			out.write(ss + ";");
			out.newLine();
			out.write(aa + ";");
			out.newLine();
			out.write(String.valueOf(p) + ";");
			out.newLine();
			out.write(bb + ";");
			out.newLine();
			out.write(dd + ";");

			out.close();
			System.out.println("Writinig successful");
		} catch (IOException e) {// to return an error
			System.out.println("There was a problem:" + e);
		}
	}

	// text file reader
	public String readEx() throws Exception {

		try {
			cc = "";
			BufferedReader in = new BufferedReader(new FileReader("src/data/EX.txt"));// text file reader
			while ((read = in.readLine()) != null) {
				cc = cc + read;
			}
			System.out.println(cc);
			in.close();
			System.out.println("Reading Successful");
		} catch (IOException e) {// return an error
			System.out.println("There was a problem:" + e);
		}
		return cc;
	}

	// register user and store in data storage
	public void regUser(String n, String p) {
		User user = new User(n, p);
		this.ds.storeUser(user);
	}

	// register user paired with allowance in data storage
	public void regUser(double amount2, String n, String p) {
		User user = new User(amount2, n, p);
		this.ds.storeUser(user);
	}

	// ensure user entered correct password
	public boolean verifyUser(String n, String pwd) {
		String real = pwd;
		String cc = "";
		User t = ds.getUser(n);
		if (t != null) {// if User is registered, return true
			cc = t.getPwd().toString();
			if (real.equals(cc))// if content matches, return true
				return true;
			else
				return false;// if content does not match, return false
		} else
			return false;// if user is not registered, return
	}

	// sets user allowance
	public void setuserAllowance(double amount2, String username) {
		this.ds.getUser(username).setuserAllowance(amount2);
	}

	// gets user allowance
	public double getuserAllowance(String username) {
		return this.ds.getUser(username).getUserAllowance();
	}

	// gets user month (used for getting top spender for the month)
	public double getUserMonth(String username, String month) {
		return this.ds.getUserMonth(username, month); // get corresponding user with month
	}

	// adds created category
	public String add(String categoryName) {
		String result = categoryName;
		Category cat = new Category(result);
		this.ds.addCat(cat);
		return result;
	}

	// deletes category
	public void deleteCat(int index1) {
		this.ds.deleteCat(index1);
	}

	// edits selected category
	public void editCat(int index1, Category cat) {
		this.ds.editCat(cat, index1);
	}

	// retrieves all categories
	public Category[] getAllCat() {
		return this.ds.getAllCat();
	}

	// calculate total expense for user
	public double calculateUserExpense(String n) {
		return this.ds.calculateUserExpense(n);
	}

	// checks for existing user
	public boolean verifyUser1(String n1, String pwd1) {
		String real = pwd1;
		String ccc = "";
		User y = ds.getUser(n1);
		if (y != null) { // checks if user exists
			ccc = y.getPwd().toString();
			if (real.equals(ccc))
				return true;
			else
				return false;
		} else
			return false;
	}

	// add allowance
	public Allowance add(String n, double f) {
		Allowance allo = new Allowance(n, f);
		this.ds.addAllo(allo);
		return allo;
	}

	// delete allowance
	public void deleteAllo(int index2) {
		this.ds.deleteAllo(index2);
	}

	// edit allowance
	public void editAllo(int index2, Allowance allo) {
		this.ds.editAllo(allo, index2);
	}

	// retrieve all allowance
	public Allowance[] getAllAllo() {
		return this.ds.getAllAllo();
	}

	// find a specific user (used for finding user info eg. name,expense, etc.)
	public boolean findUser(String n) {
		User t = ds.getUser(n);
		if (t != null) {
			return true;
		} else {
			return false;
		}
	}

	public User[] getUsers() {
		return this.ds.getUsers();
	}

	public DetailedExpense[] getAllExpense() {
		return this.ds.getAllExpense();
	}

	// update user name
	public void updateUser(String n) {
		User t = ds.getUser(n);
		if (t != null) {
			t.setName(n);

		}
	}

	// update user password
	public void updateUser(String n, String p) {
		User t = ds.getUser(n);
		if (t != null) {
			t.setName(n);
			t.setPwd(p);
		}
	}

	// retrieve specific user
	public User getUser(String n) {
		return this.ds.getUser(n);
	}

	// set user currently logged in
	public void setUserInUse(String n, String p) {
		CurrentUser u = new CurrentUser();
		u.setName(n);
		u.setPwd(p);
		this.ds.currentUser(u);
	}

	// retrieves user currently logged in
	public String getUserInUse(String rqst) {
		return this.ds.getCurrentUser(rqst);
	}

	// get allowance
	public Allowance getAllowance(Double f) {
		return this.ds.getAllowance(f);
	}

}
