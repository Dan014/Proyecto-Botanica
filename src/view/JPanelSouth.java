package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

public class JPanelSouth extends JPanel {

	public JPanelSouth() {

		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setBackground(new Color(48, 48, 48));
		this.setPreferredSize(new Dimension(0, 100));

	}
}
