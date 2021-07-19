package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

class Library {

	private String[][] temp;

	String[][] show_unsign_req() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		ArrayList<String[]> temp = new ArrayList();

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT * FROM test.view_unsigned_req WHERE Supervisor_ID=?");
			ps.setString(1, Term_project_main.field_empID.getText());

			result = ps.executeQuery();

			while (result.next()) {

				String[] temp_array = new String[12];

				for (int i = 1; i < 13; i++) {

					temp_array[i - 1] = result.getString(i);
				}
				temp.add(temp_array);
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

		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;
	}

	void adjust_PROJECT() {

		/**
		 * @author jyunanyang
		 * @since 06/04/2021
		 * 
		 *        to update whole PROJECT table
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet result = null;

		ArrayList<String[]> temp = new ArrayList();

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			ps1 = conn.prepareStatement("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
			ps1.executeUpdate();
			ps2 = conn.prepareStatement("SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
			ps2.executeUpdate();

			ps = conn.prepareStatement("SELECT pj.Project_ID,RFQ.Sheet_type,QUOT.Sheet_type, REQ.Sheet_type, \n"
					+ "PUR.Sheet_type, EXAM.Sheet_type, RCPT.Sheet_type\n"
					+ "FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
					+ "LEFT JOIN test.QUOTATION AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
					+ "LEFT JOIN test.REQUISITION AS REQ ON REQ.Project_ID = pj.Project_ID\n"
					+ "LEFT JOIN test.PURCHASE AS PUR ON PUR.Project_ID = pj.Project_ID\n"
					+ "LEFT JOIN test.EXAMINATION AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
					+ "LEFT JOIN test.RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID GROUP BY pj.Project_ID");

			result = ps.executeQuery();

			while (result.next()) {
				String[] temp_array = new String[2];
				for (int i = 2; i < 8; i++) {
					temp_array[0] = result.getString(1);

					if (result.getString(i) == null) {
						if (i == 2) {
							temp_array[1] = "just started";
							break;
						} else {
							break;
						}
					} else {
						temp_array[1] = result.getString(i);
					}
				}
				temp.add(temp_array);
			}
			
			for (int l = 0; l < temp.size(); l++) {

				ps = conn.prepareStatement("UPDATE test.PROJECT SET Project_status=? WHERE Project_ID=?");
				ps.setString(1, temp.get(l)[1]);
				ps.setString(2, temp.get(l)[0]);
				ps.executeUpdate();
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


	}

	String[][] show_project_status() {

		/**
		 * @author jyunanyang
		 * @since 06/16/2021
		 * 
		 *        only used for employee's reminder
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		String st_progress = "SELECT * FROM VIEW_PROJECT_PROGRESS";

		ArrayList<String[]> temp = new ArrayList();

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			ps = conn.prepareStatement(
					"SELECT * FROM VIEW_PROJECT_PROGRESS  WHERE (P_Delivery_pct<50 AND Date_diff>29 AND Emp_ID=?) ORDER BY Date_diff DESC");
			ps.setString(1, Term_project_main.field_empID.getText());
			result = ps.executeQuery();

			while (result.next()) {

				String[] temp_array = new String[12];
				for (int i = 1; i < 13; i++) {

					if (i == 6)
						temp_array[i - 1] = (result.getString(i) + "%");

					else
						temp_array[i - 1] = result.getString(i);
					// System.out.print(temp_array[i-1]);
				}
				temp.add(temp_array);

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

		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		// System.out.print(result_array.length);
		return result_array;
	}

	boolean num_not_null_check(JTextField num) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 */
		boolean res = false;

		try {
			Integer.parseInt(num.getText());
			// test empID.getText() is blank or alphabet
			res = true;

		} catch (NumberFormatException ex) {
			// handle exception here
			return res;
		}

		return res;
	}

	boolean supplier_check(JTextField supID) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 *        to test supID.getText() is blank or alphabet and verify it's in our
		 *        Supplier table or not
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		boolean res = false;

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			ps = conn.prepareStatement("SELECT Supplier_ID FROM test.SUPPLIER WHERE Supplier_ID=?");
			ps.setString(1, supID.getText());
			result = ps.executeQuery();

