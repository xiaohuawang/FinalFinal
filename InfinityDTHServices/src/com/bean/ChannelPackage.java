package com.bean;

import java.util.ArrayList;
import java.util.Date;

public class ChannelPackage {
	private String name;
	private ArrayList<String> category = new ArrayList<>();
	private String chargingType;
	private String packageTransmissionType;
	private ArrayList<Channel> channels = new ArrayList<Channel>();
	private double cost;
	private Date availableFromDate;
	private Date availableToDate;
	private String addedByDefault;
	//private String channelPackage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getCategory() {
		return category;
	}
	public void setCategory(ArrayList<String> category) {
		this.category = category;
	}
	public String getChargingType() {
		return chargingType;
	}
	public void setChargingType(String chargingType) {
		this.chargingType = chargingType;
	}
	public String getPackageTransmissionType() {
		return packageTransmissionType;
	}
	public void setPackageTransmissionType(String packageTransmissionType) {
		this.packageTransmissionType = packageTransmissionType;
	}
	public ArrayList<Channel> getChannels() {
		return channels;
	}
	public void setChannels(ArrayList<Channel> channels) {
		this.channels = channels;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Date getAvailableFromDate() {
		return availableFromDate;
	}
	public void setAvailableFromDate(Date availableFromDate) {
		this.availableFromDate = availableFromDate;
	}
	public Date getAvailableToDate() {
		return availableToDate;
	}
	public void setAvailableToDate(Date availableToDate) {
		this.availableToDate = availableToDate;
	}
	public String getAddedByDefault() {
		return addedByDefault;
	}
	public void setAddedByDefault(String addedByDefault) {
		this.addedByDefault = addedByDefault;
	}
	
	/*
	@Override
	public String toString() {
		return new String("ChannelPackageId: " + channelPackageId + ", " + channelPackage);
	}
	*/
}
