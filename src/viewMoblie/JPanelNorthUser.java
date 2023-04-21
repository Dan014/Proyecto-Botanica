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

public class JPanelNorthUser extends JPanel {
	private JPanel jPanelWest, jPanelEast, jPanelCenter, jPanelNorth;
	private JLabel jLabel, jLabel2;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelNorthUser(int ancho, Color color) {
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
		
		jLabel2 = new JLabel();
		jLabel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		imageIcon = new ImageIcon(getClass().getResource("/images/usuario.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_AREA_AVERAGING));
		jLabel2.setIcon(icon);
		jPanelCenter.add(jLabel2);
		
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelCenter, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.setPreferredSize(new Dimension(0, ancho));

	}
}
