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

import controller.Control;

public class JPanelPrincipalEstadistic extends JPanel {
	private JPanelCenterEstadistic jPanelCenter;
	private JPanelSouth jPanelSouth;


	ImageIcon imageIcon;
	Icon icon;

	public JPanelPrincipalEstadistic(Control control) {
		this.jPanelCenter = new JPanelCenterEstadistic(control);
		this.jPanelSouth = new JPanelSouth();
		this.setVisible(true);
		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setBackground(Color.RED);
		this.add(jPanelCenter, BorderLayout.CENTER);
		 this.add(jPanelSouth, BorderLayout.SOUTH);
	}
	
	 public JPanelCenterEstadistic getjPanelCenter() {
	        return jPanelCenter;
	    }

}
