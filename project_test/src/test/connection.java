package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	// mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	//remote
	static final String DB_URL2 = "jdbc:mysql://192.168.0.16:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER2 = "myself";
	static final String PASS2 = "20210608";
	
	//local
	static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "root";
	static final String PASS = "qazwsxedc12345678";
	
	public static Statement st;

	
	public connection(int test ) {

		// run mysql
		connection_mysql(test);
		

		
	}
	
	
	
	public connection() {

		// run mysql
		connection_mysql();
		

		
	}
	public static void connection_mysql() {
		
		/**
		 * This method is used to connect mySQL localhost
		 * @author jyunanyang
		 * 
		 */
		try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.println("Driver loaded!");
			  } catch (ClassNotFoundException e) {
			   System.out.println("Can't find driver");
			   e.printStackTrace();
			  }
		
		
		try {
			  Connection conn =  DriverManager.getConnection(DB_URL, USER, PASS);
			  System.out.println("mysql Connection Success");
			  
			  st= conn.createStatement();
			  
			  st.executeUpdate("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
			  st.executeUpdate("SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
			   
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}
	
	
public static void connection_mysql(int i) {
		
		/**
		 * This method is used to connect mySQL localhost
		 * @author jyunanyang
		 * 
		 */
		try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   System.out.println("Driver loaded!");
			  } catch (ClassNotFoundException e) {
			   System.out.println("Can't find driver");
			   e.printStackTrace();
			  }
		
		
		try {
			  Connection conn =  DriverManager.getConnection(DB_URL2, USER2, PASS2);
			  System.out.println("mysql Connection Success");
			  
			  st= conn.createStatement();
			  
			  st.executeUpdate("SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
			  st.executeUpdate("SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''))");
			   
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}
	
}
