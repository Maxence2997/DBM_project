package test;
//test 1-2
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
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

public class Term_project_main {
	
	public static connection conn;
	
	private JFrame frame;
	
	
	private JPanel login_panel;
	private JPanel home_panel;
	private JTextField field_empID;
	private JLabel lbl_emp;
	
	private JPanel core_home_panel;
	
	public static JPanel container_panel;
	
	
	private Employee_panel emp_panel;
	
	private Supplier_panel sup_panel;
	
	private Inventory_panel inv_panel;
	
	private Project_panels pj_panels;
	
	
	
	
	public static CardLayout card_layout;
	public static CardLayout cl_home;
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				  
				
				
				try {
					Term_project_main window = new Term_project_main();
					//window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public Term_project_main() {
		
		frame = new JFrame("System");
		frame.setBounds(100, 100, 666, 466);
		
		card_layout = new CardLayout();
		
		frame.getContentPane().setLayout(card_layout);
		
		
		login_panel();
		frame.setVisible(true);
		
		conn = new connection(); 
		
		home_panel();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
//	private void initialize() {
//		
//		
//		
//		frame = new JFrame("System");
//		frame.setBounds(100, 100, 666, 466);
//		
//		card_layout = new CardLayout();
//		
//		frame.getContentPane().setLayout(card_layout);
//		
//		
//		login_panel();
//		conn = new connection(); 
//		
//		home_panel();
//		
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//	}
		
		private void login_panel() {
			
			
			login_panel = new JPanel();
			frame.getContentPane().add(login_panel,"login");
			login_panel.setLayout(null);
			
			
			JLabel label_empID = new JLabel("Employee ID :");
			label_empID.setBounds(100, 191, 104, 16);
			login_panel.add(label_empID);
			
			field_empID = new JTextField("11047601");
			field_empID.setBounds(229, 186, 163, 26);
			login_panel.add(field_empID);
			field_empID.setColumns(10);
			
			JLabel login_result = new JLabel("");
			login_result.setBounds(201, 245, 245, 26);
			login_panel.add(login_result);
			
			
			JButton button_login = new JButton("Log-in");
			button_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					card_layout.show(frame.getContentPane(), "home");
					
//					if (library.is_existed(field_empID) == true) {
						
						//library = new Library();
//						card_layout.show(frame.getContentPane(), "home");
//						
//						//System.out.print("Supervisor:"+ library.is_supervisor(field_empID));
//						
//						if (library.is_supervisor(field_empID)==true) lbl_sorry.setVisible(false);
//						
//						
//						else {
//							lbl_instruction.setVisible(false);
//							sign_table.setVisible(false);
//							btn_sign.setVisible(false);
//							btn_refresh.setVisible(false);
//						}
//					}
//										
//						
//					else {
//						
//						login_result.setText("Employee ID is invalid, please refill it.");
//
//						}
//					}
				
				
			}});
			button_login.setBounds(421, 186, 117, 29);
			login_panel.add(button_login);
			
			
		}
		
		
		private void home_panel() {
			
			//home panel which contains only EMPID, button log-out, btn_reminder and button home
			home_panel = new JPanel();
			frame.getContentPane().add(home_panel, "home");
			home_panel.setLayout(null);
			
			
			JButton btn_logout = new JButton("Log-out");
			btn_logout.setBounds(0, 409, 96, 29);
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					card_layout.show(frame.getContentPane(),"login");
				}
			});
			home_panel.add(btn_logout);
			
			JLabel lbl_empID = new JLabel();
			lbl_empID.setBounds(0, 5, 179, 16);
			home_panel.add(lbl_empID);
			lbl_empID.setText(" Employee ID: " + field_empID.getText());
			
			JButton btn_reminder = new JButton("R");
			btn_reminder.setBounds(626, 0, 40, 26);
			home_panel.add(btn_reminder);
			
			cl_home = new CardLayout();
			container_panel = new JPanel(cl_home);
			container_panel.setBounds(0, 26, 666, 383);
			container_panel.setBackground(Color.CYAN);
			home_panel.add(container_panel);
			
			
			
			//home_core_panel
			core_home_panel = new JPanel();
			container_panel.add(core_home_panel,"home");
			
			JButton btn_project = new JButton("Project");
			btn_project.setBounds(91, 39, 103, 29);
			btn_project.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl_home.show(container_panel, "project");
					
				}
			});
			core_home_panel.setLayout(null);
			core_home_panel.add(btn_project);
			
			JLabel lbl_sheet = new JLabel("Project management ");
			lbl_sheet.setBounds(227, 45, 385, 16);
			core_home_panel.add(lbl_sheet);
			
			//Author: Ray
			//Date: 05/31
			//Default text field as empty
			JButton btn_invent = new JButton("Inventory");
			btn_invent.setBounds(91, 131, 103, 29);
			btn_invent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inv_panel.get_text_invID().setText("");
					inv_panel.get_text_inv_item().setText("");
					inv_panel.get_text_inv_pd().setText("");
					
					cl_home.show(container_panel, "inventory");
					
				}
			});
			core_home_panel.add(btn_invent);
			
			JLabel lbl_invent = new JLabel("Inquire the vol. of Inventory");
			lbl_invent.setBounds(227, 137, 385, 16);
			core_home_panel.add(lbl_invent);
			
			//Author: Ray
			//Date: 05/31
			//Default text field as empty
			JButton btn_sup = new JButton("Supplier");
			btn_sup.setBounds(91, 222, 103, 29);
			btn_sup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					sup_panel.get_combobox_sup().setSelectedIndex(0);
					sup_panel.get_text_sup_supID().setText("");
					sup_panel.get_text_sup_name().setText("");
					sup_panel.get_text_sup_addr().setText("");
					sup_panel.get_text_sup_ctc().setText("");
					sup_panel.get_text_sup_mobile().setText("");
					sup_panel.get_text_sup_mail().setText("");
					
					//clear table
					//sup_panel.get_sup_table().
					
					cl_home.show(container_panel, "supplier");
					
				}
			});
			core_home_panel.add(btn_sup);
			
			JLabel lbl_sup = new JLabel("Suppliers' information maintenance");
			lbl_sup.setBounds(227, 228, 385, 16);
			core_home_panel.add(lbl_sup);
			
			//Author: Ray
			//Date: 05/31
			//Default text field as empty
			JButton btn_emp = new JButton("Employee");
			btn_emp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					emp_panel.get_comboBox_employeeAction().setSelectedIndex(0);
					emp_panel.get_text_emp_empID().setText("");
					emp_panel.get_text_emp_first().setText("");
					emp_panel.get_text_emp_last().setText("");
					emp_panel.get_text_emp_addr().setText("");
					emp_panel.get_text_emp_phone().setText("");
					emp_panel.get_text_emp_supervID().setText("");
					emp_panel.get_comboBox_emp_perf().setSelectedIndex(0);
					cl_home.show(container_panel, "employee");
				}
			});
			btn_emp.setBounds(91, 314, 103, 29);
			core_home_panel.add(btn_emp);
			
			
			lbl_emp = new JLabel("Employees' information maintenance");
			lbl_emp.setBounds(227, 321, 385, 16);
			core_home_panel.add(lbl_emp);
			
			JButton btn_home = new JButton("Home");
			btn_home.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					cl_home.show(container_panel, "home");
					
				}
			});
			btn_home.setBounds(579, 409, 81, 29);
			home_panel.add(btn_home);
			
			pj_panels = new Project_panels();
			inv_panel = new Inventory_panel();
			sup_panel = new Supplier_panel();
			emp_panel = new Employee_panel(); 
			
			
		}
		
		
		public boolean is_existed(JTextField field_empID) {  
			/** To verify if the ID inputed by user is registered in EMPLOYEE or not
			 * 
			 * If the ID registered, return true; else return false
			 **/
			
			boolean existed;
			
			try {
				ResultSet resultSet = conn.st.executeQuery("SELECT Emp_ID FROM EMPLOYEE WHERE Emp_ID="+ field_empID.getText());
				if (resultSet.next()) {
					//System.out.println(resultSet.getString("Emp_ID"));
			
					existed = true;
				}
				
				else 
					existed = false;
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					existed = false;
				}
				 
			return existed;
		}
		
		
		public boolean is_supervisor(JTextField field_empID) {
			/**
			 * To verify the ID logged in is supervisor or not
			 * 
			 * if it's supervisor ID, return true; else return false
			 */
			
			boolean supervisor;
			
			try {
				ResultSet resultSet = conn.st.executeQuery("SELECT Supervisor FROM EMPLOYEE WHERE Supervisor=" + field_empID.getText());
				if (resultSet.next()) {
					System.out.println(resultSet.getString("Supervisor"));
			
					supervisor = true;
				}
				
				else 
					supervisor = false;
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					supervisor = false;
				}
				 
			return supervisor;
			
			
		}
		

		public JTextField get_field_empID() {
		
			return this.field_empID;
		}
				
}
