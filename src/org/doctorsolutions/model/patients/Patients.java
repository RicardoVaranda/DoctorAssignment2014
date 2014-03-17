package org.doctorsolutions.model.patients;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Patients {
	
	private static ArrayList<PatientInfo> patientList = new ArrayList<PatientInfo>();
	private static ArrayList<MedicalHistory> historyList = new ArrayList<MedicalHistory>();

	public Patients() {
		
	}
	
	public static void removePatient(int i)
	{ 
		patientList.remove(i);  
	}
	
	public static void removePatientHistory(int i)
	{
		for(int x = 0; x < Patients.getHistListSize(); x++)
		{
			if(getPatientMedID(x) == Patients.getPatientID(i))
			{
				historyList.remove(x); 
			}
		}
	}
	
	public static void addPatient(int id, String name, String address, String email, String contact, String gender, String dob)
	{
		patientList.add(new PatientInfo(id, name, address, email, contact, gender, dob));
	}
	
	public static void addMedHistory(int id, int patientID, String date, String desc, String treat, boolean paid) throws ParseException
	{
		historyList.add(new MedicalHistory(id, patientID, date, desc, treat, paid));
	}	
	
	public static int getPatListSize()
	{
		return patientList.size();
	}
	
	public static int getHistListSize()
	{
		return historyList.size();
	}
	
	public static int getPatientID(int ID)
	{
		return patientList.get(ID).getPatientID();
	}
	
	public static void setPatientID(int num, int ID)
	{
		patientList.get(num).setPatientID(ID);
	}
	
	public static String getPatientName(int ID)
	{
		return patientList.get(ID).getPatientName();
	}
	
	public static void setPatientName(int num, String ID)
	{
		patientList.get(num).setPatientName(ID);
	}
	
	public static String getPatientAddress(int ID)
	{
		return patientList.get(ID).getPatientAddress();
	}
	
	public static void setPatientAddress(int num, String ID)
	{
		patientList.get(num).setPatientAddress(ID);
	}
	
	public static String getPatientEmail(int ID)
	{
		return patientList.get(ID).getPatientEmail();
	}
	
	public static void setPatientEmail(int num, String ID)
	{
		patientList.get(num).setPatientEmail(ID);
	}
	
	public static String getPatientContact(int ID)
	{
		return patientList.get(ID).getPatientContactNo();
	}
	
	public static void setPatientContact(int num, String ID)
	{
		patientList.get(num).setPatientContactNo(ID);
	}
	
	public static String getPatientGender(int ID)
	{
		return patientList.get(ID).getPatientGender();
	}
	
	public static void setPatientGender(int num, String ID)
	{
		patientList.get(num).setPatientGender(ID);
	}
	
	public static String getPatientDob(int ID)
	{
		return patientList.get(ID).getPatientDOB();
	}
	
	public static void setPatientDob(int num, String ID)
	{
		patientList.get(num).setPatientDOB(ID);
	}
	
	public static int getMedicalID(int ID)
	{
		return historyList.get(ID).getMedicalID();
	}
	
	public static void setMedicalID(int ID, int num)
	{
		historyList.get(ID).setMedicalID(num);
	}
	
	public static int getPatientMedID(int ID)
	{
		return historyList.get(ID).getPatientID();
	}
	
	public static void setPatientMedID(int ID, int num)
	{
		historyList.get(ID).setPatientID(num);
	}
	
	public static Date getMedicalDate(int ID)
	{
		return historyList.get(ID).getMedDate();
	}
	
	public static void setMedicalDate(int ID, String date) throws ParseException
	{
		historyList.get(ID).setMedDate(date);
	}
	
	public static boolean isMedPaid(int ID)
	{
		return historyList.get(ID).isMedPaid();
	}
	
	public static void setMedPaid(int ID, boolean num)
	{
		historyList.get(ID).setMedPaid(num);
	}
	
	public static String getMedDescription(int ID)
	{
		return historyList.get(ID).getMedDescription();
	}
	
	public static void setMedDescription(int ID, String num)
	{
		historyList.get(ID).setMedDescription(num);
	}
	
	public static String getMedTreatment(int ID)
	{
		return historyList.get(ID).getMedTreatment();
	}
	
	public static void setMedTreatment(int ID, String num)
	{
		historyList.get(ID).setMedTreatment(num);
	}

}
