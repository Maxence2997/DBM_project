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
		
		private Library lib;
		private JPanel employee_panel;
		
		private String function;
		private JComboBox comboBox_emp_action;  //employee panel variables needed for comboBox actionListener
		private JLabel lbl_emp_first;
		private JTextField text_emp_first;
		private JLabel lbl_emp_last;
		private JTextField text_emp_last;
		private JLabel lbl_emp_addr;
		private JTextField text_emp_addr;
		private JLabel lbl_emp_phone;
		private JTextField text_emp_phone;
		private JLabel lbl_emp_supervID;
		private JTextField text_emp_supervID;
		private JLabel lbl_emp_perf;
		private JComboBox comboBox_emp_perf;
		private JButton btn_emp_confirmID;
		private JButton btn_emp_execute;
		private JLabel lbl_empID_show;
		private JLabel lbl_emp_info;
		
		private JTextField text_emp_empID;
		
		
		public Employee_panel() {
			
			lib = new Library();
			panel();
		}
		
		
		private void panel() {
			
			//wrote by Ray ,05/25
			// by Ray - employee panel
			
			employee_panel = new JPanel();
			Term_project_main.container_panel.add(employee_panel, "employee");
			employee_panel.setLayout(null);
						
			comboBox_emp_action = new JComboBox();
			comboBox_emp_action.setBounds(251, 35, 160, 27);
			comboBox_emp_action.setModel(new DefaultComboBoxModel(new String[] {"Show & Adjust", "Add Employee", "Delete Employee"}));
			function = (String) comboBox_emp_action.getSelectedItem(); //get the selected item
			comboBox_emp_action.addActionListener(new ActionListener() {
				@Override
	            public void actionPerformed(ActionEvent e) {
					function = (String) comboBox_emp_action.getSelectedItem();
				         	
					if (function.equals("Show & Adjust")) {
		        		//visibility
						
						btn_emp_execute.setText("Save Change");
						set_visible(false);
						lbl_emp_info.setVisible(false);
						lbl_empID_show.setVisible(false);
			    		btn_emp_confirmID.setVisible(true);
				            		
			    		//textField
			    		clear_text();
			    		
		            }else if (function.equals("Add Employee")) {
				   		//visibility
		            	btn_emp_execute.setText("Save Change");
				   		set_visible(true);
		         		lbl_emp_info.setVisible(false);
		         		lbl_empID_show.setVisible(false);
			       		btn_emp_confirmID.setVisible(false);
					          		
			      		//textField
	            		clear_text();
	            		
	            	}else{
	           			//visibility
	            		btn_emp_execute.setText("Delete");
		            	set_visible(false);
		            	lbl_emp_info.setVisible(false);
		            	lbl_empID_show.setVisible(false);
		            	btn_emp_confirmID.setVisible(true);
			           	//textField
			      		clear_text();
			       	}
				}
			});
			employee_panel.add(comboBox_emp_action);
						

			lbl_empID_show = new JLabel("");
			lbl_empID_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_empID_show.setBounds(230, 74, 202, 16);
			lbl_empID_show.setVisible(false);
			employee_panel.add(lbl_empID_show);

			JLabel lbl_emp_empID = new JLabel("Employee ID :");
			lbl_emp_empID.setBounds(115, 73, 86, 16);
			employee_panel.add(lbl_emp_empID);
						
			text_emp_empID = new JTextField();
			text_emp_empID.setBounds(230, 68, 202, 26);
			employee_panel.add(text_emp_empID);
			text_emp_empID.setColumns(16);
			
			lbl_emp_first = new JLabel("First Name :");
			lbl_emp_first.setBounds(115, 101, 76, 16);
			lbl_emp_first.setVisible(false);
			employee_panel.add(lbl_emp_first);
						
			text_emp_first = new JTextField();
			text_emp_first.setBounds(230, 96, 202, 26);
			text_emp_first.setVisible(false);
			employee_panel.add(text_emp_first);
			text_emp_first.setColumns(16);
						
			lbl_emp_last = new JLabel("Last Name :");
			lbl_emp_last.setBounds(115, 127, 74, 16);
			lbl_emp_last.setVisible(false);
			employee_panel.add(lbl_emp_last);
					
			text_emp_last = new JTextField();
			text_emp_last.setBounds(230, 122, 202, 26);
			text_emp_last.setVisible(false);
			employee_panel.add(text_emp_last);
			text_emp_last.setColumns(16);
						
			text_emp_addr = new JTextField();
			text_emp_addr.setBounds(230, 148, 202, 26);
			text_emp_addr.setVisible(false);
						
			lbl_emp_addr = new JLabel("Address :");
			lbl_emp_addr.setBounds(115, 153, 59, 16);
			lbl_emp_addr.setVisible(false);
			employee_panel.add(lbl_emp_addr);
			employee_panel.add(text_emp_addr);
			text_emp_addr.setColumns(16);
			
			lbl_emp_phone = new JLabel("Phone Number :");
			lbl_emp_phone.setBounds(115, 179, 100, 16);
			lbl_emp_phone.setVisible(false);
			employee_panel.add(lbl_emp_phone);
						
			text_emp_phone = new JTextField();
			text_emp_phone.setBounds(230, 174, 202, 26);
			text_emp_phone.setVisible(false);
			employee_panel.add(text_emp_phone);
			text_emp_phone.setColumns(16);
						
			lbl_emp_supervID = new JLabel("Supervisor ID :");
			lbl_emp_supervID.setBounds(115, 205, 92, 16);
			lbl_emp_supervID.setVisible(false);
			employee_panel.add(lbl_emp_supervID);
						
			text_emp_supervID = new JTextField();
			text_emp_supervID.setBounds(230, 200, 202, 26);
			text_emp_supervID.setVisible(false);
			employee_panel.add(text_emp_supervID);
			text_emp_supervID.setColumns(16);
						
			lbl_emp_perf = new JLabel("Performance :");
			lbl_emp_perf.setBounds(115, 234, 86, 16);
			lbl_emp_perf.setVisible(false);
			employee_panel.add(lbl_emp_perf);
						
			comboBox_emp_perf = new JComboBox();
			comboBox_emp_perf.setBounds(230, 229, 65, 27);
			comboBox_emp_perf.setForeground(Color.BLACK);
			comboBox_emp_perf.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C"}));
			comboBox_emp_perf.setVisible(false);
			employee_panel.add(comboBox_emp_perf);
						
			btn_emp_confirmID = new JButton("Confirm");
			btn_emp_confirmID.setBounds(449, 67, 95, 29);
			btn_emp_confirmID.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	try{
	            		Integer.parseInt(text_emp_empID.getText());
					   // test empID.getText() is blank or alphabet
				     			   
	            		String []temp = new String[] {"11047602","Abner","Williams",
	            							"Taoyuan","(09)11091002","11047600","C"}; //for testing without connection
		            	
		            	//String []temp = check(text_emp_empID);
		            	if(temp.length!=0) {
		            		
		            		lbl_empID_show.setText(text_emp_empID.getText());;
		            		lbl_empID_show.setVisible(true);
		            		text_emp_empID.setVisible(false);
		            		
		            		lbl_emp_first.setVisible(true);
		            		text_emp_first.setVisible(true);
		            		text_emp_first.setText(temp[1]);
		            		
		            		lbl_emp_last.setVisible(true);
		            		text_emp_last.setVisible(true);
		            		text_emp_last.setText(temp[2]);
		            		
		            		lbl_emp_addr.setVisible(true);
		            		text_emp_addr.setVisible(true);
		            		text_emp_addr.setText(temp[3]);
		            		
		            		lbl_emp_phone.setVisible(true);
		            		text_emp_phone.setVisible(true);
		            		text_emp_phone.setText(temp[4]);
		            		
		            		lbl_emp_supervID.setVisible(true);
		            		text_emp_supervID.setVisible(true);
		            		text_emp_supervID.setText(temp[5]);
		            		
		            		lbl_emp_perf.setVisible(true);
		            		
		            		comboBox_emp_perf.setVisible(true);
		            		comboBox_emp_perf.setSelectedItem(temp[6]);
		            		
		            		btn_emp_execute.setVisible(true);
		            		
		            		lbl_emp_info.setText("Data loaded");
					     	lbl_emp_info.setVisible(true);
					     	
		            	}else {
		            		//temp.length==0
		            		lbl_emp_info.setText("Data no found");
					     	lbl_emp_info.setVisible(true);
					     	
					     	lbl_empID_show.setText("");;
		            		lbl_empID_show.setVisible(false);
		            		text_emp_empID.setVisible(true);
		            		
		            		lbl_emp_first.setVisible(false);
		            		text_emp_first.setVisible(false);
		            		text_emp_first.setText("");
		            		
		            		lbl_emp_last.setVisible(false);
		            		text_emp_last.setVisible(false);
		            		text_emp_last.setText("");
		            		
		            		lbl_emp_addr.setVisible(false);
		            		text_emp_addr.setVisible(false);
		            		text_emp_addr.setText("");
		            		
		            		lbl_emp_phone.setVisible(false);
		            		text_emp_phone.setVisible(false);
		            		text_emp_phone.setText("");
		            		
		            		lbl_emp_supervID.setVisible(false);
		            		text_emp_supervID.setVisible(false);
		            		text_emp_supervID.setText("");
		            		
		            		lbl_emp_perf.setVisible(false);
					     	
		            		
		            	}
				    }catch (NumberFormatException ex) {
					    //handle exception here
				     	lbl_emp_info.setText("Format Invalid");
				     	lbl_emp_info.setVisible(true);
				     	
				     	lbl_empID_show.setText("");;
	            		lbl_empID_show.setVisible(false);
	            		text_emp_empID.setVisible(true);
	            		
	            		lbl_emp_first.setVisible(false);
	            		text_emp_first.setVisible(false);
	            		text_emp_first.setText("");
	            		
	            		lbl_emp_last.setVisible(false);
	            		text_emp_last.setVisible(false);
	            		text_emp_last.setText("");
	            		
	            		lbl_emp_addr.setVisible(false);
	            		text_emp_addr.setVisible(false);
	            		text_emp_addr.setText("");
	            		
	            		lbl_emp_phone.setVisible(false);
	            		text_emp_phone.setVisible(false);
	            		text_emp_phone.setText("");
	            		
	            		lbl_emp_supervID.setVisible(false);
	            		text_emp_supervID.setVisible(false);
	            		text_emp_supervID.setText("");
	            		
	            		lbl_emp_perf.setVisible(false);
						}    	
	            	}
	            });
			employee_panel.add(btn_emp_confirmID);
						
			
						
			btn_emp_execute = new JButton();
			btn_emp_execute.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (btn_emp_execute.getText().equalsIgnoreCase("Save Change")) {
						if(lib.supervisor_check(text_emp_supervID)) {
								if(save_change(text_emp_empID)==1){
									
									lbl_emp_info.setText("Modification succeed");
									lbl_emp_info.setVisible(true);	
								}else {
									//save_change(text_emp_empID)==0
									lbl_emp_info.setText("Modification failed");
									lbl_emp_info.setVisible(true);
								}
						}else {
							lbl_emp_info.setText("Supervisor ID is not in Employee table or format invalid.");
							lbl_emp_info.setVisible(true);
						}
					}else if(btn_emp_execute.getText().equalsIgnoreCase("Delete Employee")) {
						
							//delete_emp(text_emp_empID);
						}
					lbl_emp_info.setVisible(true);
					}
				});
			btn_emp_execute.setBounds(266, 281, 130, 29);
			btn_emp_execute.setVisible(false);
			employee_panel.add(btn_emp_execute);
					
			lbl_emp_info = new JLabel("Message of execute result");
			lbl_emp_info.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_emp_info.setBounds(115, 332, 434, 16);
			lbl_emp_info.setVisible(false);
			employee_panel.add(lbl_emp_info);
			
			
						
		}
		
		
		
		
		private String[] check(JTextField empID) {
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
		
		
		
		
		private int save_change(JTextField empID) {
			/**
			 * @author jyunanyang
			 * @since 05/30/2021
			 * the action after click button save_change in employee panel- show and adjust
			 */
			int r = 0;
			try {
				 r = Term_project_main.conn.st.executeUpdate("UPDATE EMPLOYEE SET First_name=\'"+text_emp_first.getText()+ "\', Last_name=\'"
						 		+text_emp_last.getText()+"\', Address=\'"+text_emp_addr.getText()
								+ "\', Phone_number=\'"+ text_emp_phone.getText()+"\', Supervisor_ID="+text_emp_supervID.getText()
								+ ", Performance=\'"+comboBox_emp_perf.getSelectedItem()+"\' WHERE Emp_ID="+lbl_empID_show.getText());
				return r;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return r;
			}
		}
		
		
		
		private void delete_emp(JTextField empID) {
			
			try {
				int resultSet = Term_project_main.conn.st.executeUpdate("DELETE FROM EMPLOYEE WHERE Emp_ID="+empID.getText());
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//Author: Ray
		//Date: 05/31
		//clear all input in JTextField
		public void clear_text() {
			
			text_emp_empID.setText("");
    		text_emp_first.setText("");
    		text_emp_last.setText("");
    		text_emp_addr.setText("");
    		text_emp_phone.setText("");
    		text_emp_supervID.setText("");
		}
		
		private void set_visible(boolean bl) {
			
			lbl_emp_first.setVisible(bl);
			text_emp_first.setVisible(bl);
			lbl_emp_last.setVisible(bl);
			text_emp_last.setVisible(bl);
			lbl_emp_addr.setVisible(bl);
			text_emp_addr.setVisible(bl);
			lbl_emp_phone.setVisible(bl);
			text_emp_phone.setVisible(bl);
			lbl_emp_supervID.setVisible(bl);
			text_emp_supervID.setVisible(bl);
			lbl_emp_perf.setVisible(bl);
			comboBox_emp_perf.setVisible(bl);
			btn_emp_execute.setVisible(bl);
			
				
		}
	
		public JComboBox get_comboBox_employeeAction() {
			
			return comboBox_emp_action;
		}
		
		public JTextField get_text_emp_empID() {
			
			return text_emp_empID;
		}
		
		public JTextField get_text_emp_first() {
			
			return text_emp_first;
		}
		
		public JTextField get_text_emp_last() {
			
			return text_emp_last;
		}
		
		public JTextField get_text_emp_addr() {
			
			return text_emp_addr;
		}
		
		public JTextField get_text_emp_phone() {
			
			return text_emp_phone;
		}
		
		public JTextField get_text_emp_supervID() {
			
			return text_emp_supervID;
		}
		
		public JComboBox get_comboBox_emp_perf() {
			
			return comboBox_emp_perf;
		}
}
