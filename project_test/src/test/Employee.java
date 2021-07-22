package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;

class Employee {
	/**
	 * @author maxence2997
	 * @date 07/20/2021
	 * @version 1.0 Description:
	 **/

//	Connection conn = null;
//	PreparedStatement ps = null;
//	ResultSet result = null;

	String[][] show_more(String empID) {

		ArrayList<String[]> temp = new ArrayList();
		String[][] result_array = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

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

	ArrayList<String> check(String empID) {
		/**
		 * @author jyunanyang
		 * @since 05/30/2021
		 * 
		 *        the action after click button confirm in employee panel- show and
		 *        adjust set instruction of SQL
		 */
		ArrayList<String> temp = new ArrayList();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT * FROM EMPLOYEE WHERE Emp_ID=?");
			ps.setString(1, empID);

			result = ps.executeQuery();

			if (result.next()) {

				for (int i = 1; i < 8; i++) {
					temp.add(result.getString(i));
				}
			}
			return temp;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return temp;
		}
	}

	int save_change(String temp[]) {
		/**
		 * @author maxence2997
		 * @since 05/30/2021 the action after click button save_change in employee
		 *        panel- show and adjust
		 * @date 07/21/2021, refactored
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		int r = 0;

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement(
					"UPDATE test.EMPLOYEE SET First_name=?, Last_name=?, Address=?, Phone_number=?, Supervisor_ID=?, Performance=? WHERE Emp_ID=?");

			for (int i = 0; i < 7; i++)

				ps.setString(i + 1, temp[i].isBlank() ? null : temp[i]);

			r = ps.executeUpdate();

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

		return r;
	}

	String add(String temp[]) {
		/**
		 * @author maxence2997
		 * @since 06/09/2021
		 * 
		 * @date 07/21/2021, refactored
		 */

		int r = 0;
		String result_string = null;

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet result = null;

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement(
					"INSERT INTO test.EMPLOYEE(First_name, Last_name, Address, Phone_number, Supervisor_ID, Performance)  VALUE( ?,?,?,?,?,?)");

			for (int i = 0; i < 6; i++)
				ps.setString(i + 1, temp[i].isBlank() ? null : temp[i]);

			r = ps.executeUpdate();

			if (r == 1) {
				// employee added
				ps2 = conn.prepareStatement("SELECT Emp_ID FROM EMPLOYEE ORDER BY Emp_ID DESC LIMIT 1");

				result = ps2.executeQuery();

				if (result.next())
					result_string = result.getString(1);
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
		return result_string;

	}

	int delete_emp(String empID) {

		int r = 0;
		String temp_supv = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {
			// re-assign supervisor for subordinates of the employee who is going to be
			// deleted

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			// check his supervisor
			ps = conn.prepareStatement("SELECT Supervisor_ID FROM EMPLOYEE WHERE Emp_ID=?");
			ps.setString(1, empID);
			result = ps.executeQuery();

			if (result.next())
				// if employee who is going to be deleted has the supervisor
				temp_supv = result.getString(1);

			if (ps != null)
				ps.close();

			if (result != null)
				result.close();

			// check his subordinates
			ArrayList<String> subordinates = new ArrayList();

			ps = conn.prepareStatement("SELECT Emp_ID FROM EMPLOYEE WHERE Supervisor_ID=?");
			ps.setString(1, empID);
			result = ps.executeQuery();

			while (result.next())
				// if employee who is going to be deleted has subordinates
				subordinates.add(result.getString(1));
			if (ps != null)
				ps.close();

			if (result != null)
				result.close();
			// check his project
			ArrayList<String> pjs = new ArrayList();

			ps = conn.prepareStatement("SELECT Project_ID FROM PROJECT WHERE Emp_ID =?");
			ps.setString(1, empID);
			result = ps.executeQuery();

			while (result.next())
				// if employee who is going to be deleted has basic emp under him/her
				pjs.add(result.getString(1));

			if (ps != null)
				ps.close();

			if (result != null)
				result.close();

			if (temp_supv != null) {
				// has supervisor
				if (subordinates.size() != 0) {
					// hse subordinates

					for (int i = 0; i < subordinates.size(); i++) {
						ps = conn.prepareStatement("UPDATE test.EMPLOYEE SET Supervisor_ID=? WHERE Emp_ID=?");
						ps.setString(1, temp_supv);
						ps.setString(2, subordinates.get(i));
						ps.executeUpdate();
					}
				}

				if (pjs.size() != 0) {
					// has projects
					for (int i = 0; i < subordinates.size(); i++) {

						ps = conn.prepareStatement("UPDATE test.PROJECT SET Emp_ID=? WHERE Project_ID=?");
						ps.setString(1, temp_supv);
						ps.setString(2, pjs.get(i));
						ps.executeUpdate();

					}
				}

				ps = conn.prepareStatement("DELETE FROM test.EMPLOYEE WHERE Emp_ID=?");
				ps.setString(1, empID);
				r = ps.executeUpdate();

				if (ps != null)
					ps.close();

			} else {
				// doesn't have supervisor
				if (subordinates.size() == 0 & pjs.size() == 0) {
					// hse no subordinate

					ps = conn.prepareStatement("DELETE FROM test.EMPLOYEE WHERE Emp_ID=?");
					ps.setString(1, empID);
					r = ps.executeUpdate();

					if (ps != null)
						ps.close();

				} else
					r = -2;
				// lbl_emp_info.setText("Request failed,you should re-assign manually his works
				// to someone else first");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			r = -1;
			// lbl_emp_info.setText("Request failed, errors occured.");

		} finally {

			try {
				if (result != null)
					result.close();

				if (ps != null)
					ps.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}
			System.out.println("closed");

		}
		return r;
	}

	String[][] show_table(String empID) {

		ArrayList<String[]> temp = new ArrayList();
		String[][] result_array = null;

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT * FROM VIEW_EMPLOYEE_SUPERVISOR WHERE Emp_ID=?");
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

	boolean emp_check(JTextField empID) {

		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 * 
		 *        to test empID.getText() is blank or alphabet and verify it's in our
		 *        Employee table or not
		 */

		try {
			Integer.parseInt(empID.getText());
			// test empID.getText() is blank or alphabet

		} catch (NumberFormatException ex) {
			// handle exception here

			return false;
		}

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT Emp_ID FROM test.EMPLOYEE WHERE Emp_ID=?");
			ps.setString(1, empID.getText());
			result = ps.executeQuery();

			if (result.next()) {

				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

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
		return false;
	}

	boolean supervisor_check(JTextField empID) {

		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 */

		boolean res = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT Supervisor_ID FROM test.EMPLOYEE WHERE Supervisor_ID=?");
			ps.setString(1, empID.getText());
			result = ps.executeQuery();

			if (result.next()) {

				// System.out.println(r.getString(1));
				res = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

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
		return res;
	}
}
