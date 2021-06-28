package test;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Maint_maint_panel {

	private JPanel maint_panel;
	private JTextField text_maint_pjID;
	private JLabel lbl_maint_pjID_show;
	private JLabel lbl_maint_empID;
	private JTextField text_maint_empID;
	private JLabel lbl_maint_date;
	private JTextField text_maint_date;
	private JLabel lbl_maint_status;
	private JLabel lbl_maint_pjID;
	private JLabel lbl_maint_emp_name;
	private JLabel lbl_maint_emp_name_show;
	private JLabel lbl_maint_status_show;
	private JLabel lbl_date_default;
	private JLabel lbl_maint_result;
	private JLabel lbl_maint_ins;
	private JButton btn_maint;
	private JButton btn_maint_check;
	private JButton btn_clear;

	Maint_maint_panel() {
		// Second panel - Maintenance

		maint_panel = new JPanel();
		maint_panel.setBounds(0, 0, 666, 348);
		Maintenance_panel.maint_container_panel.add(maint_panel, "Maintenance");
		maint_panel.setLayout(null);

		lbl_maint_pjID = new JLabel("*Project ID :");
		lbl_maint_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_maint_pjID.setBounds(350, 59, 86, 16);
		maint_panel.add(lbl_maint_pjID);

		text_maint_pjID = new JTextField();
		text_maint_pjID.setHorizontalAlignment(SwingConstants.CENTER);
		text_maint_pjID.setBounds(448, 54, 130, 30);
		maint_panel.add(text_maint_pjID);
		text_maint_pjID.setColumns(10);

		lbl_maint_pjID_show = new JLabel("");
		lbl_maint_pjID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_maint_pjID_show.setBounds(448, 59, 130, 25);
		lbl_maint_pjID_show.setVisible(false);
		maint_panel.add(lbl_maint_pjID_show);

		lbl_maint_empID = new JLabel("*Employee ID :");
		lbl_maint_empID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_maint_empID.setBounds(330, 103, 106, 16);
		maint_panel.add(lbl_maint_empID);

		text_maint_empID = new JTextField();
		text_maint_empID.setHorizontalAlignment(SwingConstants.CENTER);
		text_maint_empID.setBounds(448, 96, 130, 30);
		maint_panel.add(text_maint_empID);
		text_maint_empID.setColumns(10);

		lbl_maint_emp_name = new JLabel("Employee Name :");
		lbl_maint_emp_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_maint_emp_name.setBounds(299, 145, 137, 16);
		maint_panel.add(lbl_maint_emp_name);

		lbl_maint_emp_name_show = new JLabel("");
		lbl_maint_emp_name_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_maint_emp_name_show.setBounds(448, 138, 130, 30);
		maint_panel.add(lbl_maint_emp_name_show);

		lbl_maint_date = new JLabel("Est. Date :");
		lbl_maint_date.setBounds(330, 182, 108, 16);
		lbl_maint_date.setHorizontalAlignment(SwingConstants.RIGHT);
		maint_panel.add(lbl_maint_date);

		text_maint_date = new JTextField();
		text_maint_date.setHorizontalAlignment(SwingConstants.CENTER);
		text_maint_date.setBounds(448, 175, 130, 30);
		maint_panel.add(text_maint_date);
		text_maint_date.setColumns(10);

		lbl_date_default = new JLabel("YYYY-MM-DD ");
		lbl_date_default.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_date_default.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		lbl_date_default.setBounds(458, 209, 108, 25);
		maint_panel.add(lbl_date_default);

		lbl_maint_status = new JLabel("Project Status :");
		lbl_maint_status.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_maint_status.setBounds(334, 243, 102, 16);
		maint_panel.add(lbl_maint_status);

		lbl_maint_status_show = new JLabel("NNNN");
		lbl_maint_status_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_maint_status_show.setBounds(448, 240, 130, 23);
		maint_panel.add(lbl_maint_status_show);

		lbl_maint_result = new JLabel("");
		lbl_maint_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_maint_result.setBounds(330, 313, 367, 43);
		maint_panel.add(lbl_maint_result);

		lbl_maint_ins = new JLabel("*obligatory");
		lbl_maint_ins.setBounds(208, 59, 93, 16);
		lbl_maint_ins.setVisible(true);
		maint_panel.add(lbl_maint_ins);

		btn_maint = new JButton("");
		btn_maint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btn_maint.getText().equalsIgnoreCase("Modify")) {

					if (Term_project_main.lib.date(text_maint_date.getText())) {

						if (modify() == 1) {
							// send message to user modify succeed
							lbl_maint_result.setText("Modification succeed");
							lbl_maint_result.setVisible(true);
						} else {
							// send message to user modify failed
							lbl_maint_result.setText("Modification failed");
							lbl_maint_result.setVisible(true);
						}

					} else {
						// handle exception here

						lbl_maint_result.setText("Date format Invalid");
						lbl_maint_result.setVisible(true);
					}

				} else if (btn_maint.getText().equalsIgnoreCase("Append")) {

					if (Term_project_main.lib.emp_check(text_maint_empID)) {

						if (!(text_maint_date.getText().isBlank())) {

							if (Term_project_main.lib.date(text_maint_date.getText())) {

								ArrayList<String> temp = append();

								if (temp.size() != 0) {
									// send message to user modify succeed
									lbl_maint_result.setText("Request succeed");
									lbl_maint_result.setVisible(true);
									lbl_maint_pjID_show.setText(temp.get(0));
									lbl_maint_pjID_show.setVisible(true);
									lbl_maint_emp_name_show.setText(temp.get(2));
									lbl_maint_emp_name_show.setVisible(true);
									lbl_maint_status_show.setText(temp.get(4));
									lbl_maint_status_show.setVisible(true);

								} else {
									// send message to user modify failed
									lbl_maint_result.setText("Request failed. Check data again please");
									lbl_maint_result.setVisible(true);
								}
							} else {
								lbl_maint_result.setText("Date format Invalid");
								lbl_maint_result.setVisible(true);
							}
						} else if (text_maint_date.getText().isBlank()) {

							ArrayList<String> temp = append();

							if (temp.size() != 0) {
								// send message to user modify succeed
								lbl_maint_result.setText("Request succeed");
								lbl_maint_result.setVisible(true);
								lbl_maint_pjID_show.setText(temp.get(0));
								lbl_maint_pjID_show.setVisible(true);
								lbl_maint_emp_name_show.setText(temp.get(2));
								lbl_maint_emp_name_show.setVisible(true);
								text_maint_date.setText(temp.get(3));
								lbl_maint_status_show.setText(temp.get(4));
								lbl_maint_status_show.setVisible(true);

							} else {
								// send message to user modify failed
								lbl_maint_result.setText("Request failed. Check data again please");
								lbl_maint_result.setVisible(true);
							}
						}
					} else {
						// handle exception here

						lbl_maint_result.setText("Employee ID Invalid");
						lbl_maint_result.setVisible(true);
					}

				} else if (btn_maint.getText().equalsIgnoreCase("Delete")) {

					if (delete() != 0) {
						// send message to user modify succeed
						lbl_maint_result.setText("Request succeed");
						lbl_maint_result.setVisible(true);

					} else if (delete() == 0) {
						// send message to user modify failed

						lbl_maint_result.setVisible(true);
					}
				}
			}
		});
		btn_maint.setBounds(678, 218, 87, 29);
		maint_panel.add(btn_maint);

		btn_maint_check = new JButton("Check ");
		btn_maint_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Integer.parseInt(text_maint_pjID.getText());

					ArrayList<String> temp = check_ID(text_maint_pjID);

