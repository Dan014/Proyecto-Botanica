package view;

import controller.Commands;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import models.HistoricalContribution;
import models.Botanic;
import models.ConstantsBotanic;

public class JPanelPrototipoCard extends JButton {

	private ImageIcon imageIcon;
	private Icon icon;

	private JLabel InfoName1, infoMane2, infoDate1, infodate2, infoInstitu1, infoInstitu2, infoPlanta1, infoPLanta2;

	public JPanelPrototipoCard(String isntitucion, HistoricalContribution aporte, Botanic botanico, String nameEspecie,
			ActionListener action) {

		setLayout(new GridLayout(4, 2));
		setName(String.valueOf(aporte.getIdEspecie()));
		this.setBackground(new Color(48, 48, 48));
		addActionListener(action);
		setActionCommand(Commands.SHOW_TABLEPLANT.toString());
		// setPreferredSize(new Dimension(800, 200));

		InfoName1 = new JLabel("Nombre:  ");
		InfoName1.setBackground(new Color(59, 232, 183));
		InfoName1.setBorder(ConstantsBotanic.RIGTH_BORDER);
		InfoName1.setFont(new Font("Arial", 1, 30));
		InfoName1.setForeground(Color.WHITE);
		add(InfoName1);

		infoMane2 = new JLabel(botanico.getNameBotanico());
		infoMane2.setBackground(new Color(59, 232, 183));
		infoMane2.setForeground(Color.WHITE);
		infoMane2.setFont(new Font("Arial", 1, 30));
		add(infoMane2);

		infoDate1 = new JLabel("Fecha: ");
		infoDate1.setBackground(new Color(59, 232, 183));
		infoDate1.setBorder(ConstantsBotanic.RIGTH_BORDER);
		infoDate1.setFont(new Font("Arial", 1, 30));
		infoDate1.setForeground(Color.WHITE);
		add(infoDate1);

		infodate2 = new JLabel(ConstantsBotanic.formateDate(aporte.getDateAporte()));
		infodate2.setBackground(new Color(59, 232, 183));
		infodate2.setForeground(Color.WHITE);
		infodate2.setFont(new Font("Arial", 1, 30));
		add(infodate2);

		infoInstitu1 = new JLabel("Institucion: ");
		infoInstitu1.setBackground(new Color(59, 232, 183));
		infoInstitu1.setBorder(ConstantsBotanic.RIGTH_BORDER);
		infoInstitu1.setFont(new Font("Arial", 1, 30));
		infoInstitu1.setForeground(Color.WHITE);
		add(infoInstitu1);

		infoInstitu2 = new JLabel(isntitucion);
		infoInstitu2.setBackground(new Color(59, 232, 183));
		infoInstitu2.setFont(new Font("Arial", 1, 30));
		infoInstitu2.setForeground(Color.WHITE);
		add(infoInstitu2);

		infoPlanta1 = new JLabel("MI Especie:  ");
		infoPlanta1.setBorder(ConstantsBotanic.RIGTH_BORDER);
		infoPlanta1.setBackground(new Color(59, 232, 183));
		infoPlanta1.setFont(new Font("Arial", 1, 30));
		infoPlanta1.setForeground(Color.WHITE);
		add(infoPlanta1);

		infoPLanta2 = new JLabel(nameEspecie);
		infoPLanta2.setBackground(new Color(59, 232, 183));
		infoPLanta2.setFont(new Font("Arial", 1, 30));
		infoPLanta2.setForeground(Color.WHITE);
		add(infoPLanta2);

	}

}
