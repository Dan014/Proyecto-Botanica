package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

public class JPanelNorth extends JPanel {

	public JPanelNorth() {

		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 70));

	}
}
