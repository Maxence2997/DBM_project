package test;

import java.util.Date;

import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class RFQ extends Sheets {

	private int vol;
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet result = null;

	RFQ() {

	}

	RFQ(int sheet_ID, String type, int project_ID, String supplier_ID, String module, Date date, int vol) {
		super(sheet_ID, type, project_ID, supplier_ID, module, date);
		this.vol = vol;

		// TODO Auto-generated constructor stub
	}

	@Override
	String[][] inquire(String[] temp) {
		// TODO Auto-generated method stub

		try {
			conn = DriverManager.getConnection(Term_project_main.DB_URL, Term_project_main.USER,
					Term_project_main.PASS);
			ps = conn.prepareStatement(
					"SELECT test.veiw_rfq FROM test.RFQ AS rfq LEFT JOIN test.SUPPLIER AS sup ON sup.Supplier_ID=RFQ.Supplier_ID WHERE (RFQ_Sheet_ID=? AND rfq.Project_ID =? AND rfq.Inquiring_product=?)");
			ps.setString(1, temp[0]);
			ps.setString(2, temp[1]);
			ps.setString(3, temp[2]);
			result = ps.executeQuery();

			if (result.next()) {
				String[][] rfq = new String[1][8];

				for (int i = 1; i < 9; i++)
					rfq[0][i - 1] = result.getString(i);

				return rfq;
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
		}

		return null;
	}

	@Override
	String[][] inquire(String non_filled, String first, String second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String[][] inquire(String filled, String first) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	String[][] append() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	int modify() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int sign() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int remove() {
		// TODO Auto-generated method stub
		return 0;
	}

}
