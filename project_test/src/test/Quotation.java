package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author maxence2997
 * @date 07/17/2021
 * @version 1.0
 **/
class Quotation extends Sheets {

	/**
	 * @author maxence2997
	 * @date 07/17/2021
	 * @version 1.0
	 **/
	private String supplier_ID;
	private int unit_price;
	private int total_price;
	private Date ESD;

	Quotation(int sheet_ID, String type, int project_ID, String module, Date date, int vol, int unit_price,
			int total_price, String supplier_ID, Date ESD) {

		super(sheet_ID, type, project_ID, module, date, vol);

		this.supplier_ID = supplier_ID;
		this.unit_price = unit_price;
		this.total_price = total_price;
		this.ESD = ESD;

	}

	Quotation() {

	}

	@Override
	String[][] inquire(String[] temp) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0
		 * 
		 **/

		String[][] quot = null;

		switch (Term_project_main.lib.which_is_blank(temp)) {

		case "None of them":

			try {
				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_quotation WHERE (Sheet_ID=? AND Project_ID =? AND Module=?)");
				
				for(int i=0;i<3;i++) 
					ps.setString(i+1, temp[i]);
				
				result = ps.executeQuery();

				if (result.next()) {
					quot = new String[1][11];

					for (int i = 1; i < 12; i++)
						quot[0][i - 1] = result.getString(i);
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

			quot = inquire("sheet_ID", temp[1], temp[2]);

			break;

		case "the second one":

			quot = inquire("project_ID", temp[0], temp[2]);

			break;

		case "the third one":

			quot = inquire("module", temp[0], temp[1]);

			break;

		case "the first and the second one":

			quot = inquire("module", temp[2]);

			break;

		case "the first and the third one":

			quot = inquire("project_ID", temp[1]);

			break;

		case "the second and the third one":

			quot = inquire("sheet_ID", temp[0]);

			break;

		default:

			break;

		}

		return quot;
	}

	private String[][] inquire(String non_filled, String first, String second) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0
		 * 
		 **/

		String[][] quot = null;
		ArrayList<String[]> temp = new ArrayList();

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (non_filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_quotation WHERE (Project_ID =? AND Module=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			} else if (non_filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_quotation WHERE (Sheet_ID =? AND Module=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			} else if (non_filled.equalsIgnoreCase("Module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_quotation WHERE (Sheet_ID =? AND Project_ID=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
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

				quot = new String[temp.size()][11];
				int i = 0;
				for (String[] array_in_temp : temp) {
					quot[i++] = array_in_temp;
				}
			}
		}
		return quot;
	}

	private String[][] inquire(String filled, String first) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0
		 * 
		 **/

		String[][] quot = null;
		ArrayList<String[]> temp = new ArrayList();

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_quotation WHERE Sheet_ID =? ");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_quotation WHERE Project_ID =?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_quotation WHERE Module=?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
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

				quot = new String[temp.size()][11];
				int i = 0;
				for (String[] array_in_temp : temp) {
					quot[i++] = array_in_temp;
				}
			}
		}

		return quot;
	}

	@Override
	boolean append_check(String project_ID) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/19/2021
		 * @version 1.0
		 **/

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			ps = conn.prepareStatement("SELECT * FROM test.view_append_check WHERE Project_ID=? LIMIT 1");
			ps.setString(1, project_ID);
			result = ps.executeQuery();
			
			if (result.next()) {
				if (result.getString("RFQ_Sheet_ID") != null) {
					
					return true;
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

		}
		return false;
	}

	@Override
	String[][] append(String[] temp) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/19/2021
		 * @version 1.0
		 **/

		String[][] result_array = null;

		int r = 0;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			
			

			if (!temp[6].isBlank()) {

				ps = conn.prepareStatement(
						"INSERT INTO test.QUOTATION (Project_ID, Inquiring_product, Supplier_ID, Vol, Unit_price, ESD, Date) VALUE (?, ?, ?, ?, ?,?,?)");
				
				for(int i=0;i<7;i++) 
					ps.setString(i+1, temp[i]);
				
				
			} else {
				// temp[6].isBlank()
				ps = conn.prepareStatement(
						"INSERT INTO test.QUOTATION (Project_ID, Inquiring_product, Supplier_ID, Vol, Unit_price, ESD) VALUE (?, ?, ?, ?, ?,?)");
				
				for(int i=0;i<6;i++) 
					ps.setString(i+1, temp[i]);

			}

			r = ps.executeUpdate();

			if (r == 1) {

				result_array = new String[1][10];
				PreparedStatement ps2 = conn
						.prepareStatement("SELECT * FROM test.QUOTATION ORDER BY QUO_Sheet_ID DESC LIMIT 1");

				result = ps2.executeQuery();
				if (result.next()) {

					for (int i = 1; i < 11; i++) {
						result_array[0][i - 1] = result.getString(i);
					}
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

		}

		return result_array;
	}

	@Override
	int modify(int id, String[] temp) {
		// TODO Auto-generated method stub

		/**
		 * @author maxence2997
		 * @date 07/19/2021
		 * @version 1.0
		 **/

		int r = 0;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			
			ps = conn.prepareStatement(
					"UPDATE test.QUOTATION SET Supplier_ID=?, Vol=?, Unit_price=?, ESD=?, Date=? WHERE (QUO_Sheet_ID=? AND Project_ID=? AND Inquiring_product=?)");
			
			for(int i=0;i<8;i++) 
				ps.setString(i+1, temp[i]);
			
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
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0
		 **/

		return 0;
	}

}
