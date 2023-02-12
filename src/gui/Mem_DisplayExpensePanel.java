package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import controller.MainFrame;
import data.Allowance;
import data.DetailedExpense;

import data.User;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.PatternSyntaxException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import com.k33ptoo.components.KButton;
import javax.swing.border.MatteBorder;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;

//Design- Haziq
//Features- Haziq
//Integration- Caisoon

public class Mem_DisplayExpensePanel extends JPanel {
		private MainFrame main;
		private DefaultTableModel model;
		private JTable table;
		private JLabel lblNewLabel;
		private DetailedExpense[] expenses;
		private double allowance;
		private String [] month = {"All","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
		private String m = "";
		private JComboBox monthBox;
		
		public Mem_DisplayExpensePanel(MainFrame main) {
			this.main = main;
			this.setSize(751, 550);
			setLayout(null);
		
		 
	    this.model=new DefaultTableModel();
	    final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);


	    model.addColumn("Item");//column names
	    model.addColumn("Amount");
	    model.addColumn("Date");
	    model.addColumn("Catergory");

	    
	    KGradientPanel gradientPanel = new KGradientPanel();
	    gradientPanel.setLayout(null);
	    gradientPanel.kStartColor = new Color(102, 255, 255);
	    gradientPanel.setkStartColor(new Color(102, 255, 255));
	    gradientPanel.setBounds(0, 0, 751, 550);
	    add(gradientPanel);
	    
	    KButton btnDelete = new KButton();
	    btnDelete.setText("Delete");
	    btnDelete.setOpaque(false);
	    btnDelete.kStartColor = new Color(51, 204, 102);
	    btnDelete.setkStartColor(Color.BLUE);
	    btnDelete.kHoverStartColor = new Color(204, 255, 153);
	    btnDelete.setkHoverStartColor(new Color(204, 255, 153));
	    btnDelete.kHoverForeGround = new Color(153, 204, 153);
	    btnDelete.setkHoverForeGround(new Color(153, 204, 153));
	    btnDelete.kEndColor = new Color(0, 153, 51);
	    btnDelete.setkEndColor(Color.PINK);
	    btnDelete.kBorderRadius = 40;
	    btnDelete.setkBorderRadius(40);
	    btnDelete.setContentAreaFilled(false);
	    btnDelete.setBorderPainted(false);
	    btnDelete.setBounds(10, 165, 135, 29);
	    gradientPanel.add(btnDelete);
	    
	    
	    
	    // returns user to add expense screen
	    JButton button_1 = new JButton("Back ");
	    button_1.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		main.showAddExpense();
	    	}
	    });
	    
	    
	    button_1.setForeground(Color.WHITE);
	    button_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
	    button_1.setContentAreaFilled(false);
	    button_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
	    button_1.setBounds(29, 469, 114, 23);
	    gradientPanel.add(button_1);
	    table = new JTable(model);
	    table.setForeground(Color.BLACK);
	    table.setGridColor(Color.WHITE);
	    table.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));

	    
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setBounds(244, 125, 452, 303);
	    gradientPanel.add(scrollPane);
	    
	    KButton btnEdit = new KButton();
	    btnEdit.setText("Edit");
	    btnEdit.setOpaque(false);
	    btnEdit.kStartColor = new Color(51, 204, 102);
	    btnEdit.setkStartColor(Color.BLUE);
	    btnEdit.kHoverStartColor = new Color(204, 255, 153);
	    btnEdit.setkHoverStartColor(new Color(204, 255, 153));
	    btnEdit.kHoverForeGround = new Color(153, 204, 153);
	    btnEdit.setkHoverForeGround(new Color(153, 204, 153));
	    btnEdit.kEndColor = new Color(0, 153, 51);
	    btnEdit.setkEndColor(Color.PINK);
	    btnEdit.kBorderRadius = 40;
	    btnEdit.setkBorderRadius(40);
	    btnEdit.setContentAreaFilled(false);
	    btnEdit.setBorderPainted(false);
	    btnEdit.setBounds(10, 125, 135, 29);
	    gradientPanel.add(btnEdit);
	    
	    KButton btnFilter = new KButton();
	    btnFilter.setText("Filter");
	    btnFilter.setOpaque(false);
	    btnFilter.kStartColor = new Color(51, 204, 102);
	    btnFilter.setkStartColor(Color.BLUE);
	    btnFilter.kHoverStartColor = new Color(204, 255, 153);
	    btnFilter.setkHoverStartColor(new Color(204, 255, 153));
	    btnFilter.kHoverForeGround = new Color(153, 204, 153);
	    btnFilter.setkHoverForeGround(new Color(153, 204, 153));
	    btnFilter.kEndColor = new Color(0, 153, 51);
	    btnFilter.setkEndColor(Color.PINK);
	    btnFilter.kBorderRadius = 40;
	    btnFilter.setkBorderRadius(40);
	    btnFilter.setContentAreaFilled(false);
	    btnFilter.setBorderPainted(false);
	    btnFilter.setBounds(42, 367, 135, 29);
	    gradientPanel.add(btnFilter);
	    
	    JLabel lblExpenses = new JLabel("Expenses");
	    lblExpenses.setBounds(285, 40, 124, 33);
	    gradientPanel.add(lblExpenses);
	    lblExpenses.setForeground(Color.WHITE);
	    lblExpenses.setFont(new Font("MV Boli", Font.BOLD, 25));
	    
     
     this.monthBox = new JComboBox(this.month);
     monthBox.setBounds(70, 336, 75, 20);
     gradientPanel.add(monthBox);
     
     JLabel lblSelectMonth = new JLabel("Select Month:");
     lblSelectMonth.setFont(new Font("Segoe UI", Font.BOLD, 15));
     lblSelectMonth.setForeground(Color.WHITE);
     lblSelectMonth.setBounds(29, 311, 106, 14);
     gradientPanel.add(lblSelectMonth);
     
     JLabel GIF = new JLabel("New label");
		GIF.setBounds(584, 11, 124, 103);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/shoppingList.png")));
		
		
		// read from text file
		KButton btnReadFromFile = new KButton();
		btnReadFromFile.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String cc="";
					
					cc = main.getController().readEx();
					
					System.out.println(cc);
					
					String[] dd = cc.split(";");
					
					String i = dd[1]; // indexing
					
					double a = Double.parseDouble(dd[2]); // converts string to double
					
					String D = dd[3];
				
					String c= dd[4];
					
					User u = main.getController().getUser(main.getController().getUserInUse("name")); // gets controller method to return current user
					
					u.addDExpense(i,a,D,c); // adds expense 
					
					main.showDisplayExpensePanel();
				
				} 
				catch (Exception e1) 
				{
					e1.printStackTrace();
				}
				
			}
			
		});
		
		btnReadFromFile.setText("Read From File");
		btnReadFromFile.setOpaque(false);
		btnReadFromFile.kStartColor = new Color(51, 204, 102);
		btnReadFromFile.setkStartColor(new Color(51, 204, 102));
		btnReadFromFile.kHoverStartColor = new Color(204, 255, 153);
		btnReadFromFile.setkHoverStartColor(new Color(204, 255, 153));
		btnReadFromFile.kHoverForeGround = new Color(153, 204, 153);
		btnReadFromFile.setkHoverForeGround(new Color(153, 204, 153));
		btnReadFromFile.kEndColor = Color.PINK;
		btnReadFromFile.setkEndColor(Color.PINK);
		btnReadFromFile.kBorderRadius = 40;
		btnReadFromFile.setkBorderRadius(40);
		btnReadFromFile.setContentAreaFilled(false);
		btnReadFromFile.setBorderPainted(false);
		btnReadFromFile.setBounds(240, 439, 135, 29);
		gradientPanel.add(btnReadFromFile);
		
		table.setRowSorter(sorter);
		
		// filer JTable
		btnFilter.addActionListener(new ActionListener() 
		{
     	public void actionPerformed(ActionEvent arg0) 
     	{
     		String m = monthBox.getSelectedItem().toString();
             
     		if(m.equals("All")) 
             {
                sorter.setRowFilter(null); // no filtering
             } 
             else 
             {
                try 
                {
                   sorter.setRowFilter(RowFilter.regexFilter(m)); // filter JTable by month
                } 
                catch(PatternSyntaxException pse) 
                {
                      System.out.println("Bad regex pattern");
                }
              }
     	}
     });
		
		
	// deletes selected expense on JTable and from user
     btnDelete.addActionListener(new ActionListener() 
     {
    	public void actionPerformed(ActionEvent e) {
    		
    		
    			int numRows = table.getSelectedRow();
    			if(numRows>=0)
    			{
    				if(numRows == -1) 
		    				return;//avoid double triggering when model is set
		    			
    				model.removeRow(numRows);//remove selected row from the JTable
		    			
    				DetailedExpense de = expenses[numRows];
		    			
    				User u = main.getController().getUser(main.getController().getUserInUse("name"));// gets controller method to return current user
		    			
    				u.deleteExpense(numRows,de); // deletes user expense
    			}
    			else
    			{
    				JOptionPane.showMessageDialog(null, "Please Select Expense! ", "Notification", JOptionPane.PLAIN_MESSAGE);
    			}
    			
    	}
           
    	
    });
   
   
     // brings user to edit screen with selected expense
     btnEdit.addActionListener(new ActionListener() 
     {
    	public void actionPerformed(ActionEvent e) 
    	{
	    		
	    		int numRows = table.getSelectedRow();
	    		if(numRows>=0)
	    		{
	    			if(numRows == -1) //avoid double triggering when model is set
		    			return;
		    		
	    			DetailedExpense r= expenses[numRows]; 
	    			
	    			main.showEditExpensePanel(numRows, r); // returns selected row expense
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "Please Select Expense! ", "Notification", JOptionPane.PLAIN_MESSAGE);
	    		}
	    		
	 
	    	}
	    });
	    
	    
     this.populateExpenseList();
		
		
		}
		
		public void addExpense(String i, double a, String d, String c) 
		{
		    model.insertRow(model.getRowCount(), new Object[] {i, a, d, c});//display added expense in the JTable
			
		}
		
		private void populateExpenseList()
		{
		User u = main.getController().getUser(main.getController().getUserInUse("name"));
		
		this.expenses = u.getAllExpense();
		
		for(int i=0; i < expenses.length; i++)
		
		{
		
			DetailedExpense op = expenses[i];
		
			model.insertRow(table.getRowCount(), new Object[] {op.getItemDescription(), op.getItemAmount(), op.getItemDate(), op.getItemCategory()});
		}
		
		this.table.setModel(model);
		
		}
}
