package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class JPanelCenterContent extends JPanel {

	private JPanelContentCard jaCenterContentCircle;
	private JPanel jPanelWhitheNorth, jPanelEast, jPanelWest, jPanelSouth;

	public JPanelCenterContent() {
		this.setOpaque(false);
		jaCenterContentCircle = new JPanelContentCard();
		jPanelWhitheNorth = new JPanel();
		jPanelWhitheNorth.setOpaque(false);
		jPanelWhitheNorth.setBackground(new Color(238, 238, 238));
		jPanelWhitheNorth.setPreferredSize(new Dimension(0, 20));
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(50, 0));
		jPanelEast.setOpaque(false);
		jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(50, 0));
		jPanelWest.setOpaque(false);
		jPanelSouth = new JPanel();
		jPanelSouth.setPreferredSize(new Dimension(50, 0));

		jPanelSouth.setOpaque(false);
		jPanelSouth.setPreferredSize(new Dimension(0, 50));
		jPanelSouth.setBackground(new Color(238, 238, 238));

		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(0, 600));
		this.add(jaCenterContentCircle, BorderLayout.CENTER);
		this.add(jPanelWhitheNorth, BorderLayout.NORTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelSouth, BorderLayout.SOUTH);

	}
}
