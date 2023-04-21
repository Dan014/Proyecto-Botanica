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


public class JPanelPrincipalTableInstitution extends JPanel {
	private JPanelCenterTableInstitution jPanelCenter;
	private JPanelSouth jPanelSouth;


	ImageIcon imageIcon;
	Icon icon;

	public JPanelPrincipalTableInstitution(Control control) {
		this.jPanelCenter = new JPanelCenterTableInstitution(control);
		this.jPanelSouth = new JPanelSouth();
		init();
	}


	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setBackground(Color.RED);

		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);
	}

	  public JPanelCenterTableInstitution getjPanelCenter() {
	        return jPanelCenter;
	    }
	  @Override
		protected void paintComponent(Graphics g) {
			imageIcon = new ImageIcon(getClass().getResource("/images/fondoTable.jpg"));
			g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
			super.paintComponent(g);
		}
}
