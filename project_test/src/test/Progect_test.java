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

public class Progect_test {

	private JFrame frame;
	private Library library;
	
	
	private JPanel login_panel;
	private JPanel home_panel;
	private JTextField field_empID;
	private JLabel lbl_emp;
	
	private JPanel core_home_panel;
	private JPanel core_sheet_panel;
	private JPanel container_panel;
	private JPanel sheet_container_panel;
	
	private JPanel project_panel;
	
	private JPanel core_maint_panel;
	private JPanel maint_container_panel;
	private JPanel inq_panel2;
	private JPanel mod_panel2;
	private JPanel append_panel2;
	private JPanel remove_panel2;
	private JTable inq_table2;
	private JTable mod_table2;
	private JTable remove_table2;
	
	private JPanel progress_panel;
	
	
	
	private JPanel inventory_panel;
	
	private CardLayout card_layout;
	private CardLayout cl_home;
	private CardLayout cl_sheet;
	private CardLayout cl_maint;
	
	//private JLabel label_empID;
	
	
	private JTable inq_table;
	private JTable mod_table;
	private JTable append_table;	
	private JTable remove_table;
	private JTable sign_table;
	
	private JTable invent_table;
	private JPanel supplier_panel;
	private JTextField text_supID;
	private JTextField text_sup_name;
	private JTable sup_table;
	
	private JPanel employee_panel;
	
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
	private JTextField text_projectID;
	private JTextField text_empID;
	private JTable maint_table;
	private JTextField textField_4;
	private JTable table;
	
	private JButton btn_back2Project;
	
	//employee panel variables needed for comboBox actionListener
	private String function;
	private JComboBox comboBox_employeeAction;
	private JLabel lbl_employeeFirstName;
	private JTextField textField_employeeFirstName;
	private JLabel lbl_employeeLastName;
	private JTextField textField_employeeLastName;
	private JLabel lbl_address;
	private JTextField textField_employeeAddress;
	private JLabel lbl_employeePhoneNo;
	private JTextField textField_employeePhoneNo;
	private JLabel lbl_employeeSupervisorID;
	private JTextField textField_employeeSupervisorID;
	private JLabel lbl_employeePerformance;
	private JComboBox comboBox_employeePerformance;
	private JButton btn_IDConfirm;
	private JButton btn_employeeActionExecute;
	private JTextField text_sup_address;
	private JTextField text_sup_contact;
	private JTextField text_sup_mobile;
	private JTextField text_sup_mail;
	private JLabel lbl_employee_executeInfo;
	
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
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				  
				
				
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
		
		//library = new Library();
		
		frame = new JFrame("System");
		frame.setBounds(100, 100, 666, 466);
		
		card_layout = new CardLayout();
		
		frame.getContentPane().setLayout(card_layout);
		
		
		login_panel();
		home_panel();
		//sheet_panel();
		
		
		
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
					comboBox_employeeAction.setSelectedIndex(0);
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
			
			project_panel();
			
