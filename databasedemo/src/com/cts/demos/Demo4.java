package com.cts.demos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo4 {

	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
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
		//connection.setAutoCommit(false);
		System.out.println("Got connected!!!!!!!");
	    //STEP4
		System.out.println("Enter the code which you want to delete");
		String code=scanner.next();
		// SELECT empcode,firstname,lastname FROM employee_master
		// WHERE empcode='E00002'
	    String SQL="DELETE FROM employee_master WHERE empcode=?";
	    
        System.out.println(SQL);
        PreparedStatement statement=connection.prepareStatement(SQL);
        statement.setString(1,code);
        int deleted=statement.executeUpdate();
        // returns true till it is having the record to read
        if(deleted>0)
        {
        	System.out.println("Record got deleted with a success");
        }
        else
        {
        	System.out.println("Record not deleted!!!!");
        }
        
        statement.close();
      
        connection.close();
	}

}
