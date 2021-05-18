package test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JTextField;

public class Library {
	connection conn;
	
	public Library() {
		
		conn = new connection(); 
		//conn.instruction("sss");
		
	}
	
	public void instruction(String sql_lan) throws SQLException {
		/**
		 * This method is used to input SQL_instruction/language
		 * 
		 */
		
			try (ResultSet resultSet = conn.st.executeQuery(sql_lan)) {
				while (resultSet.next()) {
					System.out.println(resultSet.getString("Name") + "    " + resultSet.getString(
							"CountryCode") + "   " + resultSet.getString("District"));
				}
		   } catch (SQLException e) {
			   //e.printStackTrace();
			}
			
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
	
	
	public boolean is_supervisor() {
		/**
		 * To verify the ID logged in is supervisor or not
		 * 
		 * if it's supervisor ID, return true; else return false
		 */
		
		boolean supervisor;
		
		try {
			ResultSet resultSet = conn.st.executeQuery("SELECT Supervisor FROM EMPLOYEE WHERE Supervisor=" + Progect_test.field_empID.getText());
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
	
	public void btn_inquire() {
		/**
		 * the action after click btn_inqiure
		 * 
		 * set instruction of SQL 
		 * 
		 * return the result on Jtable 
		 */
		
		
		
	}
	
	public void btn_last20() {
		/**
		 * the action after click btn_last20
		 * 
		 * set instruction of SQL 
		 * 
		 * return the result on Jtable 
		 */
		
		
		
	}
	
	public String btn_modify() {
		/**
		 * the action after click btn_last20
		 * 
		 * set instruction of SQL 
		 * 
		 * return the result on Jtable 
		 */
		
		return"";
	}
	
	public String btn_append() {
		/**
		 * the action after click btn_append
		 * 
		 * set instruction of SQL 
		 * 
		 * return the result on Jtable 
		 */
		
		return"";
	}
	
	public String btn_remove() {
		/**
		 * the action after click btn_remove
		 * 
		 * set instruction of SQL 
		 * 
		 * return the result on Jtable 
		 */
		
		return"";
	}
	
	public String btn_confirm_remove() {
		/**
		 * the action after click btn_confirm on 
		 * 
		 * set instruction of SQL 
		 * 
		 * return the result on Jtable 
		 */
		
		return"";
	}
	
	public void btn_refresh() {
		/**
		 * To show unsigned order on the Jtable in sign_panel after click btn_refresh
		 * 
		 */
	}
	
	public void btn_sign() {
		/**
		 * the action after click btn_sign on 
		 * 
		 * set instruction of SQL to remove order
		 */
		
	}
	
	public void btn_inquire_invent() {
		/**
		 * the action after click btn_inquire on inventory panel
		 * 
		 * set instruction of SQL to inquire stock
		 */
		
	}
	
	
	public void btn_inquire_sup() {
		/**
		 * the action after click btn_inquire on inventory panel
		 * 
		 * set instruction of SQL to inquire stock
		 */
	}
}
