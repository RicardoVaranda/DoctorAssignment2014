package org.doctorsolutions.io; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import org.doctorsolutions.DoctorSolutions;
import org.doctorsolutions.gui.DoctorMenu;
import org.doctorsolutions.model.patients.PatientInfo;
import org.doctorsolutions.model.patients.Patients;


public class DatabaseManager {
	
	public static void newConnection(boolean getDoc, boolean getPat, boolean getMed) 
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
	    
	    if(getPat){
	    	ResultSet resultSet = statement.executeQuery("SELECT * FROM Patients WHERE DoctorID=" + DoctorSolutions.docID); 
		    DoctorSolutions.setPatients(resultSet);  
	    }
	    
	    if(getMed){
	    	ResultSet resultSet = statement.executeQuery("SELECT * FROM MedicalHistory"); 
		    DoctorSolutions.setMedHistory(resultSet);  
	    }
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