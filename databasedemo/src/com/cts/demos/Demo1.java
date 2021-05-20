package com.cts.demos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) throws SQLException {
		// Step1
		// Driver in LHS is an interface
		// from the package java.sql
		// Driver in RHS is a Driver class of MYSQL
		// and we got the driver after downloading and
		// added it in the classpath
		Driver driver=new com.mysql.cj.jdbc.Driver();
        // STEP2 
		DriverManager.registerDriver(driver);
		// STEP3
		// protocol : jdbc
		// subprotocol : mysql
		// the server : localhost
		// port number : 3306
		// Database name : DB29April
		String URL="jdbc:mysql://localhost:3306/DB29April";
		String username="root";
		String password="password@123";
		Connection connection=DriverManager.getConnection(URL,username,password);
		System.out.println("Got connected!!!!!!!");
	    //STEP4
	    String SQL="SELECT empcode,firstname,lastname FROM employee_master"; 
        Statement statement=connection.createStatement();
        ResultSet result=statement.executeQuery(SQL);
        // returns true till it is having the record to read
        while(result.next())
        {
        	System.out.println(result.getString("empcode")+"\t"+result.getString("firstname")+"\t"+result.getString("lastname"));
        }
        
        statement.close();
        result.close();
        connection.close();
	}

}
