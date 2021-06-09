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
		
		System.out.print(x&y);
		
	}

}
