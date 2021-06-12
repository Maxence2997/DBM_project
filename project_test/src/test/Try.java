package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Try {
	
	private static Library lib;
	
	
	public static connection conn2;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		ArrayList<String[]> temp= new ArrayList();
		
		lib = new Library();
		conn2= new connection();
		
		String supID = "SP0000003";
		String pd = "G0a369";
		String pj = "90000006";
		String vol="60";
		
		
		
		
		int a = 0;
		int b=0;
		int c=0;
		int d=0;
		int e2=0;
		int f=0
		
		try {
			a =	conn2.st.executeUpdate("UPDATE RFQ SET Supplier_ID = \'"+supID+"\', Inquiring_product = \'"+pd+"\' WHERE (Project_ID ="+ pj+" AND Vol="+vol+")");
			b = conn2.st.executeUpdate("UPDATE QUOTATION SET Supplier_ID = \'"+supID+"\', Inquiring_product = \'"+pd+"\' WHERE (Project_ID ="+ pj+" AND Vol="+vol+")");
			c = conn2.st.executeUpdate("UPDATE REQUISITION SET Inquiring_product = \'"+pd+"' WHERE (Project_ID ="+ pj+" AND Vol=+"+vol+")");
			d = conn2.st.executeUpdate("UPDATE PURCHASE SET Module_type = \'"+pd+"\' WHERE (Project_ID ="+pj+" AND Vol=284)");
			e2 = conn2.st.executeUpdate("UPDATE EXAMINATION SET Module_type = \'"+pd+"\' WHERE (Project_ID = "+pj+" AND Vol="+vol+")");
			f = conn2.st.executeUpdate("UPDATE RECEIPT SET Module_type = \'"+pd+"\' WHERE (Project_ID ="+pj+" AND Vol=60)");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print(a+b+c+d+e2+f);
	}

}
