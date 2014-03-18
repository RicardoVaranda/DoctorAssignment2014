package org.doctorsolutions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
  
import org.doctorsolutions.gui.MainGUI;
import org.doctorsolutions.io.DatabaseManager;
import org.doctorsolutions.model.doctors.Doctor;
import org.doctorsolutions.model.patients.Patient;
import org.doctorsolutions.model.patients.PatientHistory;

public class Surgery {
	
	public static int docID = 0;
	public static int loginID = 0;
	public static int nextPatID = 1;
	public static int nextMedID = 0;
	private static SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd"); 
	public static ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private String surgeryAdd;

	Surgery()
	{
		
	}
	
	/*
	 * 
	 * DUE TO LACK OF TIME WAS UNABLE TO FINALIZE IT
	 * PROGRAM RUNS AS IF YOU ARE THE TECHNICIAN
	 * 
	 */
	
	public static void main(String [] args) throws ParseException
	{
		//CREATES A NEW DATABASE CONNECTION
		try {
			DatabaseManager.getConnection(true, true, true, true);
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		} 
		DatabaseManager.disconnect();
		new MainGUI();
		
	}
	
	// ADDS THE DOCTORS THAT WERE RETREIVED FROM THE DATABASE TO THE CLASS
	public static void setDoctors(ResultSet rs) throws SQLException, ParseException{
		while (rs.next())
		{  
			Doctor newDoctor = new Doctor(rs.getString(2), rs.getString(3));  
			newDoctor.setDocID(rs.getInt(1));
			doctorList.add(newDoctor);
		}
	}
	
	// ADDS THE PATIENTS THAT WERE RETREIVED FROM THE DATABASE TO THE RIGHT DOCTOR
	public static void setPatients(ResultSet rs) throws SQLException, ParseException{
		while (rs.next())
		{ 
			Date date = format.parse(rs.getString(5));
			Patient newPatient = new Patient(rs.getString(2), rs.getString(3), rs.getString(4), date);  
			newPatient.setpId(rs.getInt(1));
			doctorList.get(rs.getInt(6)).addPatient(newPatient);
		}
	}
	
	// ADDS THE MEDICAL HISTORY THAT WERE RETREIVED FROM THE DATABASE TO CORRECT PATIENT
	
	public static void setMedHistory(ResultSet rs) throws SQLException, ParseException{
		while (rs.next())
		{
			PatientHistory newHistory = new PatientHistory(rs.getDate(2), rs.getString(3), rs.getString(4), rs.getString(5));  
			newHistory.setHistoryID(rs.getInt(1));   
			doctorList.get(docID).search(rs.getInt(6)).doctorsVisit(newHistory);
		}
	}
	
	// ACCEPTS A SQL QUERY AND SENDS IT TO THE DATABASE
	
	public static void saveToDB(String query) throws ClassNotFoundException, SQLException, ParseException
	{
		DatabaseManager.newConnection(query);
	} 
	
	//ADDS A DOCTOR TO THE PROGRAM
	
	public static boolean addDoctor(Doctor doctor)
	{
		if(Integer.valueOf(doctor.getDocID()).equals("") || doctor.getDocName().equals("") || doctor.getDocPhone().equals(""))
			return false;
		
		doctorList.add(doctor);
		return true;
	}
	
	//UPDATES A DOCTOR IN THE PROGRAM
	public static void updateDoctor(Doctor doctor)
	{  
		int i = 0;
		for(Doctor d : doctorList){
			if(d.getDocID() == doctor.getDocID())
				doctorList.set(i , doctor);
			i++;
		} 
	}

}
