package viewMoblie;

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

public class JPanelPrincipalMultitarea extends JPanel {
	private JPanelSouth2 jPanelSouth;
	// private JPanelCenterFilter jPanelCenter;
	JPanel jPanel, jPanelEast, jPanelWest;
	private JPanelNorth jPanelNorth;

	ImageIcon imageIcon;
	Icon icon;

	public JPanelPrincipalMultitarea(Control control) {
		this.setOpaque(false);
		this.jPanelSouth = new JPanelSouth2(control);

		jPanel = new JPanel();
		jPanelEast = new JPanel();
		jPanelWest = new JPanel();

		jPanel.setBackground(Color.LIGHT_GRAY);
		this.jPanelNorth = new JPanelNorth();
		jPanelNorth.setOpaque(false);

		init();
	}

	private void init() {
		jPanelEast.setPreferredSize(new Dimension(30, 0));
		jPanelWest.setPreferredSize(new Dimension(21, 0));
		this.setLayout(new BorderLayout());
		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanel, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelWest, BorderLayout.WEST);

	}

	// @Override
	// protected void paintComponent(Graphics g) {
	// imageIcon = new
	// ImageIcon(getClass().getResource("/images/fondofiltermobile.jpg"));
	// g.drawImage(imageIcon.getImage(), -170, 0, 700, 690, this);
	// setOpaque(false);
	// super.paintComponent(g);
	// }
	//

}
