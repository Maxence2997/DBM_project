package test;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Progect_test {

	private JFrame frame;
	
	private JPanel login_panel;
	private JPanel home_panel;
	private JTextField field_empID;
	
	private JPanel core_home_panel;
	private JPanel core_order_panel;
	private JPanel container_panel;
	private JPanel order_container_panel;
	private JPanel inq_panel;
	private JPanel mod_panel;
	
	private JPanel append_panel;
	private JLabel lbl_price;
	private JTextField text_price;
	private JLabel lbl_esd;
	private JTextField text_esd;
	private JLabel lbl_result;
	private JTextField text_result;
	private JLabel lbl_next_order;
	private JTextField text_next_order;
	private JLabel lbl_last_order;
	private JTextField text_last_order;
	
	
	private CardLayout card_layout;
	private CardLayout cl_home;
	private CardLayout cl_order;
	//private JLabel label_empID;
	
	
	private JTable inq_table;
	private JTable mod_table;
	private JTable append_table;
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				  
				/*try {
					connection conn = new connection(); 
					conn.instruction("sss");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
				try {
					Progect_test window = new Progect_test();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Progect_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("System");
		frame.setBounds(100, 100, 666, 466);
		
		card_layout = new CardLayout();
		
		frame.getContentPane().setLayout(card_layout);
		
		
		login_panel();
		home_panel();
		//order_panel();
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		private boolean verification(JTextField field_empID2) {
			/** To Verify if the ID inputed by user is registered in EMPLOYEE or not
			 **/
			
				
			
			return false;
		}
		
		private void login_panel() {
			
			
			login_panel = new JPanel();
			frame.getContentPane().add(login_panel,"login");
			login_panel.setLayout(null);
			
			
			JLabel label_empID = new JLabel("Employee ID :");
			label_empID.setBounds(100, 191, 104, 16);
			login_panel.add(label_empID);
			
			field_empID = new JTextField();
			field_empID.setBounds(229, 186, 163, 26);
			login_panel.add(field_empID);
			field_empID.setColumns(10);
			
			JLabel login_result = new JLabel("");
			login_result.setBounds(201, 245, 245, 26);
			login_panel.add(login_result);
			
			
			JButton button_login = new JButton("Log-in");
			button_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (verification(field_empID) == true){
						
						login_result.setText("Employee ID is invalid, please refill it.");
					}
					else {
						card_layout.show(frame.getContentPane(), "home");
					}
				}
				
				
			});
			button_login.setBounds(421, 186, 117, 29);
			login_panel.add(button_login);
			
			
		}
		
		
		private void home_panel() {
			
			home_panel = new JPanel();
			frame.getContentPane().add(home_panel, "home");
			home_panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("179px"),
					ColumnSpec.decode("447px"),
					ColumnSpec.decode("40px"),},
				new RowSpec[] {
					RowSpec.decode("26px"),
					RowSpec.decode("383px"),
					RowSpec.decode("29px"),}));
			
			JLabel lbl_empID = new JLabel(" Employee ID: " + field_empID.getText());
			home_panel.add(lbl_empID, "1, 1, fill, center");
			
			
			JButton btn_logout = new JButton("Log-out");
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					card_layout.show(frame.getContentPane(),"login");
				}
			});
			home_panel.add(btn_logout, "1, 3, left, top");
			
			JButton btn_reminder = new JButton("R");
			home_panel.add(btn_reminder, "3, 1, fill, fill");
			
			cl_home = new CardLayout();
			container_panel = new JPanel(cl_home);
			container_panel.setBackground(Color.CYAN);
			home_panel.add(container_panel, "1, 2, 3, 1, fill, fill");
			
			
			
			//home_core_panel();
			core_home_panel = new JPanel();
			container_panel.add(core_home_panel,"home");
			core_home_panel.setLayout(null);
			
			JButton btn_order = new JButton("Order");
			btn_order.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl_home.show(container_panel, "order");
				}
			});
			btn_order.setBounds(91, 95, 103, 29);
			core_home_panel.add(btn_order);
			
			JLabel lbl_order = new JLabel("Inquire Order, Modify Order, Delete Order, Append Order");
			lbl_order.setBounds(227, 101, 385, 16);
			core_home_panel.add(lbl_order);
			
			JButton btn_invent = new JButton("Inventory");
			btn_invent.setBounds(91, 189, 103, 29);
			core_home_panel.add(btn_invent);
			
			JLabel lbl_invent = new JLabel("Inquire Inventory, Modify Volume");
			lbl_invent.setBounds(227, 195, 352, 16);
			core_home_panel.add(lbl_invent);
			
			JButton btn_sup = new JButton("Supplier");
			btn_sup.setBounds(91, 283, 103, 29);
			core_home_panel.add(btn_sup);
			
			JLabel lbl_sup = new JLabel("Inquire Suppliers' information");
			lbl_sup.setBounds(227, 289, 352, 16);
			core_home_panel.add(lbl_sup);
			order_panels();
			
			
		}
		
		
		
		/*private void home_core_panel() {
			
			core_home_panel = new JPanel();
			container_panel.add(core_home_panel,"home");
			core_home_panel.setLayout(null);
			
			JButton btn_order = new JButton("Order");
			btn_order.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl_home.show(container_panel, "order");
				}
			});
			btn_order.setBounds(91, 95, 103, 29);
			core_home_panel.add(btn_order);
			
			JLabel lbl_order = new JLabel("Inquire Order, Modify Order, Delete Order, Append Order");
			lbl_order.setBounds(227, 101, 385, 16);
			core_home_panel.add(lbl_order);
			
			JButton btn_invent = new JButton("Inventory");
			btn_invent.setBounds(91, 189, 103, 29);
			core_home_panel.add(btn_invent);
			
			JLabel lbl_invent = new JLabel("Inquire Inventory, Modify Volume");
			lbl_invent.setBounds(227, 195, 352, 16);
			core_home_panel.add(lbl_invent);
			
			JButton btn_sup = new JButton("Supplier");
			btn_sup.setBounds(91, 283, 103, 29);
			core_home_panel.add(btn_sup);
			
			JLabel lbl_sup = new JLabel("Inquire Suppliers' information");
			lbl_sup.setBounds(227, 289, 352, 16);
			core_home_panel.add(lbl_sup);
			
			
		}*/
		
		private void order_panels() {
			
			
			core_order_panel = new JPanel();
			container_panel.add(core_order_panel,"order");
			core_order_panel.setLayout(null);
			
			order_container_panel = new JPanel(cl_order);
			order_container_panel.setBounds(0, 35, 666, 348);
			order_container_panel.setBackground(Color.CYAN);
			core_order_panel.add(order_container_panel);
			order_container_panel.setLayout(null);
			
			add_inquire_panel();
			add_modify_panel();
			add_append_panel();
			
		}
		
		//default panel - Inquire order
		private void add_inquire_panel() {
					
			inq_panel = new JPanel();
			inq_panel.setBounds(0, 0, 666, 348);
			order_container_panel.add(inq_panel, "inquire");
			inq_panel.setLayout(null);
					
			JLabel lbl_orderID = new JLabel("Order ID :");
			lbl_orderID.setBounds(75, 11, 61, 16);
			inq_panel.add(lbl_orderID);
					
			JTextField text_orderID = new JTextField();
			text_orderID.setBounds(136, 6, 141, 26);
			inq_panel.add(text_orderID);
			text_orderID.setColumns(10);
					
			JLabel lbl_date = new JLabel("Release Date :");
			lbl_date.setBounds(340, 11, 76, 16);
			inq_panel.add(lbl_date);
					
			JTextField text_date = new JTextField();
			text_date.setBounds(416, 6, 105, 26);
			inq_panel.add(text_date);
			text_date.setColumns(10);
					
			JButton btn_inquire = new JButton("Inquire");
			btn_inquire.setBounds(554, 5, 87, 29);
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
					inq_panel.add(btn_last20);
					
					JLabel lbl_note = new JLabel("Note : To inquire orders, at least one of Order ID and Employee ID must be filled in  ");
					lbl_note.setBounds(29, 73, 550, 16);
					inq_panel.add(lbl_note);
					
					inq_table = new JTable();
					inq_table.setBounds(29, 94, 612, 254);
					inq_panel.add(inq_table);
				}
		//Second panel - Modify order
		private void add_modify_panel() {
			
			mod_panel = new JPanel();
			mod_panel.setBounds(0, 0, 666, 348);
			order_container_panel.add(mod_panel, "modify");
			mod_panel.setLayout(null);
			
			JLabel lbl_orderID = new JLabel("*Order ID :");
			lbl_orderID.setBounds(72, 41, 67, 16);
			mod_panel.add(lbl_orderID);
			
			JTextField text_orderID = new JTextField();
			text_orderID.setBounds(143, 36, 115, 26);
			mod_panel.add(text_orderID);
			text_orderID.setColumns(10);
			
			JLabel lbl_next_order = new JLabel("Next Order ID :");
			lbl_next_order.setBounds(292, 41, 95, 16);
			lbl_next_order.setHorizontalAlignment(SwingConstants.RIGHT);
			mod_panel.add(lbl_next_order);
			
			JTextField text_next_order = new JTextField();
			text_next_order.setBounds(391, 36, 115, 26);
			mod_panel.add(text_next_order);
			text_next_order.setColumns(10);
			
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
			
			JLabel lbl_last_order = new JLabel("Last Order ID :");
			lbl_last_order.setBounds(296, 104, 91, 16);
			lbl_last_order.setHorizontalAlignment(SwingConstants.RIGHT);
			mod_panel.add(lbl_last_order);
			
			JTextField text_last_order = new JTextField();
			text_last_order.setBounds(391, 99, 115, 26);
			mod_panel.add(text_last_order);
			text_last_order.setColumns(10);
			
			JLabel lbl_productID = new JLabel("Product Module :");
			lbl_productID.setBounds(33, 165, 106, 16);
			mod_panel.add(lbl_productID);
			
			JTextField textField_1 = new JTextField();
			textField_1.setBounds(143, 160, 115, 26);
			mod_panel.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lbl_date = new JLabel("Release Date :");
			lbl_date.setBounds(299, 165, 88, 16);
			lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
			mod_panel.add(lbl_date);
			
			JTextField text_date = new JTextField();
			text_date.setBounds(391, 160, 115, 26);
			mod_panel.add(text_date);
			text_date.setColumns(10);
			
			JLabel lbl_vol = new JLabel("Volume :");
			lbl_vol.setBounds(83, 226, 56, 16);
			mod_panel.add(lbl_vol);
			
			JTextField textField_2 = new JTextField();
			textField_2.setBounds(143, 221, 115, 26);
			mod_panel.add(textField_2);
			textField_2.setColumns(10);
			
			mod_table = new JTable();
			mod_table.setBounds(33, 252, 593, 66);
			mod_panel.add(mod_table);
		}
		
		
		//third panel - Append order
		private void add_append_panel() {
			
			append_panel = new JPanel();
			append_panel.setBounds(0, 0, 666, 348);
			order_container_panel.add(append_panel, "append");
			append_panel.setLayout(null);
			
			JLabel lbl_order_type = new JLabel("*Oder type:");
			lbl_order_type.setBounds(62, 11, 71, 16);
			lbl_order_type.setHorizontalAlignment(SwingConstants.RIGHT);
			append_panel.add(lbl_order_type);
			
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
		            
		            lbl_last_order.setVisible(false);
		            text_last_order.setVisible(false);
		            
		            lbl_next_order.setVisible(true);
		            text_next_order.setVisible(true);
		            
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
		            
		            lbl_last_order.setVisible(true);
		            text_last_order.setVisible(true);
		            
		            lbl_next_order.setVisible(true);
		            text_next_order.setVisible(true);
		            
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
		            
		            lbl_last_order.setVisible(true);
		            text_last_order.setVisible(true);
		            
		            lbl_next_order.setVisible(true);
		            text_next_order.setVisible(true);
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
		            
		            lbl_last_order.setVisible(true);
		            text_last_order.setVisible(true);
		            
		            lbl_next_order.setVisible(true);
		            text_next_order.setVisible(true);
		        }
		    });
			bg.add(rb_purchase);
			
			JLabel lbl_date = new JLabel("Release Date :");
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
		            
		            lbl_last_order.setVisible(true);
		            text_last_order.setVisible(true);
		            
		            lbl_next_order.setVisible(true);
		            text_next_order.setVisible(true);
		        }
		    });
			bg.add(rb_exam);
			
			lbl_next_order = new JLabel("Next Order :");
			lbl_next_order.setBounds(280, 137, 134, 16);
			lbl_next_order.setHorizontalAlignment(SwingConstants.RIGHT);
			append_panel.add(lbl_next_order);
			
			text_next_order = new JTextField();
			text_next_order.setBounds(414, 132, 116, 26);
			append_panel.add(text_next_order);
			text_next_order.setColumns(10);
			
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
		            
		            lbl_last_order.setVisible(true);
		            text_last_order.setVisible(true);
		            
		            lbl_next_order.setVisible(false);
		            text_next_order.setVisible(false);
		        }
		    });
			bg.add(rb_receipt);
			
			lbl_last_order = new JLabel("Last Order :");
			lbl_last_order.setBounds(341, 168, 73, 16);
			lbl_last_order.setHorizontalAlignment(SwingConstants.RIGHT);
			append_panel.add(lbl_last_order);
			
			text_last_order = new JTextField();
			text_last_order.setBounds(414, 163, 116, 26);
			append_panel.add(text_last_order);
			text_last_order.setColumns(10);
			
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
			append_table.setBounds(33, 292, 622, 49);
			append_panel.add(append_table);
			
		}
}
