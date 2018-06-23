package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mattkawalec.T;
import com.mattkawalec.GUI.ControlPanel.documentsButtonListener;
import com.mattkawalec.GUI.ControlPanel.productsButtonListener;
import com.mattkawalec.GUI.ControlPanel.recipeButtonListener;
import com.mattkawalec.domain.Document;
import com.mattkawalec.domain.ElementOfDatabase;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.ProductQuantityPair;
import com.mattkawalec.domain.Recipe;
import com.mattkawalec.connection.ConnectionClient;

// Frame that show information about single Product, Recipe or Document

public class ContentOfElementFrame extends JFrame {
	JButton saveButton;
	JButton cancelButton;
	JButton addButton;
	JButton removeButton;
	JButton recipeButton;
	JPanel gridSummaryPanel;
	JPanel gridPanel;
	JPanel tablePanel;
	JPanel bottomPanel;
	List<Object> elementList;
	List<JLabel> localNamesJLabelList;
	List<JTextField> elementJLabelList;
	GridLayout gridLayout;
	String[] localNames;
	
	//Zmienne panelu tabeli
	DefaultTableModel dTableModel;
	JTable table;	
	JScrollPane scrollPane;
	Object[][] tableDatabase;
	
	//Pozosta³e zmienne
	ConnectionClient connectionClient;
	ElementOfDatabase elementOfDatabase;
	
	public ContentOfElementFrame(ElementOfDatabase outElementOfDatabase) {
		super();
		
		// Dodanie obiektu po³¹czenia z baz¹
		connectionClient = new ConnectionClient();
		elementOfDatabase = outElementOfDatabase;
		
		// Przypisanie zmiennej ElementOfDatabase
		
		//Ustawienie Managera rozk³adu panelu
		setLayout(new BorderLayout());
		
		if(elementOfDatabase instanceof Product)
		{
			T.t("to jest produkt");
			Product tempProduct = (Product) elementOfDatabase;
			localNames = tempProduct.getLocalNames();
			elementList = tempProduct.getElementsList();
		}
		if(elementOfDatabase instanceof Recipe)
		{
			T.t("to jest recipe");
			Recipe tempRecipe = (Recipe) elementOfDatabase;
			localNames = tempRecipe.getLocalNames();
			elementList = tempRecipe.getElementsList();
		}
		if(elementOfDatabase instanceof Document)
		{
			T.t("to jest dokument");
			Document tempDocument = (Document) elementOfDatabase;
			localNames = tempDocument.getLocalNames();
			elementList = tempDocument.getElementsList();
		}
		
		localNamesJLabelList = new ArrayList<JLabel>();
		elementJLabelList = new ArrayList<JTextField>();
		
		
		//Panel górny
		GridLayout gridLayout = new GridLayout(elementList.size(),2);
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		
		gridPanel = new JPanel();
		gridPanel.setBorder(BorderFactory.createTitledBorder("W³aœciwoœci elementu"));
		gridPanel.setLayout(gridLayout);
		fillGridPanel(); 
		
		add(gridPanel, BorderLayout.NORTH);
		
		//Panel œrodkowy
		if(elementOfDatabase instanceof Recipe){
			Recipe tempRecipe = (Recipe) elementOfDatabase;
			tablePanel = new JPanel();
			tablePanel.setLayout(new BorderLayout());
			fillTablePanel(tempRecipe.getRecipeList());
			add(tablePanel, BorderLayout.CENTER);
		}
		if(elementOfDatabase instanceof Document){
			Document tempDocument = (Document) elementOfDatabase;
			tablePanel = new JPanel();
			tablePanel.setLayout(new BorderLayout());
			fillTablePanel(tempDocument.getRecipeList());
			add(tablePanel, BorderLayout.CENTER);
		}
		
		//Panel dolny
		if(elementOfDatabase instanceof Recipe) {
			bottomPanel = new JPanel();
			createRecipeSummaryPanel(bottomPanel, elementOfDatabase);
			createButtonPanel(bottomPanel, elementOfDatabase);	
			add(bottomPanel, BorderLayout.SOUTH);
		}
		if(elementOfDatabase instanceof Document) {
			bottomPanel = new JPanel();
			createRecipeSummaryPanel(bottomPanel, elementOfDatabase);
			createButtonPanel(bottomPanel, elementOfDatabase);	
			add(bottomPanel, BorderLayout.SOUTH);
		}	
		
		if(elementOfDatabase instanceof Product) {
			bottomPanel = new JPanel();
			createButtonPanel(bottomPanel, elementOfDatabase);	
			add(bottomPanel, BorderLayout.SOUTH);
		}

		
		//Nazwa ramki i wyœwietlenie
		setTitle(elementList.get(0).toString());
		setSize(500, 500);
		
		setVisible(true);
		
	}
	
