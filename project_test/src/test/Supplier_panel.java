package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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
import javax.swing.JScrollBar;

public class Supplier_panel {

	/**
	 * @autohr Jyun-An
	 * @since 05/28 Seperated from Project_test
	 **/

	private Library lib;

	private JPanel supplier_panel;
	private JTextField text_sup_supID;
	private JTextField text_sup_name;
	private JTable sup_table;
	private JScrollPane scrollpane;

	// supplier panel variables needed for comboBox actionListener
	private String supplierFunction;
	private JLabel lbl_sup_addr;
	private JLabel lbl_sup_ctc;
	private JLabel lbl_sup_mobile;
	private JLabel lbl_sup_mail;
	private JComboBox comboBox_sup;
	private JButton btn_sup_1;
	private JButton btn_sup_2;
	private JTextField text_sup_addr;
	private JTextField text_sup_ctc;
	private JTextField text_sup_mobile;
	private JTextField text_sup_mail;
	private JLabel lbl_sup_supID;
	private JLabel lbl_sup_name;

	private DefaultTableModel sup_table_model;
	private JLabel lbl_result;

	private JLabel lbl_sup_supID_show;
	private JButton btn_clear;

	public Supplier_panel() {

		lib = new Library();
		panel();
	}

	private void panel() {

		/*
		 * New version GUI by Ray 05/27/2021
		 */

		supplier_panel = new JPanel();
		Term_project_main.container_panel.add(supplier_panel, "supplier");

		lbl_sup_supID = new JLabel("Supplier ID :");
		lbl_sup_supID.setBounds(160, 55, 77, 16);
		lbl_sup_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		supplier_panel.add(lbl_sup_supID);

		text_sup_supID = new JTextField();
		text_sup_supID.setHorizontalAlignment(SwingConstants.CENTER);
		text_sup_supID.setBounds(245, 50, 178, 26);
		supplier_panel.add(text_sup_supID);
		text_sup_supID.setColumns(14);

		lbl_sup_supID_show = new JLabel("");
		lbl_sup_supID_show.setBounds(249, 55, 174, 16);
		lbl_sup_supID_show.setVisible(false);
		supplier_panel.add(lbl_sup_supID_show);

		lbl_sup_name = new JLabel("Name :");
		lbl_sup_name.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_sup_name.setBounds(138, 81, 99, 16);
		supplier_panel.add(lbl_sup_name);

		text_sup_name = new JTextField();
		text_sup_name.setHorizontalAlignment(SwingConstants.CENTER);
		text_sup_name.setBounds(245, 76, 178, 26);
		supplier_panel.add(text_sup_name);
		text_sup_name.setColumns(14);

		lbl_sup_addr = new JLabel("");
		lbl_sup_addr.setBounds(178, 107, 59, 16);
		lbl_sup_addr.setVisible(false);
		supplier_panel.add(lbl_sup_addr);

		text_sup_addr = new JTextField();
		text_sup_addr.setHorizontalAlignment(SwingConstants.CENTER);
		text_sup_addr.setBounds(245, 102, 178, 26);
		text_sup_addr.setVisible(false);
		supplier_panel.add(text_sup_addr);
		text_sup_addr.setColumns(14);

		lbl_sup_ctc = new JLabel("Contact :");
		lbl_sup_ctc.setBounds(180, 133, 57, 16);
		lbl_sup_ctc.setVisible(false);
		supplier_panel.add(lbl_sup_ctc);

		text_sup_ctc = new JTextField();
		text_sup_ctc.setHorizontalAlignment(SwingConstants.CENTER);
		text_sup_ctc.setBounds(245, 128, 178, 26);
		text_sup_ctc.setVisible(false);
		supplier_panel.add(text_sup_ctc);
		text_sup_ctc.setColumns(14);

		lbl_sup_mobile = new JLabel("Mobile :");
		lbl_sup_mobile.setBounds(187, 159, 50, 16);
		lbl_sup_mobile.setVisible(false);
		supplier_panel.add(lbl_sup_mobile);

		text_sup_mobile = new JTextField();
		text_sup_mobile.setHorizontalAlignment(SwingConstants.CENTER);
		text_sup_mobile.setBounds(245, 154, 178, 26);
		text_sup_mobile.setVisible(false);
		supplier_panel.add(text_sup_mobile);
		text_sup_mobile.setColumns(14);

		lbl_sup_mail = new JLabel("Mail :");
		lbl_sup_mail.setBounds(203, 186, 34, 16);
		lbl_sup_mail.setVisible(false);
		supplier_panel.add(lbl_sup_mail);

		text_sup_mail = new JTextField();
		text_sup_mail.setHorizontalAlignment(SwingConstants.CENTER);
		text_sup_mail.setBounds(245, 181, 178, 26);
		text_sup_mail.setVisible(false);
		supplier_panel.add(text_sup_mail);
		text_sup_mail.setColumns(14);

		lbl_result = new JLabel("");
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setBounds(48, 219, 560, 16);
		lbl_result.setVisible(false);
		supplier_panel.add(lbl_result);

		JButton btn_show_more = new JButton("Show more");
		btn_show_more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[][] temp = show_more(text_sup_supID, text_sup_name);
				String[] column_names = { "SupplierID", "S.Name", "Item", "Module" };
				sup_table_model = new DefaultTableModel(temp, column_names);

				sup_table.setModel(sup_table_model);

			}
		});
		btn_show_more.setBounds(491, 333, 117, 29);
		btn_show_more.setVisible(false);

		supplier_panel.add(btn_show_more);

		sup_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable
		};
		sup_table.setFillsViewportHeight(true);
		// sup_table.setBounds(48,288,563,30);
		sup_table.setVisible(false);

		scrollpane = new JScrollPane(sup_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(48, 247, 563, 81);
		scrollpane.setVisible(false);
		// scrollpane.setPreferredSize(new Dimension(563, 50)); //whole scrollpane and
		// table will disapear
		supplier_panel.add(scrollpane);

		comboBox_sup = new JComboBox();
		comboBox_sup.setBounds(266, 4, 135, 27);
		comboBox_sup.setModel(
				new DefaultComboBoxModel(new String[] { "Inquire", "Add Supplier", "Add product", "Delete" }));
		supplierFunction = (String) comboBox_sup.getSelectedItem();
		comboBox_sup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				supplierFunction = (String) comboBox_sup.getSelectedItem();

				if (supplierFunction.equals("Inquire")) {
					// visibility

					lbl_sup_supID.setVisible(true);
					text_sup_supID.setVisible(true);
					lbl_sup_supID_show.setVisible(false);

					lbl_sup_name.setVisible(true);
					text_sup_name.setVisible(true);

					lbl_sup_addr = new JLabel("Address :");
					lbl_sup_addr.setVisible(false);
					text_sup_addr.setVisible(false);

					lbl_sup_ctc.setVisible(false);
					text_sup_ctc.setVisible(false);

					lbl_sup_mobile.setVisible(false);
					text_sup_mobile.setVisible(false);

					lbl_sup_mail.setVisible(false);
					text_sup_mail.setVisible(false);

					sup_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);

					btn_sup_1.setText("Inquire");
					btn_sup_1.setVisible(true);

					btn_sup_2.setVisible(false);

					btn_clear.setVisible(false);

					lbl_result.setVisible(false);

					// textField
					clear_text();
				} else if (supplierFunction.equals("Add Supplier")) {
					// visibility
					lbl_sup_supID.setVisible(true);
					text_sup_supID.setVisible(false);
					lbl_sup_supID_show.setVisible(true);

					lbl_sup_name.setVisible(true);
					text_sup_name.setVisible(true);

					lbl_sup_addr = new JLabel("Address :");
					lbl_sup_addr.setVisible(true);
					text_sup_addr.setVisible(true);

					lbl_sup_ctc.setVisible(true);
					text_sup_ctc.setVisible(true);

					lbl_sup_mobile.setVisible(true);
					text_sup_mobile.setVisible(true);

					lbl_sup_mail.setVisible(true);
					text_sup_mail.setVisible(true);

					sup_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);

					btn_sup_1.setText("");
					btn_sup_1.setVisible(false);

					btn_sup_2.setText("Add Supplier");
					btn_sup_2.setVisible(true);

					btn_clear.setVisible(true);
					// textField
					clear_text();

				} else if (supplierFunction.equals("Add Product")) {

					btn_sup_1.setText("Check");
					btn_sup_1.setVisible(true);

					btn_sup_2.setText("Add Product");
					btn_sup_2.setVisible(false);

					btn_clear.setVisible(false);

					text_sup_supID.setVisible(true);

					lbl_sup_addr = new JLabel("Module :");
					lbl_sup_addr.setVisible(false);
					text_sup_addr.setVisible(false);

					lbl_sup_ctc.setVisible(false);
					text_sup_ctc.setVisible(false);

					lbl_sup_mobile.setVisible(false);
					text_sup_mobile.setVisible(false);

					lbl_sup_mail.setVisible(false);
					text_sup_mail.setVisible(false);

					lbl_sup_name.setVisible(false);
					text_sup_name.setVisible(false);

					sup_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);

					text_sup_supID.setVisible(true);

					lbl_sup_supID_show.setVisible(false);
					clear_text();

				} else if (supplierFunction.equals("Delete")) {
					// supplierFunction.equals("Delete")
					btn_sup_1.setText("Check");
					btn_sup_1.setVisible(true);

					btn_sup_2.setText("Delete");
					btn_sup_2.setVisible(false);

					btn_clear.setVisible(false);

					text_sup_supID.setVisible(true);

					lbl_sup_addr = new JLabel("Address :");
					lbl_sup_addr.setVisible(false);
					text_sup_addr.setVisible(false);

					lbl_sup_ctc.setVisible(false);
					text_sup_ctc.setVisible(false);

					lbl_sup_mobile.setVisible(false);
					text_sup_mobile.setVisible(false);

					lbl_sup_mail.setVisible(false);
					text_sup_mail.setVisible(false);

					lbl_sup_name.setVisible(false);
					text_sup_name.setVisible(false);

					sup_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);

					text_sup_supID.setVisible(true);

					lbl_sup_supID_show.setVisible(false);
					clear_text();
				}
			}
		});
		supplier_panel.setLayout(null);
		comboBox_sup.setVisible(true);
		supplier_panel.add(comboBox_sup);

		btn_sup_1 = new JButton("");
		btn_sup_1.setBounds(435, 51, 88, 26);
		btn_sup_1.setVisible(true);
		btn_sup_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btn_sup_1.getText().equalsIgnoreCase("Inquire")) {

					// String [][] temp = {{"SP0000002", "Q-TIP", "Taoyuan", "Smith",
					// "(02)25450002",
					// "supplier002@gmail.com"}}; // for testing without connection

					String[][] temp = inquire(text_sup_supID, text_sup_name); // if want to test table without DB, mark
																				// from this line until whole if-else

					if (temp.length == 0) { // found data match

						lbl_sup_supID.setVisible(true);
						text_sup_supID.setVisible(true);
						lbl_sup_supID_show.setVisible(false);

						lbl_sup_name.setVisible(true);
						text_sup_name.setVisible(true);

						lbl_sup_addr.setVisible(false);
						text_sup_addr.setVisible(false);

						lbl_sup_ctc.setVisible(false);
						text_sup_ctc.setVisible(false);

						lbl_sup_mobile.setVisible(false);
						text_sup_mobile.setVisible(false);

						lbl_sup_mail.setVisible(false);
						text_sup_mail.setVisible(false);

						btn_sup_1.setVisible(true);

						btn_sup_2.setVisible(false);

						btn_clear.setVisible(false);

						sup_table.setVisible(false);
						scrollpane.setVisible(false);
						btn_show_more.setVisible(false);
						lbl_result.setText("No found");
						lbl_result.setVisible(true);

					} else {
						String[] column_names = { "SupplierID", "Name", "Address", "Contact", "Mobile", "Email" };
						DefaultTableModel sup_table_model = new DefaultTableModel(temp, column_names);

						sup_table.setModel(sup_table_model);

						TableColumnModel column_model = sup_table.getColumnModel();
						column_model.getColumn(0).setPreferredWidth(50);
						column_model.getColumn(1).setPreferredWidth(50);
						column_model.getColumn(2).setPreferredWidth(50);
						column_model.getColumn(3).setPreferredWidth(40);
						column_model.getColumn(4).setPreferredWidth(60);
						column_model.getColumn(5).setPreferredWidth(120);

						sup_table.setVisible(true);
						scrollpane.setVisible(true);
						btn_show_more.setVisible(true);

						lbl_result.setVisible(true);
						lbl_result.setText("Data Loaded");

						lbl_sup_supID.setVisible(true);
						text_sup_supID.setVisible(true);
						lbl_sup_supID_show.setVisible(false);

						lbl_sup_name.setVisible(true);
						text_sup_name.setVisible(true);

						lbl_sup_addr.setVisible(false);
						text_sup_addr.setVisible(false);

						lbl_sup_ctc.setVisible(false);
						text_sup_ctc.setVisible(false);

						lbl_sup_mobile.setVisible(false);
						text_sup_mobile.setVisible(false);

						lbl_sup_mail.setVisible(false);
						text_sup_mail.setVisible(false);

						btn_sup_1.setVisible(true);

						btn_sup_2.setVisible(false);

						btn_clear.setVisible(false);
					}

				} else if (btn_sup_1.getText().equalsIgnoreCase("Check")) {

					if (supplierFunction.equals("Delete")) {

						ArrayList<String> temp = check(text_sup_supID);

						if (temp.size() == 0) {

							btn_sup_1.setVisible(true);
							btn_clear.setVisible(true);
							btn_sup_2.setVisible(false);

							text_sup_supID.setVisible(true);
							lbl_sup_addr.setVisible(false);
							text_sup_addr.setVisible(false);

							lbl_sup_ctc.setVisible(false);
							text_sup_ctc.setVisible(false);

							lbl_sup_mobile.setVisible(false);
							text_sup_mobile.setVisible(false);

							lbl_sup_mail.setVisible(false);
							text_sup_mail.setVisible(false);

							sup_table.setVisible(false);
							scrollpane.setVisible(false);
							btn_show_more.setVisible(false);

							lbl_sup_name.setVisible(false);
							text_sup_name.setVisible(false);

							text_sup_supID.setVisible(true);

							lbl_sup_supID_show.setVisible(false);

							lbl_result.setText("Data no found");
							lbl_result.setVisible(true);

						} else {
							// temp.length!=0
							lbl_sup_supID_show.setText(text_sup_supID.getText()); // temp.get(0)
							lbl_sup_supID_show.setVisible(true);
							text_sup_supID.setVisible(false);

							lbl_sup_name.setVisible(true);
							text_sup_name.setText(temp.get(1));
							text_sup_name.setVisible(true);

							lbl_sup_addr.setVisible(true);
							text_sup_addr.setText(temp.get(2));
							text_sup_addr.setVisible(true);

							lbl_sup_ctc.setVisible(true);
							text_sup_ctc.setText(temp.get(3));
							text_sup_ctc.setVisible(true);

							lbl_sup_mobile.setVisible(true);
							text_sup_mobile.setText(temp.get(4));
							text_sup_mobile.setVisible(true);

							lbl_sup_mail.setVisible(true);
							text_sup_mail.setText(temp.get(5));
							text_sup_mail.setVisible(true);

							String[] column_names = { "SupplierID", "Name", "Item", "Module" };
							String[][] array = show_more(text_sup_supID, text_sup_name);
							DefaultTableModel sup_table_model = new DefaultTableModel(array, column_names);
							sup_table.setModel(sup_table_model);

							sup_table.setVisible(true);
							scrollpane.setVisible(true);
							btn_sup_1.setVisible(true);
							btn_sup_2.setVisible(true);
							btn_clear.setVisible(true);
							lbl_result.setText(
									"products provided by " + temp.get(1) + " will be delete from DB simultaneously.");
							lbl_result.setVisible(true);

							// btn_sup_delete.set

							btn_show_more.setVisible(false);
						}
					} else if (supplierFunction.equals("Add Product")) {

						ArrayList<String> temp = check(text_sup_supID);

						if (temp.size() == 0) {

							btn_sup_1.setVisible(true);
							btn_clear.setVisible(true);
							btn_sup_2.setVisible(false);

							text_sup_supID.setVisible(true);
							lbl_sup_addr.setVisible(false);
							text_sup_addr.setVisible(false);

							lbl_sup_ctc.setVisible(false);
							text_sup_ctc.setVisible(false);

							lbl_sup_mobile.setVisible(false);
							text_sup_mobile.setVisible(false);

							lbl_sup_mail.setVisible(false);
							text_sup_mail.setVisible(false);

							sup_table.setVisible(false);
							scrollpane.setVisible(false);
							btn_show_more.setVisible(false);

							lbl_sup_name.setVisible(false);
							text_sup_name.setVisible(false);

							text_sup_supID.setVisible(true);

							lbl_sup_supID_show.setVisible(false);

							lbl_result.setText("Data no found");
							lbl_result.setVisible(true);

						} else {
							// temp.length!=0
							lbl_sup_supID_show.setText(text_sup_supID.getText()); // temp.get(0)
							lbl_sup_supID_show.setVisible(true);
							text_sup_supID.setVisible(false);

							lbl_sup_ctc.setVisible(false);
							text_sup_ctc.setVisible(false);

							lbl_sup_mobile.setVisible(false);
							text_sup_mobile.setVisible(false);

							lbl_sup_mail.setVisible(false);
							text_sup_mail.setVisible(false);

							sup_table.setVisible(false);
							scrollpane.setVisible(false);
							btn_show_more.setVisible(false);

							lbl_sup_name.setVisible(true);
							text_sup_name.setVisible(false);

							lbl_sup_addr.setVisible(true);
							text_sup_addr.setVisible(true);

							btn_sup_2.setVisible(true);
							btn_clear.setVisible(true);

						}

					}
				}
			}
		});
		supplier_panel.add(btn_sup_1);

		btn_sup_2 = new JButton("");
		btn_sup_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (btn_sup_2.getText().equalsIgnoreCase("delete")) {

					if (delete() >= 2) {

						lbl_result.setText("request succeed");
						lbl_result.setVisible(true);

					} else {
						lbl_result.setText("request failed");
						lbl_result.setVisible(true);
					}
				} else if (btn_sup_2.getText().equalsIgnoreCase("Add Supplier")) {

					if (text_sup_name.getText().isBlank() | text_sup_addr.getText().isBlank()
							| text_sup_ctc.getText().isBlank() | text_sup_mobile.getText().isBlank()
							| text_sup_mail.getText().isBlank()) {

						lbl_result.setText("Supplier's infos cannot be blank.");
						lbl_result.setVisible(true);

					} else {

						ArrayList<String> temp = add_();
						if (temp.size() != 0) {

							lbl_sup_supID_show.setText(temp.get(0));
							lbl_sup_supID_show.setVisible(true);
							lbl_result.setText("Data Added");
							lbl_result.setVisible(true);

						} else {
							// temp.size()==0

							lbl_result.setText("Request failed");
							lbl_result.setVisible(true);

						}
					}
				} else if (btn_sup_2.getText().equalsIgnoreCase("Add Product")) {
					// 00
					String[][] temp = add_product();

					if (text_sup_addr.getText().substring(0, 1).equals("C"))

						text_sup_name.setText("CPU");

					else if ((text_sup_addr.getText().substring(0, 1).equals("G")))

						text_sup_name.setText("GPU");

					else if (text_sup_addr.getText().substring(0, 1).equals("R"))

						text_sup_name.setText("RAM");

					else
						text_sup_name.setText("Unknown");

					text_sup_name.setVisible(true);

					String[] column_names = { "SupplierID", "Name", "Item", "Module" };

					DefaultTableModel sup_table_model = new DefaultTableModel(temp, column_names);
					sup_table.setModel(sup_table_model);
					sup_table.setVisible(true);
					scrollpane.setVisible(true);

				}
			}
		});
		btn_sup_2.setBounds(491, 180, 84, 29);
		btn_sup_2.setVisible(false);
		supplier_panel.add(btn_sup_2);

		btn_clear = new JButton("Clear");
		btn_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_text();

				if (supplierFunction.equalsIgnoreCase("Delete") | supplierFunction.equalsIgnoreCase("Add Product")) {

					btn_sup_1.setVisible(true);
					btn_sup_2.setVisible(false);
					btn_clear.setVisible(false);

					lbl_sup_supID_show.setText("");
					lbl_sup_supID_show.setVisible(false);
					text_sup_supID.setVisible(true);

					lbl_sup_addr.setVisible(false);
					text_sup_addr.setVisible(false);

					lbl_sup_ctc.setVisible(false);
					text_sup_ctc.setVisible(false);

					lbl_sup_mobile.setVisible(false);
					text_sup_mobile.setVisible(false);

					lbl_sup_mail.setVisible(false);
					text_sup_mail.setVisible(false);

					lbl_sup_name.setVisible(false);
					text_sup_name.setVisible(false);

					text_sup_supID.setVisible(true);

					sup_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);
				} else if (supplierFunction.equalsIgnoreCase("Inquire")) {

					btn_sup_1.setVisible(true);
					btn_sup_2.setVisible(false);
					btn_clear.setVisible(false);

					lbl_sup_supID_show.setText("");
					lbl_sup_supID_show.setVisible(false);
					text_sup_supID.setVisible(true);

					lbl_sup_addr.setVisible(false);
					text_sup_addr.setVisible(false);

					lbl_sup_ctc.setVisible(false);
					text_sup_ctc.setVisible(false);

					lbl_sup_mobile.setVisible(false);
					text_sup_mobile.setVisible(false);

					lbl_sup_mail.setVisible(false);
					text_sup_mail.setVisible(false);

					lbl_sup_name.setVisible(false);
					text_sup_name.setVisible(false);

					text_sup_supID.setVisible(true);

					sup_table.setVisible(false);
					scrollpane.setVisible(false);
					btn_show_more.setVisible(false);

				}

			}
		});
		btn_clear.setBounds(435, 94, 88, 29);
		btn_clear.setVisible(false);
		supplier_panel.add(btn_clear);

	}

	public void clear_text() {
		/**
		 * @Author Ray
		 * @since 05/31 clear all input in JTextField
		 **/
		text_sup_supID.setText("");
		text_sup_name.setText("");
		text_sup_addr.setText("");
		text_sup_ctc.setText("");
		text_sup_mobile.setText("");
		text_sup_mail.setText("");
		/*
		 * editor: jyun an
		 * 
		 * @since: 06/09/2021
		 */
		lbl_sup_supID_show.setText("");
		lbl_result.setText("");
	}

	private String[][] add_product() {

		/**
		 * @Author jyun-an
		 * @since 06/15/2021 to ADD data in PRODUCT table
		 **/
		ArrayList<String[]> temp = new ArrayList();
		String item = "";

		if (text_sup_addr.getText().substring(0, 1).equals("C"))

			item = "CPU";

		else if ((text_sup_addr.getText().substring(0, 1).equals("G")))

			item = "GPU";

		else if (text_sup_addr.getText().substring(0, 1).equals("R"))

			item = "RAM";

		else
			item = "unknown";

		try {
			int resultSet = Term_project_main.conn.st
					.executeUpdate("INSERT INTO test.PRODUCT(Supplier_ID, Module_type, Item_name)" + " VALUE (\'"
							+ lbl_sup_supID_show.getText() + "\', \'" + text_sup_addr.getText() + "\', \'" + item
							+ "\')");

			if (resultSet == 1) {

				ResultSet r = Term_project_main.conn.st
						.executeQuery("SELECT * FROM test.view_supplier_product WHERE Supplier_ID=\'"
								+ lbl_sup_supID_show.getText() + "\'");

				while (r.next()) {
					String[] array = new String[4];
					for (int i = 1; i < 5; i++) {
						array[i - 1] = r.getString(i);
					}
					temp.add(array);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		String[][] result_array = new String[temp.size()][4];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;

	}

	private String[][] inquire(JTextField sup_ID, JTextField sup_name) {
		/**
		 * @Author jyun-an
		 * @since 06/01/2021, 06/03/2021 fixed
		 * 
		 *        to inquire data in SUPPLIER table
		 **/

		ArrayList<String[]> temp = new ArrayList();
		switch (lib.check_text_fields(sup_ID, sup_name)) {

		case "11":

			try {
				ResultSet resultSet = Term_project_main.conn.st
						.executeQuery("SELECT * FROM test.SUPPLIER WHERE (Supplier_ID=\'" + sup_ID.getText()
								+ "\' AND Supplier_name=\'" + sup_name.getText() + "\')");

				while (resultSet.next()) {
					String[] temp_array = new String[6];
					for (int i = 1; i < 7; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}
		case "10":

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(
						"SELECT * FROM test.SUPPLIER WHERE Supplier_ID=\'" + text_sup_supID.getText() + "\'");

				while (resultSet.next()) {
					String[] temp_array = new String[6];
					for (int i = 1; i < 7; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}

		default:

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(
						"SELECT * FROM test.SUPPLIER WHERE Supplier_name=\'" + text_sup_name.getText() + "\'");

				while (resultSet.next()) {
					String[] temp_array = new String[6];
					for (int i = 1; i < 7; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}
		}

		String[][] result_array = new String[temp.size()][6];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;

	}

	private String[][] show_more(JTextField sup_ID, JTextField sup_name) {

		/**
		 * @Author jyun-an
		 * @since 06/12/2021, 06/03/2021 fixed
		 * 
		 **/

		ArrayList<String[]> temp = new ArrayList();
		switch (lib.check_text_fields(sup_ID, sup_name)) {

		case "11":

			try {
				ResultSet resultSet = Term_project_main.conn.st
						.executeQuery("SELECT * FROM VIEW_SUPPLIER_PRODUCT WHERE (Supplier_ID=\'" + sup_ID.getText()
								+ "\' AND Supplier_name=\'" + sup_name.getText() + "\')");

				while (resultSet.next()) {
					String[] temp_array = new String[4];
					for (int i = 1; i < 5; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}
		case "10":

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(
						"SELECT * FROM VIEW_SUPPLIER_PRODUCT WHERE Supplier_ID=\'" + text_sup_supID.getText() + "\'");

				while (resultSet.next()) {
					String[] temp_array = new String[4];
					for (int i = 1; i < 5; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}

		default:

			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(
						"SELECT * FROM VIEW_SUPPLIER_PRODUCT WHERE Supplier_name=\'" + text_sup_name.getText() + "\'");
				while (resultSet.next()) {
					String[] temp_array = new String[4];
					for (int i = 1; i < 5; i++) {
						temp_array[i - 1] = resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				break;
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				// e.printStackTrace();
				break;
			}
		}

		String[][] result_array = new String[temp.size()][4];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;

	}

	private ArrayList<String> add_() {
		/**
		 * @Author jyun-an
		 * @since 06/01 to ADD data in SUPPLIER table
		 **/
		ArrayList<String> temp = new ArrayList();
		try {
			int resultSet = Term_project_main.conn.st
					.executeUpdate("INSERT INTO test.SUPPLIER(Supplier_ID, Supplier_name, Supplier_address, "
							+ "Contact_name, Contact_mobile, Contact_email) VALUE (\'" + get_new_supID() + "\', \'"
							+ text_sup_name.getText() + "\', \'" + text_sup_addr.getText() + "\', \'"
							+ text_sup_ctc.getText() + "\', \'" + text_sup_mobile.getText() + "\', \'"
							+ text_sup_mail.getText() + "\')");
			if (resultSet == 1) {
				ResultSet r = Term_project_main.conn.st
						.executeQuery("SELECT * FROM test.SUPPLIER ORDER BY Supplier_ID DESC LIMIT 1");

				while (r.next()) {

					for (int i = 1; i < 7; i++) {
						temp.add(r.getString(i));
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return temp;
		}
		return temp;
	}

	private String get_new_supID() {
		/**
		 * @Author jyun-an
		 * @since 06/01 to get the last ID in SUPPLIER table and product next one.
		 **/

		String new_ID = "";
		try {
			ResultSet resultSet = Term_project_main.conn.st
					.executeQuery("SELECT Supplier_ID FROM tset.SUPPLIER ORDER  BY Supplier_ID DESC");
			if (resultSet.next()) {

				String previous = resultSet.getString(1);
				new_ID = "SP" + String.format("%07d", (Integer.parseInt(previous.substring(2, previous.length())) + 1));
				// System.out.println(new_ID);
				return new_ID;
			}
			return new_ID;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new_ID;
		}

	}

	private int delete() {
		/**
		 * @Author jyun-an
		 * @since 06/01 to delete data in SUPPLIER table and product next one.
		 **/

		int resultSet = 0;
		int k = 0;

		try {
			k = Term_project_main.conn.st.executeUpdate(
					"DELETE FROM test.PRODUCT WHERE Supplier_ID=\'" + lbl_sup_supID_show.getText() + "\'");

			resultSet = Term_project_main.conn.st.executeUpdate(
					"DELETE FROM test.SUPPLIER WHERE Supplier_ID=\'" + lbl_sup_supID_show.getText() + "\'");

			return k + resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return k + resultSet;
		}
	}

	private ArrayList<String> check(JTextField supID) {
		/**
		 * @Author jyun-an
		 * @since 06/08/2021 to delete data in SUPPLIER table and product next one.
		 **/

		ArrayList<String> temp = new ArrayList();

		try {
			ResultSet r = Term_project_main.conn.st
					.executeQuery("SELECT * FROM test.SUPPLIER WHERE Supplier_ID=\'" + supID.getText() + "\'");

			if (r.next()) {
				for (int i = 1; i < 7; i++) {
					temp.add(r.getString(i));
				}
			}
			return temp;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return temp;
		}
	}

	public JComboBox get_combobox_sup() {

		return comboBox_sup;
	}

	public JTextField get_text_sup_supID() {

		return text_sup_supID;
	}

	public JTextField get_text_sup_name() {

		return text_sup_name;
	}

	public JTextField get_text_sup_addr() {

		return text_sup_addr;
	}

	public JTextField get_text_sup_ctc() {

		return text_sup_ctc;
	}

	public JTextField get_text_sup_mobile() {

		return text_sup_mobile;
	}

	public JTextField get_text_sup_mail() {

		return text_sup_mail;
	}

	public JTable get_sup_table() {

		return sup_table;
	}
}
