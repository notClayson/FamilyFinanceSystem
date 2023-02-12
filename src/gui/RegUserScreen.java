package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.MainFrame;
import data.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;
import javax.swing.JCheckBox;

//Design- Haziq
//Features- Haziq & Caisoon

public class RegUserScreen extends JPanel {
	
	private MainFrame main;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JComboBox selection;
	private String[] nameArr = {"Member"};


	public RegUserScreen(MainFrame main) {
		
		this.main=main;
		this.setSize(751, 550);
		setLayout(null);
		
		KGradientPanel gradientPanel_1 = new KGradientPanel();
		gradientPanel_1.setBounds(0, 0, 751, 550);
		add(gradientPanel_1);
		gradientPanel_1.setLayout(null);
		
		JLabel lblUserRegistration = new JLabel("Family Expense Tracker");
		lblUserRegistration.setBounds(240, 40, 292, 41);
		gradientPanel_1.add(lblUserRegistration);
		lblUserRegistration.setForeground(Color.WHITE);
		lblUserRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserRegistration.setFont(new Font("MV Boli", Font.BOLD, 25));
		

		
		JButton btnHeadLogin = new JButton("Head Login");
		btnHeadLogin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnHeadLogin.setForeground(Color.WHITE);
		btnHeadLogin.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnHeadLogin.setContentAreaFilled(false);
		btnHeadLogin.setBounds(608, 469, 91, 23);
		gradientPanel_1.add(btnHeadLogin);
		

		
		JPasswordField txtPassword_1 = new JPasswordField();
		txtPassword_1.setBounds(240, 210, 263, 41);
		gradientPanel_1.add(txtPassword_1);
		txtPassword_1.setEchoChar('*');
		txtPassword_1.setForeground(new Color(255, 255, 255));
		txtPassword_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtPassword_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtPassword_1.setOpaque(false);
		txtPassword_1.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(240, 137, 263, 46);
		gradientPanel_1.add(txtUsername);
		txtUsername.setForeground(new Color(255, 255, 255));
		txtUsername.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtUsername.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		txtUsername.setBackground(new Color(255, 255, 255));
		txtUsername.setOpaque(false);
		txtUsername.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBounds(250, 272, 114, 15);
		gradientPanel_1.add(chckbxNewCheckBox);
		
		// show/hide password
		chckbxNewCheckBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(chckbxNewCheckBox.isSelected())
				{
					txtPassword_1.setEchoChar((char)0);
				}
				else{
					txtPassword_1.setEchoChar('*');
				}
			}
		});
		
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.WHITE));
		
		KButton btnSignUp = new KButton();
		btnSignUp.setBounds(150, 309, 185, 45);
		gradientPanel_1.add(btnSignUp);
		btnSignUp.kHoverStartColor = new Color(204, 255, 153);
		btnSignUp.setkHoverForeGround(new Color(153, 204, 153));
		btnSignUp.kEndColor = new Color(0, 153, 51);
		btnSignUp.setkStartColor(new Color(51, 204, 102));
		btnSignUp.setkEndColor(new Color(51, 102, 51));
		btnSignUp.setText("Sign-up");
		btnSignUp.kBorderRadius = 40;
		btnSignUp.setkBorderRadius(40);
		btnSignUp.setOpaque(false);
		btnSignUp.setContentAreaFilled(false);
		btnSignUp.setBorderPainted(false);
		
		JLabel lblOr = new JLabel("OR");
		lblOr.setBounds(379, 325, 15, 15);
		gradientPanel_1.add(lblOr);
		lblOr.setForeground(Color.WHITE);
		lblOr.setFont(new Font("Segoe UI", Font.BOLD, 11));
		
		// brings user to login family member screen
		KButton btnSignin = new KButton();
		btnSignin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				
				main.showLoginMem();
			}
		});
		
		btnSignin.setText("Already Registered?");
		btnSignin.setOpaque(false);
		btnSignin.kStartColor = new Color(51, 204, 102);
		btnSignin.setkStartColor(new Color(51, 204, 102));
		btnSignin.kHoverStartColor = new Color(204, 255, 153);
		btnSignin.setkHoverStartColor(new Color(204, 255, 153));
		btnSignin.kHoverForeGround = new Color(153, 204, 153);
		btnSignin.setkHoverForeGround(new Color(153, 204, 153));
		btnSignin.kEndColor = new Color(0, 153, 51);
		btnSignin.setkEndColor(new Color(0, 153, 51));
		btnSignin.kBorderRadius = 40;
		btnSignin.setkBorderRadius(40);
		btnSignin.setContentAreaFilled(false);
		btnSignin.setBorderPainted(false);
		btnSignin.setBounds(444, 309, 185, 45);
		gradientPanel_1.add(btnSignin);
		
		JLabel lblFintackAgnecy = new JLabel("FinTrack Agency");
		lblFintackAgnecy.setForeground(Color.LIGHT_GRAY);
		lblFintackAgnecy.setFont(new Font("Palatino Linotype", Font.BOLD, 11));
		lblFintackAgnecy.setBounds(478, 77, 105, 14);
		gradientPanel_1.add(lblFintackAgnecy);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(240, 130, 68, 14);
		gradientPanel_1.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("password");
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(240, 204, 68, 14);
		gradientPanel_1.add(lblNewLabel);
		
		//Sign-up action listener
		btnSignUp.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent arg0) 
		    {
		        String n = txtUsername.getText();
		        String p = txtPassword_1.getText();
		        boolean x = main.getController().findUser(n);//check if username already exist in array
		            if(x==true)
		            {
		                JOptionPane.showMessageDialog(null, " User Already Exist ", "Notification", JOptionPane.ERROR_MESSAGE);
		            }
		            else if(txtUsername.getText().equals("")||txtPassword_1.getText().equals(""))//check if form is empty
		            {
		            	JOptionPane.showMessageDialog(null, " Please Fill Form ", "Notification", JOptionPane.ERROR_MESSAGE);
		            }
		            else{
		            	main.getController().regUser(0.0, n, p); //creates user with with 0.0 for allowance 
		            	JOptionPane.showMessageDialog(null, " Account Created Successfully ", "Notification", JOptionPane.PLAIN_MESSAGE);
		                main.showLoginMem();
		            }

		        }
		});
		
		// brings user to family head login screen
		btnHeadLogin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				main.showLoginHead();
			}
		});
	}
}
