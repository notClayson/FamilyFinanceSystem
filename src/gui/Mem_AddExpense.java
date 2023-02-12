package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;

import controller.MainFrame;
import data.Category;
import data.DataStorage;
import data.User;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import javax.swing.JCheckBox;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Haziq

public class Mem_AddExpense extends JPanel{
	private MainFrame main;
	private Mem_DisplayExpensePanel showlist;
	private JTextField textField_2;
	private JComboBox categoryBox, dayBox, monthBox, yearBox;
	private Category[] cat;
	private String [] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	private String [] day = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	private String [] year = {"2022","2023","2024"};
	private String c ="";
	private String m = "";
	private String d = "";
	private String y = "";
	
	private JTextField textField_1;
	
	public Mem_AddExpense(MainFrame main) {
		this.main = main;
		this.setSize(751, 550);
		setLayout(null);
		
		JLabel lblAdd = new JLabel("Add Expense");
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("MV Boli", Font.BOLD, 25));
		lblAdd.setBounds(285, 40, 176, 54);
		add(lblAdd);
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		cat = main.getController().getAllCat(); 
		 DefaultComboBoxModel model = new DefaultComboBoxModel();
		  
		 // adds categories by Head
		 for(int i=0; i<cat.length; i++) // loop category combo box length
		  {
			Category op = cat[i];
			
			model.addElement(op.getCategoryName().toString()); // updates combo box model
			
		  }
		
//		JButton btnNewButton_2 = new JButton("Edit Profile");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				main.showMemInfo();
//			}
//		});
//		btnNewButton_2.setBounds(10, 282, 89, 23);
//		add(btnNewButton_2);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = new Color(102, 255, 255);
		gradientPanel.setkStartColor(new Color(102, 255, 255));
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		// adds expense 
		KButton btnAddExpense = new KButton();
		btnAddExpense.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String i = textField_1.getText();
				
				double a = Double.parseDouble(textField_2.getText());//make double readable for getText()
				
				String D = d + m + y; // combines date month and year into 1 string
				
				c= categoryBox.getSelectedItem().toString(); // combo box selected month to string
				
				User u = main.getController().getUser(main.getController().getUserInUse("name"));// returns current user 

				u.addDExpense(i,a,D,c); // add expense to current user
				
