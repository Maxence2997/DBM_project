package test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

class Employee_panel {
	/**
	 * @autohr Jyun-An @ver. 1.2.2 05/28 Seperated from Project_test
	 **/

	private JPanel employee_panel;

	private String function;
	private JComboBox comboBox_emp_action; // employee panel variables needed for comboBox actionListener
	private JLabel lbl_emp_first;
	private JTextField text_emp_first;
	private JLabel lbl_emp_last;
	private JTextField text_emp_last;
	private JLabel lbl_emp_addr;
	private JTextField text_emp_addr;
	private JLabel lbl_emp_phone;
	private JTextField text_emp_phone;
	private JLabel lbl_emp_supervID;
	private JTextField text_emp_supervID;
	private JLabel lbl_emp_perf;
	private JComboBox comboBox_emp_perf;
	private JButton btn_emp_confirmID;
	private JButton btn_emp_execute;
	private JLabel lbl_empID_show;
	private JLabel lbl_emp_info;

	private JTextField text_emp_empID;
	private JTable emp_table;
	private JScrollPane scrollpane;
	private JButton btn_show_more;

	Employee_panel() {

		/**
		 * @author Ray
		 * @since 05/25/2021
		 * 
		 * @editor jyun-an
		 * @since 06/28/2021
		 */

		employee_panel = new JPanel();
		employee_panel.setBounds(0, 26, 1000, 450);
		Term_project_main.container_panel.add(employee_panel, "employee");
		employee_panel.setLayout(null);

		lbl_empID_show = new JLabel("");
		lbl_empID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_empID_show.setBounds(393, 75, 202, 16);
		lbl_empID_show.setVisible(false);
		employee_panel.add(lbl_empID_show);

		JLabel lbl_emp_empID = new JLabel("Employee ID :");
		lbl_emp_empID.setBounds(271, 75, 86, 16);
		employee_panel.add(lbl_emp_empID);

		text_emp_empID = new JTextField();
		text_emp_empID.setHorizontalAlignment(SwingConstants.CENTER);
		text_emp_empID.setBounds(393, 68, 202, 26);
		employee_panel.add(text_emp_empID);
		text_emp_empID.setColumns(16);

		lbl_emp_first = new JLabel("First Name :");
		lbl_emp_first.setBounds(271, 103, 76, 16);
		lbl_emp_first.setVisible(false);
		employee_panel.add(lbl_emp_first);

		text_emp_first = new JTextField();
		text_emp_first.setHorizontalAlignment(SwingConstants.CENTER);
		text_emp_first.setBounds(393, 97, 202, 26);
		text_emp_first.setVisible(false);
		employee_panel.add(text_emp_first);
		text_emp_first.setColumns(16);

		lbl_emp_last = new JLabel("Last Name :");
		lbl_emp_last.setBounds(271, 129, 74, 16);
		lbl_emp_last.setVisible(false);
		employee_panel.add(lbl_emp_last);

		text_emp_last = new JTextField();
		text_emp_last.setHorizontalAlignment(SwingConstants.CENTER);
		text_emp_last.setBounds(393, 123, 202, 26);
		text_emp_last.setVisible(false);
		employee_panel.add(text_emp_last);
		text_emp_last.setColumns(16);

		text_emp_addr = new JTextField();
		text_emp_addr.setHorizontalAlignment(SwingConstants.CENTER);
		text_emp_addr.setBounds(393, 149, 202, 26);
		text_emp_addr.setVisible(false);

		lbl_emp_addr = new JLabel("Address :");
		lbl_emp_addr.setBounds(271, 155, 59, 16);
		lbl_emp_addr.setVisible(false);
		employee_panel.add(lbl_emp_addr);
		employee_panel.add(text_emp_addr);
		text_emp_addr.setColumns(16);

		lbl_emp_phone = new JLabel("Phone Number :");
		lbl_emp_phone.setBounds(271, 181, 100, 16);
		lbl_emp_phone.setVisible(false);
		employee_panel.add(lbl_emp_phone);

		text_emp_phone = new JTextField();
		text_emp_phone.setHorizontalAlignment(SwingConstants.CENTER);
		text_emp_phone.setBounds(393, 175, 202, 26);
		text_emp_phone.setVisible(false);
		employee_panel.add(text_emp_phone);
		text_emp_phone.setColumns(16);

		lbl_emp_supervID = new JLabel("Supervisor ID :");
		lbl_emp_supervID.setBounds(271, 207, 92, 16);
		lbl_emp_supervID.setVisible(false);
		employee_panel.add(lbl_emp_supervID);

		text_emp_supervID = new JTextField();
		text_emp_supervID.setHorizontalAlignment(SwingConstants.CENTER);
		text_emp_supervID.setBounds(393, 201, 202, 26);
		text_emp_supervID.setVisible(false);
		employee_panel.add(text_emp_supervID);
		text_emp_supervID.setColumns(16);

		lbl_emp_perf = new JLabel("Performance :");
		lbl_emp_perf.setBounds(271, 236, 86, 16);
		lbl_emp_perf.setVisible(false);
		employee_panel.add(lbl_emp_perf);

		lbl_emp_info = new JLabel("Message of execute result");
		lbl_emp_info.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_emp_info.setBounds(178, 302, 650, 16);
		lbl_emp_info.setVisible(false);
		employee_panel.add(lbl_emp_info);

		emp_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable
		};
		emp_table.setFillsViewportHeight(true);
		// emp_table.setBounds(48,288,563,30);
		emp_table.setVisible(false);

