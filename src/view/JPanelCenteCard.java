package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JScrollPane;

public class JPanelCenteCard extends JPanel {

	private JPanel jPanelCentroContenedor, jPanelDerechoContenedor;
	private JPanelBorderContentCard jPanelBorderContenedor;
//	private JPanelCenterContentCard jPanelCenterContentCard;
	private JLabel jLabel;
	private JScrollPane jScrollPane;


	private ImageIcon imageIcon;
	private Icon icon;
 
	public JPanelCenteCard() {
		this.setOpaque(false);
		jPanelBorderContenedor = new JPanelBorderContentCard();
		jPanelCentroContenedor = new JPanel();
		jPanelDerechoContenedor = new JPanel();
		this.jScrollPane = new JScrollPane();
		jScrollPane.setOpaque(false);

		




		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 300));
		
		jPanelCentroContenedor.setBackground(Color.blue);
		jPanelCentroContenedor.setOpaque(false);

		jPanelCentroContenedor.setPreferredSize(new Dimension(100, 1000));


		
		jPanelDerechoContenedor.setBackground(Color.LIGHT_GRAY);
		jPanelDerechoContenedor.setPreferredSize(new Dimension(300, 100));
		jPanelDerechoContenedor.setOpaque(false);

		jScrollPane.setViewportView(jPanelBorderContenedor);
		this.add(jScrollPane, BorderLayout.CENTER);		
		this.add(jPanelDerechoContenedor, BorderLayout.WEST);

	
	

	}
	
	public JPanelBorderContentCard getjPanelBorderContenedor() {
        return jPanelBorderContenedor;
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
