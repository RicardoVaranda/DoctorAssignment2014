package org.doctorsolutions.model.patients; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MedicalHistory {
	
	private String medDescription, medTreatment;
	private boolean medPaid;
	private int patientID, medicalID;
	private Date medDate;
	private SimpleDateFormat pre = new SimpleDateFormat ("yyyy-MM-dd");
	private SimpleDateFormat after = new SimpleDateFormat ("dd-mm-yyyy");

	public MedicalHistory() {
		
	}
	
	public MedicalHistory(int id, int patientID, String date, String desc, String treat, boolean paid) throws ParseException
	{ 
		setMedicalID(id);
		setPatientID(patientID);
		setMedDate(date);
		setMedDescription(desc);
		setMedTreatment(treat);
		setMedPaid(paid);
	} 

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public int getMedicalID() {
		return medicalID;
	}

	public void setMedicalID(int medicalID) {
		this.medicalID = medicalID;
	}
	
	public Date getMedDate()
	{ 
		return medDate;
	}
	
	public void setMedDate(String medDate) throws ParseException
	{    
		Date d = pre.parse(medDate);
		this.medDate = d;
	}

	public boolean isMedPaid() {
		return medPaid;
	}

	public void setMedPaid(boolean medPaid) {
		this.medPaid = medPaid;
	}

	public String getMedDescription() {
		return medDescription;
	}

	public void setMedDescription(String medDescription) {
		this.medDescription = medDescription;
	}

	public String getMedTreatment() {
		return medTreatment;
	}

	public void setMedTreatment(String medTreatment) {
		this.medTreatment = medTreatment;
	}
}
