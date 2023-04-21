package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

public class JPanelSouthPlant extends JPanel {

	public JPanelSouthPlant() {

		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(248, 248,248));
		this.setPreferredSize(new Dimension(0, 100));

	}
}
