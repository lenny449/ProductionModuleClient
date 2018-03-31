package com.mattkawalec.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Document {
	public enum TypeOfTransaction {RW, PW, WZ, PZ};

	String documentId;
	String description;
	String createDate;
	TypeOfTransaction typeOfTransaction;

	List<ProductQuantityPair> recipeList;	
	
	public Document() {
		super();
	}

	public Document(String documentId, String description, String createDate, TypeOfTransaction typeOfTransaction,
			List<ProductQuantityPair> recipeList) {
		super();
		this.documentId = documentId;
		this.description = description;
		this.createDate = createDate;
		this.typeOfTransaction = typeOfTransaction;
		this.recipeList = recipeList;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public TypeOfTransaction getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(TypeOfTransaction typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public List<ProductQuantityPair> getRecipeList() {
		return recipeList;
	}

	public void setRecipeList(List<ProductQuantityPair> recipeList) {
		this.recipeList = recipeList;
	}


	
	
	
}
