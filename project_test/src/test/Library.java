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
	
	
	public void adjust_PROJECT() {
		
		/**@author jyunanyang
		 * @since 06/04/2021
		 * 
		 * to update whole PROJECT table
		 */
		
		ArrayList<String[]> temp= new ArrayList();
		
		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT pj.Project_ID,RFQ.Sheet_type,QUOT.Sheet_type, REQ.Sheet_type, \n"
																+ "PUR.Sheet_type, EXAM.Sheet_type, RCPT.Sheet_type\n"
																+ "FROM PROJECT AS pj LEFT JOIN RFQ ON pj.Project_ID = RFQ.Project_ID \n"
																+ "LEFT JOIN QUOTATION AS QUOT ON QUOT.Project_ID = pj.Project_ID \n"
																+ "LEFT JOIN REQUISITION AS REQ ON REQ.Project_ID = pj.Project_ID\n"
																+ "LEFT JOIN PURCHASE AS PUR ON PUR.Project_ID = pj.Project_ID\n"
																+ "LEFT JOIN EXAMINATION AS EXAM ON EXAM.Project_ID = pj.Project_ID\n"
																+ "LEFT JOIN RECEIPT AS RCPT ON RCPT.Project_ID = pj.Project_ID GROUP BY pj.Project_ID");
			
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
						float total_den=0;
						for(int q=0; q < denominator.size();q++) {
							total_den += denominator.get(q);
							
						}
//						System.out.print(total_den);
//						System.out.println();
						
						//temp.get(i)[2]=String.format("%.0f%%",total_num*100 / (total_den));
						temp.get(i)[2]=String.format("%.1f",total_num*100 / (total_den));
						
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
	
	
	public boolean num_not_null_check(JTextField num) {
		
		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 */
		boolean res = false;
		
		try{
			   Integer.parseInt(num.getText());
			   // test empID.getText() is blank or alphabet
			   
			   return res;
			}catch (NumberFormatException ex) {
			    //handle exception here
				return res;
			}
	}
	
	
	public boolean supplier_check(JTextField supID) {
		
		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 * to test supID.getText() is blank or alphabet
		 * and verify it's in our Supplier table or not
		 */
		
		boolean res = false;
		
		try{
			   Integer.parseInt(supID.getText());
			   // test empID.getText() is blank or alphabet
			   
			}catch (NumberFormatException ex) {
			    //handle exception here
				return res;
			}
		
		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT Supplier_ID FROM SUPPLIER WHERE Supplier_ID="+supID.getText());
			
			if(r.next()) {
				
				res=true;
			}
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return res;
		}
	}
	
	
	
	public boolean projectID_check(JTextField pjID) {
		
		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 * to test projectID.getText() is blank or alphabet
		 * and verify it's in our PORJECT table or not
		 */
		boolean res=false;
		try{
			   Integer.parseInt(pjID.getText());
			   // test empID.getText() is blank or alphabet
			   
			}catch (NumberFormatException ex) {
			    //handle exception here
				return res;
			}
		
		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT Project_ID FROM PROJECT WHERE Project_ID="+pjID.getText());
			
			if(r.next()) {
				
				res=true;
			}
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return res;
		}
	}
	
	
	
	public boolean module_check(JTextField module) {
		
		/**
		 * @author jyunanyang
		 * @since 06/08/2021
		 * 
		 * to test module.getText() is blank or alphabet
		 * and verify it's in our PORJECT table or not
		 */
		
		boolean res=false;

		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT Module_type FROM PRODUCT WHERE Module_type="+module.getText());
			
			if(r.next()) {
				
				res=true;
			}
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return res;
		}
	}
	
	public boolean tf_check(JTextField tf) {
		
		boolean res = false;
		
		if(tf.getText().equalsIgnoreCase("true")) {
			
			res = true;
		}else if(tf.getText().equalsIgnoreCase("false")) {
			
			res = true;
		}
		
		return res;
	}
	
	
 	public boolean emp_check(JTextField empID) {
		
		/**
		 * @author jyunanyang
		 * @since 06/07/2021
		 * 
		 * to test empID.getText() is blank or alphabet
		 * and verify it's in our Employee table or not
		 */
		
		boolean res = false;
		
		try{
			   Integer.parseInt(empID.getText());
			   // test empID.getText() is blank or alphabet
			   
			}catch (NumberFormatException ex) {
			    //handle exception here
				
				return res;
			}
		
		
		try {
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT Emp_ID FROM EMPLOYEE WHERE Emp_ID="+empID.getText());
			
			if(r.next()) {
				
				res=true;
			}
			
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
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
			ResultSet r = Term_project_main.conn.st.executeQuery("SELECT Supervisor_ID FROM EMPLOYEE WHERE Supervisor_ID="+empID.getText());
			
			if(r.next()) {
				
				System.out.println(r.getString(1));
				res=true;
			}
			
			return res;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			return res;
		}
		
	}
	
	
	
	public boolean date(String strDate){
	
	/**
	 * Reference: https://beginnersbook.com/2013/05/java-date-format-validation/
	 */
	   
		/* Check if date is 'null' */
		if (strDate.trim().equals("")){
			
		    return true;
		    
		}else {
		/* Date is not 'null' */
		
		    /*
		     * Set preferred date format,
		     * For example yyyy-mm-dd, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy/mm/dd");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try{
		        Date javaDate = sdfrmt.parse(strDate); 
		       
		    
		    
		    }catch (ParseException e){
		    	/* Date format is invalid */
		        return false;
		    	}
		    /* Return true if date format is valid */
		    return true;
		}
		
	}
	
	
	
	public  String[] insert(String[] input, String string, int index) {
	
		/**
		 * Reference: https://www.techiedelight.com/insert-element-array-specific-index-java/
		 * 
		 * to insert a key in specified index into an array.
		 * 
		 */
    
        String [] result = new String[input.length + 1];
 
        System.arraycopy(input, 0, result, 0, index);
        result[index] = string;
        System.arraycopy(input, index, result, index + 1, input.length - index);
 
        return result;
    }
	
	
	
	public String check_text_fields(JTextField ID, JTextField else1, JTextField else2) {
		/**@author jyunanyang
		 * @since 06/02/2021
		 * to check how many JTextField are filled by user and return a String to 
		 * be represente the status for switch case in inquire function.
		 */
		
		if (!(ID.getText().isBlank())) {
			//1
			if (!(else1.getText().isBlank())) {
				//1-1
				if (!(else2.getText().isBlank())) {
					//1-1-1
					return "111";
				}else {
					//1-1-0
					return "110";
				}
			}else if(!(else2.getText().isBlank())) {
				//1-0-1
				return "101";		
				}else {
					//1-0-0
					return "100";
				}
		}else if (!(else1.getText().isBlank())) {
			//0-1
			if (!(else2.getText().isBlank())) {
				//0-1-1
				return "011";
				}else {
					//0-1-0
					return "010";
				}
		}else {
			//0-0-1
			return "001";
		}

	}
	
	
	
	public String check_text_fields(JTextField ID, JTextField else1) {
		/**@author jyunanyang
		 * @since 06/02/2021
		 * to check how many JTextField are filled by user and return a String to 
		 * be represente the status for switch case in inquire function.
		 */
		
		if (!(ID.getText().isBlank())) {
			//1
			if (!(else1.getText().isBlank())) {
				//1-1
					return "11";
				}else {
					//1-1-0
					return "10";
				}
			}else {
				//1-0-1
				return "01";				
		}
	}
}
