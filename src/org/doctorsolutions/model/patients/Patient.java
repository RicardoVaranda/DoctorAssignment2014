package org.doctorsolutions.model.patients;
 
import java.util.ArrayList;
import java.util.Date;

public class Patient {
	
	private int pId;
	private String pName;
	private String pAddress;
	private String pPhone;
	private Date pDOB; 
	
	public ArrayList<PatientHistory> myHistory = new ArrayList<PatientHistory>();

	public Patient() {
		
	}
	public Patient(String pName, String pAddress, String pPhone, Date pDOB)
	{ 
		setpName(pName);
		setpAddress(pAddress);
		setpPhone(pPhone);
		setpDOB(pDOB); 
		//numPatients ++;
	}
	 
	public void doctorsVisit(PatientHistory pHistory)
	{
		myHistory.add(pHistory);
	}	
	
	// GETS THE SIZE OF THE PATIENTS MEDICAL HISTORY
  
	public int getHistListSize()
	{
		return myHistory.size();
	}
	
	// GETTERS AND SETTERS
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpAddress() {
		return pAddress;
	}
	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}
	public String getpPhone() {
		return pPhone;
	}
	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}
	public Date getpDOB() {
		return pDOB;
	}
	public void setpDOB(Date pDOB) {
		this.pDOB = pDOB;
	} 
}
