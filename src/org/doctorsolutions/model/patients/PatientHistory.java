package org.doctorsolutions.model.patients; 

import java.text.ParseException; 
import java.util.Date;

public class PatientHistory {
	
	private String description, medicine, procedure; 
	private int historyID;
	private Date visitDate; 
	
	public PatientHistory() {
		
	}
	
	public PatientHistory(Date date, String desc, String meds, String proc) throws ParseException
	{  
		setVisitDate(date);
		setDescription(desc);
		setMedicine(meds);
		setProcedure(proc);
	}
	
	// GETTERS AND SETTERS

	public int getHistoryID() {
		return historyID;
	}

	public void setHistoryID(int historyID) {
		this.historyID = historyID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getProcedure() {
		return procedure;
	}

	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	} 
 
}
