package com.ros.cms.dto;

public class Shipper {
	private String shipperName;
	private String shipperAddress;
	private String shipperState;
	
	public Shipper(String name, String address, String state) {
		this.shipperName = name;
		this.shipperAddress = address;
		this.shipperState = state;
	}
	
	public String getShipperName() {
		return shipperName;
	}
	
	public String getShipperAddress() {
		return shipperAddress;
	}
	
	public String getShipperState() {
		return shipperState;
	}
	
	public void setShipperName(String name) {
		this.shipperName = name;
	}
	
	public void setShipperAddress(String address) {
		this.shipperAddress = address;
	}
}
