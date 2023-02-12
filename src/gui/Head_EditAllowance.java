package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Allowance;
import data.Category;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Caisoon

public class Head_EditAllowance extends JPanel{
	private MainFrame main;
	private int index2;
	private Allowance allo;
	
	public Head_EditAllowance(MainFrame main,int ind2, Allowance allo){
		this.main=main;
		this.index2=ind2;
		this.allo=allo;
		this.main = main;
		this.setSize(751, 550);
		setLayout(null);
			
			KGradientPanel gradientPanel = new KGradientPanel();
			gradientPanel.setLayout(null);
			gradientPanel.kStartColor = Color.GREEN;
			gradientPanel.setkStartColor(Color.GREEN);
			gradientPanel.setBounds(0, 0, 751, 550);
			add(gradientPanel);
			
			// returns user to Family head screen
			JButton button = new JButton("Back");
			button.addActionListener(new ActionListener() 
			
			{
				
				public void actionPerformed(ActionEvent e) 
				
				{
					showHome();
				
				}
			
			});
			
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			button.setContentAreaFilled(false);
			button.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
			button.setBounds(29, 469, 114, 23);
			gradientPanel.add(button);
			
			//update allowance given
			KButton btnUpdate = new KButton();
			btnUpdate.addActionListener(new ActionListener() 
			{
				
				public void actionPerformed(ActionEvent e)
				
				{
					String name= textField.getText();
					
					double amount=Double.valueOf(textField_2.getText());
					
					main.getController().setuserAllowance(amount, name);// gets method from controller to set user allowance by their username
					
					System.out.println("Saved Changes");
					
					JOptionPane.showMessageDialog(null, "Successfully Edited ! ", "Notification", JOptionPane.PLAIN_MESSAGE);
					
					main.getController().editAllo(index2, allo); // displays edited allowance on JList
				}
			});
			
			btnUpdate.setText("Update");
			btnUpdate.setOpaque(false);
			btnUpdate.kStartColor = Color.PINK;
			btnUpdate.setkStartColor(Color.PINK);
			btnUpdate.kHoverStartColor = new Color(204, 255, 153);
			btnUpdate.setkHoverStartColor(new Color(204, 255, 153));
			btnUpdate.kHoverForeGround = new Color(153, 204, 153);
			btnUpdate.setkHoverForeGround(new Color(153, 204, 153));
			btnUpdate.kEndColor = new Color(0, 153, 51);
			btnUpdate.setkEndColor(Color.MAGENTA);
			btnUpdate.kBorderRadius = 40;
			btnUpdate.setkBorderRadius(40);
			btnUpdate.setContentAreaFilled(false);
			btnUpdate.setBorderPainted(false);
			btnUpdate.setBounds(302, 332, 185, 45);
			gradientPanel.add(btnUpdate);
			
			textField = new JTextField();
			textField.setBounds(294, 181, 193, 26);
			gradientPanel.add(textField);
			textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
			textField.setForeground(Color.WHITE);
			textField.setOpaque(false);
			textField.setColumns(10);
			textField.setText(""+allo.getName());
			textField.setEditable(false);
			
			textField_2 = new JTextField();
			textField_2.setForeground(Color.WHITE);
			textField_2.setOpaque(false);
			textField_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
			textField_2.setBounds(294, 253, 193, 26);
			gradientPanel.add(textField_2);
			textField_2.setColumns(10);
			textField_2.setText(""+allo.getAmount());
			
			JLabel lblNewLabel = new JLabel("Name :");
			lblNewLabel.setBounds(254, 150, 163, 20);
			gradientPanel.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			
				
			JLabel lblNewAllowance = new JLabel("New Allowance :");
			lblNewAllowance.setBounds(254, 216, 136, 26);
			gradientPanel.add(lblNewAllowance);
			lblNewAllowance.setForeground(Color.WHITE);
			lblNewAllowance.setFont(new Font("Segoe UI", Font.PLAIN, 16));
				
		JLabel lblModifyCalculation = new JLabel("Edit Allowance");
		lblModifyCalculation.setBounds(290, 58, 266, 35);
		gradientPanel.add(lblModifyCalculation);
		lblModifyCalculation.setForeground(Color.WHITE);
	}



		
		protected void showHome() 
		{
		
			this.main.showAllowance();
		}
		

		private JTextField textField;
		private JTextField textField_2;


		public int getIndex() 
		{
		 	 
			return index2; 
		}

		public void setIndex(int index2) 
		{ 
			 
			this.index2 = index2; 
		}

		public Allowance getAllo() 
		{
		 	 
			return allo; 
		}

		public void setAllo(Allowance allo) 
		{ 
			
			this.allo=allo; 
		}
}
