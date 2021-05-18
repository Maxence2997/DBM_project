package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	// mysql
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	//userid&password
	static final String USER = "root";
	static final String PASS = "yang19970429";
	public static Statement st;

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
			   
			  } catch (SQLException e) {
			   e.printStackTrace();
			  }
	}

	
}
