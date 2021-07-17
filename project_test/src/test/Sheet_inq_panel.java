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

class Sheet_inq_panel  {

	private JPanel inq_panel;
	private JLabel lbl_inq_sheetID;
	private JTextField text_inq_sheetID;
	private JLabel lbl_inq_projectID;
	private JTextField text_inq_projectID;
	private JButton btn_inq_inquire;
	private JLabel lbl_inq_pd;
	private JLabel lbl_inq_result;
	private JTextField text_inq_pd;
	private JScrollPane scrollpane_inq;
	private JRadioButton rb_inq_all;
	private JRadioButton rb_inq_RFQ;
	private JRadioButton rb_inq_quo;
	private JRadioButton rb_inq_req;
	private JRadioButton rb_inq_pur;
	private JRadioButton rb_inq_exam;
	private JRadioButton rb_inq_rec;
	private JTable inq_table;
	private JButton btn_inq_clear;

	Sheet_inq_panel() {

		// first panel - Inquire sheet

		inq_panel = new JPanel();
		inq_panel.setBounds(0, 0, 666, 348);
		Sheets_panel.sheet_container_panel.add(inq_panel, "Inquire");
		inq_panel.setLayout(null);

		btn_inq_clear = new JButton("Clear");
		btn_inq_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_inq_panel();
				inq_table.setVisible(false);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		btn_inq_clear.setBounds(741, 80, 87, 29);
		inq_panel.add(btn_inq_clear);

		lbl_inq_sheetID = new JLabel("Sheet ID :");
		lbl_inq_sheetID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_inq_sheetID.setBounds(497, 51, 103, 16);
		lbl_inq_sheetID.setVisible(false);
		inq_panel.add(lbl_inq_sheetID);

		text_inq_sheetID = new JTextField();
		text_inq_sheetID.setHorizontalAlignment(SwingConstants.CENTER);
		text_inq_sheetID.setBounds(613, 46, 105, 26);
		text_inq_sheetID.setVisible(false);
		inq_panel.add(text_inq_sheetID);
		text_inq_sheetID.setColumns(10);

		lbl_inq_projectID = new JLabel("Project ID :");
		lbl_inq_projectID.setBounds(497, 93, 106, 16);
		lbl_inq_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_inq_projectID.setVisible(false);
		inq_panel.add(lbl_inq_projectID);

		text_inq_projectID = new JTextField();
		text_inq_projectID.setHorizontalAlignment(SwingConstants.CENTER);
		text_inq_projectID.setBounds(613, 88, 105, 26);
		text_inq_projectID.setVisible(false);
		inq_panel.add(text_inq_projectID);
		text_inq_projectID.setColumns(10);

		btn_inq_inquire = new JButton("Inquire");
		btn_inq_inquire.setBounds(741, 46, 87, 29);
		btn_inq_inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				btn_inq_clear.setVisible(true);

				try {
					if (!text_inq_sheetID.getText().isBlank())
						Integer.parseInt(text_inq_sheetID.getText());

					if (!text_inq_projectID.getText().isBlank())
						Integer.parseInt(text_inq_projectID.getText());
					
				

					if (rb_inq_all.isSelected()) {

						String[][] temp = inquire_all(text_inq_sheetID, text_inq_projectID, text_inq_pd);

						
						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Column 3", "Project ID", "Column 5",
									"Column 6", "Column 7", "Column 8", "Column 9", "Column 10", "Column 11",
									"Column 12" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp.length==0
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					}
					
					
					if (rb_inq_RFQ.isSelected()) {
						
						RFQ rfq = new RFQ();
						
						//String[][] temp = inquire("RFQ", text_inq_sheetID, text_inq_projectID, text_inq_pd);
						
						
						String[][] temp = rfq.inquire(new String[] {text_inq_sheetID.getText(), text_inq_projectID.getText(), 
						                                  text_inq_pd.getText()});
						if (temp != null) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Supplier ID", "Name",
									"Inquiring Product", "Vol.", "Date" };
							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp==null
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					} 
					
					if (rb_inq_quo.isSelected()) {

						String[][] temp = inquire("QUO", text_inq_sheetID, text_inq_projectID, text_inq_pd);
						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Supplier ID", "Name",
									"Inquiring Product", "Vol.", "Unit Price", "Total Price", "ESD", "Date" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp.length==0
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					} 
					
					if (rb_inq_req.isSelected()) {

						String[][] temp = inquire("REQ", text_inq_sheetID, text_inq_projectID, text_inq_pd);
						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Inquiring Product", "Item",
									"Vol.", "Unit Price", "Total Price", "Signature", "Supervisor ID", "Name", "Date" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							inq_table.getColumnModel().getColumn(4).setPreferredWidth(40);
							inq_table.getColumnModel().getColumn(5).setPreferredWidth(40);
							inq_table.getColumnModel().getColumn(11).setPreferredWidth(90);
							inq_table.getColumnModel().getColumn(10).setPreferredWidth(100);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp.length==0
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					} 
					
					if (rb_inq_pur.isSelected()) {

						String[][] temp = inquire("PUR", text_inq_sheetID, text_inq_projectID, text_inq_pd);
						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name", "Module",
									"Vol.", "Unit Price", "Total Price", "ESD", "Date" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp.length==0
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					} 
					
					if (rb_inq_exam.isSelected()) {

						String[][] temp = inquire("EXAM", text_inq_sheetID, text_inq_projectID, text_inq_pd);
						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name", "Module",
									"Vol.", "Result", "Date" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp.length==0
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					} 
					
					if(rb_inq_rec.isSelected()){
						String[][] temp = inquire("RCPT", text_inq_sheetID, text_inq_projectID, text_inq_pd);
						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name", "Module",
									"Vol.", "Date" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
							inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							inq_table.setVisible(true);
							scrollpane_inq.setVisible(true);
							lbl_inq_result.setText("Data loaded");
							lbl_inq_result.setVisible(true);

						} else {
							// temp.length==0
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}
					}
				} catch (NumberFormatException ex) {
					// handle exception here

					lbl_inq_result.setText("Format Invalid");
					lbl_inq_result.setVisible(true);
				}
				
			}
		});
		btn_inq_inquire.setVisible(false);
		inq_panel.add(btn_inq_inquire);

		lbl_inq_pd = new JLabel("Product :");
		lbl_inq_pd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_inq_pd.setVisible(false);
		lbl_inq_pd.setBounds(457, 133, 146, 16);
		inq_panel.add(lbl_inq_pd);

		text_inq_pd = new JTextField();
		text_inq_pd.setHorizontalAlignment(SwingConstants.CENTER);
		text_inq_pd.setBounds(613, 126, 105, 26);
		text_inq_pd.setVisible(false);
		inq_panel.add(text_inq_pd);
		text_inq_pd.setColumns(10);

		lbl_inq_result = new JLabel("");
		lbl_inq_result.setBounds(536, 171, 262, 16);
		inq_panel.add(lbl_inq_result);

		inq_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable

		};
		inq_table.setBounds(29, 194, 1000, 130);
		inq_table.setVisible(false);

		scrollpane_inq = new JScrollPane(inq_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_inq.setBounds(22, 220, 950, 135);

		inq_panel.add(scrollpane_inq);

		ButtonGroup bg = new ButtonGroup();

		rb_inq_all = new JRadioButton("All  Sheets");
		rb_inq_all.setBounds(205, 28, 180, 23);
		inq_panel.add(rb_inq_all);
		rb_inq_all.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Product :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		bg.add(rb_inq_all);

		rb_inq_RFQ = new JRadioButton("R.F.Q");
		rb_inq_RFQ.setBounds(205, 50, 180, 23);
		inq_panel.add(rb_inq_RFQ);
		rb_inq_RFQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Inquiring Product :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		bg.add(rb_inq_RFQ);

		rb_inq_quo = new JRadioButton("Quotation");
		rb_inq_quo.setBounds(205, 73, 180, 23);
		inq_panel.add(rb_inq_quo);

		rb_inq_quo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Inquiring Product :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		bg.add(rb_inq_quo);

		rb_inq_req = new JRadioButton("Requisition");
		rb_inq_req.setBounds(205, 96, 180, 23);
		inq_panel.add(rb_inq_req);
		rb_inq_req.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Inquiring Product :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		bg.add(rb_inq_req);

		rb_inq_pur = new JRadioButton("Purchase");
		rb_inq_pur.setBounds(205, 120, 180, 23);
		inq_panel.add(rb_inq_pur);
		rb_inq_pur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Module Type :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		bg.add(rb_inq_pur);

		rb_inq_exam = new JRadioButton("Examination");
		rb_inq_exam.setBounds(205, 142, 180, 23);
		inq_panel.add(rb_inq_exam);
		rb_inq_exam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Module Type :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);
			}
		});
		bg.add(rb_inq_exam);

		rb_inq_rec = new JRadioButton("Receipt");
		rb_inq_rec.setBounds(205, 164, 180, 23);
		inq_panel.add(rb_inq_rec);
		rb_inq_rec.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_inq_panel();
				lbl_inq_sheetID.setVisible(true);
				text_inq_sheetID.setVisible(true);

				lbl_inq_projectID.setVisible(true);
				text_inq_projectID.setVisible(true);

				lbl_inq_pd.setText("Module Type :");
				lbl_inq_pd.setVisible(true);
				text_inq_pd.setVisible(true);

				btn_inq_inquire.setVisible(true);
				scrollpane_inq.setVisible(false);
				btn_inq_clear.setVisible(false);

			}
		});

		bg.add(rb_inq_rec);

		JLabel lbl_sheet_type = new JLabel("Sheets type :");
		lbl_sheet_type.setBounds(110, 32, 87, 16);
		inq_panel.add(lbl_sheet_type);

	}

	void clear_inq_panel() {

		text_inq_sheetID.setText("");
		text_inq_projectID.setText("");
		text_inq_pd.setText("");
		lbl_inq_result.setText("");
	}

	void set_default_visible() {

		inq_table.setVisible(false);
		scrollpane_inq.setVisible(false);
		btn_inq_clear.setVisible(false);
	}

	private String[][] inquire_all(JTextField first, JTextField second, JTextField third) {

		/**
		 * @author jyunanyang
		 * @since 05/06/2021
		 * 
		 */

		ArrayList<String[]> temp = new ArrayList();

		String st_inq_all_sheets = "SELECT * FROM VIEW_6_SHEETS";

		switch (Term_project_main.lib.check_text_fields(first, second, third)) {

		case "011":
			try {
//					System.out.print(st_inq_all_sheets+" WHERE (RFQ_pj_ID="
//							+ text_inq_projectID.getText()+" AND RFQ_pd=\'"+text_inq_pd.getText()+"\')");
				ResultSet r = Term_project_main.conn.st.executeQuery(st_inq_all_sheets + " WHERE (RFQ_pj_ID="
						+ text_inq_projectID.getText() + " AND RFQ_pd=\'" + text_inq_pd.getText() + "\')");

				while (r.next()) {

					if (r.getString(2) != null) {

						String[] rfq = new String[8];
						for (int i = 1; i < 9; i++) {
							rfq[i - 1] = r.getString(i);
						}
						temp.add(rfq);

						if (r.getString(10) != null) {

							String[] quo = new String[11];
							for (int i = 9; i < 20; i++) {
								quo[i - 9] = r.getString(i);
							}
							temp.add(quo);

							if (r.getString(21) != null) {
								String[] req = new String[12];
								for (int i = 20; i < 32; i++) {
									req[i - 20] = r.getString(i);
								}
								temp.add(req);

								if (r.getString(33) != null) {

									String[] pur = new String[11];
									for (int i = 32; i < 43; i++) {
										pur[i - 32] = r.getString(i);
									}
									temp.add(pur);

									if (r.getString(44) != null) {

										String[] exam = new String[9];
										for (int i = 43; i < 52; i++) {
											exam[i - 43] = r.getString(i);
										}
										temp.add(exam);

										if (r.getString(53) != null) {

											String[] rcpt = new String[8];
											for (int i = 52; i < 60; i++) {
												rcpt[i - 52] = r.getString(i);
											}
											temp.add(rcpt);
										}
									}
								}
							}
						}
					}

				}
				break;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		case "010":

			try {

				ResultSet r = Term_project_main.conn.st
						.executeQuery(st_inq_all_sheets + " WHERE RFQ_pj_ID=" + text_inq_projectID.getText());

				while (r.next()) {

					if (r.getString(2) != null) {

						String[] rfq = new String[8];
						for (int i = 1; i < 9; i++) {
							rfq[i - 1] = r.getString(i);
						}
						temp.add(rfq);

						if (r.getString(10) != null) {

							String[] quo = new String[11];
							for (int i = 9; i < 20; i++) {
								quo[i - 9] = r.getString(i);
							}
							temp.add(quo);

							if (r.getString(21) != null) {
								String[] req = new String[12];
								for (int i = 20; i < 32; i++) {
									req[i - 20] = r.getString(i);
								}
								temp.add(req);

								if (r.getString(33) != null) {

									String[] pur = new String[11];
									for (int i = 32; i < 43; i++) {
										pur[i - 32] = r.getString(i);
									}
									temp.add(pur);

									if (r.getString(44) != null) {

										String[] exam = new String[9];
										for (int i = 43; i < 52; i++) {
											exam[i - 43] = r.getString(i);
										}
										temp.add(exam);

										if (r.getString(53) != null) {

											String[] rcpt = new String[8];
											for (int i = 52; i < 60; i++) {
												rcpt[i - 52] = r.getString(i);
											}
											temp.add(rcpt);
										}
									}
								}
							}
						}
					}

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			break;

		case "001":

			try {
				ResultSet r = Term_project_main.conn.st
						.executeQuery(st_inq_all_sheets + " WHERE RFQ_pd=\'" + text_inq_pd.getText() + "\'");

				while (r.next()) {

					if (r.getString(2) != null) {

						String[] rfq = new String[8];
						for (int i = 1; i < 9; i++) {
							rfq[i - 1] = r.getString(i);
						}
						temp.add(rfq);

						if (r.getString(10) != null) {

							String[] quo = new String[11];
							for (int i = 9; i < 20; i++) {
								quo[i - 9] = r.getString(i);
							}
							temp.add(quo);

							if (r.getString(21) != null) {
								String[] req = new String[12];
								for (int i = 20; i < 32; i++) {
									req[i - 20] = r.getString(i);
								}
								temp.add(req);

								if (r.getString(33) != null) {

									String[] pur = new String[11];
									for (int i = 32; i < 43; i++) {
										pur[i - 32] = r.getString(i);
									}
									temp.add(pur);

									if (r.getString(44) != null) {

										String[] exam = new String[9];
										for (int i = 43; i < 52; i++) {
											exam[i - 43] = r.getString(i);
										}
										temp.add(exam);

										if (r.getString(53) != null) {

											String[] rcpt = new String[8];
											for (int i = 52; i < 60; i++) {
												rcpt[i - 52] = r.getString(i);
											}
											temp.add(rcpt);
										}
									}
								}
							}
						}
					}

				}

				break;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		default:
			// sheet_ID be filled cases all are default

			int id = Integer.parseInt(text_inq_sheetID.getText());

			if (id >= 21000000 & id < 22000000) {

				return inquire("RFQ", first, second, third);

			} else if (id >= 22000000 & id < 23000000) {

				return inquire("QUO", first, second, third);

			} else if (id >= 23000000 & id < 24000000) {

				return inquire("REQ", first, second, third);

			} else if (id >= 24000000 & id < 25000000) {

				return inquire("PUR", first, second, third);

			} else if (id >= 25000000 & id < 26000000) {

				return inquire("EXAM", first, second, third);

			} else if (id >= 26000000 & id < 27000000) {

				return inquire("RCPT", first, second, third);

			}

		}

		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}

		Term_project_main.lib.sort(result_array);
		return result_array;

	}

	private String[][] inquire(String sheet_type, JTextField first, JTextField second, JTextField third) {

		/**
		 * @author jyunanyang
		 * @since 05/06/2021
		 * 
		 */

		ArrayList<String[]> temp = new ArrayList();
		ResultSet r;
		switch (sheet_type) {

		case "RFQ":

			final String st_rfq = "SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID,  "
					+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Inquiring_product, rfq.Vol, rfq.Date FROM test.RFQ AS rfq \n"
					+ "LEFT JOIN test.SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID";

			switch (Term_project_main.lib.check_text_fields(first, second, third)) {

			case "111":

				try {
					r = Term_project_main.conn.st.executeQuery(st_rfq + " WHERE (RFQ_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND rfq.Project_ID =" + text_inq_projectID.getText()
							+ " AND rfq.Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;

				}
				break;

			case "110":

				try {
					r = Term_project_main.conn.st.executeQuery(st_rfq + " WHERE (RFQ_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Project_ID =" + text_inq_projectID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "101":

				try {
					r = Term_project_main.conn.st.executeQuery(st_rfq + " WHERE (RFQ_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "100":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rfq + " WHERE RFQ_Sheet_ID=" + text_inq_sheetID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "011":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rfq + " WHERE (Project_ID =" + text_inq_projectID.getText()
									+ " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "010":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rfq + " WHERE Project_ID =" + text_inq_projectID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			default:
				// 001
				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rfq + " WHERE Inquiring_product=\'" + text_inq_pd.getText() + "\'");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;
			}
			try {
				while (r.next()) {

					String[] rfq = new String[8];

					for (int i = 1; i < 9; i++)
						rfq[i - 1] = r.getString(i);

					temp.add(rfq);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "QUO":

			final String st_quo = "SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID,  \n"
					+ "quo.Supplier_ID, sup.Supplier_name, quo.Inquiring_product, quo.Vol, quo.Unit_price, quo.Total_price,\n"
					+ "quo.ESD, quo.Date FROM test.QUOTATION AS quo \n"
					+ "LEFT JOIN test.SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID";

			switch (Term_project_main.lib.check_text_fields(first, second, third)) {

			case "111":

				try {
					r = Term_project_main.conn.st.executeQuery(st_quo + " WHERE (QUO_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Project_ID =" + text_inq_projectID.getText()
							+ " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;

				}
				break;

			case "110":

				try {
					r = Term_project_main.conn.st.executeQuery(st_quo + " WHERE (QUO_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Project_ID =" + text_inq_projectID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "101":

				try {
					r = Term_project_main.conn.st.executeQuery(st_quo + " WHERE (QUO_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "100":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_quo + " WHERE QUO_Sheet_ID=" + text_inq_sheetID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "011":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_quo + " WHERE (Project_ID =" + text_inq_projectID.getText()
									+ " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "010":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_quo + " WHERE Project_ID =" + text_inq_projectID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			default:
				// 001
				try {
					r = Term_project_main.conn.st
							.executeQuery(st_quo + " WHERE Inquiring_product=\'" + text_inq_pd.getText() + "\'");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;
			}
			try {
				while (r.next()) {

					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = r.getString(i);

					temp.add(temp_array);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "REQ":

			final String st_req = "SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, req.Item_name,\n"
					+ " req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID,CONCAT(emp.First_name,\' \', emp.Last_name) AS Name,req.Date FROM \n"
					+ "test.REQUISITION AS req LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID";

			switch (Term_project_main.lib.check_text_fields(first, second, third)) {

			case "111":

				try {
					r = Term_project_main.conn.st.executeQuery(st_req + " WHERE (REQ_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Project_ID =" + text_inq_projectID.getText()
							+ " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;

				}
				break;

			case "110":

				try {
					r = Term_project_main.conn.st.executeQuery(st_req + " WHERE (REQ_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Project_ID =" + text_inq_projectID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "101":

				try {
					r = Term_project_main.conn.st.executeQuery(st_req + " WHERE (REQ_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "100":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_req + " WHERE REQ_Sheet_ID=" + text_inq_sheetID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "011":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_req + " WHERE (Project_ID =" + text_inq_projectID.getText()
									+ " AND Inquiring_product=\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "010":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_req + " WHERE Project_ID =" + text_inq_projectID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			default:
				// 001
				try {
					r = Term_project_main.conn.st
							.executeQuery(st_req + " WHERE Inquiring_product=\'" + text_inq_pd.getText() + "\'");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;
			}
			try {
				while (r.next()) {

					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
						temp_array[i - 1] = r.getString(i);

					temp.add(temp_array);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "PUR":

			String st_pur = "SELECT pur.PUR_Sheet_ID, Sheet_type, pur.Project_ID, pur.Supplier_ID, sup.Supplier_name, "
					+ "pur.Module_type, pur.Vol, pur.Unit_price, pur.total_price, pur.ESD, pur.Date "
					+ "FROM PURCHASE AS pur INNER JOIN SUPPLIER AS sup ON sup.Supplier_ID=pur.Supplier_ID";

			switch (Term_project_main.lib.check_text_fields(first, second, third)) {

			case "111":

				try {
					r = Term_project_main.conn.st.executeQuery(st_pur + " WHERE (pur.PUR_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND pur.Project_ID =" + text_inq_projectID.getText()
							+ " AND pur.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;

				}
				break;

			case "110":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_pur + " WHERE (pur.PUR_Sheet_ID=" + text_inq_sheetID.getText()
									+ " AND pur.Project_ID =" + text_inq_projectID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "101":

				try {
					r = Term_project_main.conn.st.executeQuery(st_pur + " WHERE (pur.PUR_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND pur.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "100":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_pur + " WHERE pur.PUR_Sheet_ID=" + text_inq_sheetID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "011":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_pur + " WHERE (pur.Project_ID =" + text_inq_projectID.getText()
									+ " AND pur.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "010":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_pur + " WHERE pur.Project_ID =" + text_inq_projectID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			default:
				// 001
				try {
					r = Term_project_main.conn.st
							.executeQuery(st_pur + " WHERE pur.Module_type =\'" + text_inq_pd.getText() + "\'");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;
			}
			try {
				while (r.next()) {

					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = r.getString(i);

					temp.add(temp_array);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "EXAM":

			String st_exam = "SELECT ex.EX_Sheet_ID, ex.Sheet_type, ex.Project_ID, ex.Supplier_ID, "
					+ "sup.Supplier_name, ex.Module_type, ex.Vol, ex.Result, ex.Date FROM EXAMINATION AS ex INNER JOIN SUPPLIER AS sup"
					+ " ON sup.Supplier_ID = ex.Supplier_ID";
			switch (Term_project_main.lib.check_text_fields(first, second, third)) {

			case "111":

				try {
					r = Term_project_main.conn.st.executeQuery(st_exam + " WHERE (ex.EX_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND ex.Project_ID =" + text_inq_projectID.getText()
							+ " AND ex.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;

				}
				break;

			case "110":

				try {
					r = Term_project_main.conn.st.executeQuery(st_exam + " WHERE (ex.EX_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND ex.Project_ID =" + text_inq_projectID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "101":

				try {
					r = Term_project_main.conn.st.executeQuery(st_exam + " WHERE (ex.EX_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND ex.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "100":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_exam + " WHERE ex.EX_Sheet_ID=" + text_inq_sheetID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "011":

				try {
					r = Term_project_main.conn.st.executeQuery(st_exam + " WHERE (ex.Project_ID ="
							+ text_inq_projectID.getText() + " AND ex.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "010":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_exam + " WHERE ex.Project_ID =" + text_inq_projectID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			default:
				// 001
				try {
					r = Term_project_main.conn.st
							.executeQuery(st_exam + " WHERE Module_type =\'" + text_inq_pd.getText() + "\'");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;
			}

			try {
				while (r.next()) {

					String[] temp_array = new String[9];

					for (int i = 1; i < 10; i++)
						temp_array[i - 1] = r.getString(i);

					temp.add(temp_array);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			// case "RCPT":
			String st_rcpt = "SELECT rcpt.REC_Sheet_ID, rcpt.Sheet_type, rcpt.Project_ID, rcpt.Supplier_ID, "
					+ "sup.Supplier_name, rcpt.Module_type, rcpt.Vol, rcpt.Date FROM RECEIPT AS rcpt INNER JOIN SUPPLIER AS sup"
					+ " ON sup.Supplier_ID = rcpt.Supplier_ID";
			switch (Term_project_main.lib.check_text_fields(first, second, third)) {

			case "111":

				try {
					r = Term_project_main.conn.st.executeQuery(st_rcpt + " WHERE (rcpt.REC_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND rcpt.Project_ID =" + text_inq_projectID.getText()
							+ " AND rcpt.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;

				}
				break;

			case "110":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rcpt + " WHERE (rcpt.REC_Sheet_ID=" + text_inq_sheetID.getText()
									+ " AND rcpt.Project_ID =" + text_inq_projectID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "101":

				try {
					r = Term_project_main.conn.st.executeQuery(st_rcpt + " WHERE (rcpt.REC_Sheet_ID="
							+ text_inq_sheetID.getText() + " AND rcpt.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "100":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rcpt + " WHERE rcpt.REC_Sheet_ID=" + text_inq_sheetID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "011":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rcpt + " WHERE (rcpt.Project_ID =" + text_inq_projectID.getText()
									+ " AND rcpt.Module_type =\'" + text_inq_pd.getText() + "\')");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			case "010":

				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rcpt + " WHERE rcpt.Project_ID =" + text_inq_projectID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;

			default:
				// 001
				try {
					r = Term_project_main.conn.st
							.executeQuery(st_rcpt + " WHERE rcpt.Module_type =\'" + text_inq_pd.getText() + "\'");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					r = null;
				}
				break;
			}
			try {
				while (r.next()) {

					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = r.getString(i);

					temp.add(temp_array);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}

		String[][] result_array = new String[temp.size()][11];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;
	}
}
