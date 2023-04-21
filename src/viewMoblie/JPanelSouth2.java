package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

import controller.Control;

public class JPanelSouth2 extends JPanel {
	private JPanel jPanelWest, jPanelEast, jPanelCenter;
	private JPanelButton jPanelButton;

	public JPanelSouth2(Control control) {
		
		jPanelButton = new JPanelButton(control);
		jPanelCenter = new JPanel();
//		jPanelCenter.setBackground(Color.BLACK);
		this.setOpaque(false);
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(30, 0));
		jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(21, 0));

		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelButton, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.setBackground(new Color(222, 222, 222,90));
		this.setPreferredSize(new Dimension(0, 50));

	}
}
