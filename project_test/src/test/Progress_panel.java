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
		
		JLabel lbl_note = new JLabel("P.D.P = Product Delivery Progress, E.S.D = Estimated Ship Date");
		lbl_note.setBounds(18, 170, 619, 16);
		progress_panel.add(lbl_note);
		
		JButton btn_prog_inquire_all = new JButton("All");
		btn_prog_inquire_all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String[][] temp = show_project_status("all");
				
				if (temp.length!=0) {
					
					String[] columns_name = {"Project ID", "P.status", "Employee ID", "E.Name", "Module", "*P.D.P",
																				"*E.S.D", "Receipt Date", "Contract"};
					DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);	
					
					prog_table.setModel(prog_table_model);
					
					lbl_prog_message.setText("Data loaded");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(true);
					scrollpane_prog.setVisible(true);
					lbl_note.setVisible(true);
					
				}else {
					//temp.length==0 
					//project no found
					
					lbl_prog_message.setText("No project is working");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					lbl_note.setVisible(false);
					
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
					
					String[] columns_name = {"Project ID", "P.status", "Employee ID", "E.Name", "Module", "*P.D.P",
																										"*E.S.D", "Receipt Date", "Contract"};
					DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);					
					prog_table.setModel(prog_table_model);
//					TableColumnModel column_model = prog_table.getColumnModel();
					//prog_table.setPreferredScrollableViewportSize(prog_table.getPreferredSize());//????
					
//					column_model.getColumn(0).setPreferredWidth(50);
//					column_model.getColumn(2).setPreferredWidth(40);
//					column_model.getColumn(3).setPreferredWidth(30);
//					column_model.getColumn(5).setPreferredWidth(30);
//					column_model.getColumn(7).setPreferredWidth(30);
//					column_model.getColumn(8).setPreferredWidth(30);
					lbl_prog_message.setText("Data loaded");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(true);
					scrollpane_prog.setVisible(true);
					lbl_note.setVisible(true);
					
				}else {
					//temp.length==0 
					//project no found
					
					lbl_prog_message.setText("No project is working");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);
					lbl_note.setVisible(false);
					
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
		//prog_table.setBounds(40, 229, 10000, 150);
		prog_table.setPreferredScrollableViewportSize(new Dimension(5000, 300));//?????
		prog_table.setFillsViewportHeight(true);
		prog_table.setVisible(false);

		scrollpane_prog = new JScrollPane(prog_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_prog.setBounds(18, 198, 619, 158);
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
						
						String[] columns_name = {"Project ID", "P.status", "Employee ID", "E.Name", "Module", "*P.D.P",
																			"*E.S.D", "Receipt Date", "Contract"};
						DefaultTableModel prog_table_model = new DefaultTableModel(temp, columns_name);					
						prog_table.setModel(prog_table_model);
						lbl_prog_message.setText("Data loaded");
						lbl_prog_message.setVisible(true);
						prog_table.setVisible(true);
						scrollpane_prog.setVisible(true);
						lbl_note.setVisible(true);
						
					}else {
						//temp.length==0 
						//project no found
						lbl_prog_message.setText("No project is working");
						lbl_prog_message.setVisible(true);
						prog_table.setVisible(false);
						scrollpane_prog.setVisible(false);
						lbl_note.setVisible(false);
					}
				}else {
					lbl_prog_message.setText("ID format invalid");
					lbl_prog_message.setVisible(true);
					prog_table.setVisible(false);
					scrollpane_prog.setVisible(false);	
					lbl_note.setVisible(false);
				}
				
			}
		});
		btnNewButton.setBounds(287, 86, 77, 29);
		progress_panel.add(btnNewButton);
		
		lbl_prog_message = new JLabel("");
		lbl_prog_message.setBounds(73, 133, 384, 16);
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
		
		final String st_progress = "SELECT \n"
				+ "    pj.Project_ID,\n"
				+ "    pj.Project_status,\n"
				+ "    pj.Emp_ID,\n"
				+ "    emp.Last_name AS Responsable,\n"
				+ "    PUR.Module_type,\n"
				+ "    CONCAT(FORMAT(((Pur.Vol*100)/ RCPT.Vol),0),'%') AS Product_Delivery,\n"
				+ "    PUR.ESD,\n"
				+ "    RCPT.Date,\n"
				+ "    (CASE\n"
				+ "        WHEN\n"
				+ "            (CASE\n"
				+ "                WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
				+ "                ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
				+ "            END) >= 29\n"
				+ "        THEN\n"
				+ "            'Violated'\n"
				+ "        WHEN\n"
				+ "            ((CASE\n"
				+ "                WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
				+ "                ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
				+ "            END) < 29\n"
				+ "                && (CASE\n"
				+ "                WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
				+ "                ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
				+ "            END) >= 15)\n"
				+ "        THEN\n"
				+ "            'Delayed'\n"
				+ "        ELSE 'In Time'\n"
				+ "    END) AS Contract,\n"
				+ "    (CASE\n"
				+ "        WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
				+ "        ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
				+ "    END) AS Date_difference\n"
				+ "FROM\n"
				+ "    test.PROJECT AS pj\n"
				+ "        LEFT JOIN\n"
				+ "    test.EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID\n"
				+ "        LEFT JOIN\n"
				+ "    test.PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)\n"
				+ "        LEFT JOIN\n"
				+ "    test.RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID\n"
				+ "        AND RCPT.Module_type = PUR.MOdule_type)";
		
		ArrayList<String[]> temp = new ArrayList();
		
		switch(st) {
		
		case "attention":
			
			if(lib.supervisor_check(Term_project_main.field_empID)) {
				
				try {
					
					ResultSet r = Term_project_main.conn.st.executeQuery(st_progress+" ORDER BY Date_difference DESC");
					
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
					
					ResultSet r = Term_project_main.conn.st.executeQuery(st_progress+" ORDER BY Date_difference DESC"
							+ " WHERE pj.Emp_ID="+Term_project_main.field_empID.getText());
					
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
						
						ResultSet r = Term_project_main.conn.st.executeQuery(st_progress+" WHERE pj.Project_ID="+text_prog_pjID.getText());
						
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
						
						ResultSet r = Term_project_main.conn.st.executeQuery(st_progress+" WHERE (pj.Emp_ID="
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
						
						ResultSet r = Term_project_main.conn.st.executeQuery(st_progress);
						
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
						
						ResultSet r = Term_project_main.conn.st.executeQuery(st_progress+" WHERE pj.Emp_ID="+Term_project_main.field_empID.getText());
						
						while(r.next()) {
							String[] temp_array = new String[9];
							for(int i =1;i<10;i++) {
								temp_array[i-1]=r.getString(i);
							}
							if(!(temp_array[5].equals("null")))
								temp_array[5]=temp_array[5]+"%";
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
