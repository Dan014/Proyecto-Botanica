package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelPrototipo extends JPanel {

	private JPanel jPanelCentroContenedor, jPanelDerechoContenedor, jPanelPrecios, jPanelTitle;
	private JLabel jLabel, jLabel2;

	private ImageIcon imageIcon;
	private Icon icon;
 
	public JPanelPrototipo(String text, String url) {

		jPanelCentroContenedor = new JPanel();
		jPanelDerechoContenedor = new JPanel();
		jPanelPrecios = new JPanel();
		jPanelTitle = new JPanel();

		init(text, url);
	}

	private void init(String text, String url) {

		this.setLayout(new BorderLayout());
		this.setBackground(Color.GREEN);
		this.setPreferredSize(new Dimension(100, 100));

		jPanelCentroContenedor.setBackground(new Color(238, 238, 238));
		jPanelCentroContenedor.setPreferredSize(new Dimension(300, 300));
		jPanelCentroContenedor.add(jlabelImage(url, 200, 200, 0));

		jPanelDerechoContenedor.setLayout(new BorderLayout());
		jPanelDerechoContenedor.setPreferredSize(new Dimension(100, 100));

		jPanelTitle.setBackground(new Color(78, 255, 155));
		jPanelTitle.setPreferredSize(new Dimension(100, 100));
		jPanelDerechoContenedor.add(jPanelTitle);

		jLabel2 = new JLabel(text);
		jLabel2.setForeground(Color.WHITE);
		jLabel2.setFont(new Font("Arial", 1, 30));
		jLabel2.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		jPanelTitle.add(jLabel2);

		this.add(jPanelCentroContenedor, BorderLayout.NORTH);
		this.add(jPanelDerechoContenedor, BorderLayout.CENTER);

	}

	public JLabel jlabelImage(String url, int x, int y, int optional) {
		jLabel = new JLabel();
		jLabel.setBorder(BorderFactory.createEmptyBorder(25, optional, 0, 0));
		imageIcon = new ImageIcon(getClass().getResource(url));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(x, y, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		this.add(jLabel);
		return jLabel;

	}

}
