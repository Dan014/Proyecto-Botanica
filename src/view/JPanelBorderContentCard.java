package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class JPanelBorderContentCard extends JPanel {

	private JPanel jPanelWest, jPanelEast;
	private JPanelCenterContentCard jPanelCenterContentCard;
	private JScrollPane jScrollPane;
	private ImageIcon imageIcon;
	private Icon icon;
 
	public JPanelBorderContentCard() {
		this.setOpaque(false);
		this.jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);
		jPanelCenterContentCard = new JPanelCenterContentCard();
		jPanelCenterContentCard.setOpaque(false);
		jPanelEast = new JPanel();
		jPanelWest = new JPanel();
		
		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 300));
		
		jPanelEast.setOpaque(false);
		jPanelEast.setPreferredSize(new Dimension(100, 1000));

		
		jPanelWest.setOpaque(false);
		jPanelWest.setPreferredSize(new Dimension(100, 100));
		jScrollPane.setViewportView(jPanelCenterContentCard);
		
		this.add(jScrollPane, BorderLayout.CENTER);		
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
	
	

	}

	  public JPanelCenterContentCard getjPanelCenterContentCard() {
	        return jPanelCenterContentCard;
	    }
	        

}
