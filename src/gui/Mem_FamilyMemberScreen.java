package gui;

import javax.swing.JFrame;
import javax.swing.JRadioButton;

import controller.MainFrame;
import gui.Mem_DisplayExpensePanel;
import data.Allowance;
import data.DetailedExpense;
import data.User;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import com.k33ptoo.components.KButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

//Design- Haziq
//Features- Haziq

public class Mem_FamilyMemberScreen extends JPanel{
	private MainFrame main;
	private double expense;

	public Mem_FamilyMemberScreen(MainFrame main) {
		setLayout(null);
		this.setSize(751, 550);
		this.main = main;
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = new Color(102, 255, 255);
		gradientPanel.setkStartColor(new Color(102, 255, 255));
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		JButton btnSignOut = new JButton("Logout");
		btnSignOut.setForeground(Color.WHITE);
		btnSignOut.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnSignOut.setContentAreaFilled(false);
		btnSignOut.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnSignOut.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnSignOut);
		
		
		JLabel lblWelcomeMember = new JLabel("Welcome,"+main.getController().getUserInUse("name"));
		lblWelcomeMember.setForeground(new Color(255, 255, 255));
		lblWelcomeMember.setBounds(258, 51, 279, 58);
		gradientPanel.add(lblWelcomeMember);
		lblWelcomeMember.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		JRadioButton rdbtnDetailedExpense = new JRadioButton("Detailed Expense");
		rdbtnDetailedExpense.setForeground(new Color(255, 255, 255));
		rdbtnDetailedExpense.setBounds(414, 261, 199, 29);
		rdbtnDetailedExpense.setOpaque(false);
		gradientPanel.add(rdbtnDetailedExpense);
		rdbtnDetailedExpense.setFont(new Font("Segoe UI", Font.BOLD, 20));
		
		JRadioButton rdbtnPersonalExpense = new JRadioButton("Personal Info\r\n");
		rdbtnPersonalExpense.setBounds(153, 261, 155, 29);
		gradientPanel.add(rdbtnPersonalExpense);
		rdbtnPersonalExpense.setForeground(new Color(255, 255, 255));
		rdbtnPersonalExpense.setFont(new Font("Segoe UI", Font.BOLD, 20));
		rdbtnPersonalExpense.setOpaque(false);
		
		JLabel GIF = new JLabel("New label");
		GIF.setBounds(560, 369, 181, 181);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/memberWave.gif")));
		
		double a = main.getController().getuserAllowance(main.getController().getUserInUse("name"));
		JLabel lblAllowanceLeft = new JLabel("Allowance Given : "+Double.toString(a));
		lblAllowanceLeft.setForeground(Color.WHITE);
		lblAllowanceLeft.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblAllowanceLeft.setBounds(276, 158, 261, 23);
		gradientPanel.add(lblAllowanceLeft);
		
		// calculates total expense of user
		DetailedExpense[] cash = main.getController().getUser(main.getController().getUserInUse("name")).getAllExpense(); // gets all of current user expense
		for(int i=0;i<cash.length;i++)
		{
			this.expense += cash[i].getItemAmount(); // sums expense
		}
		
		
		JLabel lblBalance = new JLabel("Balance: "+(main.getController().getUser(main.getController().getUserInUse("name")).getUserAllowance()-this.expense)); // substracts user allocated allowance and total expense
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblBalance.setBounds(276, 192, 187, 23);
		gradientPanel.add(lblBalance);
		
		
		// brings user to profile screen
		rdbtnPersonalExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showMemInfo();
			}
		});
		
		// brings user to add expense screen
		rdbtnDetailedExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showAddEx();
			}
		});
		
		// logs user out
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showLoginMem();
			}
		});
		
		


	}
}


