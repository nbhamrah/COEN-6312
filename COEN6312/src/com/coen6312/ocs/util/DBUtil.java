package com.coen6312.ocs.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static  Connection getConnection() throws ClassNotFoundException, SQLException{
		Connection connection;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","admin","admin");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl","SYSTEM","admin");
		return connection;
	}
}
