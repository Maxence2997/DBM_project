package test;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Term_project_main {

	// local
	static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	// userid & password
	static final String USER = "root";
	static final String PASS = "qazwsxedc12345678";

	// static connection conn;

	private JFrame frame;

	private JPanel login_panel;
	private JPanel home_panel;
	static JTextField field_empID;
	private JLabel lbl_emp;
	private JLabel lbl_empID;

	private JPanel core_home_panel;

	static JPanel container_panel;

	private Employee_panel emp_panel;

	private Supplier_panel sup_panel;

	private Inventory_panel inv_panel;
	static connection conn;
	static CardLayout card_layout;
	static CardLayout cl_home;
	static boolean supervisor_check;
	static Library lib = new Library();;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				double time1, time2, time3, time4;

				time1 = System.currentTimeMillis();

				// conn = new connection(4);
				time2 = System.currentTimeMillis();
				System.out.println((time2 - time1) / 1000);

				try {
					new Term_project_main();
					// window.frame.setVisible(true);
					time3 = System.currentTimeMillis();
					System.out.println((time3 - time1) / 1000);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	Term_project_main() {

		double time1, time2;
		time1 = System.currentTimeMillis();
		frame = new JFrame("Supply Chain System");
		// frame.setBounds(100, 100, 666, 466);
		frame.setBounds(100, 100, 1000, 550);
		conn = new connection();
		card_layout = new CardLayout();

		frame.getContentPane().setLayout(card_layout);

		login_panel();
		home_panel();
		new Project_panels();
		inv_panel = new Inventory_panel();
		sup_panel = new Supplier_panel();
		emp_panel = new Employee_panel();

		frame.setVisible(true);

		time2 = System.currentTimeMillis();
		System.out.println((time2 - time1) / 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// initialize();
	}

	private void login_panel() {

		login_panel = new JPanel();
		frame.getContentPane().add(login_panel, "login");
		login_panel.setLayout(null);

		JLabel label_empID = new JLabel("Employee ID :");
		label_empID.setBounds(286, 192, 104, 16);
		login_panel.add(label_empID);

		JLabel login_result = new JLabel("");
		login_result.setBounds(286, 246, 438, 26);
		login_panel.add(login_result);

		field_empID = new JTextField();
		field_empID.setBounds(415, 187, 163, 26);
		login_panel.add(field_empID);
		field_empID.setColumns(10);
		field_empID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//					card_layout.show(frame.getContentPane(), "home");
//					cl_home.show(container_panel, "home");

				
				Employee employee = new Employee();
				
				if (employee.emp_check(field_empID)) {
					
					lib.adjust_PROJECT();
					supervisor_check = employee.supervisor_check(field_empID);
					
					card_layout.show(frame.getContentPane(), "home");
					cl_home.show(container_panel, "home");

					lbl_empID.setText(" Employee ID: " + field_empID.getText());

					JScrollPane scrollpane = new JScrollPane();
					JTable table = new JTable() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}// uneditable
					};

					

					if (supervisor_check) {
						if (lib.show_unsign_req().length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Product", "Item", "Vol.",
									"Unit Price", "Total Price", "Signature", "Supervisor ID", "Supervisor", "Date" };

							DefaultTableModel table_model = new DefaultTableModel(lib.show_unsign_req(), columns_name);
							table.setModel(table_model);
							scrollpane.setPreferredSize(new Dimension(1000, 125));
							scrollpane.setViewportView(table);
							table.getColumnModel().getColumn(1).setPreferredWidth(50);
							table.getColumnModel().getColumn(10).setPreferredWidth(120);
							table.getColumnModel().getColumn(11).setPreferredWidth(100);
							JOptionPane.showMessageDialog(home_panel, scrollpane, "Unsigned Documents", 2);
						}
					} else {
						if (lib.show_project_status().length != 0) {

							String[] columns_name = { "Project ID", "P.status", "Employee ID", "Name", "Module",
									"*P.D.P", "Supplier ID", "Name", "*E.S.D", "Receipt Date", "Contract" };

							DefaultTableModel table_model = new DefaultTableModel(lib.show_project_status(),
									columns_name);
							table.setModel(table_model);
							scrollpane.setPreferredSize(new Dimension(800, 125));
							scrollpane.setViewportView(table);
							table.getColumnModel().getColumn(0).setPreferredWidth(90);
							table.getColumnModel().getColumn(1).setPreferredWidth(50);
							table.getColumnModel().getColumn(2).setPreferredWidth(100);
							table.getColumnModel().getColumn(3).setPreferredWidth(100);
							table.getColumnModel().getColumn(5).setPreferredWidth(50);
							table.getColumnModel().getColumn(6).setPreferredWidth(100);
							table.getColumnModel().getColumn(8).setPreferredWidth(100);
							table.getColumnModel().getColumn(9).setPreferredWidth(100);

							JOptionPane.showMessageDialog(home_panel, scrollpane, "Delivery Caution", 2);
						}
					}
				} else

					login_result.setText("Employee ID is invalid, please refill it.");
				// Term_project_main.field_empID.setText("");
//						
			}

		});

		JButton button_login = new JButton("Log-in");
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//					card_layout.show(frame.getContentPane(), "home");
//					cl_home.show(container_panel, "home");

				
				Employee employee = new Employee();
				
				if (employee.emp_check(field_empID)) {
					
					lib.adjust_PROJECT();
					supervisor_check = employee.supervisor_check(field_empID);
					
					card_layout.show(frame.getContentPane(), "home");
					cl_home.show(container_panel, "home");

					lbl_empID.setText(" Employee ID: " + field_empID.getText());

					JScrollPane scrollpane = new JScrollPane();
					JTable table = new JTable() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}// uneditable
					};

					

					if (supervisor_check) {
						if (lib.show_unsign_req().length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Product", "Item", "Vol.",
									"Unit Price", "Total Price", "Signature", "Supervisor ID", "Supervisor", "Date" };

							DefaultTableModel table_model = new DefaultTableModel(lib.show_unsign_req(), columns_name);
							table.setModel(table_model);
							scrollpane.setPreferredSize(new Dimension(1000, 125));
							scrollpane.setViewportView(table);
							table.getColumnModel().getColumn(1).setPreferredWidth(50);
							table.getColumnModel().getColumn(10).setPreferredWidth(120);
							table.getColumnModel().getColumn(11).setPreferredWidth(100);
							JOptionPane.showMessageDialog(home_panel, scrollpane, "Unsigned Documents", 2);
						}
					} else {
						if (lib.show_project_status().length != 0) {

							String[] columns_name = { "Project ID", "P.status", "Employee ID", "Name", "Module",
									"*P.D.P", "Supplier ID", "Name", "*E.S.D", "Receipt Date", "Contract" };

							DefaultTableModel table_model = new DefaultTableModel(lib.show_project_status(),
									columns_name);
							table.setModel(table_model);
							scrollpane.setPreferredSize(new Dimension(800, 125));
							scrollpane.setViewportView(table);
							table.getColumnModel().getColumn(0).setPreferredWidth(90);
							table.getColumnModel().getColumn(1).setPreferredWidth(50);
							table.getColumnModel().getColumn(2).setPreferredWidth(100);
							table.getColumnModel().getColumn(3).setPreferredWidth(100);
							table.getColumnModel().getColumn(5).setPreferredWidth(50);
							table.getColumnModel().getColumn(6).setPreferredWidth(100);
							table.getColumnModel().getColumn(8).setPreferredWidth(100);
							table.getColumnModel().getColumn(9).setPreferredWidth(100);

							JOptionPane.showMessageDialog(home_panel, scrollpane, "Delivery Caution", 2);
						}
					}
				} else

					login_result.setText("Employee ID is invalid, please refill it.");
