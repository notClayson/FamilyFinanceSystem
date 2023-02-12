package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.MainFrame;
import data.Category;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import com.k33ptoo.components.KGradientPanel;
import com.k33ptoo.components.KButton;

//Design- Haziq
//Features- Caisoon

public class Head_ShowCategories extends JPanel{
	private MainFrame main;
	private int index1;
	private JLabel lblShowResult;
	private JList categoryList;
	private Category[] categories;
	
	public Head_ShowCategories(MainFrame main){
		this.main=main;
		this.setSize(751, 550);
		setLayout(null);
		
		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.GREEN;
		gradientPanel.setkStartColor(Color.GREEN);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);
		
		
		// returns user to add categories screen
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			
			{
				
				main.AddCategories();
			
			}
		});
		
		
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnBack.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnBack);
		
		
		// brings use to edit category screen for selected category
		KButton btnEdit = new KButton();
		btnEdit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					
				int index1=categoryList.getSelectedIndex(); // gets selected category from JList
					
				if (index1 == -1)
							return;
					
				Category cat = categories[index1];
					
				main.showEditCategory(index1, cat);	// gets method from controller to update category
				}
			});


		btnEdit.setText("Edit");
		btnEdit.setOpaque(false);
		btnEdit.kStartColor = Color.PINK;
		btnEdit.setkStartColor(Color.PINK);
		btnEdit.kHoverStartColor = new Color(204, 255, 153);
		btnEdit.setkHoverStartColor(new Color(204, 255, 153));
		btnEdit.kHoverForeGround = new Color(153, 204, 153);
		btnEdit.setkHoverForeGround(new Color(153, 204, 153));
		btnEdit.kEndColor = new Color(0, 153, 51);
		btnEdit.setkEndColor(Color.MAGENTA);
		btnEdit.kBorderRadius = 40;
		btnEdit.setkBorderRadius(40);
		btnEdit.setContentAreaFilled(false);
		btnEdit.setBorderPainted(false);
		btnEdit.setBounds(403, 295, 185, 45);
		gradientPanel.add(btnEdit);
		
		KButton btnDelete = new KButton();
		btnDelete.setText("Delete");
		btnDelete.setOpaque(false);
		btnDelete.kStartColor = Color.PINK;
		btnDelete.setkStartColor(Color.PINK);
		btnDelete.kHoverStartColor = new Color(204, 255, 153);
		btnDelete.setkHoverStartColor(new Color(204, 255, 153));
		btnDelete.kHoverForeGround = new Color(153, 204, 153);
		btnDelete.setkHoverForeGround(new Color(153, 204, 153));
		btnDelete.kEndColor = new Color(0, 153, 51);
		btnDelete.setkEndColor(Color.MAGENTA);
		btnDelete.kBorderRadius = 40;
		btnDelete.setkBorderRadius(40);
		btnDelete.setContentAreaFilled(false);
		btnDelete.setBorderPainted(false);
		btnDelete.setBounds(182, 295, 185, 45);
		gradientPanel.add(btnDelete);
		
		
		this.lblShowResult = new JLabel("(Category shown here)");
		lblShowResult.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblShowResult.setForeground(Color.WHITE);
		lblShowResult.setBounds(360, 229, 228, 28);
		gradientPanel.add(lblShowResult);
		
		JLabel lblSelectedCategory = new JLabel("Selected Category :");
		lblSelectedCategory.setForeground(Color.WHITE);
		lblSelectedCategory.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblSelectedCategory.setBounds(207, 228, 140, 31);
		gradientPanel.add(lblSelectedCategory);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 129, 347, 89);
		gradientPanel.add(scrollPane);
		
		this.categoryList=new JList();
		scrollPane.setViewportView(categoryList);
		categoryList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			
			{
				
				if(e.getValueIsAdjusting())
				
				{
				
					int index1 =categoryList.getSelectedIndex();
					
					if(index1 == -1)
						return;
						
					Category cat= categories[index1];
						
					lblShowResult.setText(""+cat.getCategoryName());
				}
			}
		});
		
		JLabel lblViewAllCategories = new JLabel("View All Categories");
		lblViewAllCategories.setBounds(251, 63, 317, 41);
		gradientPanel.add(lblViewAllCategories);
		lblViewAllCategories.setForeground(Color.WHITE);
		lblViewAllCategories.setFont(new Font("MV Boli", Font.BOLD, 25));
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				index1= categoryList.getSelectedIndex();
				if(index1 == -1)
					return;
				Category cat = categories[index1];
				main.getController().deleteCat(index1);
				System.out.println("Deleted"+ " '"+cat.getCategoryName()+ "' "+ "Category");
				JOptionPane.showMessageDialog(null, "Successfully Deleted "+" '"+cat.getCategoryName()+"' !", "Notification", JOptionPane.PLAIN_MESSAGE);
				populateCategoryList();
			}
		});


				

	this.populateCategoryList();
	}
	
	
	private void populateCategoryList()
	{
		 this.categories = this.main.getController().getAllCat();
		 
		 DefaultListModel model = new DefaultListModel();
		  
		 for(int i=0; i<categories.length; i++)
		  {
			
			  Category op = categories[i];
			
			  model.addElement(op.getCategoryName());
			
		  }
			
		  this.categoryList.setModel(model);
		}

	
	public void showMenu() { 
		this.main.showFamilyHead();
	 } 
}
