package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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

// Component that create table of Product, Recipe or Document

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
		
		
		
	}
	
	
	public void createProductsTable(List<Product> productsList) {
		removeAll();
		//String[] columnNames = { "ID", "NAZWA", "ILOSC", "CENA" };
		String[] columnNames = Product.getLocalNames();
		dTableModel = new DefaultTableModel(productsDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		addProductRows(productsList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);
		
/*		table.addMouseListener(new MouseAdapter(){
		     public void mouseClicked(MouseEvent e){
		      if (e.getClickCount() == 2){
		         System.out.println(" double click" );
		         }
		      }
		     } );*/
		

	
/*	public class MouseAdapter implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		*/
	}

	public void createRecipeTable(List<Recipe> recipeList) {
		removeAll();	
		String[] columnNames = Recipe.getLocalNames();
		dTableModel = new DefaultTableModel(recipeDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		addRecipeRows(recipeList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);

	}

	public void createDocumentsTable(List<Document> documentsList) {
		removeAll();
		String[] columnNames = Document.getLocalNames();
		dTableModel = new DefaultTableModel(documentsDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setFillsViewportHeight(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		addDocumentsRows(documentsList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);

	}

	
	
	private void addProductRows(List<Product> productList) {
		for (Product tempProduct : productList) {
			Object[] tempObjectTable = tempProduct.getElementsList().toArray();
			dTableModel.addRow(tempObjectTable);
		}
	}
	
	private void addRecipeRows(List<Recipe> recipeList) {
		for (Recipe tempRecipe : recipeList) {
			Object[] tempObjectTable = tempRecipe.getElementsList().toArray();
			dTableModel.addRow(tempObjectTable);
		}
	}
	
	private void addDocumentsRows(List<Document> documentList) {
		for (Document tempDocument : documentList) {
			Object[] tempObjectTable = tempDocument.getElementsList().toArray();
			dTableModel.addRow(tempObjectTable);
		}
	}
	


}