			inventory_panel();
			supplier_panel();
			employee_panel();
			
			
		}
		
		private void project_panel() {
			project_panel = new JPanel();
			container_panel.add(project_panel,"project");
			project_panel.setLayout(null);
			
			JButton btn_maint = new JButton("Maintenance");
			btn_maint.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
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
					 cl_home.show(container_panel,"sheet");
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
			
			proj_maint_panels();
			sheet_panels();
			proj_progress();
		}
		
		
		
		
		private void proj_maint_panels() {
			
			//core sheet panel which contains comboBox
			core_maint_panel = new JPanel();
			container_panel.add(core_maint_panel,"maintenance");
			core_maint_panel.setLayout(null);
			
			//smaller panel on the core maint panel
			cl_maint = new CardLayout();
			maint_container_panel = new JPanel(cl_maint);
			
			maint_container_panel.setBounds(0, 35, 666, 348);
			maint_container_panel.setBackground(Color.CYAN);
			core_maint_panel.add(maint_container_panel);
			
			
			//add 5 sub project maintenance panels
			
			//add_default_panel();
			add_inquire_panel2();
			add_modify_panel2();
			add_append_panel2();
			add_remove_panel2();
			
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(23, 6, 126, 27);
			//comboBox.addItem("--------");
			comboBox.addItem("Inquire");
			comboBox.addItem("Modify");
			comboBox.addItem("Append");
			comboBox.addItem("Remove");
			
			
			
			comboBox.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox.getSelectedItem(); //get the selected item

		                
		            	cl_maint.show(maint_container_panel, function);		                   
		            }
		        });

			core_maint_panel.add(comboBox);
		}
		

		
		//first panel - Inquire 
		private void add_inquire_panel2() {
			
			inq_panel2 = new JPanel();
			inq_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(inq_panel2, "Inquire");
			inq_panel2.setLayout(null);
			
					
			JLabel lbl_projectID = new JLabel("project ID :");
			lbl_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_projectID.setBounds(50, 11, 86, 16);
			inq_panel2.add(lbl_projectID);
					
			JTextField text_projectID = new JTextField();
			text_projectID.setBounds(136, 6, 141, 26);
			inq_panel2.add(text_projectID);
			text_projectID.setColumns(10);
					
			JLabel lbl_date = new JLabel("Est. Date :");
			lbl_date.setBounds(310, 11, 106, 16);
			lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
			inq_panel2.add(lbl_date);
					
			JTextField text_date = new JTextField();
			text_date.setBounds(416, 6, 105, 26);
			inq_panel2.add(text_date);
			text_date.setColumns(10);
					
			JButton btn_inquire = new JButton("Inquire");
			btn_inquire.setBounds(554, 5, 87, 29);
			btn_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					library.btn_inquire();
					inq_panel2.setVisible(true);
				}
			});
			inq_panel2.add(btn_inquire);
					
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(50, 45, 86, 16);
			inq_panel2.add(lbl_empID);
					
			JTextField text_empID = new JTextField();
			text_empID.setBounds(136, 40, 141, 26);
			inq_panel2.add(text_empID);
			text_empID.setColumns(10);
					
			
					
			JButton btn_last20 = new JButton("Last 20");
			btn_last20.setBounds(554, 39, 87, 29);
			btn_last20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					library.btn_inquire();
					inq_panel2.setVisible(true);
				}
			});
			inq_panel2.add(btn_last20);
					
			JLabel lbl_note = new JLabel("Note : To inquire project, at least one of project ID and Employee ID must be filled in  ");
			lbl_note.setBounds(29, 73, 529, 16);
			inq_panel2.add(lbl_note);
					
			inq_table2 = new JTable();
			inq_table2.setBounds(29, 94, 612, 254);
			inq_panel2.add(inq_table2);
			inq_table2.setVisible(false);
		}
		
		//Second panel - Modify 
		private void add_modify_panel2() {
			
			mod_panel2 = new JPanel();
			mod_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(mod_panel2, "Modify");
			mod_panel2.setLayout(null);
			
			JLabel lbl_projectID = new JLabel("*project ID :");
			lbl_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_projectID.setBounds(53, 41, 86, 16);
			mod_panel2.add(lbl_projectID);
			
			JTextField text_projectID = new JTextField();
			text_projectID.setBounds(143, 36, 115, 26);
			mod_panel2.add(text_projectID);
			text_projectID.setColumns(10);
			
			
			JButton btn_modify = new JButton("Modify");
			btn_modify.setBounds(539, 35, 87, 29);
			mod_panel2.add(btn_modify);
			
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(53, 104, 86, 16);
			mod_panel2.add(lbl_empID);
			
			JTextField textField = new JTextField();
			textField.setBounds(143, 99, 115, 26);
			mod_panel2.add(textField);
			textField.setColumns(10);
			
			JLabel lbl_date = new JLabel("Est. Date :");
			lbl_date.setBounds(288, 41, 88, 16);
			lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
			mod_panel2.add(lbl_date);
			
			JTextField text_date = new JTextField();
			text_date.setBounds(388, 36, 115, 26);
			mod_panel2.add(text_date);
			text_date.setColumns(10);
			
			mod_table2 = new JTable();
			mod_table2.setBounds(33, 252, 593, 66);
			mod_panel2.add(mod_table2);
		}
		
		//third panel - Append 
		private void add_append_panel2() {
			
			append_panel2 = new JPanel();
			append_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(append_panel2, "Append");
			append_panel2.setLayout(null);
			
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(62, 101, 86, 16);
			append_panel2.add(lbl_empID);
			
			textField_4 = new JTextField();
			textField_4.setBounds(148, 96, 116, 26);
			append_panel2.add(textField_4);
			textField_4.setColumns(10);
			
			JButton btn_append = new JButton("Append");
			btn_append.setBounds(471, 95, 92, 29);
			append_panel2.add(btn_append);
			
			JLabel lbl_error = new JLabel("Employee ID inputed is invalid, please verify it.");
			lbl_error.setBounds(62, 159, 318, 16);
			append_panel2.add(lbl_error);
			lbl_error.setVisible(false);
			
			table = new JTable();
			table.setBounds(58, 205, 563, 39);
			append_panel2.add(table);
			
			
			
		}
		
		//forth panel - Remove 
		private void add_remove_panel2() {
					
			remove_panel2 = new JPanel();
			remove_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(remove_panel2, "Remove");
			remove_panel2.setLayout(null);
			
			JLabel lbl_projectID = new JLabel("*project ID :");
			lbl_projectID.setBounds(81, 41, 86, 16);
			remove_panel2.add(lbl_projectID);
			
			JTextField text_projectID = new JTextField();
			text_projectID.setBounds(167, 36, 146, 26);
			remove_panel2.add(text_projectID);
			text_projectID.setColumns(10);
			
			JButton btn_remove = new JButton("Remove");
			btn_remove.setBounds(494, 35, 93, 29);
			btn_remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					library.btn_remove();
					remove_table2.setVisible(true);
					lbl_confirm.setVisible(true);
					text_confirm.setVisible(true);
					btn_confirm.setVisible(true);
				}
			});
			remove_panel2.add(btn_remove);
			
			remove_table2 = new JTable();
			remove_table2.setBounds(81, 159, 506, 25);
			remove_panel2.add(remove_table2);
			remove_table2.setVisible(false);
			
			lbl_confirm = new JLabel("Please write down \"I'm PRETTY SURE that I would like to remove this sheet.\"");
			lbl_confirm.setBounds(81, 189, 506, 16);
			remove_panel2.add(lbl_confirm);
			lbl_confirm.setVisible(false);
			
			text_confirm = new JTextField();
			text_confirm.setBounds(81, 210, 506, 26);
			remove_panel2.add(text_confirm);
			text_confirm.setColumns(10);
			text_confirm.setVisible(false);
			
			btn_confirm = new JButton("Confirm");
			btn_confirm.setBounds(494, 301, 93, 29);
			remove_panel2.add(btn_confirm);
			btn_confirm.setVisible(false);
	
			}
		
		
		
		
		private void proj_progress() {
			
			progress_panel = new JPanel();
			container_panel.add(progress_panel,"progress");
			progress_panel.setLayout(null);
			
			JLabel lbl_progress = new JLabel("Progress");
			lbl_progress.setBounds(4, 5, 58, 16);
			progress_panel.add(lbl_progress);
			
			JLabel lbl_projectID = new JLabel("Project ID :");
			lbl_projectID.setBounds(79, 26, 69, 33);
			progress_panel.add(lbl_projectID);
			
			text_projectID = new JTextField();
			text_projectID.setBounds(152, 29, 119, 26);
			progress_panel.add(text_projectID);
			text_projectID.setColumns(10);
			
			JButton btn_proj_inquire = new JButton("Inquire");
			btn_proj_inquire.setBounds(507, 28, 88, 29);
			progress_panel.add(btn_proj_inquire);
			
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(62, 94, 86, 33);
			progress_panel.add(lbl_empID);
			
			text_empID = new JTextField();
			text_empID.setBounds(152, 97, 119, 26);
			progress_panel.add(text_empID);
			text_empID.setColumns(10);
			
			JButton btn_proj_last20 = new JButton("Last 20");
			btn_proj_last20.setBounds(507, 96, 90, 29);
			progress_panel.add(btn_proj_last20);
			
			maint_table = new JTable();
			maint_table.setBounds(62, 162, 622, 191);
			progress_panel.add(maint_table);
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
			
			supplier_panel = new JPanel();
			container_panel.add(supplier_panel,"supplier");
			supplier_panel.setLayout(new FormLayout(new ColumnSpec[] {
					ColumnSpec.decode("103px"),
					ColumnSpec.decode("134px"),
					ColumnSpec.decode("163px:grow"),
					ColumnSpec.decode("60px"),
					ColumnSpec.decode("175px"),},
				new RowSpec[] {
					RowSpec.decode("35px"),
					RowSpec.decode("max(9dlu;default)"),
					RowSpec.decode("26px"),
					RowSpec.decode("26px"),
					FormSpecs.DEFAULT_ROWSPEC,
					FormSpecs.DEFAULT_ROWSPEC,
					RowSpec.decode("26px"),
					RowSpec.decode("29px"),
					RowSpec.decode("52px"),
					RowSpec.decode("25px"),}));
			
			comboBox_supplierAction = new JComboBox();
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
			supplier_panel.add(comboBox_supplierAction, "3, 1, center, default");
			
			JLabel lbl_supID = new JLabel("Supplier ID :");
			lbl_supID.setHorizontalAlignment(SwingConstants.RIGHT);
			supplier_panel.add(lbl_supID, "2, 3, right, center");
			
			text_supID = new JTextField();
			supplier_panel.add(text_supID, "3, 3, center, top");
			text_supID.setColumns(14);
			
			JLabel lbl_sup_name = new JLabel("Supplier Name :");
			supplier_panel.add(lbl_sup_name, "2, 4, right, center");
			
			text_sup_name = new JTextField();
			supplier_panel.add(text_sup_name, "3, 4, center, top");
			text_sup_name.setColumns(14);
			
			btn_sup_inquire = new JButton("Inquire");
			btn_sup_inquire.setVisible(true);
			btn_sup_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					library.btn_inquire_sup();
					sup_table.setVisible(true);
				}
			});
			supplier_panel.add(btn_sup_inquire, "5, 4, left, top");
			
			lbl_sup_address = new JLabel("Address :");
			lbl_sup_address.setVisible(false);
			supplier_panel.add(lbl_sup_address, "2, 5, right, default");
			
			text_sup_address = new JTextField();
			text_sup_address.setVisible(false);
			supplier_panel.add(text_sup_address, "3, 5, center, default");
			text_sup_address.setColumns(14);
			
			lbl_sup_contact = new JLabel("Contact :");
			lbl_sup_contact.setVisible(false);
			supplier_panel.add(lbl_sup_contact, "2, 6, right, default");
			
			text_sup_contact = new JTextField();
			text_sup_contact.setVisible(false);
			supplier_panel.add(text_sup_contact, "3, 6, center, default");
			text_sup_contact.setColumns(14);
			
			lbl_sup_mobile = new JLabel("Mobile :");
			lbl_sup_mobile.setVisible(false);
			supplier_panel.add(lbl_sup_mobile, "2, 7, right, default");
			
			text_sup_mobile = new JTextField();
			text_sup_mobile.setVisible(false);
			supplier_panel.add(text_sup_mobile, "3, 7, center, default");
			text_sup_mobile.setColumns(14);
			
			lbl_sup_mail = new JLabel("Mail :");
			lbl_sup_mail.setVisible(false);
			
			btn_sup_add = new JButton("Add");
			btn_sup_add.setVisible(false);
			btn_sup_add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			supplier_panel.add(btn_sup_add, "5, 7, left, default");
			supplier_panel.add(lbl_sup_mail, "2, 8, right, default");
			
			text_sup_mail = new JTextField();
			text_sup_mail.setVisible(false);
			supplier_panel.add(text_sup_mail, "3, 8, center, default");
			text_sup_mail.setColumns(14);
			
			btn_sup_delete = new JButton("Delete");
			btn_sup_delete.setVisible(false);
			supplier_panel.add(btn_sup_delete, "5, 8, left, default");
			
			sup_table = new JTable();
			supplier_panel.add(sup_table, "2, 10, 4, 1, fill, fill");
			sup_table.setVisible(false);
		}
		
		
		
		private void employee_panel() {
			//wrote by Ray ,05/25
			// by Ray - employee panel
						employee_panel = new JPanel();
						container_panel.add(employee_panel, "employee");
						employee_panel.setLayout(null);
						
						comboBox_employeeAction = new JComboBox();
						comboBox_employeeAction.setBounds(251, 35, 160, 27);
						comboBox_employeeAction.setModel(new DefaultComboBoxModel(new String[] {"Show & Adjust", "Add Employee", "Delete Employee"}));
						function = (String) comboBox_employeeAction.getSelectedItem(); //get the selected item
						comboBox_employeeAction.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				            	function = (String) comboBox_employeeAction.getSelectedItem();
				            	
				            	if (function.equals("Show & Adjust")) {
				            		lbl_employeeFirstName.setVisible(false);
				            		textField_employeeFirstName.setVisible(false);
				            		lbl_employeeLastName.setVisible(false);
				            		textField_employeeLastName.setVisible(false);
				            		lbl_address.setVisible(false);
				            		textField_employeeAddress.setVisible(false);
				            		lbl_employeePhoneNo.setVisible(false);
				            		textField_employeePhoneNo.setVisible(false);
				            		lbl_employeeSupervisorID.setVisible(false);
				            		textField_employeeSupervisorID.setVisible(false);
				            		lbl_employeePerformance.setVisible(false);
				            		comboBox_employeePerformance.setVisible(false);
				            		btn_employeeActionExecute.setVisible(false);
				            		lbl_employee_executeInfo.setVisible(false);
				            		btn_IDConfirm.setVisible(true);
				            	}
				            	else if (function.equals("Add Employee")) {
				            		lbl_employeeFirstName.setVisible(true);
				            		textField_employeeFirstName.setVisible(true);
				            		lbl_employeeLastName.setVisible(true);
				            		textField_employeeLastName.setVisible(true);
				            		lbl_address.setVisible(true);
				            		textField_employeeAddress.setVisible(true);
				            		lbl_employeePhoneNo.setVisible(true);
				            		textField_employeePhoneNo.setVisible(true);
				            		lbl_employeeSupervisorID.setVisible(true);
				            		textField_employeeSupervisorID.setVisible(true);
				            		lbl_employeePerformance.setVisible(true);
				            		comboBox_employeePerformance.setVisible(true);
				            		btn_employeeActionExecute.setVisible(true);
				            		lbl_employee_executeInfo.setVisible(false);
				            		btn_IDConfirm.setVisible(false);
				            	}
				            	else {
				            		lbl_employeeFirstName.setVisible(false);
				            		textField_employeeFirstName.setVisible(false);
				            		lbl_employeeLastName.setVisible(false);
				            		textField_employeeLastName.setVisible(false);
				            		lbl_address.setVisible(false);
				            		textField_employeeAddress.setVisible(false);
				            		lbl_employeePhoneNo.setVisible(false);
				            		textField_employeePhoneNo.setVisible(false);
				            		lbl_employeeSupervisorID.setVisible(false);
				            		textField_employeeSupervisorID.setVisible(false);
				            		lbl_employeePerformance.setVisible(false);
				            		comboBox_employeePerformance.setVisible(false);
				            		btn_employeeActionExecute.setVisible(false);
				            		lbl_employee_executeInfo.setVisible(false);
				            		btn_IDConfirm.setVisible(true);
				            	}
				            }
				        });
						employee_panel.add(comboBox_employeeAction);
						
						JLabel lbl_employeeID = new JLabel("Employee ID :");
						lbl_employeeID.setBounds(115, 73, 86, 16);
						employee_panel.add(lbl_employeeID);
						
						JTextField textField_employeeID = new JTextField();
						textField_employeeID.setBounds(230, 68, 202, 26);
						employee_panel.add(textField_employeeID);
						textField_employeeID.setColumns(16);
						
						btn_IDConfirm = new JButton("Confirm");
						btn_IDConfirm.setBounds(449, 67, 95, 29);
						btn_IDConfirm.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
			            		lbl_employeeFirstName.setVisible(true);
			            		textField_employeeFirstName.setVisible(true);
			            		lbl_employeeLastName.setVisible(true);
			            		textField_employeeLastName.setVisible(true);
			            		lbl_address.setVisible(true);
			            		textField_employeeAddress.setVisible(true);
			            		lbl_employeePhoneNo.setVisible(true);
			            		textField_employeePhoneNo.setVisible(true);
			            		lbl_employeeSupervisorID.setVisible(true);
			            		textField_employeeSupervisorID.setVisible(true);
			            		lbl_employeePerformance.setVisible(true);
			            		comboBox_employeePerformance.setVisible(true);
			            		btn_employeeActionExecute.setVisible(true);
				            }
				        });
						employee_panel.add(btn_IDConfirm);
						
						lbl_employeeFirstName = new JLabel("First Name :");
						lbl_employeeFirstName.setBounds(115, 101, 76, 16);
						lbl_employeeFirstName.setVisible(false);
						employee_panel.add(lbl_employeeFirstName);
						
						textField_employeeFirstName = new JTextField();
						textField_employeeFirstName.setBounds(230, 96, 202, 26);
						textField_employeeFirstName.setVisible(false);
						employee_panel.add(textField_employeeFirstName);
						textField_employeeFirstName.setColumns(16);
						
						lbl_employeeLastName = new JLabel("Last Name :");
						lbl_employeeLastName.setBounds(115, 127, 74, 16);
						lbl_employeeLastName.setVisible(false);
						employee_panel.add(lbl_employeeLastName);
						
						textField_employeeLastName = new JTextField();
						textField_employeeLastName.setBounds(230, 122, 202, 26);
						textField_employeeLastName.setVisible(false);
						employee_panel.add(textField_employeeLastName);
						textField_employeeLastName.setColumns(16);
						
						lbl_address = new JLabel("Address :");
						lbl_address.setBounds(115, 153, 59, 16);
						lbl_address.setVisible(false);
						employee_panel.add(lbl_address);
						
						textField_employeeAddress = new JTextField();
						textField_employeeAddress.setBounds(230, 148, 202, 26);
						textField_employeeAddress.setVisible(false);
						employee_panel.add(textField_employeeAddress);
						textField_employeeAddress.setColumns(16);
						
						lbl_employeePhoneNo = new JLabel("Phone Number :");
						lbl_employeePhoneNo.setBounds(115, 179, 100, 16);
						lbl_employeePhoneNo.setVisible(false);
						employee_panel.add(lbl_employeePhoneNo);
						
						textField_employeePhoneNo = new JTextField();
						textField_employeePhoneNo.setBounds(230, 174, 202, 26);
						textField_employeePhoneNo.setVisible(false);
						employee_panel.add(textField_employeePhoneNo);
						textField_employeePhoneNo.setColumns(16);
						
						lbl_employeeSupervisorID = new JLabel("Supervisor ID :");
						lbl_employeeSupervisorID.setBounds(115, 205, 92, 16);
						lbl_employeeSupervisorID.setVisible(false);
						employee_panel.add(lbl_employeeSupervisorID);
						
						textField_employeeSupervisorID = new JTextField();
						textField_employeeSupervisorID.setBounds(230, 200, 202, 26);
						textField_employeeSupervisorID.setVisible(false);
						employee_panel.add(textField_employeeSupervisorID);
						textField_employeeSupervisorID.setColumns(16);
						
						lbl_employeePerformance = new JLabel("Performance :");
						lbl_employeePerformance.setBounds(115, 234, 86, 16);
						lbl_employeePerformance.setVisible(false);
						employee_panel.add(lbl_employeePerformance);
						
						comboBox_employeePerformance = new JComboBox();
						comboBox_employeePerformance.setBounds(230, 229, 65, 27);
						comboBox_employeePerformance.setForeground(Color.BLACK);
						comboBox_employeePerformance.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
	            		comboBox_employeePerformance.setVisible(false);
						employee_panel.add(comboBox_employeePerformance);
						
						btn_employeeActionExecute = new JButton();
						if (function.equals("Show & Adjust")) {
							btn_employeeActionExecute.setText("Save Changes");
						}
						else if (function.equals("Delete Employee")) {
							btn_employeeActionExecute.setText("Delete");
						}
						btn_employeeActionExecute.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								lbl_employee_executeInfo.setVisible(true);
							}
						});
						btn_employeeActionExecute.setBounds(266, 281, 130, 29);
						btn_employeeActionExecute.setVisible(false);
						employee_panel.add(btn_employeeActionExecute);
						
						lbl_employee_executeInfo = new JLabel("Message of execute result");
						lbl_employee_executeInfo.setHorizontalAlignment(SwingConstants.CENTER);
						lbl_employee_executeInfo.setBounds(183, 332, 300, 16);
						lbl_employee_executeInfo.setVisible(false);
						employee_panel.add(lbl_employee_executeInfo);
						
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
						
						JButton btn_inquire_1 = new JButton("Inquire");
						btn_inquire_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								
								library.btn_inquire_invent();
								invent_table.setVisible(true);
							}
						});
						btn_inquire_1.setBounds(554, 160, 88, 29);
						inventory_panel.add(btn_inquire_1);
						
						invent_table = new JTable();
						invent_table.setBounds(33, 194, 609, 189);
						inventory_panel.add(invent_table);
						invent_table.setVisible(false);		
						sup_table.setVisible(false);
					}
					
		
		
		private void sheet_panels() {
			
			//core sheet panel which contains comboBox
			core_sheet_panel = new JPanel();
			container_panel.add(core_sheet_panel,"sheet");
			core_sheet_panel.setLayout(null);
			
			//smaller panel on the core sheet panel
			cl_sheet = new CardLayout();
			sheet_container_panel = new JPanel(cl_sheet);
			
			sheet_container_panel.setBounds(0, 35, 666, 348);
			sheet_container_panel.setBackground(Color.CYAN);
			core_sheet_panel.add(sheet_container_panel);
			
			
			//add 5 sub sheet panels
			
			//add_default_panel();
			add_inquire_panel();
			add_modify_panel();
			add_append_panel();
			add_remove_panel();
			add_sign_panel();
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(23, 6, 126, 27);
			//comboBox.addItem("--------");
			comboBox.addItem("Inquire");
			comboBox.addItem("Modify");
			comboBox.addItem("Append");
			comboBox.addItem("Remove");
			comboBox.addItem("Signature");
			
			
			comboBox.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox.getSelectedItem(); //get the selected item

		                
		            	cl_sheet.show(sheet_container_panel, function);		                   
		            }
		        });

			core_sheet_panel.add(comboBox);
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
					library.btn_inquire();
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
					library.btn_inquire();
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
					
					library.btn_remove();
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
		
		
		
		
		
		public JTextField get_field_empID() {
		
			return field_empID;
		}
}
