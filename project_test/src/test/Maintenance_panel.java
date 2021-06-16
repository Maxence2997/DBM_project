package test;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import java.util.Arrays;
import java.util.Date;
import java.awt.Font;
public class Maintenance_panel  {
	
		/**
	     * @autohr Jyun-An
	     * @ver. 1.2.2 05/28   
	     * Seperated from Project_test
	     **/
		
		private Library lib;
		public JPanel core_maint_panel;
		private JPanel maint_container_panel;
		private JComboBox comboBox_pj;
		
		private JPanel default_panel;
		
		private JPanel inq_panel;	
		private JTable inq_table;
		private JScrollPane scrollpane;
		private JLabel lbl_result;
		private JTextField text_inq_date;
		private JTextField text_inq_pjID;
		private JTextField text_inq_empID;
		
		private JPanel maint_panel;
		private JTextField text_maint_pjID;
		private JLabel lbl_maint_pjID_show;
		private JLabel lbl_maint_empID;
		private JTextField text_maint_empID;
		private JTextField text_maint_date;
		private JLabel lbl_maint_status;
		private	JLabel lbl_maint_pjID;
		private JLabel lbl_maint_emp_name_show;
		private JLabel lbl_maint_status_show;
		private JLabel lbl_date_default;
		
		private JButton btn_maint;
		
		private JButton btn_maint_check;
		private JLabel lbl_maint_date;
		
		//private JTextField text_inq_pjID;
		
		
		