		scrollpane = new JScrollPane(emp_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(178, 330, 650, 80);
		scrollpane.setVisible(false);
		// scrollpane.setPreferredSize(new Dimension(563, 50)); //whole scrollpane and
		// table will disapear
		employee_panel.add(scrollpane);

		JButton btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_text();

				if (comboBox_emp_action.getSelectedItem().equals("Delete Employee")
						| comboBox_emp_action.getSelectedItem().equals("Show & Adjust")) {

					btn_clear.setVisible(false);

					lbl_emp_info.setVisible(false);
					lbl_empID_show.setVisible(false);
					text_emp_empID.setVisible(true);

					set_visible(false);

				}
			}
		});
		btn_clear.setBounds(623, 115, 95, 29);
		employee_panel.add(btn_clear);

		comboBox_emp_perf = new JComboBox();
		comboBox_emp_perf.setBounds(393, 230, 65, 27);
		comboBox_emp_perf.setForeground(Color.BLACK);
		comboBox_emp_perf.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C" }));
		comboBox_emp_perf.setVisible(false);
		employee_panel.add(comboBox_emp_perf);

		comboBox_emp_action = new JComboBox();
		comboBox_emp_action.setBounds(414, 36, 160, 27);
		comboBox_emp_action.setModel(
				new DefaultComboBoxModel(new String[] { "Show & Adjust", "Add Employee", "Delete Employee" }));
		function = (String) comboBox_emp_action.getSelectedItem(); // get the selected item
		comboBox_emp_action.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				function = (String) comboBox_emp_action.getSelectedItem();
				if (Term_project_main.supervisor_check) {
					if (function.equals("Show & Adjust")) {
						// visibility

						btn_emp_execute.setText("Save Change");
						set_visible(false);
						lbl_emp_empID.setVisible(true);
						lbl_emp_info.setVisible(false);
						lbl_empID_show.setVisible(false);
						text_emp_empID.setVisible(true);
						btn_emp_confirmID.setVisible(true);
						btn_clear.setVisible(false);
						emp_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);
						// textField
						clear_text();

					} else if (function.equals("Add Employee")) {
						// visibility
						btn_emp_execute.setText("Add");
						set_visible(true);
						lbl_emp_empID.setVisible(true);
						lbl_emp_info.setVisible(false);
						lbl_empID_show.setText("");
						lbl_empID_show.setVisible(true);
						text_emp_empID.setVisible(false);
						btn_emp_confirmID.setVisible(false);
						btn_clear.setVisible(true);
						emp_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);

						// textField
						clear_text();

					} else {
						// visibility
						btn_emp_execute.setText("Delete");
						set_visible(false);
						lbl_emp_empID.setVisible(true);
						lbl_emp_info.setVisible(false);
						lbl_empID_show.setVisible(false);
						btn_emp_confirmID.setVisible(true);
						text_emp_empID.setVisible(true);
						btn_clear.setVisible(false);
						emp_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);
						// textField
						clear_text();
					}
				} else {
					// not supervisor
					if (function.equals("Show & Adjust")) {
						// visibility

						btn_emp_execute.setText("Save Change");
						set_visible(false);
						lbl_emp_empID.setVisible(true);
						lbl_emp_info.setVisible(false);
						lbl_empID_show.setVisible(false);
						text_emp_empID.setVisible(true);
						btn_emp_confirmID.setVisible(true);
						btn_clear.setVisible(false);

						// textField
						clear_text();

					} else if (function.equals("Add Employee")) {
						// visibility
						btn_emp_execute.setText("Add");
						set_visible(false);
						lbl_emp_empID.setVisible(false);
						lbl_empID_show.setText("");
						lbl_empID_show.setVisible(false);
						text_emp_empID.setVisible(false);
						btn_emp_confirmID.setVisible(false);
						btn_clear.setVisible(false);
						emp_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);

						// textField
						clear_text();
						lbl_emp_info.setText("Sorry, this function is only for supervisor.");
						lbl_emp_info.setVisible(true);

					} else {
						// visibility
						btn_emp_execute.setText("Delete");
						set_visible(false);
						lbl_emp_empID.setVisible(false);
						lbl_empID_show.setVisible(false);
						btn_emp_confirmID.setVisible(false);
						text_emp_empID.setVisible(false);
						btn_clear.setVisible(false);
						emp_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);
						// textField
						clear_text();
						lbl_emp_info.setText("Sorry, this function is only for supervisor.");
						lbl_emp_info.setVisible(true);
					}

				}
			}
		});
		employee_panel.add(comboBox_emp_action);

		btn_emp_confirmID = new JButton("Confirm");
		btn_emp_confirmID.setBounds(623, 68, 95, 29);
		btn_emp_confirmID.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					Integer.parseInt(text_emp_empID.getText());
					// test empID.getText() is blank or alphabet

