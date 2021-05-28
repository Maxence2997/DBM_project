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

public class Project_test {

	private JFrame frame;
	private Library library;
	
	
	private JPanel login_panel;
	private JPanel home_panel;
	private JTextField field_empID;
	private JLabel lbl_emp;
	
	private JPanel core_home_panel;
	
	public static JPanel container_panel;
	
	
	private JPanel project_panel;
	
	private Project_subpanels project_subpanels; //project subpanels 
	
	private Sheets_panel sheets_panel;  // sheets panels
	
	private Employee_panel emp_panel;
	
	private JPanel inventory_panel;
	
	private CardLayout card_layout;
	private CardLayout cl_home;
	
	
	//private JLabel label_empID;
	
	
	
	
	private JTable invent_table;
	private JPanel supplier_panel;
	private JTextField text_supID;
	private JTextField text_sup_name;
	private JTable sup_table;
	
	
	
	
	
	
	private JButton btn_back2Project;
	
	//employee panel variables needed for comboBox actionListener
	
	
	//supplier panel variables needed for comboBox actionListener
	private String supplierFunction;
	private JLabel lbl_sup_address;
	private JLabel lbl_sup_contact;
	private JLabel lbl_sup_mobile;
	private JLabel lbl_sup_mail;
	private JComboBox comboBox_supplierAction;
	private JButton btn_sup_inquire;
	private JButton btn_sup_add;
	private JButton btn_sup_delete;
	private JTextField text_sup_address;
	private JTextField text_sup_contact;
	private JTextField text_sup_mobile;
	private JTextField text_sup_mail;
	


	/**
	 * Create the application.
	 */
	
	public Project_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//library = new Library();
		
		frame = new JFrame("System");
		frame.setBounds(100, 100, 666, 466);
		frame.setVisible(true);
		card_layout = new CardLayout();
		
		frame.getContentPane().setLayout(card_layout);
		
		
		login_panel();
		home_panel();
		
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
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
			
			//home panel which contains only EMPID, button log-out and button home
			home_panel = new JPanel();
			frame.getContentPane().add(home_panel, "home");
			home_panel.setLayout(null);
			
