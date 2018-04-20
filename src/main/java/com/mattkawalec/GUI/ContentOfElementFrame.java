package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mattkawalec.T;
import com.mattkawalec.domain.Document;
import com.mattkawalec.domain.ElementOfDatabase;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.ProductQuantityPair;
import com.mattkawalec.domain.Recipe;

public class ContentOfElementFrame extends JFrame {
	JPanel gridPanel;
	JPanel tablePanel;
	JPanel summaryPanel;
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
	
	public ContentOfElementFrame(ElementOfDatabase elementOfDatabase) {
		super();
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
		
		T.t(elementOfDatabase.getLocalNames());
		
		//Panel górny
		GridLayout gridLayout = new GridLayout(elementList.size(),2);
		gridLayout.setHgap(10);
		gridLayout.setVgap(10);
		setLayout(new BorderLayout());
		gridPanel = new JPanel();
		gridPanel.setBorder(BorderFactory.createTitledBorder("Sterowanie"));
		gridPanel.setLayout(gridLayout);
		fillGridPanel();
		
		//Panel œrodkowy
		tablePanel = new JPanel();
		
		//Dodanie paneli do ramki
		add(gridPanel, BorderLayout.NORTH);
		
		//Nazwa ramki i wyœwietlenie
		setTitle(elementList.get(0).toString());
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
/*	public void fillTablePanel(List<ProductQuantityPair> productQuantityPairList) {
		removeAll();
		String[] columnNames =  {"Produkt", "Iloœæ", "Cena", "Wartoœæ"};
		dTableModel = new DefaultTableModel(tableDatabase, columnNames);
		table = new JTable(dTableModel);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);
		addProductRows(productsList);
		scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		mainFrame.setVisible(true);

	}*/
}
