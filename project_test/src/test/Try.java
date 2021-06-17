package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

public class Try {
	
	private static Library lib;
	
	
	public static connection conn2;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		conn2= new connection();
		
		System.out.print(emp_check("11047611"));
	}



public static boolean emp_check(String empID) {

	/**
	 * @author jyunanyang
	 * @since 06/07/2021
	 * 
	 *        to test empID.getText() is blank or alphabet and verify it's in our
	 *        Employee table or not
	 */

	try {
		Integer.parseInt(empID);
		// test empID.getText() is blank or alphabet

	} catch (NumberFormatException ex) {
		// handle exception here

		return false;
	}

	try {
		ResultSet r = conn2.st
				.executeQuery("SELECT Emp_ID FROM test.EMPLOYEE WHERE Emp_ID=" + empID);

		if (r.next()) {

			return true;
		}

		return false;

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();

		return false;
	}
}}