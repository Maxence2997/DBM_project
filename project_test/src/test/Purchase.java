package test;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author maxence2997
 * @date 07/18/2021
 * @version 1.0
 **/
class Purchase extends Sheets {

	private String supplier_ID;
	private int unit_price;
	private int total_price;
	private Date ESD;

	Purchase(int sheet_ID, String type, int project_ID, String module, Date date, int vol, int unit_price,
			int total_price, String supplier_ID, Date ESD) {

		// TODO Auto-generated constructor stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0 Description:
		 **/

		super(sheet_ID, type, project_ID, module, date, vol);

		this.supplier_ID = supplier_ID;
		this.unit_price = unit_price;
		this.total_price = total_price;
		this.ESD = ESD;

	}

	Purchase() {
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

		String[][] purchase = null;

		switch (Term_project_main.lib.which_is_blank(temp)) {

		case "None of them":

			try {
				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_purchase WHERE (Sheet_ID=? AND Project_ID =? AND Module=?)");
				ps.setString(1, temp[0]);
				ps.setString(2, temp[1]);
				ps.setString(3, temp[2]);
				result = ps.executeQuery();

				if (result.next()) {
					purchase = new String[1][11];

					for (int i = 1; i < 12; i++)
						purchase[0][i - 1] = result.getString(i);
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

			purchase = inquire("sheet_ID", temp[1], temp[2]);

			break;

		case "the second one":

			purchase = inquire("project_ID", temp[0], temp[2]);

			break;

		case "the third one":

			purchase = inquire("module", temp[0], temp[1]);

			break;

		case "the first and the second one":

			purchase = inquire("module", temp[2]);

			break;

		case "the first and the third one":

			purchase = inquire("project_ID", temp[1]);

			break;

		case "the second and the third one":

			purchase = inquire("sheet_ID", temp[0]);

			break;

		default:

			break;

		}

		return purchase;
	}

	private String[][] inquire(String non_filled, String first, String second) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/17/2021
		 * @version 1.0
		 * 
		 **/

		String[][] purchase = null;
		ArrayList<String[]> temp = new ArrayList();

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (non_filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_purchase WHERE (Project_ID =? AND Module=?)");
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

				ps = conn.prepareStatement("SELECT * FROM test.view_purchase WHERE (Sheet_ID =? AND Module=?)");
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

				ps = conn.prepareStatement("SELECT * FROM test.view_purchase WHERE (Sheet_ID =? AND Project_ID=?)");
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

				purchase = new String[temp.size()][11];
				int i = 0;
				for (String[] array_in_temp : temp) {
					purchase[i++] = array_in_temp;
				}
			}
		}
		return purchase;
	}

	private String[][] inquire(String filled, String first) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/17/2021
		 * @version 1.0
		 * 
		 **/

		String[][] purchase = null;
		ArrayList<String[]> temp = new ArrayList();

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_purchase WHERE Sheet_ID =? ");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_purchase WHERE Project_ID =?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[11];

					for (int i = 1; i < 12; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_purchase WHERE Module=?");
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

				purchase = new String[temp.size()][11];
				int i = 0;
				for (String[] array_in_temp : temp) {
					purchase[i++] = array_in_temp;
				}
			}
		}

		return purchase;
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
				if (result.getString("REQ_Sheet_ID") != null) {
					if (result.getString("Signature").equalsIgnoreCase("True")) 
					
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
		 * @date 07/20/2021
		 * @version 1.0
		 **/

		String[][] result_array = null;

		int r = 0;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			
			

			if (!temp[6].isBlank()) {

				ps = conn.prepareStatement(
						"INSERT INTO test.PURCHASE (Project_ID, Module_type, Supplier_ID, Vol, Unit_price, ESD, Date) VALUE (?, ?, ?, ?, ?,?,?)");
				
				for(int i=0;i<7;i++) 
					ps.setString(i+1, temp[i]);
				
				
			} else {
				// temp[6].isBlank()
				ps = conn.prepareStatement(
						"INSERT INTO test.PURCHASE (Project_ID, Inquiring_product, Supplier_ID, Vol, Unit_price, ESD) VALUE (?, ?, ?, ?, ?,?)");
				
				for(int i=0;i<6;i++) 
					ps.setString(i+1, temp[i]);

			}

			r = ps.executeUpdate();

			if (r == 1) {

				result_array = new String[1][10];
				PreparedStatement ps2 = conn
						.prepareStatement("SELECT * FROM test.PURCHASE ORDER BY PUR_Sheet_ID DESC LIMIT 1");

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
		 * @version 1.0 Description:
		 **/

		int r = 0;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			ps = conn.prepareStatement(
					"UPDATE test.PURCHASE SET Vol=?, Unit_price=?, ESD=?, Date=? WHERE (PUR_Sheet_ID=? AND Project_ID=? AND Module_type=?)");
			
			for(int i=0;i<7;i++) 
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
	int remove(int id, String[] temp) {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/20/2021
		 * @version 1.0 Description:
		 **/

		int r = 0;

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			
			ps = conn.prepareStatement(
					"DELETE FROM test.PURCHASE WHERE (PUR_Sheet_ID=? AND Project_ID=? AND Module_type=? AND Supplier_ID=?)");

			for (int i = 0; i < 4; i++)
				ps.setString(i + 1, temp[i]);
			
			//System.out.print(ps);
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
}
