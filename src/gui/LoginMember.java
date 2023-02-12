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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import com.k33ptoo.components.KButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JRadioButton;

//Design- Haziq
//Features- Haziq

public class LoginMember extends JPanel{
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblLoginStatusHere;
	private MainFrame main;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JButton btnLoginMem_1;

	public LoginMember(MainFrame main) {
		setLayout(null);
		this.main = main;
		this.setSize(751, 550);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setkStartColor(new Color(102, 255, 255));
		gradientPanel.setLayout(null);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
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
				if(checkBox.isSelected()){
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
		checkBox.setBounds(250, 272, 114, 15);
		gradientPanel.add(checkBox);
		
		KButton btnLoginMem = new KButton();
		btnLoginMem.setText("Login");
		btnLoginMem.setOpaque(false);
		btnLoginMem.kStartColor = new Color(51, 204, 102);
		btnLoginMem.setkStartColor(new Color(51, 204, 102));
		btnLoginMem.kHoverStartColor = new Color(204, 255, 153);
		btnLoginMem.setkHoverStartColor(new Color(204, 255, 153));
		btnLoginMem.kHoverForeGround = new Color(153, 204, 153);
		btnLoginMem.setkHoverForeGround(new Color(153, 204, 153));
		btnLoginMem.kEndColor = new Color(0, 153, 51);
		btnLoginMem.setkEndColor(new Color(0, 153, 51));
		btnLoginMem.kBorderRadius = 40;
		btnLoginMem.setkBorderRadius(40);
		btnLoginMem.setContentAreaFilled(false);
		btnLoginMem.setBorderPainted(false);
		btnLoginMem.setBounds(285, 338, 185, 45);
		gradientPanel.add(btnLoginMem);
		
		// Login Family Member action listener
		btnLoginMem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String n = textField.getText();
				String pwd = passwordField.getText();
				boolean validity = main.getController().verifyUser(n, pwd); // check if username and password matches
				if (validity == true) 
				{
					lblLoginStatusHere.setText("Successful!");
					
					main.getController().setUserInUse(n,pwd); // updates user in use details
					
					main.showMember();
				}
				else if(textField.getText().equals("")||passwordField.getText().equals(""))// check if form is empty
				{
		            	JOptionPane.showMessageDialog(null, " Please Fill Form ", "Notification", JOptionPane.ERROR_MESSAGE);
		            }
				else
					lblLoginStatusHere.setText("Wrong username or password");// if username or password does not match
			}
		});
		
				JButton btnRegister = new JButton("Back to Register");
				btnRegister.setForeground(Color.WHITE);
				btnRegister.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				btnRegister.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
				btnRegister.setContentAreaFilled(false);
				btnRegister.setBounds(29, 469, 114, 23);
				gradientPanel.add(btnRegister);
				
				// brings user back to register screen
				btnRegister.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						main.showRegScreen();
					}
				});
	


						
				this.lblLoginStatusHere = new JLabel("");
				lblLoginStatusHere.setForeground(Color.WHITE);
				lblLoginStatusHere.setBounds(240, 298, 263, 29);
				gradientPanel.add(lblLoginStatusHere);
				lblLoginStatusHere.setFont(new Font("Segoe UI", Font.PLAIN, 17));
								

												
				JLabel lblLoginScreen = new JLabel("Member Login");
				lblLoginScreen.setForeground(Color.WHITE);
				lblLoginScreen.setBounds(285, 40, 185, 40);
				gradientPanel.add(lblLoginScreen);
				lblLoginScreen.setFont(new Font("MV Boli", Font.BOLD, 25));
				
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
