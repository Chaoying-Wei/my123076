package com.neuedu.my12306.bean;

import java.util.Date;

public class TicketBean {
	private int ticketId;
	private String startStation;
	private String endStation;
	private Date startDate;
	private Date startTime;
	private String  renames;
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getRenames() {
		return renames;
	}
	public void setRenames(String renames) {
		this.renames = renames;
	}
	public TicketBean(int ticketId, String startStation, String endStation, Date startDate, Date startTime,
			String renames) {
		super();
		this.ticketId = ticketId;
		this.startStation = startStation;
		this.endStation = endStation;
		this.startDate = startDate;
		this.startTime = startTime;
		this.renames = renames;
	}
	public TicketBean() {
		super();
	}
	
	

}
