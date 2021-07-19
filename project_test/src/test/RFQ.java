package test;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class RFQ extends Sheets {

	private String supplier_ID;

	RFQ() {

	}

	RFQ(int sheet_ID, String type, int project_ID, String module, Date date, int vol, String supplier_ID) {
		super(sheet_ID, type, project_ID, module, date, vol);
		this.supplier_ID = supplier_ID;

		// TODO Auto-generated constructor stub
	}

	@Override
	String[][] inquire(String[] temp) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/17/2021
		 * @version 1.0
		 * 
		 **/

		String[][] rfq = null;

		switch (Term_project_main.lib.which_is_blank(temp)) {

		case "None of them":

			try {
				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_rfq WHERE (Sheet_ID=? AND Project_ID =? AND Module=?)");
				ps.setString(1, temp[0]);
				ps.setString(2, temp[1]);
				ps.setString(3, temp[2]);
				result = ps.executeQuery();

				if (result.next()) {
					rfq = new String[1][8];

					for (int i = 1; i < 9; i++)
						rfq[0][i - 1] = result.getString(i);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			} finally {
				try {
					if (this.result != null) {
						this.result.close();
					}
					if (this.ps != null) {
						this.ps.close();
					}
					if (this.conn != null) {
						this.conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} 
					System.out.println("closed");
				
			}

			break;

		case "the first one":

			rfq = inquire("sheet_ID", temp[1], temp[2]);

			break;

		case "the second one":

			rfq = inquire("project_ID", temp[0], temp[2]);

			break;

		case "the third one":

			rfq = inquire("module", temp[0], temp[1]);

			break;

		case "the first and the second one":

			rfq = inquire("module", temp[2]);

			break;

		case "the first and the third one":

			rfq = inquire("project_ID", temp[1]);

			break;

		case "the second and the third one":

			rfq = inquire("sheet_ID", temp[0]);

			break;

		default:

			break;

		}

		return rfq;
	}

	private String[][] inquire(String non_filled, String first, String second) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/17/2021
		 * @version 1.0
		 * 
		 **/

		String[][] rfq = null;
		ArrayList<String[]> temp = new ArrayList();

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (non_filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_rfq WHERE (Project_ID =? AND Module=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			} else if (non_filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_rfq WHERE (Sheet_ID =? AND Module=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			} else if (non_filled.equalsIgnoreCase("Module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_rfq WHERE (Sheet_ID =? AND Project_ID=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			try {
				if (this.result != null) {
					this.result.close();
				}
				if (this.ps != null) {
					this.ps.close();
				}
				if (this.conn != null) {
					this.conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
				System.out.println("closed");
			

			if (temp.size() > 0) {

				rfq = new String[temp.size()][8];
				int i = 0;
				for (String[] array_in_temp : temp) {
					rfq[i++] = array_in_temp;
				}
			}
		}
		return rfq;
	}

	private String[][] inquire(String filled, String first) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/17/2021
		 * @version 1.0
		 * 
		 **/

		String[][] rfq = null;
		ArrayList<String[]> temp = new ArrayList();

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_rfq WHERE Sheet_ID =? ");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_rfq WHERE Project_ID =?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_rfq WHERE Module=?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[8];

					for (int i = 1; i < 9; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (this.result != null) {
					this.result.close();
				}
				if (this.ps != null) {
					this.ps.close();
				}
				if (this.conn != null) {
					this.conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			} 
				System.out.println("closed");
			

			if (temp.size() > 0) {

				rfq = new String[temp.size()][8];
				int i = 0;
				for (String[] array_in_temp : temp) {
					rfq[i++] = array_in_temp;
				}
			}
		}

		return rfq;
	}

	@Override
	String[][] append() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	int modify(int id, String[] temp) {
		// TODO Auto-generated method stub
		/**
		*@author maxence2997
		*@date 07/19/2021
		*@version 1.0
		*Description:
		**/


		int r = 0;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement(
					"UPDATE test.RFQ SET Supplier_ID=?, Vol=?, Date=? WHERE (RFQ_Sheet_ID=? AND Project_ID=? AND Inquiring_product=?)");
			ps.setString(1, temp[0]);
			ps.setString(2, temp[1]);
			ps.setString(3, temp[2]);
			ps.setString(4, temp[3]);
			ps.setString(5, temp[4]);
			ps.setString(6, temp[5]);
			r = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {
			try {
				if (this.result != null) {
					this.result.close();
				}
				if (this.ps != null) {
					this.ps.close();
				}
				if (this.conn != null) {
					this.conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("closed");

		}
		return r;

	}

	@Override
	int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

}
