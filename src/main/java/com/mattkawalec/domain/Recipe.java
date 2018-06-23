package com.mattkawalec.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//The Class that defines recipe and ingredients of production 

public class Recipe extends ElementOfDatabase  {

	String recipeId;
	String fullName;
	String resultProductId;
	double costOfWorkingHours;


	List<ProductQuantityPair> recipeList;
	
	public List<Object> getElementsList() {
		List<Object> elementsList = new ArrayList<>();
		elementsList.add(this.recipeId);
		elementsList.add(this.fullName);
		elementsList.add(this.resultProductId);
		elementsList.add(this.costOfWorkingHours);
		return elementsList;
	}
	
	public static String[] getLocalNames() {
		String[] localNames = {"Id", "Nazwa", "Produkt koñcowy", "Koszty pracy"};
		return localNames;
	}
	
	public Recipe() {
		super();
	}

	public Recipe(String recipeId, String fullName, String resultProductId, double costOfWorkingHours,
			List<ProductQuantityPair> recipeList) {
		super();
		this.recipeId = recipeId;
		this.fullName = fullName;
		this.resultProductId = resultProductId;
		this.costOfWorkingHours = costOfWorkingHours;
		this.recipeList = recipeList;
	}

	public String getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(String recipeId) {
		this.recipeId = recipeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getResultProductId() {
		return resultProductId;
	}

	public void setResultProductId(String resultProductId) {
		this.resultProductId = resultProductId;
	}

	public double getCostOfWorkingHours() {
		return costOfWorkingHours;
	}

	public void setCostOfWorkingHours(double costOfWorkingHours) {
		this.costOfWorkingHours = costOfWorkingHours;
	}

	public List<ProductQuantityPair> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<ProductQuantityPair> recipeList) {
		this.recipeList = recipeList;
	}

	


	
	
}
