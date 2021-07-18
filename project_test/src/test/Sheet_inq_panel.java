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

class Sheet_inq_panel {

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

					if (rb_inq_RFQ.isSelected()) {

						RFQ rfq = new RFQ();

						String[][] temp = rfq.inquire(new String[] { text_inq_sheetID.getText(),
								text_inq_projectID.getText(), text_inq_pd.getText() });
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

						Quotation quotation = new Quotation();

						String[][] temp = quotation.inquire(new String[] { text_inq_sheetID.getText(),
								text_inq_projectID.getText(), text_inq_pd.getText() });

						if (temp != null) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Supplier ID", "Name",
									"Inquiring Product", "Vol.", "Unit Price", "Total Price", "ESD", "Date" };

							DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
							inq_table.setModel(inq_table_model);
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

					if (rb_inq_req.isSelected()) {

						Requisition requisition = new Requisition();

						String[][] temp = requisition.inquire(new String[] { text_inq_sheetID.getText(),
								text_inq_projectID.getText(), text_inq_pd.getText() });
						
						if (temp != null) {

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
							// temp==null
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					}

					if (rb_inq_pur.isSelected()) {

						Purchase purchase = new Purchase();

						String[][] temp = purchase.inquire(new String[] { text_inq_sheetID.getText(),
								text_inq_projectID.getText(), text_inq_pd.getText() });
						
						if (temp != null) {


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
							// temp==null
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					}

					if (rb_inq_exam.isSelected()) {

						Examination examination = new Examination();

						String[][] temp = examination.inquire(new String[] { text_inq_sheetID.getText(),
								text_inq_projectID.getText(), text_inq_pd.getText() });
						
						if (temp != null) {

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
							// temp==null
							inq_table.setVisible(false);
							scrollpane_inq.setVisible(false);
							lbl_inq_result.setText("Data no found");
							lbl_inq_result.setVisible(true);
						}

					}

					if (rb_inq_rec.isSelected()) {
						
						Receipt receipt = new Receipt();

						String[][] temp = receipt.inquire(new String[] { text_inq_sheetID.getText(),
								text_inq_projectID.getText(), text_inq_pd.getText() });
						
						if (temp != null) {

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

}