//						ArrayList<String> temp = new ArrayList();  // test data
//						temp.addAll(Arrays.asList(new String[] {"90000007","11047637","2021-03-10","RCPT",""})); // test data

					if (temp.size() == 0) {

						btn_maint.setVisible(false);
						btn_clear.setVisible(false);

						btn_maint_check.setVisible(true);
						lbl_maint_ins.setVisible(true);

						lbl_maint_pjID.setVisible(true);
						text_maint_pjID.setVisible(true); // let projectID be uneditable

						lbl_maint_pjID_show.setVisible(false);
						lbl_maint_result.setText("no found");
						lbl_maint_result.setVisible(true);
						set_visible(false);

					} else {
						// temp.size() != 0

						set_visible(true);
						lbl_maint_pjID_show.setText(text_maint_pjID.getText());
						text_maint_empID.setText(temp.get(1));
						lbl_maint_emp_name_show.setText(temp.get(2));
						text_maint_date.setText(temp.get(3));
						lbl_maint_status_show.setText(temp.get(4));

						btn_clear.setVisible(true);
						text_maint_pjID.setText("");
						text_maint_pjID.setVisible(false); // let projectID be uneditable
						lbl_maint_pjID_show.setVisible(true);
						lbl_maint_result.setText("Data loading succeed");
						lbl_maint_result.setVisible(true);
						btn_maint.setVisible(true);
					}

				} catch (NumberFormatException ex) {
					// handle exception here

					btn_maint.setVisible(false);
					btn_clear.setVisible(false);

					btn_maint_check.setVisible(true);
					lbl_maint_ins.setVisible(true);

					lbl_maint_pjID.setVisible(true);
					text_maint_pjID.setVisible(true);
					set_visible(false);

					lbl_maint_result.setText(" Project ID format Invalid");
					lbl_maint_result.setVisible(true);

				}

			}
		});
		btn_maint_check.setBounds(616, 54, 78, 29);
		maint_panel.add(btn_maint_check);

		btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_maint_panel();

				if (Maintenance_panel.comboBox_pj.getSelectedItem().equals("Modify")
						| (Maintenance_panel.comboBox_pj.getSelectedItem().equals("Delete"))) {

					btn_maint.setVisible(false);
					btn_clear.setVisible(false);
					lbl_maint_result.setVisible(false);

					btn_maint_check.setVisible(true);
					lbl_maint_ins.setVisible(true);

					lbl_maint_pjID.setVisible(true);
					text_maint_pjID.setVisible(true);
					set_visible(false);
				}
			}
		});
		btn_clear.setBounds(695, 54, 86, 29);
		maint_panel.add(btn_clear);

	}

	void clear_maint_panel() {

		lbl_maint_pjID_show.setText("");
		text_maint_pjID.setText("");
		text_maint_empID.setText("");
		lbl_maint_emp_name_show.setText("");
		text_maint_date.setText("");

		lbl_maint_status_show.setText("");
		lbl_maint_result.setText("");

	}

	void set_default_visible(String st) {

		switch (st) {

		case "Modify":

			btn_maint.setText(st);
			btn_maint.setVisible(false);
			btn_clear.setVisible(false);
			btn_maint_check.setVisible(true);
			lbl_maint_ins.setVisible(true);
			lbl_maint_pjID.setVisible(true);
			text_maint_pjID.setVisible(true);
			set_visible(false);
			clear_maint_panel();
			break;

		case "Append":

			btn_maint.setText(st);
			text_maint_pjID.setVisible(false);
			btn_maint_check.setVisible(false);
			btn_maint.setVisible(true);
			btn_clear.setVisible(true);
			set_visible(true);
			clear_maint_panel();
			break;

		case "Delete":

			btn_maint.setText(st);

			text_maint_pjID.setVisible(true);
			btn_maint_check.setVisible(true);
			btn_clear.setVisible(false);
			btn_maint.setVisible(false);
			set_visible(false);
			clear_maint_panel();
			break;

		default:
			break;
		}
	}

	private void set_visible(boolean bl) {

		lbl_maint_empID.setVisible(bl);
		text_maint_empID.setVisible(bl);

		lbl_maint_emp_name.setVisible(bl);
		lbl_maint_emp_name_show.setVisible(bl);

		lbl_maint_date.setVisible(bl);
		text_maint_date.setVisible(bl);

		lbl_date_default.setVisible(bl);

		lbl_maint_status.setVisible(bl);
		lbl_maint_status_show.setVisible(bl);

	}

	private int modify() {
		/**
		 * @Author jyun-an
		 * @since 06/03/2021 to MODIFY data in PROJECT table
		 **/
		int resultSet = 0;

		if (text_maint_empID.getText().isBlank() | (!(Term_project_main.lib.emp_check(text_maint_empID)))
				| text_maint_date.getText().isBlank()) {

			return resultSet;
		}

		try {
			resultSet = Term_project_main.conn.st
					.executeUpdate("UPDATE PROJECT SET Emp_ID=" + text_maint_empID.getText() + ", Established_date=\'"
							+ text_maint_date.getText() + "\' WHERE Project_ID=" + lbl_maint_pjID_show.getText());

			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return resultSet;
		}

	}

	private ArrayList<String> append() {
		/**
		 * @Author jyun-an
		 * @since 06/03/2021 to ADD data in PROJECT table
		 **/
		int resultSet = 0;
		ArrayList<String> temp = new ArrayList();

		if (text_maint_date.getText().isBlank()) {
			try {
				resultSet = Term_project_main.conn.st
						.executeUpdate("INSERT INTO PROJECT (Emp_ID, Project_status) VALUE ("
								+ text_maint_empID.getText() + ", 'just started')");

				if (resultSet == 1) {

					ResultSet add_result = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, pj.Emp_ID,"
							+ "CONCAT(`emp`.`First_name`, ' ', `emp`.`Last_name`) AS `Name`,"
							+ " pj.Established_date, pj.Project_status FROM test.PROJECT AS pj "
							+ "LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID ORDER BY Project_ID DESC LIMIT 1");
					if (add_result.next()) {
						for (int i = 1; i < 6; i++) {
							temp.add(add_result.getString(i));
						}
					}

					return temp;

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}

		} else if (!(text_maint_date.getText().isBlank())) {
			// !(text_maint_date.getText().isBlank())
			try {
				resultSet = Term_project_main.conn.st
						.executeUpdate("INSERT INTO test.PROJECT (Emp_ID, Established_date, Project_status) VALUE ("
								+ text_maint_empID.getText() + ", \'" + text_maint_date.getText()
								+ "\', \'just started\')");

				if (resultSet == 1) {

					ResultSet add_result = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, pj.Emp_ID,"
							+ "CONCAT(`emp`.`First_name`, ' ', `emp`.`Last_name`) AS `Name`,"
							+ " pj.Established_date, pj.Project_status FROM test.PROJECT AS pj "
							+ "LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID ORDER BY Project_ID DESC LIMIT 1");

					if (add_result.next()) {
						for (int i = 1; i < 6; i++) {
							temp.add(add_result.getString(i));
						}
					}

					return temp;

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
		}

		return temp;
	}

	private int delete() {

		int resultSet = 0;
		int resultSet2 = 0;

		try {

			ResultSet rs = Term_project_main.conn.st
					.executeQuery("SELECT * FROM test.INVENTORY WHERE Project_ID=" + lbl_maint_pjID_show.getText());

			if (rs.next()) {

				lbl_maint_result.setText(
						"You could not delete a project with purchasing inventory\n which means it's already/almost finished");
				return resultSet + resultSet2;

			}
			resultSet = Term_project_main.conn.st.executeUpdate("DELETE RFQ, QUOT, REQ,PUR,EXAM,RCPT, INV "
					+ "FROM test.PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
					+ "LEFT JOIN test.QUOTATION AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
					+ "LEFT JOIN test.REQUISITION AS REQ ON REQ.Project_ID = pj.Project_ID\n"
					+ "LEFT JOIN test.PURCHASE AS PUR ON PUR.Project_ID = pj.Project_ID\n"
					+ "LEFT JOIN test.EXAMINATION AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
					+ "LEFT JOIN test.RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID \n"
					+ "LEFT JOIN test.INVENTORY AS INV ON INV.Project_ID = pj.Project_ID WHERE pj.Project_ID="
					+ lbl_maint_pjID_show.getText());

			resultSet2 = Term_project_main.conn.st
					.executeUpdate("DELETE FROM PROJECT WHERE Project_ID=" + lbl_maint_pjID_show.getText());

			return resultSet + resultSet2;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			lbl_maint_result.setText("Request failed.\n Please check data again");
			return resultSet + resultSet2;
		}

	}

	private ArrayList<String> check_ID(JTextField ID) {

		ArrayList<String> temp = new ArrayList();

		try {
			ResultSet resultSet = Term_project_main.conn.st
					.executeQuery("SELECT pj.Project_ID, pj.Emp_ID,CONCAT(`emp`.`First_name`,"
							+ " ' ', `emp`.`Last_name`) AS `Name`, pj.Established_date, pj.Project_status FROM test.PROJECT AS pj "
							+ "LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID WHERE Project_ID="
							+ ID.getText());

			if (resultSet.next()) {

				for (int i = 1; i < 6; i++) {
					temp.add(resultSet.getString(i));
					// System.out.print(resultSet.getString(i));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp;
	}

}
