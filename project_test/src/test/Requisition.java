package test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author maxence2997
 * @date 07/18/2021
 * @version 1.0
 **/
class Requisition extends Sheets {

	private String item;
	private int unit_price;
	private int total_price;
	private boolean signature;
	private int supervisor_ID;
	private Date ESD;

	Requisition(int sheet_ID, String type, int project_ID, String module, Date date, int vol, String item,
			int unit_price, int total_price, boolean signature, int supervisor_ID, Date ESD) {
		// TODO Auto-generated constructor stub
				/**
				 * @author maxence2997
				 * @date 07/18/2021
				 * @version 1.0
				 * 
				 **/
		
		super(sheet_ID, type, project_ID, module, date, vol);
		
		this.item =item;
		this.unit_price=unit_price;
		this.total_price=total_price;
		this.signature=signature;
		this.supervisor_ID=supervisor_ID;
		this.ESD=ESD;
		

	}

	Requisition() {
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

		String[][] requisition = null;

		switch (Term_project_main.lib.which_is_blank(temp)) {

		case "None of them":

			try {
				conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
						Term_project_main.PASS);

				ps = conn.prepareStatement(
						"SELECT * FROM test.view_requisition WHERE (Sheet_ID=? AND Project_ID =? AND Module=?)");
				ps.setString(1, temp[0]);
				ps.setString(2, temp[1]);
				ps.setString(3, temp[2]);
				result = ps.executeQuery();

				if (result.next()) {
					requisition = new String[1][12];

					for (int i = 1; i < 13; i++)
						requisition[0][i - 1] = result.getString(i);
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
				} finally {
					System.out.println("closed");
				}
			}

			break;

		case "the first one":

			requisition = inquire("sheet_ID", temp[1], temp[2]);

			break;

		case "the second one":

			requisition = inquire("project_ID", temp[0], temp[2]);

			break;

		case "the third one":

			requisition = inquire("module", temp[0], temp[1]);

			break;

		case "the first and the second one":

			requisition = inquire("module", temp[2]);

			break;

		case "the first and the third one":

			requisition = inquire("project_ID", temp[1]);

			break;

		case "the second and the third one":

			requisition = inquire("sheet_ID", temp[0]);

			break;

		default:

			break;

		}

		return requisition;
	}

	private String[][] inquire(String non_filled, String first, String second) {
		// TODO Auto-generated method stub
		String[][] requisition = null;
		ArrayList<String[]> temp = new ArrayList();

		try {

			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (non_filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_requisition WHERE (Project_ID =? AND Module=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			} else if (non_filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_requisition WHERE (Sheet_ID =? AND Module=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}

			} else if (non_filled.equalsIgnoreCase("Module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_requisition WHERE (Sheet_ID =? AND Project_ID=?)");
				ps.setString(1, first);
				ps.setString(2, second);
				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
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

			} finally {
				System.out.println("closed");
			}

			if (temp.size() > 0) {

				requisition = new String[temp.size()][12];
				int i = 0;
				for (String[] array_in_temp : temp) {
					requisition[i++] = array_in_temp;
				}
			}
		}
		return requisition;
	}

	private String[][] inquire(String filled, String first) {
		// TODO Auto-generated method stub

		String[][] requisition = null;
		ArrayList<String[]> temp = new ArrayList();

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);

			if (filled.equalsIgnoreCase("sheet_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_requisition WHERE Sheet_ID =? ");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("project_ID")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_requisition WHERE Project_ID =?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
						temp_array[i - 1] = result.getString(i);

					temp.add(temp_array);
				}
			} else if (filled.equalsIgnoreCase("module")) {

				ps = conn.prepareStatement("SELECT * FROM test.view_requisition WHERE Module=?");
				ps.setString(1, first);

				result = ps.executeQuery();

				while (result.next()) {
					String[] temp_array = new String[12];

					for (int i = 1; i < 13; i++)
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

			} finally {
				System.out.println("closed");
			}

			if (temp.size() > 0) {

				requisition = new String[temp.size()][12];
				int i = 0;
				for (String[] array_in_temp : temp) {
					requisition[i++] = array_in_temp;
				}
			}
		}

		return requisition;
	}

	@Override
	String[][] append() {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0 Description:
		 **/

		return null;
	}
	
	boolean sign() {
		return false;
	}
	
	@Override
	int modify() {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0 Description:
		 **/

		return 0;
	}

	@Override
	int remove() {
		// TODO Auto-generated method stub
		/**
		 * @author maxence2997
		 * @date 07/18/2021
		 * @version 1.0 Description:
		 **/

		return 0;
	}
	/**
	 * @author maxence2997
	 * @date 07/18/2021
	 * @version 1.0 Description:
	 **/
}
