package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelNorthTitle extends JPanel {
	private JPanel jPanelWest, jPanelEast, jPanelCenter, jPanelNorth;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelNorthTitle(int ancho, Color color) {
		jPanelCenter = new JPanel();
		jPanelCenter.setBackground(color);
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(30, 0));
		jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(21, 0));
		init(ancho);
	}

	private void init(int ancho ) {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());		
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.setPreferredSize(new Dimension(0, ancho));

	}
}
