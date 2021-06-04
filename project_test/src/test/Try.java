package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Try {
		
	public static String join_pj_with_six_table = "SELECT pj.Project_ID,RFQ.Sheet_type,QUOT.Sheet_type, REQ.Sheet_type, \n"
			+ "PUR.Sheet_type, EXAM.Sheet_type, RCPT.Sheet_type\n"
			+ "FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
			+ "LEFT JOIN QUOTATION AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
			+ "LEFT JOIN REQUISITION AS REQ ON REQ.Project_ID = pj.Project_ID\n"
			+ "LEFT JOIN PURCHASE AS PUR ON PUR.Project_ID = pj.Project_ID\n"
			+ "LEFT JOIN EXAMINATION AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
			+ "LEFT JOIN RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID GROUP BY pj.Project_ID";
	public static connection conn2;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		ArrayList<String[]> temp= new ArrayList();
		
		
		conn2= new connection();
		
		try {
			ResultSet r = conn2.st.executeQuery(join_pj_with_six_table);
			
			while(r.next()) {
				String[] temp_array = new String[3];
				for(int i =2; i<8;i++) {
					temp_array[0] = r.getString(1);
					
					if(r.getString(i)==null) {
						if(i==2) {
							temp_array[1]="just started";
							break;
						}else {
							break;
						}
					}else {
						temp_array[1]=r.getString(i);
					}	
				}
				temp.add(temp_array);	
			}
			for(int i=0;i<temp.size();i++) {
				if (temp.get(i)[1].equalsIgnoreCase("RCPT")) {
					try {
						ResultSet r2 = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, Pur.Module_type, Pur.Vol,"+
								 "RCPT.Vol FROM PROJECT AS pj RIGHT JOIN PURCHASE AS Pur "+
								 "ON pj.Project_ID = Pur.Project_ID  RIGHT JOIN RECEIPT AS RCPT "+
								 "ON (pj.project_ID= RCPT.Project_ID AND RCPT.Module_type = PUR.Module_type) WHERE pj.Project_ID="+temp.get(i)[0]);
						
						ArrayList<Float> numerator = new ArrayList();
						ArrayList<Float> denominator = new ArrayList();
						
						while(r2.next()) {
							for(int j =3; j<5;j++) {
								numerator.add(r2.getFloat(3));
								denominator.add(r2.getFloat(4));
							}
						}
						
						float total_num=0;
						
						for(int p=0; p < numerator.size();p++) {
							total_num += numerator.get(p);
							
						}
//						System.out.println("----bgn---");
//						System.out.print(total_num);
//						System.out.println();
						int total_den=0;
						for(int q=0; q < denominator.size();q++) {
							total_den += denominator.get(q);
							
						}
//						System.out.print(total_den);
//						System.out.println();
						
						temp.get(i)[2]=String.format("%.0f%%",total_num*100 / (total_den));
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
				}
//				System.out.print(temp.get(i)[0]+"\t"+temp.get(i)[1]+"\t"+temp.get(i)[2]+"\n");
//				System.out.println("---end----");
//				System.out.println();
//				System.out.println();
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int l=0; l<temp.size();l++) {
			
			
			try {
			    int resultSet = Term_project_main.conn.st.executeUpdate("UPDATE PROJECT SET Project_status=\'"+temp.get(l)[1]
										+"\', Delivery_progress=\'"+temp.get(l)[2]+"\' WHERE Project_ID="+temp.get(l)[0]);

				;	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
					
			}
		}
		

	}

}
