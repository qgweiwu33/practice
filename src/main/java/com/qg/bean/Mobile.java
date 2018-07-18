package com.qg.bean;

public class Mobile {
	private int id;
	private int mobileNumber;
	private String mobileArea;
	private String mobileType;
	private int areaCode;
	private int postCode;
	
	public Mobile() {
		super();
	}
	public Mobile(int id, int mobileNumber, String mobileArea, String mobleType, int areaCode, int postCode) {
		super();
		this.id = id;
		this.mobileNumber = mobileNumber;
		this.mobileArea = mobileArea;
		this.mobileType = mobleType;
		this.areaCode = areaCode;
		this.postCode = postCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(int mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMobileArea() {
		return mobileArea;
	}
	public void setMobileArea(String mobileArea) {
		this.mobileArea = mobileArea;
	}
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobleType) {
		this.mobileType = mobleType;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getPostCode() {
		return postCode;
	}
	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "Mobile [id=" + id + ", mobileNumber=" + mobileNumber + ", mobileArea=" + mobileArea + ", mobleType="
				+ mobileType + ", areaCode=" + areaCode + ", postCode=" + postCode + "]";
	}
	
	
	
}