//	            		String []temp = new String[] {"11047602","Abner","Williams",
//	            										"Taoyuan","(09)11091002","11047600","C"}; //for testing without connection
					Employee employee = new Employee();
					ArrayList<String> temp = employee.check(text_emp_empID.getText());
					if (temp.size() != 0) {

						// if(comboBox_emp_action.getSelectedItem().equals("Delete Employee")) {

						btn_clear.setVisible(true);
						// }

						lbl_empID_show.setText(text_emp_empID.getText());
						;
						lbl_empID_show.setVisible(true);

						text_emp_empID.setVisible(false);

						lbl_emp_first.setVisible(true);
						text_emp_first.setVisible(true);
						text_emp_first.setText(temp.get(1));

						lbl_emp_last.setVisible(true);
						text_emp_last.setVisible(true);
						text_emp_last.setText(temp.get(2));

						lbl_emp_addr.setVisible(true);
						text_emp_addr.setVisible(true);
						text_emp_addr.setText(temp.get(3));

						lbl_emp_phone.setVisible(true);
						text_emp_phone.setVisible(true);
						text_emp_phone.setText(temp.get(4));

						lbl_emp_supervID.setVisible(true);
						text_emp_supervID.setVisible(true);
						text_emp_supervID.setText(temp.get(5));

						lbl_emp_perf.setVisible(true);

						comboBox_emp_perf.setVisible(true);
						comboBox_emp_perf.setSelectedItem(temp.get(6));

						String[][] temp2 = employee.show_table(text_emp_empID.getText());
						String[] column_names = { "Emp. ID", "Name", "Address", "Phone Num", "Perf.", "Super. ID",
								"Name" };

						DefaultTableModel emp_table_model = new DefaultTableModel(temp2, column_names);
						emp_table.setModel(emp_table_model);
						emp_table.getColumnModel().getColumn(4).setPreferredWidth(25);
						emp_table.getColumnModel().getColumn(6).setPreferredWidth(110);
						emp_table.getColumnModel().getColumn(3).setPreferredWidth(110);
						emp_table.setVisible(true);
						scrollpane.setVisible(true);
						btn_show_more.setVisible(true);

						if (Term_project_main.supervisor_check)

							btn_emp_execute.setVisible(true);

						else
							btn_emp_execute.setVisible(false);

						if (function.equals("Show & Adjust"))
							lbl_emp_info.setText("Data loaded");
						else
							lbl_emp_info.setText(
									"the projects and subordinates in his/her charge will be transfered to the supervisor automatically");
						lbl_emp_info.setVisible(true);

					} else {
						// temp.size()==0
						lbl_emp_info.setText("Data no found");
						lbl_emp_info.setVisible(true);

						lbl_empID_show.setText("");

						lbl_empID_show.setVisible(false);
						text_emp_empID.setVisible(true);

						lbl_emp_first.setVisible(false);
						text_emp_first.setVisible(false);
						text_emp_first.setText("");

						lbl_emp_last.setVisible(false);
						text_emp_last.setVisible(false);
						text_emp_last.setText("");

						lbl_emp_addr.setVisible(false);
						text_emp_addr.setVisible(false);
						text_emp_addr.setText("");

						lbl_emp_phone.setVisible(false);
						text_emp_phone.setVisible(false);
						text_emp_phone.setText("");

						lbl_emp_supervID.setVisible(false);
						text_emp_supervID.setVisible(false);
						text_emp_supervID.setText("");

						lbl_emp_perf.setVisible(false);
						comboBox_emp_perf.setVisible(false);

						btn_emp_execute.setVisible(false);

						emp_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);

						btn_clear.setVisible(false);

					}
				} catch (NumberFormatException ex) {
					// handle exception here
					lbl_emp_info.setText("Format Invalid");
					lbl_emp_info.setVisible(true);

					lbl_empID_show.setText("");
					;
					lbl_empID_show.setVisible(false);
					text_emp_empID.setVisible(true);

					lbl_emp_first.setVisible(false);
					text_emp_first.setVisible(false);
					text_emp_first.setText("");

					lbl_emp_last.setVisible(false);
					text_emp_last.setVisible(false);
					text_emp_last.setText("");

					lbl_emp_addr.setVisible(false);
					text_emp_addr.setVisible(false);
					text_emp_addr.setText("");

					lbl_emp_phone.setVisible(false);
					text_emp_phone.setVisible(false);
					text_emp_phone.setText("");

					lbl_emp_supervID.setVisible(false);
					text_emp_supervID.setVisible(false);
					text_emp_supervID.setText("");

					lbl_emp_perf.setVisible(false);
					comboBox_emp_perf.setVisible(false);

					btn_emp_execute.setVisible(false);

					btn_clear.setVisible(false);

					emp_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);

				}
			}
		});
		employee_panel.add(btn_emp_confirmID);

		btn_emp_execute = new JButton(); // btn_save_change. btn_add and btn_delete
		btn_emp_execute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Employee employee = new Employee();

				boolean emp_check = (text_emp_supervID.getText().isBlank()
						| ((!text_emp_supervID.getText().isBlank()) & employee.emp_check(text_emp_supervID)));

				boolean blanks_in_JTextFields = (text_emp_first.getText().isBlank() | text_emp_last.getText().isBlank()
						| text_emp_addr.getText().isBlank() | text_emp_phone.getText().isBlank());

				

				if (btn_emp_execute.getText().equalsIgnoreCase("Save Change")) {

					if (emp_check) {
						if (blanks_in_JTextFields) {

							lbl_emp_info.setText("Employee infos cannot be blank.");
							lbl_emp_info.setVisible(true);

						} else {
							String[] input = { text_emp_first.getText(), text_emp_last.getText(), text_emp_addr.getText(),
									text_emp_phone.getText(), text_emp_supervID.getText(),
									(String) comboBox_emp_perf.getSelectedItem(), lbl_empID_show.getText() };
							if (employee.save_change(input) == 1) {

								lbl_emp_info.setText("Modification succeed");
								lbl_emp_info.setVisible(true);

							} else {
								// save_change(text_emp_empID)==0
								lbl_emp_info.setText("Modification failed");
								lbl_emp_info.setVisible(true);
							}
						}

					} else {
						lbl_emp_info.setText("Supervisor ID is not in Employee table or format invalid.");
						lbl_emp_info.setVisible(true);
					}
				} else if (btn_emp_execute.getText().equalsIgnoreCase("Delete")) {

					int result = employee.delete_emp(text_emp_empID.getText());
					if (result == 1) {

						btn_clear.setVisible(false);

						lbl_emp_info.setVisible(false);
						lbl_empID_show.setVisible(false);
						text_emp_empID.setVisible(true);
						clear_text();
						set_visible(false);
						lbl_emp_info.setText("Request succeed");
						lbl_emp_info.setVisible(true);

					} else {
						// result<0
						btn_clear.setVisible(false);

						lbl_emp_info.setVisible(false);
						lbl_empID_show.setVisible(false);
						text_emp_empID.setVisible(true);
						clear_text();
						set_visible(false);
						if (result == -1)
							lbl_emp_info.setText("Request failed, errors occured.");
						else // result==-2
							lbl_emp_info.setText(
									"Request failed,you should re-assign manually his works to someone else first");
						lbl_emp_info.setVisible(true);
					}
				} else if (btn_emp_execute.getText().equalsIgnoreCase("Add")) {

					if (emp_check) {

						if (blanks_in_JTextFields) {

							lbl_emp_info.setText("Employee infos cannot be blank.");
							lbl_emp_info.setVisible(true);

						} else {
							String[] input = { text_emp_first.getText(), text_emp_last.getText(), text_emp_addr.getText(),
									text_emp_phone.getText(), text_emp_supervID.getText(),
									(String) comboBox_emp_perf.getSelectedItem() };
							String temp = employee.add(input);

							if (temp != null) {

								lbl_emp_info.setText("Employee added");
								lbl_emp_info.setVisible(true);

								text_emp_empID.setVisible(false);
								lbl_empID_show.setText(temp);
								lbl_empID_show.setVisible(true);

							} else {
								// add()==0
								lbl_emp_info.setText("Request failed");
								lbl_emp_info.setVisible(true);
							}
						}

					} else {
						lbl_emp_info.setText("Supervisor ID is not in Employee table or format invalid.");
						lbl_emp_info.setVisible(true);
					}
				}

			}
		});
		btn_emp_execute.setBounds(605, 236, 114, 29);
		btn_emp_execute.setVisible(false);
		employee_panel.add(btn_emp_execute);

		btn_show_more = new JButton("Show more");
		btn_show_more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Employee employee = new Employee();
				String[][] temp = employee.show_more(text_emp_empID.getText());

				if (temp == null) {

					lbl_emp_info.setText("the emp. whom you inquire doesn't participate any project.");
					lbl_emp_info.setVisible(true);

				} else {
					// temp!=null

					String[] column_names = { "Emp. ID", "Name", "Project ID", "P.status", "Est. Date" };

					JScrollPane scrollpane = new JScrollPane();
					JTable table = new JTable() {
						@Override
						public boolean isCellEditable(int row, int column) {
							return false;
						}// uneditable
					};

					DefaultTableModel emp_table_model = new DefaultTableModel(temp, column_names);
					table.setModel(emp_table_model);
					scrollpane.setPreferredSize(new Dimension(600, 125));
					scrollpane.setViewportView(table);
					// table.getColumnModel().getColumn(4).setPreferredWidth(30);
					JOptionPane.showMessageDialog(null, scrollpane, "Employees' infos of the projects", 1);

				}

			}
		});
		btn_show_more.setBounds(734, 264, 100, 29);
		employee_panel.add(btn_show_more);

	}

	void clear_text() {

		/**
		 * @author Ray
		 * @since 05/25/2021
		 * 
		 *        clear all input in JTextField
		 * 
		 * 
		 * @editor jyun-an
		 * @since 06/28/2021
		 */

		text_emp_empID.setText("");
		text_emp_first.setText("");
		text_emp_last.setText("");
		text_emp_addr.setText("");
		text_emp_phone.setText("");
		text_emp_supervID.setText("");
		comboBox_emp_perf.setSelectedIndex(0);

		/**
		 * @editor: jyun an
		 * 
		 * @since: 06/09/2021
		 */
		lbl_empID_show.setText("");
		lbl_emp_info.setText("");
	}

	void set_visible(boolean bl) {

		lbl_emp_first.setVisible(bl);
		text_emp_first.setVisible(bl);

		lbl_emp_last.setVisible(bl);
		text_emp_last.setVisible(bl);

		lbl_emp_addr.setVisible(bl);
		text_emp_addr.setVisible(bl);

		lbl_emp_phone.setVisible(bl);
		text_emp_phone.setVisible(bl);

		lbl_emp_supervID.setVisible(bl);
		text_emp_supervID.setVisible(bl);

		lbl_emp_perf.setVisible(bl);
		comboBox_emp_perf.setVisible(bl);

		btn_emp_execute.setVisible(bl);

		emp_table.setVisible(bl);
		scrollpane.setVisible(bl);
		btn_show_more.setVisible(bl);

	}

	JComboBox get_comboBox_employeeAction() {

		return comboBox_emp_action;
	}

}
