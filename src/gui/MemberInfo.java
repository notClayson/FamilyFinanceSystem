package gui;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import controller.MainFrame;
import data.User;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Haziq

public class MemberInfo extends JPanel {
	private MainFrame main;
	private JTextField textField;
	private int index;
	private User rec;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	public MemberInfo(MainFrame main) {
		this.main = main;
		this.setSize(751, 550);
		setLayout(null);
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = new Color(102, 255, 255);
		gradientPanel.setkStartColor(new Color(102, 255, 255));
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		
		// returns user to family member screen
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) {
				main.showMember();
			}
		});
		
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnBack.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnBack);
		
		
		JLabel lblWelcomeMember = new JLabel("Edit Profile");
		lblWelcomeMember.setForeground(Color.WHITE);
		lblWelcomeMember.setBounds(290, 39, 164, 50);
		gradientPanel.add(lblWelcomeMember);
		lblWelcomeMember.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		JLabel lblPassword = new JLabel("Set New Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(191, 204, 152, 14);
		gradientPanel.add(lblPassword);
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		JLabel lblName = new JLabel("Set New Username:");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(191, 127, 152, 14);
		gradientPanel.add(lblName);
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 16));
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.WHITE);
		textField_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField_1.setColumns(10);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(242, 135, 263, 46);
		gradientPanel.add(textField_1);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField.setEchoChar('*');
		passwordField.setColumns(10);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordField.setBounds(242, 208, 263, 41);
		gradientPanel.add(passwordField);
		
		// show/hide password
		JCheckBox checkBox = new JCheckBox("Show Password");
		checkBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(checkBox.isSelected())
				{
					passwordField.setEchoChar((char)0);
				}
				else{
					passwordField.setEchoChar('*');
				}
			}
		});
		
		checkBox.setOpaque(false);
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		checkBox.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.WHITE));
		checkBox.setBounds(252, 262, 114, 15);
		gradientPanel.add(checkBox);
		
		KButton btnUpdate = new KButton();
		btnUpdate.setText("Update");
		btnUpdate.setOpaque(false);
		btnUpdate.kStartColor = new Color(51, 204, 102);
		btnUpdate.setkStartColor(new Color(51, 204, 102));
		btnUpdate.kHoverStartColor = new Color(204, 255, 153);
		btnUpdate.setkHoverStartColor(new Color(204, 255, 153));
		btnUpdate.kHoverForeGround = new Color(153, 204, 153);
		btnUpdate.setkHoverForeGround(new Color(153, 204, 153));
		btnUpdate.kEndColor = new Color(0, 153, 51);
		btnUpdate.setkEndColor(new Color(0, 153, 51));
		btnUpdate.kBorderRadius = 40;
		btnUpdate.setkBorderRadius(40);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		btnUpdate.setBounds(269, 306, 185, 45);
		gradientPanel.add(btnUpdate);
		
		JLabel GIF = new JLabel("New label");
		GIF.setBounds(533, 11, 175, 179);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/mem.png")));
		
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					String n = textField_1.getText();
					
					String p = passwordField.getText();
					
					if(textField_1.getText().equals("")||passwordField.getText().equals("")) // checks if form is filled
					{
		            	JOptionPane.showMessageDialog(null, " Please Fill Form ", "Notification", JOptionPane.ERROR_MESSAGE);
		            }
					else{
						 User u = main.getController().getUser(main.getController().getUserInUse("name")); // gets current user
						
						 main.getController().setUserInUse(n, p); // return method to set current user new username and password
						
						 u.setName(n); // sets new username
						 
						 u.setPwd(p); // sets new password						
						 JOptionPane.showMessageDialog(null, "Personal Info Updated! ", "Notification", JOptionPane.PLAIN_MESSAGE);
						
						 main.showMember();	
					}
				 
				

		}
			
		});
		
	
		
	}
}
