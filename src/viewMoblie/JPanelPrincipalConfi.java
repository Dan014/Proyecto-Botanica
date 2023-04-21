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



public class JPanelPrincipalConfi extends JPanel {
	private JPanelSouth2 jPanelSouth;
	private JPanelCenterConfi jPanelCenter;
	private JPanelNorth jPanelNorth;


	ImageIcon imageIcon;
	Icon icon;

	public JPanelPrincipalConfi(Control control) {
		this.jPanelSouth = new JPanelSouth2(control);
		this.jPanelCenter = new JPanelCenterConfi(control);
//		jPanelCenter.setBackground(Color.green);
		this.jPanelNorth = new JPanelNorth();



		init();
	}


	private void init() {

		this.setLayout(new BorderLayout());
		this.add(jPanelNorth, BorderLayout.NORTH);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(getClass().getResource("/images/mobile.png"));
		g.drawImage(imageIcon.getImage(), -170, 0, 710, 690, this);
		setOpaque(false);
		super.paintComponent(g);
	}
        


}
