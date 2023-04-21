package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelCenterImagePrincipal extends JPanel {
	
	JPanel jPanelImage, jPanelinfo;
	JLabel jLabel;

	ImageIcon imageIcon;
	Icon icon;



	public JPanelCenterImagePrincipal() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		jPanelImage = new JPanel();
		jPanelImage.setPreferredSize(new Dimension(this.getWidth(), 200));
		jLabel = new JLabel();
		imageIcon = new ImageIcon(getClass().getResource("/images/imagePrincipal.jpg"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(this.getWidth(), 500, Image.SCALE_AREA_AVERAGING));
		jLabel.setIcon(icon);
		jPanelImage.add(jLabel);
		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 100));
		this.add(jPanelImage);
		

	}
}
