package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

class Sheet_mod_panel  {

	private JPanel mod_panel;
	private JLabel lbl_mod_sheetID;
	private JTextField text_mod_sheetID;
	private JButton btn_mod_modify;
	private JLabel lbl_mod_projectID;
	private JTextField text_mod_projectID;
	private JLabel lbl_mod_pd;
	private JTextField text_mod_pd;
	private JLabel lbl_mod_supID;
	private JTextField text_mod_supID;
	private JLabel lbl_mod_5;
	private JTextField text_mod_5;
	private JLabel lbl_mod_6;
	private JTextField text_mod_6;
	private JLabel lbl_mod_7;
	private JTextField text_mod_7;
	private JLabel lbl_mod_8;
	private JTextField text_mod_8;
	private JButton btn_mod_check;
	private JLabel lbl_mod_message;
	private JLabel lbl_mod_note;
	private JButton btn_mod_clear;
	private JLabel lbl_mod_sheetID_show;
	private JLabel lbl_mod_projectID_show;
	private JLabel lbl_mod_pd_show;
	private JLabel lbl_mod_supID_show;

	// Second panel - Modify sheet
	Sheet_mod_panel() {

		mod_panel = new JPanel();
		Sheets_panel.sheet_container_panel.add(mod_panel, "Modify");
		mod_panel.setBounds(0, 0, 662, 367);
		mod_panel.setLayout(null);

		lbl_mod_note = new JLabel("* neccessary");
		lbl_mod_note.setBounds(184, 52, 123, 16);
		lbl_mod_note.setVisible(true);
		mod_panel.add(lbl_mod_note);

		lbl_mod_sheetID = new JLabel("*Sheet ID :");
		lbl_mod_sheetID.setBounds(336, 52, 67, 16);
		lbl_mod_sheetID.setVisible(true);
		mod_panel.add(lbl_mod_sheetID);

		text_mod_sheetID = new JTextField();
		text_mod_sheetID.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_sheetID.setBounds(415, 47, 115, 26);
		mod_panel.add(text_mod_sheetID);
		text_mod_sheetID.setColumns(10);

		lbl_mod_sheetID_show = new JLabel("");
		lbl_mod_sheetID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_sheetID_show.setBounds(415, 52, 115, 16);
		lbl_mod_sheetID_show.setVisible(false);
		mod_panel.add(lbl_mod_sheetID_show);

		lbl_mod_projectID = new JLabel("*Project ID :");
		lbl_mod_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_projectID.setVisible(true);
		lbl_mod_projectID.setBounds(307, 90, 96, 16);
		mod_panel.add(lbl_mod_projectID);

		text_mod_projectID = new JTextField();
		text_mod_projectID.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_projectID.setBounds(415, 85, 115, 26);
		mod_panel.add(text_mod_projectID);
		text_mod_projectID.setColumns(10);

		lbl_mod_projectID_show = new JLabel("");
		lbl_mod_projectID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_projectID_show.setBounds(415, 90, 115, 16);
		lbl_mod_projectID_show.setVisible(false);
		mod_panel.add(lbl_mod_projectID_show);

		lbl_mod_pd = new JLabel("*Product :");
		lbl_mod_pd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_pd.setVisible(true);
		lbl_mod_pd.setBounds(297, 128, 106, 16);
		mod_panel.add(lbl_mod_pd);

		text_mod_pd = new JTextField();
		text_mod_pd.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_pd.setBounds(415, 123, 115, 26);
		mod_panel.add(text_mod_pd);
		text_mod_pd.setColumns(10);

		lbl_mod_pd_show = new JLabel("");
		lbl_mod_pd_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_pd_show.setBounds(415, 128, 115, 16);
		lbl_mod_pd_show.setVisible(false);
		mod_panel.add(lbl_mod_pd_show);

		lbl_mod_supID = new JLabel("Supplier ID :");
		lbl_mod_supID.setBounds(307, 163, 96, 16);
		lbl_mod_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_supID.setVisible(true);
		mod_panel.add(lbl_mod_supID);

		text_mod_supID = new JTextField();
		text_mod_supID.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_supID.setBounds(415, 161, 115, 26);
		text_mod_supID.setVisible(true);
		mod_panel.add(text_mod_supID);
		text_mod_supID.setColumns(10);

		lbl_mod_5 = new JLabel("");
		lbl_mod_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_5.setBounds(297, 202, 106, 16);
		lbl_mod_5.setVisible(false);
		mod_panel.add(lbl_mod_5);

		text_mod_5 = new JTextField();
		text_mod_5.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_5.setBounds(415, 197, 115, 26);
		text_mod_5.setVisible(false);
		mod_panel.add(text_mod_5);
		text_mod_5.setColumns(10);

		lbl_mod_6 = new JLabel("");
		lbl_mod_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_6.setBounds(297, 244, 106, 16);
		lbl_mod_6.setVisible(false);
		mod_panel.add(lbl_mod_6);

		text_mod_6 = new JTextField();
		text_mod_6.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_6.setBounds(415, 239, 115, 26);
		text_mod_6.setVisible(false);
		mod_panel.add(text_mod_6);
		text_mod_6.setColumns(10);

		lbl_mod_7 = new JLabel("");
		lbl_mod_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_7.setBounds(297, 277, 106, 26);
		lbl_mod_7.setVisible(false);
		mod_panel.add(lbl_mod_7);

		text_mod_7 = new JTextField();
		text_mod_7.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_7.setBounds(415, 277, 115, 26);
		text_mod_7.setVisible(false);
		mod_panel.add(text_mod_7);
		text_mod_7.setColumns(10);

		lbl_mod_message = new JLabel("");
		lbl_mod_message.setBounds(542, 128, 431, 73);
		lbl_mod_message.setVisible(false);
		mod_panel.add(lbl_mod_message);

		text_mod_8 = new JTextField();
		text_mod_8.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_8.setBounds(415, 315, 115, 26);
		text_mod_8.setVisible(false);
		mod_panel.add(text_mod_8);
		text_mod_8.setColumns(10);

		lbl_mod_8 = new JLabel("");
		lbl_mod_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_8.setBounds(297, 320, 100, 16);
		lbl_mod_8.setVisible(false);
		mod_panel.add(lbl_mod_8);

		lbl_mod_supID_show = new JLabel("");
		lbl_mod_supID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_supID_show.setBounds(415, 166, 115, 16);
		mod_panel.add(lbl_mod_supID_show);

		btn_mod_modify = new JButton("Modify");
		btn_mod_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// verify format
				int id = Integer.parseInt(lbl_mod_sheetID_show.getText());

				if (id >= 21000000 & id < 22000000) {
					// RFQ
					if (Term_project_main.lib.num_not_null_check(text_mod_5)
							& Term_project_main.lib.date(text_mod_6.getText())) {

						if (modify() == 1)
							lbl_mod_message.setText("modification succeed");
						else
							lbl_mod_message.setText("modification failed");
					} else {
//											System.out.print(Term_project_main.lib.supplier_check(text_mod_supID));
//											System.out.print(Term_project_main.lib.num_not_null_check(text_mod_5));
//											System.out.print(Term_project_main.lib.date(text_mod_6.getText()));
						lbl_mod_message.setText("format Invalid");
						lbl_mod_message.setVisible(true);
					}

				} else if (id >= 22000000 & id < 23000000) {
					// QUOT
					if (Term_project_main.lib.num_not_null_check(text_mod_5)
							& Term_project_main.lib.num_not_null_check(text_mod_6)
							& Term_project_main.lib.date(text_mod_7.getText())
							& Term_project_main.lib.date(text_mod_8.getText())) {

						if (modify() == 1)
							lbl_mod_message.setText("Modification succeed");
						else
							lbl_mod_message.setText("Modification failed");
					} else {
						lbl_mod_message.setText("Format Invalid");
						lbl_mod_message.setVisible(true);
					}
				} else if (id >= 23000000 & id < 24000000) {
					// REQ
					if (Term_project_main.lib.num_not_null_check(text_mod_5)
							& Term_project_main.lib.num_not_null_check(text_mod_6)
							& Term_project_main.lib.supervisor_check(text_mod_7)
							& Term_project_main.lib.date(text_mod_8.getText())) {

						if (modify() == 1)
							lbl_mod_message.setText("Modification succeed");
						else
							lbl_mod_message.setText("Modification failed");
					} else {
						lbl_mod_message.setText("Format Invalid");
						lbl_mod_message.setVisible(true);
					}
				} else if (id >= 24000000 & id < 25000000) {
					// PUR
					if (Term_project_main.lib.num_not_null_check(text_mod_5)
							& Term_project_main.lib.num_not_null_check(text_mod_6)
							& Term_project_main.lib.date(text_mod_7.getText())
							& Term_project_main.lib.date(text_mod_8.getText())) {

						if (modify() == 1)
							lbl_mod_message.setText("modification succeed");
						else
							lbl_mod_message.setText("modification failed");
					} else {
						lbl_mod_message.setText("format Invalid");
						lbl_mod_message.setVisible(true);
					}

				} else if (id >= 25000000 & id < 26000000) {
					// EXAM
					if (Term_project_main.lib.num_not_null_check(text_mod_5)
							& Term_project_main.lib.date(text_mod_6.getText())) {

						if (modify() == 1)
							lbl_mod_message.setText("modification succeed");
						else
							lbl_mod_message.setText("modification failed");
					} else {
						lbl_mod_message.setText("format Invalid");
						lbl_mod_message.setVisible(true);
					}
				} else {
					// RCPT
					if (Term_project_main.lib.num_not_null_check(text_mod_5)
							& Term_project_main.lib.date(text_mod_6.getText())) {

						if (modify() == 1)
							lbl_mod_message.setText("modification succeed");
						else
							lbl_mod_message.setText("modification failed");
					} else {
						lbl_mod_message.setText("format Invalid");
						lbl_mod_message.setVisible(true);
					}
				}
			}
		});
		btn_mod_modify.setBounds(682, 46, 87, 29);
		mod_panel.add(btn_mod_modify);

		btn_mod_check = new JButton("Check");
		btn_mod_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!Term_project_main.lib.num_not_null_check(text_mod_sheetID)
						| !Term_project_main.lib.num_not_null_check(text_mod_projectID)
						| text_mod_pd.getText().isBlank()) {
					// None of them can't be blank

					lbl_mod_message.setText("Format Invalid");
					lbl_mod_message.setVisible(true);

					btn_mod_check.setVisible(true);
					btn_mod_clear.setVisible(true);
					btn_mod_modify.setVisible(false);

					lbl_mod_sheetID_show.setVisible(false);
					lbl_mod_projectID_show.setVisible(false);
					lbl_mod_pd_show.setVisible(false);
					lbl_mod_supID_show.setVisible(false);

					lbl_mod_5.setVisible(false);
					text_mod_5.setVisible(false);

					lbl_mod_6.setVisible(false);
					text_mod_6.setVisible(false);

					lbl_mod_7.setVisible(false);
					text_mod_7.setVisible(false);

					lbl_mod_8.setVisible(false);
					text_mod_8.setVisible(false);

				} else {
					// each of them is filled

					int what = Integer.parseInt(text_mod_sheetID.getText());

					if (what >= 23000000 & what < 24000000) {
						if (text_mod_supID.getText().isBlank()) {
							// REQ

							ArrayList<String> temp = Term_project_main.lib.rmv_mod_check(text_mod_sheetID,
									text_mod_projectID, text_mod_pd, text_mod_supID);

							if (temp.size() != 0) {

								btn_mod_clear.setVisible(true);

								lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
								text_mod_sheetID.setVisible(false);
								lbl_mod_sheetID_show.setVisible(true);

								lbl_mod_projectID_show.setText(text_mod_projectID.getText());
								text_mod_projectID.setVisible(false);
								lbl_mod_projectID_show.setVisible(true);

								lbl_mod_pd_show.setText(text_mod_pd.getText());
								text_mod_pd.setVisible(false);
								lbl_mod_pd_show.setVisible(true);

								lbl_mod_supID_show.setText(text_mod_supID.getText());
								lbl_mod_supID.setVisible(true);
								text_mod_supID.setVisible(false);

								lbl_mod_5.setText("Vol. :");
								text_mod_5.setText(temp.get(5));
								lbl_mod_5.setVisible(true);
								text_mod_5.setVisible(true);

								lbl_mod_6.setText("Unit Price :");
								text_mod_6.setText(temp.get(6));
								lbl_mod_6.setVisible(true);
								text_mod_6.setVisible(true);

								lbl_mod_7.setText("Supervisor ID :");
								text_mod_7.setText(temp.get(9));
								lbl_mod_7.setVisible(true);
								text_mod_7.setVisible(true);

								lbl_mod_8.setText("Date :");
								text_mod_8.setText(temp.get(11));
								lbl_mod_8.setVisible(true);
								text_mod_8.setVisible(true);

								btn_mod_modify.setVisible(true);
								lbl_mod_message.setText("Data loaded");
								lbl_mod_message.setVisible(true);

							} else {
								// no found

								btn_mod_check.setVisible(true);
								btn_mod_clear.setVisible(true);
								btn_mod_modify.setVisible(false);

								lbl_mod_sheetID_show.setVisible(false);
								lbl_mod_projectID_show.setVisible(false);
								lbl_mod_pd_show.setVisible(false);
								lbl_mod_supID_show.setVisible(false);

								lbl_mod_5.setVisible(false);
								text_mod_5.setVisible(false);

								lbl_mod_6.setVisible(false);
								text_mod_6.setVisible(false);

								lbl_mod_7.setVisible(false);
								text_mod_7.setVisible(false);

								lbl_mod_8.setVisible(false);
								text_mod_8.setVisible(false);

								btn_mod_modify.setVisible(false);
								lbl_mod_message.setText("Please check data again");
								lbl_mod_message.setVisible(true);
							}

						} else {

							btn_mod_check.setVisible(true);
							btn_mod_clear.setVisible(true);
							btn_mod_modify.setVisible(false);

							lbl_mod_sheetID_show.setVisible(false);
							lbl_mod_projectID_show.setVisible(false);
							lbl_mod_pd_show.setVisible(false);
							lbl_mod_supID_show.setVisible(false);

							lbl_mod_5.setVisible(false);
							text_mod_5.setVisible(false);

							lbl_mod_6.setVisible(false);
							text_mod_6.setVisible(false);

							lbl_mod_7.setVisible(false);
							text_mod_7.setVisible(false);

							lbl_mod_8.setVisible(false);
							text_mod_8.setVisible(false);

							btn_mod_modify.setVisible(false);
							lbl_mod_message
									.setText("If you wanna check REQ sheet, you couldn't fill Supplier_ID textField.");
							lbl_mod_message.setVisible(true);
						}
					} else {
						// except for REQ sheets

						if (text_mod_supID.getText().isBlank()) {

							btn_mod_check.setVisible(true);
							btn_mod_clear.setVisible(true);
							btn_mod_modify.setVisible(false);

							lbl_mod_sheetID_show.setVisible(false);
							lbl_mod_projectID_show.setVisible(false);
							lbl_mod_pd_show.setVisible(false);
							lbl_mod_supID_show.setVisible(false);

							lbl_mod_5.setVisible(false);
							text_mod_5.setVisible(false);

							lbl_mod_6.setVisible(false);
							text_mod_6.setVisible(false);

							lbl_mod_7.setVisible(false);
							text_mod_7.setVisible(false);

							lbl_mod_8.setVisible(false);
							text_mod_8.setVisible(false);

							btn_mod_modify.setVisible(false);
							lbl_mod_message.setText("Except for REQUISITION sheet, Please fill all the textField.");
							lbl_mod_message.setVisible(true);

						} else {

							ArrayList<String> temp = Term_project_main.lib.rmv_mod_check(text_mod_sheetID,
									text_mod_projectID, text_mod_pd, text_mod_supID);

							if (temp.size() != 0) {

								btn_mod_clear.setVisible(true);

								if (temp.get(1).equalsIgnoreCase("RFQ")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Date :");
									text_mod_6.setText(temp.get(7));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("");
									text_mod_7.setText("");
									lbl_mod_7.setVisible(false);
									text_mod_7.setVisible(false);

									lbl_mod_8.setText("");
									text_mod_8.setText("");
									lbl_mod_8.setVisible(false);
									text_mod_8.setVisible(false);

									btn_mod_modify.setVisible(true);
									lbl_mod_message.setText("Data loaded");
									lbl_mod_message.setVisible(true);

								} else if (temp.get(1).equalsIgnoreCase("QUOT")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Unit Price :");
									text_mod_6.setText(temp.get(7));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("ESD :");
									text_mod_7.setText(temp.get(9));
									lbl_mod_7.setVisible(true);
									text_mod_7.setVisible(true);

									lbl_mod_8.setText("Date :");
									text_mod_8.setText(temp.get(10));
									lbl_mod_8.setVisible(true);
									text_mod_8.setVisible(true);

									btn_mod_modify.setVisible(true);
									lbl_mod_message.setText("Data loaded");
									lbl_mod_message.setVisible(true);

								} else if (temp.get(1).equalsIgnoreCase("PURC")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol :");
									text_mod_5.setText(temp.get(5));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Unit Price :");
									text_mod_6.setText(temp.get(6));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("ESD :");
									text_mod_7.setText(temp.get(8));
									lbl_mod_7.setVisible(true);
									text_mod_7.setVisible(true);

									lbl_mod_8.setText("Date :");
									text_mod_8.setText(temp.get(9));
									lbl_mod_8.setVisible(true);
									text_mod_8.setVisible(true);

									btn_mod_modify.setVisible(true);
									lbl_mod_message.setText("Data loaded");
									lbl_mod_message.setVisible(true);

								} else if (temp.get(1).equalsIgnoreCase("EXAM")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Date");
									text_mod_6.setText(temp.get(8));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("");
									text_mod_7.setText("");
									lbl_mod_7.setVisible(false);
									text_mod_7.setVisible(false);

									lbl_mod_8.setText("");
									text_mod_8.setText("");
									lbl_mod_8.setVisible(false);
									text_mod_8.setVisible(false);

									btn_mod_modify.setVisible(true);
									lbl_mod_message.setText("Data loaded");
									lbl_mod_message.setVisible(true);

								} else {
									// if (temp.get(1).equalsIgnoreCase("RCPT"))
									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Date :");
									text_mod_6.setText(temp.get(7));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("");
									text_mod_7.setText("");
									lbl_mod_7.setVisible(false);
									text_mod_7.setVisible(false);

									lbl_mod_8.setText("");
									text_mod_8.setText("");
									lbl_mod_8.setVisible(false);
									text_mod_8.setVisible(false);

									btn_mod_modify.setVisible(true);
									lbl_mod_message.setText("Data loaded");
									lbl_mod_message.setVisible(true);

								}
							} else {
								btn_mod_check.setVisible(true);
								btn_mod_clear.setVisible(true);
								btn_mod_modify.setVisible(false);

								lbl_mod_sheetID_show.setVisible(false);
								lbl_mod_projectID_show.setVisible(false);
								lbl_mod_pd_show.setVisible(false);
								lbl_mod_supID_show.setVisible(false);

								lbl_mod_5.setVisible(false);
								text_mod_5.setVisible(false);

								lbl_mod_6.setVisible(false);
								text_mod_6.setVisible(false);

								lbl_mod_7.setVisible(false);
								text_mod_7.setVisible(false);

								lbl_mod_8.setVisible(false);
								text_mod_8.setVisible(false);

								btn_mod_modify.setVisible(false);
								lbl_mod_message.setText("Please check data again");
								lbl_mod_message.setVisible(true);
							}
						}
					}
				}
			}
		});
		btn_mod_check.setBounds(532, 47, 83, 29);
		mod_panel.add(btn_mod_check);

		btn_mod_clear = new JButton("Clear");
		btn_mod_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_mod_panel();
				btn_mod_check.setVisible(true);
				btn_mod_clear.setVisible(false);
				btn_mod_modify.setVisible(false);

				text_mod_sheetID.setVisible(true);
				text_mod_projectID.setVisible(true);
				text_mod_pd.setVisible(true);
				text_mod_supID.setVisible(true);
				lbl_mod_sheetID_show.setVisible(false);
				lbl_mod_projectID_show.setVisible(false);
				lbl_mod_pd_show.setVisible(false);
				lbl_mod_supID_show.setVisible(false);

				lbl_mod_5.setVisible(false);
				text_mod_5.setVisible(false);

				lbl_mod_6.setVisible(false);
				text_mod_6.setVisible(false);

				lbl_mod_7.setVisible(false);
				text_mod_7.setVisible(false);

				lbl_mod_8.setVisible(false);
				text_mod_8.setVisible(false);

				lbl_mod_message.setVisible(false);
			}
		});
		btn_mod_clear.setBounds(532, 85, 83, 29);
		btn_mod_clear.setVisible(true);
		mod_panel.add(btn_mod_clear);

	}

	void clear_mod_panel() {

		text_mod_sheetID.setText("");
		lbl_mod_sheetID_show.setText("");

		text_mod_projectID.setText("");
		lbl_mod_projectID_show.setText("");

		text_mod_pd.setText("");
		lbl_mod_pd_show.setText("");

		text_mod_supID.setText("");
		lbl_mod_supID_show.setText("");
		text_mod_5.setText("");
		text_mod_6.setText("");
		text_mod_7.setText("");
		text_mod_8.setText("");

		lbl_mod_message.setText("");
	}

	void set_defalt_visible() {
		
		btn_mod_check.setVisible(true);
		btn_mod_clear.setVisible(false);
		btn_mod_modify.setVisible(false);

		text_mod_sheetID.setVisible(true);
		text_mod_projectID.setVisible(true);
		text_mod_pd.setVisible(true);
		text_mod_supID.setVisible(true);
		lbl_mod_sheetID_show.setVisible(false);
		lbl_mod_projectID_show.setVisible(false);
		lbl_mod_pd_show.setVisible(false);
		lbl_mod_supID_show.setVisible(false);

		lbl_mod_5.setVisible(false);
		text_mod_5.setVisible(false);

		lbl_mod_6.setVisible(false);
		text_mod_6.setVisible(false);

		lbl_mod_7.setVisible(false);
		text_mod_7.setVisible(false);

		lbl_mod_8.setVisible(false);
		text_mod_8.setVisible(false);

		lbl_mod_message.setVisible(false);
	}

	private int modify() {

		/**
		 * @author jyunanyang
		 * @since 06/06/2021
		 * 
		 */

		int id = Integer.parseInt(lbl_mod_sheetID_show.getText());

		int r = 0;
		if (id >= 21000000 & id < 22000000) {

			try {

				r = Term_project_main.conn.st
						.executeUpdate("UPDATE test.RFQ SET Supplier_ID=\'" + text_mod_supID.getText() + "\', Vol="
								+ text_mod_5.getText() + ", Date=\'" + text_mod_6.getText() + "\' WHERE (RFQ_Sheet_ID="
								+ lbl_mod_sheetID_show.getText() + " AND Project_ID=" + lbl_mod_projectID_show.getText()
								+ " AND Inquiring_product=\'" + lbl_mod_pd_show.getText() + "\')");
				return r;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}

		} else if (id >= 22000000 & id < 23000000) {

			try {

				r = Term_project_main.conn.st.executeUpdate("UPDATE test.QUOTATION SET Supplier_ID=\'"
						+ text_mod_supID.getText() + "\', Vol=" + text_mod_5.getText() + ", Unit_price="
						+ text_mod_6.getText() + ", ESD=\'" + text_mod_7.getText() + "\', Date=\'"
						+ text_mod_8.getText() + "\' WHERE (QUO_Sheet_ID=" + lbl_mod_sheetID_show.getText()
						+ " AND Project_ID=" + lbl_mod_projectID_show.getText() + " AND Inquiring_product=\'"
						+ lbl_mod_pd_show.getText() + "\')");
				return r;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}

		} else if (id >= 23000000 & id < 24000000) {

			try {

				r = Term_project_main.conn.st.executeUpdate("UPDATE test.REQUISITION SET Item_name=\'"
						+ text_mod_supID.getText() + "\', Vol=" + text_mod_5.getText() + ", Unit_price="
						+ text_mod_6.getText() + ", Supervisor_ID=\'" + text_mod_7.getText() + "\', Date=\'"
						+ text_mod_8.getText() + "\' WHERE (REQ_Sheet_ID=" + lbl_mod_sheetID_show.getText()
						+ " AND Project_ID=" + lbl_mod_projectID_show.getText() + " AND Inquiring_product=\'"
						+ lbl_mod_pd_show.getText() + "\')");
				return r;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}

		} else if (id >= 24000000 & id < 25000000) {

			try {

				r = Term_project_main.conn.st.executeUpdate("UPDATE test.PURCHASE SET Vol=" + text_mod_5.getText()
						+ ", Unit_price=" + text_mod_6.getText() + ", ESD=\'" + text_mod_7.getText() + "\', Date=\'"
						+ text_mod_8.getText() + "\' WHERE (PUR_Sheet_ID=" + lbl_mod_sheetID_show.getText()
						+ " AND Project_ID=" + lbl_mod_projectID_show.getText() + " AND Module_type=\'"
						+ lbl_mod_pd_show.getText() + "\')");
				return r;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}

		} else if (id >= 25000000 & id < 26000000) {

			try {

				r = Term_project_main.conn.st.executeUpdate("UPDATE test.EXAMINATION SET Vol=" + text_mod_5.getText()
						+ ", Date=\'" + text_mod_6.getText() + "\' WHERE (EX_Sheet_ID=" + lbl_mod_sheetID_show.getText()
						+ " AND Project_ID=" + lbl_mod_projectID_show.getText() + " AND Module_type=\'"
						+ lbl_mod_pd_show.getText() + "\')");

				return r;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}

		} else {

			try {

				r = Term_project_main.conn.st.executeUpdate("UPDATE test.RECEIPT SET Vol=" + text_mod_5.getText()
						+ ", Date=\'" + text_mod_6.getText() + "\' WHERE (REC_Sheet_ID="
						+ lbl_mod_sheetID_show.getText() + " AND Project_ID=" + lbl_mod_projectID_show.getText()
						+ " AND Module_type=\'" + lbl_mod_pd_show.getText() + "\')");

				return r;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}

		}
	}

}
