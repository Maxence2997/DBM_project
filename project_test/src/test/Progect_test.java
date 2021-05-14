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
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.SystemColor;

public class Progect_test {

	private JFrame frame;
	
	private JPanel login_panel;
	private JPanel home_panel;
	
	private JPanel core_home_panel;
	private JPanel core_order_panel;
	private JPanel container_panel;
	private JPanel order_container_panel;
	private JPanel inq_panel;
	private JPanel mod_panel;
	
	private CardLayout card_layout;
	private CardLayout cl_home;
	private CardLayout cl_order;
	//private JLabel label_empID;
	
	private JTextField field_empID;
	private JTable table;
	
	
	
	
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
			
			JButton btn_reminder = new JButton("R");
			home_panel.add(btn_reminder, "3, 1, fill, fill");
			
			cl_home = new CardLayout();
			container_panel = new JPanel(cl_home);
			container_panel.setBackground(Color.CYAN);
			home_panel.add(container_panel, "1, 2, 3, 1, fill, fill");
			
			home_core_panel();
			order_panels();
			
			home_panel.add(btn_logout, "1, 3, left, top");
		}
		
		
		
		private void home_core_panel() {
			
			
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
			
			JLabel lbl_invent = new JLabel("Inquire Inventory, Modify Volumn");
			lbl_invent.setBounds(227, 195, 352, 16);
			core_home_panel.add(lbl_invent);
			
			JButton btn_sup = new JButton("Supplier");
			btn_sup.setBounds(91, 283, 103, 29);
			core_home_panel.add(btn_sup);
			
			JLabel lbl_sup = new JLabel("Inquire Suppliers' information");
			lbl_sup.setBounds(227, 289, 352, 16);
			core_home_panel.add(lbl_sup);
			
		}
		
		private void order_panels() {
			
			
			core_order_panel = new JPanel();
			container_panel.add(core_order_panel,"order");
			core_order_panel.setLayout(null);
			
			order_container_panel = new JPanel(cl_order);
			order_container_panel.setBounds(0, 35, 666, 348);
			order_container_panel.setBackground(Color.CYAN);
			core_order_panel.add(order_container_panel);
			order_container_panel.setLayout(null);
			
			
			//default panel - Inquire order
			/*inq_panel = new JPanel();
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
			
			JLabel lbl_date = new JLabel("Order Date :");
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
			
			table = new JTable();
			table.setBounds(29, 94, 612, 254);
			inq_panel.add(table);*/
			
			//Second panel - Modify order
			mod_panel = new JPanel();
			mod_panel.setBounds(0, 0, 666, 348);
			order_container_panel.add(mod_panel, "inquire");
			mod_panel.setLayout(new FormLayout(new ColumnSpec[] {
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,
					FormSpecs.RELATED_GAP_COLSPEC,
					FormSpecs.DEFAULT_COLSPEC,},
				new RowSpec[] {
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.RELATED_GAP_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,}));
			
			JLabel lbl_orderID = new JLabel("*Order ID :");
			mod_panel.add(lbl_orderID, "4, 4");
			
			JLabel lblNewLabel = new JLabel("New label");
			mod_panel.add(lblNewLabel, "4, 8");
			
			
			
		}
		
		
		
}
