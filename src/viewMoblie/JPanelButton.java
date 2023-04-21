package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Commands;
import controller.Control;


public class JPanelButton extends JPanel {
	
	private JButton jButton, jButton2, jButton3;
	private JPanel jPanelWest, jPanelEast, jPanelCenter;
	ImageIcon imageIcon;
	Icon icon;


	public JPanelButton(Control control) {
		
		jButton = new JButton();
		jButton.setActionCommand(Commands.SHOWMULTI.name());
		jButton.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/boton1.PNG"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(130, 100, Image.SCALE_AREA_AVERAGING));
		jButton.setIcon(icon);

		jButton2 = new JButton();
		jButton2.setActionCommand(Commands.CLOSE_MOBILE.name());
		jButton2.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/boton2.PNG"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(130, 50, Image.SCALE_AREA_AVERAGING));
		jButton2.setIcon(icon);
		
		jButton3 = new JButton();
		jButton3.setActionCommand(Commands.SHOW_HOMEMOBILE.name());
		jButton3.addActionListener(control);
		imageIcon = new ImageIcon(getClass().getResource("/images/boton3.PNG"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(130, 50, Image.SCALE_AREA_AVERAGING));
		jButton3.setIcon(icon);
		init();
	}

	private void init() {

		this.setLayout(new GridLayout(1, 3));
		this.setBackground(new Color(30, 100, 100,90));
		this.setPreferredSize(new Dimension(0, 50));
	
		
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);

		

	}
}
