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
	
	private CardLayout card_layout;
	private CardLayout cl_home;
	private CardLayout cl_order;
	//private JLabel label_empID;
	
	private JTextField field_empID;
	/*private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;*/
	
	
	
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
			
			inq_panel = new JPanel();
			inq_panel.setBounds(0, 0, 666, 348);
			order_container_panel.add(inq_panel);
			inq_panel.setLayout(null);
			order_core_panels();
			
		}
		
		
		private void order_core_panels() {
		}
}
