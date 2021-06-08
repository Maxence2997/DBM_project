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

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class Sheets_panel  {
	
	/**
     * @autohr Jyun-An
     * @ver. 1.2.2 05/28   
     * Seperated from Project_test
     **/
	
	private Library lib;

	private JComboBox comboBox_sheets;
	private CardLayout cl_sheet;
	public JPanel core_sheet_panel;
	
	private JPanel sheet_container_panel;
	
	private JPanel default_panel;
	
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
	
	
	private JPanel mod_panel;
	private JLabel lbl_mod_sheetID;
	private JTextField text_mod_sheetID;
	private JButton btn_mod_modify;
	private JLabel lbl_mod_projectID;
	private JTextField text_mod_projectID;
	private JLabel lbl_mod_pd;
	private JTextField text_mod_pd;
	private JLabel lbl_mod_4;
	private JTextField text_mod_4;
	private JLabel lbl_mod_5;
	private JTextField text_mod_5;
	private JLabel lbl_mod_6;
	private JTextField text_mod_6;
	private JLabel lbl_mod_7;
	private JTextField text_mod_7;
	private JLabel lbl_mod_8;
	private JTextField text_mod_8;
	private JButton btn_mod_check;
	private JLabel lbl_mod_message;
	private JLabel lbl_mod_note;
	private JButton btn_mod_clear;
	private JLabel lbl_mod_sheetID_show;
	private JLabel lbl_mod_projectID_show;
	private JLabel lbl_mod_pd_show;
	
	
	private JPanel append_panel;
	private JLabel lbl_appd_1;
	private JTextField text_appd_1;
	private JLabel lbl_appd_2;
	private JTextField text_appd_2;
	private JLabel lbl_appd_3;
	private JTextField text_appd_3;
	private JLabel lbl_appd_4;
	private JTextField text_appd_4;
	private JLabel lbl_appd_5;
	private JTextField text_appd_5;
	private JLabel lbl_appd_6;
	private JTextField text_appd_6;
	private JLabel lbl_appd_7;
	private JTextField text_appd_7;
	private JButton btn_appd_append;
	private JScrollPane scrollpane_append;
	private JTable append_table;
	private JRadioButton rb_appd_RFQ;
	private JRadioButton rb_appd_QUO;
	private JRadioButton rb_appd_REQ;
	private JRadioButton rb_appd_PUR;
	private JRadioButton rb_appd_EXAM;
	private JRadioButton rb_appd_RCPT;
	private JLabel lbl_append_message;


	
	private JTable sign_table;
	
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
	
	private JPanel sign_panel;
	private JLabel lbl_sign_sorry;
	private JLabel lbl_sign_instr;
	private JButton btn_sign_sign;
	private JButton btn_sign_refresh;
	private JScrollPane scrollpane_sign;
	
	public Sheets_panel() {
		
		lib = new Library();
		panels();
		
	}
	
	private void panels() {
				
				//core sheet panel which contains comboBox
				core_sheet_panel = new JPanel();
				Term_project_main.container_panel.add(core_sheet_panel,"sheets");
				core_sheet_panel.setLayout(null);
				
				//smaller panel on the core sheet panel
				cl_sheet = new CardLayout();
				sheet_container_panel = new JPanel(cl_sheet);
				sheet_container_panel.setBounds(0, 36, 662, 348);
				sheet_container_panel.setBackground(Color.CYAN);
				core_sheet_panel.add(sheet_container_panel);
				
				
				//add 5 sub sheet panels
				
				add_default_panel();
				add_inquire_panel();
				add_modify_panel();
				add_append_panel();
				add_remove_panel();
				add_sign_panel();
				
				comboBox_sheets = new JComboBox(new String[] {"--------","Inquire", "Modify", "Append", "Remove","Signature"});
				comboBox_sheets.setBounds(262, 6, 120, 27);			
				comboBox_sheets.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	String function = (String) comboBox_sheets.getSelectedItem(); //get the selected item
	
			                
			            	cl_sheet.show(sheet_container_panel, function);	
			            	
			            	if (function.equalsIgnoreCase("signature")){
				            	if(lib.supervisor_check(Term_project_main.field_empID)) {
									
									String[][] temp = show_unsign_req();
									
									if(temp.length!=0) {
										
										String[] columns_name = {"Sheet ID", "Sheet Type", "Project ID", "Product", "Item", "Vol.", "Unit Price", 
												"Total Price", "Signature", "Supervisor ID", "Supervisor","Date"};
									
										lbl_sign_sorry.setVisible(false);
										btn_sign_sign.setVisible(true);
										btn_sign_refresh.setVisible(true);
										lbl_sign_instr.setText("Please sign sheets below after reading.");
										lbl_sign_instr.setVisible(true);
										
										DefaultTableModel sign_table_model = new DefaultTableModel(temp,columns_name);
										sign_table.setModel(sign_table_model);		
										sign_table.setVisible(true);
										scrollpane_sign.setVisible(true);
										
									}else {
										
										lbl_sign_instr.setText("All sheets are signed");
										lbl_sign_instr.setVisible(true);
										
										lbl_sign_sorry.setVisible(false);
										btn_sign_sign.setVisible(false);
										btn_sign_refresh.setVisible(false);
										sign_table.setVisible(false);
										scrollpane_sign.setVisible(false);
									}	
								}else {
									//not supervisor
									
									lbl_sign_sorry.setVisible(true);
									btn_sign_sign.setVisible(false);
									btn_sign_refresh.setVisible(false);
									sign_table.setVisible(false);
									scrollpane_sign.setVisible(false);
									
									}
			            		}
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
				go_back = go_back.getScaledInstance( 21, 21,  java.awt.Image.SCALE_AREA_AVERAGING) ;
				
				JLabel lbl_sheets = new JLabel("Sheets");
				lbl_sheets.setBounds(54, 10, 41, 16);
				lbl_sheets.setHorizontalAlignment(SwingConstants.CENTER);
				core_sheet_panel.add(lbl_sheets);
				btn_back2pj.setIcon(new ImageIcon(go_back));
				core_sheet_panel.add(btn_back2pj);
			}
			
			
			
			
			//default panel
			private void add_default_panel() {
				default_panel = new JPanel();
				default_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(default_panel, "--------");
				default_panel.setLayout(null);
			}
			
			//first panel - Inquire sheet
			private void add_inquire_panel() {
				
				inq_panel = new JPanel();
				inq_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(inq_panel, "Inquire");
				inq_panel.setLayout(null);
				
						
				lbl_inq_sheetID = new JLabel("Sheet ID :");
				lbl_inq_sheetID.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_inq_sheetID.setBounds(310, 44, 103, 16);
				lbl_inq_sheetID.setVisible(false);
				inq_panel.add(lbl_inq_sheetID);
						
				text_inq_sheetID = new JTextField();
				text_inq_sheetID.setBounds(426, 39, 105, 26);
				text_inq_sheetID.setVisible(false);
				inq_panel.add(text_inq_sheetID);
				text_inq_sheetID.setColumns(10);
						
				lbl_inq_projectID = new JLabel("Project ID :");
				lbl_inq_projectID.setBounds(310, 86, 106, 16);
				lbl_inq_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_inq_projectID.setVisible(false);
				inq_panel.add(lbl_inq_projectID);
						
				text_inq_projectID = new JTextField();
				text_inq_projectID.setBounds(426, 81, 105, 26);
				text_inq_projectID.setVisible(false);
				inq_panel.add(text_inq_projectID);
				text_inq_projectID.setColumns(10);
						
				btn_inq_inquire = new JButton("Inquire");
				btn_inq_inquire.setBounds(554, 39, 87, 29);
				btn_inq_inquire.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//library.btn_inquire();
						try {
							if(!text_inq_sheetID.getText().isBlank()) 
								Integer.parseInt(text_inq_sheetID.getText());
							
							if(!text_inq_projectID.getText().isBlank()) 
								Integer.parseInt(text_inq_projectID.getText());
							
							if (rb_inq_all.isSelected()) {
								
									String [][] temp = inquire_all(text_inq_sheetID,text_inq_projectID,text_inq_pd);
									
		//							for(int i=0; i<temp.length;i++) {
		//								for(int j=0; j<temp[i].length;j++) {
		//									System.out.print(temp[i][j]+"\t");
		//								}
		//								System.out.println();
		//							}
									if(temp.length!=0) {
										
										String[] columns_name = {"Column 1", "Column 2", "Column 3", "Column 4", "Column 5", "Column 6", "Column 7", "Column 8",
												"Column 9", "Column 10", "Column 11", "Column 12"};
										
										DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
										inq_table.setModel(inq_table_model);
										inq_table.setVisible(true);
										scrollpane_inq.setVisible(true);
										lbl_inq_result.setText("Data loaded");
										lbl_inq_result.setVisible(true);
										
									}else {
										//temp.length==0
										inq_table.setVisible(false);
										scrollpane_inq.setVisible(false);
										lbl_inq_result.setText("Data no found");
										lbl_inq_result.setVisible(true);	
									}
							
								
							}else if(rb_inq_RFQ.isSelected()) {
								
									String[][] temp = inquire("RFQ", text_inq_sheetID,text_inq_projectID,text_inq_pd);
									if(temp.length!=0) {
										
										String[] columns_name = {"Sheet ID", "Type", "Project ID", "Inquiring Product", "Supplier ID", "Name", "Vol.", "Date"};
										DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
										inq_table.setModel(inq_table_model);
										inq_table.setVisible(true);
										scrollpane_inq.setVisible(true);
										lbl_inq_result.setText("Data loaded");
										lbl_inq_result.setVisible(true);
										
									}else {
										//temp.length==0
										inq_table.setVisible(false);
										scrollpane_inq.setVisible(false);
										lbl_inq_result.setText("Data no found");
										lbl_inq_result.setVisible(true);	
									}
									
							}else if(rb_inq_quo.isSelected()) {
								
								String[][] temp = inquire("QUO", text_inq_sheetID,text_inq_projectID,text_inq_pd);
								if(temp.length!=0) {
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Inquiring Product", "Supplier ID", "Name", "Vol.",
											"Unit Price","Total Price","ESD", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.setVisible(true);
									scrollpane_inq.setVisible(true);
									lbl_inq_result.setText("Data loaded");
									lbl_inq_result.setVisible(true);
									
								}else {
									//temp.length==0
									inq_table.setVisible(false);
									scrollpane_inq.setVisible(false);
									lbl_inq_result.setText("Data no found");
									lbl_inq_result.setVisible(true);	
								}
								
							}else if(rb_inq_req.isSelected()) {
								
								String[][] temp = inquire("REQ", text_inq_sheetID,text_inq_projectID,text_inq_pd);
								if(temp.length!=0) {
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Inquiring Product", "Item Name", "Vol.",
											"Unit Price", "Total Price", "Signature", "Supervisor ID","Name", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.setVisible(true);
									scrollpane_inq.setVisible(true);
									lbl_inq_result.setText("Data loaded");
									lbl_inq_result.setVisible(true);
									
								}else {
									//temp.length==0
									inq_table.setVisible(false);
									scrollpane_inq.setVisible(false);
									lbl_inq_result.setText("Data no found");
									lbl_inq_result.setVisible(true);	
								}
								
							}else if(rb_inq_pur.isSelected()) {
								
								String[][] temp = inquire("PUR", text_inq_sheetID,text_inq_projectID,text_inq_pd);
								if(temp.length!=0) {
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Module", "Vol.",
											"Unit Price", "Total Price", "ESD", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.setVisible(true);
									scrollpane_inq.setVisible(true);
									lbl_inq_result.setText("Data loaded");
									lbl_inq_result.setVisible(true);
									
								}else {
									//temp.length==0
									inq_table.setVisible(false);
									scrollpane_inq.setVisible(false);
									lbl_inq_result.setText("Data no found");
									lbl_inq_result.setVisible(true);	
								}
								
							}else if(rb_inq_exam.isSelected()) {
								
								String[][] temp = inquire("EXAM", text_inq_sheetID,text_inq_projectID,text_inq_pd);
								if(temp.length!=0) {
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Module", "Vol.", "Result", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.setVisible(true);
									scrollpane_inq.setVisible(true);
									lbl_inq_result.setText("Data loaded");
									lbl_inq_result.setVisible(true);
									
								}else {
									//temp.length==0
									inq_table.setVisible(false);
									scrollpane_inq.setVisible(false);
									lbl_inq_result.setText("Data no found");
									lbl_inq_result.setVisible(true);	
								}
								
							}else {
								//else if(rb_inq_rec.isSelected()) 
								String[][] temp = inquire("RCPT", text_inq_sheetID,text_inq_projectID,text_inq_pd);
								if(temp.length!=0) {
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Module", "Vol.", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.setVisible(true);
									scrollpane_inq.setVisible(true);
									lbl_inq_result.setText("Data loaded");
									lbl_inq_result.setVisible(true);
									
								}else {
									//temp.length==0
									inq_table.setVisible(false);
									scrollpane_inq.setVisible(false);
									lbl_inq_result.setText("Data no found");
									lbl_inq_result.setVisible(true);	
								}
							}
							
						}catch (NumberFormatException ex) {
							//handle exception here
							
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
				lbl_inq_pd.setBounds(270, 126, 146, 16);
				inq_panel.add(lbl_inq_pd);
						
				text_inq_pd = new JTextField();
				text_inq_pd.setBounds(426, 119, 105, 26);
				text_inq_pd.setVisible(false);
				inq_panel.add(text_inq_pd);
				text_inq_pd.setColumns(10);
						
				lbl_inq_result = new JLabel("");
				lbl_inq_result.setBounds(349, 164, 262, 16);
				inq_panel.add(lbl_inq_result);
						
				
				inq_table = new JTable(){ 
					@Override
					public boolean isCellEditable(int row, int column)
		            {
		                                  return false;}//uneditable
		            
					}; 
				inq_table.setBounds(29, 194, 1000, 130);
				inq_table.setVisible(false);

				scrollpane_inq = new JScrollPane(inq_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollpane_inq.setBounds(52,219,559,100);
				
				inq_panel.add(scrollpane_inq);
				
				ButtonGroup bg = new ButtonGroup();
				
				
				
				rb_inq_all = new JRadioButton("All  Sheets");
				rb_inq_all.setBounds(137, 28, 180, 23);
				inq_panel.add(rb_inq_all);
				rb_inq_all.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Product :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);
			        	
			        	btn_inq_inquire.setVisible(true);   
			        }
			    });
				bg.add(rb_inq_all);
				
				rb_inq_RFQ = new JRadioButton("R.F.Q");
				rb_inq_RFQ.setBounds(137, 56, 180, 23);
				inq_panel.add(rb_inq_RFQ);
				rb_inq_RFQ.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        			        	
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Inquiring Product :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);
			            	        	
			        	btn_inq_inquire.setVisible(true);			
			        }
			    });
				bg.add(rb_inq_RFQ);
				
				
				rb_inq_quo = new JRadioButton("Quotation");
				rb_inq_quo.setBounds(137, 79, 180, 23);
				inq_panel.add(rb_inq_quo);
				
				rb_inq_quo.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			             	
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Inquiring Product :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);		        	
			        	
			        	btn_inq_inquire.setVisible(true);
			        }
			    });
				bg.add(rb_inq_quo);
				
							
				rb_inq_req = new JRadioButton("Requisition");
				rb_inq_req.setBounds(137, 102, 180, 23);
				inq_panel.add(rb_inq_req);
				rb_inq_req.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Inquiring Product :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);		        	
			        	
			        	btn_inq_inquire.setVisible(true);			        	
			        }
			    });
				bg.add(rb_inq_req);
								
				
				rb_inq_pur = new JRadioButton("Purchase");
				rb_inq_pur.setBounds(137, 122, 180, 23);
				inq_panel.add(rb_inq_pur);
				rb_inq_pur.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        			        	
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Module Type :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);
			        				        	
			        	btn_inq_inquire.setVisible(true);
			        }
			    });
				bg.add(rb_inq_pur);
				
				
				rb_inq_exam = new JRadioButton("Examination");
				rb_inq_exam.setBounds(137, 142, 180, 23);
				inq_panel.add(rb_inq_exam);
				rb_inq_exam.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {		        	
			        	
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Module Type :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);
			        	
			        	
			        	btn_inq_inquire.setVisible(true);		        	
			        }
			    });
				bg.add(rb_inq_exam);
				
				
				rb_inq_rec = new JRadioButton("Receipt");
				rb_inq_rec.setBounds(137, 164, 180, 23);
				inq_panel.add(rb_inq_rec);
				rb_inq_rec.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        			        	
			        	lbl_inq_sheetID.setVisible(true);
			        	text_inq_sheetID.setVisible(true);
			        	
			        	lbl_inq_projectID.setVisible(true);
			        	text_inq_projectID.setVisible(true);
			        	
			        	lbl_inq_pd.setText("Module Type :");
			        	lbl_inq_pd.setVisible(true);
			        	text_inq_pd.setVisible(true);
			        			        	
			        	btn_inq_inquire.setVisible(true);
			        }
			    });
				
				bg.add(rb_inq_rec);
				
				JLabel lbl_sheet_type = new JLabel("Sheets type :");
				lbl_sheet_type.setBounds(42, 32, 87, 16);
				inq_panel.add(lbl_sheet_type);
				
				JButton btn_clear = new JButton("Clear");
				btn_clear.setBounds(554, 73, 87, 29);
				inq_panel.add(btn_clear);
											
			}
			
			//Second panel - Modify sheet
			private void add_modify_panel() {

				mod_panel = new JPanel();
				sheet_container_panel.add(mod_panel,"Modify");
				mod_panel.setBounds(0, 0, 662, 367);
				mod_panel.setLayout(null);
				
				lbl_mod_sheetID = new JLabel("*sheet ID :");
				lbl_mod_sheetID.setBounds(193, 41, 67, 16);
				mod_panel.add(lbl_mod_sheetID);
				
				text_mod_sheetID = new JTextField();
				text_mod_sheetID.setBounds(272, 36, 115, 26);
				mod_panel.add(text_mod_sheetID);
				text_mod_sheetID.setColumns(10);
				
				btn_mod_modify = new JButton("Modify");
				btn_mod_modify.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//verify format
						int id = Integer.parseInt(lbl_mod_sheetID_show.getText());

						if (id>=21000000 & id< 22000000) {
							//RFQ
								if (lib.supplier_check(text_mod_4)&lib.num_not_null_check(text_mod_5)&lib.date(text_mod_6.getText())) {
									
									if (modify()==1) 
										lbl_mod_message.setText("modification succeed");
									else 
										lbl_mod_message.setText("modification failed");
								}else{
									lbl_mod_message.setText("format Invalid");
									lbl_mod_message.setVisible(true);
								}
						}else if (id>=22000000 & id< 23000000) {
							//QUOT
							if (lib.supplier_check(text_mod_4)&lib.num_not_null_check(text_mod_5)&lib.num_not_null_check(text_mod_6)
									&lib.date(text_mod_7.getText())&lib.date(text_mod_8.getText())) {
									
									if (modify()==1) 
										lbl_mod_message.setText("modification succeed");
									else 
										lbl_mod_message.setText("modification failed");
								}else{
									lbl_mod_message.setText("format Invalid");
									lbl_mod_message.setVisible(true);
									}
						}else if (id>=23000000 & id< 24000000) {
							//REQ
							if (lib.num_not_null_check(text_mod_5)&lib.num_not_null_check(text_mod_6)
										&lib.supervisor_check(text_mod_7)&lib.date(text_mod_8.getText())) {
										
								if (modify()==1)
									lbl_mod_message.setText("modification succeed");
								else 
									lbl_mod_message.setText("modification failed");
							}else{
								lbl_mod_message.setText("format Invalid");
								lbl_mod_message.setVisible(true);
								}
						}else if (id>=24000000 & id< 25000000) {
							//PUR
							if (lib.num_not_null_check(text_mod_5)&lib.num_not_null_check(text_mod_6)
									&lib.date(text_mod_7.getText())&lib.date(text_mod_8.getText())) {
										
								if (modify()==1) 
									lbl_mod_message.setText("modification succeed");
								else 
									lbl_mod_message.setText("modification failed");
							}else{
								lbl_mod_message.setText("format Invalid");
								lbl_mod_message.setVisible(true);
								}
								
						}else if (id>=25000000 & id< 26000000) {
							//EXAM
							if (lib.num_not_null_check(text_mod_4)&lib.date(text_mod_6.getText())){
											
								if (modify()==1) 
									lbl_mod_message.setText("modification succeed");
								else 
									lbl_mod_message.setText("modification failed");
							}else{
								lbl_mod_message.setText("format Invalid");
								lbl_mod_message.setVisible(true);
								}
						}else {
							//RCPT
							if (lib.num_not_null_check(text_mod_4)&lib.date(text_mod_6.getText())){
										
								if (modify()==1) 
									lbl_mod_message.setText("modification succeed");
								else 
									lbl_mod_message.setText("modification failed");
							}else{
								lbl_mod_message.setText("format Invalid");
								lbl_mod_message.setVisible(true);
							}
						}
					}					
				});
				btn_mod_modify.setBounds(539, 35, 87, 29);
				mod_panel.add(btn_mod_modify);
				
				lbl_mod_projectID = new JLabel("*Project ID :");
				lbl_mod_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_mod_projectID.setBounds(164, 79, 96, 16);
				mod_panel.add(lbl_mod_projectID);
				
				text_mod_projectID = new JTextField();
				text_mod_projectID.setBounds(272, 74, 115, 26);
				mod_panel.add(text_mod_projectID);
				text_mod_projectID.setColumns(10);
				
				lbl_mod_pd = new JLabel("*Product :");
				lbl_mod_pd.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_mod_pd.setBounds(154, 117, 106, 16);
				mod_panel.add(lbl_mod_pd);
				
				text_mod_pd = new JTextField();
				text_mod_pd.setBounds(272, 112, 115, 26);
				mod_panel.add(text_mod_pd);
				text_mod_pd.setColumns(10);
				
				lbl_mod_4 = new JLabel("");
				lbl_mod_4.setBounds(164, 152, 96, 16);
				lbl_mod_4.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_mod_4.setVisible(false);
				mod_panel.add(lbl_mod_4);
				
				text_mod_4 = new JTextField();
				text_mod_4.setBounds(272, 150, 115, 26);
				text_mod_4.setVisible(false);
				mod_panel.add(text_mod_4);
				text_mod_4.setColumns(10);
				
				lbl_mod_5 = new JLabel("");
				lbl_mod_5.setBounds(154, 191, 106, 16);
				lbl_mod_5.setVisible(false);
				mod_panel.add(lbl_mod_5);
				
				text_mod_5 = new JTextField();
				text_mod_5.setBounds(272, 186, 115, 26);
				text_mod_5.setVisible(false);
				mod_panel.add(text_mod_5);
				text_mod_5.setColumns(10);
				
				btn_mod_check = new JButton("Check");
				btn_mod_check.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(!lib.num_not_null_check(text_mod_sheetID)|!lib.num_not_null_check(text_mod_projectID)|text_mod_pd.getText().isBlank()) {
							//None of them can't be blank 
							
							lbl_mod_message.setText("Format Invalid");
							lbl_mod_message.setVisible(true);
							
						}else {
							//each of them is filled
							
								
								ArrayList<String> temp = check(text_mod_sheetID, text_mod_projectID, text_mod_pd);
								
								
								//ArrayList<String> temp = new ArrayList(); //test data
//								String[] temp2 = {"21000002", "RFQ", "90000002", "C0z035", "SP0000004", "204", "2021-03-07"};
//								String[] temp2 = {"23000002", "QUOT", "90000002", "C0z087", "SP0000005", "206", "716", "147496",
//										"2021-04-16", "2021-03-17"};
//								String[] temp2 = {"23000002", "REQ", "90000002", "C0z087", "CPU", "206", "716", "147496",
//								"11047603", "True", "2021-03-27"}; //test data
//								String[] temp2 = {"23000002", "PURC", "90000002", "C0z087", "CPU", "206", "716", "147496",
//										"2021-04-16", "2021-04-06", "2021-04-16"};
//								String[] temp2 = {"23000002", "EXAM", "90000002", "C0z087", "204", "2021-04-16"};
//								String[] temp2 = {"23000002", "RCPT", "90000002", "C0z087", "137", "2021-04-18"};
								
		//						for(int i=0;i<temp2.length;i++)   //test data
		//							temp.add(temp2[i]); //test data
												
								
								
								if (temp.size()!=0) {
									if (temp.get(1).equalsIgnoreCase("RFQ")) {
										
										lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
										text_mod_sheetID.setVisible(false);
										lbl_mod_sheetID_show.setVisible(true);
										
										lbl_mod_projectID_show.setText(text_mod_projectID.getText());
										text_mod_projectID.setVisible(false);
										lbl_mod_projectID_show.setVisible(true);
										
										lbl_mod_pd_show.setText(text_mod_pd.getText());
										text_mod_pd.setVisible(false);
										lbl_mod_pd_show.setVisible(true);
										
										lbl_mod_4.setText("Supplier ID :");
										text_mod_4.setText(temp.get(4));
										lbl_mod_4.setVisible(true);
										text_mod_4.setVisible(true);
										
										lbl_mod_5.setText("Vol. :");
										text_mod_5.setText(temp.get(5));
										lbl_mod_5.setVisible(true);
										text_mod_5.setVisible(true);
										
										lbl_mod_6.setText("Date :");
										text_mod_6.setText(temp.get(6));
										lbl_mod_6.setVisible(true);
										text_mod_6.setVisible(true);
										
										lbl_mod_7.setText("");
										text_mod_7.setText("");
										lbl_mod_7.setVisible(false);
										text_mod_7.setVisible(false);
										
										lbl_mod_8.setText("");
										text_mod_8.setText("");
										lbl_mod_8.setVisible(false);
										text_mod_8.setVisible(false);
										
										btn_mod_modify.setVisible(true);
										lbl_mod_message.setText("Data loaded");
										lbl_mod_message.setVisible(true);
										
									}else if (temp.get(1).equalsIgnoreCase("QUOT")) {
										
										lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
										text_mod_sheetID.setVisible(false);
										lbl_mod_sheetID_show.setVisible(true);
										
										lbl_mod_projectID_show.setText(text_mod_projectID.getText());
										text_mod_projectID.setVisible(false);
										lbl_mod_projectID_show.setVisible(true);
										
										lbl_mod_pd_show.setText(text_mod_pd.getText());
										text_mod_pd.setVisible(false);
										lbl_mod_pd_show.setVisible(true);
										
										lbl_mod_4.setText("Supplier ID :");
										text_mod_4.setText(temp.get(4));
										lbl_mod_4.setVisible(true);
										text_mod_4.setVisible(true);
										
										lbl_mod_5.setText("Vol. :");
										text_mod_5.setText(temp.get(5));
										lbl_mod_5.setVisible(true);
										text_mod_5.setVisible(true);
										
										lbl_mod_6.setText("Unit Price :");
										text_mod_6.setText(temp.get(6));
										lbl_mod_6.setVisible(true);
										text_mod_6.setVisible(true);
										
										lbl_mod_7.setText("ESD :");
										text_mod_7.setText(temp.get(8));
										lbl_mod_7.setVisible(true);
										text_mod_7.setVisible(true);
										
										lbl_mod_8.setText("Date :");
										text_mod_8.setText(temp.get(9));
										lbl_mod_8.setVisible(true);
										text_mod_8.setVisible(true);
										
										btn_mod_modify.setVisible(true);
										lbl_mod_message.setText("Data loaded");
										lbl_mod_message.setVisible(true);
									
									}else if (temp.get(1).equalsIgnoreCase("REQ")) {
										
										lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
										text_mod_sheetID.setVisible(false);
										lbl_mod_sheetID_show.setVisible(true);
										
										lbl_mod_projectID_show.setText(text_mod_projectID.getText());
										text_mod_projectID.setVisible(false);
										lbl_mod_projectID_show.setVisible(true);
										
										lbl_mod_pd_show.setText(text_mod_pd.getText());
										text_mod_pd.setVisible(false);
										lbl_mod_pd_show.setVisible(true);
										
										lbl_mod_4.setText("Item Name :");
										text_mod_4.setText(temp.get(4));
										lbl_mod_4.setVisible(true);
										text_mod_4.setVisible(true);
										
										lbl_mod_5.setText("Vol. :");
										text_mod_5.setText(temp.get(5));
										lbl_mod_5.setVisible(true);
										text_mod_5.setVisible(true);
										
										lbl_mod_6.setText("Unit Price :");
										text_mod_6.setText(temp.get(6));
										lbl_mod_6.setVisible(true);
										text_mod_6.setVisible(true);
										
										lbl_mod_7.setText("Supervisor ID :");
										text_mod_7.setText(temp.get(9));
										lbl_mod_7.setVisible(true);
										text_mod_7.setVisible(true);
										
										lbl_mod_8.setText("Date :");
										text_mod_8.setText(temp.get(10));
										lbl_mod_8.setVisible(true);
										text_mod_8.setVisible(true);
										
										btn_mod_modify.setVisible(true);
										lbl_mod_message.setText("Data loaded");
										lbl_mod_message.setVisible(true);
									
									}else if (temp.get(1).equalsIgnoreCase("PUR")) {
										
										lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
										text_mod_sheetID.setVisible(false);
										lbl_mod_sheetID_show.setVisible(true);
										
										lbl_mod_projectID_show.setText(text_mod_projectID.getText());
										text_mod_projectID.setVisible(false);
										lbl_mod_projectID_show.setVisible(true);
										
										lbl_mod_pd_show.setText(text_mod_pd.getText());
										text_mod_pd.setVisible(false);
										lbl_mod_pd_show.setVisible(true);
										
										lbl_mod_4.setText("Vol. :");
										text_mod_4.setText(temp.get(4));
										lbl_mod_4.setVisible(true);
										text_mod_4.setVisible(true);
										
										lbl_mod_5.setText("Unit price :");
										text_mod_5.setText(temp.get(5));
										lbl_mod_5.setVisible(true);
										text_mod_5.setVisible(true);
										
										lbl_mod_6.setText("ESD :");
										text_mod_6.setText(temp.get(7));
										lbl_mod_6.setVisible(true);
										text_mod_6.setVisible(true);
										
										lbl_mod_7.setText("Date :");
										text_mod_7.setText(temp.get(8));
										lbl_mod_7.setVisible(true);
										text_mod_7.setVisible(true);
										
										lbl_mod_8.setText("");
										text_mod_8.setText("");
										lbl_mod_8.setVisible(false);
										text_mod_8.setVisible(false);
										
										btn_mod_modify.setVisible(true);
										lbl_mod_message.setText("Data loaded");
										lbl_mod_message.setVisible(true);
									
									}else if (temp.get(1).equalsIgnoreCase("EXAM")) {
										
										lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
										text_mod_sheetID.setVisible(false);
										lbl_mod_sheetID_show.setVisible(true);
										
										lbl_mod_projectID_show.setText(text_mod_projectID.getText());
										text_mod_projectID.setVisible(false);
										lbl_mod_projectID_show.setVisible(true);
										
										lbl_mod_pd_show.setText(text_mod_pd.getText());
										text_mod_pd.setVisible(false);
										lbl_mod_pd_show.setVisible(true);
										
										lbl_mod_4.setText("Vol. :");
										text_mod_4.setText(temp.get(4));
										lbl_mod_4.setVisible(true);
										text_mod_4.setVisible(true);
										
										lbl_mod_5.setText("Date :");
										text_mod_5.setText(temp.get(6));
										lbl_mod_5.setVisible(true);
										text_mod_5.setVisible(true);
										
										lbl_mod_6.setText("");
										text_mod_6.setText("");
										lbl_mod_6.setVisible(false);
										text_mod_6.setVisible(false);
										
										lbl_mod_7.setText("");
										text_mod_7.setText("");
										lbl_mod_7.setVisible(false);
										text_mod_7.setVisible(false);
										
										lbl_mod_8.setText("");
										text_mod_8.setText("");
										lbl_mod_8.setVisible(false);
										text_mod_8.setVisible(false);
										
										btn_mod_modify.setVisible(true);
										lbl_mod_message.setText("Data loaded");
										lbl_mod_message.setVisible(true);
									
									}else {
										//if (temp.get(1).equalsIgnoreCase("RCPT"))
										lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
										text_mod_sheetID.setVisible(false);
										lbl_mod_sheetID_show.setVisible(true);
										
										lbl_mod_projectID_show.setText(text_mod_projectID.getText());
										text_mod_projectID.setVisible(false);
										lbl_mod_projectID_show.setVisible(true);
										
										lbl_mod_pd_show.setText(text_mod_pd.getText());
										text_mod_pd.setVisible(false);
										lbl_mod_pd_show.setVisible(true);
										
										lbl_mod_4.setText("Vol. :");
										text_mod_4.setText(temp.get(4));
										lbl_mod_4.setVisible(true);
										text_mod_4.setVisible(true);
										
										lbl_mod_5.setText("Date :");
										text_mod_5.setText(temp.get(5));
										lbl_mod_5.setVisible(true);
										text_mod_5.setVisible(true);
										
										lbl_mod_6.setText("");
										text_mod_6.setText("");
										lbl_mod_6.setVisible(false);
										text_mod_6.setVisible(false);
										
										lbl_mod_7.setText("");
										text_mod_7.setText("");
										lbl_mod_7.setVisible(false);
										text_mod_7.setVisible(false);
										
										lbl_mod_8.setText("");
										text_mod_8.setText("");
										lbl_mod_8.setVisible(false);
										text_mod_8.setVisible(false);
										
										btn_mod_modify.setVisible(true);
										lbl_mod_message.setText("Data loaded");
										lbl_mod_message.setVisible(true);
										
									}
								}else {
										lbl_mod_4.setText("");
										lbl_mod_4.setVisible(false);
										text_mod_4.setVisible(false);
										
										lbl_mod_5.setText("");
										lbl_mod_5.setVisible(false);
										text_mod_5.setVisible(false);	
										
										lbl_mod_6.setText("");
										lbl_mod_6.setVisible(false);
										text_mod_6.setVisible(false);							
										
										lbl_mod_7.setText("");
										lbl_mod_7.setVisible(false);
										text_mod_7.setVisible(false);
										
										lbl_mod_8.setText("");
										lbl_mod_8.setVisible(false);
										text_mod_8.setVisible(false);
										
										btn_mod_modify.setVisible(false);
										lbl_mod_message.setText("please check data again");
										lbl_mod_message.setVisible(true);	
								}
						}
					}
				});
				btn_mod_check.setBounds(389, 36, 83, 29);
				mod_panel.add(btn_mod_check);
				
				lbl_mod_6 = new JLabel("");
				lbl_mod_6.setBounds(154, 233, 106, 16);
				lbl_mod_6.setVisible(false);
				mod_panel.add(lbl_mod_6);
				
				text_mod_6 = new JTextField();
				text_mod_6.setBounds(272, 228, 115, 26);
				text_mod_6.setVisible(false);
				mod_panel.add(text_mod_6);
				text_mod_6.setColumns(10);
				
				lbl_mod_7 = new JLabel("");
				lbl_mod_7.setBounds(154, 276, 106, 16);
				lbl_mod_7.setVisible(false);
				mod_panel.add(lbl_mod_7);
				
				text_mod_7 = new JTextField();
				text_mod_7.setBounds(272, 266, 115, 26);
				text_mod_7.setVisible(false);
				mod_panel.add(text_mod_7);
				text_mod_7.setColumns(10);
				
				lbl_mod_message = new JLabel("");
				lbl_mod_message.setBounds(399, 117, 227, 16);
				lbl_mod_message.setVisible(false);
				mod_panel.add(lbl_mod_message);
				
				lbl_mod_note = new JLabel("* neccessary");
				lbl_mod_note.setBounds(41, 41, 123, 16);
				mod_panel.add(lbl_mod_note);
				
				text_mod_8 = new JTextField();
				text_mod_8.setBounds(272, 304, 115, 26);
				text_mod_8.setVisible(false);
				mod_panel.add(text_mod_8);
				text_mod_8.setColumns(10);
				
				lbl_mod_8 = new JLabel("");
				lbl_mod_8.setBounds(154, 309, 100, 16);
				lbl_mod_8.setVisible(false);
				mod_panel.add(lbl_mod_8);
				
				btn_mod_clear = new JButton("Clear");
				btn_mod_clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btn_mod_clear.setBounds(389, 74, 83, 29);
				btn_mod_clear.setVisible(true);
				mod_panel.add(btn_mod_clear);
				
				lbl_mod_sheetID_show = new JLabel("");
				lbl_mod_sheetID_show.setBounds(272, 41, 115, 16);
				lbl_mod_sheetID_show.setVisible(false);
				mod_panel.add(lbl_mod_sheetID_show);
				
				lbl_mod_projectID_show = new JLabel("");
				lbl_mod_projectID_show.setBounds(272, 79, 115, 16);
				lbl_mod_projectID_show.setVisible(false);
				mod_panel.add(lbl_mod_projectID_show);
				
				lbl_mod_pd_show = new JLabel("");
				lbl_mod_pd_show.setBounds(272, 117, 115, 16);
				lbl_mod_pd_show.setVisible(false);
				mod_panel.add(lbl_mod_pd_show);
	
			}
			
			//third panel - Append sheet
			private void add_append_panel() {
				
				append_panel = new JPanel();
				append_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(append_panel, "Append");
				append_panel.setLayout(null);
				
				JLabel lbl_appd_type = new JLabel("*Sheet type:");
				lbl_appd_type.setBounds(48, 11, 85, 16);
				lbl_appd_type.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_type);
				
				lbl_appd_1 = new JLabel("");
				lbl_appd_1.setBounds(280, 11, 134, 16);
				lbl_appd_1.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_1.setVisible(false);
				append_panel.add(lbl_appd_1);
				
				text_appd_1 = new JTextField();
				text_appd_1.setBounds(414, 6, 116, 26);
				text_appd_1.setVisible(false);
				append_panel.add(text_appd_1);
				text_appd_1.setColumns(10);
				
				lbl_appd_2 = new JLabel("");
				lbl_appd_2.setBounds(280, 44, 134, 16);
				lbl_appd_2.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_2.setVisible(false);
				append_panel.add(lbl_appd_2);
				
				text_appd_2 = new JTextField();
				text_appd_2.setBounds(414, 39, 116, 26);
				text_appd_2.setVisible(false);
				append_panel.add(text_appd_2);
				text_appd_2.setColumns(10);
				
				lbl_appd_3 = new JLabel("");
				lbl_appd_3.setBounds(358, 75, 56, 16);
				lbl_appd_3.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_3.setVisible(false);
				append_panel.add(lbl_appd_3);
				
				text_appd_3 = new JTextField();
				text_appd_3.setBounds(414, 70, 116, 26);
				text_appd_3.setVisible(false);
				append_panel.add(text_appd_3);
				text_appd_3.setColumns(10);
				
				lbl_appd_4 = new JLabel("");
				lbl_appd_4.setBounds(280, 106, 134, 16);
				lbl_appd_4.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_4.setVisible(false);
				append_panel.add(lbl_appd_4);
				
				text_appd_4 = new JTextField();
				text_appd_4.setBounds(414, 101, 116, 26);
				text_appd_4.setVisible(false);
				append_panel.add(text_appd_4);
				text_appd_4.setColumns(10);
				
				lbl_appd_5 = new JLabel("");
				lbl_appd_5.setBounds(280, 137, 134, 16);
				lbl_appd_5.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_5.setVisible(false);
				append_panel.add(lbl_appd_5);
				
				text_appd_5 = new JTextField();
				text_appd_5.setBounds(414, 132, 116, 26);
				text_appd_5.setVisible(false);
				append_panel.add(text_appd_5);
				text_appd_5.setColumns(10);
				
				lbl_appd_6 = new JLabel("");
				lbl_appd_6.setBounds(341, 168, 73, 16);
				lbl_appd_6.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_6.setVisible(false);
				append_panel.add(lbl_appd_6);
				
				text_appd_6 = new JTextField();
				text_appd_6.setBounds(414, 163, 116, 26);
				text_appd_6.setVisible(false);
				append_panel.add(text_appd_6);
				text_appd_6.setColumns(10);
				
				lbl_appd_7 = new JLabel("");
				lbl_appd_7.setBounds(329, 200, 85, 16);
				lbl_appd_7.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_appd_7.setVisible(false);
				append_panel.add(lbl_appd_7);
				
				text_appd_7 = new JTextField();
				text_appd_7.setBounds(414, 195, 116, 26);
				text_appd_7.setVisible(false);
				append_panel.add(text_appd_7);
				text_appd_7.setColumns(10);
				
				btn_appd_append = new JButton("Append");
				btn_appd_append.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if (rb_appd_RFQ.isSelected()) {
							if (append_check("RFQ")) {
								if(lib.projectID_check(text_appd_1)&lib.supplier_check(text_appd_3)&lib.num_not_null_check(text_appd_4)) {
									if((!text_appd_5.getText().isBlank())&lib.date(text_appd_5.getText())) {
										
										String[][] temp = append("RFQ");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Product", "Supplier", "Vol.", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
										
									}else if(text_appd_5.getText().isBlank()){
										
											String[][] temp = append("RFQ");
											String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Product", "Supplier", "Vol.", "Date"};
											
											if(temp[0].length!=0) {
												DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
												append_table.setModel(append_table_model);
												append_table.setVisible(true);
												scrollpane_append.setVisible(true);
												lbl_append_message.setVisible(false);
											}else {
												lbl_append_message.setText("Please verify your inputted data again");
												lbl_append_message.setVisible(true);
												append_table.setVisible(false);
												scrollpane_append.setVisible(false);
											}
										}
											
								}else {
									lbl_append_message.setText("Format Invalid");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							}else {
								lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
	
						}else if (rb_appd_QUO.isSelected()) {
							if (append_check("QUOT")) {
								if(lib.projectID_check(text_appd_1)&lib.supplier_check(text_appd_3)&lib.num_not_null_check(text_appd_4)
										&lib.num_not_null_check(text_appd_5)&lib.date(text_appd_6.getText())) {
									if((!text_appd_7.getText().isBlank())&lib.date(text_appd_7.getText())) {
									
										String[][] temp = append("QUOT");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Product", "Supplier", "Vol.", "Unit Price",
																"Total_price", "ESD", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}else if(text_appd_7.getText().isBlank()){
										
										String[][] temp = append("QUOT");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Product", "Supplier", "Vol.", "Unit Price",
																"Total_price", "ESD", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}		
								}else {
									lbl_append_message.setText("Format Invalid");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							}else {
								lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
							
						}else if (rb_appd_REQ.isSelected()) {
							if (append_check("REQ")) {
								if(lib.projectID_check(text_appd_1)&lib.num_not_null_check(text_appd_3)&lib.num_not_null_check(text_appd_4)
										&lib.supervisor_check(text_appd_6)) {
									if((!text_appd_7.getText().isBlank())&lib.date(text_appd_7.getText())) {
										String[][] temp = append("REQ");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Item Name", "Vol.", "Unit Price",
												"Total_price", "Signature", "Supervisor", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}else if(text_appd_7.getText().isBlank()) {
										
										String[][] temp = append("REQ");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Item Name", "Vol.", "Unit Price",
												"Total_price", "Signature", "Supervisor", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}
								}else {
									lbl_append_message.setText("Format Invalid");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							}else {
								lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
							
						}else if (rb_appd_PUR.isSelected()) {
							if (append_check("PUR")) {
								if(lib.projectID_check(text_appd_1)&lib.module_check(text_appd_2)&lib.num_not_null_check(text_appd_3)
										&lib.num_not_null_check(text_appd_4)&lib.date(text_appd_5.getText())) {
									if((!text_appd_6.getText().isBlank())&lib.date(text_appd_6.getText())) {
										
										String[][] temp = append("PUR");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Unit Price",
												"Total_price", "ESD", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}else if(text_appd_6.getText().isBlank()) {
										
										String[][] temp = append("PUR");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Unit Price",
												"Total_price", "ESD", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}
								}else {
									lbl_append_message.setText("Format Invalid");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							}else {
								lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}		
						}else if (rb_appd_EXAM.isSelected()) {
							if (append_check("EXAM")){
								if(lib.projectID_check(text_appd_1)&lib.module_check(text_appd_2)
										&lib.num_not_null_check(text_appd_3)&lib.tf_check(text_appd_4)){
									if((!text_appd_5.getText().isBlank())&lib.date(text_appd_5.getText())) {
										
										String[][] temp = append("EXAM");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Result", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}else if(text_appd_5.getText().isBlank()) {
										String[][] temp = append("EXAM");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Result", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}									
									}
								}else {
									lbl_append_message.setText("Format Invalid");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}	
							}else {
								lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						}else {
							//if (rb_appd_RCPT.isSelected()) {
							if (append_check("RCPT")) {
								if(lib.projectID_check(text_appd_1)&lib.module_check(text_appd_2)
										&lib.num_not_null_check(text_appd_3)){
									if((!text_appd_4.getText().isBlank())&lib.date(text_appd_4.getText())) {
										String[][] temp = append("RCPT");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}else if(text_appd_4.getText().isBlank()) {
										
										String[][] temp = append("RCPT");
										String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Date"};
										
										if(temp[0].length!=0) {
											DefaultTableModel append_table_model = new DefaultTableModel(temp,columns);
											append_table.setModel(append_table_model);
											append_table.setVisible(true);
											scrollpane_append.setVisible(true);
											lbl_append_message.setVisible(false);
											
										}else {
											lbl_append_message.setText("Please verify your inputted data again");
											lbl_append_message.setVisible(true);
											append_table.setVisible(false);
											scrollpane_append.setVisible(false);
										}
									}
								}else {
									lbl_append_message.setText("Format Invalid");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}	
							}else {
								lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						}	
					}
				});
				btn_appd_append.setBounds(563, 5, 92, 29);
				append_panel.add(btn_appd_append);
				
				ButtonGroup bg = new ButtonGroup();
				
				rb_appd_RFQ = new JRadioButton("R.F.Q");
				rb_appd_RFQ.setBounds(137, 8, 110, 23);
				append_panel.add(rb_appd_RFQ);
				rb_appd_RFQ.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_appd_1.setText("Project ID :");
			            lbl_appd_1.setVisible(true);
			            text_appd_1.setVisible(true);
			            
			            lbl_appd_2.setText("Inquiring Product :");
			            lbl_appd_2.setVisible(true);
			            text_appd_2.setVisible(true);
			            
			            lbl_appd_3.setText("Supplier ID :");
			            lbl_appd_3.setVisible(true);
			            text_appd_3.setVisible(true);
			            
			            lbl_appd_4.setText("Vol. :");
			            lbl_appd_4.setVisible(true);
			            text_appd_4.setVisible(true);
			            
			            lbl_appd_5.setText("Date :");
			            lbl_appd_5.setVisible(true);
			            text_appd_5.setVisible(true);
			            
			            lbl_appd_6.setText("");
			            lbl_appd_6.setVisible(false);
			            text_appd_6.setVisible(false);
			            
			            lbl_appd_7.setText("");
			            lbl_appd_7.setVisible(false);
			            text_appd_7.setVisible(false);
			            
			            
			            
			        }
			    });
				bg.add(rb_appd_RFQ);
				
				rb_appd_QUO = new JRadioButton("Quotation");
				rb_appd_QUO.setBounds(137, 40, 110, 23);
				append_panel.add(rb_appd_QUO);
				
				rb_appd_QUO.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_appd_1.setText("Project ID :");
			            lbl_appd_1.setVisible(true);
			            text_appd_1.setVisible(true);
			            
			            lbl_appd_2.setText("Inquiring Product :");
			            lbl_appd_2.setVisible(true);
			            text_appd_2.setVisible(true);
			            
			            lbl_appd_3.setText("Supplier ID :");
			            lbl_appd_3.setVisible(true);
			            text_appd_3.setVisible(true);
			            
			            lbl_appd_4.setText("Vol. :");
			            lbl_appd_4.setVisible(true);
			            text_appd_4.setVisible(true);
			            
			            lbl_appd_5.setText("Unit Price :");
			            lbl_appd_5.setVisible(true);
			            text_appd_5.setVisible(true);
			            
			            lbl_appd_6.setText("ESD :");
			            lbl_appd_6.setVisible(true);
			            text_appd_6.setVisible(true);
			            
			            lbl_appd_7.setText("Date :");
			            lbl_appd_7.setVisible(true);
			            text_appd_7.setVisible(true);
			            
			        }
			    });
				bg.add(rb_appd_QUO);
				
				rb_appd_REQ = new JRadioButton("Requisition");
				rb_appd_REQ.setBounds(137, 71, 110, 23);
				append_panel.add(rb_appd_REQ);
				rb_appd_REQ.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_appd_1.setText("Project ID :");
			            lbl_appd_1.setVisible(true);
			            text_appd_1.setVisible(true);
			            
			            lbl_appd_2.setText("Inquiring Product :");
			            lbl_appd_2.setVisible(true);
			            text_appd_2.setVisible(true);
			            
			            lbl_appd_3.setText("Item Name :");
			            lbl_appd_3.setVisible(true);
			            text_appd_3.setVisible(true);
			            
			            lbl_appd_4.setText("Vol. :");
			            lbl_appd_4.setVisible(true);
			            text_appd_4.setVisible(true);
			            
			            lbl_appd_5.setText("Unit Price :");
			            lbl_appd_5.setVisible(true);
			            text_appd_5.setVisible(true);
			            
			            lbl_appd_6.setText("Supervisor ID:");
			            lbl_appd_6.setVisible(true);
			            text_appd_6.setVisible(true);
			            
			            lbl_appd_7.setText("Date :");
			            lbl_appd_7.setVisible(true);
			            text_appd_7.setVisible(true);
			        }
			    });
				bg.add(rb_appd_REQ);
				
				rb_appd_PUR = new JRadioButton("Purchase");
				rb_appd_PUR.setBounds(137, 102, 110, 23);
				append_panel.add(rb_appd_PUR);
				rb_appd_PUR.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_appd_1.setText("Project ID :");
			            lbl_appd_1.setVisible(true);
			            text_appd_1.setVisible(true);
			            
			            lbl_appd_2.setText("Module Type :");
			            lbl_appd_2.setVisible(true);
			            text_appd_2.setVisible(true);
			            
			            lbl_appd_3.setText("Vol. :");
			            lbl_appd_3.setVisible(true);
			            text_appd_3.setVisible(true);
			            
			            lbl_appd_4.setText("Unit Price :");
			            lbl_appd_4.setVisible(true);
			            text_appd_4.setVisible(true);
			            
			            lbl_appd_5.setText("ESD :");
			            lbl_appd_5.setVisible(true);
			            text_appd_5.setVisible(true);
			            
			            lbl_appd_6.setText("Date :");
			            lbl_appd_6.setVisible(true);
			            text_appd_6.setVisible(true);
			            
			            lbl_appd_7.setText("");
			            lbl_appd_7.setVisible(false);
			            text_appd_7.setVisible(false);
			        }
			    });
				bg.add(rb_appd_PUR);
				
				rb_appd_EXAM = new JRadioButton("Examination");
				rb_appd_EXAM.setBounds(137, 133, 110, 23);
				append_panel.add(rb_appd_EXAM);
				rb_appd_EXAM.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_appd_1.setText("Project ID :");
			            lbl_appd_1.setVisible(true);
			            text_appd_1.setVisible(true);
			            
			            lbl_appd_2.setText("Module Type :");
			            lbl_appd_2.setVisible(true);
			            text_appd_2.setVisible(true);
			            
			            lbl_appd_3.setText("Vol. :");
			            lbl_appd_3.setVisible(true);
			            text_appd_3.setVisible(true);
			            
			            lbl_appd_4.setText("Result :");
			            lbl_appd_4.setVisible(true);
			            text_appd_4.setVisible(true);
			            
			            lbl_appd_5.setText("Date :");
			            lbl_appd_5.setVisible(true);
			            text_appd_5.setVisible(true);
			            
			            lbl_appd_6.setText("");
			            lbl_appd_6.setVisible(false);
			            text_appd_6.setVisible(false);
			            
			            lbl_appd_7.setText("");
			            lbl_appd_7.setVisible(false);
			            text_appd_7.setVisible(false);
			        }
			    });
				bg.add(rb_appd_EXAM);
				
				rb_appd_RCPT = new JRadioButton("Receipt");
				rb_appd_RCPT.setBounds(137, 164, 110, 23);
				append_panel.add(rb_appd_RCPT);
				rb_appd_RCPT.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	
			        	lbl_appd_1.setText("Project ID :");
			            lbl_appd_1.setVisible(true);
			            text_appd_1.setVisible(true);
			            
			            lbl_appd_2.setText("Module Type :");
			            lbl_appd_2.setVisible(true);
			            text_appd_2.setVisible(true);
			            
			            lbl_appd_3.setText("Vol. :");
			            lbl_appd_3.setVisible(true);
			            text_appd_3.setVisible(true);
			            
			            lbl_appd_4.setText("Date :");
			            lbl_appd_4.setVisible(true);
			            text_appd_4.setVisible(true);
			            
			            lbl_appd_5.setText("");
			            lbl_appd_5.setVisible(false);
			            text_appd_5.setVisible(false);
			            
			            lbl_appd_6.setText("");
			            lbl_appd_6.setVisible(false);
			            text_appd_6.setVisible(false);
			            
			            lbl_appd_7.setText("");
			            lbl_appd_7.setVisible(false);
			            text_appd_7.setVisible(false);
			        }
			    });
				bg.add(rb_appd_RCPT);
				
				
				append_table = new JTable(){ 
					@Override
					public boolean isCellEditable(int row, int column)
		            {
		                                  return false;}//uneditable
		            
					}; 
				append_table.setBounds(33, 292, 603, 49);
				
				
				//inventory_panel.add(inv_table);
				

				scrollpane_append = new JScrollPane(append_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
				scrollpane_append.setBounds(55,279,563,48);
				
				append_panel.add(scrollpane_append);
				
				JButton btn_append_clear = new JButton("Clear");
				btn_append_clear.setBounds(545, 200, 73, 29);
				append_panel.add(btn_append_clear);
				
				lbl_append_message = new JLabel("");
				lbl_append_message.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_append_message.setBounds(55, 251, 563, 16);
				lbl_append_message.setVisible(false);
				append_panel.add(lbl_append_message);
				
			}
			
			//forth panel - remove sheet
			private void add_remove_panel() {
						
				remove_panel = new JPanel();
				remove_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(remove_panel, "Remove");
				remove_panel.setLayout(null);
				
				JLabel lbl_remove_sheetID = new JLabel("*sheet ID :");
				lbl_remove_sheetID.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_remove_sheetID.setBounds(45, 41, 103, 16);
				remove_panel.add(lbl_remove_sheetID);
				
				text_remove_sheetID = new JTextField();
				text_remove_sheetID.setBounds(167, 36, 146, 26);
				remove_panel.add(text_remove_sheetID);
				text_remove_sheetID.setColumns(10);
				
				JButton btn_remove_check = new JButton("Check");
				btn_remove_check.setBounds(325, 36, 76, 29);
				btn_remove_check.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(!lib.num_not_null_check(text_remove_sheetID)|!lib.num_not_null_check(text_remove_projectID)
																						|text_remove_pd.getText().isBlank()) {
							//None of them can't be blank 
							
							lbl_mod_message.setText("Format Invalid");
							lbl_mod_message.setVisible(true);
							
						}else {
							
							ArrayList<String> temp_list = check(text_remove_sheetID, text_remove_projectID, text_remove_pd);
							
							if (temp_list.size()!=0) {
								//data found
								
								String[][] temp_array = new String[1][temp_list.size()];
								for(int i=0; i< temp_list.size();i++) {
									temp_array[0][i]=temp_list.get(i);
								}
								
								if(temp_array[0][1].equalsIgnoreCase("RFQ")) {
									
									String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Product", "Supplier", "Vol.", "Date"};
									
									DefaultTableModel remove_table_model = new DefaultTableModel(temp_array, columns);
									remove_table.setModel(remove_table_model);
									
									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);
									
									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									
									
								}else if (temp_array[0][1].equalsIgnoreCase("QUOT")) {
									
									String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Product", "Supplier", "Vol.", "Unit Price",
											"Total_price", "ESD", "Date"};
									
									DefaultTableModel remove_table_model = new DefaultTableModel(temp_array, columns);
									remove_table.setModel(remove_table_model);
									
									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);
									
									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									
								}else if (temp_array[0][1].equalsIgnoreCase("REQ")) {
									
									String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Item Name", "Vol.", "Unit Price",
											"Total_price", "Signature", "Supervisor", "Date"};
									
									DefaultTableModel remove_table_model = new DefaultTableModel(temp_array, columns);
									remove_table.setModel(remove_table_model);
									
									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);
									
									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									
								}else if (temp_array[0][1].equalsIgnoreCase("PUR")) {
									
									String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Unit Price",
											"Total_price", "ESD", "Date"};
									
									DefaultTableModel remove_table_model = new DefaultTableModel(temp_array, columns);
									remove_table.setModel(remove_table_model);
									
									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);
									
									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									
								}else if (temp_array[0][1].equalsIgnoreCase("EXAM")) {
									
									String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Result", "Date"};
									
									DefaultTableModel remove_table_model = new DefaultTableModel(temp_array, columns);
									remove_table.setModel(remove_table_model);
									
									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);
									
									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									
								}else {
									//temp_array[0][1].equalsIgnoreCase("RCPT")
									String[] columns = {"Sheet ID", "Sheet type", "Project ID", "Module", "Vol.", "Date"};
									
									DefaultTableModel remove_table_model = new DefaultTableModel(temp_array, columns);
									remove_table.setModel(remove_table_model);
									
									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);
									
									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
								}
							}else {
								//data no found
								
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
				});
				remove_panel.add(btn_remove_check);
				
				remove_table = new JTable(){ 
					@Override
					public boolean isCellEditable(int row, int column)
		            {
		                                  return false;}//uneditable    
				};
				remove_table.setBounds(78, 177, 506, 47);
				
				remove_table.setVisible(false);
				
				scrollpane_remove = new JScrollPane(remove_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollpane_remove.setBounds(45,195,563,43);
				scrollpane_remove.setVisible(false);
				remove_panel.add(scrollpane_remove);
				
				lbl_remove_confirm = new JLabel("Please write down \" I would like to remove this sheet permenantly.\"");
				lbl_remove_confirm.setBounds(55, 250, 555, 16);
				lbl_remove_confirm.setVisible(false);
				remove_panel.add(lbl_remove_confirm);
				
				text_remove_confirm = new JTextField();
				text_remove_confirm.setBounds(55, 263, 443, 26);
				text_remove_confirm.setColumns(10);
				text_remove_confirm.setVisible(false);
				remove_panel.add(text_remove_confirm);
				
				btn_remove_confirm = new JButton("Confirm");
				btn_remove_confirm.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						if(text_remove_confirm.getText().equals("I would like to remove this sheet permenantly.")) {
							if(delete()==1) { 
								
							
								lbl_remove_message.setText("Delete succeed");
								lbl_remove_message.setVisible(true);
								
							}else {
								lbl_remove_message.setText("Delete failed, errors occurred.");
								lbl_remove_message.setVisible(true);
							}
						}
					}
				});
				btn_remove_confirm.setBounds(494, 301, 93, 29);
				btn_remove_confirm.setVisible(false);
				remove_panel.add(btn_remove_confirm);
				
				text_remove_projectID = new JTextField();
				text_remove_projectID.setBounds(167, 73, 146, 26);
				remove_panel.add(text_remove_projectID);
				text_remove_projectID.setColumns(10);
				
				text_remove_pd = new JTextField();
				text_remove_pd.setBounds(167, 111, 146, 26);
				remove_panel.add(text_remove_pd);
				text_remove_pd.setColumns(10);
				
				JLabel lbl_remove_projectID = new JLabel("*Project ID :");
				lbl_remove_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_remove_projectID.setBounds(45, 78, 103, 16);
				remove_panel.add(lbl_remove_projectID);
				
				JLabel lbl_remove_pd = new JLabel("*Product :");
				lbl_remove_pd.setHorizontalAlignment(SwingConstants.RIGHT);
				lbl_remove_pd.setBounds(45, 116, 103, 16);
				remove_panel.add(lbl_remove_pd);
				
				JButton btn_remove_clear = new JButton("Clear");
				btn_remove_clear.setBounds(325, 77, 76, 29);
				remove_panel.add(btn_remove_clear);
				
				lbl_remove_sheetID_show = new JLabel("");
				lbl_remove_sheetID_show.setBounds(167, 41, 146, 16);
				lbl_remove_sheetID_show.setVisible(false);
				remove_panel.add(lbl_remove_sheetID_show);
				
				lbl_remove_projectID_show = new JLabel("");
				lbl_remove_projectID_show.setBounds(167, 78, 146, 16);
				lbl_remove_projectID_show.setVisible(false);
				remove_panel.add(lbl_remove_projectID_show);
				
				lbl_remove_pd_show = new JLabel("");
				lbl_remove_pd_show.setBounds(167, 116, 146, 16);
				lbl_remove_pd_show.setVisible(false);
				remove_panel.add(lbl_remove_pd_show);
				
				lbl_remove_message = new JLabel("");
				lbl_remove_message.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_remove_message.setBounds(67, 167, 506, 16);
				remove_panel.add(lbl_remove_message);
				
		
				}
			
			//fifth panel - sign sheet only supervisor
			private void add_sign_panel() {
					
					sign_panel = new JPanel();
					sign_panel.setBounds(0, 0, 666, 348);
					sheet_container_panel.add(sign_panel, "Signature");
					sign_panel.setLayout(null);
					
					
					lbl_sign_sorry = new JLabel("Sorry, no right to access this page, work harder for promotion.");
					lbl_sign_sorry.setBounds(62, 34, 517, 16);
					sign_panel.add(lbl_sign_sorry);
					
					
					lbl_sign_instr = new JLabel("");
					lbl_sign_instr.setBounds(62, 68, 411, 16);
					sign_panel.add(lbl_sign_instr);
					
					
					sign_table = new JTable(){
						@Override
						public boolean isCellEditable(int row, int column)
			            {
			                                  return false;}//uneditable
			            
					};
					sign_table.setBounds(62, 97, 546, 192);
					
					sign_table.setVisible(false);
					
					scrollpane_sign = new JScrollPane(sign_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
					scrollpane_sign.setBounds(46,189,563,87);
					scrollpane_sign.setVisible(false);
					sign_panel.add(scrollpane_sign);
					
					btn_sign_sign = new JButton("Sign all");
					btn_sign_sign.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							if (sign_all()==0) {
								lbl_sign_instr.setText("Oops errors occurred");
								lbl_sign_instr.setVisible(true);
								
								
							}else {
								lbl_sign_instr.setText("Sign succeed");
								lbl_sign_instr.setVisible(true);
							}
						}
					});
					btn_sign_sign.setBounds(528, 281, 81, 29);
					sign_panel.add(btn_sign_sign);
					//btn_sign.setVisible(true);
					
					btn_sign_refresh = new JButton("Refresh");
					btn_sign_refresh.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							String[][] temp = show_unsign_req();
							
							if(temp.length!=0) {
								
								String[] columns_name = {"Sheet ID", "Sheet Type", "Project ID", "Product", "Item", "Vol.", "Unit Price", 
										"Total Price", "Signature", "Supervisor ID", "Name","Date"};
							
								lbl_sign_sorry.setVisible(false);
								btn_sign_sign.setVisible(true);
								btn_sign_refresh.setVisible(true);
								lbl_sign_instr.setText("Please sign sheets below after reading.");
								lbl_sign_instr.setVisible(true);
								
								DefaultTableModel sign_table_model = new DefaultTableModel(temp,columns_name);
								sign_table.setModel(sign_table_model);		
								sign_table.setVisible(true);
								scrollpane_sign.setVisible(true);
								
							}else {
								
								lbl_sign_instr.setText("All sheets are signed");
								lbl_sign_instr.setVisible(true);
								
								lbl_sign_sorry.setVisible(false);
								btn_sign_sign.setVisible(false);
								btn_sign_refresh.setVisible(false);
								sign_table.setVisible(false);
								scrollpane_sign.setVisible(false);
							}	
						}
					});
					btn_sign_refresh.setBounds(497, 63, 112, 29);
					sign_panel.add(btn_sign_refresh);
					//btn_refresh.setVisible(true);
					
					
					
					
			}
			
			
			
			
	private String[][] inquire_all(JTextField first, JTextField second, JTextField third){
				
		/**@author jyunanyang
		 * @since 05/06/2021
		 * 
		 */
		
		ArrayList<String[]> temp = new ArrayList();
				
			switch(lib.check_text_fields(first, second,third)) {
			
				
				case "011":
					try {
						ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID\n"
								+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
								+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
								+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
								+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
								+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
								+ "AND EXAM.Module_type = PUR.Module_type)\n"
								+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
								+ "AND RCPT.Module_type = EXAM.MOdule_type) LEFT JOIN SUPPLIER AS SUP \n"
								+ "ON (sup.Supplier_ID=RFQ.Supplier_ID AND sup.Supplier_ID=QUOT.Supplier_ID) WHERE (pj.Project_ID="
								+ text_inq_projectID.getText()+"AND RFQ.Inquiring_product=\'"+text_inq_pd.getText()+"\')");
						
						while(r.next()) {
							
							if(r.getString(6)!= null) {
								
								String [] rfq = new String[7];
								for(int i =6; i<13;i++) {
									
									rfq[0]=r.getString(1);
									
									if(i==8) 
										continue;
									
									else if(i>8)
										rfq[i-6]=r.getString(i);
									
									else
										rfq[i-5]=r.getString(i);		
								}
								rfq = lib.insert(rfq, r.getString(57), 5);
								temp.add(rfq);
								
								if(r.getString(13)!= null) {
									
									String [] quo = new String[10];
									for(int i =13; i<23;i++) {
										
										quo[0]=r.getString(1);
										
										if(i==15) 
											continue;
										
										else if(i>15)
											quo[i-13]=r.getString(i);
										
										else
											quo[i-12]=r.getString(i);		
									}
									quo = lib.insert(quo, r.getString(57), 5);
									temp.add(quo);
									
									if(r.getString(23)!= null) {
										String [] req = new String[11];
										for(int i =23; i<34;i++) {
											
											req[0]=r.getString(1);
											
											if(i==25) 
												continue;
											
											else if(i>25)
												req[i-23]=r.getString(i);
											
											else
												req[i-22]=r.getString(i);		
										}
										temp.add(req);
										
										if (r.getString(34)!= null) {
											
											String [] pur = new String[9];
											for(int i =34; i<43;i++) {
												
												pur[0]=r.getString(1);
												
												if(i==37) 
													continue;
												
												else if(i>37)
													pur[i-34]=r.getString(i);
												
												else
													pur[i-33]=r.getString(i);		
											}
											temp.add(pur);
											
											if(r.getString(43)!= null) {
												
												String [] exam = new String[7];
												for(int i =43; i<50;i++) {
													
													exam[0]=r.getString(1);
													
													if(i==45) 
														continue;
													
													else if(i>45)
														exam[i-43]=r.getString(i);
													
													else
														exam[i-42]=r.getString(i);		
												}
												temp.add(exam);
												
												if(r.getString(50)!= null) {
													
													String [] rcpt = new String[6];
													for(int i =50; i<56;i++) {
														
														rcpt[0]=r.getString(1);
														
														if(i==52) 
															continue;
														
														else if(i>52)
															rcpt[i-50]=r.getString(i);
														
														else
															rcpt[i-49]=r.getString(i);		
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
						
						}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
			
				case "010":
					
					try {
						
						ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID\n"
								+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
								+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
								+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
								+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
								+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
								+ "AND EXAM.Module_type = PUR.Module_type)\n"
								+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
								+ "AND RCPT.Module_type = EXAM.MOdule_type) LEFT JOIN SUPPLIER AS SUP \n"
								+ "ON (sup.Supplier_ID=RFQ.Supplier_ID AND sup.Supplier_ID=QUOT.Supplier_ID) WHERE pj.Project_ID ="
								+text_inq_projectID.getText());
						
						while(r.next()) {
							
							if(r.getString(6)!= null) {
								
								String [] rfq = new String[7];
								for(int i =6; i<13;i++) {
									
									rfq[0]=r.getString(1);
									
									if(i==8) 
										continue;
									
									else if(i>8)
										rfq[i-6]=r.getString(i);
									
									else
										rfq[i-5]=r.getString(i);		
								}
								rfq = lib.insert(rfq, r.getString(57), 5);
								temp.add(rfq);
								
								if(r.getString(13)!= null) {
									
									String [] quo = new String[10];
									for(int i =13; i<23;i++) {
										
										quo[0]=r.getString(1);
										
										if(i==15) 
											continue;
										
										else if(i>15)
											quo[i-13]=r.getString(i);
										
										else
											quo[i-12]=r.getString(i);		
									}
									quo = lib.insert(quo, r.getString(57), 5);
									temp.add(quo);
									
									if(r.getString(23)!= null) {
										String [] req = new String[11];
										for(int i =23; i<34;i++) {
											
											req[0]=r.getString(1);
											
											if(i==25) 
												continue;
											
											else if(i>25)
												req[i-23]=r.getString(i);
											
											else
												req[i-22]=r.getString(i);		
										}
										temp.add(req);
										
										if (r.getString(34)!= null) {
											
											String [] pur = new String[9];
											for(int i =34; i<43;i++) {
												
												pur[0]=r.getString(1);
												
												if(i==37) 
													continue;
												
												else if(i>37)
													pur[i-34]=r.getString(i);
												
												else
													pur[i-33]=r.getString(i);		
											}
											temp.add(pur);
											
											if(r.getString(43)!= null) {
												
												String [] exam = new String[7];
												for(int i =43; i<50;i++) {
													
													exam[0]=r.getString(1);
													
													if(i==45) 
														continue;
													
													else if(i>45)
														exam[i-43]=r.getString(i);
													
													else
														exam[i-42]=r.getString(i);		
												}
												temp.add(exam);
												
												if(r.getString(50)!= null) {
													
													String [] rcpt = new String[6];
													for(int i =50; i<56;i++) {
														
														rcpt[0]=r.getString(1);
														
														if(i==52) 
															continue;
														
														else if(i>52)
															rcpt[i-50]=r.getString(i);
														
														else
															rcpt[i-49]=r.getString(i);		
													}
													temp.add(rcpt);	
												}
											}
										}
									}
								}
							}	
							
						}
					
						}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
						break;
					
					
				case "001":	
					
					try {
						ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ \n"
												+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
												+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
												+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
												+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
												+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
												+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
												+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
												+ "AND EXAM.Module_type = PUR.Module_type)\n"
												+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
												+ "AND RCPT.Module_type = EXAM.MOdule_type) LEFT JOIN SUPPLIER AS SUP \n"
												+ "ON (sup.Supplier_ID=RFQ.Supplier_ID AND sup.Supplier_ID=QUOT.Supplier_ID) WHERE RFQ.Inquiring_product ="
												+text_inq_pd.getText());
						
						while(r.next()) {
							
							if(r.getString(1)!= null) {
								
								String [] rfq = new String[7];
								for(int i =1; i<8;i++) {

									rfq[i-1]=r.getString(i);		
								}
								rfq = lib.insert(rfq, r.getString(52), 5);
								temp.add(rfq);
								
								if(r.getString(8)!= null) {
									
									String [] quo = new String[10];
									for(int i =8; i<18;i++) {
										
										quo[i-8]=r.getString(i);		
									}
									quo = lib.insert(quo, r.getString(57), 5);
									temp.add(quo);
									
									if(r.getString(18)!= null) {
										String [] req = new String[11];
										for(int i =18; i<29;i++) {

											req[i-18]=r.getString(i);		
										}
										temp.add(req);
										
										if (r.getString(29)!= null) {
											
											String [] pur = new String[9];
											for(int i =29; i<38;i++) {
												
												pur[i-29]=r.getString(i);		
											}
											temp.add(pur);
											
											if(r.getString(38)!= null) {
												
												String [] exam = new String[7];
												for(int i =38; i<45;i++) {
													
													exam[i-38]=r.getString(i);		
												}
												temp.add(exam);
												
												if(r.getString(45)!= null) {
													
													String [] rcpt = new String[6];
													for(int i =45; i<51;i++) {
														
														rcpt[i-45]=r.getString(i);		
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
						
						}catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							break;
						}
				
				default:
					//sheet_ID be filled cases all are default
						
					int id = Integer.parseInt(text_inq_sheetID.getText());
						
					if (id>=21000000 & id< 22000000) {
							
						return inquire("RFQ",first,second,third);
							
					}else if(id>=22000000 & id< 23000000){
							
						return inquire("QUO",first,second,third);
							
					}else if(id>=23000000 & id< 24000000) {
							
						return inquire("REQ",first,second,third);
							
					}else if(id>=24000000 & id< 25000000) {
							
						return inquire("PUR",first,second,third);
							
					}else if(id>=25000000 & id< 26000000) {
							
						return inquire("EXAM",first,second,third);
							
					}else if(id>=26000000 & id< 27000000) {
							
						return inquire("RCPT",first,second,third);
							
					}

				}
//				for(int i=0; i<temp.size();i++) {
//					for(int j=0; j<temp.get(i).length;j++) {
//					System.out.print(temp.get(i)[j]+"\t");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				System.out.println();
//				System.out.println();
				
				String[][] result_array = new String[temp.size()][11];
				int i=0;
				for (String[] array_in_temp : temp) {
					result_array[i++] = array_in_temp;
				        }
				
//				for(int i2=0; i2<result_array.length;i2++) {
//					for(int j2=0; j2<result_array[i2].length;j2++) {
//					System.out.print(result_array[i2][j2]+"\t");
//					}
//					System.out.println();
//				}
				
				return result_array;
				
			}
	
	
	
	
	
	
	private String[][] inquire(String sheet_type, JTextField first, JTextField second, JTextField third){
			
			/**@author jyunanyang
			 * @since 05/06/2021
			 * 
			 */
			
			ArrayList<String[]> temp = new ArrayList();
			ResultSet r;
			switch(sheet_type) {
				
				case "RFQ":

					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																		+"rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																		+"LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE (RFQ_Sheet_ID="
																		+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()
																		+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
	
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																		+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																		+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE (RFQ_Sheet_ID="
																		+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");
	
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																	+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																	+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE (RFQ_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																		+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																		+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE RFQ_Sheet_ID="
																		+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																	+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE (Project_ID ="
																	+text_inq_projectID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																		+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																		+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE Project_ID ="
																		+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID, rfq.Inquiring_product, \n"
																+ "rfq.Supplier_ID, sup.Supplier_name, rfq.Vol, rfq.Date FROM RFQ AS rfq \n"
																+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE Inquiring_product=\'"
																+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] rfq = new String[8];
							
							for(int i=1;i<9;i++) 
								rfq[i-1]=r.getString(i);
							
							temp.add(rfq);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
					
				case "QUO":
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
																	+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
																	+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
																	+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE (QUO_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()
																	+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
																	+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
																	+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
																	+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE (QUO_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
																	+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
																	+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
																	+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE (QUO_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SSELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
																		+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
																		+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
																		+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE QUO_Sheet_ID="
																		+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
																	+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
																	+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
																	+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE (Project_ID ="
																	+text_inq_projectID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
																		+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
																		+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
																		+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE Project_ID ="
																		+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID, quo.Inquiring_product, \n"
															+ "quo.Supplier_ID, sup.Supplier_name, quo.Vol, quo.Unit_price, quo.Total_price,\n"
															+ "quo.ESD, quo.Date FROM QUOTATION AS quo \n"
															+ "LEFT JOIN SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID WHERE Inquiring_product=\'"
															+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] temp_array = new String[11];
							
							for(int i=1;i<12;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				
				case "REQ":
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
											+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
											+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
											+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE (REQ_Sheet_ID="
											+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()
											+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SSELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
											+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
											+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
											+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE (REQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
											+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
											+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
											+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE (REQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
										+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
										+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
										+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE REQ_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SSELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
										+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
										+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
										+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE (Project_ID ="
												+text_inq_projectID.getText()
												+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
										+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
										+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
										+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE Project_ID ="
															+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, \n"
										+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID, emp.Last_name,\n"
										+ "req.Date FROM REQUISITION AS req LEFT JOIN PROJECT AS pj ON pj.Project_ID=req.Project_ID \n"
										+ "LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID WHERE Inquiring_product=\'"
															+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] temp_array = new String[12];
							
							for(int i=1;i<13;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case "PUR":
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE (PUR_Sheet_ID="
											+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()
											+" AND Module_type =\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE (PUR_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE (PUR_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Module_type =\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE PUR_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE (Project_ID ="
												+text_inq_projectID.getText()
												+" AND Module_type =\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE Project_ID ="
															+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE Module_type =\'"
															+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] temp_array = new String[9];
							
							for(int i=1;i<10;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case "EXAM":
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE (EX_Sheet_ID="
											+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()
											+" AND Module_type =\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE (EX_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE (EX_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Module_type =\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE EX_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE (Project_ID ="
												+text_inq_projectID.getText()
												+" AND Module_type =\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE Project_ID ="
															+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE Module_type =\'"
															+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] temp_array = new String[7];
							
							for(int i=1;i<8;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				
				default:
				//case "RCPT":
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE (REC_Sheet_ID="
											+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()
											+" AND Module_type =\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE (REC_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE (REC_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Module_type =\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE REC_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE (Project_ID ="
												+text_inq_projectID.getText()
												+" AND Module_type =\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE Project_ID ="
															+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE Module_type =\'"
															+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] temp_array = new String[6];
							
							for(int i=1;i<7;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
			}
			
			
			
			String[][] result_array = new String[temp.size()][11];
			int i=0;
			for (String[] array_in_temp : temp) {
				result_array[i++] = array_in_temp;
			        }
			return result_array;
		}
	
	
	
	
	
	private String[][] show_unsign_req() {
		
		ArrayList <String[]> temp = new ArrayList();
	
		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID,req.Inquiring_product, "
															+ "req.Item_name, req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID,"
															+ " emp.Last_name, req.Date FROM REQUISITION AS req LEFT JOIN EMPLOYEE AS emp "
															+ "ON req.Supervisor_ID = emp.Emp_ID WHERE (Signature='False' AND req.Supervisor_ID="
															+Term_project_main.field_empID.getText()+")");
			
			while(r.next()) {
				
				String[] temp_array = new String[12];
				
				for(int i=1;i<13;i++) {
					
					temp_array[i-1]=r.getString(i);
				}temp.add(temp_array);
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
	
	
	
	
	
	private int sign_all() {
		
		int r=0;
		try {
			r = Term_project_main.conn.st.executeUpdate("UPDATE REQUISITION SET Signature=\'True\' WHERE Supervisor_ID="
																			+Term_project_main.field_empID.getText());
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r;
		}
		
	}
	
	
	
	
	private int modify() {
		
		/**@author jyunanyang
		 * @since 06/06/2021
		 * 
		 */
		
		int id = Integer.parseInt(lbl_mod_sheetID_show.getText());
		
		int r=0;
		if (id>=21000000 & id< 22000000) {
			
			try {	
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE RFQ SET Supplier_ID=\'"+text_mod_4.getText()+"\', Vol="+text_mod_5.getText()
				 										+", Date=\'"+text_mod_6.getText()+"\' WHERE (RFQ_Sheet_ID="+lbl_mod_sheetID_show.getText()+
				 										" AND Project_ID="+lbl_mod_projectID_show.getText()+" AND Inquiring_product=\'"
				 										+lbl_mod_pd_show.getText()+"\')");
				 return r;
				 
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return r;
				}
			
		}else if(id>=22000000 & id< 23000000){
				
			try {	
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE QUOTATION SET Supplier_ID=\'"+text_mod_4.getText()+"\', Vol="+text_mod_5.getText()
				 											+", Unit_price="+text_mod_6.getText()+", ESD=\'"+text_mod_7.getText()+"\', Date=\'"
				 											+text_mod_8.getText()+ "\' WHERE (QUO_Sheet_ID="+lbl_mod_sheetID_show.getText()
				 											+" AND Project_ID="+lbl_mod_projectID_show.getText()+" AND Inquiring_product=\'"
				 											+lbl_mod_pd_show.getText()+"\')");
				 return r;
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return r;
				}
			
				
		}else if(id>=23000000 & id< 24000000) {
			
			try {	
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE REQUISITION SET Item_name=\'"+ text_mod_4.getText()+"\', Vol="
						 								+text_mod_5.getText()+", Unit_price="+text_mod_6.getText()+", Supervisor_ID=\'"
						 								+text_mod_7.getText()+"\', Date=\'"+text_mod_8.getText()+"\' WHERE (REQ_Sheet_ID="
						 								+lbl_mod_sheetID_show.getText()+" AND Project_ID="+lbl_mod_projectID_show.getText()
						 								+" AND Inquiring_product=\'"+lbl_mod_pd_show.getText()+"\')");
				 return r;
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
			
				
			
				
		}else if(id>=24000000 & id< 25000000) {
				
			try {	
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE PURCHASE SET Vol="+text_mod_4.getText()+", Unit_price="+text_mod_5.getText()+", ESD=\'"
															+text_mod_6.getText()+"\', Date=\'"+text_mod_7.getText()+"\' WHERE (PUR_Sheet_ID="
															+lbl_mod_sheetID_show.getText()+" AND Project_ID="+lbl_mod_projectID_show.getText()
															+" AND Module_type=\'"+lbl_mod_pd_show.getText()+"\')");			 
				 return r;

				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return r;
				}
				
		}else if(id>=25000000 & id< 26000000) {
				
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("UPDATE EXAMINATION SET Vol="+text_mod_4.getText()+", Date=\'"+text_mod_5.getText()
															+"\' WHERE (EX_Sheet_ID="+lbl_mod_sheetID_show.getText()+" AND Project_ID="
															+lbl_mod_projectID_show.getText()+" AND Module_type=\'"+lbl_mod_pd_show.getText()+"\')");

				return r;
			
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return r;
				}
				
		}else  {
				
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("UPDATE RECEIPT SET Vol="+text_mod_4.getText()+", Date=\'"+text_mod_5.getText()
														+"\' WHERE (REC_Sheet_ID="+lbl_mod_sheetID_show.getText()+" AND Project_ID="
														+lbl_mod_projectID_show.getText()+" AND Module_type=\'"+lbl_mod_pd_show.getText()+"\')");
				
				
				return r;
			
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return r;
			}
				
		}
	}
	
	
	

	
	private int delete() {
		
		/*
		 * *@author jyunanyang
		 * @since 06/06/2021
		 * 
		 */
	
		int id = Integer.parseInt(lbl_remove_sheetID_show.getText());
		int r=0;
		
		if (id>=21000000 & id< 22000000) {
			//RFQ
			try {	
				
				 r = Term_project_main.conn.st.executeUpdate("DELETE FROM RFQ WHERE (RFQ_Sheet_ID="+lbl_remove_sheetID_show.getText()+
																" AND Project_ID="+lbl_remove_projectID_show.getText()+" AND Inquiring_product=\'"
																+lbl_remove_pd_show.getText()+"\')");
				
				
				return r;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
			
			
			
		}else if(id>=22000000 & id< 23000000){
				//QUOT
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM QUOTATION WHERE (QUO_Sheet_ID="+lbl_remove_sheetID_show.getText()+
																" AND Project_ID="+lbl_remove_projectID_show.getText()+" AND Inquiring_product=\'"
																+lbl_remove_pd_show.getText()+"\')");
				
				return r;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
			
				
		}else if(id>=23000000 & id< 24000000) {
			//REQ
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM REQUISITION WHERE (REQ_Sheet_ID="+lbl_remove_sheetID_show.getText()+
																		" AND Project_ID="+lbl_remove_projectID_show.getText()+" AND Inquiring_product=\'"
																		+lbl_remove_pd_show.getText()+"\')");
				
				
				return r;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
			
				
			
				
		}else if(id>=24000000 & id< 25000000) {
				//PUR
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM PURCHASE WHERE (PUR_Sheet_ID="+lbl_remove_sheetID_show.getText()+
																		" AND Project_ID="+lbl_remove_projectID_show.getText()+" AND Module_type=\'"
																			+lbl_remove_pd_show.getText()+"\')");
										
				
				return r;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
				
		}else if(id>=25000000 & id< 26000000) {
				//EXAM
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM EXAMINATION WHERE (EX_Sheet_ID="+lbl_remove_sheetID_show.getText()+
																		" AND Project_ID="+lbl_remove_projectID_show.getText()+" AND Module_type=\'"
																		+lbl_remove_pd_show.getText()+"\')");
				
				
				return r;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
				
		}else if(id>=26000000 & id< 27000000) {
				//RCPT
			try {	
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM RECEIPT WHERE (REC_Sheet_ID="+lbl_remove_sheetID_show.getText()+
																		" AND Project_ID="+lbl_remove_projectID_show.getText()+" AND Module_type=\'"
																		+lbl_remove_pd_show.getText()+"\')");
				
				return r;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
		
		}else
			return r;
	}
	
	
	

	
	private boolean append_check(String st) {
		
		/**@author jyunanyang
		 * @since 06/06/2021
		 * 
		 */
		
		boolean result=false;
		
		String [] temp = new String[7];
	
		
		try {
			
			ResultSet r =Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID,RFQ.RFQ_Sheet_ID, QUOT.QUO_Sheet_ID, REQ.REQ_Sheet_ID, \n"
															+ "PUR.PUR_Sheet_ID, EXAM.EX_Sheet_ID,RCPT.REC_Sheet_ID \n"
															+ "FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
															+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
															+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
															+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
															+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
															+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
															+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
															+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
															+ "AND EXAM.Module_type = PUR.Module_type)\n"
															+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
															+ "AND RCPT.Module_type = EXAM.MOdule_type) WHERE pj.Project_ID ="
															+text_appd_1.getText()+" LIMIT 1");
			
			if(r.next()) {
				
				for(int i=1;i<8;i++) {
					temp[i-1]=r.getString(i);
				}	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch(st) {
		
			case "RFQ":
				
				if (temp[0]!=null) {
					
					result = true;
				}
				break;
				
			case "QUOT":
				
				if (temp[1]!=null) {
					
					result = true;
				}
				break;
			
			case "REQ":
				
				if (temp[2]!=null) {
					
					result = true;
				}
				break;
			
			case "PUR":
				
				if (temp[3]!=null) {
					
					result = true;
				}
				break;
			
			case "EXAM":
				
				if (temp[4]!=null) {
					
					result = true;
				}
				break;
				
			default:
				//case "RCPT"
				if (temp[5]!=null) {
					
					result = true;
				}
				break;
		}
		
		return result;
		
	}
	
	
	
	
	private String[][] append(String st) {
		
		/**@author jyunanyang
		 * @since 06/06/2021
		 */
		ArrayList<String> temp = new ArrayList();
		int resultSet=0;
		
		switch(st) {
		
			case "RFQ":
				if(!text_appd_5.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO RFQ (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol, Date) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+
																	text_appd_3.getText()+"\', "+ text_appd_4.getText()+", \'"+text_appd_5.getText()+"\')");
		
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ ORDER BY RFQ_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<8;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					//text_appd_5.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO RFQ (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+
																	text_appd_3.getText()+"\', "+ text_appd_4.getText()+")");
		
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ ORDER BY RFQ_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<8;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
				break;
				
			case "QUOT":
				if(!text_appd_7.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO QUOTATION (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol, Unit_price, ESD, Date) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()
																	+"\', \'"+text_appd_3.getText()+"\', "+ text_appd_4.getText()+", "+text_appd_5.getText()
																	+", \'"+text_appd_6.getText()+"\', \'"+text_appd_7.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<11;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					//text_appd_7.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO QUOTATION (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol, Unit_price, ESD) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()
																	+"\', \'"+text_appd_3.getText()+"\', "+ text_appd_4.getText()+", "+text_appd_5.getText()
																	+", \'"+text_appd_6.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<11;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
				
			case "REQ":
				if(!text_appd_7.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO REQUISITION (Project_ID, Inquiring_product, Item_name, "
																	+ "Vol, Unit_price, Supervisor_ID, Date) VALUE ("+ text_appd_1.getText()+", \'"															
																	+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+"\', "+ text_appd_4.getText()+", "
																	+text_appd_5.getText()+", "+text_appd_6.getText()+", \'"+text_appd_7.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION ORDER BY REQ_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<12;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					//text_appd_7.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO REQUISITION (Project_ID, Inquiring_product, Item_name, "
																	+ "Vol, Unit_price, Supervisor_ID) VALUE ("+ text_appd_1.getText()+", \'"															
																	+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+"\', "+ text_appd_4.getText()+", "
																	+text_appd_5.getText()+", "+text_appd_6.getText()+")");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION ORDER BY REQ_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<12;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;
				
				
			case "PUR":
				if(!text_appd_6.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO PURCHASE (Project_ID, Module_type, Vol, Unit_price, ESD, Date) VALUE ("
																	+ text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', "+text_appd_3.getText()+", "
																	+text_appd_4.getText()+", \'"+text_appd_5.getText()+"\', \'"+text_appd_6.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<10;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					//text_appd_6.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO PURCHASE (Project_ID, Module_type, Vol, Unit_price, ESD) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', "+text_appd_3.getText()+", "
																	+text_appd_4.getText()+", \'"+text_appd_5.getText()+"\')");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<10;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;	
				
			case "EXAM":
				if(!text_appd_5.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO EXAMINATION (Project_ID, Module_type, Vol, Result, Date) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', "+text_appd_3.getText()+
																	", \'"+ text_appd_4.getText()+"\', \'"+text_appd_5.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION ORDER BY EX_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<8;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					//text_appd_5.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO EXAMINATION (Project_ID, Module_type, Vol, Result) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', "+text_appd_3.getText()+
																	", \'"+ text_appd_4.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION ORDER BY EX_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<8;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;	
				
			default:
				if(!text_appd_4.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO RECIPT (Project_ID, Module_type, Vol, Date) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', "+text_appd_3.getText()
																	+", \'"+ text_appd_4.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT ORDER BY REC_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<7;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					//text_appd_4.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO RECIPT (Project_ID, Module_type, Vol) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', "+text_appd_3.getText()+")");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT ORDER BY REC_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<7;i++) {
									temp.add(r.getString(i));
								}
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				break;	
				
		}
		String[][] result_array = new String[1][temp.size()];
		
		int i=0;
		for (String k : temp) {
			result_array[0][i++] = k;
		        }
		return result_array;
	
	}
	
	
	
	
	private ArrayList<String> check(JTextField text1, JTextField text2, JTextField text3) {
		
		
		/**@author jyunanyang
		 * @since 05/06/2021
		 */
		
		ArrayList<String> temp = new ArrayList();
		
		int id = Integer.parseInt(text1.getText());
		
		if (id>=21000000 & id< 22000000) {
			//RFQ
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE (RFQ_Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Inquiring_product=\'"+text3.getText()
												+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<8;i++) {
	
							temp.add(r.getString(i));	
					}
				}
				return temp;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
			
			
			
		}else if(id>=22000000 & id< 23000000){
				//QUOT
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE (QUO_Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Inquiring_product=\'"+text3.getText()
												+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<11;i++)
					
						temp.add(r.getString(i));	
				}
				return temp;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
			
				
		}else if(id>=23000000 & id< 24000000) {
			//REQ
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE (REQ_Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Inquiring_product=\'"+text3.getText()
												+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<12;i++) {
						
						temp.add(r.getString(i));	
					}
				}
				return temp;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
			
				
			
				
		}else if(id>=24000000 & id< 25000000) {
				//PUR
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE (PUR_Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module_type=\'"+text3.getText()
												+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<10;i++) {
						
						temp.add(r.getString(i));	
					}
				}
				return temp;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
				
		}else if(id>=25000000 & id< 26000000) {
				//EXAM
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE (EX_Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module_type=\'"+text3.getText()
												+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<8;i++) {
						
						temp.add(r.getString(i));	
					}
				}
				return temp;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
				
		}else if(id>=26000000 & id< 27000000) {
				//RCPT
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE (REC_Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module_type=\'"+text3.getText()
												+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<7;i++) {
		
						temp.add(r.getString(i));	
					}
				}
				return temp;
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
				
		}else {
			
			return temp;
		}
		
	}
	
	public JComboBox get_comboBox_sheets() {
					
		return comboBox_sheets;
	}
}
