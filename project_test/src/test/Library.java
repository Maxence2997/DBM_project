package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

public class Library {
	
	
	public final String st_progress = "SELECT \n"
			+ "    pj.Project_ID,\n"
			+ "    pj.Project_status,\n"
			+ "    pj.Emp_ID,\n"
			+ "    emp.Last_name AS Responsable,\n"
			+ "    PUR.Module_type,\n"
			+ "    CONCAT(FORMAT(((Pur.Vol*100)/ RCPT.Vol),0),'%') AS Product_Delivery,\n"
			+ "    PUR.ESD,\n"
			+ "    RCPT.Date,\n"
			+ "    (CASE\n"
			+ "        WHEN\n"
			+ "            (CASE\n"
			+ "                WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
			+ "                ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
			+ "            END) >= 29\n"
			+ "        THEN\n"
			+ "            'Violated'\n"
			+ "        WHEN\n"
			+ "            ((CASE\n"
			+ "                WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
			+ "                ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
			+ "            END) < 29\n"
			+ "                && (CASE\n"
			+ "                WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
			+ "                ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
			+ "            END) >= 15)\n"
			+ "        THEN\n"
			+ "            'Delayed'\n"
			+ "        ELSE 'In Time'\n"
			+ "    END) AS Contract,\n"
			+ "    (CASE\n"
			+ "        WHEN (Pur.Vol*100)/ RCPT.Vol < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
			+ "        ELSE DATEDIFF(RCPT.Date, PUR.ESD)\n"
			+ "    END) AS Date_difference\n"
			+ "FROM\n"
			+ "    PROJECT AS pj\n"
			+ "        LEFT JOIN\n"
			+ "    EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID\n"
			+ "        LEFT JOIN\n"
			+ "    PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)\n"
			+ "        LEFT JOIN\n"
			+ "    RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID\n"
			+ "        AND RCPT.Module_type = PUR.MOdule_type)";
	
	
	
	public final String st_project_inquire = "SELECT pj.Project_ID, pj.Emp_ID, emp.Last_name AS E_name, pj.Project_status AS P_status,\n"
			+ "pj.Established_date AS Est_date, rfq.Inquiring_product AS Product, rfq.RFQ_Sheet_ID, quo.QUO_Sheet_ID,\n"
			+ " req.REQ_Sheet_ID, pur.PUR_Sheet_ID, exam.EX_Sheet_ID, rcpt.REC_Sheet_ID FROM PROJECT AS pj \n"
			+ "LEFT JOIN RFQ AS rfq ON rfq.Project_ID = pj.Project_ID LEFT JOIN QUOTATION AS quo \n"
			+ "ON (quo.Project_ID = rfq.Project_ID AND quo.Inquiring_product = rfq.Inquiring_product)\n"
			+ "LEFT JOIN REQUISITION AS req ON (req.Project_ID = quo.Project_ID AND req.Inquiring_product = quo.Inquiring_product)\n"
			+ "LEFT JOIN PURCHASE AS pur ON (pur.Project_ID = req.Project_ID AND req.Inquiring_product = pur.Module_type)\n"
			+ "LEFT JOIN EXAMINATION AS exam ON (exam.Project_ID = pur.Project_ID AND exam.Module_type = pur.Module_type)\n"
			+ "LEFT JOIN RECEIPT AS rcpt ON (rcpt.Project_ID = exam.Project_ID AND rcpt.Module_type = exam.Module_type)\n"
			+ "LEFT JOIN EMPLOYEE AS emp ON pj.Emp_ID = emp.Emp_ID";
	
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
				String[] temp_array = new String[2];
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int l=0; l<temp.size();l++) {
			
			
			try {
			    int resultSet = Term_project_main.conn.st.executeUpdate("UPDATE PROJECT SET Project_status=\'"+temp.get(l)[1]
										+"\' WHERE Project_ID="+temp.get(l)[0]);

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
			   res=true;
			  
			}catch (NumberFormatException ex) {
			    //handle exception here
				return res;
			}
		 return res;
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
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-mm-dd");
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
