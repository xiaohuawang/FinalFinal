package com.bean;

import java.util.ArrayList;

public class SetTopBox {
	private String stbType;
	private ArrayList<STBFeature> features;
	private Dimension dimension;
	private double price;
	private double installationCharges;
	private double upgradingCharges;
	private double discount;
	private String billType;
	private double refundableDepositAmount;
	private STBInventory inventory;


	public String getStbType() {
		return stbType;
	}

	public void setStbType(String stbType) {
		this.stbType = stbType;
	}

	public String getBillType() {
		return billType;
	}

	public void setBillType(String billType) {
		this.billType = billType;
	}

	public ArrayList<STBFeature> getFeatures() {
		return features;
	}

	public void setFeatures(ArrayList<STBFeature> features) {
		this.features = features;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getInstallationCharges() {
		return installationCharges;
	}

	public void setInstallationCharges(double installationCharges) {
		this.installationCharges = installationCharges;
	}

	public double getUpgradingCharges() {
		return upgradingCharges;
	}

	public void setUpgradingCharges(double upgradingCharges) {
		this.upgradingCharges = upgradingCharges;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getRefundableDepositAmount() {
		return refundableDepositAmount;
	}

	public void setRefundableDepositAmount(double refundableDepositAmount) {
		this.refundableDepositAmount = refundableDepositAmount;
	}

	public STBInventory getInventory() {
		return inventory;
	}

	public void setInventory(STBInventory inventory) {
		this.inventory = inventory;
	}
	
	
}
