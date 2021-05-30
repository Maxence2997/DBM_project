package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Employee_panel {
		/**
	     * @autohr Jyun-An
	     * @ver. 1.2.2 05/28   
	     * Seperated from Project_test
	     **/
		
		
		private JPanel employee_panel;
		
		private String function;
		private JComboBox comboBox_employeeAction;  //employee panel variables needed for comboBox actionListener
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
		
		private JLabel lbl_employee_executeInfo;
		
		//JTextField textField_employeeID;
		
		
		public Employee_panel() {
			
			
			panel();
		}
		
		
		private void panel() {
			//wrote by Ray ,05/25
			// by Ray - employee panel
						employee_panel = new JPanel();
						Term_project_main.container_panel.add(employee_panel, "employee");
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
				            	
				            	String []temp = show_adjust(textField_employeeID);
				            	
			            		lbl_employeeFirstName.setVisible(true);
			            		textField_employeeFirstName.setVisible(true);
			            		textField_employeeFirstName.setText(temp[1]);
			            		
			            		lbl_employeeLastName.setVisible(true);
			            		textField_employeeLastName.setVisible(true);
			            		textField_employeeLastName.setText(temp[2]);
			            		
			            		lbl_address.setVisible(true);
			            		textField_employeeAddress.setVisible(true);
			            		textField_employeeAddress.setText(temp[3]);
			            		
			            		lbl_employeePhoneNo.setVisible(true);
			            		textField_employeePhoneNo.setVisible(true);
			            		textField_employeePhoneNo.setText(temp[4]);
			            		
			            		lbl_employeeSupervisorID.setVisible(true);
			            		textField_employeeSupervisorID.setVisible(true);
			            		textField_employeeSupervisorID.setText(temp[5]);
			            		
			            		lbl_employeePerformance.setVisible(true);
			            		
			            		comboBox_employeePerformance.setVisible(true);
			            		comboBox_employeePerformance.setSelectedItem(temp[6]);
			            		
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
							btn_employeeActionExecute.setText("Save Change");
						}
						else if (function.equals("Delete Employee")) {
							btn_employeeActionExecute.setText("Delete");
						}
						btn_employeeActionExecute.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								if (btn_employeeActionExecute.getText().equalsIgnoreCase("Save Change")) {
										
											save_change(textField_employeeID);						
								}
								else if(btn_employeeActionExecute.getText().equalsIgnoreCase("Delete Employee")) {
									delete_emp(textField_employeeID);
								}
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
						
					}
		
		
		private String[] show_adjust(JTextField empID) {
			/**
			 * @author jyunanyang
			 * @since 05/30/2021
			 * 
			 * the action after click button confirm in employee panel- show and adjust
			 * set instruction of SQL 
			 */
			String [] temp = new String[7];
			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM EMPLOYEE WHERE Emp_ID=" + empID.getText());
				if(resultSet.next()) {
					
//					System.out.println(resultSet.getString("Emp_ID") + "    " + resultSet.getString(
//							"First_name") + "   " + resultSet.getString("Last_name") + "   " + resultSet.getString("Address") 
//							+ "   " + resultSet.getString("Phone_number") + "   " + resultSet.getString("Supervisor_ID")+ "   " 
//							+ resultSet.getString("Performance"));
					
					for(int i = 1; i<8; i++) {
						temp[i-1]= resultSet.getString(i);
					}
				}
				
				return temp;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
			}
		}
		
		private void save_change(JTextField empID) {
			/**
			 * @author jyunanyang
			 * @since 05/30/2021
			 * the action after click button save_change in employee panel- show and adjust
			 */
			String statement;
			
			if (function.equalsIgnoreCase("Show & Adjust")) {
					statement = "UPDATE EMPLOYEE SET First_name=\'"+textField_employeeFirstName.getText()+
					"\', Last_name=\'"+textField_employeeLastName.getText()+"\', Address=\'"+textField_employeeAddress.getText()
					+"\', Phone_number=\'"+ textField_employeePhoneNo.getText()+"\', Supervisor_ID="+textField_employeeSupervisorID.getText()
					+", Performance=\'"+comboBox_employeePerformance.getSelectedItem()+"\' WHERE Emp_ID=" + empID.getText();
			
			}
			else {
				statement = "INSERT INTO EMPLOYEE(Fires_name, Last_name, Address, Phone_number, Supervisor_ID, Performance) VALUE(\'"+
						textField_employeeFirstName.getText()+"\', \'"+textField_employeeLastName.getText()+"\', \'"+
						textField_employeeAddress.getText()+"\', \'"+textField_employeePhoneNo.getText()+"\', "+
						textField_employeeSupervisorID.getText()+", \'"+comboBox_employeePerformance.getSelectedItem()+ "\')";
			}
			System.out.println(statement);
//			try {
//				int resultSet = Term_project_main.conn.st.executeUpdate(statement);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
				//tell user that the supervisor_ID inputed is not in the employee_id list
				//have to deal with FK constraint
			//}
		}
		
		
		
		private void delete_emp(JTextField empID) {
			
			try {
				int resultSet = Term_project_main.conn.st.executeUpdate("DELETE FROM EMPLOYEE WHERE Emp_ID="+empID.getText());
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
		public JComboBox get_comboBox_employeeAction() {
			
			return comboBox_employeeAction;
		}
		
}
