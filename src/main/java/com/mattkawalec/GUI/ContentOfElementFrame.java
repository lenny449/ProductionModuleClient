package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mattkawalec.T;
import com.mattkawalec.domain.Document;
import com.mattkawalec.domain.ElementOfDatabase;
import com.mattkawalec.domain.Product;
import com.mattkawalec.domain.Recipe;

public class ContentOfElementFrame extends JFrame {
	JPanel gridPanel;
	JPanel tablePanel;
	String[] localNames;
	List<Object> elementList;
	
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
		
		T.t(elementOfDatabase.getLocalNames());
		
		//setLayout(new GridLayout(0, ));

		
		setLayout(new BorderLayout());
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(elementList.size(),2));
		fillGridPanel();
		tablePanel = new JPanel();
		add(gridPanel, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	private void fillGridPanel()
	{
		for(int i = 0; i<elementList.size(); i++ )
		{
			System.out.println(localNames[i]);
			System.out.println(localNames[i]);
		}
		
	}
}
