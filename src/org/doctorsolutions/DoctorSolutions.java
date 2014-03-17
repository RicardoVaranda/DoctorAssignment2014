package org.doctorsolutions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import org.doctorsolutions.gui.DoctorLogin;
import org.doctorsolutions.gui.DoctorMenu;
import org.doctorsolutions.io.DatabaseManager;
import org.doctorsolutions.model.patients.*;

public class DoctorSolutions {
	
	public static int docID = 1;
	public static int loginID = 0;
	
	DoctorSolutions()
	{
		
	}
	
	public static void main(String [] args) throws ParseException
	{
		try {
			DatabaseManager.newConnection(false, true, true);
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		} 
		DatabaseManager.disconnect();
		new DoctorMenu();
		
	}
	
	public static void setPatients(ResultSet rs) throws SQLException{
		while (rs.next())
		{
			Patients.addPatient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));  
		}
	}
	
	public static void setMedHistory(ResultSet rs) throws SQLException, ParseException{
		while (rs.next())
		{
			Patients.addMedHistory(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getBoolean(6));  
		}
	}
	
	
	
	public static void dbSetDetails(ResultSet rs) throws SQLException{
		while (rs.next())
		{
//			getPatientID()[numPatients] = rs.getString(1);
//			getPatientName()[numPatients] = rs.getString(2);
//			getPatientAddress()[numPatients] = rs.getString(3);
//			getPatientEmail()[numPatients] = rs.getString(4);
//			getPatientContactNo()[numPatients] = rs.getString(5);
//			getPatientGender()[numPatients] = rs.getString(6);
//			getPatientDOB()[numPatients] = rs.getString(7);
//			numPatients++;
		}
	} 

}
