package test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Sheets_panel  {
	
	private JTable inq_table;
	private JTable mod_table;
	private JTable append_table;	
	private JTable remove_table;
	private JTable sign_table;
	
	
	public JPanel core_sheet_panel;
	
	private JPanel sheet_container_panel;
	private JPanel default_panel;
	private JPanel inq_panel;
	private JPanel mod_panel;
	private JPanel remove_panel;
	private JLabel lbl_confirm;
	private JTextField text_confirm;
	private JButton btn_confirm;
	
	
	private JPanel sign_panel;
	private JLabel lbl_sorry;
	private JLabel lbl_instruction;
	private JButton btn_sign;
	private JButton btn_refresh;
	
	private JPanel append_panel;
	private JLabel lbl_price;
	private JTextField text_price;
	private JLabel lbl_esd;
	private JTextField text_esd;
	private JLabel lbl_result;
	private JTextField text_result;
	private JLabel lbl_next_sheet;
	private JTextField text_next_sheet;
	private JLabel lbl_last_sheet;
	private JTextField text_last_sheet;
	
	private JComboBox comboBox_sheets;
	
	
	private CardLayout cl_sheet;
	
	
	public Sheets_panel() {
		
		panels();

	}
	
	
	
	
	private void panels() {
				
				//core sheet panel which contains comboBox
				core_sheet_panel = new JPanel();
				Project_test.container_panel.add(core_sheet_panel,"sheets");
				core_sheet_panel.setLayout(null);
				
				//smaller panel on the core sheet panel
				cl_sheet = new CardLayout();
				sheet_container_panel = new JPanel(cl_sheet);
				
				sheet_container_panel.setBounds(0, 35, 666, 348);
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
				comboBox_sheets.setBounds(23, 6, 126, 27);
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
				
						
				JLabel lbl_sheetID = new JLabel("sheet ID :");
				lbl_sheetID.setBounds(76, 11, 60, 16);
				inq_panel.add(lbl_sheetID);
						
				JTextField text_sheetID = new JTextField();
				text_sheetID.setBounds(136, 6, 141, 26);
				inq_panel.add(text_sheetID);
				text_sheetID.setColumns(10);
						
				JLabel lbl_date = new JLabel("Realized Date :");
				lbl_date.setBounds(310, 11, 106, 16);
				lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
				inq_panel.add(lbl_date);
						
				JTextField text_date = new JTextField();
				text_date.setBounds(416, 6, 105, 26);
				inq_panel.add(text_date);
				text_date.setColumns(10);
						
				JButton btn_inquire = new JButton("Inquire");
				btn_inquire.setBounds(554, 5, 87, 29);
				btn_inquire.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//library.btn_inquire();
						inq_table.setVisible(true);
					}
				});
				inq_panel.add(btn_inquire);
						
				JLabel lbl_empID = new JLabel("Employee ID :");
				lbl_empID.setBounds(50, 45, 86, 16);
				inq_panel.add(lbl_empID);
						
				JTextField textField = new JTextField();
				textField.setBounds(136, 40, 141, 26);
				inq_panel.add(textField);
				textField.setColumns(10);
						
				JLabel lbl_product = new JLabel("Product Module :");
				lbl_product.setBounds(310, 45, 106, 16);
				inq_panel.add(lbl_product);
						
				JTextField textField_1 = new JTextField();
				textField_1.setBounds(416, 40, 105, 26);
				inq_panel.add(textField_1);
				textField_1.setColumns(10);
						
				JButton btn_last20 = new JButton("Last 20");
				btn_last20.setBounds(554, 39, 87, 29);
				btn_last20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//library.btn_inquire();
						inq_table.setVisible(true);
					}
				});
				inq_panel.add(btn_last20);
						
				JLabel lbl_note = new JLabel("Note : To inquire sheets, at least one of sheet ID and Employee ID must be filled in  ");
				lbl_note.setBounds(29, 73, 529, 16);
				inq_panel.add(lbl_note);
						
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
				
				JLabel lbl_sheetID = new JLabel("*sheet ID :");
				lbl_sheetID.setBounds(72, 41, 67, 16);
				mod_panel.add(lbl_sheetID);
				
				JTextField text_sheetID = new JTextField();
				text_sheetID.setBounds(143, 36, 115, 26);
				mod_panel.add(text_sheetID);
				text_sheetID.setColumns(10);
				
				JLabel lbl_next_sheet = new JLabel("Next sheet ID :");
				lbl_next_sheet.setBounds(292, 41, 95, 16);
				lbl_next_sheet.setHorizontalAlignment(SwingConstants.RIGHT);
				mod_panel.add(lbl_next_sheet);
				
				JTextField text_next_sheet = new JTextField();
				text_next_sheet.setBounds(391, 36, 115, 26);
				mod_panel.add(text_next_sheet);
				text_next_sheet.setColumns(10);
				
				JButton btn_modify = new JButton("Modify");
				btn_modify.setBounds(539, 35, 87, 29);
				mod_panel.add(btn_modify);
				
				JLabel lbl_empID = new JLabel("Employee ID :");
				lbl_empID.setBounds(53, 104, 86, 16);
				mod_panel.add(lbl_empID);
				
				JTextField textField = new JTextField();
				textField.setBounds(143, 99, 115, 26);
				mod_panel.add(textField);
				textField.setColumns(10);
				
				JLabel lbl_last_sheet = new JLabel("Last sheet ID :");
				lbl_last_sheet.setBounds(296, 104, 91, 16);
				lbl_last_sheet.setHorizontalAlignment(SwingConstants.RIGHT);
				mod_panel.add(lbl_last_sheet);
				
				JTextField text_last_sheet = new JTextField();
				text_last_sheet.setBounds(391, 99, 115, 26);
				mod_panel.add(text_last_sheet);
				text_last_sheet.setColumns(10);
				
				JLabel lbl_productID = new JLabel("Product Module :");
				lbl_productID.setBounds(33, 165, 106, 16);
				mod_panel.add(lbl_productID);
				
				JTextField text_productID = new JTextField();
				text_productID.setBounds(143, 160, 115, 26);
				mod_panel.add(text_productID);
				text_productID.setColumns(10);
				
				JLabel lbl_date = new JLabel("Realized Date :");
				lbl_date.setBounds(299, 165, 88, 16);
				lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
				mod_panel.add(lbl_date);
				
				JTextField text_date = new JTextField();
				text_date.setBounds(391, 160, 115, 26);
				mod_panel.add(text_date);
				text_date.setColumns(10);
				
				JLabel lbl_vol = new JLabel("Vol. :");
				lbl_vol.setBounds(83, 226, 56, 16);
				mod_panel.add(lbl_vol);
				
				JTextField text_vol = new JTextField();
				text_vol.setBounds(143, 221, 115, 26);
				mod_panel.add(text_vol);
				text_vol.setColumns(10);
				
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
				
				JLabel lbl_sheet_type = new JLabel("*Oder type:");
				lbl_sheet_type.setBounds(62, 11, 71, 16);
				lbl_sheet_type.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_sheet_type);
				
				ButtonGroup bg = new ButtonGroup();
				
				JRadioButton rb_RFQ = new JRadioButton("R.F.Q");
				rb_RFQ.setBounds(137, 8, 110, 23);
				append_panel.add(rb_RFQ);
				rb_RFQ.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			            lbl_price.setVisible(false);
			            text_price.setVisible(false);
			            
			            lbl_esd.setVisible(false);
			            text_esd.setVisible(false);
			            
			            lbl_result.setVisible(false);
			            text_result.setVisible(false);
			            
			            lbl_last_sheet.setVisible(false);
			            text_last_sheet.setVisible(false);
			            
			            lbl_next_sheet.setVisible(true);
			            text_next_sheet.setVisible(true);
			            
			        }
			    });
				bg.add(rb_RFQ);
				
				JLabel lbl_empID = new JLabel("Employee ID :");
				lbl_empID.setBounds(280, 11, 134, 16);
				lbl_empID.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_empID);
				
				JTextField text_empID = new JTextField();
				text_empID.setBounds(414, 6, 116, 26);
				append_panel.add(text_empID);
				text_empID.setColumns(10);
				
				JButton btn_append = new JButton("Append");
				btn_append.setBounds(563, 5, 92, 29);
				append_panel.add(btn_append);
				
				JRadioButton rb_quotation = new JRadioButton("Quotation");
				rb_quotation.setBounds(137, 40, 110, 23);
				append_panel.add(rb_quotation);
				
				rb_quotation.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_result.setVisible(false);
			            text_result.setVisible(false);
			            
			            lbl_price.setVisible(true);
			            text_price.setVisible(true);
			            
			            lbl_esd.setVisible(true);
			            text_esd.setVisible(true);
			            
			            lbl_last_sheet.setVisible(true);
			            text_last_sheet.setVisible(true);
			            
			            lbl_next_sheet.setVisible(true);
			            text_next_sheet.setVisible(true);
			            
			        }
			    });
				bg.add(rb_quotation);
				
				JLabel lbl_product = new JLabel("Product Module :");
				lbl_product.setBounds(280, 44, 134, 16);
				lbl_product.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_product);
				
				JTextField textField = new JTextField();
				textField.setBounds(414, 39, 116, 26);
				append_panel.add(textField);
				textField.setColumns(10);
				
				JRadioButton rb_req = new JRadioButton("Requisition");
				rb_req.setBounds(137, 71, 110, 23);
				append_panel.add(rb_req);
				rb_req.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_price.setVisible(false);
			            text_price.setVisible(false);
			            
			            lbl_esd.setVisible(false);
			            text_esd.setVisible(false);
			            
			            lbl_result.setVisible(false);
			            text_result.setVisible(false);
			            
			            lbl_last_sheet.setVisible(true);
			            text_last_sheet.setVisible(true);
			            
			            lbl_next_sheet.setVisible(true);
			            text_next_sheet.setVisible(true);
			        }
			    });
				bg.add(rb_req);
				
				JLabel lbl_vol = new JLabel("Volumn :");
				lbl_vol.setBounds(358, 75, 56, 16);
				lbl_vol.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_vol);
				
				JTextField text_vol = new JTextField();
				text_vol.setBounds(414, 70, 116, 26);
				append_panel.add(text_vol);
				text_vol.setColumns(10);
				
				JRadioButton rb_purchase = new JRadioButton("Purchase");
				rb_purchase.setBounds(137, 102, 110, 23);
				append_panel.add(rb_purchase);
				rb_purchase.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_result.setVisible(false);
			            text_result.setVisible(false);
			            
			            lbl_price.setVisible(true);
			            text_price.setVisible(true);
			            
			            lbl_esd.setVisible(true);
			            text_esd.setVisible(true);
			            
			            lbl_last_sheet.setVisible(true);
			            text_last_sheet.setVisible(true);
			            
			            lbl_next_sheet.setVisible(true);
			            text_next_sheet.setVisible(true);
			        }
			    });
				bg.add(rb_purchase);
				
				JLabel lbl_date = new JLabel("Realized Date :");
				lbl_date.setBounds(280, 106, 134, 16);
				lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_date);
				
				JTextField text_date = new JTextField();
				text_date.setBounds(414, 101, 116, 26);
				append_panel.add(text_date);
				text_date.setColumns(10);
				
				JRadioButton rb_exam = new JRadioButton("Examination");
				rb_exam.setBounds(137, 133, 110, 23);
				append_panel.add(rb_exam);
				rb_exam.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_result.setVisible(true);
			            text_result.setVisible(true);
			            
			            lbl_price.setVisible(false);
			            text_price.setVisible(false);
			            
			            lbl_esd.setVisible(false);
			            text_esd.setVisible(false);
			            
			            lbl_last_sheet.setVisible(true);
			            text_last_sheet.setVisible(true);
			            
			            lbl_next_sheet.setVisible(true);
			            text_next_sheet.setVisible(true);
			        }
			    });
				bg.add(rb_exam);
				
				lbl_next_sheet = new JLabel("Next sheet :");
				lbl_next_sheet.setBounds(280, 137, 134, 16);
				lbl_next_sheet.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_next_sheet);
				
				text_next_sheet = new JTextField();
				text_next_sheet.setBounds(414, 132, 116, 26);
				append_panel.add(text_next_sheet);
				text_next_sheet.setColumns(10);
				
				JRadioButton rb_receipt = new JRadioButton("Receipt");
				rb_receipt.setBounds(137, 164, 110, 23);
				append_panel.add(rb_receipt);
				rb_receipt.addActionListener(new ActionListener() {
			        @Override
			        public void actionPerformed(ActionEvent e) {
			        	lbl_result.setVisible(false);
			            text_result.setVisible(false);
			            
			            lbl_price.setVisible(false);
			            text_price.setVisible(false);
			            
			            lbl_esd.setVisible(false);
			            text_esd.setVisible(false);
			            
			            lbl_last_sheet.setVisible(true);
			            text_last_sheet.setVisible(true);
			            
			            lbl_next_sheet.setVisible(false);
			            text_next_sheet.setVisible(false);
			        }
			    });
				bg.add(rb_receipt);
				
				lbl_last_sheet = new JLabel("Last sheet :");
				lbl_last_sheet.setBounds(341, 168, 73, 16);
				lbl_last_sheet.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_last_sheet);
				
				text_last_sheet = new JTextField();
				text_last_sheet.setBounds(414, 163, 116, 26);
				append_panel.add(text_last_sheet);
				text_last_sheet.setColumns(10);
				
				lbl_price = new JLabel("Price :");
				lbl_price.setBounds(376, 200, 38, 16);
				lbl_price.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_price);
				
				text_price = new JTextField();
				text_price.setBounds(414, 195, 116, 26);
				append_panel.add(text_price);
				text_price.setColumns(10);
				
				lbl_esd = new JLabel("Estimated Ship Date :");
				lbl_esd.setBounds(280, 233, 134, 16);
				lbl_esd.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_esd);  
				
				text_esd = new JTextField();
				text_esd.setBounds(414, 228, 116, 26);
				append_panel.add(text_esd);
				text_esd.setColumns(10);
				
				lbl_result = new JLabel("Exam Result :");
				lbl_result.setBounds(329, 266, 85, 16);
				lbl_result.setHorizontalAlignment(SwingConstants.RIGHT);
				append_panel.add(lbl_result);
				
				text_result = new JTextField();
				text_result.setBounds(414, 261, 116, 26);
				append_panel.add(text_result);
				text_result.setColumns(10);
				
				append_table = new JTable();
				append_table.setBounds(33, 292, 603, 49);
				append_panel.add(append_table);
				
			}
			
			//forth panel - remove sheet
			private void add_remove_panel() {
						
				remove_panel = new JPanel();
				remove_panel.setBounds(0, 0, 666, 348);
				sheet_container_panel.add(remove_panel, "Remove");
				remove_panel.setLayout(null);
				
				JLabel lbl_sheetID = new JLabel("*sheet ID :");
				lbl_sheetID.setBounds(81, 41, 67, 16);
				remove_panel.add(lbl_sheetID);
				
				JTextField text_sheetID = new JTextField();
				text_sheetID.setBounds(167, 36, 146, 26);
				remove_panel.add(text_sheetID);
				text_sheetID.setColumns(10);
				
				JButton btn_remove = new JButton("Remove");
				btn_remove.setBounds(494, 35, 93, 29);
				btn_remove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						//library.btn_remove();
						remove_table.setVisible(true);
						lbl_confirm.setVisible(true);
						text_confirm.setVisible(true);
						btn_confirm.setVisible(true);
					}
				});
				remove_panel.add(btn_remove);
				
				remove_table = new JTable();
				remove_table.setBounds(81, 159, 506, 25);
				remove_panel.add(remove_table);
				remove_table.setVisible(false);
				
				lbl_confirm = new JLabel("Please write down \"I'm PRETTY SURE that I would like to remove this sheet.\"");
				lbl_confirm.setBounds(81, 189, 506, 16);
				remove_panel.add(lbl_confirm);
				lbl_confirm.setVisible(false);
				
				text_confirm = new JTextField();
				text_confirm.setBounds(81, 210, 506, 26);
				remove_panel.add(text_confirm);
				text_confirm.setColumns(10);
				text_confirm.setVisible(false);
				
				btn_confirm = new JButton("Confirm");
				btn_confirm.setBounds(494, 301, 93, 29);
				remove_panel.add(btn_confirm);
				btn_confirm.setVisible(false);
		
				}
			
			//fifth panel - sign sheet only supervisor
			private void add_sign_panel() {
					
					sign_panel = new JPanel();
					sign_panel.setBounds(0, 0, 666, 348);
					sheet_container_panel.add(sign_panel, "Signature");
					sign_panel.setLayout(null);
					
					
					lbl_sorry = new JLabel("Sorry, no right to access this page, work harder for the promotion.");
					lbl_sorry.setBounds(62, 34, 517, 16);
					sign_panel.add(lbl_sorry);
					//lbl_sorry.setVisible(true);
					
					lbl_instruction = new JLabel("Please sign the sheets below after reading.");
					lbl_instruction.setBounds(62, 68, 411, 16);
					sign_panel.add(lbl_instruction);
					//lbl_instruction.setVisible(true);
					
					sign_table = new JTable();
					sign_table.setBounds(62, 97, 546, 192);
					sign_panel.add(sign_table);
					//sign_table.setVisible(true);
					
					btn_sign = new JButton("Sign all");
					btn_sign.setBounds(497, 301, 112, 29);
					sign_panel.add(btn_sign);
					//btn_sign.setVisible(true);
					
					btn_refresh = new JButton("Refresh");
					btn_refresh.setBounds(497, 63, 112, 29);
					sign_panel.add(btn_refresh);
					//btn_refresh.setVisible(true);
					
					
			}
			
			public JComboBox get_comboBox_sheets() {
				
				return comboBox_sheets;
			}
}
