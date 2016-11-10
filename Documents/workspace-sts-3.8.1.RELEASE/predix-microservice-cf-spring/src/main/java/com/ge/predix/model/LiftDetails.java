/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */
 
package com.ge.predix.model;

import java.util.Date;

/**
 * 
 * @author predix -
 */
public class LiftDetails {

	
	private Integer tenentID;
	private String  sessionID;
	private String  locationID;
	private String  elevatorID;
	private String elevatorStartDate;
	private String elevatorToDate;
	/**
	 * @return the tenentID
	 */
	public Integer getTenentID() {
		return this.tenentID;
	}
	/**
	 * @param tenentID the tenentID to set
	 */
	public void setTenentID(Integer tenentID) {
		this.tenentID = tenentID;
	}
	/**
	 * @return the sessionID
	 */
	public String getSessionID() {
		return this.sessionID;
	}
	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	/**
	 * @return the locationID
	 */
	public String getLocationID() {
		return this.locationID;
	}
	/**
	 * @param locationID the locationID to set
	 */
	public void setLocationID(String locationID) {
		this.locationID = locationID;
	}
	/**
	 * @return the elevatorID
	 */
	public String getElevatorID() {
		return this.elevatorID;
	}
	/**
	 * @param elevatorID the elevatorID to set
	 */
	public void setElevatorID(String elevatorID) {
		this.elevatorID = elevatorID;
	}
	/**
	 * @return the elevatorStartDate
	 */
	public String getElevatorStartDate() {
		return this.elevatorStartDate;
	}
	/**
	 * @param elevatorStartDate the elevatorStartDate to set
	 */
	public void setElevatorStartDate(String elevatorStartDate) {
		this.elevatorStartDate = elevatorStartDate;
	}
	/**
	 * @return the elevatorToDate
	 */
	public String getElevatorToDate() {
		return this.elevatorToDate;
	}
	/**
	 * @param elevatorToDate the elevatorToDate to set
	 */
	public void setElevatorToDate(String elevatorToDate) {
		this.elevatorToDate = elevatorToDate;
	}
	/**
	 *  -
	 */
	public LiftDetails() {
		// TODO Auto-generated constructor stub
	}

}
