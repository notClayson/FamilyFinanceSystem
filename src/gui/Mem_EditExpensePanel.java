package gui;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import controller.MainFrame;
import data.Category;
import data.DetailedExpense;
import data.User;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import com.k33ptoo.components.KButton;
import javax.swing.border.MatteBorder;
import javax.swing.ComboBoxModel;

//Design- Haziq
//Features- Haziq

public class Mem_EditExpensePanel extends JPanel{
	private MainFrame main;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DetailedExpense dEx;
	private Category[] cat;
	private JComboBox categoryBox;
	private int index;
	
	public Mem_EditExpensePanel(MainFrame main, int ind, DetailedExpense dEx) {
		this.main = main;
		this.setSize(751, 550);
		setLayout(null);
		this.index=ind;
		this.dEx = dEx;
		Double d = dEx.getItemAmount();
		String s = String.valueOf(d);//convert to string
		
		// returns category created by family head
		cat = main.getController().getAllCat();
		 DefaultComboBoxModel model = new DefaultComboBoxModel();
		  for(int i=0; i<cat.length; i++)
		  {
			Category op = cat[i];
			
			model.addElement(op.getCategoryName().toString()); // fills combo box 
			
		  }
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = new Color(102, 255, 255);
		gradientPanel.setkStartColor(new Color(102, 255, 255));
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
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
		btnUpdate.setBounds(307, 384, 135, 29);
		gradientPanel.add(btnUpdate);
		
		// returns user to display expense screen
		JButton button_1 = new JButton("Back ");
		button_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				main.showDisplayExpensePanel();
			}
		});
		
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		button_1.setContentAreaFilled(false);
		button_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		button_1.setBounds(29, 469, 114, 23);
		gradientPanel.add(button_1);
		
		JLabel label_1 = new JLabel("Item:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_1.setBounds(213, 128, 69, 20);
		gradientPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Amount:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_2.setBounds(213, 184, 69, 20);
		gradientPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Date:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_3.setBounds(213, 242, 46, 14);
		gradientPanel.add(label_3);
		
		JLabel label_4 = new JLabel("Category:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		label_4.setBounds(213, 313, 118, 23);
		gradientPanel.add(label_4);
		
		JLabel GIF = new JLabel("New label");
		GIF.setBounds(533, 11, 175, 179);
		gradientPanel.add(GIF);
		GIF.setText("");
		GIF.setIcon(new ImageIcon(this.getClass().getResource("/edit.png")));
		
		this.categoryBox = new JComboBox(model);
		categoryBox.setBounds(241, 344, 262, 26);
		gradientPanel.add(categoryBox);
		categoryBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		categoryBox.setSelectedItem(dEx.getItemCategory());
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.WHITE);
		textField_1.setBounds(243, 215, 260, 26);
		gradientPanel.add(textField_1);
		textField_1.setOpaque(false);
		textField_1.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField_1.setColumns(10);
		textField_1.setText(s);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.WHITE);
		textField_2.setOpaque(false);
		textField_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField_2.setBounds(241, 279, 262, 26);
		gradientPanel.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(dEx.getItemDate());
		
		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBounds(243, 147, 260, 26);
		gradientPanel.add(textField);
		textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
		textField.setOpaque(false);
		textField.setColumns(10);
		textField.setText(dEx.getItemDescription());
		
		JLabel lblEditScreen = new JLabel("Edit Panel");
		lblEditScreen.setBounds(285, 40, 176, 54);
		gradientPanel.add(lblEditScreen);
		lblEditScreen.setForeground(Color.WHITE);
		lblEditScreen.setFont(new Font("MV Boli", Font.BOLD, 25));
		
		// updates expense
		btnUpdate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals("")||categoryBox.getSelectedItem().equals(null)) // checks if form is filled
				{
					JOptionPane.showMessageDialog(null, "Please Fill In Expense! ", "Notification", JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					String i = textField.getText();
					
					double a = Double.parseDouble(textField_1.getText()); // converts string to double
					
					String d = textField_2.getText();
					
					String c= categoryBox.getSelectedItem().toString();

					DetailedExpense newDEX = new DetailedExpense(i,a,d,c); // sets format
					
					User u = main.getController().getUser(main.getController().getUserInUse("name")); // gets current user
					
					u.editExpense(index, newDEX); // replaces expense at index
					
					JOptionPane.showMessageDialog(null, " Expense Updated! ", "Notification", JOptionPane.PLAIN_MESSAGE);
					main.showDisplayExpensePanel();
				}

			}
		
	});
		
		
	}
}

