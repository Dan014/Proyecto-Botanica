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


public class JPanelPrincipalCard extends JPanel {
	private JPanelCenteCard jPanelCenter;
	private JPanelSouth jPanelSouth;


	ImageIcon imageIcon;
	Icon icon;

	public JPanelPrincipalCard() {
		this.jPanelCenter = new JPanelCenteCard();
		this.jPanelSouth = new JPanelSouth();
//		this.jPanelCenter = new JPanelPrincipalCentro();
//		this.jPanelPrincipalNorte = new JPanelPrincipalNorte(control);

		init();
	}


	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setBackground(Color.RED);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelSouth, BorderLayout.SOUTH);
	}

	 public JPanelCenteCard getjPanelCenter() {
	        return jPanelCenter;
	    }
	
	@Override
	protected void paintComponent(Graphics g) {
		imageIcon = new ImageIcon(getClass().getResource("/images/fondoPrincipal2.jpg"));
		g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
	}
        

}
