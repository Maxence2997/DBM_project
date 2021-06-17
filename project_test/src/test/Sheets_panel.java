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
	private JButton btn_inq_clear;
	
	
	private JPanel mod_panel;
	private JLabel lbl_mod_sheetID;
	private JTextField text_mod_sheetID;
	private JButton btn_mod_modify;
	private JLabel lbl_mod_projectID;
	private JTextField text_mod_projectID;
	private JLabel lbl_mod_pd;
	private JTextField text_mod_pd;
	private JLabel lbl_mod_supID;
	private JTextField text_mod_supID;
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
	private JLabel lbl_mod_supID_show;
	
	
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
	private JButton btn_append_clear;


	
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
	private JLabel lbl_remove_supID_show;
	
	private JPanel sign_panel;
	private JLabel lbl_sign_sorry;
	private JLabel lbl_sign_instr;
	private JButton btn_sign_sign;
	private JButton btn_sign_refresh;
	private JScrollPane scrollpane_sign;
	private JLabel lbl_remove_ins;
	private JLabel lbl_appd_ins;
	private JTextField text_remove_supID;
	
	public Sheets_panel() {
		
		lib = new Library();
		
		panels();
		
		
	}
	
	private void panels() {
				
		//core sheet panel which contains comboBox
		core_sheet_panel = new JPanel();
		core_sheet_panel.setBounds(0,26,1000,450);
		Term_project_main.container_panel.add(core_sheet_panel,"sheets");
		core_sheet_panel.setLayout(null);
				
		//smaller panel on the core sheet panel
		cl_sheet = new CardLayout();
		sheet_container_panel = new JPanel(cl_sheet);
		sheet_container_panel.setBounds(0, 36, 1000, 380);
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
		comboBox_sheets.setBounds(423, 6, 120, 27);			
		comboBox_sheets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			            	
				String function = (String) comboBox_sheets.getSelectedItem(); //get the selected item
				
				if (function.equalsIgnoreCase("signature")){
					if(lib.supervisor_check(Term_project_main.field_empID)) {
						
						String[][] temp = lib.show_unsign_req();
						
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
				}else if(function.equalsIgnoreCase("Inquire")) {
			            			
					clear_inq_panel();
					inq_table.setVisible(false);
					scrollpane_inq.setVisible(false);   
					btn_inq_clear.setVisible(false);
			            		
				}else if(function.equalsIgnoreCase("Modify")) {
			            			
					clear_mod_panel();
					btn_mod_check.setVisible(true);
					btn_mod_clear.setVisible(false);
					btn_mod_modify.setVisible(false);
					
					text_mod_sheetID.setVisible(true);
					text_mod_projectID.setVisible(true);
					text_mod_pd.setVisible(true);
					text_mod_supID.setVisible(true);
					lbl_mod_sheetID_show.setVisible(false);
					lbl_mod_projectID_show.setVisible(false);
					lbl_mod_pd_show.setVisible(false);
					lbl_mod_supID_show.setVisible(false);
			            		
					lbl_mod_5.setVisible(false);
					text_mod_5.setVisible(false);
			            		
					lbl_mod_6.setVisible(false);
					text_mod_6.setVisible(false);
			            		
					lbl_mod_7.setVisible(false);
					text_mod_7.setVisible(false);
			            		
					lbl_mod_8.setVisible(false);
					text_mod_8.setVisible(false);
			            		
					lbl_mod_message.setVisible(false);
			            		
				}else if(function.equalsIgnoreCase("Append")) {
			            		
					clear_app_panel();
			            		
			            		
					append_table.setVisible(false);
					scrollpane_append.setVisible(false);
					btn_append_clear.setVisible(false);
					lbl_appd_ins.setVisible(true);
				}else if(function.equalsIgnoreCase("Delete")) {
					clear_remove_panel();
					scrollpane_remove.setVisible(false);
					remove_table.setVisible(false);
					lbl_remove_confirm.setVisible(false);
					text_remove_confirm.setVisible(false);
					btn_remove_confirm.setVisible(false);
					text_remove_sheetID.setVisible(true);
					lbl_remove_sheetID_show.setVisible(false);
					text_remove_projectID.setVisible(true);
					lbl_remove_projectID_show.setVisible(false);
					text_remove_pd.setVisible(true);
					lbl_remove_pd_show.setVisible(false);
					
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
				
		btn_inq_clear = new JButton("Clear");
		btn_inq_clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						clear_inq_panel();
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
										
										String[] columns_name = {"Sheet ID", "Type", "Column 3", "Project ID", "Column 5", "Column 6", "Column 7", "Column 8",
												"Column 9", "Column 10", "Column 11", "Column 12"};
										
										DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
										inq_table.setModel(inq_table_model);
										inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
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
										
										String[] columns_name = {"Sheet ID", "Type", "Project ID", "Supplier ID","Name", "Inquiring Product", 
												 "Vol.", "Date"};
										DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
										inq_table.setModel(inq_table_model);
										inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
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
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Supplier ID", "Name", "Inquiring Product", "Vol.",
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
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Inquiring Product", "Item", "Vol.",
											"Unit Price", "Total Price", "Signature", "Supervisor ID","Name", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
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
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Supplier_ID", "Name", "Module", "Vol.",
											"Unit Price", "Total Price", "ESD", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
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
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Supplier_ID", 
														"Name", "Module", "Vol.", "Result", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
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
									
									String[] columns_name = {"Sheet ID", "Type", "Project ID", "Supplier_ID", "Name", "Module", "Vol.", "Date"};
									
									DefaultTableModel inq_table_model = new DefaultTableModel(temp,columns_name);
									inq_table.setModel(inq_table_model);
									inq_table.getColumnModel().getColumn(1).setPreferredWidth(40);
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
						
				
		inq_table = new JTable(){ 
					@Override
					public boolean isCellEditable(int row, int column)
		            {
		                                  return false;}//uneditable
		            
					}; 
		inq_table.setBounds(29, 194, 1000, 130);
		inq_table.setVisible(false);

		scrollpane_inq = new JScrollPane(inq_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_inq.setBounds(22,220,950,135);
				
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
			        	
			        }
			    });
				
		bg.add(rb_inq_rec);
				
		JLabel lbl_sheet_type = new JLabel("Sheets type :");
		lbl_sheet_type.setBounds(110, 32, 87, 16);
		inq_panel.add(lbl_sheet_type);
								
	}
	
	
			
			//Second panel - Modify sheet
	private void add_modify_panel() {

		mod_panel = new JPanel();
		sheet_container_panel.add(mod_panel,"Modify");
		mod_panel.setBounds(0, 0, 662, 367);
		mod_panel.setLayout(null);
		
		lbl_mod_note = new JLabel("* neccessary");
		lbl_mod_note.setBounds(184, 52, 123, 16);
		lbl_mod_note.setVisible(true);
		mod_panel.add(lbl_mod_note);
				
		lbl_mod_sheetID = new JLabel("*Sheet ID :");
		lbl_mod_sheetID.setBounds(336, 52, 67, 16);
		lbl_mod_sheetID.setVisible(true);
		mod_panel.add(lbl_mod_sheetID);
				
		text_mod_sheetID = new JTextField();
		text_mod_sheetID.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_sheetID.setBounds(415, 47, 115, 26);
		mod_panel.add(text_mod_sheetID);
		text_mod_sheetID.setColumns(10);
				
		lbl_mod_sheetID_show = new JLabel("");
		lbl_mod_sheetID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_sheetID_show.setBounds(415, 52, 115, 16);
		lbl_mod_sheetID_show.setVisible(false);
		mod_panel.add(lbl_mod_sheetID_show);
		
		lbl_mod_projectID = new JLabel("*Project ID :");
		lbl_mod_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_projectID.setVisible(true);
		lbl_mod_projectID.setBounds(307, 90, 96, 16);
		mod_panel.add(lbl_mod_projectID);
				
		text_mod_projectID = new JTextField();
		text_mod_projectID.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_projectID.setBounds(415, 85, 115, 26);
		mod_panel.add(text_mod_projectID);
		text_mod_projectID.setColumns(10);

		lbl_mod_projectID_show = new JLabel("");
		lbl_mod_projectID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_projectID_show.setBounds(415, 90, 115, 16);
		lbl_mod_projectID_show.setVisible(false);
		mod_panel.add(lbl_mod_projectID_show);
						
		lbl_mod_pd = new JLabel("*Product :");
		lbl_mod_pd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_pd.setVisible(true);
		lbl_mod_pd.setBounds(297, 128, 106, 16);
		mod_panel.add(lbl_mod_pd);
				
		text_mod_pd = new JTextField();
		text_mod_pd.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_pd.setBounds(415, 123, 115, 26);
		mod_panel.add(text_mod_pd);
		text_mod_pd.setColumns(10);
				
		lbl_mod_pd_show = new JLabel("");
		lbl_mod_pd_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_pd_show.setBounds(415, 128, 115, 16);
		lbl_mod_pd_show.setVisible(false);
		mod_panel.add(lbl_mod_pd_show);
				
		lbl_mod_supID = new JLabel("Supplier ID :");
		lbl_mod_supID.setBounds(307, 163, 96, 16);
		lbl_mod_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_supID.setVisible(true);
		mod_panel.add(lbl_mod_supID);
				
		text_mod_supID = new JTextField();
		text_mod_supID.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_supID.setBounds(415, 161, 115, 26);
		text_mod_supID.setVisible(true);
		mod_panel.add(text_mod_supID);
		text_mod_supID.setColumns(10);
				
		lbl_mod_5 = new JLabel("");
		lbl_mod_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_5.setBounds(297, 202, 106, 16);
		lbl_mod_5.setVisible(false);
		mod_panel.add(lbl_mod_5);
				
		text_mod_5 = new JTextField();
		text_mod_5.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_5.setBounds(415, 197, 115, 26);
		text_mod_5.setVisible(false);
		mod_panel.add(text_mod_5);
		text_mod_5.setColumns(10);
		
		lbl_mod_6 = new JLabel("");
		lbl_mod_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_6.setBounds(297, 244, 106, 16);
		lbl_mod_6.setVisible(false);
		mod_panel.add(lbl_mod_6);
		
		text_mod_6 = new JTextField();
		text_mod_6.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_6.setBounds(415, 239, 115, 26);
		text_mod_6.setVisible(false);
		mod_panel.add(text_mod_6);
		text_mod_6.setColumns(10);
		
		lbl_mod_7 = new JLabel("");
		lbl_mod_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_7.setBounds(297, 287, 106, 16);
		lbl_mod_7.setVisible(false);
		mod_panel.add(lbl_mod_7);
		
		text_mod_7 = new JTextField();
		text_mod_7.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_7.setBounds(415, 277, 115, 26);
		text_mod_7.setVisible(false);
		mod_panel.add(text_mod_7);
		text_mod_7.setColumns(10);
		
		lbl_mod_message = new JLabel("");
		lbl_mod_message.setBounds(542, 128, 431, 73);
		lbl_mod_message.setVisible(false);
		mod_panel.add(lbl_mod_message);
		
		text_mod_8 = new JTextField();
		text_mod_8.setHorizontalAlignment(SwingConstants.CENTER);
		text_mod_8.setBounds(415, 315, 115, 26);
		text_mod_8.setVisible(false);
		mod_panel.add(text_mod_8);
		text_mod_8.setColumns(10);
			
		lbl_mod_8 = new JLabel("");
		lbl_mod_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_mod_8.setBounds(297, 320, 100, 16);
		lbl_mod_8.setVisible(false);
		mod_panel.add(lbl_mod_8);
		
		lbl_mod_supID_show = new JLabel("");
		lbl_mod_supID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_mod_supID_show.setBounds(415, 166, 115, 16);
		mod_panel.add(lbl_mod_supID_show);
		
		btn_mod_modify = new JButton("Modify");
		btn_mod_modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//verify format
				int id = Integer.parseInt(lbl_mod_sheetID_show.getText());
				
				if (id>=21000000 & id< 22000000) {
					//RFQ
					if (lib.num_not_null_check(text_mod_5)&lib.date(text_mod_6.getText())) {
						
						if (modify()==1) 
							lbl_mod_message.setText("modification succeed");
						else 
							lbl_mod_message.setText("modification failed");
					}else{
//										System.out.print(lib.supplier_check(text_mod_supID));
//										System.out.print(lib.num_not_null_check(text_mod_5));
//										System.out.print(lib.date(text_mod_6.getText()));
						lbl_mod_message.setText("format Invalid");
						lbl_mod_message.setVisible(true);
						}
					
				}else if (id>=22000000 & id< 23000000) {
					//QUOT
					if (lib.num_not_null_check(text_mod_5)&lib.num_not_null_check(text_mod_6)
							&lib.date(text_mod_7.getText())&lib.date(text_mod_8.getText())) {
						
						if (modify()==1) 
							lbl_mod_message.setText("Modification succeed");
						else 
							lbl_mod_message.setText("Modification failed");
					}else{
						lbl_mod_message.setText("Format Invalid");
						lbl_mod_message.setVisible(true);
					}
				}else if (id>=23000000 & id< 24000000) {
					//REQ
					if (lib.num_not_null_check(text_mod_5)&lib.num_not_null_check(text_mod_6)
							&lib.supervisor_check(text_mod_7)&lib.date(text_mod_8.getText())) {
						
						if (modify()==1)
							lbl_mod_message.setText("Modification succeed");
						else 
							lbl_mod_message.setText("Modification failed");
								}else{
								lbl_mod_message.setText("Format Invalid");
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
					if (lib.num_not_null_check(text_mod_5)&lib.date(text_mod_6.getText())){
											
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
					if (lib.num_not_null_check(text_mod_5)&lib.date(text_mod_6.getText())){
										
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
		btn_mod_modify.setBounds(682, 46, 87, 29);
		mod_panel.add(btn_mod_modify);
		
		btn_mod_check = new JButton("Check");
		btn_mod_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				if(!lib.num_not_null_check(text_mod_sheetID)|!lib.num_not_null_check(text_mod_projectID)|text_mod_pd.getText().isBlank()) {
					//None of them can't be blank 
					
					lbl_mod_message.setText("Format Invalid");
					lbl_mod_message.setVisible(true);
					
					btn_mod_check.setVisible(true);
					btn_mod_clear.setVisible(true);
					btn_mod_modify.setVisible(false);
					
					lbl_mod_sheetID_show.setVisible(false);
					lbl_mod_projectID_show.setVisible(false);
					lbl_mod_pd_show.setVisible(false);
					lbl_mod_supID_show.setVisible(false);
					
					
					lbl_mod_5.setVisible(false);
					text_mod_5.setVisible(false);
					
					lbl_mod_6.setVisible(false);
					text_mod_6.setVisible(false);
		            		
					lbl_mod_7.setVisible(false);
					text_mod_7.setVisible(false);
					
					lbl_mod_8.setVisible(false);
					text_mod_8.setVisible(false);
					
					
				}else {
					//each of them is filled
						
					int what = Integer.parseInt(text_mod_sheetID.getText());
							
					if(what>=23000000 & what< 24000000){
						if(text_mod_supID.getText().isBlank()){
							//REQ
								
							ArrayList<String> temp = rmv_mod_check(text_mod_sheetID, text_mod_projectID, text_mod_pd, text_mod_supID);
							
							if (temp.size()!=0) {
								
								btn_mod_clear.setVisible(true);
								
								lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
								text_mod_sheetID.setVisible(false);
								lbl_mod_sheetID_show.setVisible(true);
								
								lbl_mod_projectID_show.setText(text_mod_projectID.getText());
								text_mod_projectID.setVisible(false);
								lbl_mod_projectID_show.setVisible(true);
								
								lbl_mod_pd_show.setText(text_mod_pd.getText());
								text_mod_pd.setVisible(false);
								lbl_mod_pd_show.setVisible(true);
								
								lbl_mod_supID_show.setText(text_mod_supID.getText());
								lbl_mod_supID.setVisible(true);
								text_mod_supID.setVisible(false);
									
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
								text_mod_8.setText(temp.get(11));
								lbl_mod_8.setVisible(true);
								text_mod_8.setVisible(true);
								
								btn_mod_modify.setVisible(true);
								lbl_mod_message.setText("Data loaded");
								lbl_mod_message.setVisible(true);
								
							}else{
								//no found
									
								btn_mod_check.setVisible(true);
								btn_mod_clear.setVisible(true);
								btn_mod_modify.setVisible(false);
						            		
								lbl_mod_sheetID_show.setVisible(false);
								lbl_mod_projectID_show.setVisible(false);
								lbl_mod_pd_show.setVisible(false);
								lbl_mod_supID_show.setVisible(false);
								
								
								lbl_mod_5.setVisible(false);
								text_mod_5.setVisible(false);
								
								lbl_mod_6.setVisible(false);
								text_mod_6.setVisible(false);
								
								lbl_mod_7.setVisible(false);
								text_mod_7.setVisible(false);
								
								lbl_mod_8.setVisible(false);
								text_mod_8.setVisible(false);
												
								btn_mod_modify.setVisible(false);
								lbl_mod_message.setText("Please check data again");
								lbl_mod_message.setVisible(true);	
							}
							
						}else {
										
							btn_mod_check.setVisible(true);
							btn_mod_clear.setVisible(true);
							btn_mod_modify.setVisible(false);
							
							lbl_mod_sheetID_show.setVisible(false);
							lbl_mod_projectID_show.setVisible(false);
							lbl_mod_pd_show.setVisible(false);
							lbl_mod_supID_show.setVisible(false);
							
					            		
							lbl_mod_5.setVisible(false);
							text_mod_5.setVisible(false);
							
							lbl_mod_6.setVisible(false);
							text_mod_6.setVisible(false);
					            		
							lbl_mod_7.setVisible(false);
							text_mod_7.setVisible(false);
					            		
							lbl_mod_8.setVisible(false);
							text_mod_8.setVisible(false);
											
							btn_mod_modify.setVisible(false);
							lbl_mod_message.setText("If you wanna check REQ sheet, you couldn't fill Supplier_ID textField.");
							lbl_mod_message.setVisible(true);	
						}
					}else {
						// except for REQ sheets
									
						if (text_mod_supID.getText().isBlank()) {
										
							btn_mod_check.setVisible(true);
							btn_mod_clear.setVisible(true);
							btn_mod_modify.setVisible(false);

							lbl_mod_sheetID_show.setVisible(false);
							lbl_mod_projectID_show.setVisible(false);
							lbl_mod_pd_show.setVisible(false);
							lbl_mod_supID_show.setVisible(false);

							lbl_mod_5.setVisible(false);
							text_mod_5.setVisible(false);
					            		
							lbl_mod_6.setVisible(false);
							text_mod_6.setVisible(false);

							lbl_mod_7.setVisible(false);
							text_mod_7.setVisible(false);

							lbl_mod_8.setVisible(false);
							text_mod_8.setVisible(false);

							btn_mod_modify.setVisible(false);
							lbl_mod_message.setText("Except for REQUISITION sheet, Please fill all the textField.");
							lbl_mod_message.setVisible(true);

						} else {

							ArrayList<String> temp = rmv_mod_check(text_mod_sheetID, text_mod_projectID, text_mod_pd,
									text_mod_supID);

							if (temp.size() != 0) {

								btn_mod_clear.setVisible(true);

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

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Date :");
									text_mod_6.setText(temp.get(7));
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

								} else if (temp.get(1).equalsIgnoreCase("QUO")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Unit Price :");
									text_mod_6.setText(temp.get(7));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("ESD :");
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

								} else if (temp.get(1).equalsIgnoreCase("PUR")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Unit Price :");
									text_mod_6.setText(temp.get(7));
									lbl_mod_6.setVisible(true);
									text_mod_6.setVisible(true);

									lbl_mod_7.setText("ESD :");
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

								} else if (temp.get(1).equalsIgnoreCase("EXAM")) {

									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Date");
									text_mod_6.setText(temp.get(8));
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

								} else {
									// if (temp.get(1).equalsIgnoreCase("RCPT"))
									lbl_mod_sheetID_show.setText(text_mod_sheetID.getText());
									text_mod_sheetID.setVisible(false);
									lbl_mod_sheetID_show.setVisible(true);

									lbl_mod_projectID_show.setText(text_mod_projectID.getText());
									text_mod_projectID.setVisible(false);
									lbl_mod_projectID_show.setVisible(true);

									lbl_mod_pd_show.setText(text_mod_pd.getText());
									text_mod_pd.setVisible(false);
									lbl_mod_pd_show.setVisible(true);

									lbl_mod_supID_show.setText(text_mod_supID.getText());
									lbl_mod_supID_show.setVisible(true);
									text_mod_supID.setVisible(false);

									lbl_mod_5.setText("Vol. :");
									text_mod_5.setText(temp.get(6));
									lbl_mod_5.setVisible(true);
									text_mod_5.setVisible(true);

									lbl_mod_6.setText("Date :");
									text_mod_6.setText(temp.get(7));
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

								}
							} else {
								btn_mod_check.setVisible(true);
								btn_mod_clear.setVisible(true);
								btn_mod_modify.setVisible(false);

								lbl_mod_sheetID_show.setVisible(false);
								lbl_mod_projectID_show.setVisible(false);
								lbl_mod_pd_show.setVisible(false);
								lbl_mod_supID_show.setVisible(false);

								lbl_mod_5.setVisible(false);
								text_mod_5.setVisible(false);

								lbl_mod_6.setVisible(false);
								text_mod_6.setVisible(false);

								lbl_mod_7.setVisible(false);
								text_mod_7.setVisible(false);

								lbl_mod_8.setVisible(false);
								text_mod_8.setVisible(false);

								btn_mod_modify.setVisible(false);
								lbl_mod_message.setText("Please check data again");
								lbl_mod_message.setVisible(true);
							}
						}
					}
				}
			}
		});
		btn_mod_check.setBounds(532, 47, 83, 29);
		mod_panel.add(btn_mod_check);

		btn_mod_clear = new JButton("Clear");
		btn_mod_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_mod_panel();
				btn_mod_check.setVisible(true);
				btn_mod_clear.setVisible(false);
				btn_mod_modify.setVisible(false);

				text_mod_sheetID.setVisible(true);
				text_mod_projectID.setVisible(true);
				text_mod_pd.setVisible(true);
				text_mod_supID.setVisible(true);
				lbl_mod_sheetID_show.setVisible(false);
				lbl_mod_projectID_show.setVisible(false);
				lbl_mod_pd_show.setVisible(false);
				lbl_mod_supID_show.setVisible(false);

				lbl_mod_5.setVisible(false);
				text_mod_5.setVisible(false);

				lbl_mod_6.setVisible(false);
				text_mod_6.setVisible(false);

				lbl_mod_7.setVisible(false);
				text_mod_7.setVisible(false);

				lbl_mod_8.setVisible(false);
				text_mod_8.setVisible(false);

				lbl_mod_message.setVisible(false);
			}
		});
		btn_mod_clear.setBounds(532, 85, 83, 29);
		btn_mod_clear.setVisible(true);
		mod_panel.add(btn_mod_clear);

	}

	// third panel - Append sheet
	private void add_append_panel() {

		append_panel = new JPanel();
		append_panel.setBounds(0, 0, 666, 348);
		sheet_container_panel.add(append_panel, "Append");
		append_panel.setLayout(null);

		JLabel lbl_appd_type = new JLabel("*Sheet type:");
		lbl_appd_type.setBounds(167, 31, 85, 16);
		lbl_appd_type.setHorizontalAlignment(SwingConstants.RIGHT);
		append_panel.add(lbl_appd_type);

		lbl_appd_1 = new JLabel("");
		lbl_appd_1.setBounds(500, 26, 134, 16);
		lbl_appd_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_1.setVisible(false);
		append_panel.add(lbl_appd_1);

		text_appd_1 = new JTextField();
		text_appd_1.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_1.setBounds(634, 21, 116, 26);
		text_appd_1.setVisible(false);
		append_panel.add(text_appd_1);
		text_appd_1.setColumns(10);

		lbl_appd_2 = new JLabel("");
		lbl_appd_2.setBounds(500, 59, 134, 16);
		lbl_appd_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_2.setVisible(false);
		append_panel.add(lbl_appd_2);

		text_appd_2 = new JTextField();
		text_appd_2.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_2.setBounds(634, 54, 116, 26);
		text_appd_2.setVisible(false);
		append_panel.add(text_appd_2);
		text_appd_2.setColumns(10);

		lbl_appd_3 = new JLabel("");
		lbl_appd_3.setBounds(500, 90, 134, 16);
		lbl_appd_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_3.setVisible(false);
		append_panel.add(lbl_appd_3);

		text_appd_3 = new JTextField();
		text_appd_3.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_3.setBounds(634, 85, 116, 26);
		text_appd_3.setVisible(false);
		append_panel.add(text_appd_3);
		text_appd_3.setColumns(10);

		lbl_appd_4 = new JLabel("");
		lbl_appd_4.setBounds(500, 121, 134, 16);
		lbl_appd_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_4.setVisible(false);
		append_panel.add(lbl_appd_4);

		text_appd_4 = new JTextField();
		text_appd_4.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_4.setBounds(634, 116, 116, 26);
		text_appd_4.setVisible(false);
		append_panel.add(text_appd_4);
		text_appd_4.setColumns(10);

		lbl_appd_5 = new JLabel("");
		lbl_appd_5.setBounds(500, 152, 134, 16);
		lbl_appd_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_5.setVisible(false);
		append_panel.add(lbl_appd_5);

		text_appd_5 = new JTextField();
		text_appd_5.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_5.setBounds(634, 147, 116, 26);
		text_appd_5.setVisible(false);
		append_panel.add(text_appd_5);
		text_appd_5.setColumns(10);

		lbl_appd_6 = new JLabel("");
		lbl_appd_6.setBounds(500, 183, 134, 16);
		lbl_appd_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_6.setVisible(false);
		append_panel.add(lbl_appd_6);

		text_appd_6 = new JTextField();
		text_appd_6.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_6.setBounds(634, 178, 116, 26);
		text_appd_6.setVisible(false);
		append_panel.add(text_appd_6);
		text_appd_6.setColumns(10);

		lbl_appd_7 = new JLabel("");
		lbl_appd_7.setBounds(500, 215, 134, 16);
		lbl_appd_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_appd_7.setVisible(false);
		append_panel.add(lbl_appd_7);

		text_appd_7 = new JTextField();
		text_appd_7.setHorizontalAlignment(SwingConstants.CENTER);
		text_appd_7.setBounds(634, 210, 116, 26);
		text_appd_7.setVisible(false);
		append_panel.add(text_appd_7);
		text_appd_7.setColumns(10);

		btn_appd_append = new JButton("Append");
		btn_appd_append.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (rb_appd_RFQ.isSelected()) {
					if (append_check("RFQ")) {
						if (lib.projectID_check(text_appd_1) & lib.supplier_check(text_appd_3)
								& lib.num_not_null_check(text_appd_4)) {
							if ((!text_appd_5.getText().isBlank()) & lib.date(text_appd_5.getText())) {

								String[][] temp = append("RFQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier", "Product",
										"Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);
								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}

							} else if (text_appd_5.getText().isBlank()) {

								String[][] temp = append("RFQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier", "Product",
										"Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);
								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_5.getText().isBlank()) & (!lib.date(text_appd_5.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}

						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}

				} else if (rb_appd_QUO.isSelected()) {
					if (append_check("QUOT")) {
						if (lib.projectID_check(text_appd_1) & lib.supplier_check(text_appd_3)
								& lib.num_not_null_check(text_appd_4) & lib.num_not_null_check(text_appd_5)
								& lib.date(text_appd_6.getText())) {
							if ((!text_appd_7.getText().isBlank()) & lib.date(text_appd_7.getText())) {

								String[][] temp = append("QUOT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Product", "Supplier",
										"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_7.getText().isBlank()) {

								String[][] temp = append("QUOT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Product", "Supplier",
										"Vol.", "Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_7.getText().isBlank()) & (!lib.date(text_appd_7.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}

				} else if (rb_appd_REQ.isSelected()) {
					if (append_check("REQ")) {
						if (lib.projectID_check(text_appd_1) & lib.num_not_null_check(text_appd_4)
								& lib.num_not_null_check(text_appd_5) & lib.supervisor_check(text_appd_6)) {
							if ((!text_appd_7.getText().isBlank()) & lib.date(text_appd_7.getText())) {
								String[][] temp = append("REQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Item ","Module", "Vol.",
										"Unit Price", "Total_price", "Signature", "Supervisor", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_7.getText().isBlank()) {

								String[][] temp = append("REQ");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Item ","Module", "Vol.",
										"Unit Price", "Total_price", "Signature", "Supervisor", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_7.getText().isBlank()) & (!lib.date(text_appd_7.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}

				} else if (rb_appd_PUR.isSelected()) {
					if (append_check("PUR")) {
						if (lib.projectID_check(text_appd_1) &lib.supplier_check(text_appd_2)&lib.module_check(text_appd_3)
								& lib.num_not_null_check(text_appd_4) & lib.num_not_null_check(text_appd_5)
								& lib.date(text_appd_6.getText())) {
							if ((!text_appd_7.getText().isBlank()) & lib.date(text_appd_7.getText())) {

								String[][] temp = append("PUR");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module", "Vol.",
										"Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_7.getText().isBlank()) {

								String[][] temp = append("PUR");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module", "Vol.",
										"Unit Price", "Total_price", "ESD", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_7.getText().isBlank()) & (!lib.date(text_appd_7.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}
				} else if (rb_appd_EXAM.isSelected()) {
					if (append_check("EXAM")) {
						if (lib.projectID_check(text_appd_1) &lib.supplier_check(text_appd_2)& lib.module_check(text_appd_3)
								& lib.num_not_null_check(text_appd_4) & lib.tf_check(text_appd_5)) {
							if ((!text_appd_6.getText().isBlank()) & lib.date(text_appd_6.getText())) {

								String[][] temp = append("EXAM");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module", "Vol.", "Result",
										"Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_6.getText().isBlank()) {
								String[][] temp = append("EXAM");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module", "Vol.", "Result",
										"Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_6.getText().isBlank()) & (!lib.date(text_appd_6.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}
				} else {
					// if (rb_appd_RCPT.isSelected()) {
					if (append_check("RCPT")) {
						if (lib.projectID_check(text_appd_1) &lib.supplier_check(text_appd_2) &lib.module_check(text_appd_3)
								& lib.num_not_null_check(text_appd_4)) {
							if ((!text_appd_5.getText().isBlank()) & lib.date(text_appd_5.getText())) {
								String[][] temp = append("RCPT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module", "Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if (text_appd_5.getText().isBlank()) {

								String[][] temp = append("RCPT");
								String[] columns = { "Sheet ID", "Sheet type", "Project ID", "Supplier ID", "Module", "Vol.", "Date" };

								if (temp[0].length != 0) {
									DefaultTableModel append_table_model = new DefaultTableModel(temp, columns);
									append_table.setModel(append_table_model);
									append_table.setVisible(true);
									scrollpane_append.setVisible(true);
									lbl_append_message.setVisible(false);

								} else {
									lbl_append_message.setText("Please verify your inputted data again");
									lbl_append_message.setVisible(true);
									append_table.setVisible(false);
									scrollpane_append.setVisible(false);
								}
							} else if ((!text_appd_5.getText().isBlank()) & (!lib.date(text_appd_5.getText()))) {
								lbl_append_message.setText("Date Format Invalid");
								lbl_append_message.setVisible(true);
								append_table.setVisible(false);
								scrollpane_append.setVisible(false);
							}
						} else {
							lbl_append_message.setText("Format Invalid");
							lbl_append_message.setVisible(true);
							append_table.setVisible(false);
							scrollpane_append.setVisible(false);
						}
					} else {
						lbl_append_message.setText("you couldn't append a new sheet without previous procedure.");
						lbl_append_message.setVisible(true);
						append_table.setVisible(false);
						scrollpane_append.setVisible(false);
					}
				}
			}
		});
		btn_appd_append.setBounds(784, 21, 92, 29);
		btn_appd_append.setVisible(false);
		append_panel.add(btn_appd_append);

		ButtonGroup bg = new ButtonGroup();

		rb_appd_RFQ = new JRadioButton("R.F.Q");
		rb_appd_RFQ.setBounds(256, 28, 110, 23);
		append_panel.add(rb_appd_RFQ);
		rb_appd_RFQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Inquiring Product :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
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

				lbl_appd_ins.setVisible(true);
				btn_append_clear.setVisible(true);
				btn_appd_append.setVisible(true);

			}
		});
		bg.add(rb_appd_RFQ);

		rb_appd_QUO = new JRadioButton("Quotation");
		rb_appd_QUO.setBounds(256, 60, 110, 23);
		append_panel.add(rb_appd_QUO);

		rb_appd_QUO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Inquiring Product :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Supplier ID :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("*Unit Price :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("*ESD :");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("Date :");
				lbl_appd_7.setVisible(true);
				text_appd_7.setVisible(true);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

			}
		});
		bg.add(rb_appd_QUO);

		rb_appd_REQ = new JRadioButton("Requisition");
		rb_appd_REQ.setBounds(256, 91, 110, 23);
		append_panel.add(rb_appd_REQ);
		rb_appd_REQ.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Inquiring Product :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(false);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("*Unit Price :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("*Supervisor ID:");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("Date :");
				lbl_appd_7.setVisible(true);
				text_appd_7.setVisible(true);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);
			}
		});
		bg.add(rb_appd_REQ);

		rb_appd_PUR = new JRadioButton("Purchase");
		rb_appd_PUR.setBounds(256, 122, 110, 23);
		append_panel.add(rb_appd_PUR);
		rb_appd_PUR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Supplier ID :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Module Type :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("*Unit Price :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("*ESD :");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("Date :");
				lbl_appd_7.setVisible(true);
				text_appd_7.setVisible(true);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);
			}
		});
		bg.add(rb_appd_PUR);

		rb_appd_EXAM = new JRadioButton("Examination");
		rb_appd_EXAM.setBounds(256, 153, 110, 23);
		append_panel.add(rb_appd_EXAM);
		rb_appd_EXAM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Supplier ID :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Module Type :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
				lbl_appd_4.setVisible(true);
				text_appd_4.setVisible(true);

				lbl_appd_5.setText("Result :");
				lbl_appd_5.setVisible(true);
				text_appd_5.setVisible(true);

				lbl_appd_6.setText("Date :");
				lbl_appd_6.setVisible(true);
				text_appd_6.setVisible(true);

				lbl_appd_7.setText("");
				lbl_appd_7.setVisible(false);
				text_appd_7.setVisible(false);

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);
			}
		});
		bg.add(rb_appd_EXAM);

		rb_appd_RCPT = new JRadioButton("Receipt");
		rb_appd_RCPT.setBounds(256, 184, 110, 23);
		append_panel.add(rb_appd_RCPT);
		rb_appd_RCPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				clear_app_panel();

				lbl_appd_1.setText("*Project ID :");
				lbl_appd_1.setVisible(true);
				text_appd_1.setVisible(true);

				lbl_appd_2.setText("*Supplier ID :");
				lbl_appd_2.setVisible(true);
				text_appd_2.setVisible(true);

				lbl_appd_3.setText("*Module Type :");
				lbl_appd_3.setVisible(true);
				text_appd_3.setVisible(true);

				lbl_appd_4.setText("*Vol. :");
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

				lbl_appd_ins.setVisible(true);
				btn_appd_append.setVisible(true);
				btn_append_clear.setVisible(true);

			}
		});
		bg.add(rb_appd_RCPT);

		append_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable

		};
		append_table.setBounds(33, 292, 603, 49);

		// inventory_panel.add(inv_table);

		scrollpane_append = new JScrollPane(append_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane_append.setBounds(27, 281, 950, 79);

		append_panel.add(scrollpane_append);

		btn_append_clear = new JButton("Clear");
		btn_append_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clear_app_panel();
			}
		});
		btn_append_clear.setBounds(784, 210, 73, 29);
		btn_append_clear.setVisible(false);
		append_panel.add(btn_append_clear);

		lbl_append_message = new JLabel("");
		lbl_append_message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_append_message.setBounds(211, 253, 563, 16);
		lbl_append_message.setVisible(false);
		append_panel.add(lbl_append_message);

		lbl_appd_ins = new JLabel("*Obligatory");
		lbl_appd_ins.setBounds(172, 220, 102, 16);
		lbl_appd_ins.setVisible(false);
		append_panel.add(lbl_appd_ins);

	}

	// forth panel - remove sheet
	private void add_remove_panel() {

		remove_panel = new JPanel();
		remove_panel.setBounds(0, 0, 666, 348);
		sheet_container_panel.add(remove_panel, "Remove");
		remove_panel.setLayout(null);

		JLabel lbl_remove_sheetID = new JLabel("*Sheet ID :");
		lbl_remove_sheetID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_sheetID.setBounds(287, 53, 103, 16);
		remove_panel.add(lbl_remove_sheetID);

		text_remove_sheetID = new JTextField();
		text_remove_sheetID.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_sheetID.setBounds(409, 48, 146, 26);
		remove_panel.add(text_remove_sheetID);
		text_remove_sheetID.setColumns(10);

		lbl_remove_sheetID_show = new JLabel("");
		lbl_remove_sheetID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_sheetID_show.setBounds(409, 53, 146, 16);
		lbl_remove_sheetID_show.setVisible(false);
		remove_panel.add(lbl_remove_sheetID_show);

		lbl_remove_projectID_show = new JLabel("");
		lbl_remove_projectID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_projectID_show.setBounds(409, 88, 146, 16);
		lbl_remove_projectID_show.setVisible(false);
		remove_panel.add(lbl_remove_projectID_show);

		lbl_remove_pd_show = new JLabel("");
		lbl_remove_pd_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_pd_show.setBounds(409, 123, 146, 16);
		lbl_remove_pd_show.setVisible(false);
		remove_panel.add(lbl_remove_pd_show);

		lbl_remove_message = new JLabel("");
		lbl_remove_message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_message.setBounds(239, 192, 506, 16);
		remove_panel.add(lbl_remove_message);

		lbl_remove_ins = new JLabel("*Obligatory");
		lbl_remove_ins.setBounds(309, 18, 226, 16);
		lbl_remove_ins.setVisible(true);
		remove_panel.add(lbl_remove_ins);

		lbl_remove_confirm = new JLabel("Please write down \" I would like to remove this sheet permenantly.\"");
		lbl_remove_confirm.setBounds(206, 276, 555, 16);
		lbl_remove_confirm.setVisible(false);
		remove_panel.add(lbl_remove_confirm);

		text_remove_confirm = new JTextField(8);
		text_remove_confirm.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_confirm.setBounds(204, 289, 611, 26);
		text_remove_confirm.setColumns(10);
		text_remove_confirm.setVisible(false);
		text_remove_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (text_remove_confirm.getText().equals("I would like to remove this sheet permenantly.")) {
					if (delete() == 1) {

						lbl_remove_message.setText("Delete succeed");
						lbl_remove_message.setVisible(true);

					} else {
						lbl_remove_message.setText("Delete failed, errors occurred.");
						lbl_remove_message.setVisible(true);
					}
				}
			}
		});
		remove_panel.add(text_remove_confirm);

		text_remove_projectID = new JTextField();
		text_remove_projectID.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_projectID.setBounds(409, 85, 146, 26);
		remove_panel.add(text_remove_projectID);
		text_remove_projectID.setColumns(10);

		text_remove_pd = new JTextField();
		text_remove_pd.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_pd.setBounds(409, 118, 146, 26);
		remove_panel.add(text_remove_pd);
		text_remove_pd.setColumns(10);

		JLabel lbl_remove_projectID = new JLabel("*Project ID :");
		lbl_remove_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_projectID.setBounds(287, 88, 103, 16);
		remove_panel.add(lbl_remove_projectID);

		JLabel lbl_remove_pd = new JLabel("*Product :");
		lbl_remove_pd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_pd.setBounds(287, 123, 103, 16);
		remove_panel.add(lbl_remove_pd);
		
		text_remove_supID = new JTextField();
		text_remove_supID.setHorizontalAlignment(SwingConstants.CENTER);
		text_remove_supID.setBounds(409, 154, 146, 26);
		remove_panel.add(text_remove_supID);
		text_remove_supID.setColumns(10);

		JLabel lbl_remove_supID = new JLabel("Supplier_ID :");
		lbl_remove_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_remove_supID.setBounds(309, 159, 81, 16);
		remove_panel.add(lbl_remove_supID);

		lbl_remove_supID_show = new JLabel("");
		lbl_remove_supID_show.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_remove_supID_show.setBounds(409, 159, 146, 16);
		remove_panel.add(lbl_remove_supID_show);


		JButton btn_remove_check = new JButton("Check");
		btn_remove_check.setBounds(567, 48, 76, 29);
		btn_remove_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!lib.num_not_null_check(text_remove_sheetID) | !lib.num_not_null_check(text_remove_projectID)
						| text_remove_pd.getText().isBlank()) {
					// None of them can't be blank

					lbl_mod_message.setText("Format Invalid");
					lbl_mod_message.setVisible(true);

				} else {
					int what = Integer.parseInt(text_remove_sheetID.getText());

					if (what >= 23000000 & what < 24000000) {
						if (text_remove_supID.getText().isBlank()) {
							// REQ

							ArrayList<String> temp_list = rmv_mod_check(text_remove_sheetID, text_remove_projectID,
									text_remove_pd, text_remove_supID);

							if (temp_list.size() != 0) {
								// data found

								String[][] temp_array = new String[1][temp_list.size()];
								for (int i = 0; i < temp_list.size(); i++) {
									temp_array[0][i] = temp_list.get(i);
								}

								String[] columns_req = { "Sheet ID", "Sheet type", "Project ID", "Product", "Item Name",
										"Vol.", "Unit Price", "Total_price", "Signature", "Supervisor", "Date" };

								DefaultTableModel remove_table_model_req = new DefaultTableModel(temp_array,
										columns_req);
								remove_table.setModel(remove_table_model_req);

								remove_table.setVisible(true);
								scrollpane_remove.setVisible(true);
								lbl_remove_confirm.setVisible(true);
								text_remove_confirm.setVisible(true);
								btn_remove_confirm.setVisible(true);

								lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
								lbl_remove_projectID_show.setText(text_remove_projectID.getText());
								lbl_remove_pd_show.setText(text_remove_pd.getText());
								lbl_remove_supID_show.setText(text_remove_supID.getText());
								text_remove_sheetID.setVisible(false);
								text_remove_projectID.setVisible(false);
								text_remove_pd.setVisible(false);
								text_remove_supID.setVisible(false);
								lbl_remove_sheetID_show.setVisible(true);
								lbl_remove_projectID_show.setVisible(true);
								lbl_remove_pd_show.setVisible(true);
								lbl_remove_supID_show.setVisible(true);
							} else {
								// no found

								text_remove_sheetID.setVisible(true);
								text_remove_projectID.setVisible(true);
								text_remove_pd.setVisible(true);
								text_remove_supID.setVisible(true);
								lbl_remove_sheetID_show.setVisible(false);
								lbl_remove_projectID_show.setVisible(false);
								lbl_remove_pd_show.setVisible(false);
								lbl_remove_supID_show.setVisible(false);
								remove_table.setVisible(false);
								scrollpane_remove.setVisible(false);
								lbl_remove_confirm.setVisible(false);
								text_remove_confirm.setVisible(false);
								btn_remove_confirm.setVisible(false);

								lbl_remove_message.setText("Please check data inputted again");
								lbl_remove_message.setVisible(true);
							}
						} else {
							// REQ but Supplier_ID is filled

							text_remove_sheetID.setVisible(true);
							text_remove_projectID.setVisible(true);
							text_remove_pd.setVisible(true);
							text_remove_supID.setVisible(true);
							lbl_remove_sheetID_show.setVisible(false);
							lbl_remove_projectID_show.setVisible(false);
							lbl_remove_pd_show.setVisible(false);
							lbl_remove_supID_show.setVisible(false);
							remove_table.setVisible(false);
							scrollpane_remove.setVisible(false);
							lbl_remove_confirm.setVisible(false);
							text_remove_confirm.setVisible(false);
							btn_remove_confirm.setVisible(false);

							lbl_remove_message
									.setText("If you wanna check REQ sheet, you couldn't fill Supplier_ID textField.");
							lbl_remove_message.setVisible(true);

						}
					} else {
						// except for REQ sheet

						if (text_remove_supID.getText().isBlank()) {
							
							text_remove_sheetID.setVisible(true);
							text_remove_projectID.setVisible(true);
							text_remove_pd.setVisible(true);
							text_remove_supID.setVisible(true);
							lbl_remove_sheetID_show.setVisible(false);
							lbl_remove_projectID_show.setVisible(false);
							lbl_remove_pd_show.setVisible(false);
							lbl_remove_supID_show.setVisible(false);
							remove_table.setVisible(false);
							scrollpane_remove.setVisible(false);
							lbl_remove_confirm.setVisible(false);
							text_remove_confirm.setVisible(false);
							btn_remove_confirm.setVisible(false);

							lbl_remove_message.setText("Except for REQUISITION sheet, Please fill all the textField.");
							lbl_remove_message.setVisible(true);

						} else {

							ArrayList<String> temp_list = rmv_mod_check(text_remove_sheetID, text_remove_projectID,
									text_remove_pd, text_remove_supID);

							if (temp_list.size() != 0) {
								// data found

								String[][] temp_array = new String[1][temp_list.size()];
								for (int i = 0; i < temp_list.size(); i++) {
									temp_array[0][i] = temp_list.get(i);
								}

								if (temp_array[0][1].equalsIgnoreCase("RFQ")) {

									String[] columns_rfq = { "Sheet ID", "Sheet type", "Project ID", "Supplier",
											"Product", "Vol.", "Date" };

									DefaultTableModel remove_table_model_rfq = new DefaultTableModel(temp_array,
											columns_rfq);
									remove_table.setModel(remove_table_model_rfq);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

								} else if (temp_array[0][1].equalsIgnoreCase("QUOT")) {

									String[] columns_quot = { "Sheet ID", "Sheet type", "Project ID", "Supplier",
											"Product", "Vol.", "Unit Price", "Total_price", "ESD", "Date" };

									DefaultTableModel remove_table_model_quot = new DefaultTableModel(temp_array,
											columns_quot);
									remove_table.setModel(remove_table_model_quot);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

								} else if (temp_array[0][1].equalsIgnoreCase("PURC")) {

									String[] columns_pur = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name",
											"Module", "Vol.", "Unit Price", "Total Price", "ESD", "Date" };

									DefaultTableModel remove_table_model_pur = new DefaultTableModel(temp_array,
											columns_pur);
									remove_table.setModel(remove_table_model_pur);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

								} else if (temp_array[0][1].equalsIgnoreCase("EXAM")) {

									String[] columns_exam = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name",
											"Module", "Vol.", "Result", "Date" };

									DefaultTableModel remove_table_model_exam = new DefaultTableModel(temp_array,
											columns_exam);
									remove_table.setModel(remove_table_model_exam);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);

								} else {
									// temp_array[0][1].equalsIgnoreCase("RCPT")
									String[] columns_rcpt = { "Sheet ID", "Type", "Project ID", "Supplier_ID", "Name",
											"Module", "Vol.", "Date" };

									DefaultTableModel remove_table_model_rcpt = new DefaultTableModel(temp_array,
											columns_rcpt);
									remove_table.setModel(remove_table_model_rcpt);

									remove_table.setVisible(true);
									scrollpane_remove.setVisible(true);
									lbl_remove_confirm.setVisible(true);
									text_remove_confirm.setVisible(true);
									btn_remove_confirm.setVisible(true);

									lbl_remove_sheetID_show.setText(text_remove_sheetID.getText());
									lbl_remove_projectID_show.setText(text_remove_projectID.getText());
									lbl_remove_pd_show.setText(text_remove_pd.getText());
									lbl_remove_supID_show.setText(text_remove_supID.getText());
									text_remove_sheetID.setVisible(false);
									text_remove_projectID.setVisible(false);
									text_remove_pd.setVisible(false);
									text_remove_supID.setVisible(false);
									lbl_remove_sheetID_show.setVisible(true);
									lbl_remove_projectID_show.setVisible(true);
									lbl_remove_pd_show.setVisible(true);
									lbl_remove_supID_show.setVisible(true);
								}
							} else {
								// data no found

								text_remove_sheetID.setVisible(true);
								text_remove_projectID.setVisible(true);
								text_remove_pd.setVisible(true);
								text_remove_supID.setVisible(true);
								lbl_remove_sheetID_show.setVisible(false);
								lbl_remove_projectID_show.setVisible(false);
								lbl_remove_pd_show.setVisible(false);
								lbl_remove_supID_show.setVisible(false);
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

				}
			}
		});
		remove_panel.add(btn_remove_check);

		remove_table = new JTable() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}// uneditable
		};
		remove_table.setBounds(78, 177, 506, 47);

		remove_table.setVisible(false);

		scrollpane_remove = new JScrollPane(remove_table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane_remove.setBounds(21, 221, 950, 43);
		scrollpane_remove.setVisible(false);
		remove_panel.add(scrollpane_remove);

		btn_remove_confirm = new JButton("Confirm");
		btn_remove_confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (text_remove_confirm.getText().equals("I would like to remove this sheet permenantly.")) {
					if (delete() == 1) {

						lbl_remove_message.setText("Delete succeed");
						lbl_remove_message.setVisible(true);

					} else {
						lbl_remove_message.setText("Delete failed, errors occurred.");
						lbl_remove_message.setVisible(true);
					}
				}
			}
		});
		btn_remove_confirm.setBounds(452, 327, 93, 29);
		btn_remove_confirm.setVisible(false);
		remove_panel.add(btn_remove_confirm);

		JButton btn_remove_clear = new JButton("Clear");
		btn_remove_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				clear_remove_panel();
				scrollpane_remove.setVisible(false);
				remove_table.setVisible(false);
				lbl_remove_confirm.setVisible(false);
				text_remove_confirm.setVisible(false);
				btn_remove_confirm.setVisible(false);
				text_remove_sheetID.setVisible(true);
				lbl_remove_sheetID_show.setVisible(false);
				text_remove_projectID.setVisible(true);
				lbl_remove_projectID_show.setVisible(false);
				text_remove_pd.setVisible(true);
				lbl_remove_pd_show.setVisible(false);

			}
		});
		btn_remove_clear.setBounds(567, 89, 76, 29);
		remove_panel.add(btn_remove_clear);

		
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

				String[][] temp = lib.show_unsign_req();

				if (temp.length != 0) {

					String[] columns_name = { "Sheet ID", "Sheet Type", "Project ID", "Product", "Item", "Vol.",
							"Unit Price", "Total Price", "Signature", "Supervisor ID", "Name", "Date" };

					lbl_sign_sorry.setVisible(false);
					btn_sign_sign.setVisible(true);
					btn_sign_refresh.setVisible(true);
					lbl_sign_instr.setText("Please sign sheets below after reading.");
					lbl_sign_instr.setVisible(true);

					DefaultTableModel sign_table_model = new DefaultTableModel(temp, columns_name);
					sign_table.setModel(sign_table_model);
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
			}
		});
		btn_sign_refresh.setBounds(658, 89, 112, 29);
		sign_panel.add(btn_sign_refresh);
		// btn_refresh.setVisible(true);

	}

	public void clear_inq_panel() {

		text_inq_sheetID.setText("");
		text_inq_projectID.setText("");
		text_inq_pd.setText("");
	}

	public void clear_mod_panel() {

		text_mod_sheetID.setText("");
		lbl_mod_sheetID_show.setText("");

		text_mod_projectID.setText("");
		lbl_mod_projectID_show.setText("");

		text_mod_pd.setText("");
		lbl_mod_pd_show.setText("");

		text_mod_supID.setText("");
		lbl_mod_supID_show.setText("");
		text_mod_5.setText("");
		text_mod_6.setText("");
		text_mod_7.setText("");
		text_mod_8.setText("");

		lbl_mod_message.setText("");
	}

	public void clear_app_panel() {

		text_appd_1.setText("");
		text_appd_2.setText("");
		text_appd_3.setText("");
		text_appd_4.setText("");
		text_appd_5.setText("");
		text_appd_6.setText("");
		text_appd_7.setText("");

		lbl_append_message.setText("");

	}

	public void clear_remove_panel() {

		text_remove_sheetID.setText("");
		text_remove_projectID.setText("");
		text_remove_pd.setText("");
		text_remove_supID.setText("");
		lbl_remove_sheetID_show.setText("");
		lbl_remove_projectID_show.setText("");
		lbl_remove_pd_show.setText("");
		lbl_remove_supID_show.setText("");
	}
			
	private String[][] inquire_all(JTextField first, JTextField second, JTextField third){
				
		/**@author jyunanyang
		 * @since 05/06/2021
		 * 
		 */
		
		ArrayList<String[]> temp = new ArrayList();
		
		String st_inq_all_sheets = "SELECT * FROM VIEW_6_SHEETS";
							
			switch(lib.check_text_fields(first, second,third)) {
				
				
				case "011":
					try {
//						System.out.print(st_inq_all_sheets+" WHERE (RFQ_pj_ID="
//								+ text_inq_projectID.getText()+" AND RFQ_pd=\'"+text_inq_pd.getText()+"\')");
						ResultSet r = Term_project_main.conn.st.executeQuery(st_inq_all_sheets+" WHERE (RFQ_pj_ID="
								+ text_inq_projectID.getText()+" AND RFQ_pd=\'"+text_inq_pd.getText()+"\')");
						
						while(r.next()) {
							
							if(r.getString(2)!= null) {
								
								String [] rfq = new String[8];
								for(int i =1; i<9;i++) {
									rfq[i-1]=r.getString(i);		
								}
								temp.add(rfq);
								
								if(r.getString(10)!= null) {
									
									String [] quo = new String[11];
									for(int i =9; i<20;i++) {
										quo[i-9]=r.getString(i);		
									}
									temp.add(quo);
									
									if(r.getString(21)!= null) {
										String [] req = new String[12];
										for(int i =20; i<32;i++) {
											req[i-20]=r.getString(i);		
										}
										temp.add(req);
										
										if (r.getString(33)!= null) {
											
											String [] pur = new String[11];
											for(int i =32; i<43;i++) {
												pur[i-32]=r.getString(i);		
											}
											temp.add(pur);
											
											if(r.getString(44)!= null) {
												
												String [] exam = new String[9];
												for(int i =43; i<52;i++) {
													exam[i-43]=r.getString(i);		
												}
												temp.add(exam);
												
												if(r.getString(53)!= null) {
													
													String [] rcpt = new String[8];
													for(int i =52; i<60;i++) {
														rcpt[i-52]=r.getString(i);		
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
						
						ResultSet r = Term_project_main.conn.st.executeQuery(st_inq_all_sheets+" WHERE RFQ_pj_ID="+text_inq_projectID.getText());
						
						while(r.next()) {
							
							if(r.getString(2)!= null) {
								
								String [] rfq = new String[8];
								for(int i =1; i<9;i++) {
									rfq[i-1]=r.getString(i);		
								}
								temp.add(rfq);
								
								if(r.getString(10)!= null) {
									
									String [] quo = new String[11];
									for(int i =9; i<20;i++) {
										quo[i-9]=r.getString(i);		
									}
									temp.add(quo);
									
									if(r.getString(21)!= null) {
										String [] req = new String[12];
										for(int i =20; i<32;i++) {
											req[i-20]=r.getString(i);		
										}
										temp.add(req);
										
										if (r.getString(33)!= null) {
											
											String [] pur = new String[11];
											for(int i =32; i<43;i++) {
												pur[i-43]=r.getString(i);		
											}
											temp.add(pur);
											
											if(r.getString(44)!= null) {
												
												String [] exam = new String[9];
												for(int i =43; i<52;i++) {
													exam[i-43]=r.getString(i);		
												}
												temp.add(exam);
												
												if(r.getString(53)!= null) {
													
													String [] rcpt = new String[8];
													for(int i =52; i<60;i++) {
														rcpt[i-52]=r.getString(i);		
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
						ResultSet r = Term_project_main.conn.st.executeQuery(st_inq_all_sheets+" WHERE RFQ_pd=\'"+text_inq_pd.getText()+"\'");
						
						while(r.next()) {
							
							if(r.getString(2)!= null) {
								
								String [] rfq = new String[8];
								for(int i =1; i<9;i++) {
									rfq[i-1]=r.getString(i);		
								}
								temp.add(rfq);
								
								if(r.getString(10)!= null) {
									
									String [] quo = new String[11];
									for(int i =9; i<20;i++) {
										quo[i-9]=r.getString(i);		
									}
									temp.add(quo);
									
									if(r.getString(21)!= null) {
										String [] req = new String[12];
										for(int i =20; i<32;i++) {
											req[i-20]=r.getString(i);		
										}
										temp.add(req);
										
										if (r.getString(33)!= null) {
											
											String [] pur = new String[11];
											for(int i =32; i<43;i++) {
												pur[i-32]=r.getString(i);		
											}
											temp.add(pur);
											
											if(r.getString(44)!= null) {
												
												String [] exam = new String[9];
												for(int i =43; i<52;i++) {
													exam[i-43]=r.getString(i);		
												}
												temp.add(exam);
												
												if(r.getString(53)!= null) {
													
													String [] rcpt = new String[8];
													for(int i =52; i<60;i++) {
														rcpt[i-52]=r.getString(i);		
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
				
				String[][] result_array = new String[temp.size()][12];
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
				lib.sort(result_array);
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
					
					final String st_rfq = "SELECT rfq.RFQ_Sheet_ID, rfq.Sheet_type, rfq.Project_ID,  "
							+"rfq.Supplier_ID, sup.Supplier_name, rfq.Inquiring_product, rfq.Vol, rfq.Date FROM test.RFQ AS rfq \n"
							+"LEFT JOIN test.SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID";
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE (RFQ_Sheet_ID="
																		+text_inq_sheetID.getText()+" AND rfq.Project_ID ="+text_inq_projectID.getText()
																		+" AND rfq.Inquiring_product=\'"+text_inq_pd.getText()+"\')");
	
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE (RFQ_Sheet_ID="
																		+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");
	
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE (RFQ_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE RFQ_Sheet_ID="
																		+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE (Project_ID ="
																	+text_inq_projectID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE Project_ID ="+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery(st_rfq+" WHERE Inquiring_product=\'"+text_inq_pd.getText()+"\'");

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
					
					final String st_quo = "SELECT quo.QUO_Sheet_ID, quo.Sheet_type, quo.Project_ID,  \n"
							+ "quo.Supplier_ID, sup.Supplier_name, quo.Inquiring_product, quo.Vol, quo.Unit_price, quo.Total_price,\n"
							+ "quo.ESD, quo.Date FROM test.QUOTATION AS quo \n"
							+ "LEFT JOIN test.SUPPLIER AS sup ON sup.Supplier_ID=quo.Supplier_ID";
					
					switch(lib.check_text_fields(first, second, third)) {
					
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE (QUO_Sheet_ID="
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
								r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE (QUO_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE (QUO_Sheet_ID="
																	+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE QUO_Sheet_ID="+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE (Project_ID ="
																	+text_inq_projectID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE Project_ID ="
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
								r = Term_project_main.conn.st.executeQuery(st_quo+" WHERE Inquiring_product=\'"
															+text_inq_pd.getText()+"\'");

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
					
					final String st_req = "SELECT req.REQ_Sheet_ID, req.Sheet_type, req.Project_ID, req.Inquiring_product, req.Item_name,\n"
							+ " req.Vol, req.Unit_price, req.Total_price, req.Signature, req.Supervisor_ID,CONCAT(emp.First_name,\' \', emp.Last_name) AS Name,req.Date FROM \n"
							+ "test.REQUISITION AS req LEFT JOIN test.EMPLOYEE AS emp ON emp.Emp_ID=req.Supervisor_ID";
					
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery(st_req+" WHERE (REQ_Sheet_ID="
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
								r = Term_project_main.conn.st.executeQuery(st_req+" WHERE (REQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_req+" WHERE (REQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_req+" WHERE REQ_Sheet_ID="+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_req+" WHERE (Project_ID ="+text_inq_projectID.getText()
																			+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_req+" WHERE Project_ID ="+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery(st_req+" WHERE Inquiring_product=\'"+text_inq_pd.getText()+"\'");

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
					
					String st_pur = "SELECT pur.PUR_Sheet_ID, Sheet_type, pur.Project_ID, pur.Supplier_ID, sup.Supplier_name, "
							+ "pur.Module_type, pur.Vol, pur.Unit_price, pur.total_price, pur.ESD, pur.Date "
							+ "FROM PURCHASE AS pur INNER JOIN SUPPLIER AS sup ON sup.Supplier_ID=pur.Supplier_ID";
					
					switch(lib.check_text_fields(first, second, third)) {
						
						
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE (pur.PUR_Sheet_ID="
											+text_inq_sheetID.getText()+" AND pur.Project_ID ="+text_inq_projectID.getText()
											+" AND pur.Module_type =\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE (pur.PUR_Sheet_ID="
												+text_inq_sheetID.getText()+" AND pur.Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE (pur.PUR_Sheet_ID="
												+text_inq_sheetID.getText()+" AND pur.Module_type =\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE pur.PUR_Sheet_ID="+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE (pur.Project_ID ="+text_inq_projectID.getText()
												+" AND pur.Module_type =\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE pur.Project_ID ="+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery(st_pur+" WHERE pur.Module_type =\'"+text_inq_pd.getText()+"\'");

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
					
				case "EXAM":
					
					String st_exam = "SELECT ex.EX_Sheet_ID, ex.Sheet_type, ex.Project_ID, ex.Supplier_ID, "
							+ "sup.Supplier_name, ex.Module_type, ex.Vol, ex.Result, ex.Date FROM EXAMINATION AS ex INNER JOIN SUPPLIER AS sup"
							+ " ON sup.Supplier_ID = ex.Supplier_ID";
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE (ex.EX_Sheet_ID="
											+text_inq_sheetID.getText()+" AND ex.Project_ID ="+text_inq_projectID.getText()
											+" AND ex.Module_type =\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE (ex.EX_Sheet_ID="
												+text_inq_sheetID.getText()+" AND ex.Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE (ex.EX_Sheet_ID="
												+text_inq_sheetID.getText()+" AND ex.Module_type =\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE ex.EX_Sheet_ID="+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE (ex.Project_ID ="+text_inq_projectID.getText()
												+" AND ex.Module_type =\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE ex.Project_ID ="+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery(st_exam+" WHERE Module_type =\'"+text_inq_pd.getText()+"\'");

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
				
				default:
				//case "RCPT":
					String st_rcpt = "SELECT rcpt.REC_Sheet_ID, rcpt.Sheet_type, rcpt.Project_ID, rcpt.Supplier_ID, "
								+ "sup.Supplier_name, rcpt.Module_type, rcpt.Vol, rcpt.Date FROM RECEIPT AS rcpt INNER JOIN SUPPLIER AS sup"
								+ " ON sup.Supplier_ID = rcpt.Supplier_ID";
					switch(lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE (rcpt.REC_Sheet_ID="+text_inq_sheetID.getText()
											+" AND rcpt.Project_ID ="+text_inq_projectID.getText()
											+" AND rcpt.Module_type =\'"+text_inq_pd.getText()+"\')");

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							r=null;
							
						}
						break;
					
						case "110":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE (rcpt.REC_Sheet_ID="+text_inq_sheetID.getText()
														+" AND rcpt.Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE (rcpt.REC_Sheet_ID="+text_inq_sheetID.getText()
								+" AND rcpt.Module_type =\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE rcpt.REC_Sheet_ID="+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE (rcpt.Project_ID ="+text_inq_projectID.getText()
												+" AND rcpt.Module_type =\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE rcpt.Project_ID ="+text_inq_projectID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						default:
							//001
							try {
								r = Term_project_main.conn.st.executeQuery(st_rcpt+" WHERE rcpt.Module_type =\'"+text_inq_pd.getText()+"\'");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
					}
					try {
						while(r.next()) {
							
							String[] temp_array = new String[8];
							
							for(int i=1;i<9;i++) 
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
	
	
	
	
	
	
	
	
	
	
	
	private int sign_all() {
		
		int r=0;
		try {
			r = Term_project_main.conn.st.executeUpdate("UPDATE test.REQUISITION SET Signature=\'True\' WHERE Supervisor_ID="
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
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE test.RFQ SET Supplier_ID=\'"+text_mod_supID.getText()+"\', Vol="+text_mod_5.getText()
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
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE test.QUOTATION SET Supplier_ID=\'"+text_mod_supID.getText()+"\', Vol="+text_mod_5.getText()
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
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE test.REQUISITION SET Item_name=\'"+ text_mod_supID.getText()+"\', Vol="
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
				
				 r = Term_project_main.conn.st.executeUpdate("UPDATE test.PURCHASE SET Vol="+text_mod_5.getText()+", Unit_price="+text_mod_6.getText()+", ESD=\'"
															+text_mod_7.getText()+"\', Date=\'"+text_mod_8.getText()+"\' WHERE (PUR_Sheet_ID="
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
				
				r = Term_project_main.conn.st.executeUpdate("UPDATE test.EXAMINATION SET Vol="+text_mod_5.getText()+", Date=\'"+text_mod_6.getText()
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
				
				r = Term_project_main.conn.st.executeUpdate("UPDATE test.RECEIPT SET Vol="+text_mod_5.getText()+", Date=\'"+text_mod_6.getText()
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
				
				 r = Term_project_main.conn.st.executeUpdate("DELETE FROM test.RFQ WHERE (RFQ_Sheet_ID="+lbl_remove_sheetID_show.getText()+
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
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM test.QUOTATION WHERE (QUO_Sheet_ID="+lbl_remove_sheetID_show.getText()+
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
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM test.REQUISITION WHERE (REQ_Sheet_ID="+lbl_remove_sheetID_show.getText()+
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
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM test.PURCHASE WHERE (PUR_Sheet_ID="+lbl_remove_sheetID_show.getText()+
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
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM test.EXAMINATION WHERE (EX_Sheet_ID="+lbl_remove_sheetID_show.getText()+
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
				
				r = Term_project_main.conn.st.executeUpdate("DELETE FROM test.RECEIPT WHERE (REC_Sheet_ID="+lbl_remove_sheetID_show.getText()+
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
															+ "FROM test.PROJECT AS pj LEFT JOIN test.RFQ ON pj.Project_ID = RFQ.Project_ID \n"
															+ "LEFT JOIN test.QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
															+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
															+ "LEFT JOIN test.REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
															+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
															+ "LEFT JOIN test.PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
															+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
															+ "LEFT JOIN test.EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
															+ "AND EXAM.Module_type = PUR.Module_type)\n"
															+ "LEFT JOIN test.RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
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
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.RFQ (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol, Date) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+
																	text_appd_3.getText()+"\', "+ text_appd_4.getText()+", \'"+text_appd_5.getText()+"\')");
		
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.RFQ ORDER BY RFQ_Sheet_ID DESC LIMIT 1");
							
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
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.RFQ (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+
																	text_appd_3.getText()+"\', "+ text_appd_4.getText()+")");
		
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.RFQ ORDER BY RFQ_Sheet_ID DESC LIMIT 1");
							
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
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.QUOTATION (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol, Unit_price, ESD, Date) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()
																	+"\', \'"+text_appd_3.getText()+"\', "+ text_appd_4.getText()+", "+text_appd_5.getText()
																	+", \'"+text_appd_6.getText()+"\', \'"+text_appd_7.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");
							
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
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.QUOTATION (Project_ID, Inquiring_product, Supplier_ID, "
																	+ "Vol, Unit_price, ESD) VALUE ("+ text_appd_1.getText()+", \'"+text_appd_2.getText()
																	+"\', \'"+text_appd_3.getText()+"\', "+ text_appd_4.getText()+", "+text_appd_5.getText()
																	+", \'"+text_appd_6.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");
							
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
				
				
				String item;
				
				if (text_appd_2.getText().substring(0, 1).equals("C"))

					item="CPU";

				else if ((text_appd_2.getText().substring(0, 1).equals("G")))

					item="GPU";

				else if (text_appd_2.getText().substring(0, 1).equals("R"))

					item="RAM";

				else
					item="Unknown";
				
				if(!text_appd_7.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.REQUISITION (Project_ID, Inquiring_product, Item_name, "
																	+ "Vol, Unit_price, Supervisor_ID, Date) VALUE ("+ text_appd_1.getText()+", \'"															
																	+text_appd_2.getText()+"\', \'"+item+"\', "+ text_appd_4.getText()+", "
																	+text_appd_5.getText()+", "+text_appd_6.getText()+", \'"+text_appd_7.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.REQUISITION ORDER BY REQ_Sheet_ID DESC LIMIT 1");
							
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
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.REQUISITION (Project_ID, Inquiring_product, Item_name, "
																	+ "Vol, Unit_price, Supervisor_ID) VALUE ("+ text_appd_1.getText()+", \'"															
																	+text_appd_2.getText()+"\', \'"+item+"\', "+ text_appd_4.getText()+", "
																	+text_appd_5.getText()+", "+text_appd_6.getText()+")");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.REQUISITION ORDER BY REQ_Sheet_ID DESC LIMIT 1");
							
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
				if(!text_appd_7.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.PURCHASE (Project_ID, Supplier_ID, Module_type, Vol, Unit_price, ESD, Date) VALUE ("
																	+ text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+"\', "
																	+text_appd_4.getText()+", "+text_appd_5.getText()+", \'"+text_appd_6.getText()+"\', \'"+text_appd_7.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");
							
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
					//text_appd_6.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.PURCHASE (Project_ID, Supplier_ID, Module_type, Vol, Unit_price, ESD) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+"\', "
																	+text_appd_4.getText()+", "+text_appd_5.getText()+", \'"+text_appd_6.getText()+"\')");
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");
							
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
				
			case "EXAM":
				if(!text_appd_6.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.EXAMINATION (Project_ID, Supplier_ID, Module_type, Vol, Result, Date) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+
																	"\', "+ text_appd_4.getText()+", \'"+text_appd_5.getText()+"\', \'"+text_appd_6.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.EXAMINATION ORDER BY EX_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<9;i++) {
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
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.EXAMINATION (Project_ID, Supplier_ID, Module_type, Vol, Result) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+
																	"\', "+text_appd_4.getText()+ ", \'"+ text_appd_5.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.EXAMINATION ORDER BY EX_Sheet_ID DESC LIMIT 1");
							
							if(r.next()) {
								for(int i=1;i<9;i++) {
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
				if(!text_appd_5.getText().isBlank()) {
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.RECEIPT (Project_ID, Supplier_ID, Module_type, Vol, Date) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+text_appd_3.getText()
																	+"\', "+text_appd_4.getText()+", \'"+ text_appd_5.getText()+"\')");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.RECEIPT ORDER BY REC_Sheet_ID DESC LIMIT 1");
							
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
					//text_appd_4.getText().isBlank()
					try {
						resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO test.RECEIPT (Project_ID, Supplier_ID, Module_type, Vol) VALUE ("
																	+text_appd_1.getText()+", \'"+text_appd_2.getText()+"\', \'"+text_appd_3.getText()+"\', "
																	+text_appd_4.getText()+")");
						
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if (resultSet!=0) {
						try {
							ResultSet r =Term_project_main.conn.st.executeQuery("SELECT * FROM test.RECEIPT ORDER BY REC_Sheet_ID DESC LIMIT 1");
							
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
				
		}
		String[][] result_array = new String[1][temp.size()];
		
		int i=0;
		for (String k : temp) {
			result_array[0][i++] = k;
		        }
		return result_array;
	
	}
	
	
	
	
	private ArrayList<String> rmv_mod_check(JTextField text1, JTextField text2, JTextField text3, JTextField text4) {
		
		
		/**@author jyunanyang
		 * @since 05/06/2021
		 */
		
		ArrayList<String> temp = new ArrayList();
		
		int id = Integer.parseInt(text1.getText());
		
		if (id>=21000000 & id< 22000000) {
			//RFQ
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.veiw_rfq WHERE (Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module=\'"+text3.getText()
												+"\' AND Supplier_ID=\'"+text4.getText()+"\')");
				
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
			
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.view_quotation WHERE (Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module=\'"+text3.getText()
												+"\' AND Supplier_ID=\'"+text4.getText()+"\')");
				
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
			
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.view_requisition WHERE (Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module=\'"+text3.getText()
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
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.view_purchase WHERE (Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module=\'"+text3.getText()
												+"\' AND Supplier_ID=\'"+text4.getText()+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<11;i++) {
						//System.out.print(r.getString(i)+"\t");
						temp.add(r.getString(i));
						
					}
					//System.out.print("\n");
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
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.view_examination WHERE (Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module=\'"+text3.getText()
												+"\' AND Supplier_ID=\'"+text4.getText()+"\')");
				
				while(r.next()) {
					
					for(int i=1; i<9;i++) {
						
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
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.view_receipt WHERE (Sheet_ID="+text1.getText()+
												" AND Project_ID="+text2.getText()+" AND Module=\'"+text3.getText()
												+"\' AND Supplier_ID=\'"+text4.getText()+"\')");
				
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
				
		}else {
			
			return temp;
		}
		
	}
	
	public JComboBox get_comboBox_sheets() {
					
		return comboBox_sheets;
	}
}
