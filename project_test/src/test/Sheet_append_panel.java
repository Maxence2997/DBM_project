package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

class Sheet_append_panel {

	private JPanel append_panel;
	private JLabel lbl_appd_1;
	private JTextField text_appd_1;
	private JLabel lbl_appd_2;
	private JTextField text_appd_2;
	private JLabel lbl_appd_3;
	private JTextField text_appd_3;
	private JLabel lbl_appd_4;
	private JTextField text_appd_4;
	private JLabel lbl_appd_5;
	private JTextField text_appd_5;
	private JLabel lbl_appd_6;
	private JTextField text_appd_6;
	private JLabel lbl_appd_7;
	private JTextField text_appd_7;
	private JButton btn_appd_append;
	private JScrollPane scrollpane_append;
	private JTable append_table;
	private JRadioButton rb_appd_RFQ;
	private JRadioButton rb_appd_QUO;
	private JRadioButton rb_appd_REQ;
	private JRadioButton rb_appd_PUR;
	private JRadioButton rb_appd_EXAM;
	private JRadioButton rb_appd_RCPT;
	private JLabel lbl_append_message;
	private JButton btn_append_clear;
	private JLabel lbl_appd_ins;

	// third panel - Append sheet
	Sheet_append_panel() {

		append_panel = new JPanel();
		append_panel.setBounds(0, 0, 666, 348);
		Sheets_panel.sheet_container_panel.add(append_panel, "Append");
		append_panel.setLayout(null);

		JLabel lbl_appd_type = new JLabel("*Sheet type:");
		lbl_appd_type.setBounds(167, 31, 85, 16);
		lbl_appd_type.setHorizontalAlignment(SwingConstants.RIGHT);
		append_panel.add(lbl_appd_type);

		lbl_appd_1 = new JLabel("");
		lbl_appd_1.setBounds(500, 26, 134, 16);
		lbl_appd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_1.setVisible(false);
		append_panel.add(lbl_appd_1);

		text_appd_1 = new JTextField();
		text_appd_1.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_1.setBounds(634, 21, 116, 26);
		text_appd_1.setVisible(false);
		append_panel.add(text_appd_1);
		text_appd_1.setColumns(10);

		lbl_appd_2 = new JLabel("");
		lbl_appd_2.setBounds(500, 59, 134, 16);
		lbl_appd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_2.setVisible(false);
		append_panel.add(lbl_appd_2);

		text_appd_2 = new JTextField();
		text_appd_2.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_2.setBounds(634, 54, 116, 26);
		text_appd_2.setVisible(false);
		append_panel.add(text_appd_2);
		text_appd_2.setColumns(10);

		lbl_appd_3 = new JLabel("");
		lbl_appd_3.setBounds(500, 90, 134, 16);
		lbl_appd_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_3.setVisible(false);
		append_panel.add(lbl_appd_3);

		text_appd_3 = new JTextField();
		text_appd_3.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_3.setBounds(634, 85, 116, 26);
		text_appd_3.setVisible(false);
		append_panel.add(text_appd_3);
		text_appd_3.setColumns(10);

		lbl_appd_4 = new JLabel("");
		lbl_appd_4.setBounds(500, 121, 134, 16);
		lbl_appd_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_4.setVisible(false);
		append_panel.add(lbl_appd_4);

		text_appd_4 = new JTextField();
		text_appd_4.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_4.setBounds(634, 116, 116, 26);
		text_appd_4.setVisible(false);
		append_panel.add(text_appd_4);
		text_appd_4.setColumns(10);

		lbl_appd_5 = new JLabel("");
		lbl_appd_5.setBounds(500, 152, 134, 16);
		lbl_appd_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_5.setVisible(false);
		append_panel.add(lbl_appd_5);

		text_appd_5 = new JTextField();
		text_appd_5.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_5.setBounds(634, 147, 116, 26);
		text_appd_5.setVisible(false);
		append_panel.add(text_appd_5);
		text_appd_5.setColumns(10);

		lbl_appd_6 = new JLabel("");
		lbl_appd_6.setBounds(500, 183, 134, 16);
		lbl_appd_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_6.setVisible(false);
		append_panel.add(lbl_appd_6);

		text_appd_6 = new JTextField();
		text_appd_6.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_6.setBounds(634, 178, 116, 26);
		text_appd_6.setVisible(false);
		append_panel.add(text_appd_6);
		text_appd_6.setColumns(10);

		lbl_appd_7 = new JLabel("");
		lbl_appd_7.setBounds(500, 215, 134, 16);
		lbl_appd_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_7.setVisible(false);
		append_panel.add(lbl_appd_7);

		text_appd_7 = new JTextField();
		text_appd_7.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_7.setBounds(634, 210, 116, 26);
		text_appd_7.setVisible(false);
		append_panel.add(text_appd_7);
		text_appd_7.setColumns(10);

		btn_appd_append = new JButton("Append");
		btn_appd_append.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (rb_appd_RFQ.isSelected()) {
					if (append_check("RFQ")) {
						if (Term_project_main.lib.projectID_check(text_appd_1)
								& Term_project_main.lib.module_check(text_appd_2)
								& Term_project_main.lib.supplier_check(text_appd_3)
								& Term_project_main.lib.num_not_null_check(text_appd_4)) {
							if ((!text_appd_5.getText().isBlank())
									& Term_project_main.lib.date(text_appd_5.getText())) {

								String[][] temp = append("RFQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier", "Product",
										"Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);
								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}

							} else if (text_appd_5.getText().isBlank()) {

								String[][] temp = append("RFQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier", "Product",
										"Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);
								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_5.getText().isBlank())
									& (!Term_project_main.lib.date(text_appd_5.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}

						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}

				} else if (rb_appd_QUO.isSelected()) {
					if (append_check("QUOT")) {
						if (Term_project_main.lib.projectID_check(text_appd_1)
								& Term_project_main.lib.module_check(text_appd_2)
								& Term_project_main.lib.supplier_check(text_appd_3)
								& Term_project_main.lib.num_not_null_check(text_appd_4)
								& Term_project_main.lib.num_not_null_check(text_appd_5)
								& Term_project_main.lib.date(text_appd_6.getText())) {
							if ((!text_appd_7.getText().isBlank())
									& Term_project_main.lib.date(text_appd_7.getText())) {

								String[][] temp = append("QUOT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Product", "Supplier",
										"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_7.getText().isBlank()) {

								String[][] temp = append("QUOT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Product", "Supplier",
										"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_7.getText().isBlank())
									& (!Term_project_main.lib.date(text_appd_7.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}

				} else if (rb_appd_REQ.isSelected()) {
					if (append_check("REQ")) {
						if (Term_project_main.lib.projectID_check(text_appd_1)
								& Term_project_main.lib.module_check(text_appd_2)
								& Term_project_main.lib.num_not_null_check(text_appd_4)
								& Term_project_main.lib.num_not_null_check(text_appd_5)
								& Term_project_main.lib.supervisor_check(text_appd_6)) {
							if ((!text_appd_7.getText().isBlank())
									& Term_project_main.lib.date(text_appd_7.getText())) {
								String[][] temp = append("REQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Item ", "Module", "Vol.",
										"Unit Price", "Total_price", "Signature", "Supervisor", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_7.getText().isBlank()) {

								String[][] temp = append("REQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Item ", "Module", "Vol.",
										"Unit Price", "Total_price", "Signature", "Supervisor", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_7.getText().isBlank())
									& (!Term_project_main.lib.date(text_appd_7.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}

				} else if (rb_appd_PUR.isSelected()) {
					if (append_check("PUR")) {
						if (Term_project_main.lib.projectID_check(text_appd_1)
								& Term_project_main.lib.supplier_check(text_appd_3)
								& Term_project_main.lib.module_check(text_appd_2)
								& Term_project_main.lib.num_not_null_check(text_appd_4)
								& Term_project_main.lib.num_not_null_check(text_appd_5)
								& Term_project_main.lib.date(text_appd_6.getText())) {
							if ((!text_appd_7.getText().isBlank())
									& Term_project_main.lib.date(text_appd_7.getText())) {

								String[][] temp = append("PUR");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module",
										"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_7.getText().isBlank()) {

								String[][] temp = append("PUR");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module",
										"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_7.getText().isBlank())
									& (!Term_project_main.lib.date(text_appd_7.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}
				} else if (rb_appd_EXAM.isSelected()) {
					if (append_check("EXAM")) {
						if (Term_project_main.lib.projectID_check(text_appd_1)
								& Term_project_main.lib.supplier_check(text_appd_3)
								& Term_project_main.lib.module_check(text_appd_2)
								& Term_project_main.lib.num_not_null_check(text_appd_4)
								& Term_project_main.lib.tf_check(text_appd_5)) {
							if ((!text_appd_6.getText().isBlank())
									& Term_project_main.lib.date(text_appd_6.getText())) {

								String[][] temp = append("EXAM");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module",
										"Vol.", "Result", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_6.getText().isBlank()) {
								String[][] temp = append("EXAM");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module",
										"Vol.", "Result", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_6.getText().isBlank())
									& (!Term_project_main.lib.date(text_appd_6.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}
				} else {
					// if (rb_appd_RCPT.isSelected()) {
					if (append_check("RCPT")) {
						if (Term_project_main.lib.projectID_check(text_appd_1)
								& Term_project_main.lib.supplier_check(text_appd_3)
								& Term_project_main.lib.module_check(text_appd_2)
								& Term_project_main.lib.num_not_null_check(text_appd_4)) {
							if ((!text_appd_5.getText().isBlank())
									& Term_project_main.lib.date(text_appd_5.getText())) {
								String[][] temp = append("RCPT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module",
										"Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_5.getText().isBlank()) {

								String[][] temp = append("RCPT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module",
										"Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_5.getText().isBlank())
									& (!Term_project_main.lib.date(text_appd_5.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}
				}
			}
		});
		btn_appd_append.setBounds(784, 21, 92, 29);
		btn_appd_append.setVisible(false);
		append_panel.add(btn_appd_append);

		ButtonGroup bg = new ButtonGroup();

		rb_appd_RFQ = new JRadioButton("R.F.Q");
		rb_appd_RFQ.setBounds(256, 28, 110, 23);
		append_panel.add(rb_appd_RFQ);
		rb_appd_RFQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Inquiring Product :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("Date :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("");
				lbl_appd_6.setVisible(false);
				text_appd_6.setVisible(false);

				lbl_appd_7.setText("");
				lbl_appd_7.setVisible(false);
				text_appd_7.setVisible(false);

				lbl_appd_ins.setVisible(true);
				btn_append_clear.setVisible(true);
				btn_appd_append.setVisible(true);

				append_table.setVisible(false);
				scrollpane_append.setVisible(false);

			}
		});
		bg.add(rb_appd_RFQ);

		rb_appd_QUO = new JRadioButton("Quotation");
		rb_appd_QUO.setBounds(256, 60, 110, 23);
		append_panel.add(rb_appd_QUO);

		rb_appd_QUO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Inquiring Product :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("*Unit Price :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("*ESD :");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("Date :");
				lbl_appd_7.setVisible(true);
				text_appd_7.setVisible(true);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

				append_table.setVisible(false);
				scrollpane_append.setVisible(false);

			}
		});
		bg.add(rb_appd_QUO);

		rb_appd_REQ = new JRadioButton("Requisition");
		rb_appd_REQ.setBounds(256, 91, 110, 23);
		append_panel.add(rb_appd_REQ);
		rb_appd_REQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Inquiring Product :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(false);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("*Unit Price :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("*Supervisor ID:");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("Date :");
				lbl_appd_7.setVisible(true);
				text_appd_7.setVisible(true);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

				append_table.setVisible(false);
				scrollpane_append.setVisible(false);
			}
		});
		bg.add(rb_appd_REQ);

		rb_appd_PUR = new JRadioButton("Purchase");
		rb_appd_PUR.setBounds(256, 122, 110, 23);
		append_panel.add(rb_appd_PUR);
		rb_appd_PUR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Module Type :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("*Unit Price :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("*ESD :");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("Date :");
				lbl_appd_7.setVisible(true);
				text_appd_7.setVisible(true);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

				append_table.setVisible(false);
				scrollpane_append.setVisible(false);
			}
		});
		bg.add(rb_appd_PUR);

		rb_appd_EXAM = new JRadioButton("Examination");
		rb_appd_EXAM.setBounds(256, 153, 110, 23);
		append_panel.add(rb_appd_EXAM);
		rb_appd_EXAM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Module Type :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("Result :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("Date :");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("");
				lbl_appd_7.setVisible(false);
				text_appd_7.setVisible(false);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

				append_table.setVisible(false);
				scrollpane_append.setVisible(false);
			}
		});
		bg.add(rb_appd_EXAM);

		rb_appd_RCPT = new JRadioButton("Receipt");
		rb_appd_RCPT.setBounds(256, 184, 110, 23);
		append_panel.add(rb_appd_RCPT);
		rb_appd_RCPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Module Type :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("Date :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("");
				lbl_appd_6.setVisible(false);
				text_appd_6.setVisible(false);

				lbl_appd_7.setText("");
				lbl_appd_7.setVisible(false);
				text_appd_7.setVisible(false);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

				append_table.setVisible(false);
				scrollpane_append.setVisible(false);

			}
		});
		bg.add(rb_appd_RCPT);

		append_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable

		};
		append_table.setBounds(33, 292, 603, 49);

		// inventory_panel.add(inv_table);

		scrollpane_append = new JScrollPane(append_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane_append.setBounds(27, 281, 950, 79);

		append_panel.add(scrollpane_append);

		btn_append_clear = new JButton("Clear");
		btn_append_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear_app_panel();
			}
		});
		btn_append_clear.setBounds(784, 210, 73, 29);
		btn_append_clear.setVisible(false);
		append_panel.add(btn_append_clear);

		lbl_append_message = new JLabel("");
		lbl_append_message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_append_message.setBounds(211, 253, 563, 16);
		lbl_append_message.setVisible(false);
		append_panel.add(lbl_append_message);

		lbl_appd_ins = new JLabel("*Obligatory");
		lbl_appd_ins.setBounds(172, 220, 102, 16);
		lbl_appd_ins.setVisible(false);
		append_panel.add(lbl_appd_ins);

	}

	void clear_app_panel() {

		text_appd_1.setText("");
		text_appd_2.setText("");
		text_appd_3.setText("");
		text_appd_4.setText("");
		text_appd_5.setText("");
		text_appd_6.setText("");
		text_appd_7.setText("");

		lbl_append_message.setText("");

	}

	void set_default_visible() {

		append_table.setVisible(false);
		scrollpane_append.setVisible(false);
		btn_append_clear.setVisible(true);
		lbl_appd_ins.setVisible(true);
	}

	private boolean append_check(String st) {

		/**
		 * @author jyunanyang
		 * @since 06/06/2021
		 * 
		 */

		boolean result = false;

		try {

			ResultSet r = Term_project_main.conn.st.executeQuery(
					"SELECT * FROM test.view_append_check WHERE Project_ID=" + text_appd_1.getText() + " LIMIT 1");
			System.out.print(
					"SELECT * FROM test.view_append_check WHERE Project_ID=" + text_appd_1.getText() + " LIMIT 1");

			if (r.next()) {

				switch (st) {

				case "RFQ":

					if (r.getString("Project_ID") != null) {

						result = true;
					}
					break;

				case "QUOT":

					if (r.getString("RFQ_Sheet_ID") != null) {

						result = true;
					}
					break;

				case "REQ":

					if (r.getString("QUO_Sheet_ID") != null) {

						result = true;
					}
					break;

				case "PUR":
					if (r.getString("REQ_Sheet_ID") != null) {
						if (r.getString("Signature").equalsIgnoreCase("True")) {

							result = true;
						}
					}
					break;

				case "EXAM":

					if (r.getString("PUR_Sheet_ID") != null) {

						result = true;
					}
					break;

				case "RCPT":
					// case "RCPT"
					if (r.getString("EX_Sheet_ID") != null) {

						result = true;
					}
					break;

				default:
					break;
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	private String[][] append(String st) {

		/**
		 * @author jyunanyang
		 * @since 06/06/2021
		 */
		ArrayList<String> temp = new ArrayList();
		int resultSet = 0;

		switch (st) {

		case "RFQ":
			if (!text_appd_5.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st
							.executeUpdate("INSERT INTO test.RFQ (Project_ID, Inquiring_product, Supplier_ID, "
									+ "Vol, Date) VALUE (" + text_appd_1.getText() + ", \'" + text_appd_2.getText()
									+ "\', \'" + text_appd_3.getText() + "\', " + text_appd_4.getText() + ", \'"
									+ text_appd_5.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.RFQ ORDER BY RFQ_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 8; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// text_appd_5.getText().isBlank()
				try {
					resultSet = Term_project_main.conn.st
							.executeUpdate("INSERT INTO test.RFQ (Project_ID, Inquiring_product, Supplier_ID, "
									+ "Vol) VALUE (" + text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.RFQ ORDER BY RFQ_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 8; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			break;

		case "QUOT":
			if (!text_appd_7.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st
							.executeUpdate("INSERT INTO test.QUOTATION (Project_ID, Inquiring_product, Supplier_ID, "
									+ "Vol, Unit_price, ESD, Date) VALUE (" + text_appd_1.getText() + ", \'"
									+ text_appd_2.getText() + "\', \'" + text_appd_3.getText() + "\', "
									+ text_appd_4.getText() + ", " + text_appd_5.getText() + ", \'"
									+ text_appd_6.getText() + "\', \'" + text_appd_7.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 11; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// text_appd_7.getText().isBlank()
				try {
					resultSet = Term_project_main.conn.st
							.executeUpdate("INSERT INTO test.QUOTATION (Project_ID, Inquiring_product, Supplier_ID, "
									+ "Vol, Unit_price, ESD) VALUE (" + text_appd_1.getText() + ", \'"
									+ text_appd_2.getText() + "\', \'" + text_appd_3.getText() + "\', "
									+ text_appd_4.getText() + ", " + text_appd_5.getText() + ", \'"
									+ text_appd_6.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 11; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;

		case "REQ":

			String item;

			if (text_appd_2.getText().substring(0, 1).equals("C"))

				item = "CPU";

			else if ((text_appd_2.getText().substring(0, 1).equals("G")))

				item = "GPU";

			else if (text_appd_2.getText().substring(0, 1).equals("R"))

				item = "RAM";

			else
				item = "Unknown";

			if (!text_appd_7.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st
							.executeUpdate("INSERT INTO test.REQUISITION (Project_ID, Inquiring_product, Item_name, "
									+ "Vol, Unit_price, Supervisor_ID, Date) VALUE (" + text_appd_1.getText() + ", \'"
									+ text_appd_2.getText() + "\', \'" + item + "\', " + text_appd_4.getText() + ", "
									+ text_appd_5.getText() + ", " + text_appd_6.getText() + ", \'"
									+ text_appd_7.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.REQUISITION ORDER BY REQ_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 12; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// text_appd_7.getText().isBlank()
				try {
					resultSet = Term_project_main.conn.st
							.executeUpdate("INSERT INTO test.REQUISITION (Project_ID, Inquiring_product, Item_name, "
									+ "Vol, Unit_price, Supervisor_ID) VALUE (" + text_appd_1.getText() + ", \'"
									+ text_appd_2.getText() + "\', \'" + item + "\', " + text_appd_4.getText() + ", "
									+ text_appd_5.getText() + ", " + text_appd_6.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.REQUISITION ORDER BY REQ_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 12; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;

		case "PUR":
			if (!text_appd_7.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st.executeUpdate(
							"INSERT INTO test.PURCHASE (Project_ID, Module_type, Supplier_ID, Vol, Unit_price, ESD, Date) VALUE ("
									+ text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ", "
									+ text_appd_5.getText() + ", \'" + text_appd_6.getText() + "\', \'"
									+ text_appd_7.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 11; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// text_appd_6.getText().isBlank()
				try {
					resultSet = Term_project_main.conn.st.executeUpdate(
							"INSERT INTO test.PURCHASE (Project_ID, Module_type, Supplier_ID, Vol, Unit_price, ESD) VALUE ("
									+ text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ", "
									+ text_appd_5.getText() + ", \'" + text_appd_6.getText() + "\')");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 11; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;

		case "EXAM":
			if (!text_appd_6.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st.executeUpdate(
							"INSERT INTO test.EXAMINATION (Project_ID, Module_type, Supplier_ID, Vol, Result, Date) VALUE ("
									+ text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ", \'"
									+ text_appd_5.getText() + "\', \'" + text_appd_6.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.EXAMINATION ORDER BY EX_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 9; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// text_appd_5.getText().isBlank()
				try {
					resultSet = Term_project_main.conn.st.executeUpdate(
							"INSERT INTO test.EXAMINATION (Project_ID, Module_type, Supplier_ID, Vol, Result) VALUE ("
									+ text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ", \'"
									+ text_appd_5.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.EXAMINATION ORDER BY EX_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 9; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;

		default:
			if (!text_appd_5.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st.executeUpdate(
							"INSERT INTO test.RECEIPT (Project_ID, Module_type, Supplier_ID,  Vol, Date) VALUE ("
									+ text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ", \'"
									+ text_appd_5.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.RECEIPT ORDER BY REC_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 8; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				// text_appd_4.getText().isBlank()
				try {
					resultSet = Term_project_main.conn.st.executeUpdate(
							"INSERT INTO test.RECEIPT (Project_ID, Module_type, Supplier_ID,  Vol) VALUE ("
									+ text_appd_1.getText() + ", \'" + text_appd_2.getText() + "\', \'"
									+ text_appd_3.getText() + "\', " + text_appd_4.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (resultSet != 0) {
					try {
						ResultSet r = Term_project_main.conn.st
								.executeQuery("SELECT * FROM test.RECEIPT ORDER BY REC_Sheet_ID DESC LIMIT 1");

						if (r.next()) {
							for (int i = 1; i < 8; i++) {
								temp.add(r.getString(i));
							}
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			break;

		}
		String[][] result_array = new String[1][temp.size()];

		int i = 0;
		for (String k : temp) {
			result_array[0][i++] = k;
		}
		return result_array;

	}

}
