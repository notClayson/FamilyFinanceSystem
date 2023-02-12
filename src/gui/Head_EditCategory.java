/**
 * 
 */
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
import data.Category;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Caisoon

public class Head_EditCategory extends JPanel{
	private MainFrame main;
	
		private int index1;
		private Category cat;
		public Head_EditCategory(MainFrame main, int ind, Category cat) {
			this.index1=ind;
			this.cat=cat;
			this.main = main;
			this.setSize(751, 550);
			setLayout(null);
			
			JLabel lblModifyCalculation = new JLabel("Modify Category");
			lblModifyCalculation.setForeground(Color.WHITE);
			lblModifyCalculation.setFont(new Font("MV Boli", Font.BOLD, 25));
			lblModifyCalculation.setBounds(280, 55, 289, 35);
			add(lblModifyCalculation);
			
			JLabel lblNewLabel = new JLabel("New Category:");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
			lblNewLabel.setBounds(233, 147, 163, 29);
			add(lblNewLabel);
			
			KGradientPanel gradientPanel = new KGradientPanel();
			gradientPanel.setLayout(null);
			gradientPanel.kStartColor = Color.GREEN;
			gradientPanel.setkStartColor(Color.GREEN);
			gradientPanel.setBounds(0, 0, 751, 550);
			add(gradientPanel);
			
			// returns user display categories screen
			JButton button = new JButton("Back");
			button.addActionListener(new ActionListener() 
			{
				
				public void actionPerformed(ActionEvent e) 
				
				{
					
					showCat();
				
				}
			});
			
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			button.setContentAreaFilled(false);
			button.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
			button.setBounds(29, 469, 114, 23);
			gradientPanel.add(button);
			
			KButton btnUpdate = new KButton();
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
			btnUpdate.setBounds(302, 266, 185, 45);
			gradientPanel.add(btnUpdate);
			
			textField = new JTextField();
			textField.setBounds(294, 187, 193, 26);
			gradientPanel.add(textField);
			textField.setBorder(new MatteBorder(0, 0, 3, 0, (Color) Color.WHITE));
			textField.setOpaque(false);
			textField.setForeground(Color.WHITE);
			textField.setColumns(10);
			textField.setText(""+cat.getCategoryName());
			
			
			// updates category
			btnUpdate.addActionListener(new ActionListener() 
			{
				
				public void actionPerformed(ActionEvent e) 
				
				{
					
					String newCat = textField.getText();
					
					Category cat = new Category(newCat);
					
					main.getController().editCat(index1, cat); // gets method from controller to edit category
					
					System.out.println("Saved Changes");
					
					JOptionPane.showMessageDialog(null, "Successfully Saved! ", "Notification", JOptionPane.PLAIN_MESSAGE);
					
					
				
				}
			});
		}

		
		protected void showCat() {
		this.main.showCategories();
		}
		

		private JTextField textField;


		public int getIndex() {
		 	 return index1; 
		}

		public void setIndex(int index1) { 
			 this.index1 = index1; 
		}

		public Category getCat() {
		 	 return cat; 
		}

		public void setCat(Category cat) { 
			 this.cat = cat; 
		}
}