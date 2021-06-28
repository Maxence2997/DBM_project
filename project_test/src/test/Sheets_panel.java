package test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

class Sheets_panel {

	/**
	 * @autohr Jyun-An @ver. 1.2.2 05/28 Seperated from Project_test
	 **/

	private JComboBox comboBox_sheets;
	private CardLayout cl_sheet;
	private JPanel core_sheet_panel;
	static JPanel sheet_container_panel;

	private JPanel default_panel;
	private Sheet_inq_panel inq_panel;
	private Sheet_mod_panel mod_panel;
	private Sheet_append_panel append_panel;
	private Sheet_remove_panel remove_panel;

	private JPanel sign_panel;
	private JTable sign_table;
	private JLabel lbl_sign_sorry;
	private JLabel lbl_sign_instr;
	private JButton btn_sign_sign;
	private JButton btn_sign_refresh;
	private JScrollPane scrollpane_sign;

	Sheets_panel() {

		// core sheet panel which contains comboBox
		core_sheet_panel = new JPanel();
		core_sheet_panel.setBounds(0, 26, 1000, 450);
		Term_project_main.container_panel.add(core_sheet_panel, "sheets");
		core_sheet_panel.setLayout(null);

		// smaller panel on the core sheet panel
		cl_sheet = new CardLayout();
		sheet_container_panel = new JPanel(cl_sheet);
		sheet_container_panel.setBounds(0, 36, 1000, 380);
		sheet_container_panel.setBackground(Color.CYAN);
		core_sheet_panel.add(sheet_container_panel);

		// add 5 sub sheet panels

		// default panel
		default_panel = new JPanel();
		default_panel.setBounds(0, 0, 666, 348);
		sheet_container_panel.add(default_panel, "--------");
		default_panel.setLayout(null);

		inq_panel = new Sheet_inq_panel();
		mod_panel = new Sheet_mod_panel();
		append_panel = new Sheet_append_panel();
		remove_panel = new Sheet_remove_panel();
		add_sign_panel();

		comboBox_sheets = new JComboBox(
				new String[] { "--------", "Inquire", "Modify", "Append", "Remove", "Signature" });
		comboBox_sheets.setBounds(423, 6, 120, 27);
		comboBox_sheets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String function = (String) comboBox_sheets.getSelectedItem(); // get the selected item

				if (function.equalsIgnoreCase("signature")) {
					if (Term_project_main.lib.supervisor_check(Term_project_main.field_empID)) {

						String[][] temp = Term_project_main.lib.show_unsign_req();

						if (temp.length != 0) {

							String[] columns_name = { "Sheet ID", "Type", "Project ID", "Module", "Item", "Vol.",
									"Unit Price", "Total Price", "Signature", "Supervisor ID", "Name", "Date" };

							lbl_sign_sorry.setVisible(false);
							btn_sign_sign.setVisible(true);
							btn_sign_refresh.setVisible(true);
							lbl_sign_instr.setText("Please sign sheets below after reading.");
							lbl_sign_instr.setVisible(true);

							DefaultTableModel sign_table_model = new DefaultTableModel(temp, columns_name);
							sign_table.setModel(sign_table_model);
							sign_table.getColumnModel().getColumn(1).setPreferredWidth(40);
							sign_table.getColumnModel().getColumn(4).setPreferredWidth(40);
							sign_table.getColumnModel().getColumn(10).setPreferredWidth(120);
							sign_table.getColumnModel().getColumn(11).setPreferredWidth(100);
							sign_table.setVisible(true);
							scrollpane_sign.setVisible(true);

						} else {

							lbl_sign_instr.setText("All sheets are signed");
							lbl_sign_instr.setVisible(true);

							lbl_sign_sorry.setVisible(false);
							btn_sign_sign.setVisible(false);
							btn_sign_refresh.setVisible(false);
							sign_table.setVisible(false);
							scrollpane_sign.setVisible(false);
						}
					} else {
						// not supervisor

						lbl_sign_sorry.setVisible(true);
						btn_sign_sign.setVisible(false);
						btn_sign_refresh.setVisible(false);
						sign_table.setVisible(false);
						scrollpane_sign.setVisible(false);

					}
				} else if (function.equalsIgnoreCase("Inquire")) {

					inq_panel.clear_inq_panel();
					inq_panel.set_default_visible();

				} else if (function.equalsIgnoreCase("Modify")) {

					mod_panel.clear_mod_panel();
					mod_panel.set_defalt_visible();

				} else if (function.equalsIgnoreCase("Append")) {

					append_panel.clear_app_panel();
					append_panel.set_default_visible();

				} else if (function.equalsIgnoreCase("Delete")) {
					remove_panel.clear_remove_panel();
					remove_panel.set_default_visible();

				}

				cl_sheet.show(sheet_container_panel, function);
			}
		});

		core_sheet_panel.add(comboBox_sheets);

		JButton btn_back2pj = new JButton("");
		btn_back2pj.setBounds(10, 3, 36, 30);
		btn_back2pj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
			}
		});
		Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
		go_back = go_back.getScaledInstance(21, 21, java.awt.Image.SCALE_AREA_AVERAGING);

		JLabel lbl_sheets = new JLabel("Sheets");
		lbl_sheets.setBounds(54, 10, 41, 16);
		lbl_sheets.setHorizontalAlignment(SwingConstants.CENTER);
		core_sheet_panel.add(lbl_sheets);
		btn_back2pj.setIcon(new ImageIcon(go_back));
		core_sheet_panel.add(btn_back2pj);
	}

	// fifth panel - sign sheet only supervisor
	private void add_sign_panel() {

		sign_panel = new JPanel();
		sign_panel.setBounds(0, 0, 666, 348);
		sheet_container_panel.add(sign_panel, "Signature");
		sign_panel.setLayout(null);

		lbl_sign_sorry = new JLabel("Sorry, no right to access this page, work harder for promotion.");
		lbl_sign_sorry.setBounds(223, 60, 517, 16);
		sign_panel.add(lbl_sign_sorry);

		lbl_sign_instr = new JLabel("");
		lbl_sign_instr.setBounds(223, 94, 411, 16);
		sign_panel.add(lbl_sign_instr);

		sign_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable

		};
		sign_table.setBounds(62, 97, 546, 192);

		sign_table.setVisible(false);

		scrollpane_sign = new JScrollPane(sign_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_sign.setBounds(27, 192, 950, 125);
		scrollpane_sign.setVisible(false);
		sign_panel.add(scrollpane_sign);

		btn_sign_sign = new JButton("Sign all");
		btn_sign_sign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (sign_all() == 0) {
					lbl_sign_instr.setText("Oops errors occurred");
					lbl_sign_instr.setVisible(true);

				} else {
					lbl_sign_instr.setText("Sign succeed");
					lbl_sign_instr.setVisible(true);
				}
			}
		});
		btn_sign_sign.setBounds(896, 325, 81, 29);
		sign_panel.add(btn_sign_sign);
		// btn_sign.setVisible(true);

		btn_sign_refresh = new JButton("Refresh");
		btn_sign_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[][] temp = Term_project_main.lib.show_unsign_req();

				if (temp.length != 0) {

					String[] columns_name = { "Sheet ID", "Type", "Project ID", "Module", "Item", "Vol.", "Unit Price",
							"Total Price", "Signature", "Supervisor ID", "Name", "Date" };

					lbl_sign_sorry.setVisible(false);
					btn_sign_sign.setVisible(true);
					btn_sign_refresh.setVisible(true);
					lbl_sign_instr.setText("Please sign sheets below after reading.");
					lbl_sign_instr.setVisible(true);

					DefaultTableModel sign_table_model = new DefaultTableModel(temp, columns_name);
					sign_table.setModel(sign_table_model);
					sign_table.getColumnModel().getColumn(1).setPreferredWidth(40);
					sign_table.getColumnModel().getColumn(4).setPreferredWidth(40);
					sign_table.getColumnModel().getColumn(10).setPreferredWidth(100);
					sign_table.getColumnModel().getColumn(11).setPreferredWidth(100);
					sign_table.setVisible(true);
					scrollpane_sign.setVisible(true);

				} else {

					lbl_sign_instr.setText("All sheets are signed");
					lbl_sign_instr.setVisible(true);

					lbl_sign_sorry.setVisible(false);
					btn_sign_sign.setVisible(false);
					btn_sign_refresh.setVisible(true);
					sign_table.setVisible(false);
					scrollpane_sign.setVisible(false);
				}
			}
		});
		btn_sign_refresh.setBounds(658, 89, 112, 29);
		sign_panel.add(btn_sign_refresh);
		// btn_refresh.setVisible(true);

	}

	private int sign_all() {

		int r = 0;
		try {
			r = Term_project_main.conn.st
					.executeUpdate("UPDATE test.REQUISITION SET Signature=\'True\' WHERE Supervisor_ID="
							+ Term_project_main.field_empID.getText());
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r;
		}

	}

	JComboBox get_comboBox_sheets() {

		return comboBox_sheets;
	}
}
