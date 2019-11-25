package com.neuedu.my12306.bean;

import java.util.Date;

public class reuserBean {
	private String reNames;
	private String rePass;
	private String reTrueName;
	private String sex;
	private String province;
	private String city;
	private String cardTpye;
	private String idNumber;
	private String passengerType;
	private String tips;
	private Date birthday;
	//-1超级管理员，0普通用户，1管理员
	private int isAdmin;
	private String img;
	
	public reuserBean(String reNames, String rePass, String reTrueName, String sex, String province, String city,
			String cardTpye, String idNumber, String passengerType, String tips, Date birthday, int isAdmin,
			String img) {
		super();
		this.reNames = reNames;
		this.rePass = rePass;
		this.reTrueName = reTrueName;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.cardTpye = cardTpye;
		this.idNumber = idNumber;
		this.passengerType = passengerType;
		this.tips = tips;
		this.birthday = birthday;
		this.isAdmin = isAdmin;
		this.img = img;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public reuserBean() {
		super();
	}
	public reuserBean(String reNames, String rePass) {
		this.reNames = reNames;
		this.rePass = rePass;
	}
	
	public reuserBean(String reNames, String rePass, String reTrueName, String sex, String province, String city,
			String cardTpye, String idNumber, String passengerType, String tips, Date birthday) {
		super();
		this.reNames = reNames;
		this.rePass = rePass;
		this.reTrueName = reTrueName;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.cardTpye = cardTpye;
		this.idNumber = idNumber;
		this.passengerType = passengerType;
		this.tips = tips;
		this.birthday = birthday;
		
		
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getReNames() {
		return reNames;
	}
	public void setReNames(String reNames) {
		this.reNames = reNames;
	}
	public String getRePass() {
		return rePass;
	}
	public void setRePass(String rePass) {
		this.rePass = rePass;
	}
	public String getReTrueName() {
		return reTrueName;
	}
	public void setReTrueName(String reTrueName) {
		this.reTrueName = reTrueName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCardTpye() {
		return cardTpye;
	}
	public void setCardTpye(String cardTpye) {
		this.cardTpye = cardTpye;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPassengerType() {
		return passengerType;
	}
	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	@Override
	public String toString() {
		return "reuserBean [reNames=" + reNames + ", rePass=" + rePass + ", reTrueName=" + reTrueName + ", sex=" + sex
				+ ", province=" + province + ", city=" + city + ", cardTpye=" + cardTpye + ", idNumber=" + idNumber
				+ ", passengerType=" + passengerType + ", tips=" + tips + ", birthday=" + birthday + ", isAdmin="
				+ isAdmin + ", img=" + img + "]";
	}
	
	

}
