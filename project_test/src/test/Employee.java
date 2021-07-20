package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

class Employee {
	/**
	 * @author maxence2997
	 * @date 07/20/2021
	 * @version 1.0 Description:
	 **/

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet result = null;

	String[][] show_more(String empID) {

		ArrayList<String[]> temp = new ArrayList();
		String[][] result_array = null;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT * FROM VIEW_EMPLOYEE_PROJECT WHERE Emp_ID=?");
			ps.setString(1, empID);

			result = ps.executeQuery();

			while (result.next()) {
				String[] array = new String[5];
				for (int i = 1; i < 6; i++) {
					array[i - 1] = result.getString(i);
				}
				temp.add(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (result != null) {
					result.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
			System.out.println("closed");

		}

		if (temp.size() > 0) {
			result_array = new String[temp.size()][5];
			int i = 0;
			for (String[] array_in_temp : temp) {
				result_array[i++] = array_in_temp;
			}
		}
		return result_array;
	}

	String[][] show_table(String empID) {

		ArrayList<String[]> temp = new ArrayList();
		String[][] result_array = null;
		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT * FROM VIEW_EMPLOYEE_SUPERVISOR WHERE Emp_ID=");
			ps.setString(1, empID);

			result = ps.executeQuery();
			while (result.next()) {
				String[] array = new String[7];
				for (int i = 1; i < 8; i++) {
					array[i - 1] = result.getString(i);
				}
				temp.add(array);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (result != null) {
					result.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();

			}
			System.out.println("closed");

		}
		if (temp.size() > 0) {
			result_array = new String[temp.size()][7];
			int i = 0;
			for (String[] array_in_temp : temp) {
				result_array[i++] = array_in_temp;
			}
		}
		return result_array;
	}
}
