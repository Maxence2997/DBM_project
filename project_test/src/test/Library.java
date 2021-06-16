package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

public class Library {

	public Library() {

	}

	public String[][] show_unsign_req() {

		ArrayList<String[]> temp = new ArrayList();

		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT * FROM test.view_unsigned_req WHERE Supervisor_ID="
							+ Term_project_main.field_empID.getText());

			while (r.next()) {

				String[] temp_array = new String[12];

				for (int i = 1; i < 13; i++) {

					temp_array[i - 1] = r.getString(i);
				}
				temp.add(temp_array);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		return result_array;
	}

	
	public void adjust_PROJECT() {

		/**
		 * @author jyunanyang
		 * @since 06/04/2021
		 * 
		 *        to update whole PROJECT table
		 */

		ArrayList<String[]> temp = new ArrayList();

		try {
			ResultSet r = Term_project_main.conn.st
					.executeQuery("SELECT pj.Project_ID,RFQ.Sheet_type,QUOT.Sheet_type, REQ.Sheet_type, \n"
							+ "PUR.Sheet_type, EXAM.Sheet_type, RCPT.Sheet_type\n"
							+ "FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
							+ "LEFT JOIN test.QUOTATION AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
							+ "LEFT JOIN test.REQUISITION AS REQ ON REQ.Project_ID = pj.Project_ID\n"
							+ "LEFT JOIN test.PURCHASE AS PUR ON PUR.Project_ID = pj.Project_ID\n"
							+ "LEFT JOIN test.EXAMINATION AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
							+ "LEFT JOIN test.RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID GROUP BY pj.Project_ID");

			while (r.next()) {
				String[] temp_array = new String[2];
				for (int i = 2; i < 8; i++) {
					temp_array[0] = r.getString(1);

					if (r.getString(i) == null) {
						if (i == 2) {
							temp_array[1] = "just started";
							break;
						} else {
							break;
						}
					} else {
						temp_array[1] = r.getString(i);
					}
				}
				temp.add(temp_array);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int l = 0; l < temp.size(); l++) {

			try {
				int resultSet = Term_project_main.conn.st.executeUpdate("UPDATE test.PROJECT SET Project_status=\'"
						+ temp.get(l)[1] + "\' WHERE Project_ID=" + temp.get(l)[0]);

				;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	public String[][] show_project_status() {

		/**
		 * @author jyunanyang
		 * @since 06/16/2021
		 */

		final String st_progress = "SELECT * FROM VIEW_PROJECT_PROGRESS";

		ArrayList<String[]> temp = new ArrayList();

		
			try {
//				System.out.print(st_progress + " WHERE (P_Delivery_pct<50 AND Date_diff>29 AND Emp_ID="
//						+ Term_project_main.field_empID.getText() + ") ORDER BY Date_diff DESC");
//				
				ResultSet r = Term_project_main.conn.st.executeQuery(st_progress + " WHERE (P_Delivery_pct<50 AND Date_diff>29 AND Emp_ID="
						+ Term_project_main.field_empID.getText() + ") ORDER BY Date_diff DESC");

				while (r.next()) {

					String[] temp_array = new String[12];
					for (int i = 1; i < 13; i++) {
						
						if (i==6)
								temp_array[i-1]= (r.getString(i)+"%");
						
						else
							temp_array[i - 1] = r.getString(i);
							// System.out.print(temp_array[i-1]);
					}
					temp.add(temp_array);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		String[][] result_array = new String[temp.size()][12];
		int i = 0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		}
		// System.out.print(result_array.length);
		return result_array;
	}

	public boolean num_not_null_check(JTextField num) {

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

	public boolean supplier_check(JTextField supID) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 *        to test supID.getText() is blank or alphabet and verify it's in our
		 *        Supplier table or not
		 */

		boolean res = false;

		try {
			ResultSet r = Term_project_main.conn.st.executeQuery(
					"SELECT Supplier_ID FROM test.SUPPLIER WHERE Supplier_ID=\'" + supID.getText() + "\'");

			if (r.next()) {

				res = true;
			}
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return res;
		}
	}

	public boolean projectID_check(JTextField pjID) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 *        to test projectID.getText() is blank or alphabet and verify it's in
		 *        our PORJECT table or not
		 */
		boolean res = false;
		try {
			Integer.parseInt(pjID.getText());
			// test empID.getText() is blank or alphabet

		} catch (NumberFormatException ex) {
			// handle exception here
			return res;
		}

		try {
			ResultSet r = Term_project_main.conn.st
					.executeQuery("SELECT Project_ID FROM test.PROJECT WHERE Project_ID=" + pjID.getText());

			if (r.next()) {

				res = true;
			}
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return res;
		}
	}

	public boolean module_check(JTextField module) {

		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 *        to test module.getText() is blank or alphabet and verify it's in our
		 *        PORJECT table or not
		 */

		boolean res = false;

		try {
			ResultSet r = Term_project_main.conn.st.executeQuery(
					"SELECT Module_type FROM test.PRODUCT WHERE Module_type=\'" + module.getText() + "\'");

			if (r.next()) {

				res = true;
			}
			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return res;
		}
	}

	public boolean tf_check(JTextField tf) {

		boolean res = false;

		if (tf.getText().equalsIgnoreCase("true")) {

			res = true;
		} else if (tf.getText().equalsIgnoreCase("false")) {

			res = true;
		}

		return res;
	}

	public boolean emp_check(JTextField empID) {

		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 * 
		 *        to test empID.getText() is blank or alphabet and verify it's in our
		 *        Employee table or not
		 */

		boolean res = false;

		try {
			Integer.parseInt(empID.getText());
			// test empID.getText() is blank or alphabet

		} catch (NumberFormatException ex) {
			// handle exception here

			return res;
		}

		try {
			ResultSet r = Term_project_main.conn.st
					.executeQuery("SELECT Emp_ID FROM test.EMPLOYEE WHERE Emp_ID=" + empID.getText());

			if (r.next()) {

				res = true;
			}

			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			return res;
		}
	}

	public boolean supervisor_check(JTextField empID) {

		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 */

		boolean res = false;

		try {
			ResultSet r = Term_project_main.conn.st
					.executeQuery("SELECT Supervisor_ID FROM test.EMPLOYEE WHERE Supervisor_ID=" + empID.getText());

			if (r.next()) {

				// System.out.println(r.getString(1));
				res = true;
			}

			return res;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();

			return res;
		}

	}

	public boolean date(String strDate) {

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

	public String[] insert(String[] input, String string, int index) {

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

	public String check_text_fields(JTextField ID, JTextField else1, JTextField else2) {
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

	public String check_text_fields(JTextField ID, JTextField else1) {
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
}
