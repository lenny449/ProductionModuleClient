package com.mattkawalec.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {

	String recipeId;
	String fullName;
	String resultProductId;
	double workHours;

	List<ProductQuantityPair> recipeList;
	
	public Recipe() {
		super();
	}

	public Recipe(String recipeId, String fullName, String resultProductId, double workHours,
			List<ProductQuantityPair> receipeList) {
		super();
		this.recipeId = recipeId;
		this.fullName = fullName;
		this.resultProductId = resultProductId;
		this.workHours = workHours;
		this.recipeList = receipeList;
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

	public double getWorkHours() {
		return workHours;
	}

	public void setWorkHours(double workHours) {
		this.workHours = workHours;
	}

	public List<ProductQuantityPair> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<ProductQuantityPair> recipeList) {
		this.recipeList = recipeList;
	}



	
	
}
