package org.doctorsolutions.io; 

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.*; 

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.doctorsolutions.model.patients.PatientInfo;


public class DatabaseManager {
	
	public static void connect() 
	throws SQLException, ClassNotFoundException
	{
		// Load the JDBC driver
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("Driver loaded");
	    // Establish a connection
	    Connection connection = DriverManager.getConnection
	    		("jdbc:mysql://192.186.253.201/collegeAssignments", "r00086862", "Test123");
	    System.out.println("Database connected");

	    Statement statement = connection.createStatement();
	    
	    ResultSet resultSet = statement.executeQuery
	    	      ("select * from Patients"); 
	    PatientInfo.dbSetDetails(resultSet);  
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
	

 
    public static TableModel resultSetToTableModel(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            Vector columnNames = new Vector();

            // Get the column names
            for (int column = 0; column < numberOfColumns; column++) {
                columnNames.addElement(metaData.getColumnLabel(column + 1));
            }

            // Get all rows.
            Vector rows = new Vector();

            while (rs.next()) {
                Vector newRow = new Vector();

                for (int i = 1; i <= numberOfColumns; i++) {
                    newRow.addElement(rs.getObject(i));
                }

                rows.addElement(newRow);
            }

            return new DefaultTableModel(rows, columnNames);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}