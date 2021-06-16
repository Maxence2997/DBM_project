package test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Progress_panel {

	private Library lib;
	private JPanel progress_panel;
	private JTextField text_prog_pjID;
	private JTable prog_table;
	private JScrollPane scrollpane_prog;
	private JLabel lbl_prog_message;

	public Progress_panel() {

		lib = new Library();
		panel();
	}

	private void panel() {

		progress_panel = new JPanel();
		progress_panel.setBounds(0,26,1000,450);
		Term_project_main.container_panel.add(progress_panel, "progress");
		progress_panel.setLayout(null);

		JLabel lbl_prog = new JLabel("Progress");
		lbl_prog.setBounds(51, 14, 54, 16);
		progress_panel.add(lbl_prog);

		JLabel lbl_prog_projectID = new JLabel("Project ID :");
		lbl_prog_projectID.setBounds(396, 71, 69, 29);
		progress_panel.add(lbl_prog_projectID);

		text_prog_pjID = new JTextField();
		text_prog_pjID.setBounds(469, 72, 119, 26);
		progress_panel.add(text_prog_pjID);
		text_prog_pjID.setColumns(10);

		JLabel lbl_note = new JLabel("P.D.P = Product Delivery Progress, E.S.D = Estimated Ship Date");
		lbl_note.setBounds(51, 211, 619, 16);
		lbl_note.setVisible(false);
		progress_panel.add(lbl_note);

		JButton btn_prog_inquire_all = new JButton("All");
		btn_prog_inquire_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[][] temp = show_project_status("all");

				if (temp.length != 0) {

					String[] columns_name = { "Project ID", "Status", "Employee ID", "Name", "Module", "*P.D.P",
							"Supplier ID", "Name", "*E.S.D", "Receipt Date", "Contract" };
					DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);

					prog_table.setModel(prog_table_model);
					prog_table.getColumnModel().getColumn(1).setPreferredWidth(40);
					prog_table.getColumnModel().getColumn(3).setPreferredWidth(110);
					prog_table.getColumnModel().getColumn(4).setPreferredWidth(60);
					prog_table.getColumnModel().getColumn(5).setPreferredWidth(40);

					lbl_prog_message.setText("Data loaded");
					lbl_prog_message.setVisible(true);
					lbl_note.setVisible(true);
					prog_table.setVisible(true);
					scrollpane_prog.setVisible(true);
					lbl_note.setVisible(true);

				} else {
					// temp.length==0
					// project no found

					lbl_prog_message.setText("No project is working");
					lbl_prog_message.setVisible(true);
					lbl_note.setVisible(false);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					lbl_note.setVisible(false);

				}
			}
		});
		btn_prog_inquire_all.setBounds(738, 206, 77, 29);
		progress_panel.add(btn_prog_inquire_all);

		JButton btn_prog_attention = new JButton("Attention !");
		btn_prog_attention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String[][] temp = show_project_status("attention");

				if (temp.length != 0) {

					String[] columns_name = { "Project ID", "Status", "Employee ID", "Name", "Module", "*P.D.P",
							"Supplier ID", "Name", "*E.S.D", "Receipt Date", "Contract" };
					DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);
					prog_table.setModel(prog_table_model);
					prog_table.getColumnModel().getColumn(1).setPreferredWidth(40);
					prog_table.getColumnModel().getColumn(3).setPreferredWidth(110);
					prog_table.getColumnModel().getColumn(4).setPreferredWidth(60);
					prog_table.getColumnModel().getColumn(5).setPreferredWidth(40);
					lbl_prog_message.setText("Data loaded");
					lbl_prog_message.setVisible(true);
					lbl_note.setVisible(true);
					prog_table.setVisible(true);
					scrollpane_prog.setVisible(true);
					lbl_note.setVisible(true);

				} else {
					// temp.length==0
					// project no found

					lbl_prog_message.setText("No project is working");
					lbl_prog_message.setVisible(true);
					lbl_note.setVisible(false);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					lbl_note.setVisible(false);

				}
			}
		});
		btn_prog_attention.setBounds(827, 206, 111, 29);
		progress_panel.add(btn_prog_attention);

		prog_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable

		};
		
		
		
		prog_table.setVisible(false);

		scrollpane_prog = new JScrollPane(prog_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_prog.setBounds(18, 245, 965, 158);
		scrollpane_prog.setVisible(false);

		progress_panel.add(scrollpane_prog);

		JButton btn_back2pj = new JButton("");
		btn_back2pj.setBounds(4, 5, 34, 32);
		btn_back2pj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
			}
		});
		Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
		go_back = go_back.getScaledInstance(21, 21, java.awt.Image.SCALE_AREA_AVERAGING);
		btn_back2pj.setIcon(new ImageIcon(go_back));
		progress_panel.add(btn_back2pj);

		JButton btnNewButton = new JButton("Inquire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (lib.num_not_null_check(text_prog_pjID)) {

					String[][] temp = show_project_status("inquire");

					if (temp.length != 0) {

						String[] columns_name = { "Project ID", "Status", "Employee ID", "Name", "Module", "*P.D.P",
								"Supplier ID", "Name", "*E.S.D", "Receipt Date", "Contract" };
						DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);
						prog_table.setModel(prog_table_model);
						prog_table.getColumnModel().getColumn(1).setPreferredWidth(40);
						prog_table.getColumnModel().getColumn(3).setPreferredWidth(110);
						prog_table.getColumnModel().getColumn(4).setPreferredWidth(60);
						prog_table.getColumnModel().getColumn(5).setPreferredWidth(40);
						lbl_prog_message.setText("Data loaded");
						lbl_prog_message.setVisible(true);
						prog_table.setVisible(true);
						scrollpane_prog.setVisible(true);
						lbl_note.setVisible(true);

					} else {
						// temp.length==0
						// project no found
						lbl_prog_message.setText("No project is working");
						lbl_prog_message.setVisible(true);
						prog_table.setVisible(false);
						scrollpane_prog.setVisible(false);
						lbl_note.setVisible(false);
					}
				} else {
					lbl_prog_message.setText("ID format invalid");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					lbl_note.setVisible(false);
				}

			}
		});
		btnNewButton.setBounds(634, 72, 77, 29);
		progress_panel.add(btnNewButton);

		lbl_prog_message = new JLabel("");
		lbl_prog_message.setBounds(365, 143, 384, 16);
		lbl_prog_message.setVisible(false);
		progress_panel.add(lbl_prog_message);

	}

	public void clear() {

		prog_table.setVisible(false);
		scrollpane_prog.setVisible(false);

		lbl_prog_message.setText("");
		text_prog_pjID.setText("");

	}

	private String[][] show_project_status(String st) {

		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 */

		final String st_progress = "SELECT * FROM VIEW_PROJECT_PROGRESS";

		ArrayList<String[]> temp = new ArrayList();

		ResultSet r=null;
		switch (st) {

		case "attention":

			if (lib.supervisor_check(Term_project_main.field_empID)) {

				try {

					r = Term_project_main.conn.st.executeQuery(
							st_progress + " WHERE P_Delivery_pct <100 AND Date_diff >15 ORDER BY Date_diff DESC");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} else {
				// not supervisor can only see the project on his responsibility
				try {

					r = Term_project_main.conn.st
							.executeQuery(st_progress + " WHERE (P_Delivery_pct <100 AND Date_diff >15 AND Emp_ID="
									+ Term_project_main.field_empID.getText() + ") ORDER BY Date_diff DESC");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		case "inquire":

			if (lib.supervisor_check(Term_project_main.field_empID)) {

				try {

					r = Term_project_main.conn.st
							.executeQuery(st_progress + " WHERE Project_ID=" + text_prog_pjID.getText());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} else {
				// not supervisor can only see the project on his responsibility
				try {

					r = Term_project_main.conn.st
							.executeQuery(st_progress + " WHERE (Emp_ID=" + Term_project_main.field_empID.getText()
									+ " AND Project_ID=" + text_prog_pjID.getText() + ")");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		default:
			// all
			if (lib.supervisor_check(Term_project_main.field_empID)) {

				try {

					r = Term_project_main.conn.st.executeQuery(st_progress + " ORDER BY Project_ID");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			} else {
				// not supervisor can only see the project on his responsibility
				try {

					r = Term_project_main.conn.st.executeQuery(st_progress + " WHERE Emp_ID="
							+ Term_project_main.field_empID.getText() + " ORDER BY Project_ID");

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}

		}

		try {
			while (r.next()) {

				String[] temp_array = new String[12];
				for (int i = 1; i < 13; i++) {

					if ((i==6)&(r.getString("P_Delivery_pct")!=null))
						temp_array[i-1]= (r.getString(i)+"%");
				
				else
					temp_array[i - 1] = r.getString(i);
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
		// System.out.print(result_array.length);
		return result_array;
	}
}
