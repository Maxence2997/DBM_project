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

public class Progect_test {

	private JFrame frame;
	
	//private JPanel login_panel;
	//private JPanel home_panel;
	private CardLayout card_layout;
	//private JLabel label_empID;
	private JTextField field_empID;
	
	/*private JTextField text_order;
	private JTextField text_sup;
	private JTextField text_inv;
	private JTextField text_;
	private JPanel order_panel;
	private JButton btn_reminder;*/
	private CardLayout cl_order;
	private JTable table;
	private JTextField text_ID;
	private JTextField text_empID;
	private JTextField text_date;
	private JTextField textField;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				  
				try {
					connection conn = new connection(); 
					conn.instruction("sss");
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
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
		order_panel();
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		private boolean verification(JTextField field_empID2) {
			/** To Verify if the ID inputed by user is registered in EMPLOYEE or not
			 **/
			
				
			
			return false;
		}
		
		private void login_panel() {
			
			
			JPanel login_panel = new JPanel();
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
					
					if (verification(field_empID) == false){
						
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
			
			JPanel home_panel = new JPanel();
			frame.getContentPane().add(home_panel, "home");
			home_panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("179px"),
					ColumnSpec.decode("48px"),
					ColumnSpec.decode("331px:grow"),
					ColumnSpec.decode("18dlu"),
					ColumnSpec.decode("21dlu"),
					FormSpecs.DEFAULT_COLSPEC,},
				new RowSpec[] {
					RowSpec.decode("26px"),
					RowSpec.decode("45px"),
					RowSpec.decode("38px"),
					FormSpecs.DEFAULT_ROWSPEC,
					RowSpec.decode("38px"),
					FormSpecs.DEFAULT_ROWSPEC,
					RowSpec.decode("38px"),
					FormSpecs.DEFAULT_ROWSPEC,
					RowSpec.decode("38px"),
					RowSpec.decode("91px:grow"),
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
			home_panel.add(btn_reminder, "5, 1");
			
			home_panel.add(btn_logout, "1, 11, left, top");
			
			JButton btn_order = new JButton("   Order   ");
			btn_order.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					card_layout.show(frame.getContentPane(), "order");
				}
			});
			home_panel.add(btn_order, "1, 3, center, center");
			
			JButton btn_sup = new JButton("  Supplier ");
			home_panel.add(btn_sup, "1, 5, center, center");
			
			JButton btn_inv = new JButton(" Inventory ");
			home_panel.add(btn_inv, "1, 7, center, bottom");
			
			JButton btnNewButton = new JButton("New button");
			home_panel.add(btnNewButton, "1, 9, center, bottom");
			
			JTextField text_order = new JTextField();
			home_panel.add(text_order, "3, 3, fill, fill");
			text_order.setColumns(10);
			
			JTextField text_sup = new JTextField();
			text_sup.setColumns(10);
			home_panel.add(text_sup, "3, 5, fill, fill");
			
			JTextField text_inv = new JTextField();
			text_inv.setColumns(10);
			home_panel.add(text_inv, "3, 7, fill, fill");
			
			JTextField text_ = new JTextField();
			text_.setColumns(10);
			home_panel.add(text_, "3, 9, fill, fill");
		}
		
		
		
		private void order_panel() {
			
			JPanel order_panel = new JPanel();
			frame.getContentPane().add(order_panel, "order");
			order_panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("179px:grow"),
					ColumnSpec.decode("48px"),
					ColumnSpec.decode("331px:grow"),
					ColumnSpec.decode("18dlu"),
					ColumnSpec.decode("21dlu"),
					FormSpecs.DEFAULT_COLSPEC,},
				new RowSpec[] {
					RowSpec.decode("26px"),
					RowSpec.decode("30px"),
					RowSpec.decode("38px"),
					RowSpec.decode("default:grow"),
					RowSpec.decode("38px"),
					FormSpecs.DEFAULT_ROWSPEC,
					RowSpec.decode("38px"),
					FormSpecs.DEFAULT_ROWSPEC,
					RowSpec.decode("38px"),
					RowSpec.decode("91px:grow"),
					RowSpec.decode("29px"),}));
			
			JLabel lbl_empID = new JLabel(" Employee ID: " + field_empID.getText());
			order_panel.add(lbl_empID, "1, 1, fill, center");
			
			JButton btn_logout = new JButton("Log-out");
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					card_layout.show(frame.getContentPane(),"login");
				}
			});
			
			JButton btn_reminder = new JButton("R");
			order_panel.add(btn_reminder, "5, 1");
			
			
			order_panel.add(btn_logout, "1, 11, left, top");
			JPanel panel = new JPanel();
			panel.setBackground(Color.CYAN);
			order_panel.add(panel, "1, 4, 6, 7, fill, fill");
			
			cl_order = new CardLayout();
			cl_order.setVgap(5);
			cl_order.setHgap(10);
			panel.setLayout(cl_order);
			
			JPanel inq_panel = new JPanel();
			inq_panel.setLayout(null);
			
			
			panel.add(inq_panel,"inquire");	
			
			JButton btn_inq = new JButton("Inquire");
			btn_inq.setBounds(552, 270, 88, 29);
			inq_panel.add(btn_inq);
			
			JButton btn_inquiire_20 = new JButton("Last 10 orders");
			btn_inquiire_20.setBounds(437, 270, 117, 29);
			inq_panel.add(btn_inquiire_20);
			
			table = new JTable();
			table.setBounds(22, 87, 607, 171);
			inq_panel.add(table);
			
			JLabel lbl_orderID = new JLabel("Order ID : ");
			lbl_orderID.setBounds(69, 6, 80, 16);
			inq_panel.add(lbl_orderID);
			
			text_ID = new JTextField();
			text_ID.setBounds(154, 1, 130, 26);
			inq_panel.add(text_ID);
			text_ID.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Employee ID :");
			lblNewLabel.setBounds(61, 43, 88, 16);
			inq_panel.add(lblNewLabel);
			
			text_empID = new JTextField();
			text_empID.setBounds(154, 39, 130, 26);
			inq_panel.add(text_empID);
			text_empID.setColumns(10);
			
			JLabel lbl_date = new JLabel("Created Dated : ");
			lbl_date.setBounds(337, 6, 101, 16);
			inq_panel.add(lbl_date);
			
			text_date = new JTextField();
			text_date.setBounds(450, 1, 130, 26);
			inq_panel.add(text_date);
			text_date.setColumns(10);
			
			JLabel lbl_product = new JLabel("Product Module :");
			lbl_product.setBounds(337, 43, 117, 16);
			inq_panel.add(lbl_product);
			
			textField = new JTextField();
			textField.setBounds(450, 38, 130, 26);
			inq_panel.add(textField);
			textField.setColumns(10);
			
			
			
			
		}
}
