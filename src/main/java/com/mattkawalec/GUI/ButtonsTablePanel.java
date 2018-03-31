package com.mattkawalec.GUI;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.mattkawalec.T;
import com.mattkawalec.GUI.MainFrame;
import com.mattkawalec.connection.ConnectionClient;
import com.mattkawalec.domain.Product;

public class ButtonsTablePanel extends JPanel {
	JButton addObjectButton;
	JButton deleteObjectButton;

	public ButtonsTablePanel() {
		super();
		
		ImageIcon addIcon = new ImageIcon("src/main/resources/add_icon.png");
		ImageIcon deleteIcon = new ImageIcon("src/main/resources/delete_icon.png");
		//addObjectButton = new JButton("przycisk");
		addObjectButton = new JButton("Dodaj", addIcon);
		deleteObjectButton = new JButton("Usuñ", deleteIcon);
		
		addObjectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}	
		}
		);
		
		deleteObjectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}	
		}
		
		
		
		);
		
		add(addObjectButton);
		add(deleteObjectButton);
		
	}
	

}
