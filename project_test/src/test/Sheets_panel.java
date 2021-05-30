package test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
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
	private JPanel mod_panel;
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
				
				comboBox_sheets = new JComboBox();
				comboBox_sheets.setBounds(262, 6, 120, 27);
				comboBox_sheets.addItem("--------");
				comboBox_sheets.addItem("Inquire");
				comboBox_sheets.addItem("Modify");
				comboBox_sheets.addItem("Append");
				comboBox_sheets.addItem("Remove");
				comboBox_sheets.addItem("Signature");
				
				
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
				
						
				JLabel lbl_inq_sheetID = new JLabel("sheet ID :");
				lbl_inq_sheetID.setBounds(76, 11, 60, 16);
				inq_panel.add(lbl_inq_sheetID);
						
				JTextField text_inq_sheetID = new JTextField();
				text_inq_sheetID.setBounds(136, 6, 141, 26);
				inq_panel.add(text_inq_sheetID);
				text_inq_sheetID.setColumns(10);
						
				JLabel lbl_inq_date = new JLabel("Realized Date :");
				lbl_inq_date.setBounds(310, 11, 106, 16);
				lbl_inq_date.setHorizontalAlignment(SwingConstants.RIGHT);
				inq_panel.add(lbl_inq_date);
						
				JTextField text_inq_date = new JTextField();
				text_inq_date.setBounds(416, 6, 105, 26);
				inq_panel.add(text_inq_date);
				text_inq_date.setColumns(10);
						
				JButton btn_inq_inquire = new JButton("Inquire");
				btn_inq_inquire.setBounds(554, 5, 87, 29);
				btn_inq_inquire.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//library.btn_inquire();
						inq_table.setVisible(true);
					}
				});
				inq_panel.add(btn_inq_inquire);
						
				JLabel lbl_inq_empID = new JLabel("Employee ID :");
				lbl_inq_empID.setBounds(50, 45, 86, 16);
				inq_panel.add(lbl_inq_empID);
						
				JTextField text_inq_empID = new JTextField();
				text_inq_empID.setBounds(136, 40, 141, 26);
				inq_panel.add(text_inq_empID);
				text_inq_empID.setColumns(10);
						
				JLabel lbl_inq_pd = new JLabel("Product Module :");
				lbl_inq_pd.setBounds(310, 45, 106, 16);
				inq_panel.add(lbl_inq_pd);
						
				JTextField text_inq_pd = new JTextField();
				text_inq_pd.setBounds(416, 40, 105, 26);
				inq_panel.add(text_inq_pd);
				text_inq_pd.setColumns(10);
						
				JButton btn_inq_last20 = new JButton("Last 20");
				btn_inq_last20.setBounds(554, 39, 87, 29);
				btn_inq_last20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//library.btn_inquire();
						inq_table.setVisible(true);
					}
				});
				inq_panel.add(btn_inq_last20);
						
				JLabel lbl_inq_note = new JLabel("Note : To inquire sheets, at least one of sheet ID and Employee ID must be filled in  ");
				lbl_inq_note.setBounds(29, 73, 529, 16);
				inq_panel.add(lbl_inq_note);
						
				inq_table = new JTable();
				inq_table.setBounds(29, 94, 612, 254);
				inq_panel.add(inq_table);
				inq_table.setVisible(false);
			}
			
			//Second panel - Modify sheet
			private void add_modify_panel() {
				
				mod_panel = new JPanel();
				mod_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(mod_panel, "Modify");
				mod_panel.setLayout(null);
				
				JLabel lbl_mod_sheetID = new JLabel("*sheet ID :");
				lbl_mod_sheetID.setBounds(72, 41, 67, 16);
				mod_panel.add(lbl_mod_sheetID);
				
				JTextField text_mod_sheetID = new JTextField();
				text_mod_sheetID.setBounds(143, 36, 115, 26);
				mod_panel.add(text_mod_sheetID);
				text_mod_sheetID.setColumns(10);
				
				JLabel lbl_mod_next = new JLabel("Next sheet ID :");
				lbl_mod_next.setBounds(292, 41, 95, 16);
				lbl_mod_next.setHorizontalAlignment(SwingConstants.RIGHT);
				mod_panel.add(lbl_mod_next);
				
				JTextField text_mod_next = new JTextField();
				text_mod_next.setBounds(391, 36, 115, 26);
				mod_panel.add(text_mod_next);
				text_mod_next.setColumns(10);
				
				JButton btn_mod_modify = new JButton("Modify");
				btn_mod_modify.setBounds(539, 35, 87, 29);
				mod_panel.add(btn_mod_modify);
				
				JLabel lbl_mod_empID = new JLabel("Employee ID :");
				lbl_mod_empID.setBounds(53, 104, 86, 16);
				mod_panel.add(lbl_mod_empID);
				
				JTextField text_mod_empID = new JTextField();
				text_mod_empID.setBounds(143, 99, 115, 26);
				mod_panel.add(text_mod_empID);
				text_mod_empID.setColumns(10);
				
				JLabel lbl_mod_last = new JLabel("Last sheet ID :");
				lbl_mod_last.setBounds(296, 104, 91, 16);
				lbl_mod_last.setHorizontalAlignment(SwingConstants.RIGHT);
				mod_panel.add(lbl_mod_last);
				
				JTextField text_mod_last = new JTextField();
				text_mod_last.setBounds(391, 99, 115, 26);
				mod_panel.add(text_mod_last);
				text_mod_last.setColumns(10);
				
				JLabel lbl_mod_pdID = new JLabel("Product Module :");
				lbl_mod_pdID.setBounds(33, 165, 106, 16);
				mod_panel.add(lbl_mod_pdID);
				
				JTextField text_mod_pdID = new JTextField();
				text_mod_pdID.setBounds(143, 160, 115, 26);
				mod_panel.add(text_mod_pdID);
				text_mod_pdID.setColumns(10);
				
				JLabel lbl_mod_date = new JLabel("Realized Date :");
				lbl_mod_date.setBounds(299, 165, 88, 16);
				lbl_mod_date.setHorizontalAlignment(SwingConstants.RIGHT);
				mod_panel.add(lbl_mod_date);
				
				JTextField text_mod_date = new JTextField();
				text_mod_date.setBounds(391, 160, 115, 26);
				mod_panel.add(text_mod_date);
				text_mod_date.setColumns(10);
				
				JLabel lbl_mod_vol = new JLabel("Vol. :");
				lbl_mod_vol.setBounds(83, 226, 56, 16);
				mod_panel.add(lbl_mod_vol);
				
				JTextField text_mod_vol = new JTextField();
				text_mod_vol.setBounds(143, 221, 115, 26);
				mod_panel.add(text_mod_vol);
				text_mod_vol.setColumns(10);
				
				mod_table = new JTable();
				mod_table.setBounds(33, 252, 593, 66);
				mod_panel.add(mod_table);
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
			
			public JComboBox get_comboBox_sheets() {
				
				return comboBox_sheets;
			}
}