		private CardLayout cl_maint;
		//private JTextField text_inq_empID;
		private JButton btn_clear;
		private JLabel lbl_maint_result;
		private JLabel lbl_inq_date_format;
		private JLabel lbl_maint_ins;
		private JLabel lbl_maint_emp_name;
//		private JTextField text_inq_month;
//		private JTextField text_inq_day;
		
		
		
		
		
		
		/**
		 * @wbp.parser.entryPoint
		 */
		public Maintenance_panel() {
			
			lib = new Library();
			proj_maint_panels();
					
					
		}
	
	
		private void proj_maint_panels() {
			
			//core sheet panel which contains comboBox
			core_maint_panel = new JPanel();
			core_maint_panel.setBounds(0,26,1000,450);
			Term_project_main.container_panel.add(core_maint_panel,"maintenance");
			core_maint_panel.setLayout(null);
			
			//smaller panel on the core maint panel
			cl_maint = new CardLayout();
			maint_container_panel = new JPanel(cl_maint);
			
			maint_container_panel.setBounds(0, 35, 1000, 380);
			maint_container_panel.setBackground(Color.CYAN);
			core_maint_panel.add(maint_container_panel);
			
			
			//add 5 sub project maintenance panels
			
			add_default_panel();
			add_inquire_panel();
			add_maintenance_panel();
			
			
			
			comboBox_pj = new JComboBox( new String[] {"-----------","Inquire","Modify","Append", "Delete"});
			comboBox_pj.setBounds(435, 5, 159, 27);

			comboBox_pj.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox_pj.getSelectedItem(); //get the selected item
		            	
		            	switch (function){
		            	
		            		
		            		case "Modify":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			
		            			
		            			btn_maint.setText("Modify");
		            			btn_maint.setVisible(false);
		            			btn_clear.setVisible(false);
		            			btn_maint_check.setVisible(true);
		            			lbl_maint_ins.setVisible(true);
		            			lbl_maint_pjID.setVisible(true);
		            			text_maint_pjID.setVisible(true);
		            			set_visible(false);
		            			clear_maint_panel();
		            			break;
		            			
		            		case "Append":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Append");
		            			
		            			text_maint_pjID.setVisible(false);
		            			btn_maint_check.setVisible(false);
		            			
		            			set_visible(true);
		            			clear_maint_panel();
		            			break;
		            			
		            		case "Delete":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Delete");
		            			
		            			text_maint_pjID.setVisible(true);
		            			btn_maint_check.setVisible(true);
		            			btn_clear.setVisible(false);
		            			btn_maint.setVisible(false);
		            			set_visible(false);
		            			clear_maint_panel();
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
			
					
			JLabel lbl_inq_pjID = new JLabel("Project ID :");
			lbl_inq_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_inq_pjID.setBounds(250, 45, 86, 16);
			inq_panel.add(lbl_inq_pjID);
					
			text_inq_pjID = new JTextField();
			text_inq_pjID.setHorizontalAlignment(SwingConstants.CENTER);
			text_inq_pjID.setBounds(336, 40, 141, 26);
			inq_panel.add(text_inq_pjID);
			text_inq_pjID.setColumns(10);
					
			JLabel lbl_inq_date = new JLabel("Est. Date :");
			lbl_inq_date.setBounds(230, 131, 106, 16);
			lbl_inq_date.setHorizontalAlignment(SwingConstants.RIGHT);
			inq_panel.add(lbl_inq_date);
					
			text_inq_date = new JTextField();
			text_inq_date.setHorizontalAlignment(SwingConstants.CENTER);
			text_inq_date.setBounds(336, 126, 141, 26);
			inq_panel.add(text_inq_date);
			text_inq_date.setColumns(10);
			
			JLabel lbl_inq_empID = new JLabel("Employee ID :");
			lbl_inq_empID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_inq_empID.setBounds(250, 88, 86, 16);
			inq_panel.add(lbl_inq_empID);
					
			text_inq_empID = new JTextField();
			text_inq_empID.setHorizontalAlignment(SwingConstants.CENTER);
			text_inq_empID.setBounds(336, 84, 141, 26);
			inq_panel.add(text_inq_empID);
			text_inq_empID.setColumns(10);
			
			JButton btn_inq_inquire = new JButton("Inquire");
			btn_inq_inquire.setBounds(564, 86, 87, 29);
			btn_inq_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
//					String [][] temp = {{"90000000","11047630","2021/3/3","EXAM",""}, {"90000008","11047638","2021/3/11","RCPT",""},
//												{"90000010","11047640","2021/3/13","EXAM",""}, {"90000013","11047643","2021/3/16","RCPT",""}};
					try{							
						if (!text_inq_pjID.getText().isBlank()) 
							Integer.parseInt(text_inq_pjID.getText());
						
						if (!text_inq_empID.getText().isBlank())
							Integer.parseInt(text_inq_empID.getText());
						
						if(!text_inq_date.getText().isBlank()) {
							if(lib.date(text_inq_date.getText())) {
								
								String[][] temp = inquire(text_inq_pjID,text_inq_empID,text_inq_date);
								
								if (temp.length != 0 ) {
									
									String [] columns_name = {"Project ID", "Employee ID", "E.Name", "Status", "Product", "RFQ ID", "QUOT. ID",
											"REQ. ID", "PUR. ID", "EXAM. ID", "RCPT ID","Est. Date"};
									DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
									inq_table.setModel(inq_table_model);
									
									TableColumnModel column_model = inq_table.getColumnModel();
									
									scrollpane.setVisible(true);
									lbl_result.setText("Data load succeed");
									lbl_result.setVisible(true);
									
								}else {
									lbl_result.setText("no found");
									lbl_result.setVisible(true);
									}
							}else {
								lbl_result.setText("date format Invalid");
								lbl_result.setVisible(true);
							}
							
						}else { 
							//text_inq_date.getText().isBlank()
							String[][] temp = inquire(text_inq_pjID,text_inq_empID,text_inq_date);
							
							if (temp.length != 0 ) {
								
								String [] columns_name = {"Project ID", "Employee ID", "Name", "Status", "Product", "RFQ ID", "QUOT. ID",
										"REQ. ID", "PUR. ID", "EXAM. ID", "RCPT ID","Est. Date"};
								DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
								inq_table.setModel(inq_table_model);
								
								inq_table.getColumnModel().getColumn(2).setPreferredWidth(100);
								inq_table.getColumnModel().getColumn(3).setPreferredWidth(50);
								inq_table.getColumnModel().getColumn(4).setPreferredWidth(70);
								inq_table.getColumnModel().getColumn(11).setPreferredWidth(90);
								
								inq_table.setVisible(true);
								scrollpane.setVisible(true);
								lbl_result.setText("Data load succeed");
								lbl_result.setVisible(true);
								
							}else {
								lbl_result.setText("no found");
								lbl_result.setVisible(true);
								}
						}
					}catch (NumberFormatException ex) {
						//handle exception here
							
						lbl_result.setText("Format Invalid");
						lbl_result.setVisible(true);
						}
				}
			});
			inq_panel.add(btn_inq_inquire);
							
			JButton btn_inq_last20 = new JButton("Last 20");
			btn_inq_last20.setBounds(564, 126, 87, 29);
			btn_inq_last20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String [] columns_name = {"Project ID", "Employee ID", "Name", "Status", "Product", "RFQ ID", "QUOT. ID",
							"REQ. ID", "PUR. ID", "EXAM. ID", "RCPT ID","Est. Date"};
					
					
					String[][] temp = last_20();
					
					DefaultTableModel inq_table_model = new DefaultTableModel(temp, columns_name);
					inq_table.setModel(inq_table_model);
					
					inq_table.getColumnModel().getColumn(2).setPreferredWidth(100);
					inq_table.getColumnModel().getColumn(3).setPreferredWidth(50);
					inq_table.getColumnModel().getColumn(4).setPreferredWidth(80);
					inq_table.getColumnModel().getColumn(11).setPreferredWidth(90);
					inq_table.setVisible(true);
					scrollpane.setVisible(true);
					lbl_result.setText("Data load succeed");
				}
			});
			inq_panel.add(btn_inq_last20);
					
			lbl_result = new JLabel("");
			lbl_result.setBounds(230, 186, 529, 16);
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
			scrollpane.setBounds(49,228,900,135);
			scrollpane.setVisible(false);
			inq_panel.add(scrollpane);
			
			lbl_inq_date_format = new JLabel("YYYY-MM-DD");
			lbl_inq_date_format.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lbl_inq_date_format.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_inq_date_format.setBounds(336, 151, 141, 16);
			lbl_inq_date_format.setVisible(true);
			inq_panel.add(lbl_inq_date_format);
		}
		
		
		
		
		
		
		
		
		//Second panel - Maintenance
		private void add_maintenance_panel() {
			
			maint_panel = new JPanel();
			maint_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(maint_panel, "Maintenance");
			maint_panel.setLayout(null);
			
			lbl_maint_pjID = new JLabel("*project ID :");
			lbl_maint_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_pjID.setBounds(162, 41, 86, 16);
			maint_panel.add(lbl_maint_pjID);
			
			text_maint_pjID = new JTextField();
			text_maint_pjID.setHorizontalAlignment(SwingConstants.CENTER);
			text_maint_pjID.setBounds(260, 36, 130, 30);
			maint_panel.add(text_maint_pjID);
			text_maint_pjID.setColumns(10);
			
			lbl_maint_pjID_show = new JLabel("");
			lbl_maint_pjID_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_pjID_show.setBounds(260, 41, 130, 25);
			lbl_maint_pjID_show.setVisible(false);
			maint_panel.add(lbl_maint_pjID_show);
			
			lbl_maint_empID = new JLabel("*Employee ID :");
			lbl_maint_empID.setHorizontalAlignment(SwingConstants.RIGHT);			
			lbl_maint_empID.setBounds(142, 85, 106, 16);
			maint_panel.add(lbl_maint_empID);
			
			text_maint_empID = new JTextField();
			text_maint_empID.setHorizontalAlignment(SwingConstants.CENTER);
			text_maint_empID.setBounds(260, 78, 130, 30);
			maint_panel.add(text_maint_empID);
			text_maint_empID.setColumns(10);
			
			lbl_maint_emp_name = new JLabel("Employee Name :");
			lbl_maint_emp_name.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_emp_name.setBounds(111, 127, 137, 16);
			maint_panel.add(lbl_maint_emp_name);
			
			lbl_maint_emp_name_show = new JLabel("");
			lbl_maint_emp_name_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_emp_name_show.setBounds(260, 120, 130, 30);
			maint_panel.add(lbl_maint_emp_name_show);
			
			lbl_maint_date = new JLabel("Est. Date :");
			lbl_maint_date.setBounds(142, 164, 108, 16);
			lbl_maint_date.setHorizontalAlignment(SwingConstants.RIGHT);
			maint_panel.add(lbl_maint_date);
			
			text_maint_date = new JTextField();
			text_maint_date.setHorizontalAlignment(SwingConstants.CENTER);
			text_maint_date.setBounds(260, 157, 130, 30);
			maint_panel.add(text_maint_date);
			text_maint_date.setColumns(10);
			
			lbl_date_default = new JLabel("YYYY-MM-DD ");
			lbl_date_default.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_date_default.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
			lbl_date_default.setBounds(270, 191, 108, 25);
			maint_panel.add(lbl_date_default);
			
			lbl_maint_status = new JLabel("Project Status :");
			lbl_maint_status.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_status.setBounds(146, 225, 102, 16);
			maint_panel.add(lbl_maint_status);
			
			lbl_maint_status_show = new JLabel("NNNN");
			lbl_maint_status_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_status_show.setBounds(260, 222, 130, 23);
			maint_panel.add(lbl_maint_status_show);
			
			lbl_maint_result = new JLabel("");
			lbl_maint_result.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_result.setBounds(422, 85, 222, 95);
			maint_panel.add(lbl_maint_result);
			
			lbl_maint_ins = new JLabel("*obligatory");
			lbl_maint_ins.setBounds(33, 41, 93, 16);
			lbl_maint_ins.setVisible(true);
			maint_panel.add(lbl_maint_ins);
			
			btn_maint = new JButton("");
			btn_maint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(btn_maint.getText().equalsIgnoreCase("Modify")) {
						
						if(lib.date(text_maint_date.getText())) {
							
							if(modify()==1) {
								//send message to user modify succeed
								lbl_maint_result.setText("Modification succeed");
								lbl_maint_result.setVisible(true);
							}else {
								//send message to user modify failed
								lbl_maint_result.setText("Modification failed");
								lbl_maint_result.setVisible(true);
								}
							
						}else {
						    //handle exception here
							
							lbl_maint_result.setText("Date format Invalid");
							lbl_maint_result.setVisible(true);
							}
						
					}else if (btn_maint.getText().equalsIgnoreCase("Append")) {
						
						if(lib.emp_check(text_maint_empID)) {
							
							if(!(text_maint_date.getText().isBlank())) {
								
								if(lib.date(text_maint_date.getText())) {
									
									ArrayList<String> temp = append();
									
									if(temp.size()!=0) {
										//send message to user modify succeed
										lbl_maint_result.setText("Append succeed");
										lbl_maint_result.setVisible(true);
										lbl_maint_pjID_show.setText(temp.get(0));
										lbl_maint_pjID_show.setVisible(true);
										lbl_maint_emp_name_show.setText(temp.get(2));
										lbl_maint_emp_name_show.setVisible(true);
										lbl_maint_status_show.setText(temp.get(3));
										lbl_maint_status_show.setVisible(true);
										
										
									}else {
										//send message to user modify failed
										lbl_maint_result.setText("Append failed.\n Check data again please");
										lbl_maint_result.setVisible(true);
									}
								}else {
									lbl_maint_result.setText("Date format Invalid");
									lbl_maint_result.setVisible(true);
								}
							}else if(text_maint_date.getText().isBlank()){
							
								ArrayList<String> temp = append();
								
								if(temp.size()!=0) {
									//send message to user modify succeed
									lbl_maint_result.setText("Append succeed");
									lbl_maint_result.setVisible(true);
									lbl_maint_pjID_show.setText(temp.get(0));
									lbl_maint_pjID_show.setVisible(true);
									text_maint_date.setText(temp.get(3));
									lbl_maint_status_show.setText(temp.get(4));
									lbl_maint_status_show.setVisible(true);
									
									
								}else {
									//send message to user modify failed
									lbl_maint_result.setText("Append failed.\n Check data again please");
									lbl_maint_result.setVisible(true);
								}
							}
						}else {
						    //handle exception here
							
							lbl_maint_result.setText("Employee ID Invalid");
							lbl_maint_result.setVisible(true);
							}
							
					}else if (btn_maint.getText().equalsIgnoreCase("Delete")) {
						
						if(delete()!=0) {
							//send message to user modify succeed
							lbl_maint_result.setText("Request succeed");
							lbl_maint_result.setVisible(true);
							
						}else if(delete()==0) {
							//send message to user modify failed
							
							lbl_maint_result.setVisible(true);
						}
					}
				}
			});
			btn_maint.setBounds(490, 200, 87, 29);
			maint_panel.add(btn_maint);
					
			btn_maint_check = new JButton("Check ");
			btn_maint_check.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					

					try{
						Integer.parseInt(text_maint_pjID.getText());
						
						ArrayList<String> temp = check_ID(text_maint_pjID);
						
//						ArrayList<String> temp = new ArrayList();  // test data
//						temp.addAll(Arrays.asList(new String[] {"90000007","11047637","2021-03-10","RCPT",""})); // test data
						
						
						if(temp.size() == 0) {
							
							btn_maint.setVisible(false);
	            			btn_clear.setVisible(false);

	            			btn_maint_check.setVisible(true);
	            			lbl_maint_ins.setVisible(true);
	            			
	            			lbl_maint_pjID.setVisible(true);
	            			text_maint_pjID.setVisible(true);    						//let projectID be uneditable
							
							lbl_maint_pjID_show.setVisible(false);
							lbl_maint_result.setText("no found");
							lbl_maint_result.setVisible(true);
							set_visible(false);
							
						}else {
							//temp.size() != 0
							
							set_visible(true);
							lbl_maint_pjID_show.setText(text_maint_pjID.getText());
							text_maint_empID.setText(temp.get(1));
							lbl_maint_emp_name_show.setText(temp.get(2));
							text_maint_date.setText(temp.get(3));
							lbl_maint_status_show.setText(temp.get(4));
							
							
							btn_clear.setVisible(true);
							text_maint_pjID.setText("");
							text_maint_pjID.setVisible(false);     						//let projectID be uneditable
							lbl_maint_pjID_show.setVisible(true);
							lbl_maint_result.setText("Data loading succeed");	
							lbl_maint_result.setVisible(true);
							btn_maint.setVisible(true);
						}
						   
						}catch (NumberFormatException ex) {
						    //handle exception here
							
							btn_maint.setVisible(false);
	            			btn_clear.setVisible(false);

	            			btn_maint_check.setVisible(true);
	            			lbl_maint_ins.setVisible(true);
	            			
	            			lbl_maint_pjID.setVisible(true);
	            			text_maint_pjID.setVisible(true);
	            			set_visible(false);
	            			
							lbl_maint_result.setText(" Project ID format Invalid");
							lbl_maint_result.setVisible(true);
							
						}
					
					
					
					
					
				}
			});
			btn_maint_check.setBounds(402, 36, 78, 29);
			maint_panel.add(btn_maint_check);
			
			btn_clear = new JButton("Clear");
			btn_clear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					clear_maint_panel();
					
					if(comboBox_pj.getSelectedItem().equals("Modify")|(comboBox_pj.getSelectedItem().equals("Delete"))) {
						
						btn_maint.setVisible(false);
            			btn_clear.setVisible(false);
            			lbl_maint_result.setVisible(false);
            			
            			btn_maint_check.setVisible(true);
            			lbl_maint_ins.setVisible(true);
            			
            			lbl_maint_pjID.setVisible(true);
            			text_maint_pjID.setVisible(true);
            			set_visible(false);	
					}
				}
			});
			btn_clear.setBounds(481, 36, 86, 29);
			maint_panel.add(btn_clear);
			
		}
		
		
		public void clear_maint_panel() {
			
			lbl_maint_pjID_show.setText("");
			text_maint_pjID.setText("");
			text_maint_empID.setText("");
			lbl_maint_emp_name_show.setText("");
			text_maint_date.setText("");
			
			lbl_maint_status_show.setText("");
			lbl_maint_result.setText("");
			
		}
		
		
		
		private void set_visible(boolean bl) {
			
			lbl_maint_empID.setVisible(bl);
			text_maint_empID.setVisible(bl);
			
			lbl_maint_emp_name.setVisible(bl);
			lbl_maint_emp_name_show.setVisible(bl);
			
			lbl_maint_date.setVisible(bl);
			text_maint_date.setVisible(bl);

			lbl_date_default.setVisible(bl);
			
			lbl_maint_status.setVisible(bl);
			lbl_maint_status_show.setVisible(bl);
			
		}


		
		private int modify() {
			/** 
			 * @Author jyun-an
			 *  @since 06/03/2021
			 *  to MODIFY data in PROJECT table
			 **/
			int resultSet=0;
			
			if(text_maint_empID.getText().isBlank()|(!(lib.emp_check(text_maint_empID)))|text_maint_date.getText().isBlank()) {
				
				return resultSet;
			}
			
			try {
				resultSet = Term_project_main.conn.st.executeUpdate("UPDATE PROJECT SET Emp_ID="+ text_maint_empID.getText()
											+", Established_date=\'"+text_maint_date.getText()+"\' WHERE Project_ID="+text_maint_pjID.getText());

				return 	resultSet;	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 	resultSet;	
			}
			
		}
		
		
		
		private String[][] inquire(JTextField projectID, JTextField empID, JTextField est_date){
			
			/**@author jyunanyang
			 * @since 06/02/2021
			 * pass in 3 JTextFields and use switch case to handle every situation which they are filled in or not. 
			 */
			
			final String st_inquire = "SELECT * FROM VIEW_PROJECT";
			
			ArrayList<String[]> temp = new ArrayList();
			
			switch (lib.check_text_fields(projectID, empID, est_date)) {
			
			
					case "111":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE (Project_ID=" + 
																		projectID.getText()+" AND Emp_ID="+ empID.getText()+" AND Est_date=\'"
																						+est_date.getText()+"\')");
							
							if(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);	
							}

						}catch (SQLException e) {
						// TODO Auto-generated catch block
							e.printStackTrace();
							}
							break;
													
					case "110":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE (Project_ID=" 
																				+projectID.getText()+" AND Emp_ID="+ empID.getText()+")");
							
							while(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
							}

						}catch (SQLException e) {	
						// TODO Auto-generated catch block
							e.printStackTrace();
							}
						break;
						
					case "101":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE (Project_ID=" 
																		+ projectID.getText()+" AND Est_date=\'"+est_date.getText()+"\')");
							
							while(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
							}
							
						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							e.printStackTrace();
							
							}
							break;
							
					case "100":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE Project_ID="+projectID.getText());
																			
							if(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);
							}
							
						}catch (SQLException e) {	
						// TODO Auto-generated catch block
							e.printStackTrace();							
							}
						break;
						
					case "011":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE (Emp_ID="
																						+empID.getText()+" AND Est_date=\'"+est_date.getText()+"\')");
							
							while(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);	
							}
							
						}catch (SQLException e) {	
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
							break;
							
					case "010":
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE Emp_ID="+empID.getText());
							while(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);	
							}
							break;

						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							e.printStackTrace();
							break;
							}
						
					default:
						
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+" WHERE Est_date=\'"+est_date.getText()+"\'");
							
							while(resultSet.next()) {
								String [] temp_array = new String[12];
								for(int i = 1; i<13; i++) {
									temp_array[i-1]= resultSet.getString(i);
								}
								temp.add(temp_array);	
							}
							break;

						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							e.printStackTrace();
							
							break;
							}		
			}
			String[][] result_array = new String[temp.size()][12];
			int i=0;
			for (String[] array_in_temp : temp) {
				result_array[i++] = array_in_temp;
			        }
			return result_array;
		}
		
		
		private String[][] last_20(){
			
			final String st_inquire = "SELECT * FROM VIEW_PROJECT";
			
			ArrayList<String[]> temp = new ArrayList();
			
			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery(st_inquire+ " ORDER BY Est_date DESC LIMIT 20");
				
				
				while(resultSet.next()) {
					String [] temp_array = new String[12];
					for(int i = 1; i<13; i++) {
						temp_array[i-1]= resultSet.getString(i);
					}
					temp.add(temp_array);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[][] result_array = new String[temp.size()][12];
			int i=0;
			for (String[] array_in_temp : temp) {
				result_array[i++] = array_in_temp;
			        }
			return result_array;
			
		}
		
		
		
		private ArrayList<String> append() {
			/** 
			 * @Author jyun-an
			 *  @since 06/03/2021
			 *  to ADD data in PROJECT table
			 **/
			int resultSet=0;
			ArrayList<String> temp = new ArrayList();
			
			if(text_maint_date.getText().isBlank()) {
				try {
					resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO PROJECT (Emp_ID, Project_status) VALUE ("
											+ text_maint_empID.getText()+", 'just started')");
					
					if (resultSet==1){
						
						ResultSet add_result = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, pj.Emp_ID, emp.Last_name, "
																			+ "pj.Established_date, pj.Project_status FROM test.PROJECT "
																			+ "AS pj LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID ORDER BY Project_ID "
																			+ "DESC LIMIT 1");
						if(add_result.next()) {
							for(int i =1; i<6;i++) {
								temp.add(add_result.getString(i));
								}
						}
						
						return temp;
						
						
					}
					
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return temp;
				}
				
			}else if(!(text_maint_date.getText().isBlank())){
				//!(text_maint_date.getText().isBlank())
				try {
					resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.PROJECT (Emp_ID, Established_date, Project_status) VALUE ("
																	+ text_maint_empID.getText()+", \'"+text_maint_date.getText()+"\', \'just started\')");
					
					if (resultSet==1){
						
						ResultSet add_result = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, pj.Emp_ID, emp.Last_name, pj.Established_date,"
																	+ " pj.Project_status, pj.Delivery_progress FROM tset.PROJECT AS pj "
																	+ "LEFT JOIN tset.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID ORDER BY Project_ID DESC LIMIT 1");
						
						if(add_result.next()) {
							for(int i =1; i<7;i++) {
								temp.add(add_result.getString(i));
								}	
						}
						
						return temp;
						
						
					}
					
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return temp;
				}
			}
			
			return temp;
		}
		
	
		
		
		private int delete() {
			
			int resultSet=0;
			int resultSet2=0;
			
			try {
				
				ResultSet rs = Term_project_main.conn.st.executeQuery("SELECT * FROM test.INVENTORY WHERE Project_ID="+lbl_maint_pjID_show.getText());
				
				if (rs.next()) {
					
					lbl_maint_result.setText("You could not delete a project with purchasing inventory\n which means it's already/almost finished");
					return resultSet+resultSet2;
					
				}
				resultSet = Term_project_main.conn.st.executeUpdate("DELETE RFQ, QUOT, REQ,PUR,EXAM,RCPT, INV "
						+ "FROM test.PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
						+ "LEFT JOIN test.QUOTATION AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
						+ "LEFT JOIN test.REQUISITION AS REQ ON REQ.Project_ID = pj.Project_ID\n"
						+ "LEFT JOIN test.PURCHASE AS PUR ON PUR.Project_ID = pj.Project_ID\n"
						+ "LEFT JOIN test.EXAMINATION AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
						+ "LEFT JOIN test.RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID \n"
						+ "LEFT JOIN test.INVENTORY AS INV ON INV.Project_ID = pj.Project_ID WHERE pj.Project_ID="+lbl_maint_pjID_show.getText());
				
				
				resultSet2 = Term_project_main.conn.st.executeUpdate("DELETE FROM PROJECT WHERE Project_ID="+lbl_maint_pjID_show.getText());
				
				return resultSet+resultSet2;
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					lbl_maint_result.setText("Request failed.\n Please check data again");
					return resultSet+resultSet2;
					}
			
		}
		
		
		
		
		
		private ArrayList<String> check_ID(JTextField ID) {
			
			
			ArrayList<String>  temp = new ArrayList();
			
			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, pj.Emp_ID, emp.Last_name, pj.Established_date, "
														+ "pj.Project_status FROM test.PROJECT AS pj "
														+ "LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=pj.Emp_ID WHERE Project_ID=" + ID.getText());
				
				if(resultSet.next()) {
					 
					for(int i = 1; i<6; i++) {
						temp.add(resultSet.getString(i));
						//System.out.print(resultSet.getString(i));
					}	
				}
			}catch (SQLException e) {	
			// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
			return temp;
		}
		
		
		public void clear_inq_panel() {
			
			text_inq_date.setText("");
			text_inq_pjID.setText("");
			text_inq_empID.setText("");
			
		}
		
		
		
		
		public JComboBox get_comboBox_project() {
			
			return comboBox_pj;
		}
}