	private void fillGridPanel()
	{

		for(int i = 0; i<elementList.size(); i++ )
		{
			localNamesJLabelList.add(new JLabel(localNames[i]));
			elementJLabelList.add(new JTextField(elementList.get(i).toString()));
		}
		for(int i = 0; i<elementList.size(); i++ )
		{
			System.out.println(localNames[i]);
			System.out.println(elementList.get(i));
			gridPanel.add(localNamesJLabelList.get(i));
			gridPanel.add(elementJLabelList.get(i));
		}		
		
		
		
	}
	public void fillTablePanel(List<ProductQuantityPair> productQuantityPairList) {
		tablePanel.removeAll();
		String[] columnNames =  {"Produkt", "Iloœæ", "Cena", "Wartoœæ"};
		dTableModel = new DefaultTableModel(tableDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		addProductQuantityPairRows(productQuantityPairList);
		scrollPane = new JScrollPane(table);
		tablePanel.add(scrollPane, BorderLayout.CENTER);
		//mainFrame.setVisible(true);

	}
	

	private void addProductQuantityPairRows(List<ProductQuantityPair> productQuantityPairList) {
		for (ProductQuantityPair tempProductQuantityPair : productQuantityPairList) {
			Object[] tempObjectTable = new Object[4];
			tempObjectTable[0] = tempProductQuantityPair.getPairedProductName();
			tempObjectTable[1] = tempProductQuantityPair.getPairedQuantity();
			tempObjectTable[2] = connectionClient.getProduct(tempProductQuantityPair.getPairedProductName()).getPrice();
			tempObjectTable[3] = (double)tempObjectTable[1]*(double)tempObjectTable[2];
			dTableModel.addRow(tempObjectTable);
		}
		
	}
	
	private void createRecipeSummaryPanel(JPanel outPanel, ElementOfDatabase tempElementOfDatabase) {
		GridLayout gridSummaryLayout = new GridLayout(6,2);
		gridSummaryLayout.setHgap(10);
		gridSummaryLayout.setVgap(10);
		gridSummaryPanel = new JPanel();
		gridSummaryPanel.setBorder(BorderFactory.createTitledBorder("Podsumowanie"));
		gridSummaryPanel.setLayout(gridSummaryLayout);
		
		
		
		Recipe tempRecipe = (Recipe)tempElementOfDatabase;
		
		//Wype³nienie panelu podsumowania 
		gridSummaryPanel.add(new JLabel("Wartoœæ komponentów:"));
		gridSummaryPanel.add(new JLabel("XXX"));
		gridSummaryPanel.add(new JLabel("Wartoœæ pracy:"));
		gridSummaryPanel.add(new JLabel(Double.toString(tempRecipe.getCostOfWorkingHours())));
		gridSummaryPanel.add(new JLabel("Suma:"));
		gridSummaryPanel.add(new JLabel("XXX"));
		gridSummaryPanel.add(new JLabel("Wartoœæ produktu koñcowego"));
		gridSummaryPanel.add(new JLabel("XXX"));
		gridSummaryPanel.add(new JLabel("Zysk bezwzglêdny"));
		gridSummaryPanel.add(new JLabel("XXX"));
		gridSummaryPanel.add(new JLabel("Zysk wzglêdny"));
		gridSummaryPanel.add(new JLabel("XXX"));
		
		outPanel.add(gridSummaryPanel);
		
	}
	
	private void createDocumentSummaryPanel() {
		
			
	
	}
	
	private void createButtonPanel(JPanel outPanel, ElementOfDatabase tempElementOfDatabase) {
		ImageIcon productIcon = new ImageIcon("src/main/resources/product_icon.png");
		
		/*saveButton = new JButton("Zapisz", productIcon);
		cancelButton = new JButton("Anuluj", productIcon);
		addButton = new JButton("Dodaj", productIcon);
		removeButton = new JButton("Usuñ", productIcon);*/
		
		saveButton = new JButton("ZAPISZ");
		cancelButton = new JButton("ANULUJ");
		addButton = new JButton("DODAJ");
		removeButton = new JButton("USUÑ");
		recipeButton = new JButton("RECEPTURA");
		
		saveButton.addActionListener(new saveButtonListener());
		cancelButton.addActionListener(new cancelButtonListener());
		addButton.addActionListener(new addButtonListener());
		removeButton.addActionListener(new removeButtonListener());
		recipeButton.addActionListener(new recipeButtonListener());
		
		JPanel buttonPanel = new JPanel();
		BoxLayout boxLayout = new BoxLayout(buttonPanel, BoxLayout.Y_AXIS);
		
		buttonPanel.setLayout(boxLayout);
		
		
		if(tempElementOfDatabase instanceof Recipe || tempElementOfDatabase instanceof Document) {
			buttonPanel.add(addButton);
			buttonPanel.add(Box.createVerticalStrut(5));   // n pixels of vertical space.
			buttonPanel.add(removeButton);
			buttonPanel.add(Box.createVerticalStrut(5));   // n pixels of vertical space.
		}
		
		if(tempElementOfDatabase instanceof Document) {
			buttonPanel.add(recipeButton);
			buttonPanel.add(Box.createVerticalStrut(5));   // n pixels of vertical space.

		}
		
		buttonPanel.add(cancelButton);
		buttonPanel.add(Box.createVerticalStrut(5));   // n pixels of vertical space.
		//buttonPanel.add(Box.createHorizontalStrut(10));
		buttonPanel.add(saveButton);	
		buttonPanel.add(Box.createVerticalStrut(5));   // n pixels of vertical space.
		
		outPanel.add(buttonPanel);
		
		T.t("jestem w createButtonPanel");
		
	}
	
	public class saveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if(elementOfDatabase instanceof Product)
			{
				Product orginProduct = (Product) elementOfDatabase;
				connectionClient.updateProduct(
						new Product(orginProduct.getProductId(),
								elementJLabelList.get(1).getText(), Double.parseDouble(elementJLabelList.get(2).getText()), Double.parseDouble(elementJLabelList.get(3).getText())), 
						orginProduct.getProductId());
				
			}
			dispose();
		} 
	}
	
	public class cancelButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();
		} 
	}
	
	public class addButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		} 
	}
	
	public class removeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		} 
	}
	
	public class recipeButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		} 
	}
	
	
	private double componentsSummaryValue() {
		return 0;
	}
	

}