			JLabel lbl_empID = new JLabel();
			lbl_empID.setBounds(0, 5, 179, 16);
			home_panel.add(lbl_empID);
			lbl_empID.setText(" Employee ID: " + field_empID.getText());
			
			
			JButton btn_logout = new JButton("Log-out");
			btn_logout.setBounds(0, 409, 96, 29);
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					card_layout.show(frame.getContentPane(),"login");
				}
			});
			home_panel.add(btn_logout);
			
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
			
			JButton btn_invent = new JButton("Inventory");
			btn_invent.setBounds(91, 131, 103, 29);
			btn_invent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl_home.show(container_panel, "inventory");
					
				}
			});
			core_home_panel.add(btn_invent);
			
			JLabel lbl_invent = new JLabel("Inquire the vol. of Inventory");
			lbl_invent.setBounds(227, 137, 385, 16);
			core_home_panel.add(lbl_invent);
			
			JButton btn_sup = new JButton("Supplier");
			btn_sup.setBounds(91, 222, 103, 29);
			btn_sup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comboBox_supplierAction.setSelectedIndex(0);
					cl_home.show(container_panel, "supplier");
					
				}
			});
			core_home_panel.add(btn_sup);
			
			JLabel lbl_sup = new JLabel("Suppliers' information maintenance");
			lbl_sup.setBounds(227, 228, 385, 16);
			core_home_panel.add(lbl_sup);
			
			JButton btn_emp = new JButton("Employee");
			btn_emp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					emp_panel.get_comboBox_employeeAction().setSelectedIndex(0);
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
					btn_back2Project.setVisible(false);
				}
			});
			btn_home.setBounds(579, 409, 81, 29);
			home_panel.add(btn_home);
			
			btn_back2Project = new JButton("Project");
			btn_back2Project.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					cl_home.show(container_panel, "project");
					btn_back2Project.setVisible(false);
				}
			});
			btn_back2Project.setBounds(491, 409, 90, 29);
			btn_back2Project.setVisible(false);
			home_panel.add(btn_back2Project);
			
			project_panels();
			inventory_panel();
			supplier_panel();
			emp_panel = new Employee_panel(); 
			
			
		}
		
		
		private void project_panels() {
			
			project_panel = new JPanel();
			container_panel.add(project_panel,"project");
			project_panel.setLayout(null);
			
			JButton btn_maint = new JButton("Maintenance");
			btn_maint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					project_subpanels.get_comboBox_project().setSelectedIndex(0);
					 cl_home.show(container_panel,"maintenance");
					 btn_back2Project.setVisible(true);
				}
			});
			btn_maint.setBounds(130, 98, 123, 29);
			project_panel.add(btn_maint);
			
			JLabel lbl_project2 = new JLabel("Project Inquiring, Modifying...");
			lbl_project2.setBounds(315, 104, 187, 16);
			project_panel.add(lbl_project2);
			
			JButton btn_progress= new JButton("Progress ");
			btn_progress.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 cl_home.show(container_panel,"progress");
					 btn_back2Project.setVisible(true);
				}
			});
			btn_progress.setBounds(130, 192, 123, 29);
			project_panel.add(btn_progress);
			
			JLabel lbl_progess = new JLabel("Project Progess Inquiring");
			lbl_progess.setBounds(315, 198, 187, 16);
			project_panel.add(lbl_progess);
			
			JButton btn_sheet = new JButton("Sheets");
			btn_sheet.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 sheets_panel.get_comboBox_sheets().setSelectedIndex(0);
					 cl_home.show(container_panel,"sheets");
					 btn_back2Project.setVisible(true);
				}
			});
			btn_sheet.setBounds(130, 286, 123, 29);
			project_panel.add(btn_sheet);
			
			JLabel lbl_sheet = new JLabel("Sheets' Maintenance");
			lbl_sheet.setBounds(315, 292, 187, 16);
			project_panel.add(lbl_sheet);
			
			JLabel lbl_project = new JLabel("Project");
			lbl_project.setBounds(6, 6, 61, 16);
			project_panel.add(lbl_project);
			
			project_subpanels = new Project_subpanels();
			sheets_panel = new Sheets_panel();
		}
		
		
		private void inventory_panel() {
			
			inventory_panel = new JPanel();
			container_panel.add(inventory_panel,"inventory");
			inventory_panel.setLayout(null);
			
			JLabel lbl_stockID = new JLabel("Stock ID :");
			lbl_stockID.setBounds(111, 40, 61, 16);
			lbl_stockID.setHorizontalAlignment(SwingConstants.RIGHT);
			inventory_panel.add(lbl_stockID);
			
			JTextField text_stockID = new JTextField();
			text_stockID.setBounds(176, 35, 108, 26);
			inventory_panel.add(text_stockID);
			text_stockID.setColumns(10);
			
			JLabel lbl_item = new JLabel("Item Type :");
			lbl_item.setBounds(364, 40, 70, 16);
			lbl_item.setHorizontalAlignment(SwingConstants.RIGHT);
			inventory_panel.add(lbl_item);
			
			JTextField textField_3 = new JTextField();
			textField_3.setBounds(438, 35, 112, 26);
			inventory_panel.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lbl_product = new JLabel("Product Module : ");
			lbl_product.setBounds(62, 102, 110, 16);
			lbl_product.setHorizontalAlignment(SwingConstants.RIGHT);
			inventory_panel.add(lbl_product);
			
			JTextField text_item = new JTextField();
			text_item.setBounds(176, 97, 108, 26);
			inventory_panel.add(text_item);
			text_item.setColumns(10);
			
			JLabel lbl_date = new JLabel("Receive Date : ");
			lbl_date.setBounds(342, 102, 92, 16);
			lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
			inventory_panel.add(lbl_date);
			
			JTextField text_date = new JTextField();
			text_date.setBounds(438, 97, 112, 26);
			inventory_panel.add(text_date);
			text_date.setColumns(10);
			
			JButton btn_inquire = new JButton("Inquire");
			btn_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					library.btn_inquire_invent();
					invent_table.setVisible(true);
				}
			});
			btn_inquire.setBounds(554, 160, 88, 29);
			inventory_panel.add(btn_inquire);
			
			invent_table = new JTable();
			invent_table.setBounds(33, 194, 609, 189);
			inventory_panel.add(invent_table);
			invent_table.setVisible(false);		
		}
		
		
		

		private void supplier_panel() {
			
			/*
			 *  New version GUI by Ray
			 * 05/27/2021
			 */
			
			supplier_panel = new JPanel();
			container_panel.add(supplier_panel,"supplier");
			
			comboBox_supplierAction = new JComboBox();
			comboBox_supplierAction.setBounds(266, 4, 135, 27);
			comboBox_supplierAction.setModel(new DefaultComboBoxModel(new String[] {"Inquire", "Maintenance"}));
			supplierFunction = (String) comboBox_supplierAction.getSelectedItem();
			comboBox_supplierAction.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	supplierFunction = (String) comboBox_supplierAction.getSelectedItem();
	            	
	            	if (supplierFunction.equals("Inquire")) {
	            		btn_sup_inquire.setVisible(true);
	            		btn_sup_add.setVisible(false);
	            		btn_sup_delete.setVisible(false);
	            		lbl_sup_address.setVisible(false);
	            		text_sup_address.setVisible(false);
	            		lbl_sup_contact.setVisible(false);
	            		text_sup_contact.setVisible(false);
	            		lbl_sup_mobile.setVisible(false);
	            		text_sup_mobile.setVisible(false);
	            		lbl_sup_mail.setVisible(false);
	            		text_sup_mail.setVisible(false);
	            		
	            	}
	            	else if (supplierFunction.equals("Maintenance")) {
	            		btn_sup_inquire.setVisible(false);
	            		btn_sup_add.setVisible(true);
	            		btn_sup_delete.setVisible(true);
	            		lbl_sup_address.setVisible(true);
	            		text_sup_address.setVisible(true);
	            		lbl_sup_contact.setVisible(true);
	            		text_sup_contact.setVisible(true);
	            		lbl_sup_mobile.setVisible(true);
	            		text_sup_mobile.setVisible(true);
	            		lbl_sup_mail.setVisible(true);
	            		text_sup_mail.setVisible(true);
	            	}
	            }
	        });
			supplier_panel.setLayout(null);
			supplier_panel.add(comboBox_supplierAction);
			
			JLabel lbl_supID = new JLabel("Supplier ID :");
			lbl_supID.setBounds(160, 55, 77, 16);
			lbl_supID.setHorizontalAlignment(SwingConstants.RIGHT);
			supplier_panel.add(lbl_supID);
			
			text_supID = new JTextField();
			text_supID.setBounds(245, 50, 178, 26);
			supplier_panel.add(text_supID);
			text_supID.setColumns(14);
			
			JLabel lbl_sup_name = new JLabel("Supplier Name :");
			lbl_sup_name.setBounds(138, 81, 99, 16);
			supplier_panel.add(lbl_sup_name);
			
			text_sup_name = new JTextField();
			text_sup_name.setBounds(245, 76, 178, 26);
			supplier_panel.add(text_sup_name);
			text_sup_name.setColumns(14);
			
			btn_sup_inquire = new JButton("Inquire");
			btn_sup_inquire.setBounds(491, 76, 88, 26);
			btn_sup_inquire.setVisible(true);
			btn_sup_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					library.btn_inquire_sup();
					sup_table.setVisible(true);
				}
			});
			supplier_panel.add(btn_sup_inquire);
			
			lbl_sup_address = new JLabel("Address :");
			lbl_sup_address.setBounds(178, 107, 59, 16);
			lbl_sup_address.setVisible(false);
			supplier_panel.add(lbl_sup_address);
			
			text_sup_address = new JTextField();
			text_sup_address.setBounds(245, 102, 178, 26);
			text_sup_address.setVisible(false);
			supplier_panel.add(text_sup_address);
			text_sup_address.setColumns(14);
			
			lbl_sup_contact = new JLabel("Contact :");
			lbl_sup_contact.setBounds(180, 133, 57, 16);
			lbl_sup_contact.setVisible(false);
			supplier_panel.add(lbl_sup_contact);
			
			text_sup_contact = new JTextField();
			text_sup_contact.setBounds(245, 128, 178, 26);
			text_sup_contact.setVisible(false);
			supplier_panel.add(text_sup_contact);
			text_sup_contact.setColumns(14);
			
			lbl_sup_mobile = new JLabel("Mobile :");
			lbl_sup_mobile.setBounds(187, 159, 50, 16);
			lbl_sup_mobile.setVisible(false);
			supplier_panel.add(lbl_sup_mobile);
			
			text_sup_mobile = new JTextField();
			text_sup_mobile.setBounds(245, 154, 178, 26);
			text_sup_mobile.setVisible(false);
			supplier_panel.add(text_sup_mobile);
			text_sup_mobile.setColumns(14);
			
			lbl_sup_mail = new JLabel("Mail :");
			lbl_sup_mail.setBounds(203, 186, 34, 16);
			lbl_sup_mail.setVisible(false);
			
			btn_sup_add = new JButton("Add");
			btn_sup_add.setBounds(491, 154, 75, 26);
			btn_sup_add.setVisible(false);
			btn_sup_add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			supplier_panel.add(btn_sup_add);
			supplier_panel.add(lbl_sup_mail);
			
			text_sup_mail = new JTextField();
			text_sup_mail.setBounds(245, 181, 178, 26);
			text_sup_mail.setVisible(false);
			supplier_panel.add(text_sup_mail);
			text_sup_mail.setColumns(14);
			
			btn_sup_delete = new JButton("Delete");
			btn_sup_delete.setBounds(491, 180, 84, 29);
			btn_sup_delete.setVisible(false);
			supplier_panel.add(btn_sup_delete);
			
			sup_table = new JTable();
			sup_table.setBounds(67, 262, 563, 25);
			supplier_panel.add(sup_table);
			sup_table.setVisible(false);
		}
		
		
		
		public JTextField get_field_empID() {
		
			return this.field_empID;
		}
				
}
