package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

import controller.Control;
import view.JPanleFilterCreatePlant;

public class JPanelCenterAddPlant extends JPanel {
	private JPanel jPanelWest, jPanelEast, jPanelCenter, jPanelNorth;
	private JPanleFilterCreatePlantMobile jPanleFilterMobile;
	private JPanelNorthTitle jPanelNorthTitle;

	public JPanelCenterAddPlant(Control control) {
		jPanelNorthTitle = new JPanelNorthTitle(20, Color.WHITE);
		jPanelCenter = new JPanel();
		jPanelCenter.setBackground(Color.BLUE);
		jPanelNorth = new JPanel();
		jPanelNorth.setPreferredSize(new Dimension(30, 100));
		jPanelNorth.setBackground(Color.WHITE);
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(30, 0));
		jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(21, 0));
		jPanleFilterMobile = new JPanleFilterCreatePlantMobile(control);

		init();
	}
	public JPanleFilterCreatePlantMobile getJPanleFilterCreatePlantMobile() {
		return jPanleFilterMobile;
		
	}
	private void init() {

		this.setLayout(new BorderLayout());
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanleFilterMobile, BorderLayout.CENTER);
		this.add(jPanelNorthTitle, BorderLayout.NORTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.setBackground(new Color(222, 222, 222,90));
		this.setPreferredSize(new Dimension(0, 50));

	}
}
