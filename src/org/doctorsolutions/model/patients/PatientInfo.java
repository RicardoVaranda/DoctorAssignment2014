package org.doctorsolutions.model.patients;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientInfo {
	
	public static String[] patientID = new String[500];
	public static String[] patientName = new String[500];
	public static String[] patientAddress = new String[500];
	public static String[] patientEmail = new String[500];
	public static String[] patientContactNo = new String[500];
	public static String[] patientGender = new String[500];
	public static String[] patientDOB = new String[500];
	public static int numPatients = 1;
	
	/*
	 1		PatientID
	 2 		PatientName
	 3		PatientAddress
	 4		PatientEmail
	 5		PatientContactNo
	 6		PatientGender Descending
	 7		PatientDOB
	 */
	
	PatientInfo(){
		
	}
	
	public static void dbSetDetails(ResultSet rs) throws SQLException{
		while (rs.next())
		{
			patientID[numPatients] = rs.getString(1);
			patientName[numPatients] = rs.getString(2);
			patientAddress[numPatients] = rs.getString(3);
			patientEmail[numPatients] = rs.getString(4);
			patientContactNo[numPatients] = rs.getString(5);
			patientGender[numPatients] = rs.getString(6);
			patientDOB[numPatients] = rs.getString(7);
			numPatients++;
		}
	}
 
 

}
