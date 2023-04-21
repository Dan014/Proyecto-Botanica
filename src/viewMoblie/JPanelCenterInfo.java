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

import controller.Control;
import view.JPanelPrincipalPlant;
import view.JPanleFilterTable;

public class JPanelCenterInfo extends JPanel {
	private JPanel jPanelWest, jPanelEast, jPanelCenter, jPanelNorth, jPanel;
	private JPanelNorthTitle jPanelNorthTitle;
	private JLabel jLabel2;
	ImageIcon imageIcon;
	Icon icon;


	public JPanelCenterInfo(Control control) {
		jPanelNorthTitle = new JPanelNorthTitle(40, Color.WHITE);
		jPanelCenter = new JPanel();
		jPanel = new JPanel();
		jPanel.setBackground(Color.BLUE);
		
		
		jPanelNorth = new JPanel();
		jPanelNorth.setPreferredSize(new Dimension(30, 100));
		jPanelNorth.setBackground(Color.WHITE);
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(30, 0));
		jPanelWest = new JPanel();
		jPanelWest.setPreferredSize(new Dimension(21, 0));
		
		
		jLabel2 = new JLabel();
		imageIcon = new ImageIcon(getClass().getResource("/images/info.jpeg"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(390, 700, Image.SCALE_AREA_AVERAGING));
		jLabel2.setIcon(icon);
		jPanelCenter.add(jLabel2);

		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelNorthTitle, BorderLayout.NORTH);
		this.add(jPanelWest, BorderLayout.WEST);
		this.setBackground(new Color(222, 222, 222,90));
		this.setPreferredSize(new Dimension(0, 50));

	}
}
