package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class JPanelInfoPlant extends JPanel {

	private JPanel jPanelWest, jPanelCenter, jPanelEast, jPanelNorth, jPanelSouth;
	private JPanelInfoPlantTxx  jPanelInfoPlantTxx;

	ImageIcon imageIcon;
	Icon icon;

	public JPanelInfoPlant() {
		this.setOpaque(false);
		this.jPanelInfoPlantTxx = new JPanelInfoPlantTxx();
		this.jPanelWest = new JPanel();
		jPanelWest.setBackground(new Color(248, 248, 248));
		jPanelWest.setPreferredSize(new Dimension(20, 100));
		this.jPanelEast = new JPanel();
		jPanelEast.setBackground(new Color(248, 248, 248));
		jPanelEast.setPreferredSize(new Dimension(20,100));
		this.jPanelNorth = new JPanel();
		jPanelNorth.setBackground(new Color(248, 248, 248));
		jPanelNorth.setPreferredSize(new Dimension(10,100));
		this.jPanelSouth = new JPanel();
		jPanelNorth.setOpaque(false);
		jPanelSouth.setOpaque(false);
		jPanelEast.setOpaque(false);
		jPanelWest.setOpaque(false);




		jPanelSouth.setBackground(new Color(248, 248, 248));
		jPanelSouth.setPreferredSize(new Dimension(100,20));


		init();
	}
	 public JPanelInfoPlantTxx getjPanelInfoPlantTxx() {
	        return jPanelInfoPlantTxx;
	    }
	        

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelInfoPlantTxx, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelSouth, BorderLayout.SOUTH);
;

	}



}
