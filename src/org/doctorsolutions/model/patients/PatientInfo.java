package org.doctorsolutions.model.patients;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientInfo {
	
//	private static String[] patientID = new String[500];
//	private static String[] patientName = new String[500];
//	private static String[] patientAddress = new String[500];
//	private static String[] patientEmail = new String[500];
//	private static String[] patientContactNo = new String[500];
//	private static String[] patientGender = new String[500];
//	private static String[] patientDOB = new String[500];
	
	private int patientID;
	private String patientName;
	private String patientAddress;
	private String patientEmail;
	private String patientContactNo;
	private String patientGender;
	private String patientDOB;
	
	public static int numPatients = 0;
	
	/*
	 * 
	 *
	 1		PatientID
	 2 		PatientName
	 3		PatientAddress
	 4		PatientEmail
	 5		PatientContactNo
	 6		PatientGender Descending
	 7		PatientDOB
	 *
	 *
	 */
	
	PatientInfo(){
		
	}
	
	PatientInfo(int id, String name, String address, String email, String contact, String gender, String dob)
	{
		setPatientID(id);
		setPatientName(name);
		setPatientAddress(address);
		setPatientEmail(email);
		setPatientContactNo(contact);
		setPatientGender(gender);
		setPatientDOB(dob);
		numPatients ++;
	}
	
	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public String getPatientContactNo() {
		return patientContactNo;
	}

	public void setPatientContactNo(String patientContactNo) {
		this.patientContactNo = patientContactNo;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(String patientDOB) {
		this.patientDOB = patientDOB;
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
			numPatients++;
		}
	} 
}
