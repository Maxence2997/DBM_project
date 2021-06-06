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
	
	
	private JTable inq_table;
	private JTable mod_table;
	private JTable appd_table;	
	private JTable remv_table;
	private JTable sign_table;
	
	
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
	private JScrollPane scrollpane;
	private JRadioButton rb_inq_all;
	private JRadioButton rb_inq_RFQ;
	private JRadioButton rb_inq_quo;
	private JRadioButton rb_inq_req;
	private JRadioButton rb_inq_pur;
	private JRadioButton rb_inq_exam;
	private JRadioButton rb_inq_rec;
	private DefaultTableModel inq_table_model;
	
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
	
	private JPanel remove_panel;
	private JLabel lbl_remv_confirm;
	private JTextField text_remv_confirm;
	private JButton btn_remv_confirm;
	
	
	private JPanel sign_panel;
	private JLabel lbl_sign_sorry;
	private JLabel lbl_sign_instr;
	private JButton btn_sign_sign;
	private JButton btn_sign_refresh;
	
	private JPanel append_panel;
	private JLabel lbl_appd_price;
	private JTextField text_appd_price;
	private JLabel lbl_appd_esd;
	private JTextField text_appd_esd;
	private JLabel lbl_appd_result;
	private JTextField text_appd_result;
	private JLabel lbl_appd_next;
	private JTextField text_appd_next;
	private JLabel lbl_appd_last;
	private JTextField text_appd_last;
	
	private JComboBox comboBox_sheets;
	
	
	private CardLayout cl_sheet;
	private JButton btn_mod_check;
	private JLabel lbl_mod_message;
	private JLabel lbl_mod_note;
	private JTextField text_mod_8;
	private JLabel lbl_mod_8;
	private JButton btn_clear;
	private JLabel lbl_mod_sheetID_show;
	private JLabel lbl_mod_projectID_show;
	private JLabel lbl_mod_pd_show;
	
	
	
	public Sheets_panel() {
		
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
				
				comboBox_sheets = new JComboBox(new String[] {"--------","Inquire", "Modify","Remove","Signature"});
				comboBox_sheets.setBounds(262, 6, 120, 27);			
				comboBox_sheets.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	String function = (String) comboBox_sheets.getSelectedItem(); //get the selected item
	
			                
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
						
						if (rb_inq_all.isSelected()) {
							String [][] temp = inquire_all(text_inq_sheetID,text_inq_projectID,text_inq_pd);
							
//							for(int i=0; i<temp.length;i++) {
//								for(int j=0; j<temp[i].length;j++) {
//									System.out.print(temp[i][j]+"\t");
//								}
//								System.out.println();
//							}

							String[] columns_name = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
							
							if(temp.length!=0) {
								inq_table_model = new DefaultTableModel(temp,columns_name);
								inq_table.setModel(inq_table_model);
								inq_table.setVisible(true);
								scrollpane.setVisible(true);
								lbl_inq_result.setText("Data loaded");
								lbl_inq_result.setVisible(true);
							}
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

				scrollpane = new JScrollPane(inq_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollpane.setBounds(52,219,559,100);
				
				inq_panel.add(scrollpane);
				
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
						
						
						//verify formate
						
						if (modify()==1) 
							
							lbl_mod_message.setText("modification succeed");
						else 
							lbl_mod_message.setText("modification failed");
						
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
						
						ArrayList<String> temp = check();
//						ArrayList<String> temp = new ArrayList(); //test data
//						String[] temp2 = {"23000002", "REQ", "90000002", "C0z035", "CPU", "204", "653", "11047603", "2021-03-27"}; //test data
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
							
								lbl_mod_4.setVisible(false);
								text_mod_4.setVisible(false);
								
								lbl_mod_5.setVisible(true);
								text_mod_5.setVisible(true);		
							
								lbl_mod_6.setVisible(false);
								text_mod_6.setVisible(false);
								
								
								lbl_mod_7.setVisible(false);
								text_mod_7.setVisible(false);
								
								lbl_mod_8.setVisible(false);
								text_mod_8.setVisible(false);
								
								btn_mod_modify.setVisible(false);
								lbl_mod_message.setText("please check data again");
								lbl_mod_message.setVisible(true);
							
							
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
				
				btn_clear = new JButton("Clear");
				btn_clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				btn_clear.setBounds(389, 74, 83, 29);
				btn_clear.setVisible(true);
				mod_panel.add(btn_clear);
				
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
				
				JLabel lbl_appd_type = new JLabel("*Order type:");
				lbl_appd_type.setBounds(48, 11, 85, 16);
				lbl_appd_type.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_type);
				
				ButtonGroup bg = new ButtonGroup();
				
				JRadioButton rb_appd_RFQ = new JRadioButton("R.F.Q");
				rb_appd_RFQ.setBounds(137, 8, 110, 23);
				append_panel.add(rb_appd_RFQ);
				rb_appd_RFQ.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			            lbl_appd_price.setVisible(false);
			            text_appd_price.setVisible(false);
			            
			            lbl_appd_esd.setVisible(false);
			            text_appd_esd.setVisible(false);
			            
			            lbl_appd_result.setVisible(false);
			            text_appd_result.setVisible(false);
			            
			            lbl_appd_last.setVisible(false);
			            text_appd_last.setVisible(false);
			            
			            lbl_appd_next.setVisible(true);
			            text_appd_next.setVisible(true);
			            
			        }
			    });
				bg.add(rb_appd_RFQ);
				
				JLabel lbl_appd_empID = new JLabel("Employee ID :");
				lbl_appd_empID.setBounds(280, 11, 134, 16);
				lbl_appd_empID.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_empID);
				
				JTextField text_appd_empID = new JTextField();
				text_appd_empID.setBounds(414, 6, 116, 26);
				append_panel.add(text_appd_empID);
				text_appd_empID.setColumns(10);
				
				JButton btn_appd_append = new JButton("Append");
				btn_appd_append.setBounds(563, 5, 92, 29);
				append_panel.add(btn_appd_append);
				
				JRadioButton rb_appd_quotation = new JRadioButton("Quotation");
				rb_appd_quotation.setBounds(137, 40, 110, 23);
				append_panel.add(rb_appd_quotation);
				
				rb_appd_quotation.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_appd_result.setVisible(false);
			            text_appd_result.setVisible(false);
			            
			            lbl_appd_price.setVisible(true);
			            text_appd_price.setVisible(true);
			            
			            lbl_appd_esd.setVisible(true);
			            text_appd_esd.setVisible(true);
			            
			            lbl_appd_last.setVisible(true);
			            text_appd_last.setVisible(true);
			            
			            lbl_appd_next.setVisible(true);
			            text_appd_next.setVisible(true);
			            
			        }
			    });
				bg.add(rb_appd_quotation);
				
				JLabel lbl_appd_pd = new JLabel("Product Module :");
				lbl_appd_pd.setBounds(280, 44, 134, 16);
				lbl_appd_pd.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_pd);
				
				JTextField text_appd_pd = new JTextField();
				text_appd_pd.setBounds(414, 39, 116, 26);
				append_panel.add(text_appd_pd);
				text_appd_pd.setColumns(10);
				
				JRadioButton rb_appd_req = new JRadioButton("Requisition");
				rb_appd_req.setBounds(137, 71, 110, 23);
				append_panel.add(rb_appd_req);
				rb_appd_req.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_appd_price.setVisible(false);
			            text_appd_price.setVisible(false);
			            
			            lbl_appd_esd.setVisible(false);
			            text_appd_esd.setVisible(false);
			            
			            lbl_appd_result.setVisible(false);
			            text_appd_result.setVisible(false);
			            
			            lbl_appd_last.setVisible(true);
			            text_appd_last.setVisible(true);
			            
			            lbl_appd_next.setVisible(true);
			            text_appd_next.setVisible(true);
			        }
			    });
				bg.add(rb_appd_req);
				
				JLabel lbl_appd_vol = new JLabel("Volumn :");
				lbl_appd_vol.setBounds(358, 75, 56, 16);
				lbl_appd_vol.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_vol);
				
				JTextField text_appd_vol = new JTextField();
				text_appd_vol.setBounds(414, 70, 116, 26);
				append_panel.add(text_appd_vol);
				text_appd_vol.setColumns(10);
				
				JRadioButton rb_appd_purchase = new JRadioButton("Purchase");
				rb_appd_purchase.setBounds(137, 102, 110, 23);
				append_panel.add(rb_appd_purchase);
				rb_appd_purchase.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_appd_result.setVisible(false);
			            text_appd_result.setVisible(false);
			            
			            lbl_appd_price.setVisible(true);
			            text_appd_price.setVisible(true);
			            
			            lbl_appd_esd.setVisible(true);
			            text_appd_esd.setVisible(true);
			            
			            lbl_appd_last.setVisible(true);
			            text_appd_last.setVisible(true);
			            
			            lbl_appd_next.setVisible(true);
			            text_appd_next.setVisible(true);
			        }
			    });
				bg.add(rb_appd_purchase);
				
				JLabel lbl_appd_date = new JLabel("Realized Date :");
				lbl_appd_date.setBounds(280, 106, 134, 16);
				lbl_appd_date.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_date);
				
				JTextField text_appd_date = new JTextField();
				text_appd_date.setBounds(414, 101, 116, 26);
				append_panel.add(text_appd_date);
				text_appd_date.setColumns(10);
				
				JRadioButton rb_appd_exam = new JRadioButton("Examination");
				rb_appd_exam.setBounds(137, 133, 110, 23);
				append_panel.add(rb_appd_exam);
				rb_appd_exam.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_appd_result.setVisible(true);
			            text_appd_result.setVisible(true);
			            
			            lbl_appd_price.setVisible(false);
			            text_appd_price.setVisible(false);
			            
			            lbl_appd_esd.setVisible(false);
			            text_appd_esd.setVisible(false);
			            
			            lbl_appd_last.setVisible(true);
			            text_appd_last.setVisible(true);
			            
			            lbl_appd_next.setVisible(true);
			            text_appd_next.setVisible(true);
			        }
			    });
				bg.add(rb_appd_exam);
				
				lbl_appd_next = new JLabel("Next sheet :");
				lbl_appd_next.setBounds(280, 137, 134, 16);
				lbl_appd_next.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_next);
				
				text_appd_next = new JTextField();
				text_appd_next.setBounds(414, 132, 116, 26);
				append_panel.add(text_appd_next);
				text_appd_next.setColumns(10);
				
				JRadioButton rb_appd_receipt = new JRadioButton("Receipt");
				rb_appd_receipt.setBounds(137, 164, 110, 23);
				append_panel.add(rb_appd_receipt);
				rb_appd_receipt.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_appd_result.setVisible(false);
			            text_appd_result.setVisible(false);
			            
			            lbl_appd_price.setVisible(false);
			            text_appd_price.setVisible(false);
			            
			            lbl_appd_esd.setVisible(false);
			            text_appd_esd.setVisible(false);
			            
			            lbl_appd_last.setVisible(true);
			            text_appd_last.setVisible(true);
			            
			            lbl_appd_next.setVisible(false);
			            text_appd_next.setVisible(false);
			        }
			    });
				bg.add(rb_appd_receipt);
				
				lbl_appd_last = new JLabel("Last sheet :");
				lbl_appd_last.setBounds(341, 168, 73, 16);
				lbl_appd_last.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_last);
				
				text_appd_last = new JTextField();
				text_appd_last.setBounds(414, 163, 116, 26);
				append_panel.add(text_appd_last);
				text_appd_last.setColumns(10);
				
				lbl_appd_price = new JLabel("Price :");
				lbl_appd_price.setBounds(376, 200, 38, 16);
				lbl_appd_price.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_price);
				
				text_appd_price = new JTextField();
				text_appd_price.setBounds(414, 195, 116, 26);
				append_panel.add(text_appd_price);
				text_appd_price.setColumns(10);
				
				lbl_appd_esd = new JLabel("Estimated Ship Date :");
				lbl_appd_esd.setBounds(280, 233, 134, 16);
				lbl_appd_esd.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_esd);  
				
				text_appd_esd = new JTextField();
				text_appd_esd.setBounds(414, 228, 116, 26);
				append_panel.add(text_appd_esd);
				text_appd_esd.setColumns(10);
				
				lbl_appd_result = new JLabel("Exam Result :");
				lbl_appd_result.setBounds(329, 266, 85, 16);
				lbl_appd_result.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_appd_result);
				
				text_appd_result = new JTextField();
				text_appd_result.setBounds(414, 261, 116, 26);
				append_panel.add(text_appd_result);
				text_appd_result.setColumns(10);
				
				appd_table = new JTable();
				appd_table.setBounds(33, 292, 603, 49);
				append_panel.add(appd_table);
				
			}
			
			//forth panel - remove sheet
			private void add_remove_panel() {
						
				remove_panel = new JPanel();
				remove_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(remove_panel, "Remove");
				remove_panel.setLayout(null);
				
				JLabel lbl_remv_sheetID = new JLabel("*sheet ID :");
				lbl_remv_sheetID.setBounds(81, 41, 67, 16);
				remove_panel.add(lbl_remv_sheetID);
				
				JTextField text_remv_sheetID = new JTextField();
				text_remv_sheetID.setBounds(167, 36, 146, 26);
				remove_panel.add(text_remv_sheetID);
				text_remv_sheetID.setColumns(10);
				
				JButton btn_remv_remove = new JButton("Remove");
				btn_remv_remove.setBounds(494, 35, 93, 29);
				btn_remv_remove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//library.btn_remove();
						remv_table.setVisible(true);
						lbl_remv_confirm.setVisible(true);
						text_remv_confirm.setVisible(true);
						btn_remv_confirm.setVisible(true);
					}
				});
				remove_panel.add(btn_remv_remove);
				
				remv_table = new JTable();
				remv_table.setBounds(81, 159, 506, 25);
				remove_panel.add(remv_table);
				remv_table.setVisible(false);
				
				lbl_remv_confirm = new JLabel("Please write down \"I'm PRETTY SURE that I would like to remove this sheet.\"");
				lbl_remv_confirm.setBounds(81, 189, 506, 16);
				remove_panel.add(lbl_remv_confirm);
				lbl_remv_confirm.setVisible(false);
				
				text_remv_confirm = new JTextField();
				text_remv_confirm.setBounds(81, 210, 506, 26);
				remove_panel.add(text_remv_confirm);
				text_remv_confirm.setColumns(10);
				text_remv_confirm.setVisible(false);
				
				btn_remv_confirm = new JButton("Confirm");
				btn_remv_confirm.setBounds(494, 301, 93, 29);
				remove_panel.add(btn_remv_confirm);
				btn_remv_confirm.setVisible(false);
		
				}
			
			//fifth panel - sign sheet only supervisor
			private void add_sign_panel() {
					
					sign_panel = new JPanel();
					sign_panel.setBounds(0, 0, 666, 348);
					sheet_container_panel.add(sign_panel, "Signature");
					sign_panel.setLayout(null);
					
					
					lbl_sign_sorry = new JLabel("Sorry, no right to access this page, work harder for the promotion.");
					lbl_sign_sorry.setBounds(62, 34, 517, 16);
					sign_panel.add(lbl_sign_sorry);
					//lbl_sorry.setVisible(true);
					
					lbl_sign_instr = new JLabel("Please sign the sheets below after reading.");
					lbl_sign_instr.setBounds(62, 68, 411, 16);
					sign_panel.add(lbl_sign_instr);
					//lbl_instruction.setVisible(true);
					
					sign_table = new JTable();
					sign_table.setBounds(62, 97, 546, 192);
					sign_panel.add(sign_table);
					//sign_table.setVisible(true);
					
					btn_sign_sign = new JButton("Sign all");
					btn_sign_sign.setBounds(497, 301, 112, 29);
					sign_panel.add(btn_sign_sign);
					//btn_sign.setVisible(true);
					
					btn_sign_refresh = new JButton("Refresh");
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
				
			switch(Term_project_main.lib.check_text_fields(first, second,third)) {
			
				
				case "011":
					try {
						ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
								+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
								+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
								+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
								+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
								+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
								+ "AND EXAM.Module_type = PUR.Module_type)\n"
								+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
								+ "AND RCPT.Module_type = EXAM.MOdule_type) WHERE (pj.Project_ID="
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
						
						ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
								+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
								+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
								+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
								+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
								+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
								+ "AND EXAM.Module_type = PUR.Module_type)\n"
								+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
								+ "AND RCPT.Module_type = EXAM.MOdule_type) WHERE pj.Project_ID ="+text_inq_projectID.getText());
						
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
						ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM  RFQ \n"
								+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
								+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
								+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
								+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
								+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
								+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
								+ "AND EXAM.Module_type = PUR.Module_type)\n"
								+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
								+ "AND RCPT.Module_type = EXAM.MOdule_type) WHERE RFQ.Inquiring_product ="+text_inq_pd.getText());
						
						while(r.next()) {
							
							if(r.getString(1)!= null) {
								
								String [] rfq = new String[7];
								for(int i =1; i<8;i++) {

									rfq[i-1]=r.getString(i);		
								}
								temp.add(rfq);
								
								if(r.getString(8)!= null) {
									
									String [] quo = new String[10];
									for(int i =8; i<18;i++) {
										
										quo[i-8]=r.getString(i);		
									}
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
					
					
					switch(Term_project_main.lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE (RFQ_Sheet_ID="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE (RFQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");
	
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE (RFQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE RFQ_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE (Project_ID ="
														+text_inq_projectID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "010":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE Project_ID ="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE Inquiring_product=\'"
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
							
							for(int i=1;i<7;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
					
				case "QUO":
					
					switch(Term_project_main.lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE (QUO_Sheet_ID="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE (QUO_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE (QUO_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE QUO_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE (Project_ID ="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE Project_ID ="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE Inquiring_product=\'"
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
							
							String[] temp_array = new String[10];
							
							for(int i=1;i<10;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				
				case "REQ":
					
					switch(Term_project_main.lib.check_text_fields(first, second, third)) {
					
						case "111":
							
						try {
							r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE (REQ_Sheet_ID="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE (REQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Project_ID ="+text_inq_projectID.getText()+")");

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "101":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE (REQ_Sheet_ID="
												+text_inq_sheetID.getText()+" AND Inquiring_product=\'"+text_inq_pd.getText()+"\')");
								
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
						
						case "100":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE REQ_Sheet_ID="
																						+text_inq_sheetID.getText());

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								r=null;
							}
							break;
							
						case "011":
							
							try {
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE (Project_ID ="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE Project_ID ="
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
								r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE Inquiring_product=\'"
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
							
							for(int i=1;i<11;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case "PUR":
					
					switch(Term_project_main.lib.check_text_fields(first, second, third)) {
					
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
							
							for(int i=1;i<9;i++) 
								temp_array[i-1]=r.getString(i);
							
							temp.add(temp_array);								
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				case "EXAM":
					
					switch(Term_project_main.lib.check_text_fields(first, second, third)) {
					
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
							
							for(int i=1;i<7;i++) 
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
					
					switch(Term_project_main.lib.check_text_fields(first, second, third)) {
					
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
							
							for(int i=1;i<6;i++) 
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
	
	
	
	private int modify() {
		
		
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
															+"\' WHERE (EXA_Sheet_ID="+lbl_mod_sheetID_show.getText()+" AND Project_ID="
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
	
	
	private ArrayList<String> check() {
		
		ArrayList<String> temp = new ArrayList();
		
		if(text_mod_sheetID.getText().isBlank() | text_mod_projectID.getText().isBlank() | text_mod_pd.getText().isBlank()) {

			return temp;
		}
		
		int id = Integer.parseInt(text_mod_sheetID.getText());
		
		if (id>=21000000 & id< 22000000) {
			
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM RFQ WHERE (RFQ_Sheet_ID="+text_mod_sheetID.getText()+
												" AND Project_ID="+text_mod_projectID.getText()+" AND Inquiring_product=\'"+text_mod_pd.getText()
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
				
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM QUOTATION WHERE (QUO_Sheet_ID="+text_mod_sheetID.getText()+
												" AND Project_ID="+text_mod_projectID.getText()+" AND Inquiring_product=\'"+text_mod_pd.getText()
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
			
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM REQUISITION WHERE (REQ_Sheet_ID="+text_mod_sheetID.getText()+
												" AND Project_ID="+text_mod_projectID.getText()+" AND Inquiring_product=\'"+text_mod_pd.getText()
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
				
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM PURCHASE WHERE (PUR_Sheet_ID="+text_mod_sheetID.getText()+
												" AND Project_ID="+text_mod_projectID.getText()+" AND Module_type=\'"+text_mod_pd.getText()
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
				
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM EXAMINATION WHERE (EX_Sheet_ID="+text_mod_sheetID.getText()+
												" AND Project_ID="+text_mod_projectID.getText()+" AND Module_type=\'"+text_mod_pd.getText()
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
				
			try {	
				
				ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM RECEIPT WHERE (REC_Sheet_ID="+text_mod_sheetID.getText()+
												" AND Project_ID="+text_mod_projectID.getText()+" AND Module_type=\'"+text_mod_pd.getText()
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
