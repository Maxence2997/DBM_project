package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Try {
		
	public static String join_pj_with_six_table = "SELECT pj.Project_ID,QUO.Sheet_type,QUOT.Sheet_type, PUR.Sheet_type, \n"
			+ "PUR.Sheet_type, EXAM.Sheet_type, RCPT.Sheet_type\n"
			+ "FROM PROJECT AS pj LEFT JOIN QUO ON pj.Project_ID = QUO.Project_ID \n"
			+ "LEFT JOIN RECEIPT AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
			+ "LEFT JOIN RECEIPT AS PUR ON PUR.Project_ID = pj.Project_ID\n"
			+ "LEFT JOIN RECEIPT AS PUR ON PUR.Project_ID = pj.Project_ID\n"
			+ "LEFT JOIN RECEIPT AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
			+ "LEFT JOIN RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID GROUP BY pj.Project_ID";
	public static connection conn2;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		ArrayList<String[]> temp= new ArrayList();
		
		
		conn2= new connection();
//		
		try {
			ResultSet r = conn2.st.executeQuery("SELECT * FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
					+ "LEFT JOIN QUOTATION AS QUOT ON (RFQ.Project_ID  = QUOT.Project_ID \n"
					+ "AND RFQ.Inquiring_product = QUOT.Inquiring_product)\n"
					+ "LEFT JOIN REQUISITION AS REQ ON (REQ.Project_ID = QUOT.Project_ID \n"
					+ "AND REQ.Inquiring_product = QUOT.Inquiring_product)\n"
					+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = REQ.Project_ID \n"
					+ "AND PUR.Module_type = REQ.Inquiring_product)\n"
					+ "LEFT JOIN EXAMINATION AS EXAM ON (EXAM.Project_ID = PUR.Project_ID \n"
					+ "AND EXAM.Module_type = PUR.Module_type)\n"
					+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = EXAM.Project_ID \n"
					+ "AND RCPT.Module_type = EXAM.MOdule_type) WHERE pj.Project_ID =90000004");
	
			while(r.next()) {
				
				if(r.getString(6)!= null) {
					
					String [] rfq = new String[7];
					for(int i =6; i<13;i++) {
						
						rfq[0]=r.getString(1);
						
						if(i==8) 
							continue;
						
						else if(i>8)
							rfq[i-6]=r.getString(i);
						
						else
							rfq[i-5]=r.getString(i);		
					}
					temp.add(rfq);
					
					if(r.getString(13)!= null) {
						
						String [] quo = new String[10];
						for(int i =13; i<23;i++) {
							
							quo[0]=r.getString(1);
							
							if(i==15) 
								continue;
							
							else if(i>15)
								quo[i-13]=r.getString(i);
							
							else
								quo[i-12]=r.getString(i);		
						}
						temp.add(quo);
						
						if(r.getString(23)!= null) {
							String [] req = new String[11];
							for(int i =23; i<34;i++) {
								
								req[0]=r.getString(1);
								
								if(i==25) 
									continue;
								
								else if(i>25)
									req[i-23]=r.getString(i);
								
								else
									req[i-22]=r.getString(i);		
							}
							temp.add(req);
							
							if (r.getString(34)!= null) {
								
								String [] pur = new String[9];
								for(int i =34; i<43;i++) {
									
									pur[0]=r.getString(1);
									
									if(i==37) 
										continue;
									
									else if(i>37)
										pur[i-34]=r.getString(i);
									
									else
										pur[i-33]=r.getString(i);		
								}
								temp.add(pur);
								
								if(r.getString(43)!= null) {
									
									String [] exam = new String[7];
									for(int i =43; i<50;i++) {
										
										exam[0]=r.getString(1);
										
										if(i==45) 
											continue;
										
										else if(i>45)
											exam[i-43]=r.getString(i);
										
										else
											exam[i-42]=r.getString(i);		
									}
									temp.add(exam);
									
									if(r.getString(50)!= null) {
										
										String [] rcpt = new String[6];
										for(int i =50; i<56;i++) {
											
											rcpt[0]=r.getString(1);
											
											if(i==52) 
												continue;
											
											else if(i>52)
												rcpt[i-50]=r.getString(i);
											
											else
												rcpt[i-49]=r.getString(i);		
										}
										temp.add(rcpt);	
									}
								}
							}
						}
					}
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		for(int i=0; i<temp.size();i++) {
			for(int j=0; j<temp.get(i).length;j++) {
			System.out.print(temp.get(i)[j]+"\t");
			}
			System.out.println();
		}
		
		
//			while(r.next()) {
//				String[] temp_array = new String[3];
//				for(int i =2; i<8;i++) {
//					temp_array[0] = r.getString(1);
//					
//					if(r.getString(i)==null) {
//						if(i==2) {
//							temp_array[1]="just started";
//							break;
//						}else {
//							break;
//						}
//					}else {
//						temp_array[1]=r.getString(i);
//					}	
//				}
//				temp.add(temp_array);	
//			}
//			for(int i=0;i<temp.size();i++) {
//				if (temp.get(i)[1].equalsIgnoreCase("RCPT")) {
//					try {
//						ResultSet r2 = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID, Pur.Module_type, Pur.Vol,"+
//								 "RCPT.Vol FROM PROJECT AS pj RIGHT JOIN RECEIPT AS Pur "+
//								 "ON pj.Project_ID = Pur.Project_ID  RIGHT JOIN RECEIPT AS RCPT "+
//								 "ON (pj.project_ID= RCPT.Project_ID AND RCPT.Module_type = PUR.Module_type) WHERE pj.Project_ID="+temp.get(i)[0]);
//						
//						ArrayList<Float> numerator = new ArrayList();
//						ArrayList<Float> denominator = new ArrayList();
//						
//						while(r2.next()) {
//							for(int j =3; j<5;j++) {
//								numerator.add(r2.getFloat(3));
//								denominator.add(r2.getFloat(4));
//							}
//						}
//						
//						float total_num=0;
//						
//						for(int p=0; p < numerator.size();p++) {
//							total_num += numerator.get(p);
//							
//						}
////						System.out.println("----bgn---");
////						System.out.print(total_num);
////						System.out.println();
//						int total_den=0;
//						for(int q=0; q < denominator.size();q++) {
//							total_den += denominator.get(q);
//							
//						}
////						System.out.print(total_den);
////						System.out.println();
//						
//						temp.get(i)[2]=String.format("%.0f%%",total_num*100 / (total_den));
//						
//					} catch (SQLException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		
//				}
////				System.out.print(temp.get(i)[0]+"\t"+temp.get(i)[1]+"\t"+temp.get(i)[2]+"\n");
////				System.out.println("---end----");
////				System.out.println();
////				System.out.println();
//			}	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		for(int l=0; l<temp.size();l++) {
//			
//			
//			try {
//			    int resultSet = Term_project_main.conn.st.executeUpdate("UPDATE PROJECT SET Project_status=\'"+temp.get(l)[1]
//										+"\', Delivery_progress=\'"+temp.get(l)[2]+"\' WHERE Project_ID="+temp.get(l)[0]);
//
//				;	
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//					
//			}
//		}
//		
//		
//		
//			try {
//				ResultSet r = conn2.st.executeQuery("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
//				
//				
//				while(r.next()) {
//					System.out.print(r);
//				}
//				
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
	
//		String st = "PD";
//		ResultSet res;
//		
//		switch(st) {
//		
//			case "INV":
//				
//				try {
//					res = conn2.st.executeQuery("SELECT * FROM INVENTORY");
//					
//					
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					res=null;
//				}
//				break;
//				
//			case "PD":
//				
//			try {
//				res = conn2.st.executeQuery("SELECT * FROM PRODUCT");
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				res=null;
//			}
//			break;		
//					
//				
//				
//			default:
//			try {
//				res = conn2.st.executeQuery("SELECT * FROM PROJECT");
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//				res=null;
//			}
//			break;
//		
//		}
//		
//		try {
//			while(res.next()) {
//				for(int i=1; i <2 ; i++)
//					System.out.print(res.getString(i));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		
	}

}