//						
			}

		});
		button_login.setBounds(607, 187, 117, 29);
		login_panel.add(button_login);

	}

	private void home_panel() {

		// home panel which contains only EMPID, button log-out, btn_reminder and button
		// home
		home_panel = new JPanel();
		// home_panel.setbo
		frame.getContentPane().add(home_panel, "home");
		home_panel.setLayout(null);

		JButton btn_logout = new JButton("Log-out");
		btn_logout.setBounds(0, 488, 96, 29);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(core_home_panel, "Sure to logout?", "Logout",
						JOptionPane.YES_NO_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					card_layout.show(frame.getContentPane(), "login");
				}
			}
		});
		home_panel.add(btn_logout);

		lbl_empID = new JLabel();
		lbl_empID.setBounds(0, 5, 179, 16);
		home_panel.add(lbl_empID);

		JButton btn_reminder = new JButton("Reminder");
		btn_reminder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * @author Ray
				 * @since 06/15/2021
				 * 
				 * @editor Jyun An
				 * @since 06/16/2021
				 */
				JScrollPane scrollpane = new JScrollPane();
				JTable table = new JTable() {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}// uneditable
				};
				Employee employee = new Employee();
				if (employee.supervisor_check(Term_project_main.field_empID)) {

					String[] columns_name = { "Sheet ID", "Type", "Project ID", "Product", "Item", "Vol.", "Unit Price",
							"Total Price", "Signature", "Supervisor ID", "Supervisor", "Date" };

					DefaultTableModel table_model = new DefaultTableModel(lib.show_unsign_req(), columns_name);
					table.setModel(table_model);
					scrollpane.setPreferredSize(new Dimension(1000, 125));
					scrollpane.setViewportView(table);
					table.getColumnModel().getColumn(1).setPreferredWidth(50);
					table.getColumnModel().getColumn(10).setPreferredWidth(120);
					table.getColumnModel().getColumn(11).setPreferredWidth(100);
					JOptionPane.showMessageDialog(home_panel, scrollpane, "Unsigned Documents", 2);
				} else {

					String[] columns_name = { "Project ID", "P.status", "Employee ID", "Name", "Module", "*P.D.P",
							"Supplier ID", "Name", "*E.S.D", "Receipt Date", "Contract" };

					DefaultTableModel table_model = new DefaultTableModel(lib.show_project_status(), columns_name);

					table.setModel(table_model);
					scrollpane.setPreferredSize(new Dimension(800, 125));
					scrollpane.setViewportView(table);
					table.getColumnModel().getColumn(0).setPreferredWidth(90);
					table.getColumnModel().getColumn(1).setPreferredWidth(50);
					table.getColumnModel().getColumn(2).setPreferredWidth(100);
					table.getColumnModel().getColumn(3).setPreferredWidth(100);
					table.getColumnModel().getColumn(5).setPreferredWidth(50);
					table.getColumnModel().getColumn(6).setPreferredWidth(100);
					table.getColumnModel().getColumn(8).setPreferredWidth(100);
					table.getColumnModel().getColumn(9).setPreferredWidth(100);

					JOptionPane.showMessageDialog(home_panel, scrollpane, "Delivery Caution", 2);
				}
			}
		});
		btn_reminder.setBounds(891, 0, 109, 26);
		home_panel.add(btn_reminder);

		cl_home = new CardLayout();
		container_panel = new JPanel(cl_home);
		container_panel.setBounds(0, 26, 1000, 450);
		container_panel.setBackground(Color.CYAN);
		home_panel.add(container_panel);

		// home_core_panel
		core_home_panel = new JPanel();
		container_panel.add(core_home_panel, "home");

		JButton btn_project = new JButton("Project");
		btn_project.setBounds(334, 71, 103, 29);
		btn_project.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl_home.show(container_panel, "project");

			}
		});
		core_home_panel.setLayout(null);
		core_home_panel.add(btn_project);

		JLabel lbl_sheet = new JLabel("Project management ");
		lbl_sheet.setBounds(470, 77, 385, 16);
		core_home_panel.add(lbl_sheet);

		// Author: Ray
		// Date: 05/31
		// Default text field as empty
		JButton btn_invent = new JButton("Inventory");
		btn_invent.setBounds(334, 163, 103, 29);
		btn_invent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/**
				 * @editor: jyun an
				 * 
				 * @since: 06/09/2021
				 */
				inv_panel.clear();
				cl_home.show(container_panel, "inventory");

			}
		});
		core_home_panel.add(btn_invent);

		JLabel lbl_invent = new JLabel("Inquire the vol. of Inventory");
		lbl_invent.setBounds(470, 169, 385, 16);
		core_home_panel.add(lbl_invent);

		// Author: Ray
		// Date: 05/31
		// Default text field as empty
		JButton btn_sup = new JButton("Supplier");
		btn_sup.setBounds(334, 254, 103, 29);
		btn_sup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sup_panel.get_combobox_sup().setSelectedIndex(0);

				/**
				 * @editor: jyun an
				 * 
				 * @since: 06/09/2021
				 */
				sup_panel.clear_text();

				// clear table
				// sup_panel.get_sup_table().

				cl_home.show(container_panel, "supplier");

			}
		});
		core_home_panel.add(btn_sup);

		JLabel lbl_sup = new JLabel("Suppliers' information maintenance");
		lbl_sup.setBounds(470, 260, 385, 16);
		core_home_panel.add(lbl_sup);

		// Author: Ray
		// Date: 05/31
		// Default text field as empty
		JButton btn_emp = new JButton("Employee");
		btn_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				emp_panel.get_comboBox_employeeAction().setSelectedIndex(0);

				/**
				 * @editor: Jyun-An
				 * @since:06/08/2021 add emp_panel.set_visible(false);
				 */
				emp_panel.set_visible(false);
				emp_panel.clear_text();

				cl_home.show(container_panel, "employee");
			}
		});
		btn_emp.setBounds(334, 346, 103, 29);
		core_home_panel.add(btn_emp);

		lbl_emp = new JLabel("Employees' information maintenance");
		lbl_emp.setBounds(470, 353, 385, 16);
		core_home_panel.add(lbl_emp);

		JButton btn_home = new JButton("Home");
		btn_home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				cl_home.show(container_panel, "home");

			}
		});
		btn_home.setBounds(913, 488, 81, 29);
		home_panel.add(btn_home);

	}
}
