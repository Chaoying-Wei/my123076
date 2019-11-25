package com.neuedu.my12306.bean;

public class FareBean {
	private int fareId;
	private String fareName;
	private String fProvince;
	private String fImg;
	public int getFareId() {
		return fareId;
	}
	public void setFareId(int fareId) {
		this.fareId = fareId;
	}
	public String getFareName() {
		return fareName;
	}
	public void setFareName(String fareName) {
		this.fareName = fareName;
	}
	public String getfProvince() {
		return fProvince;
	}
	public void setfProvince(String fProvince) {
		this.fProvince = fProvince;
	}
	public String getfImg() {
		return fImg;
	}
	public void setfImg(String fImg) {
		this.fImg = fImg;
	}
	public FareBean(int fareId, String fareName, String fProvince, String fImg) {
		super();
		this.fareId = fareId;
		this.fareName = fareName;
		this.fProvince = fProvince;
		this.fImg = fImg;
	}
	public FareBean() {
		super();
	}
	
	

}
