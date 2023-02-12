package controller;

import java.awt.CardLayout;

import javax.swing.JFrame;

import data.Allowance;
import data.Category;
import data.DetailedExpense;
import gui.Head_ShowAllowance;
import gui.Head_ShowCategories;
import gui.Head_Summary;
import gui.LoginMember;
import gui.MemberInfo;
import gui.Head_AllocateAllowance;
//import gui.CalculateExpenses;
import gui.Mem_DisplayExpensePanel;
import gui.Head_EditAllowance;
import gui.Head_EditCategory;
import gui.Mem_EditExpensePanel;
import gui.Head_AddCategories;
import gui.Mem_AddExpense;
import gui.Head_FamilyHeadScreen;
import gui.Mem_FamilyMemberScreen;
import gui.LoginHead;
import gui.RegUserScreen;

//THIS IS THE ONE NEEDED TO CHANGE
public class MainFrame extends JFrame {

	private CardLayout card;
	private Controller cont;

	public MainFrame() {
		this.setTitle("Family Expense Tracker");
		this.setSize(750, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		this.card = new CardLayout();
		this.setLayout(this.card);
		this.cont = new Controller();

		this.showRegScreen();

		this.setVisible(true);
	}

	public Controller getController() {
		return this.cont;
	}

	// Registration Screen
	public void showRegScreen() {
		RegUserScreen p1 = new RegUserScreen(this);
		this.add(p1, "Panel1");
		this.card.show(this.getContentPane(), "Panel1");
	}

	// Login Screen
	public void showLoginMem() {
		LoginMember p2 = new LoginMember(this);
		this.add(p2, "Panel2");
		this.card.show(this.getContentPane(), "Panel2");
	}

	// Member Opening Screen
	public void showMember() {
		Mem_FamilyMemberScreen p3 = new Mem_FamilyMemberScreen(this);
		this.add(p3, "Panel3");
		this.card.show(this.getContentPane(), "Panel3");
	}

	// Member Add Expense Screen
	public void showAddEx() {
		Mem_AddExpense p4 = new Mem_AddExpense(this);
		this.add(p4, "Panel4");
		this.card.show(this.getContentPane(), "Panel4");
	}

	public void showMemInfo() {
		MemberInfo p5 = new MemberInfo(this);
		getContentPane().add(p5, "AddRecord");
		this.card.show(this.getContentPane(), "AddRecord");
	}

	public void showDisplayExpensePanel() {
		Mem_DisplayExpensePanel p6 = new Mem_DisplayExpensePanel(this);
		getContentPane().add(p6, "DisplayExpense");
		this.card.show(this.getContentPane(), "DisplayExpense");
	}

	public void showEditExpensePanel(int ind, DetailedExpense dEx) {
		Mem_EditExpensePanel p7 = new Mem_EditExpensePanel(this, ind, dEx);
		getContentPane().add(p7, "DisplayEditExpensePanel");
		this.card.show(this.getContentPane(), "DisplayEditExpensePanel");
	}

	public void showLoginHead() {
		LoginHead p8 = new LoginHead(this);
		this.add(p8, "Panel8");
		this.card.show(this.getContentPane(), "Panel8");
	}

	public void showAddExpense() {
		Mem_AddExpense p9 = new Mem_AddExpense(this);
		this.add(p9, "Panel9");
		this.card.show(this.getContentPane(), "Panel9");
	}

	public void showFamilyHead() {
		Head_FamilyHeadScreen p10 = new Head_FamilyHeadScreen(this);
		this.add(p10, "Panel10");
		this.card.show(this.getContentPane(), "Panel10");
	}

	public void AddCategories() {
		Head_AddCategories p11 = new Head_AddCategories(this);
		this.add(p11, "Panel11");
		this.card.show(this.getContentPane(), "Panel11");
	}

	public void showCategories() {
		Head_ShowCategories p12 = new Head_ShowCategories(this);
		this.add(p12, "Panel12");
		this.card.show(this.getContentPane(), "Panel12");
	}

	public void showEditCategory(int index1, Category cat) {
		Head_EditCategory p13 = new Head_EditCategory(this, index1, cat);
		this.add(p13, "Panel13");
		this.card.show(this.getContentPane(), "Panel13");
	}

	public void showAllowance() {
		Head_ShowAllowance p14 = new Head_ShowAllowance(this);
		this.add(p14, "Panel14");
		this.card.show(this.getContentPane(), "Panel14");
	}

	public void showAllocateAllowance() {
		Head_AllocateAllowance p15 = new Head_AllocateAllowance(this);
		this.add(p15, "Panel15");
		this.card.show(this.getContentPane(), "Panel15");
	}

	public void showEditAllowance(int index2, Allowance allo) {
		Head_EditAllowance p16 = new Head_EditAllowance(this, index2, allo);
		this.add(p16, "Panel16");
		this.card.show(this.getContentPane(), "Panel16");
	}

	public void showSummary() {
		Head_Summary p18 = new Head_Summary(this);
		this.add(p18, "Panel18");
		this.card.show(this.getContentPane(), "Panel18");
	}

	public static void main(String[] args) {
		MainFrame g2 = new MainFrame();
	}
}