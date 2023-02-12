/**
 * 
 */
package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;

//Caisoon- Features
//Haziq- Design

public class Head_AddCategories extends JPanel {
	private MainFrame main;
	private JTextField textField;
	private String result;
	private JLabel lblResult;
	
	public Head_AddCategories(MainFrame main){
		this.main=main;
		this.setSize(751, 550);
		setLayout(null);
			
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.GREEN;
		gradientPanel.setkStartColor(Color.GREEN);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		// returns user to family head screen
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			
			{
				main.showFamilyHead();
			
			}
		});
		
			
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnBack.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnBack);
		
		KButton btnAdd = new KButton();
		btnAdd.setText("Add");
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
		btnAdd.setBounds(302, 266, 185, 45);
		gradientPanel.add(btnAdd);
		

			
		JLabel lblCategories = new JLabel("Add Categories");
		lblCategories.setForeground(Color.WHITE);
		lblCategories.setBounds(280, 55, 291, 29);
		gradientPanel.add(lblCategories);
		lblCategories.setFont(new Font("MV Boli", Font.BOLD, 25));
		

		
		textField = new JTextField();
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setBounds(294, 187, 193, 26);
		gradientPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Category Name:");
		lblName.setBounds(233, 147, 125, 29);
		gradientPanel.add(lblName);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		
		// brings user to display categories screen
		JButton btnAllCategories = new JButton("View Categories");
		btnAllCategories.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			
			{
				
				main.showCategories();
			
			}
		
		});
		
		btnAllCategories.setForeground(Color.WHITE);
		btnAllCategories.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnAllCategories.setContentAreaFilled(false);
		btnAllCategories.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnAllCategories.setBounds(601, 469, 114, 23);
		gradientPanel.add(btnAllCategories);
		btnAdd.addActionListener(new ActionListener()
		
		// add written category to JCombobox
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if( textField.getText().equals(""))// if field is empty, an error message would appear
				
				{
					JOptionPane.showMessageDialog(null, "Enter Category First !", "Notification", JOptionPane.ERROR_MESSAGE);
				}
				
				else
				
				{
				System.out.println("Successfully Added");
				
				String cat = textField.getText();
				
				result = main.getController().add(cat); // add category to category JCombobox
				
				JOptionPane.showMessageDialog(null, "Successfully Added '"+cat+"' Category !", "Notification", JOptionPane.PLAIN_MESSAGE);
						
				}
			}
			
		});
		
	}

}



