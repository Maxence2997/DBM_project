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
import java.awt.Image;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Progress_panel {
	
	private Library lib;
	private JPanel progress_panel;
	private JTextField text_prog_pjID;
	private JTable prog_table;
	private JScrollPane scrollpane_prog;
	private JLabel lbl_prog_message;
	
	private final String horrible_tables_join ="SELECT pj.Project_ID, pj.Project_status, pj.Emp_ID, emp.Last_name AS Respensable, PUR.Module_type, pj.Delivery_progress,"
												+ " PUR.ESD, RCPT.Date, \n"
												+ " (CASE WHEN  (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) \n"
												+ "   ELSE DATEDIFF(RCPT.Date,PUR.ESD)END) >=29 THEN 'Violated' \n"
												+ "   WHEN ((CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) \n"
												+ "   ELSE DATEDIFF(RCPT.Date,PUR.ESD)END)  < 29 && (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) \n"
												+ "   ELSE DATEDIFF(RCPT.Date,PUR.ESD)END) >=15) THEN 'Delayed'\n"
												+ "   ELSE 'In Time' END) AS Contrat\n"
												+ "FROM PROJECT AS pj LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID\n"
												+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)\n"
												+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID \n"
												+ "AND RCPT.Module_type = PUR.MOdule_type)";
	
	private final String horrible_tables_join2= "SELECT pj.Project_ID, pj.Project_status, pj.Emp_ID, emp.Last_name AS Responsable, PUR.Module_type,\n"
												+ "pj.Delivery_progress, PUR.ESD, RCPT.Date, (CASE WHEN (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) >= 29 THEN 'Violated'\n"
												+ "WHEN((CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) < 29 && (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
												+ "ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) >= 15) THEN 'Delayed' ELSE 'In Time' END) AS Contract,\n"
												+ "(CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) AS Date_difference\n"
												+ "FROM PROJECT AS pj LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID\n"
												+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)\n"
												+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID AND RCPT.Module_type = PUR.MOdule_type)\n"
												+ "ORDER BY Date_difference DESC";
	
	public Progress_panel() {
		
		lib = new Library();
		panel();
	}
	
	
	private void panel() {
		
		progress_panel = new JPanel();
		Term_project_main.container_panel.add(progress_panel,"progress");
		progress_panel.setLayout(null);
		
		JLabel lbl_prog = new JLabel("Progress");
		lbl_prog.setBounds(48, 12, 54, 16);
		progress_panel.add(lbl_prog);
		
		JLabel lbl_prog_projectID = new JLabel("Project ID :");
		lbl_prog_projectID.setBounds(73, 85, 69, 29);
		progress_panel.add(lbl_prog_projectID);
		
		text_prog_pjID = new JTextField();
		text_prog_pjID.setBounds(146, 86, 119, 26);
		progress_panel.add(text_prog_pjID);
		text_prog_pjID.setColumns(10);
		
		JButton btn_prog_inquire_all = new JButton("All");
		btn_prog_inquire_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[][] temp = show_project_status("all");
				
				if (temp.length!=0) {
					
					String[] columns_name = {"Project ID", "status", "Employee ID", "Responsable", "Module", "Delivery Progress",
																										"ESD", "Receipt Date", "Contract Status"};
					DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);					
					prog_table.setModel(prog_table_model);
					lbl_prog_message.setText("Data loaded");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(true);
					scrollpane_prog.setVisible(true);
					
				}else {
					//temp.length==0 
					//project no found
					
					lbl_prog_message.setText("No project is working");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					
				}
			}
		});
		btn_prog_inquire_all.setBounds(500, 108, 77, 29);
		progress_panel.add(btn_prog_inquire_all);
		
		JButton btn_prog_attention = new JButton("Attention !");
		btn_prog_attention.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[][] temp = show_project_status("attention");
				
				if (temp.length!=0) {
					
					String[] columns_name = {"Project ID", "status", "Employee ID", "Responsable", "Module", "Delivery Progress",
																										"ESD", "Receipt Date", "Contract Status"};
					DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);					
					prog_table.setModel(prog_table_model);
					lbl_prog_message.setText("Data loaded");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(true);
					scrollpane_prog.setVisible(true);
					
				}else {
					//temp.length==0 
					//project no found
					
					lbl_prog_message.setText("No project is working");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					
				}
			}
		});
		btn_prog_attention.setBounds(480, 141, 111, 29);
		progress_panel.add(btn_prog_attention);
		
		prog_table = new JTable(){ 
			@Override
			public boolean isCellEditable(int row, int column)
            {
                                  return false;}//uneditable
            
			};
		prog_table.setBounds(40, 229, 1000, 150);
		
		prog_table.setVisible(false);

		scrollpane_prog = new JScrollPane(prog_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_prog.setBounds(40, 229, 580, 156);
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
		go_back = go_back.getScaledInstance(21, 21,  java.awt.Image.SCALE_AREA_AVERAGING) ;
		btn_back2pj.setIcon(new ImageIcon(go_back));
		progress_panel.add(btn_back2pj);
		
		JButton btnNewButton = new JButton("Inquire");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(lib.num_not_null_check(text_prog_pjID)) {
					
					String[][] temp = show_project_status("inquire");
					
					if (temp.length!=0) {
						
						String[] columns_name = {"Project ID", "status", "Employee ID", "Responsable", "Module", "Delivery Progress",
																											"ESD", "Receipt Date", "Contract Status"};
						DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);					
						prog_table.setModel(prog_table_model);
						lbl_prog_message.setText("Data loaded");
						lbl_prog_message.setVisible(true);
						prog_table.setVisible(true);
						scrollpane_prog.setVisible(true);
						
					}else {
						//temp.length==0 
						//project no found
						lbl_prog_message.setText("No project is working");
						lbl_prog_message.setVisible(true);
						prog_table.setVisible(false);
						scrollpane_prog.setVisible(false);	
					}
				}else {
					lbl_prog_message.setText("ID format invalid");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);	
				}
				
			}
		});
		btnNewButton.setBounds(287, 86, 77, 29);
		progress_panel.add(btnNewButton);
		
		lbl_prog_message = new JLabel("");
		lbl_prog_message.setBounds(73, 197, 518, 16);
		lbl_prog_message.setVisible(false);
		progress_panel.add(lbl_prog_message);
		
		
	}
	
	
	
	private String[][] show_project_status(String st) {
		
		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 */
		
		ArrayList<String[]> temp = new ArrayList();
		
		switch(st) {
		
		case "attention":
			
			if(lib.supervisor_check(Term_project_main.field_empID)) {
				
				try {
					
					ResultSet r = Term_project_main.conn.st.executeQuery(horrible_tables_join2);
					
					while(r.next()) {
						if(r.getInt(10)>=15) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								
								temp_array[i-1]=r.getString(i);
								//System.out.print(temp_array[i-1]);
							}
							temp.add(temp_array);
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			else {
				//not supervisor can only see the project on his responsibility
				try {
					
					ResultSet r = Term_project_main.conn.st.executeQuery(horrible_tables_join2+" WHERE pj.Emp_ID="+Term_project_main.field_empID.getText());
					
					while(r.next()) {
						if(r.getInt(10)>=15) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								
								temp_array[i-1]=r.getString(i);
								//System.out.print(temp_array[i-1]);
							}
							temp.add(temp_array);
						}
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		
		
			case "inquire":
				
				if(lib.supervisor_check(Term_project_main.field_empID)) {
					
					try {
						
						ResultSet r = Term_project_main.conn.st.executeQuery(horrible_tables_join+" WHERE pj.Project_ID="+text_prog_pjID.getText());
						
						while(r.next()) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								temp_array[i-1]=r.getString(i);
								//System.out.print(temp_array[i-1]);
							}
							temp.add(temp_array);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				else {
					//not supervisor can only see the project on his responsibility
					try {
						
						ResultSet r = Term_project_main.conn.st.executeQuery(horrible_tables_join+" WHERE (pj.Emp_ID="
															+Term_project_main.field_empID.getText()+" AND pj.Project_ID="+text_prog_pjID.getText()+")");
						
						while(r.next()) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								temp_array[i-1]=r.getString(i);
							}
							temp.add(temp_array);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
		
		
			default:
				//all
				if(lib.supervisor_check(Term_project_main.field_empID)) {
					
					try {
						
						ResultSet r = Term_project_main.conn.st.executeQuery(horrible_tables_join);
						
						while(r.next()) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								temp_array[i-1]=r.getString(i);
								//System.out.print(temp_array[i-1]);
							}
							temp.add(temp_array);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				else {
					//not supervisor can only see the project on his responsibility
					try {
						
						ResultSet r = Term_project_main.conn.st.executeQuery(horrible_tables_join+" WHERE pj.Emp_ID="+Term_project_main.field_empID.getText());
						
						while(r.next()) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								temp_array[i-1]=r.getString(i);
							}
							temp.add(temp_array);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
			
		}
		String[][] result_array = new String[temp.size()][9];
		int i=0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		        }
		//System.out.print(result_array.length);
		return result_array;
	}
}
