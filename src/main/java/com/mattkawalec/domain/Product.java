package com.mattkawalec.domain;

import java.util.ArrayList;
import java.util.List;


public class Product {

	private String productId;
	private String fullName;
	private double quantity;
	private double price;
	
	public List<Object> getElementsList() {
		List<Object> elementsList = new ArrayList<>();
		elementsList.add(this.productId);
		elementsList.add(this.fullName);
		elementsList.add(this.quantity);
		elementsList.add(this.price);
		return elementsList;
	}
	
	public String[] getLocalNames() {
		String[] localNames = {"Id", "Nazwa", "Ilość", "Koszt"};
		return localNames;
	}
	
	public Product() {
		super();
	}

	public Product(String productId, String fullName, double quantity, double price) {
		super();
		this.productId = productId;
		this.fullName = fullName;
		this.quantity = quantity;
		this.price = price;
	}
	


	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
