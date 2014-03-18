package org.doctorsolutions.io; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
 
import org.doctorsolutions.Surgery; 


public class DatabaseManager {
	
	public static void getConnection(boolean getDoc, boolean getAllPat, boolean getDocPat, boolean getMed) 
	throws SQLException, ClassNotFoundException, ParseException
	{
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Driver loaded");
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	    		("jdbc:mysql://192.186.253.201/collegeAssignments", "r00086862", "Test123");
	    System.out.println("Database connected");

	    Statement statement = connection.createStatement();
	    
	    if(getDoc)
	    {
	    	ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff WHERE StaffPosition='Doctor'"); 
	    	Surgery.setDoctors(resultSet); 
	    }
	    
	    if(getAllPat)
	    {
	    	ResultSet resultSet = statement.executeQuery("SELECT * FROM Patients"); 
	    	while(resultSet.next())
	    		Surgery.nextPatID ++;  
	    }
	    
	    if(getDocPat)
	    {
	    	ResultSet resultSet = statement.executeQuery("SELECT * FROM Patients WHERE DoctorID=" + Surgery.docID); 
		    Surgery.setPatients(resultSet);  
	    }
	    
	    if(getMed)
	    {
	    	ResultSet resultSet = statement.executeQuery("SELECT * FROM MedicalHistory"); 
	    	Surgery.setMedHistory(resultSet);  
	    	while(resultSet.next())
	    		Surgery.nextPatID ++;  
	    }
	}
	
	public static void newConnection(String query) 
	throws SQLException, ClassNotFoundException, ParseException
	{
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Driver loaded");
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	    		("jdbc:mysql://192.186.253.201/collegeAssignments", "r00086862", "Test123");
	    System.out.println("Database connected");

	    Statement statement = connection.createStatement();
	    
	    statement.executeUpdate(query);  
	    
	    disconnect();
	}
	
	public static void disconnect() {
		try {
			DriverManager.getConnection
    		("jdbc:mysql://192.186.253.201/collegeAssignments", "r00086862", "Test123").close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}