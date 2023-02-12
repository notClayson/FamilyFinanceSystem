/**
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;

import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;

import controller.MainFrame;
import data.Allowance;

//Design- Haziq
//Features- Caisoon

public class Head_ShowAllowance extends JPanel {
	private MainFrame main;
	private int index2;
	private JLabel lblShowResult;
	private JList allowanceList;
	private Allowance[] allowance;

	public Head_ShowAllowance(MainFrame main) {
		this.main = main;
		this.setSize(751, 550);
		setLayout(null);

		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.GREEN;
		gradientPanel.setkStartColor(Color.GREEN);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);

		JButton btnBackToMenu = new JButton("Back");
		btnBackToMenu.setForeground(Color.WHITE);
		btnBackToMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBackToMenu.setContentAreaFilled(false);
		btnBackToMenu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnBackToMenu.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnBackToMenu);

		KButton btnEdit = new KButton();
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
		btnDelete.setBounds(181, 295, 185, 45);
		gradientPanel.add(btnDelete);

		JLabel lblViewAllAllowance = new JLabel("View Allowance");
		lblViewAllAllowance.setBounds(268, 62, 261, 20);
		gradientPanel.add(lblViewAllAllowance);
		lblViewAllAllowance.setForeground(Color.WHITE);
		lblViewAllAllowance.setFont(new Font("MV Boli", Font.BOLD, 25));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(205, 129, 347, 89);
		gradientPanel.add(scrollPane);

		this.allowanceList = new JList();
		scrollPane.setViewportView(allowanceList);

		JLabel lblName = new JLabel("Name , Amount($)");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblName.setBounds(206, 111, 190, 16);
		gradientPanel.add(lblName);

		// edits selected user allowance
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index2 = allowanceList.getSelectedIndex(); // returns user index from JList

				if (index2 == -1)
					return;

				Allowance all = allowance[index2];

				main.showEditAllowance(index2, all); // displays edited allowance

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)

			{

				index2 = allowanceList.getSelectedIndex(); // returns user index from JList

				if (index2 == -1)
					return;

				Allowance all = allowance[index2];

				main.getController().deleteAllo(index2); // gets method from controller to delete allocated allowance

				main.getController().setuserAllowance(0.0, all.getName()); // gets method from controller to set
																			// selected user allowance to 0.0

				JOptionPane.showMessageDialog(null, "Successfully Deleted ! ", "Notification",
						JOptionPane.PLAIN_MESSAGE);

				populateAllowanceList();

			}
		});

		// brings user back to allocate allowance screen
		btnBackToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)

			{

				main.showAllocateAllowance();

			}
		});

		populateAllowanceList();
	}

	private void populateAllowanceList() {
		this.allowance = this.main.getController().getAllAllo();// gets method from controller to return allowance array

		DefaultListModel model = new DefaultListModel();

		for (int i = 0; i < allowance.length; i++) // loops by allowance length
		{

			Allowance op = allowance[i];

			model.addElement(op.getName() + "  " + "," + "  " + op.getAmount());

		}

		this.allowanceList.setModel(model);
	}
}
