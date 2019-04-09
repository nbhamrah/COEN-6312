package com.coen6312.ocs.bean;

import java.util.Date;

/**
 * The Class LeaveBean.
 */
public class LeaveBean {
	private String doctorID;
	private Date leaveFrom;
	private Date leaveTo;
	private String reason;
	private int status;
	
	/**
	 * Gets the doctor ID.
	 *
	 * @return the doctor ID
	 */
	public String getDoctorID() {
		return doctorID;
	}
	
	/**
	 * Sets the doctor ID.
	 *
	 * @param doctorID the new doctor ID
	 */
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	/**
	 * Gets the leave from.
	 *
	 * @return the leave from
	 */
	public Date getLeaveFrom() {
		return leaveFrom;
	}
	
	/**
	 * Sets the leave from.
	 *
	 * @param leaveFrom the new leave from
	 */
	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	
	/**
	 * Gets the leave to.
	 *
	 * @return the leave to
	 */
	public Date getLeaveTo() {
		return leaveTo;
	}
	
	/**
	 * Sets the leave to.
	 *
	 * @param leaveTo the new leave to
	 */
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}
	
	/**
	 * Gets the reason.
	 *
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}
	
	/**
	 * Sets the reason.
	 *
	 * @param reason the new reason
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
}
