package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Allowance;
import data.User;

import javax.swing.JComboBox;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Caisoon

public class Head_AllocateAllowance extends JPanel{
	private MainFrame main;
	private JTextField textField_1;
	private JLabel lblResult;
	private JComboBox nameBox;
	private String name;
	public Head_AllocateAllowance(MainFrame main){
		this.main=main;
		this.setSize(751, 550);
		setLayout(null);
			
			// Fill user JCombobox
			User[] storage = main.getController().getUsers(); // gets registered users
			 DefaultComboBoxModel model1 = new DefaultComboBoxModel();
			  
			 for(int i=0; i<storage.length; i++)// loop through user array
			  {
				
				 User opp = storage[i];
				
				 model1.addElement(opp.getName().toString());// get username and adds to JCombobox
				
			  }
				
				KGradientPanel gradientPanel = new KGradientPanel();
				gradientPanel.setLayout(null);
				gradientPanel.kStartColor = Color.GREEN;
				gradientPanel.setkStartColor(Color.GREEN);
				gradientPanel.setBounds(0, 0, 751, 550);
				add(gradientPanel);
				
				JButton btnBackToMenu = new JButton("Back");
				btnBackToMenu.setForeground(Color.WHITE);
				btnBackToMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				btnBackToMenu.setContentAreaFilled(false);
				btnBackToMenu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
				btnBackToMenu.setBounds(29, 469, 114, 23);
				gradientPanel.add(btnBackToMenu);
				
				KButton btnAdd = new KButton();
				btnAdd.setText("Allocate");
				btnAdd.setOpaque(false);
				btnAdd.kStartColor = Color.PINK;
				btnAdd.setkStartColor(Color.PINK);
				btnAdd.kHoverStartColor = new Color(204, 255, 153);
				btnAdd.setkHoverStartColor(new Color(204, 255, 153));
				btnAdd.kHoverForeGround = new Color(153, 204, 153);
				btnAdd.setkHoverForeGround(new Color(153, 204, 153));
				btnAdd.kEndColor = new Color(0, 153, 51);
				btnAdd.setkEndColor(Color.MAGENTA);
				btnAdd.kBorderRadius = 40;
				btnAdd.setkBorderRadius(40);
				btnAdd.setContentAreaFilled(false);
				btnAdd.setBorderPainted(false);
				btnAdd.setBounds(294, 309, 185, 45);
				gradientPanel.add(btnAdd);
				

		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField_1.setOpaque(false);
		textField_1.setBounds(294, 252, 193, 26);
		gradientPanel.add(textField_1);
		textField_1.setColumns(10);
		this.nameBox = new JComboBox(model1);
		nameBox.setBounds(312, 183, 142, 27);
		gradientPanel.add(nameBox);
		nameBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(262, 152, 90, 20);
		gradientPanel.add(lblName);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblAmount.setBounds(262, 221, 90, 20);
		gradientPanel.add(lblAmount);
		
		JButton btnViewAllowance = new JButton("View Allowance");
		btnViewAllowance.setForeground(Color.WHITE);
		btnViewAllowance.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnViewAllowance.setContentAreaFilled(false);
		btnViewAllowance.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnViewAllowance.setBounds(595, 471, 114, 23);
		gradientPanel.add(btnViewAllowance);
		
		JLabel lblCategories = new JLabel("Allocate Allowance");
		lblCategories.setBounds(262, 58, 251, 40);
		gradientPanel.add(lblCategories);
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		JLabel GIF = new JLabel("New label");
		GIF.setBounds(560, 11, 181, 181);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/allocate.gif")));
		
		// allocates allowance to selected user
		btnAdd.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("Successfully Allocated");
				
				String nm = nameBox.getSelectedItem().toString(); // gets username from JComboBox and converts to String
				
				double am= Double.valueOf(textField_1.getText()); // gets allowance written by Head from textField and converts to double
				
				main.getController().setuserAllowance(am, nm); // gets method from controller to set user allowance
				
				Allowance result = main.getController().add(nm,am); // adds user with corresponding allowance to JList to be displayed
				
				
				JOptionPane.showMessageDialog(null,nm+" was allocated $"+am+".", "Notification", JOptionPane.PLAIN_MESSAGE);
						
				}
			});
				
		btnBackToMenu.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) 
					{
						showMenu();
					}
				});
				
		btnViewAllowance.addActionListener(new ActionListener() 
		{
					public void actionPerformed(ActionEvent e) 
					{
						main.showAllowance();
					}
				});
		}

		public void showMenu() { 
			this.main.showFamilyHead();
		 } 
	}

