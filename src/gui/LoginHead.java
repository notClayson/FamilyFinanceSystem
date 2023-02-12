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
import data.User;
import com.k33ptoo.components.KGradientPanel;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Caisoon

public class LoginHead extends JPanel{
	private JTextField textField;
	private String n1;
	private String pwd1;
	private JLabel lblLoginStatusHere;
	private MainFrame main;
	private JPasswordField passwordField;
	private JTextField textField_2;

	public LoginHead(MainFrame main) {
		setLayout(null);
		this.setSize(751, 550);
		this.main = main;
		JLabel lblLoginScreen = new JLabel("Head Login ");
		lblLoginScreen.setForeground(Color.WHITE);
		lblLoginScreen.setFont(new Font("MV Boli", Font.BOLD, 25));
		lblLoginScreen.setBounds(285, 40, 162, 40);
		add(lblLoginScreen);
	
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkStartColor(Color.GREEN);
		gradientPanel.setLayout(null);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		passwordField = new JPasswordField();
		passwordField.setOpaque(false);
		passwordField.setForeground(Color.WHITE);
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		passwordField.setEchoChar('*');
		passwordField.setColumns(10);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		passwordField.setBounds(240, 210, 263, 41);
		gradientPanel.add(passwordField);
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		textField.setBackground(Color.WHITE);
		textField.setBounds(240, 137, 263, 46);
		gradientPanel.add(textField);
		
		// show/hide password
		JCheckBox checkBox = new JCheckBox("Show Password");
		checkBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(checkBox.isSelected())
				{
					passwordField.setEchoChar((char)0);//view entered value as letters
					
				}
				else
				{
					passwordField.setEchoChar('*');//view entered value as *
				}
			}
		});		
		checkBox.setOpaque(false);
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		checkBox.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.WHITE));
		checkBox.setBounds(250, 272, 114, 15);
		gradientPanel.add(checkBox);
		
		//login
		KButton btnLoginHead = new KButton();
		btnLoginHead.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				n1 = textField.getText();
				pwd1 = passwordField.getText();
				if(n1.equals("Admin") && pwd1.equals("admin") )//if user name and password match show next screen
				{
					lblLoginStatusHere.setText("Successful.");
					main.showFamilyHead();
				 }
	            else if(textField.getText().equals("")||passwordField.getText().equals(""))// if user name and password is blank, show an error
	            {
	            	JOptionPane.showMessageDialog(null, " Please Fill Form ", "Notification", JOptionPane.ERROR_MESSAGE);
	            }
				else // if user name and password doesn't match, show an error
					lblLoginStatusHere.setText("Wrong username or password");
				
			}
		});
		btnLoginHead.setText("Login");
		btnLoginHead.setOpaque(false);
		btnLoginHead.kStartColor = new Color(51, 204, 102);
		btnLoginHead.setkStartColor(new Color(51, 204, 102));
		btnLoginHead.kHoverStartColor = new Color(204, 255, 153);
		btnLoginHead.setkHoverStartColor(new Color(204, 255, 153));
		btnLoginHead.kHoverForeGround = new Color(153, 204, 153);
		btnLoginHead.setkHoverForeGround(new Color(153, 204, 153));
		btnLoginHead.kEndColor = new Color(0, 153, 51);
		btnLoginHead.setkEndColor(new Color(0, 153, 51));
		btnLoginHead.kBorderRadius = 40;
		btnLoginHead.setkBorderRadius(40);
		btnLoginHead.setContentAreaFilled(false);
		btnLoginHead.setBorderPainted(false);
		btnLoginHead.setBounds(285, 338, 185, 45);
		gradientPanel.add(btnLoginHead);
		
		JButton btnRegister1 = new JButton("Back to Register");
		btnRegister1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showRegScreen();
			}
		});
		btnRegister1.setForeground(Color.WHITE);
		btnRegister1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnRegister1.setContentAreaFilled(false);
		btnRegister1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnRegister1.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnRegister1);
		
		this.lblLoginStatusHere = new JLabel("");
		lblLoginStatusHere.setForeground(Color.WHITE);
		lblLoginStatusHere.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		lblLoginStatusHere.setBounds(240, 298, 263, 29);
		gradientPanel.add(lblLoginStatusHere);
		
		JLabel label = new JLabel("username");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		label.setBounds(240, 130, 68, 14);
		gradientPanel.add(label);
		
		JLabel label_1 = new JLabel("password");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		label_1.setBounds(240, 204, 68, 14);
		gradientPanel.add(label_1);
	}
}


