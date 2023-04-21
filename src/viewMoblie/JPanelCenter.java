package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

import controller.Control;

public class JPanelCenter extends JPanel {
	private JPanel jPanelWest, jPanelEast, jPanelCenter, jPanelNorth;
	private JPanelHome jPanelHome;
	private JPanelNorthTitle jPanelNorthTitle;

	public JPanelCenter(Control control) {
		jPanelNorthTitle = new JPanelNorthTitle(40, Color.WHITE);
		jPanelCenter = new JPanel();
		jPanelCenter.setBackground(Color.BLUE);
		jPanelNorth = new JPanel();
		jPanelNorth.setPreferredSize(new Dimension(30, 100));
		jPanelNorth.setBackground(Color.WHITE);
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(30, 0));
		jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(21, 0));
		jPanelHome = new JPanelHome(control);

		init();
	}

	
	public JPanelHome getJPanelHome() {
		return jPanelHome;
		
	}
	private void init() {

		this.setLayout(new BorderLayout());
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelHome, BorderLayout.CENTER);
		this.add(jPanelNorthTitle, BorderLayout.NORTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.setBackground(new Color(222, 222, 222,90));
		this.setPreferredSize(new Dimension(0, 50));

	}
}