			if (result.next()) {

				res = true;
			}
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return res;
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
	}

	boolean projectID_check(JTextField pjID) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 *        to test projectID.getText() is blank or alphabet and verify it's in
		 *        our PORJECT table or not
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		boolean res = false;
		try {
			Integer.parseInt(pjID.getText());
			// test empID.getText() is blank or alphabet

		} catch (NumberFormatException ex) {
			// handle exception here
			return res;
		}

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT Project_ID FROM test.PROJECT WHERE Project_ID=?");
			ps.setString(1, pjID.getText());
			result = ps.executeQuery();

			if (result.next()) {

				res = true;
			}
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return res;
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
	}

	boolean module_check(JTextField module) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 *        to test module.getText() is blank or alphabet and verify it's in our
		 *        PORJECT table or not
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;
		boolean res = false;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement("SELECT Module_type FROM test.PRODUCT WHERE Module_type=?");
			ps.setString(1, module.getText());
			result = ps.executeQuery();

			if (result.next()) {

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

	boolean tf_check(JTextField tf) {

		boolean res = false;

		if (tf.getText().equalsIgnoreCase("true")) {

			res = true;
		} else if (tf.getText().equalsIgnoreCase("false")) {

			res = true;
		}

		return res;
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

	boolean date(String strDate) {

		/**
		 * Reference: https://beginnersbook.com/2013/05/java-date-format-validation/
		 */

		/* Check if date is 'null' */
		if (strDate.trim().equals("")) {

			return false;

		} else {
			/* Date is not 'null' */

			/*
			 * Set preferred date format, For example yyyy-mm-dd, MM.dd.yyyy,dd.MM.yyyy etc.
			 */
			SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-mm-dd");
			sdfrmt.setLenient(false);
			/*
			 * Create Date object parse the string into date
			 */
			try {
				Date javaDate = sdfrmt.parse(strDate);

			} catch (ParseException e) {
				/* Date format is invalid */
				return false;
			}
			/* Return true if date format is valid */
			return true;
		}

	}

	String[] insert(String[] input, String string, int index) {

		/**
		 * Reference:
		 * https://www.techiedelight.com/insert-element-array-specific-index-java/
		 * 
		 * to insert a key in specified index into an array.
		 * 
		 */

		String[] result = new String[input.length + 1];

		System.arraycopy(input, 0, result, 0, index);
		result[index] = string;
		System.arraycopy(input, index, result, index + 1, input.length - index);

		return result;
	}

	String check_text_fields(JTextField ID, JTextField else1, JTextField else2) {
		/**
		 * @author maxence2997
		 * @since 06/02/2021 to check how many JTextField are filled by user and return
		 *        a String to be represent the status for switch case in inquire
		 *        function.
		 */

		if (!(ID.getText().isBlank())) {
			// 1
			if (!(else1.getText().isBlank())) {
				// 1-1
				if (!(else2.getText().isBlank())) {
					// 1-1-1
					return "111";
				} else {
					// 1-1-0
					return "110";
				}
			} else if (!(else2.getText().isBlank())) {
				// 1-0-1
				return "101";
			} else {
				// 1-0-0
				return "100";
			}
		} else if (!(else1.getText().isBlank())) {
			// 0-1
			if (!(else2.getText().isBlank())) {
				// 0-1-1
				return "011";
			} else {
				// 0-1-0
				return "010";
			}
		} else {
			// 0-0-1
			return "001";
		}

	}

	String which_is_blank(String temp[]) {
		/**
		 * @author jyunanyang
		 * @since 07/17/2021
		 * 
		 *        to check which String is/are blank and return a String to represent
		 *        the status for switch case in inquire function.
		 */

		if (!(temp[0].isBlank())) {
			// 1
			if (!(temp[1].isBlank())) {
				// 1-1
				if (!(temp[2].isBlank())) {
					// 1-1-1
					return "None of them";
				} else {
					// 1-1-0
					return "the third one";
				}
			} else {
				// 1-0
				if (!(temp[2].isBlank())) {

					// 1-0-1
					return "the second one";

				} else {
					// 1-0-0
					return "the second and the third one";
				}
			}
		} else {
			// 0
			if (!(temp[1].isBlank())) {
				// 0-1
				if (!(temp[2].isBlank())) {
					// 0-1-1
					return "the first one";
				} else {
					// 0-1-0
					return "the first and the third one";
				}
			} else {
				// 0-0
				if (!temp[2].isBlank())
					// 0-0-1
					return "the first and the second one";

				else
					// 0-0-0
					return "All";
			}
		}

	}

	String check_text_fields(JTextField ID, JTextField else1) {
		/**
		 * @author jyunanyang
		 * @since 06/02/2021 to check how many JTextField are filled by user and return
		 *        a String to be represente the status for switch case in inquire
		 *        function.
		 */

		if (!(ID.getText().isBlank())) {
			// 1
			if (!(else1.getText().isBlank())) {
				// 1-1
				return "11";
			} else {
				// 1-1-0
				return "10";
			}
		} else {
			// 1-0-1
			return "01";
		}
	}

	ArrayList<String> rmv_mod_check(JTextField text1, JTextField text2, JTextField text3, JTextField text4) {

		/**
		 * @author jyunanyang
		 * @since 05/06/2021
		 */

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result = null;

		ArrayList<String> temp = new ArrayList();

		int id = Integer.parseInt(text1.getText());

		try {

			if (id >= 21000000 & id < 22000000) {
				// RFQ

				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_rfq WHERE (Sheet_ID=? AND Project_ID=? AND Module=? AND Supplier_ID=?)");
				ps.setString(1, text1.getText());
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());
				ps.setString(4, text4.getText());
				System.out.print(ps);
				result = ps.executeQuery();

				while (result.next()) {

					for (int i = 1; i < 9; i++) {

						temp.add(result.getString(i));
					}
				}

			} else if (id >= 22000000 & id < 23000000) {
				// QUOT

				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_quotation WHERE (Sheet_ID=? AND Project_ID=? AND Module=? AND Supplier_ID=?)");
				ps.setString(1, text1.getText());
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());
				ps.setString(4, text4.getText());
				result = ps.executeQuery();

				while (result.next()) {

					for (int i = 1; i < 12; i++)

						temp.add(result.getString(i));
				}

			} else if (id >= 23000000 & id < 24000000) {
				// REQ

				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_requisition WHERE (Sheet_ID=? AND Project_ID=? AND Module=?)");
				ps.setString(1, text1.getText());
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());

				result = ps.executeQuery();

				while (result.next()) {

					for (int i = 1; i < 13; i++) {

						temp.add(result.getString(i));
					}
				}

			} else if (id >= 24000000 & id < 25000000) {
				// PURC

				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_purchase WHERE (Sheet_ID=? AND Project_ID=? AND Module=? AND Supplier_ID=?)");
				ps.setString(1, text1.getText());
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());
				ps.setString(4, text4.getText());
				result = ps.executeQuery();

				while (result.next()) {

					for (int i = 1; i < 12; i++) {
						// System.out.print(r.getString(i)+"\t");
						temp.add(result.getString(i));

					}
					// System.out.print("\n");
				}

			} else if (id >= 25000000 & id < 26000000) {
				// EXAM

				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_examination WHERE (Sheet_ID=? AND Project_ID=? AND Module=? AND Supplier_ID=?)");
				ps.setString(1, text1.getText());
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());
				ps.setString(4, text4.getText());
				result = ps.executeQuery();

				while (result.next()) {

					for (int i = 1; i < 10; i++) {

						temp.add(result.getString(i));
					}
				}

			} else if (id >= 26000000 & id < 27000000) {
				// RCPT

				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_receipt WHERE (Sheet_ID=? AND Project_ID=? AND Module=? AND Supplier_ID=?)");
				ps.setString(1, text1.getText());
				ps.setString(2, text2.getText());
				ps.setString(3, text3.getText());
				ps.setString(4, text4.getText());
				result = ps.executeQuery();

				while (result.next()) {

					for (int i = 1; i < 9; i++) {

						temp.add(result.getString(i));
					}
				}
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
		return temp;

	}

	void sort(String[][] array) {
		this.temp = array;

		quickSort(0, temp.length - 1);
		// System.out.println("Done");
	}

	private void quickSort(int leftbound, int rightbound) {
		// 1. implement quickSort algorithm

		if (leftbound > rightbound)
			return;

		int pivot = Integer.parseInt(temp[rightbound][0]);
		int right = rightbound - 1;
		int left = leftbound;
		int swapindex = leftbound;
		for (int i = left; i <= right; i++) {
			if (Integer.parseInt(temp[i][0]) < pivot) {
				swap(swapindex, i);
				swapindex++;

			}

		}
		swap(swapindex, rightbound);
		quickSort(leftbound, swapindex - 1);
		quickSort(swapindex + 1, rightbound);

	}

	private void swap(int aIndex, int bIndex) {
		String[] temp2 = temp[aIndex];
		temp[aIndex] = temp[bIndex];
		temp[bIndex] = temp2;
	}
}
