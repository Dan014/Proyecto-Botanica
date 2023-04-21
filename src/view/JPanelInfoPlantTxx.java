package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import models.Specie;

public class JPanelInfoPlantTxx extends JPanel {

	JLabel jLabel, jLabel2;
	JPanel jPanel;
	ImageIcon imageIcon;
	Icon icon;
	private String paises = "";
	private Specie especie = null;

	public void setEspecie(Specie especie) {
		removeAll();
		paises = "";
		this.especie = especie;

		for (String object : especie.getContriesList()) {
			Locale l = new Locale("EN", object);
			paises += l.getDisplayCountry() + ", ";
		}

		this.setOpaque(false);
		this.add(createJTextField("Nombre: " + especie.getNombreCientifico(), new Color(0, 0, 0, 94), 100, 100));
		this.add(createJTextField("Familia: " + especie.getFamiliaEspaecie(), new Color(0, 0, 0, 94), 100, 100));
		this.add(createJTextField("Paises: " + paises, new Color(0, 0, 0, 84), 100, 100));

		this.repaint();
		this.revalidate();

	}

	public JPanelInfoPlantTxx() {
		this.setLayout(new GridLayout(6, 1));
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setBackground(Color.green);
		jLabel.setPreferredSize(new Dimension(0, 20));
		this.add(jLabel);
		return jLabel;

	}

	public JPanel createJTextField(String name, Color color, int largo, int ancho) {
		jLabel = new JLabel(name);
		jLabel.setForeground(Color.WHITE);
		jLabel.setFont(new Font("Arial", 1, 20));
		jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout());
		jPanel.setBackground(color);
		jPanel.add(jLabel);
		return jPanel;

	}

}
