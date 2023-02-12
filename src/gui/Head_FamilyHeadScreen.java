package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import controller.MainFrame;

//Design- Haziq
//Features- Caisoon

public class Head_FamilyHeadScreen extends JPanel{ 
	private MainFrame main;
	
	public Head_FamilyHeadScreen(MainFrame main) {
		this.main=main;
		this.setSize(751, 550);
		
		
		setLayout(null);
		
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.GREEN;
		gradientPanel.setkStartColor(Color.GREEN);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		JButton button_1 = new JButton("Logout");
		button_1.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			
			{
				
				main.showLoginHead();
			
			}
		});
		
		
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		button_1.setBounds(29, 469, 114, 23);
		gradientPanel.add(button_1);
		
		JLabel lblWelcomeFamilyHead = new JLabel("Welcome Family Head !");
		lblWelcomeFamilyHead.setBounds(226, 44, 315, 45);
		gradientPanel.add(lblWelcomeFamilyHead);
		lblWelcomeFamilyHead.setForeground(Color.WHITE);
		lblWelcomeFamilyHead.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		
		// brings user to allocate allowance screen
		KButton btnAllowance = new KButton();
		btnAllowance.addActionListener(new ActionListener()
		{
			
			public void actionPerformed(ActionEvent e) 
			
			{
				
				main.showAllocateAllowance();
			
			}
		});
		
		
		btnAllowance.setText("Allocate Allowance");
		btnAllowance.setOpaque(false);
		btnAllowance.kStartColor = Color.PINK;
		btnAllowance.setkStartColor(Color.PINK);
		btnAllowance.kHoverStartColor = new Color(204, 255, 153);
		btnAllowance.setkHoverStartColor(new Color(204, 255, 153));
		btnAllowance.kHoverForeGround = new Color(153, 204, 153);
		btnAllowance.setkHoverForeGround(new Color(153, 204, 153));
		btnAllowance.kEndColor = new Color(0, 153, 51);
		btnAllowance.setkEndColor(Color.MAGENTA);
		btnAllowance.kBorderRadius = 40;
		btnAllowance.setkBorderRadius(40);
		btnAllowance.setContentAreaFilled(false);
		btnAllowance.setBorderPainted(false);
		btnAllowance.setBounds(286, 230, 185, 45);
		gradientPanel.add(btnAllowance);
		
		
		//  brings user to display summary screen
		KButton btnViewSummary = new KButton();
		btnViewSummary.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e) 
			
			{
				
				main.showSummary();
			
			}
		});
		
		
		btnViewSummary.setText("View Summary");
		btnViewSummary.setOpaque(false);
		btnViewSummary.kStartColor = Color.PINK;
		btnViewSummary.setkStartColor(Color.PINK);
		btnViewSummary.kHoverStartColor = new Color(204, 255, 153);
		btnViewSummary.setkHoverStartColor(new Color(204, 255, 153));
		btnViewSummary.kHoverForeGround = new Color(153, 204, 153);
		btnViewSummary.setkHoverForeGround(new Color(153, 204, 153));
		btnViewSummary.kEndColor = new Color(0, 153, 51);
		btnViewSummary.setkEndColor(Color.MAGENTA);
		btnViewSummary.kBorderRadius = 40;
		btnViewSummary.setkBorderRadius(40);
		btnViewSummary.setContentAreaFilled(false);
		btnViewSummary.setBorderPainted(false);
		btnViewSummary.setBounds(286, 306, 185, 45);
		gradientPanel.add(btnViewSummary);
		
		
		// brings user to add categories screen
		KButton btnCreateCatergories = new KButton();
		btnCreateCatergories.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			
			{
				
				main.AddCategories();
			
			}
		});
		
		
		btnCreateCatergories.setText("Create Catergories");
		btnCreateCatergories.setOpaque(false);
		btnCreateCatergories.kStartColor = new Color(51, 204, 102);
		btnCreateCatergories.setkStartColor(Color.PINK);
		btnCreateCatergories.kHoverStartColor = new Color(204, 255, 153);
		btnCreateCatergories.setkHoverStartColor(new Color(204, 255, 153));
		btnCreateCatergories.kHoverForeGround = new Color(153, 204, 153);
		btnCreateCatergories.setkHoverForeGround(new Color(153, 204, 153));
		btnCreateCatergories.kEndColor = new Color(0, 153, 51);
		btnCreateCatergories.setkEndColor(Color.MAGENTA);
		btnCreateCatergories.kBorderRadius = 40;
		btnCreateCatergories.setkBorderRadius(40);
		btnCreateCatergories.setContentAreaFilled(false);
		btnCreateCatergories.setBorderPainted(false);
		btnCreateCatergories.setBounds(286, 153, 185, 45);
		gradientPanel.add(btnCreateCatergories);
		
		JLabel GIF = new JLabel("New label");
		GIF.setBounds(551, 11, 181, 181);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/boss.gif")));
		
		
	}
}

