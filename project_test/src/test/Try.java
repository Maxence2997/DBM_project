package test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Try {
	
	private static Library lib;
	
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
		
		lib = new Library();
		conn2= new connection();
		
//		
		boolean x = true;
		boolean y = true;
		
//		System.out.print("SELECT pj.Project_ID, pj.Project_status, pj.Emp_ID, emp.Last_name AS Respensable, PUR.Module_type, pj.Delivery_progress,"
//				+ " PUR.ESD, RCPT.Date, \n"
//				+ " (CASE WHEN  (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) \n"
//				+ "   ELSE DATEDIFF(RCPT.Date,PUR.ESD)END) >=29 THEN 'Violated' \n"
//				+ "   WHEN ((CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) \n"
//				+ "   ELSE DATEDIFF(RCPT.Date,PUR.ESD)END)  < 29 && (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) \n"
//				+ "   ELSE DATEDIFF(RCPT.Date,PUR.ESD)END) >=15) THEN 'Delayed'\n"
//				+ "   ELSE 'In Time' END) AS Contrat\n"
//				+ "FROM PROJECT AS pj LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID\n"
//				+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)\n"
//				+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID \n"
//				+ "AND RCPT.Module_type = PUR.MOdule_type)");
		
		
		System.out.print("SELECT pj.Project_ID, pj.Project_status, pj.Emp_ID, emp.Last_name AS Responsable, PUR.Module_type,\n"
												+ "pj.Delivery_progress, PUR.ESD, RCPT.Date, (CASE WHEN (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) >= 29 THEN 'Violated'\n"
												+ "WHEN((CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) < 29 && (CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD)\n"
												+ "ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) >= 15) THEN 'Delayed' ELSE 'In Time' END) AS Contract,\n"
												+ "(CASE WHEN pj.Delivery_progress < 100 THEN DATEDIFF(CURDATE(), PUR.ESD) ELSE DATEDIFF(RCPT.Date, PUR.ESD) END) AS Date_difference\n"
												+ "FROM PROJECT AS pj LEFT JOIN EMPLOYEE AS emp ON emp.Emp_ID = pj.Emp_ID\n"
												+ "LEFT JOIN PURCHASE AS PUR ON (PUR.Project_ID = pj.Project_ID)\n"
												+ "LEFT JOIN RECEIPT AS RCPT ON (RCPT.Project_ID = PUR.Project_ID AND RCPT.Module_type = PUR.MOdule_type)\n"
												+ "ORDER BY Date_difference DESC");
	}

}
