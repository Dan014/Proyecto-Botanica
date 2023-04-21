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


public class JPanelCenterPlantContent extends JPanel {

	private JPanel jPanelWest, jPanelEast, jPanelCenter;
	private JPanelCenterPlant jPanelCenterPlant;

	ImageIcon imageIcon;
	Icon icon;

	public JPanelCenterPlantContent() {
		this.setOpaque(false);

		this.jPanelCenter = new JPanel();
		this.jPanelCenterPlant = new JPanelCenterPlant();
		this.jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(100, 100));
		jPanelEast.setBackground(new Color(248, 248, 248));
		this.jPanelWest = new JPanel();
		jPanelWest.setBackground(new Color(248, 248, 248));
		jPanelWest.setPreferredSize(new Dimension(100, 100));
		jPanelWest.setOpaque(false);
		jPanelEast.setOpaque(false);



		init();
	}
	 public JPanelCenterPlant getjPanelCenterPlant() {
	        return jPanelCenterPlant;
	    }

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.add(jPanelCenterPlant, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
	}



}
