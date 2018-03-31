package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mattkawalec.T;
import com.mattkawalec.connection.ConnectionClient;
import com.mattkawalec.domain.Document;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.Recipe;

public class TablePanel extends JPanel {

	JTable table;
	DefaultTableModel dTableModel;
	JScrollPane scrollPane;
	Object[][] productsDatabase;
	Object[][] recipeDatabase;
	Object[][] documentsDatabase;
	MainFrame mainFrame;
	Container c;

	public TablePanel(MainFrame extendMainFrame) {
		super();

		mainFrame = extendMainFrame;
		setLayout(new BorderLayout());
		T.t("sdas");
	}

	public void createProductsTable(List<Product> productsList) {
		removeAll();
		
		
		
		
		String[] columnNames = { "ID", "NAZWA", "ILOSC", "CENA" };
		dTableModel = new DefaultTableModel(productsDatabase, columnNames);
		table = new JTable(dTableModel);
		addProductRows(productsList);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		// table.setFillsViewportHeight(true);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);
	}

	public void createRecipeTable(List<Recipe> recipeList) {
		removeAll();
		
		
		String[] columnNames = { "ID", "NAZWA", "PRODUCT KOÑCOWY", "ROBOCZO-GODZINY" };
		dTableModel = new DefaultTableModel(recipeDatabase, columnNames);
		table = new JTable(dTableModel);
		addRecipeRows(recipeList);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);

	}

	public void createDocumentsTable(List<Document> documentsList) {
		String[] columnNames = { "ID", "TYP DOKUMENTU", "OPIS", "DATA" };
		dTableModel = new DefaultTableModel(documentsDatabase, columnNames);
		table = new JTable(dTableModel);
		addDocumentsRows(documentsList);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);

	}

	
	
	private void addProductRows(List<Product> productList) {
		for (Product tempProduct : productList) {
			Object[] tempObjectTable = new Object[] { tempProduct.getProductId(), tempProduct.getFullName(),
					tempProduct.getQuantity(), tempProduct.getPrice() };
			dTableModel.addRow(tempObjectTable);
		}
	}
	
	private void addRecipeRows(List<Recipe> recipeList) {
		for (Recipe tempRecipe : recipeList) {
			Object[] tempObjectTable = new Object[] { tempRecipe.getRecipeId(), tempRecipe.getFullName(),
					tempRecipe.getResultProductId(), tempRecipe.getWorkHours()};
			dTableModel.addRow(tempObjectTable);
		}
	}
	
	private void addDocumentsRows(List<Document> documentList) {
		for (Document tempDocument : documentList) {
			Object[] tempObjectTable = new Object[] { tempDocument.getDocumentId(), tempDocument.getTypeOfTransaction(),
					tempDocument.getDescription(), tempDocument.getCreateDate() };
			dTableModel.addRow(tempObjectTable);
		}
	}

}
