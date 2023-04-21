package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JPanelImagePlant extends JPanel {

	private JPanel jPanelWest, jPanelCenter, jPanelNorth;
	private JLabel jLabel;

	ImageIcon imageIcon;
	Icon icon;

	public JPanelImagePlant() {
		this.setOpaque(false);
		this.jPanelCenter = new JPanel();
		this.jPanelCenter = new JPanel();
		jPanelCenter.setPreferredSize(new Dimension(100, 100));
		jPanelCenter.setOpaque(false);
		this.jPanelNorth = new JPanel();
		jPanelNorth.setPreferredSize(new Dimension(100, 100));
		jPanelNorth.setBackground(new Color(248, 248, 248));
		jPanelNorth.setOpaque(false);



		init();
	}


	private void init() {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(700, 100));

		
		jLabel = new JLabel();
		jLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
		imageIcon = new ImageIcon(getClass().getResource("/images/plant1.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(600, 500, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelCenter.add(jLabel);
		
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelNorth, BorderLayout.NORTH);

	}



}
