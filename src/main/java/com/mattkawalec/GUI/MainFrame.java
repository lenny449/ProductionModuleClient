package com.mattkawalec.GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.MenuItem;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import com.mattkawalec.connection.ConnectionClient;
import com.mattkawalec.domain.Product;

public class MainFrame extends JFrame {
	
	
	ButtonsPanel buttonsPanel;
	Container c;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem menuItem;
	JPanel productListPanel;
	JPanel productButtonsPanel;
	JPanel recipeButtonsPanel;
	Object[] tempRow;
	TablePanel tablePanel;


	public MainFrame() {
		c = getContentPane();
		setLayout(new BorderLayout());

		/*
		 * menuItem = new JMenuItem("A text-only menu item"); menu.add(menuItem); menu =
		 * new JMenu("File"); menuBar.add(menu); menuBar = new JMenuBar();
		 */

		tablePanel = new TablePanel(this);
		buttonsPanel = new ButtonsPanel(tablePanel);
		c.add(buttonsPanel, BorderLayout.NORTH);
		c.add(tablePanel, BorderLayout.CENTER);

		setTitle("Production Module Client");
		setSize(600, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}



	// Set Layout Manager

	// Create Swing Components

	// Add Swing components to

}
