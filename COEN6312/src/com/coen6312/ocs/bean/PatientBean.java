package com.coen6312.ocs.bean;

import java.util.Date;

public class PatientBean {
	private String patientID;
	private String userID;
	private Date appointmentDate;
	private String ailmentType;
	private String ailmentDetails;
	private String diagnosisHistory;
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAilmentType() {
		return ailmentType;
	}
	public void setAilmentType(String ailmentType) {
		this.ailmentType = ailmentType;
	}
	public String getAilmentDetails() {
		return ailmentDetails;
	}
	public void setAilmentDetails(String ailmentDetails) {
		this.ailmentDetails = ailmentDetails;
	}
	public String getDiagnosisHistory() {
		return diagnosisHistory;
	}
	public void setDiagnosisHistory(String diagnosisHistory) {
		this.diagnosisHistory = diagnosisHistory;
	}
	
}
