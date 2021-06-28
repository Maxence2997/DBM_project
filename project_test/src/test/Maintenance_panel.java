package test;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.Font;

class Maintenance_panel {

	/**
	 * @autohr Jyun-An @ver. 1.2.2 05/28 Seperated from Project_test
	 **/

	private JPanel core_maint_panel;
	static JPanel maint_container_panel;
	static JComboBox comboBox_pj;

	private JPanel default_panel;

	private JPanel inq_panel;
	private JTable inq_table;
	private JScrollPane scrollpane;
	private JLabel lbl_result;
	private JLabel lbl_inq_date_format;
	private JTextField text_inq_date;
	private JTextField text_inq_pjID;
	private JTextField text_inq_empID;
	private Maint_maint_panel maint_panel;

	private CardLayout cl_maint;

	/**
	 * @wbp.parser.entryPoint
	 */
	Maintenance_panel() {

		// core sheet panel which contains comboBox
		core_maint_panel = new JPanel();
		core_maint_panel.setBounds(0, 26, 1000, 450);
		Term_project_main.container_panel.add(core_maint_panel, "maintenance");
		core_maint_panel.setLayout(null);

		// smaller panel on the core maint panel
		cl_maint = new CardLayout();
		maint_container_panel = new JPanel(cl_maint);

		maint_container_panel.setBounds(0, 35, 1000, 380);
		maint_container_panel.setBackground(Color.CYAN);
		core_maint_panel.add(maint_container_panel);

		// add 5 sub project maintenance panels

		// default panel
		default_panel = new JPanel();
		default_panel.setBounds(0, 0, 666, 348);
		maint_container_panel.add(default_panel, "-----------");
		default_panel.setLayout(null);

		add_inquire_panel();
		maint_panel = new Maint_maint_panel();

		comboBox_pj = new JComboBox(new String[] { "-----------", "Inquire", "Modify", "Append", "Delete" });
		comboBox_pj.setBounds(435, 5, 159, 27);

		comboBox_pj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String function = (String) comboBox_pj.getSelectedItem(); // get the selected item

				switch (function) {

				case "Modify":

					cl_maint.show(maint_container_panel, "Maintenance");
					maint_panel.set_default_visible("Modify");

					break;

				case "Append":

					cl_maint.show(maint_container_panel, "Maintenance");
					maint_panel.set_default_visible("Append");

					break;

				case "Delete":

					cl_maint.show(maint_container_panel, "Maintenance");
					maint_panel.set_default_visible("Delete");

					break;

				default:
					// inquire
					cl_maint.show(maint_container_panel, function);
					lbl_result.setVisible(false);
					inq_table.setVisible(false);
					scrollpane.setVisible(false);

					break;

				}
				// cl_maint.show(maint_container_panel, function);
			}
		});

		core_maint_panel.add(comboBox_pj);

		JButton btn_back2pj = new JButton("");
		btn_back2pj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
			}
		});
		Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
		go_back = go_back.getScaledInstance(21, 21, java.awt.Image.SCALE_AREA_AVERAGING);
		btn_back2pj.setIcon(new ImageIcon(go_back));
		btn_back2pj.setBounds(16, 4, 30, 30);
		core_maint_panel.add(btn_back2pj);

		JLabel lbl_maint = new JLabel("Maintenance");
		lbl_maint.setBounds(58, 11, 87, 16);
		core_maint_panel.add(lbl_maint);
	}

	// first panel - Inquire
	private void add_inquire_panel() {

		inq_panel = new JPanel();
		inq_panel.setBounds(0, 0, 666, 348);
		maint_container_panel.add(inq_panel, "Inquire");
		inq_panel.setLayout(null);

		JLabel lbl_inq_pjID = new JLabel("Project ID :");
		lbl_inq_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_inq_pjID.setBounds(250, 45, 86, 16);
		inq_panel.add(lbl_inq_pjID);

		text_inq_pjID = new JTextField();
		text_inq_pjID.setHorizontalAlignment(SwingConstants.CENTER);
		text_inq_pjID.setBounds(336, 40, 141, 26);
		inq_panel.add(text_inq_pjID);
		text_inq_pjID.setColumns(10);

		JLabel lbl_inq_date = new JLabel("Est. Date :");
		lbl_inq_date.setBounds(230, 131, 106, 16);
		lbl_inq_date.setHorizontalAlignment(SwingConstants.RIGHT);
		inq_panel.add(lbl_inq_date);

		text_inq_date = new JTextField();
		text_inq_date.setHorizontalAlignment(SwingConstants.CENTER);
		text_inq_date.setBounds(336, 126, 141, 26);
		inq_panel.add(text_inq_date);
		text_inq_date.setColumns(10);

		JLabel lbl_inq_empID = new JLabel("Employee ID :");
		lbl_inq_empID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_inq_empID.setBounds(250, 88, 86, 16);
		inq_panel.add(lbl_inq_empID);

		text_inq_empID = new JTextField();
		text_inq_empID.setHorizontalAlignment(SwingConstants.CENTER);
		text_inq_empID.setBounds(336, 84, 141, 26);
		inq_panel.add(text_inq_empID);
		text_inq_empID.setColumns(10);

		JButton btn_inq_inquire = new JButton("Inquire");
		btn_inq_inquire.setBounds(564, 86, 87, 29);
		btn_inq_inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//					String [][] temp = {{"90000000","11047630","2021/3/3","EXAM",""}, {"90000008","11047638","2021/3/11","RCPT",""},
//												{"90000010","11047640","2021/3/13","EXAM",""}, {"90000013","11047643","2021/3/16","RCPT",""}};
				try {
					if (!text_inq_pjID.getText().isBlank())
						Integer.parseInt(text_inq_pjID.getText());

					if (!text_inq_empID.getText().isBlank())
						Integer.parseInt(text_inq_empID.getText());

					if (!text_inq_date.getText().isBlank()) {
						if (Term_project_main.lib.date(text_inq_date.getText())) {

							String[][] temp = inquire(text_inq_pjID, text_inq_empID, text_inq_date);

							if (temp.length != 0) {

								String[] columns_name = { "Project ID", "Employee ID", "E.Name", "Status", "Product",
										"RFQ ID", "QUOT. ID", "REQ. ID", "PUR. ID", "EXAM. ID", "RCPT ID",
										"Est. Date" };
								DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
								inq_table.setModel(inq_table_model);

								TableColumnModel column_model = inq_table.getColumnModel();
								inq_table.setVisible(true);
								scrollpane.setVisible(true);
								lbl_result.setText("Data load succeed");
								lbl_result.setVisible(true);

							} else {
								lbl_result.setText("no found");
								lbl_result.setVisible(true);
								inq_table.setVisible(false);
								scrollpane.setVisible(false);
							}
						} else {
							lbl_result.setText("date format Invalid");
							lbl_result.setVisible(true);
							inq_table.setVisible(false);
							scrollpane.setVisible(false);
						}

					} else {
						// text_inq_date.getText().isBlank()
						String[][] temp = inquire(text_inq_pjID, text_inq_empID, text_inq_date);

						if (temp.length != 0) {

							String[] columns_name = { "Project ID", "Employee ID", "Name", "Status", "Product",
									"RFQ ID", "QUOT. ID", "REQ. ID", "PUR. ID", "EXAM. ID", "RCPT ID", "Est. Date" };
							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);

							inq_table.getColumnModel().getColumn(2).setPreferredWidth(100);
							inq_table.getColumnModel().getColumn(3).setPreferredWidth(50);
							inq_table.getColumnModel().getColumn(4).setPreferredWidth(70);
							inq_table.getColumnModel().getColumn(11).setPreferredWidth(90);

							inq_table.setVisible(true);
							scrollpane.setVisible(true);
							lbl_result.setText("Data load succeed");
							lbl_result.setVisible(true);

						} else {
							lbl_result.setText("no found");
							lbl_result.setVisible(true);
							inq_table.setVisible(false);
							scrollpane.setVisible(false);
						}
					}
				} catch (NumberFormatException ex) {
					// handle exception here

					lbl_result.setText("Format Invalid");
					lbl_result.setVisible(true);
					inq_table.setVisible(false);
					scrollpane.setVisible(false);
				}
			}
		});
		inq_panel.add(btn_inq_inquire);

		JButton btn_inq_last20 = new JButton("Last 20");
		btn_inq_last20.setBounds(564, 126, 87, 29);
		btn_inq_last20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[] columns_name = { "Project ID", "Employee ID", "Name", "Status", "Product", "RFQ ID",
						"QUOT. ID", "REQ. ID", "PUR. ID", "EXAM. ID", "RCPT ID", "Est. Date" };

				String[][] temp = last_20();

				DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
				inq_table.setModel(inq_table_model);

				inq_table.getColumnModel().getColumn(2).setPreferredWidth(100);
				inq_table.getColumnModel().getColumn(3).setPreferredWidth(50);
				inq_table.getColumnModel().getColumn(4).setPreferredWidth(80);
				inq_table.getColumnModel().getColumn(11).setPreferredWidth(90);
				inq_table.setVisible(true);
				scrollpane.setVisible(true);
				lbl_result.setText("Data load succeed");
			}
		});
		inq_panel.add(btn_inq_last20);

		lbl_result = new JLabel("");
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setBounds(132, 186, 565, 16);
		inq_panel.add(lbl_result);

		inq_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable

		};
		inq_table.setBounds(29, 195, 612, 153);
		// inq_panel.add(inq_table);
		inq_table.setVisible(false);

		scrollpane = new JScrollPane(inq_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(49, 228, 900, 135);
		scrollpane.setVisible(false);
		inq_panel.add(scrollpane);

		lbl_inq_date_format = new JLabel("YYYY-MM-DD");
		lbl_inq_date_format.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lbl_inq_date_format.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_inq_date_format.setBounds(336, 151, 141, 16);
		lbl_inq_date_format.setVisible(true);
		inq_panel.add(lbl_inq_date_format);
	}

	private String[][] inquire(JTextField projectID, JTextField empID, JTextField est_date) {

		/**
		 * @author jyunanyang
		 * @since 06/02/2021 pass in 3 JTextFields and use switch case to handle every
		 *        situation which they are filled in or not.
		 */

		final String st_inquire = "SELECT * FROM VIEW_PROJECT";

		ArrayList<String[]> temp = new ArrayList();

		switch (Term_project_main.lib.check_text_fields(projectID, empID, est_date)) {

		case "111":

			try {
				ResultSet resultSet = Term_project_main.conn.st
						.executeQuery(st_inquire + " WHERE (Project_ID=" + projectID.getText() + " AND Emp_ID="
								+ empID.getText() + " AND Est_date=\'" + est_date.getText() + "\')");

				if (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "110":

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire + " WHERE (Project_ID="
						+ projectID.getText() + " AND Emp_ID=" + empID.getText() + ")");

				while (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "101":

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire + " WHERE (Project_ID="
						+ projectID.getText() + " AND Est_date=\'" + est_date.getText() + "\')");

				while (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}

			} catch (SQLException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			break;

		case "100":

			try {
				ResultSet resultSet = Term_project_main.conn.st
						.executeQuery(st_inquire + " WHERE Project_ID=" + projectID.getText());

				if (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "011":

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire + " WHERE (Emp_ID="
						+ empID.getText() + " AND Est_date=\'" + est_date.getText() + "\')");

				while (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "010":

			try {
				ResultSet resultSet = Term_project_main.conn.st
						.executeQuery(st_inquire + " WHERE Emp_ID=" + empID.getText());
				while (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;

			} catch (SQLException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		default:

			try {
				ResultSet resultSet = Term_project_main.conn.st
						.executeQuery(st_inquire + " WHERE Est_date=\'" + est_date.getText() + "\'");

				while (resultSet.next()) {
					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;

			} catch (SQLException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

				break;
			}
		}
		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;
	}

	private String[][] last_20() {

		final String st_inquire = "SELECT * FROM VIEW_PROJECT";

		ArrayList<String[]> temp = new ArrayList();

		try {
			ResultSet resultSet = Term_project_main.conn.st
					.executeQuery(st_inquire + " ORDER BY Est_date DESC LIMIT 20");

			while (resultSet.next()) {
				String[] temp_array = new String[12];
				for (int i = 1; i < 13; i++) {
					temp_array[i - 1] = resultSet.getString(i);
				}
				temp.add(temp_array);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;

	}

	void clear_inq_panel() {

		text_inq_date.setText("");
		text_inq_pjID.setText("");
		text_inq_empID.setText("");

	}

	JComboBox get_comboBox_project() {

		return comboBox_pj;
	}

}
