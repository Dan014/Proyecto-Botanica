package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Commands;
import controller.Control;

public class JPanelConfi extends JPanel {
	private JButton jButton, jButton2, jButton3,jButton4,jButton5,jButton6;
	ImageIcon imageIcon;
	Icon icon;
	private JScrollPane jScrollPane;

	public JPanelConfi(Control control) {
//		this.setOpaque(false);
		jButton = new JButton("PREGUNTAS FRECUENTES");
		jButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 70));

		jButton.setBackground(new Color(0, 166, 226));
//		jButton.setActionCommand(Commands.SHOW_ADDPLANT.name());
		imageIcon = new ImageIcon(getClass().getResource("/images/apoyar.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
		jButton.setIcon(icon);
//		jButton.addActionListener(control);

		
		
		
		jButton2 = new JButton("CONTACTANOS");
		jButton2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 130));
		imageIcon = new ImageIcon(getClass().getResource("/images/contac.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
		jButton2.setIcon(icon);
		jButton2.setBackground(new Color(124, 193, 0));
//		jButton2.setActionCommand(Commands.SHOW_INFOPLANT_MONILE.name());
//		jButton2.addActionListener(control);

		
		jButton3 = new JButton("CONDICIONES Y PRIVACIDAD");
		jButton3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
		imageIcon = new ImageIcon(getClass().getResource("/images/lista.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
		jButton3.setIcon(icon);
		jButton3.setBackground(new Color(227, 207, 0));
//		jButton3.setActionCommand(Commands.SHOW_USER_MOBILE.name());
//		jButton3.addActionListener(control);
		
		jButton4 = new JButton("INFO");
		jButton4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 190));
		imageIcon = new ImageIcon(getClass().getResource("/images/informacion.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
		jButton4.setIcon(icon);
		jButton4.setBackground(new Color(167, 97, 176));
		jButton4.setActionCommand(Commands.SHOW_INFO_MOBILE.name());
		jButton4.addActionListener(control);

		init();
	}

	private void init() {

		this.setLayout(new GridLayout(4, 1));
		this.setOpaque(false);
		this.add(jButton);
		this.add(jButton2);
		this.add(jButton3);
		this.add(jButton4);
		

	}
}
