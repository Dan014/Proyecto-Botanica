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


public class JPanelCenterPlant extends JPanel {

	private JPanel jPanelWest, jPanelCenter;
	private JPanelImagePlant jPanelImagePlant;
	private JPanelInfoPlant  jPanelInfoPlant;

	ImageIcon imageIcon;
	Icon icon;

	public JPanelCenterPlant() {
		this.setOpaque(false);
		this.jPanelCenter = new JPanel();
		this.jPanelImagePlant = new JPanelImagePlant();
		this.jPanelInfoPlant = new JPanelInfoPlant();
		this.jPanelCenter = new JPanel();
		jPanelCenter.setPreferredSize(new Dimension(100, 100));
//		jPanelCenter.setBackground(Color.YELLOW);
		this.jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(700, 100));


		init();
	}


	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.add(jPanelInfoPlant, BorderLayout.CENTER);
		this.add(jPanelImagePlant, BorderLayout.WEST);
	}

	 public JPanelInfoPlant getjPanelInfoPlant() {
	        return jPanelInfoPlant;
	    }

}
