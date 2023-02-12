package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.MainFrame;
import data.DetailedExpense;
import data.Category;
import data.DataStorage;
import data.User;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.k33ptoo.components.KGradientPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import com.k33ptoo.components.KButton;
import javax.swing.ComboBoxModel;

//Design- Haziq
//Features- Caisoon
//Bonues Features(Find biggest spender)- Haziq

public class Head_Summary extends JPanel {
	private MainFrame main;
	private DetailedExpense[] ex;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox categoryBox;
	private JComboBox nameBox;
	private JComboBox monthBox;
	private String[] month = { "All", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };
	private JTextField textField;
	public double total[], sum, highest;
	public String baller;
	private KButton btnBaller;

	public Head_Summary(MainFrame main) {
		this.main = main;
		this.setSize(751, 550);
		setLayout(null);

		this.model = new DefaultTableModel();
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table = new JTable(model); // create JTable
		table.setRowSorter(sorter);

		model.addColumn("Name");
		model.addColumn("Item");
		model.addColumn("Amount");
		model.addColumn("Date");
		model.addColumn("Catergory");

		Category[] cat = main.getController().getAllCat();

		DefaultComboBoxModel model = new DefaultComboBoxModel();

		for (int i = 0; i < cat.length; i++) {

			Category op = cat[i];

			model.addElement(op.getCategoryName().toString());

		}

		User[] storage = main.getController().getUsers();

		DefaultComboBoxModel model1 = new DefaultComboBoxModel();

		for (int i = 0; i < storage.length; i++)

		{

			User opp = storage[i];

			model1.addElement(opp.getName().toString());

		}

		KGradientPanel gradientPanel = new KGradientPanel();
		gradientPanel.setLayout(null);
		gradientPanel.kStartColor = Color.GREEN;
		gradientPanel.setkStartColor(Color.GREEN);
		gradientPanel.setBounds(0, 0, 751, 550);
		add(gradientPanel);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnBack.setContentAreaFilled(false);
		btnBack.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.WHITE));
		btnBack.setBounds(29, 469, 114, 23);
		gradientPanel.add(btnBack);

		KButton btnFilter = new KButton();
		btnFilter.setText("Filter Category");
		btnFilter.setOpaque(false);
		btnFilter.kStartColor = Color.PINK;
		btnFilter.setkStartColor(Color.MAGENTA);
		btnFilter.kHoverStartColor = new Color(204, 255, 153);
		btnFilter.setkHoverStartColor(new Color(204, 255, 153));
		btnFilter.kHoverForeGround = new Color(153, 204, 153);
		btnFilter.setkHoverForeGround(new Color(153, 204, 153));
		btnFilter.kEndColor = new Color(0, 153, 51);
		btnFilter.setkEndColor(Color.BLUE);
		btnFilter.kBorderRadius = 40;
		btnFilter.setkBorderRadius(40);
		btnFilter.setContentAreaFilled(false);
		btnFilter.setBorderPainted(false);
		btnFilter.setBounds(50, 245, 143, 23);
		gradientPanel.add(btnFilter);

		JLabel lblSummary = new JLabel("Summary");
		lblSummary.setForeground(Color.WHITE);
		lblSummary.setFont(new Font("MV Boli", Font.BOLD, 25));
		lblSummary.setBounds(285, 40, 266, 35);
		gradientPanel.add(lblSummary);

		KButton btnFilterMember = new KButton();
		btnFilterMember.setText("Filter Member");
		btnFilterMember.setOpaque(false);
		btnFilterMember.kStartColor = Color.PINK;
		btnFilterMember.setkStartColor(Color.MAGENTA);
		btnFilterMember.kHoverStartColor = new Color(204, 255, 153);
		btnFilterMember.setkHoverStartColor(new Color(204, 255, 153));
		btnFilterMember.kHoverForeGround = new Color(153, 204, 153);
		btnFilterMember.setkHoverForeGround(new Color(153, 204, 153));
		btnFilterMember.kEndColor = new Color(0, 153, 51);
		btnFilterMember.setkEndColor(Color.BLUE);
		btnFilterMember.kBorderRadius = 40;
		btnFilterMember.setkBorderRadius(40);
		btnFilterMember.setContentAreaFilled(false);
		btnFilterMember.setBorderPainted(false);
		btnFilterMember.setBounds(50, 154, 143, 23);
		gradientPanel.add(btnFilterMember);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(244, 125, 452, 303);
		gradientPanel.add(scrollPane);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.WHITE));
		textField.setForeground(Color.WHITE);
		textField.setOpaque(false);
		textField.setBounds(476, 436, 116, 22);
		gradientPanel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);

		this.categoryBox = new JComboBox(model);
		categoryBox.setBounds(50, 209, 146, 25);
		gradientPanel.add(categoryBox);
		categoryBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		this.nameBox = new JComboBox(model1);
		nameBox.setBounds(50, 120, 146, 23);
		gradientPanel.add(nameBox);
		nameBox.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblName.setBounds(29, 105, 46, 14);
		gradientPanel.add(lblName);

		JLabel lblNewLabel = new JLabel("Category:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel.setBounds(29, 193, 60, 14);
		gradientPanel.add(lblNewLabel);

		JLabel lblAmount = new JLabel("Total: ");
		lblAmount.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(432, 439, 56, 16);
		gradientPanel.add(lblAmount);

		KButton btnFilterBoth = new KButton();
		btnFilterBoth.setText("Filter Both");
		btnFilterBoth.setOpaque(false);
		btnFilterBoth.kStartColor = Color.PINK;
		btnFilterBoth.setkStartColor(Color.MAGENTA);
		btnFilterBoth.kHoverStartColor = new Color(204, 255, 153);
		btnFilterBoth.setkHoverStartColor(new Color(204, 255, 153));
		btnFilterBoth.kHoverForeGround = new Color(153, 204, 153);
		btnFilterBoth.setkHoverForeGround(new Color(153, 204, 153));
		btnFilterBoth.kEndColor = new Color(0, 153, 51);
		btnFilterBoth.setkEndColor(Color.BLUE);
		btnFilterBoth.kBorderRadius = 40;
		btnFilterBoth.setkBorderRadius(40);
		btnFilterBoth.setContentAreaFilled(false);
		btnFilterBoth.setBorderPainted(false);
		btnFilterBoth.setBounds(50, 330, 143, 35);
		gradientPanel.add(btnFilterBoth);

		KButton btnCalculate = new KButton();
		btnCalculate.setText("Calculate");
		btnCalculate.setOpaque(false);
		btnCalculate.kStartColor = Color.PINK;
		btnCalculate.setkStartColor(Color.MAGENTA);
		btnCalculate.kHoverStartColor = new Color(204, 255, 153);
		btnCalculate.setkHoverStartColor(new Color(204, 255, 153));
		btnCalculate.kHoverForeGround = new Color(153, 204, 153);
		btnCalculate.setkHoverForeGround(new Color(153, 204, 153));
		btnCalculate.kEndColor = new Color(0, 153, 51);
		btnCalculate.setkEndColor(Color.BLUE);
		btnCalculate.kBorderRadius = 40;
		btnCalculate.setkBorderRadius(40);
		btnCalculate.setContentAreaFilled(false);
		btnCalculate.setBorderPainted(false);
		btnCalculate.setBounds(285, 435, 106, 23);
		gradientPanel.add(btnCalculate);

		JLabel lblNewLabel_1 = new JLabel("Top Spender");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(452, 91, 244, 28);
		gradientPanel.add(lblNewLabel_1);

		JComboBox monthBox = new JComboBox(this.month);
		monthBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		monthBox.setBounds(50, 376, 146, 25);
		gradientPanel.add(monthBox);

		KButton btnBaller;
		btnBaller = new KButton();

		// finds highest spender
		btnBaller.addActionListener(new ActionListener() {
			public double total[], totalSum, highest;

			public String baller;

			User[] u = main.getController().getUsers(); // gets user array

			public String[] name = new String[u.length]; // makes new array

			public double[] bag = new double[u.length]; // makes new array

			public void actionPerformed(ActionEvent e) {
				String m = monthBox.getSelectedItem().toString();

				if (m.equals("All")) // no filter

				{
					sorter.setRowFilter(null); // does not filter anything

					if (main.getController().getUsers() != null) // check for any registered user
					{

						this.total = new double[main.getController().getUsers().length]; // user array length

						User[] u = main.getController().getUsers();

						for (int i = 0; i < u.length; i++) // user length for loop

						{
							totalSum = main.getController().calculateUserExpense(u[i].getName());// calculate each user

							this.total[i] = totalSum; // loop for each user
						}

						if (this.total != null) // if total is not 0
						{

							for (int x = 0; x != total.length; x++)

							{
								if (total.length > 1) // check for more than one user

								{
									if ((x + 1 < total.length) == true)

									{
										if (total[x] > total[x + 1]) // compares total expense of user in array

										{
											highest = total[x];

											this.baller = u[x].getName();
										}

										else {
											highest = total[x + 1];

											this.baller = u[x + 1].getName();
										}
									}
								}

								else // if only 1 user, show that user
								{
									highest = total[x];

									this.baller = u[x].getName();
								}
							}

						}

					}
					lblNewLabel_1.setText("Top Spender: " + baller + " " + "$" + highest);
				} else // filter by month for biggest spender
				{
					User[] u = main.getController().getUsers();

					double mSum[] = new double[u.length];

					String name[] = new String[u.length];
					try {
						sorter.setRowFilter(RowFilter.regexFilter(m)); // filter month

						for (int i = 0; i < u.length; i++) {
							double total = main.getController().getUserMonth(u[i].getName(),
									monthBox.getSelectedItem().toString()); // gets method from controller to get
																			// username with month

							mSum[i] = total; // gets total expense

							name[i] = u[i].getName(); // gets username

						}
						double max = mSum[0];

						String rich = name[0];

						for (int x = 0; x < mSum.length; x++) {
							if (mSum[x] > max) // compares highest expenses
							{

								max = mSum[x];

								rich = name[x];
							}

						}

						System.out.println(max + " " + rich);

						lblNewLabel_1.setText("Top Spender: " + rich + " " + "$" + max);
					} catch (PatternSyntaxException pse) {

						System.out.println("Bad regex pattern");
					}
				}
			}
		});

		btnBaller.setText("Top Spender");
		btnBaller.setOpaque(false);
		btnBaller.kStartColor = Color.PINK;
		btnBaller.setkStartColor(Color.MAGENTA);
		btnBaller.kHoverStartColor = new Color(204, 255, 153);
		btnBaller.setkHoverStartColor(new Color(204, 255, 153));
		btnBaller.kHoverForeGround = new Color(153, 204, 153);
		btnBaller.setkHoverForeGround(new Color(153, 204, 153));
		btnBaller.kEndColor = new Color(0, 153, 51);
		btnBaller.setkEndColor(Color.BLUE);
		btnBaller.kBorderRadius = 40;
		btnBaller.setkBorderRadius(40);
		btnBaller.setContentAreaFilled(false);
		btnBaller.setBorderPainted(false);
		btnBaller.setBounds(72, 412, 106, 23);
		gradientPanel.add(btnBaller);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.showFamilyHead();
			}
		});
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sum();
			}
		});
		btnFilterBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<RowFilter<Object, Object>> filters = new ArrayList<RowFilter<Object, Object>>(2);

				filters.add(RowFilter.regexFilter(nameBox.getSelectedItem().toString(), 0));

				filters.add(RowFilter.regexFilter(categoryBox.getSelectedItem().toString(), 4));

				RowFilter<Object, Object> Filter = RowFilter.andFilter(filters);

				sorter.setRowFilter(Filter);
			}
		});

		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String c = categoryBox.getSelectedItem().toString();
				if (c.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					try {
						sorter.setRowFilter(RowFilter.regexFilter(c));
					} catch (PatternSyntaxException pse) {
						System.out.println("Bad regex pattern");
					}
				}
			}
		});
		btnFilterMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = nameBox.getSelectedItem().toString();
				if (n.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					try {
						sorter.setRowFilter(RowFilter.regexFilter(n));

					} catch (PatternSyntaxException pse) {
						System.out.println("Bad regex pattern");
					}
				}
			}
		});

		this.populateJTABLE();
	}

	public void sum() {
		double sum = 0;
		for (int i = 0; i < table.getRowCount(); i++) {
			sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
		}
		textField.setText(Double.toString(sum));
	}

	public void addExpense(String i, double a, String d, String c) {
		model.insertRow(model.getRowCount(), new Object[] { i, a, d, c });// display added expense in the JTable

	}

	public void populateJTABLE() {

		User[] u = main.getController().getUsers();
		for (int i = 0; i < u.length; i++) {
			ex = u[i].getAllExpense();
			for (int x = 0; x < ex.length; x++) {

				DetailedExpense op = ex[x];
				model.insertRow(table.getRowCount(), new Object[] { u[i].getName(), op.getItemDescription(),
						op.getItemAmount(), op.getItemDate(), op.getItemCategory() });// should be fine

			}
			this.table.setModel(model);
		}

	}
}
