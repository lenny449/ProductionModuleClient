package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mattkawalec.T;
import com.mattkawalec.connection.ConnectionClient;
import com.mattkawalec.domain.Document;
import com.mattkawalec.domain.ElementOfDatabase;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.Recipe;

public class TablePanel extends JPanel {
	Container c;
	DefaultTableModel dTableModel;
	JTable table;	
	JScrollPane scrollPane;
	Object[][] productsDatabase;
	Object[][] recipeDatabase;
	Object[][] documentsDatabase;
	MainFrame mainFrame;
	

	public TablePanel(MainFrame extendMainFrame) {
		super();
		setLayout(new BorderLayout());
		mainFrame = extendMainFrame;
		
		//TEST
		test(new Product());
		
	}

	public void createTable(List<ElementOfDatabase> elementOfDatabaseList, ElementOfDatabase eod) {
		removeAll();		
		String[] columnNames;
		if(eod instanceof Product)
		{
			Product tempProduct = (Product)eod;
			columnNames = tempProduct.getLocalNames();
		} 
		else if (eod instanceof Recipe) {
			Recipe tempRecipe = (Recipe)eod;
			columnNames = tempRecipe.getLocalNames();
		} 
		else if(eod instanceof Document)
		{
			Document tempDocument = (Document)eod;
			columnNames = tempDocument.getLocalNames();
		}
			
		dTableModel = new DefaultTableModel(productsDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		//table.setFillsViewportHeight(true);
		
		for(int i = 0; i < elementOfDatabaseList.size(); i++) {
			elementOfDatabaseList.
		}
		dTableModel.addRow(elementOfDatabaseList.get);
		addProductRows(productsList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.NORTH);
		mainFrame.setVisible(true);

	}
	
	public void test(ElementOfDatabase eod) {
		T.t("jestem w funkcji test");
		T.t(eod.getLocalNames());
		Product p1 = (Product.class) eod;
		if(eod instanceof Product)
		{
			T.t("to jest produkt");
		}
		if(eod instanceof ElementOfDatabase)
		{
			T.t("to jest ElementOfDatabase");
		}
		T.t(eod.getLocalNames());

	}
	
	public void createProductsTable(List<Product> productsList) {
		removeAll();
		//String[] columnNames = { "ID", "NAZWA", "ILOSC", "CENA" };
		String[] columnNames = Product.getLocalNames();
		dTableModel = new DefaultTableModel(productsDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		//table.setFillsViewportHeight(true);
		addProductRows(productsList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.NORTH);
		mainFrame.setVisible(true);

	}

	public void createRecipeTable(List<Recipe> recipeList) {
		removeAll();	
		String[] columnNames = Recipe.getLocalNames();
		dTableModel = new DefaultTableModel(recipeDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		//table.setFillsViewportHeight(true);
		addRecipeRows(recipeList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.NORTH);
		mainFrame.setVisible(true);

	}

	public void createDocumentsTable(List<Document> documentsList) {
		removeAll();
		String[] columnNames = Document.getLocalNames();
		dTableModel = new DefaultTableModel(documentsDatabase, columnNames);
		table = new JTable(dTableModel);
		//table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		addDocumentsRows(documentsList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.NORTH);
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
