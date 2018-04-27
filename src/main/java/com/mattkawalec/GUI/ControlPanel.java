package com.mattkawalec.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.mattkawalec.T;
import com.mattkawalec.GUI.MainFrame;
import com.mattkawalec.connection.ConnectionClient;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.ProductQuantityPair;
import com.mattkawalec.domain.Recipe;

public class ControlPanel extends JPanel {
	ConnectionClient connectionClient;
	
	JButton productsButton;
	JButton recipeButton;
	JButton documentsButton;
	TablePanel tablePanel;
	

	
	public ControlPanel(TablePanel externalTablePanel) {
		super();
		
		connectionClient = new ConnectionClient();
		
		tablePanel = externalTablePanel;
		
		ImageIcon productIcon = new ImageIcon("src/main/resources/product_icon.png");
		ImageIcon recipeIcon = new ImageIcon("src/main/resources/recipe_icon.png");
		ImageIcon documentIcon = new ImageIcon("src/main/resources/document_icon.png");
		
		productsButton = new JButton("TOWARY", productIcon);
		recipeButton = new JButton("RECEPTURY", recipeIcon);
		documentsButton = new JButton("DOKUMENTY", documentIcon);
		
		productsButton.addActionListener(new productsButtonListener());
		recipeButton.addActionListener(new recipeButtonListener());
		documentsButton.addActionListener(new documentsButtonListener());
		
		add(productsButton);
		add(recipeButton);
		add(documentsButton);
		
		setBorder(BorderFactory.createTitledBorder("Sterowanie"));
		//Dimension size = getPreferredSize();
		//size.height = 60;
		//setPreferredSize(size);
		
		//TEST
		//ContentOfElementFrame contentOfElementFrame = new ContentOfElementFrame(connectionClient.getProduct("HN"));
		
		ProductQuantityPair pqp1 = new ProductQuantityPair("HN", 4.0);
		ProductQuantityPair pqp2 = new ProductQuantityPair("LE", 2.0);
		List<ProductQuantityPair> listaPQP = new ArrayList<ProductQuantityPair>();
		listaPQP.add(pqp1);
		listaPQP.add(pqp2);
		
		Recipe r1 = new Recipe("B1", "bimbrowanie", "BIMP1201", 4, listaPQP);
		//connectionClient.addRecipe(r1);
		
		ContentOfElementFrame contentOfElementFrame = new ContentOfElementFrame(connectionClient.getRecipe("B11"));
	}
	
	public class productsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tablePanel.createProductsTable(connectionClient.getAllProducts());
		} 
	}
	
	public class recipeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tablePanel.createRecipeTable(connectionClient.getAllRecipe());	
		} 
	}
	
	public class documentsButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			tablePanel.createDocumentsTable(connectionClient.getAllDocuments());
			
		} 
	}
}
