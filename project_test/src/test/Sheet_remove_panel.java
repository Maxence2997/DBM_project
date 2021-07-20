package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

class Sheet_remove_panel {

	private JPanel remove_panel;
	private JLabel lbl_remove_confirm;
	private JTextField text_remove_confirm;
	private JButton btn_remove_confirm;
	private JTable remove_table;
	private JLabel lbl_remove_sheetID_show;
	private JLabel lbl_remove_projectID_show;
	private JLabel lbl_remove_pd_show;
	private JTextField text_remove_projectID;
	private JTextField text_remove_pd;
	private JTextField text_remove_sheetID;
	private JScrollPane scrollpane_remove;
	private JLabel lbl_remove_message;
	private JTextField text_remove_supID;
	private JLabel lbl_remove_supID_show;
	private JLabel lbl_remove_ins;

	// forth panel - remove sheet
	Sheet_remove_panel() {

		remove_panel = new JPanel();
		remove_panel.setBounds(0, 0, 666, 348);
		Sheets_panel.sheet_container_panel.add(remove_panel, "Remove");
		remove_panel.setLayout(null);

		JLabel lbl_remove_sheetID = new JLabel("*Sheet ID :");
		lbl_remove_sheetID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_sheetID.setBounds(287, 53, 103, 16);
		remove_panel.add(lbl_remove_sheetID);

		text_remove_sheetID = new JTextField();
		text_remove_sheetID.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_sheetID.setBounds(409, 48, 146, 26);
		remove_panel.add(text_remove_sheetID);
		text_remove_sheetID.setColumns(10);

		lbl_remove_sheetID_show = new JLabel("");
		lbl_remove_sheetID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_sheetID_show.setBounds(409, 53, 146, 16);
		lbl_remove_sheetID_show.setVisible(false);
		remove_panel.add(lbl_remove_sheetID_show);

		lbl_remove_projectID_show = new JLabel("");
		lbl_remove_projectID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_projectID_show.setBounds(409, 88, 146, 16);
		lbl_remove_projectID_show.setVisible(false);
		remove_panel.add(lbl_remove_projectID_show);

		lbl_remove_pd_show = new JLabel("");
		lbl_remove_pd_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_pd_show.setBounds(409, 123, 146, 16);
		lbl_remove_pd_show.setVisible(false);
		remove_panel.add(lbl_remove_pd_show);

		lbl_remove_message = new JLabel("");
		lbl_remove_message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_message.setBounds(239, 192, 506, 16);
		remove_panel.add(lbl_remove_message);

		lbl_remove_ins = new JLabel("*Obligatory");
		lbl_remove_ins.setBounds(309, 18, 226, 16);
		lbl_remove_ins.setVisible(true);
		remove_panel.add(lbl_remove_ins);

		lbl_remove_confirm = new JLabel("Please write down \"I would like to remove this sheet permanently.\"");
		lbl_remove_confirm.setBounds(206, 276, 555, 16);
		lbl_remove_confirm.setVisible(false);
		remove_panel.add(lbl_remove_confirm);

		text_remove_confirm = new JTextField();
		text_remove_confirm.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_confirm.setBounds(204, 289, 611, 26);
		text_remove_confirm.setColumns(10);
		text_remove_confirm.setVisible(false);
		text_remove_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (text_remove_confirm.getText().equals("I would like to remove this sheet permanently.")) {

					int id = Integer.parseInt(lbl_remove_sheetID_show.getText());
					String[] temp = { lbl_remove_sheetID_show.getText(), lbl_remove_projectID_show.getText(),
							lbl_remove_pd_show.getText(), lbl_remove_supID_show.getText() };
					int r = 0;
					
					if (id >= 21000000 & id < 22000000) {
						// RFQ
						RFQ rfq = new RFQ();
						r = rfq.remove(id, temp);

					} else if (id >= 22000000 & id < 23000000) {
						// QUOTATION
						Quotation quotation = new Quotation();
						r=quotation.remove(id, temp);

					} else if (id >= 23000000 & id < 24000000) {
						// REQUISITION
						Requisition requisition = new Requisition();
						r= requisition.remove(id, temp);

					} else if (id >= 24000000 & id < 25000000) {
						// PURCHASE
						Purchase purchase = new Purchase();
						r= purchase.remove(id, temp);
						

					} else if (id >= 25000000 & id < 26000000) {
						// EXAMINATION
						Examination examination = new Examination();
						r= examination.remove(id, temp);

					} else {
						// if (id >= 26000000 & id < 27000000) {
						// RECEIPT
						Receipt receipt = new Receipt();
						r= receipt.remove(id, temp);

					}

					// result output
					if (r == 1) {


						clear_remove_panel();
						scrollpane_remove.setVisible(false);
						remove_table.setVisible(false);
						lbl_remove_confirm.setVisible(false);
						text_remove_confirm.setVisible(false);
						btn_remove_confirm.setVisible(false);
						text_remove_sheetID.setVisible(true);
						lbl_remove_sheetID_show.setVisible(false);
						text_remove_projectID.setVisible(true);
						lbl_remove_projectID_show.setVisible(false);
						text_remove_pd.setVisible(true);
						lbl_remove_pd_show.setVisible(false);
						text_remove_supID.setVisible(true);
						lbl_remove_supID_show.setVisible(false);
						lbl_remove_message.setText("Delete succeed");
						lbl_remove_message.setVisible(true);
						text_remove_confirm.setText("");
						

					} else {
						lbl_remove_message.setText("Delete failed, errors occurred.");
						lbl_remove_message.setVisible(true);
					}
				} else {
					lbl_remove_message.setText("Text wrong, please check your text.");
					lbl_remove_message.setVisible(true);
					text_remove_confirm.setText("");
				}
			}
		});
		remove_panel.add(text_remove_confirm);

		text_remove_projectID = new JTextField();
		text_remove_projectID.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_projectID.setBounds(409, 85, 146, 26);
		remove_panel.add(text_remove_projectID);
		text_remove_projectID.setColumns(10);

		text_remove_pd = new JTextField();
		text_remove_pd.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_pd.setBounds(409, 118, 146, 26);
		remove_panel.add(text_remove_pd);
		text_remove_pd.setColumns(10);

		JLabel lbl_remove_projectID = new JLabel("*Project ID :");
		lbl_remove_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_projectID.setBounds(287, 88, 103, 16);
		remove_panel.add(lbl_remove_projectID);

		JLabel lbl_remove_pd = new JLabel("*Product :");
		lbl_remove_pd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_pd.setBounds(287, 123, 103, 16);
		remove_panel.add(lbl_remove_pd);

		text_remove_supID = new JTextField();
		text_remove_supID.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_supID.setBounds(409, 154, 146, 26);
		remove_panel.add(text_remove_supID);
		text_remove_supID.setColumns(10);

		JLabel lbl_remove_supID = new JLabel("Supplier_ID :");
		lbl_remove_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_supID.setBounds(309, 159, 81, 16);
		remove_panel.add(lbl_remove_supID);

		lbl_remove_supID_show = new JLabel("");
		lbl_remove_supID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_supID_show.setBounds(409, 159, 146, 16);
		remove_panel.add(lbl_remove_supID_show);

		JButton btn_remove_check = new JButton("Check");
		btn_remove_check.setBounds(567, 48, 76, 29);
		btn_remove_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!Term_project_main.lib.num_not_null_check(text_remove_sheetID)
						| !Term_project_main.lib.num_not_null_check(text_remove_projectID)
						| text_remove_pd.getText().isBlank()) {
					// None of them can't be blank

					lbl_remove_message.setText("Format Invalid");
					lbl_remove_message.setVisible(true);

				} else {
					int what = Integer.parseInt(text_remove_sheetID.getText());

					if (what >= 23000000 & what < 24000000) {
						if (text_remove_supID.getText().isBlank()) {
							// REQ

							ArrayList<String> temp_list = Term_project_main.lib.rmv_mod_check(text_remove_sheetID,
									text_remove_projectID, text_remove_pd, text_remove_supID);

							if (temp_list.size() != 0) {
								// data found

								String[][] temp_array = new String[1][temp_list.size()];
								for (int i = 0; i < temp_list.size(); i++) {
									temp_array[0][i] = temp_list.get(i);
								}

								String[] columns_req = { "Sheet ID", "Type", "Project ID", "Item", "Module", "Vol.",
										"Unit Price", "Total_price", "Signature", "Supervisor", "Name", "Date" };

								DefaultTableModel remove_table_model_req = new DefaultTableModel(temp_array,
										columns_req);
								remove_table.setModel(remove_table_model_req);
								remove_table.getColumnModel().getColumn(10).setPreferredWidth(100);
								remove_table.getColumnModel().getColumn(11).setPreferredWidth(100);
								remove_table.getColumnModel().getColumn(1).setPreferredWidth(50);
								remove_table.getColumnModel().getColumn(5).setPreferredWidth(40);

								remove_table.setVisible(true);
								scrollpane_remove.setVisible(true);
								lbl_remove_confirm.setVisible(true);
								text_remove_confirm.setVisible(true);
								btn_remove_confirm.setVisible(true);

								lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
								lbl_remove_projectID_show.setText(text_remove_projectID.getText());
								lbl_remove_pd_show.setText(text_remove_pd.getText());
								lbl_remove_supID_show.setText(text_remove_supID.getText());
								text_remove_sheetID.setVisible(false);
								text_remove_projectID.setVisible(false);
								text_remove_pd.setVisible(false);
								text_remove_supID.setVisible(false);
								lbl_remove_sheetID_show.setVisible(true);
								lbl_remove_projectID_show.setVisible(true);
								lbl_remove_pd_show.setVisible(true);
								lbl_remove_supID_show.setVisible(true);

								lbl_remove_message.setText("Data loaded");
								lbl_remove_message.setVisible(true);
							} else {
								// no found

								text_remove_sheetID.setVisible(true);
								text_remove_projectID.setVisible(true);
								text_remove_pd.setVisible(true);
								text_remove_supID.setVisible(true);
								lbl_remove_sheetID_show.setVisible(false);
								lbl_remove_projectID_show.setVisible(false);
								lbl_remove_pd_show.setVisible(false);
								lbl_remove_supID_show.setVisible(false);
								remove_table.setVisible(false);
								scrollpane_remove.setVisible(false);
								lbl_remove_confirm.setVisible(false);
								text_remove_confirm.setVisible(false);
								btn_remove_confirm.setVisible(false);

								lbl_remove_message.setText("Please check data inputted again");
								lbl_remove_message.setVisible(true);
							}
						} else {
							// REQ but Supplier_ID is filled

							text_remove_sheetID.setVisible(true);
							text_remove_projectID.setVisible(true);
							text_remove_pd.setVisible(true);
							text_remove_supID.setVisible(true);
							lbl_remove_sheetID_show.setVisible(false);
							lbl_remove_projectID_show.setVisible(false);
							lbl_remove_pd_show.setVisible(false);
							lbl_remove_supID_show.setVisible(false);
							remove_table.setVisible(false);
							scrollpane_remove.setVisible(false);
							lbl_remove_confirm.setVisible(false);
							text_remove_confirm.setVisible(false);
							btn_remove_confirm.setVisible(false);

							lbl_remove_message
									.setText("If you wanna check REQ sheet, you couldn't fill Supplier_ID textField.");
							lbl_remove_message.setVisible(true);

						}
					} else {
						// except for REQ sheet

						if (text_remove_supID.getText().isBlank()) {

							text_remove_sheetID.setVisible(true);
							text_remove_projectID.setVisible(true);
							text_remove_pd.setVisible(true);
							text_remove_supID.setVisible(true);
							lbl_remove_sheetID_show.setVisible(false);
							lbl_remove_projectID_show.setVisible(false);
							lbl_remove_pd_show.setVisible(false);
							lbl_remove_supID_show.setVisible(false);
							remove_table.setVisible(false);
							scrollpane_remove.setVisible(false);
							lbl_remove_confirm.setVisible(false);
							text_remove_confirm.setVisible(false);
							btn_remove_confirm.setVisible(false);

							lbl_remove_message.setText("Except for REQUISITION sheet, Please fill all the textField.");
							lbl_remove_message.setVisible(true);

						} else {

							ArrayList<String> temp_list = Term_project_main.lib.rmv_mod_check(text_remove_sheetID,
									text_remove_projectID, text_remove_pd, text_remove_supID);

							if (temp_list.size() != 0) {
								// data found

								String[][] temp_array = new String[1][temp_list.size()];
								for (int i = 0; i < temp_list.size(); i++) {
									temp_array[0][i] = temp_list.get(i);
								}

								if (temp_array[0][1].equalsIgnoreCase("RFQ")) {

									String[] columns_rfq = { "Sheet ID", "Type", "Project ID", "Supplier ID", "Name",
											"Product", "Vol.", "Date" };

									DefaultTableModel remove_table_model_rfq = new DefaultTableModel(temp_array,
											columns_rfq);
									remove_table.setModel(remove_table_model_rfq);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

									lbl_remove_message.setText("Data loaded");
									lbl_remove_message.setVisible(true);

								} else if (temp_array[0][1].equalsIgnoreCase("QUOT")) {

									String[] columns_quot = { "Sheet ID", "Type", "Project ID", "Supplier", "Product",
											"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

									DefaultTableModel remove_table_model_quot = new DefaultTableModel(temp_array,
											columns_quot);
									remove_table.setModel(remove_table_model_quot);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

									lbl_remove_message.setText("Data loaded");
									lbl_remove_message.setVisible(true);

								} else if (temp_array[0][1].equalsIgnoreCase("PURC")) {

									String[] columns_pur = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name",
											"Module", "Vol.", "Unit Price", "Total Price", "ESD", "Date" };

									DefaultTableModel remove_table_model_pur = new DefaultTableModel(temp_array,
											columns_pur);
									remove_table.setModel(remove_table_model_pur);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

									lbl_remove_message.setText("Data loaded");
									lbl_remove_message.setVisible(true);

								} else if (temp_array[0][1].equalsIgnoreCase("EXAM")) {

									String[] columns_exam = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name",
											"Module", "Vol.", "Result", "Date" };

									DefaultTableModel remove_table_model_exam = new DefaultTableModel(temp_array,
											columns_exam);
									remove_table.setModel(remove_table_model_exam);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

									lbl_remove_message.setText("Data loaded");
									lbl_remove_message.setVisible(true);

								} else {
									// temp_array[0][1].equalsIgnoreCase("RCPT")
									String[] columns_rcpt = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name",
											"Module", "Vol.", "Date" };

									DefaultTableModel remove_table_model_rcpt = new DefaultTableModel(temp_array,
											columns_rcpt);
									remove_table.setModel(remove_table_model_rcpt);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

									lbl_remove_message.setText("Data loaded");
									lbl_remove_message.setVisible(true);
								}
							} else {
								// data no found

								text_remove_sheetID.setVisible(true);
								text_remove_projectID.setVisible(true);
								text_remove_pd.setVisible(true);
								text_remove_supID.setVisible(true);
								lbl_remove_sheetID_show.setVisible(false);
								lbl_remove_projectID_show.setVisible(false);
								lbl_remove_pd_show.setVisible(false);
								lbl_remove_supID_show.setVisible(false);
								remove_table.setVisible(false);
								scrollpane_remove.setVisible(false);
								lbl_remove_confirm.setVisible(false);
								text_remove_confirm.setVisible(false);
								btn_remove_confirm.setVisible(false);

								lbl_remove_message.setText("Please check data inputted again");
								lbl_remove_message.setVisible(true);
							}
						}
					}

				}
			}
		});
		remove_panel.add(btn_remove_check);

		remove_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable
		};
		remove_table.setBounds(78, 177, 506, 47);

		remove_table.setVisible(false);

		scrollpane_remove = new JScrollPane(remove_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_remove.setBounds(21, 221, 950, 43);
		scrollpane_remove.setVisible(false);
		remove_panel.add(scrollpane_remove);

		btn_remove_confirm = new JButton("Confirm");
		btn_remove_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (text_remove_confirm.getText().equals("I would like to remove this sheet permanently.")) {

					int id = Integer.parseInt(lbl_remove_sheetID_show.getText());
					String[] temp = { lbl_remove_sheetID_show.getText(), lbl_remove_projectID_show.getText(),
							lbl_remove_pd_show.getText(), lbl_remove_supID_show.getText() };
					int r = 0;
					
					if (id >= 21000000 & id < 22000000) {
						// RFQ
						RFQ rfq = new RFQ();
						r = rfq.remove(id, temp);

					} else if (id >= 22000000 & id < 23000000) {
						// QUOTATION
						Quotation quotation = new Quotation();
						r=quotation.remove(id, temp);

					} else if (id >= 23000000 & id < 24000000) {
						// REQUISITION
						Requisition requisition = new Requisition();
						r= requisition.remove(id, temp);

					} else if (id >= 24000000 & id < 25000000) {
						// PURCHASE
						Purchase purchase = new Purchase();
						r= purchase.remove(id, temp);
						

					} else if (id >= 25000000 & id < 26000000) {
						// EXAMINATION
						Examination examination = new Examination();
						r= examination.remove(id, temp);

					} else {
						// if (id >= 26000000 & id < 27000000) {
						// RECEIPT
						Receipt receipt = new Receipt();
						r= receipt.remove(id, temp);

					}

					// result output
					if (r == 1) {

						
						clear_remove_panel();
						scrollpane_remove.setVisible(false);
						remove_table.setVisible(false);
						lbl_remove_confirm.setVisible(false);
						text_remove_confirm.setVisible(false);
						btn_remove_confirm.setVisible(false);
						text_remove_sheetID.setVisible(true);
						lbl_remove_sheetID_show.setVisible(false);
						text_remove_projectID.setVisible(true);
						lbl_remove_projectID_show.setVisible(false);
						text_remove_pd.setVisible(true);
						lbl_remove_pd_show.setVisible(false);
						text_remove_supID.setVisible(true);
						lbl_remove_supID_show.setVisible(false);
						lbl_remove_message.setText("Delete succeed");
						lbl_remove_message.setVisible(true);
						text_remove_confirm.setText("");
						

					} else {
						lbl_remove_message.setText("Delete failed, errors occurred.");
						lbl_remove_message.setVisible(true);
					}
				} else {
					lbl_remove_message.setText("Text wrong, please check your text.");
					lbl_remove_message.setVisible(true);
					text_remove_confirm.setText("");
				}
			}
		});
		btn_remove_confirm.setBounds(452, 327, 93, 29);
		btn_remove_confirm.setVisible(false);
		remove_panel.add(btn_remove_confirm);

		JButton btn_remove_clear = new JButton("Clear");
		btn_remove_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_remove_panel();
				scrollpane_remove.setVisible(false);
				remove_table.setVisible(false);
				lbl_remove_confirm.setVisible(false);
				text_remove_confirm.setVisible(false);
				btn_remove_confirm.setVisible(false);
				text_remove_sheetID.setVisible(true);
				lbl_remove_sheetID_show.setVisible(false);
				text_remove_projectID.setVisible(true);
				lbl_remove_projectID_show.setVisible(false);
				text_remove_pd.setVisible(true);
				lbl_remove_pd_show.setVisible(false);
				text_remove_supID.setVisible(true);
				lbl_remove_supID_show.setVisible(false);

			}
		});
		btn_remove_clear.setBounds(567, 89, 76, 29);
		remove_panel.add(btn_remove_clear);

	}

	void clear_remove_panel() {

		text_remove_sheetID.setText("");
		text_remove_projectID.setText("");
		text_remove_pd.setText("");
		text_remove_supID.setText("");
		lbl_remove_sheetID_show.setText("");
		lbl_remove_projectID_show.setText("");
		lbl_remove_pd_show.setText("");
		lbl_remove_supID_show.setText("");
		lbl_remove_message.setText("");
	}

	void set_default_visible() {
		scrollpane_remove.setVisible(false);
		remove_table.setVisible(false);
		lbl_remove_confirm.setVisible(false);
		text_remove_confirm.setVisible(false);
		btn_remove_confirm.setVisible(false);
		text_remove_sheetID.setVisible(true);
		lbl_remove_sheetID_show.setVisible(false);
		text_remove_projectID.setVisible(true);
		lbl_remove_projectID_show.setVisible(false);
		text_remove_pd.setVisible(true);
		lbl_remove_pd_show.setVisible(false);
	}
}