				main.showDisplayExpensePanel();
			
			}
		});
		
		btnAddExpense.setText("Add");
		btnAddExpense.setOpaque(false);
		btnAddExpense.kStartColor = new Color(51, 204, 102);
		btnAddExpense.setkStartColor(new Color(51, 204, 102));
		btnAddExpense.kHoverStartColor = new Color(204, 255, 153);
		btnAddExpense.setkHoverStartColor(new Color(204, 255, 153));
		btnAddExpense.kHoverForeGround = new Color(153, 204, 153);
		btnAddExpense.setkHoverForeGround(new Color(153, 204, 153));
		btnAddExpense.kEndColor = new Color(0, 153, 51);
		btnAddExpense.setkEndColor(new Color(0, 153, 51));
		btnAddExpense.kBorderRadius = 40;
		btnAddExpense.setkBorderRadius(40);
		btnAddExpense.setContentAreaFilled(false);
		btnAddExpense.setBorderPainted(false);
		btnAddExpense.setBounds(307, 384, 135, 29);
		gradientPanel.add(btnAddExpense);
		
		// returns user to family member screen
		JButton btnBack = new JButton("Back ");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				main.showMember();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnBack.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		label.setBounds(10, 384, 263, 29);
		gradientPanel.add(label);
		
		
		// brings user to display expense screen
		JButton btnNewButton_1 = new JButton("Next");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				main.showDisplayExpensePanel();
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBounds(619, 469, 89, 23);
		gradientPanel.add(btnNewButton_1);
	
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBounds(243, 147, 260, 26);
		gradientPanel.add(textField_1);
		textField_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField_1.setOpaque(false);
		textField_1.setColumns(10);
		
		JLabel lblItem = new JLabel("Item:");
		lblItem.setForeground(Color.WHITE);
		lblItem.setBounds(213, 128, 69, 20);
		gradientPanel.add(lblItem);
		lblItem.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(213, 184, 69, 20);
		gradientPanel.add(lblAmount);
		lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(213, 242, 46, 14);
		gradientPanel.add(lblDate);
		lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JLabel lblCatergory = new JLabel("Category:");
		lblCatergory.setForeground(Color.WHITE);
		lblCatergory.setBounds(213, 313, 118, 23);
		gradientPanel.add(lblCatergory);
		lblCatergory.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		this.dayBox = new JComboBox(this.day);
		dayBox.setBounds(240, 267, 46, 26);
		gradientPanel.add(dayBox);
		dayBox.setBackground(Color.WHITE);
		
		this.monthBox = new JComboBox(this.month);
		monthBox.setBounds(339, 267, 54, 26);
		gradientPanel.add(monthBox);
		this.categoryBox = new JComboBox(model);
		categoryBox.setBounds(240, 344, 263, 26);
		gradientPanel.add(categoryBox);
		categoryBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.yearBox = new JComboBox(this.year);
		yearBox.setBounds(436, 267, 67, 26);
		gradientPanel.add(yearBox);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setBounds(243, 205, 260, 26);
		gradientPanel.add(textField_2);
		textField_2.setOpaque(false);
		textField_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setColumns(10);
		
		JLabel GIF = new JLabel("New label");
		GIF.setBounds(533, 11, 175, 179);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/shopping.png")));
		
		// write to file
		KButton btnWriteToFile = new KButton();
		btnWriteToFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				User u = main.getController().getUser(main.getController().getUserInUse("name")); // gets current user
				
				String name = u.getName(); // gets name
				
				String item= textField_1.getText();	
				
				double amt = Double.valueOf(textField_2.getText()); // convert text field to double
				
				String Date = dayBox.getSelectedItem().toString() + monthBox.getSelectedItem().toString() + yearBox.getSelectedItem().toString(); // combine combo box of day, month and year into 1 String
				
				c= categoryBox.getSelectedItem().toString(); 
				
				
				try 
				{
					main.getController().writeExpense(name,item,amt, Date, c); //writes 
				} 
				catch ( Exception x) 
				{
					x.printStackTrace();
					
					System.out.println("Something went wrong.");
				}
						
		}});		
		
		btnWriteToFile.setText("Write To File");
		btnWriteToFile.setOpaque(false);
		btnWriteToFile.kStartColor = new Color(51, 204, 102);
		btnWriteToFile.setkStartColor(new Color(51, 204, 102));
		btnWriteToFile.kHoverStartColor = new Color(204, 255, 153);
		btnWriteToFile.setkHoverStartColor(new Color(204, 255, 153));
		btnWriteToFile.kHoverForeGround = new Color(153, 204, 153);
		btnWriteToFile.setkHoverForeGround(new Color(153, 204, 153));
		btnWriteToFile.kEndColor = new Color(0, 153, 51);
		btnWriteToFile.setkEndColor(new Color(0, 153, 51));
		btnWriteToFile.kBorderRadius = 40;
		btnWriteToFile.setkBorderRadius(40);
		btnWriteToFile.setContentAreaFilled(false);
		btnWriteToFile.setBorderPainted(false);
		btnWriteToFile.setBounds(307, 424, 135, 29);
		gradientPanel.add(btnWriteToFile);
		
				// brings user to display expense screen
				btnAddExpense.addActionListener(new ComboBoxListener());
				btnAddExpense.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						main.showDisplayExpensePanel();
			
					}
		});
		
	}
	private class ComboBoxListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			c= categoryBox.getSelectedItem().toString();//convert combo box selection to string 
			
			d= dayBox.getSelectedItem().toString();
			
			m= monthBox.getSelectedItem().toString();
			
			y= yearBox.getSelectedItem().toString();
			
		}
	}
		
}
	

