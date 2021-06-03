package test;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
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
import java.util.ArrayList;
public class Maintenance_panel  {
	
		/**
	     * @autohr Jyun-An
	     * @ver. 1.2.2 05/28   
	     * Seperated from Project_test
	     **/
	
		public JPanel core_maint_panel;
		private JPanel maint_container_panel;
		private JComboBox comboBox_pj;
		
		private JPanel default_panel;
		
		private JPanel inq_panel;	
		private JTable inq_table;
		private DefaultTableModel inq_table_model;
		private JScrollPane scrollpane;
		private JLabel lbl_result;
		
		private JPanel maint_panel;
		private JTextField text_maint_pjID;
		private JLabel lbl_maint_pjID_show;
		private JLabel lbl_maint_empID;
		private JTextField text_maint_empID;
		private JTextField text_maint_date;
		private JLabel lbl_maint_status;
		private JLabel lbl_maint_del_status;
		private JLabel lbl_maint_status_show;
		private JLabel lbl_maint_del_progress;
		private JLabel lbl_maint_del_progress_show;
		
		private JButton btn_maint;
		
		private JButton btn_maint_check;
		private JLabel lbl_maint_date;
		private JLabel lbl_maint_del_status_show;
		//private JTextField text_inq_pjID;
		
		
		
		private CardLayout cl_maint;
		//private JTextField text_inq_empID;
		private JButton btn_refresh;
		private JLabel lbl_maint_result;
		
		
		
		
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public Maintenance_panel(String st) {
			
			
			if (st.equalsIgnoreCase("panel"))
					proj_maintc_panels();
			
			
			
		}
	
	
		private void proj_maintc_panels() {
			
			//core sheet panel which contains comboBox
			core_maint_panel = new JPanel();
			Term_project_main.container_panel.add(core_maint_panel,"maintenance");
			core_maint_panel.setLayout(null);
			
			//smaller panel on the core maint panel
			cl_maint = new CardLayout();
			maint_container_panel = new JPanel(cl_maint);
			
			maint_container_panel.setBounds(0, 35, 666, 348);
			maint_container_panel.setBackground(Color.CYAN);
			core_maint_panel.add(maint_container_panel);
			
			
			//add 5 sub project maintenance panels
			
			add_default_panel();
			add_inquire_panel();
			add_maintenance_panel();
			
			
			
			comboBox_pj = new JComboBox( new String[] {"-----------","Inquire","Modify","Append", "Delete"});
			comboBox_pj.setBounds(245, 7, 159, 27);
//			comboBox_pj.addItem("--------");
//			comboBox_pj.addItem("Inquire");
//			comboBox_pj.addItem("Modify");
//			comboBox_pj.addItem("Append");
//			comboBox_pj.addItem("Remove");
			
			
			
			comboBox_pj.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox_pj.getSelectedItem(); //get the selected item
		            	
		            	switch (function){
		            	
		            		
		            		case "Modify":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Modify");
		            			
		            			btn_maint_check.setVisible(true);
		            			set_visible(false);
		            			break;
		            			
		            		case "Append":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Append");
		            			
		            			
		            			btn_maint_check.setVisible(false);
		            			set_visible(true);
		            			break;
		            			
		            		case "Delete":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Delete");
		            			
		            			
		            			btn_maint_check.setVisible(true);
		            			set_visible(false);
		            			break;
		            			
		            		default:
		            			cl_maint.show(maint_container_panel, function);
		            			break;
		            		
		            	}
		            	//cl_maint.show(maint_container_panel, function);		                   
		            }
		        });
		
			core_maint_panel.add(comboBox_pj);
			
			JButton btn_back2pj = new JButton("");
			btn_back2pj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
				}
			});
			Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
			go_back = go_back.getScaledInstance( 21, 21,  java.awt.Image.SCALE_AREA_AVERAGING) ;
			btn_back2pj.setIcon(new ImageIcon(go_back));
			btn_back2pj.setBounds(16, 4, 30, 30);
			core_maint_panel.add(btn_back2pj);
			
			JLabel lbl_maint = new JLabel("Maintenance");
			lbl_maint.setBounds(58, 11, 87, 16);
			core_maint_panel.add(lbl_maint);
		}
		
		
		
		
		//default panel
		private void add_default_panel() {
			default_panel = new JPanel();
			default_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(default_panel, "-----------");
			default_panel.setLayout(null);
		}
		
		//first panel - Inquire 
		private void add_inquire_panel() {
			
			inq_panel = new JPanel();
			inq_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(inq_panel, "Inquire");
			inq_panel.setLayout(null);
			
					
			JLabel lbl_inq_pjID = new JLabel("project ID :");
			lbl_inq_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_inq_pjID.setBounds(50, 11, 86, 16);
			inq_panel.add(lbl_inq_pjID);
					
			JTextField text_inq_pjID = new JTextField();
			text_inq_pjID.setBounds(136, 6, 141, 26);
			inq_panel.add(text_inq_pjID);
			text_inq_pjID.setColumns(10);
					
			JLabel lbl_inq_date = new JLabel("Est. Date :");
			lbl_inq_date.setBounds(30, 97, 106, 16);
			lbl_inq_date.setHorizontalAlignment(SwingConstants.RIGHT);
			inq_panel.add(lbl_inq_date);
					
			JTextField text_inq_date = new JTextField();
			text_inq_date.setBounds(136, 92, 141, 26);
			inq_panel.add(text_inq_date);
			text_inq_date.setColumns(10);
			
			JLabel lbl_inq_empID = new JLabel("Employee ID :");
			lbl_inq_empID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_inq_empID.setBounds(50, 57, 86, 16);
			inq_panel.add(lbl_inq_empID);
					
			JTextField text_inq_empID = new JTextField();
			text_inq_empID.setBounds(136, 54, 141, 26);
			inq_panel.add(text_inq_empID);
			text_inq_empID.setColumns(10);
			
			JButton btn_inq_inquire = new JButton("Inquire");
			btn_inq_inquire.setBounds(364, 52, 87, 29);
			btn_inq_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String [] columns_name = {"Project ID", "Employee ID", "Est. Date", "Status", "Delivery Status", "Delivery Progress"};
//					String [][] temp = {{"90000000","11047630","2021/3/3","EXAM","",""}, {"90000008","11047638","2021/3/11","RCPT","",""},
//												{"90000010","11047640","2021/3/13","EXAM","",""}, {"90000013","11047643","2021/3/16","RCPT","",""}};
				String[][] temp = inquire(text_inq_pjID,text_inq_empID,text_inq_date);
					
//					for(int j=0; j<temp.length;j++) {
//							System.out.print("\n");
//								for(int i=0;i<6;i++) {
//									System.out.print(temp[j][i]+"\t");	
//									}	
//							}
					if (temp.length != 0 ) {
						inq_table_model = new DefaultTableModel(temp, columns_name);
						inq_table.setModel(inq_table_model);
						
						TableColumnModel column_model = inq_table.getColumnModel();
						column_model.getColumn(0).setPreferredWidth(50);
						column_model.getColumn(1).setPreferredWidth(50);
						column_model.getColumn(2).setPreferredWidth(50);
						column_model.getColumn(3).setPreferredWidth(40);
						column_model.getColumn(4).setPreferredWidth(60);
						column_model.getColumn(5).setPreferredWidth(80);
						inq_table.setVisible(true);
						scrollpane.setVisible(true);
						lbl_result.setText("Data load succeed");
					}
					else {
						lbl_result.setText("no found");
					}
				}
			});
			inq_panel.add(btn_inq_inquire);
					
			
					
			
					
			JButton btn_inq_last20 = new JButton("Last 20");
			btn_inq_last20.setBounds(364, 92, 87, 29);
			btn_inq_last20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//library.btn_inquire();
					inq_panel.setVisible(true);
				}
			});
			inq_panel.add(btn_inq_last20);
					
			lbl_result = new JLabel("");
			lbl_result.setBounds(30, 152, 529, 16);
			inq_panel.add(lbl_result);
					
			inq_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column)
            {
                                  return false;}//uneditable
            
			}; 
			inq_table.setBounds(29, 195, 612, 153);
			//inq_panel.add(inq_table);
			inq_table.setVisible(false);
			
			scrollpane = new JScrollPane(inq_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollpane.setBounds(49,241,563,87);
			scrollpane.setVisible(false);
			inq_panel.add(scrollpane);
		}
		
		//Second panel - Maintenance
		private void add_maintenance_panel() {
			
			maint_panel = new JPanel();
			maint_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(maint_panel, "Maintenance");
			maint_panel.setLayout(null);
			
			JLabel lbl_maint_pjID = new JLabel("*project ID :");
			lbl_maint_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_pjID.setBounds(162, 41, 86, 16);
			maint_panel.add(lbl_maint_pjID);
			
			text_maint_pjID = new JTextField();
			text_maint_pjID.setBounds(260, 36, 130, 30);
			maint_panel.add(text_maint_pjID);
			text_maint_pjID.setColumns(10);
			
			
			btn_maint = new JButton("");
			btn_maint.setBounds(490, 200, 87, 29);
			maint_panel.add(btn_maint);
			
			lbl_maint_empID = new JLabel("Employee ID :");
			
			lbl_maint_empID.setBounds(162, 85, 86, 16);
			maint_panel.add(lbl_maint_empID);
			
			text_maint_empID = new JTextField();
			text_maint_empID.setBounds(260, 78, 130, 30);
			maint_panel.add(text_maint_empID);
			text_maint_empID.setColumns(10);
			
			lbl_maint_date = new JLabel("Est. Date :");
			lbl_maint_date.setBounds(142, 118, 108, 16);
			lbl_maint_date.setHorizontalAlignment(SwingConstants.RIGHT);
			maint_panel.add(lbl_maint_date);
			
			text_maint_date = new JTextField();
			text_maint_date.setBounds(260, 113, 130, 30);
			maint_panel.add(text_maint_date);
			text_maint_date.setColumns(10);
			
			lbl_maint_status = new JLabel("Project Status :");
			lbl_maint_status.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_status.setBounds(146, 163, 102, 16);
			maint_panel.add(lbl_maint_status);
			
			lbl_maint_del_status = new JLabel("Delivery Status :");
			lbl_maint_del_status.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_del_status.setBounds(146, 213, 102, 16);
			maint_panel.add(lbl_maint_del_status);
			
			lbl_maint_del_status_show = new JLabel("NNNN");
			lbl_maint_del_status_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_del_status_show.setBounds(260, 206, 130, 30);
			maint_panel.add(lbl_maint_del_status_show);
			
			lbl_maint_status_show = new JLabel("NNNN");
			lbl_maint_status_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_status_show.setBounds(260, 163, 130, 23);
			maint_panel.add(lbl_maint_status_show);
			
			lbl_maint_del_progress = new JLabel("Delivery Progress :");
			lbl_maint_del_progress.setBounds(130, 270, 117, 16);
			maint_panel.add(lbl_maint_del_progress);
			
			lbl_maint_del_progress_show = new JLabel("NNNN");
			lbl_maint_del_progress_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_del_progress_show.setBounds(260, 270, 130, 16);
			maint_panel.add(lbl_maint_del_progress_show);
			
			btn_maint_check = new JButton("Check ");
			btn_maint_check.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String[] temp = check_ID(text_maint_pjID);
					System.out.print(temp.length);
					if(temp.length == 0) {
						lbl_maint_result.setText("no found");
						
					}else {
						//temp.length != 0
						
						set_visible(true);
						text_maint_empID.setText(temp[1]);
						text_maint_date.setText(temp[2]);
						lbl_maint_status_show.setText(temp[3]);
						lbl_maint_del_status_show.setText(temp[4]);
						lbl_maint_del_progress_show.setText(temp[5]);
						
						
						text_maint_pjID.setVisible(false);     						//let projectID be uneditable
						lbl_maint_pjID_show.setText(text_maint_pjID.getText());
						lbl_maint_pjID_show.setVisible(true);
						lbl_maint_result.setText("Data loading succeed");	
						
					}
				}
			});
			btn_maint_check.setBounds(402, 36, 78, 29);
			maint_panel.add(btn_maint_check);
			
			btn_refresh = new JButton("Refresh");
			btn_refresh.setBounds(481, 36, 86, 29);
			maint_panel.add(btn_refresh);
			
			lbl_maint_pjID_show = new JLabel("");
			lbl_maint_pjID_show.setBounds(260, 41, 130, 25);
			lbl_maint_pjID_show.setVisible(false);
			maint_panel.add(lbl_maint_pjID_show);
			
			lbl_maint_result = new JLabel("");
			lbl_maint_result.setBounds(412, 85, 61, 16);
			maint_panel.add(lbl_maint_result);
		}

		
		
		
		
		private String[][] inquire(JTextField projectID, JTextField empID, JTextField est_date){
			
			/**@author jyunanyang
			 * @since 06/02/2021
			 * pass in 3 JTextFields and use switch case to handle every situation which they are filled in or not. 
			 */
			
			
			ArrayList<String[]> temp = new ArrayList();
			
			switch (check_text_fields(projectID, empID, est_date)) {
			
			
					case "111":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE (Project_ID=" + 
									projectID.getText()+" AND Emp_ID="+ empID.getText()+" AND Established_date=\'"
													+est_date.getText()+"\')");
							
							if(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								break;
							}
							break;
							
					
						}catch (SQLException e) {
						// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
							}
						
					case "110":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE (Project_ID=" + 
									projectID.getText()+" AND Emp_ID="+ empID.getText()+")");
							
							if(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								break;
							}
							break;
					
					
						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
							}
						
					case "101":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE (Project_ID=" + 
									projectID.getText()+" AND Established_date=\'"+est_date.getText()+"\')");
							
							if(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								break;
							}
							break;
					
					
						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
							}
						
					case "100":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE Project_ID=" + 
									projectID.getText());
							
							if(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								break;
							}
							break;
					
					
						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
							}
					
					case "011":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE (Emp_ID="+
													empID.getText()+" AND Established_date=\'"+est_date.getText()+"\')");
							int k=0;
							while(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								k++;
							}
							break;
					
					
						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							//e.printStackTrace();
							
							break;
							}
						
					case "010":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE Emp_ID="+
													empID.getText());
							
							int k=0;
							while(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								k++;
							}
							break;

						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							//e.printStackTrace();
							break;
							}
						
					default:
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE Established_date=\'"+
													est_date.getText()+"\'");
							
							int k=0;
							while(resultSet.next()) {
								String [] temp_array = new String[6];
								for(int i = 1; i<7; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
								k++;
							}
							break;

						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							e.printStackTrace();
							
							break;
							}		
			}
			String[][] result_array = new String[temp.size()][6];
			int i=0;
			for (String[] array_in_temp : temp) {
				result_array[i++] = array_in_temp;
			        }
			return result_array;
		}

		
		public String check_text_fields(JTextField ID, JTextField else1, JTextField else2) {
			/**@author jyunanyang
			 * @since 06/02/2021
			 * to check how many JTextField are filled by user and return a String to 
			 * be represente the status for switch case in inquire function.
			 */
			
			if (!(ID.getText().isEmpty())) {
				//1
				if (!(else1.getText().isEmpty())) {
					//1-1
					if (!(else2.getText().isEmpty())) {
						//1-1-1
						return "111";
					}else {
						//1-1-0
						return "110";
					}
				}else if(!(else2.getText().isEmpty())) {
					//1-0-1
					return "101";		
					}else {
						//1-0-0
						return "100";
					}
			}else if (!(else1.getText().isEmpty())) {
				//0-1
				if (!(else2.getText().isEmpty())) {
					//0-1-1
					return "011";
					}else {
						//0-1-0
						return "010";
					}
			}else {
				//0-0-1
				return "001";
			}

		}
		
		
		private String [] check_ID(JTextField ID) {
			

			String [] temp;
			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT WHERE Project_ID=" + ID.getText());
				
				if(resultSet.next()) {
					 temp= new String[6];
					for(int i = 1; i<7; i++) {
						temp[i-1]= resultSet.getString(i);
						System.out.print(resultSet.getString(i));
					}
					return temp;
				}
				temp= new String[0];
				return temp;
		
		
			}catch (SQLException e) {
				
			// TODO Auto-generated catch block
				temp= new String[0];
				e.printStackTrace();
				return temp;
				}
			
		}
		
		
		private void set_visible(boolean bl) {
			
			lbl_maint_empID.setVisible(bl);
			text_maint_empID.setVisible(bl);
			
			lbl_maint_date.setVisible(bl);
			text_maint_date.setVisible(bl);
			
			lbl_maint_status.setVisible(bl);
			lbl_maint_status_show.setVisible(bl);
			
			lbl_maint_del_progress.setVisible(bl);
			lbl_maint_del_progress_show.setVisible(bl);
			
			lbl_maint_del_status.setVisible(bl);
			lbl_maint_del_status_show.setVisible(bl);
			
			
			
			
		}
		
		public JComboBox get_comboBox_project() {
			
			return comboBox_pj;
		}
}
