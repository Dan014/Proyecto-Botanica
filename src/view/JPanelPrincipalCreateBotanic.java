package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

import controller.Control;
import general.HandlerLanguage;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

import models.ConstantsBotanic;
import models.Institution;
import models.SuitableCyty;
import models.KindBotanic;

public class JPanelPrincipalCreateBotanic extends JPanel {
	ImageIcon imageIcon;
	Icon icon;
	JButton jButton;
	JLabel jLabel, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, foto;
	JTextField name, correo, password;
	JComboBox<KindBotanic> jCBCostsCategory;
	JComboBox<String> jCBInstitu;

	public JPanelPrincipalCreateBotanic(Control control) {

		init(control);
	}

	public void init(Control control) {

		this.setLayout(null);
		this.setBackground(Color.white);

		jLabel = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.NAME_BOTANIC));
		jLabel.setBounds(20, 10, 300, 25);
		jLabel.setFont(new Font("Andale Mono", 3, 15));
		jLabel.setForeground(new Color(23, 4, 255));
		jLabel.setBackground(Color.BLUE);
		add(jLabel);

		name = new JTextField("");
		name.setBounds(20, 40, 320, 25);
		name.setBackground(new java.awt.Color(224, 224, 224));
		name.setFont(new java.awt.Font("Andale Mono", 1, 14));
		name.setForeground(new java.awt.Color(255, 0, 0));
		add(name);

		jLabel2 = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.EMAIL));
		jLabel2.setBounds(20, 85, 200, 25);
		jLabel2.setFont(new Font("Andale Mono", 3, 15));
		jLabel2.setForeground(new Color(23, 4, 255));
		jLabel2.setBackground(Color.BLUE);
		add(jLabel2);

		correo = new JTextField();
		correo.setBounds(20, 115, 320, 25);
		correo.setBackground(new java.awt.Color(224, 224, 224));
		correo.setFont(new java.awt.Font("Andale Mono", 1, 14));
		correo.setForeground(new java.awt.Color(255, 0, 0));
		add(correo);

		jLabel3 = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.PASSWORD));
		jLabel3.setBounds(20, 150, 200, 25);
		jLabel3.setFont(new Font("Andale Mono", 3, 15));
		jLabel3.setForeground(new Color(23, 4, 255));
		jLabel3.setBackground(Color.BLUE);
		add(jLabel3);

		password = new JTextField();
		password.setBounds(20, 175, 320, 25);
		password.setBackground(new java.awt.Color(224, 224, 224));
		password.setFont(new java.awt.Font("Andale Mono", 1, 14));
		password.setForeground(new java.awt.Color(255, 0, 0));
		add(password);

		jCBCostsCategory = new JComboBox<KindBotanic>();
		jCBCostsCategory.setBounds(20, 205, 320, 50);
		jCBCostsCategory.setBackground(new java.awt.Color(224, 224, 224));
		jCBCostsCategory.setBorder(BorderFactory.createTitledBorder(
				HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.KIND_BOTANIC)));
		jCBCostsCategory.setModel(new DefaultComboBoxModel(KindBotanic.values()));
		jCBCostsCategory.setBackground(Color.WHITE);
		add(jCBCostsCategory);

		jCBInstitu = new JComboBox<>();
		jCBInstitu.setBounds(20, 265, 320, 55);
		jCBInstitu.setBackground(new java.awt.Color(224, 224, 224));
		jCBInstitu.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.INSTITUTION)));
		jCBInstitu.setBackground(Color.white);
		add(jCBInstitu);

		// createEspacio();

		jButton = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.CREATE));
		jButton.setBounds(250, 340, 200, 25);
		jButton.setFont(new Font("Andale Mono", 3, 15));
		jButton.setForeground(new Color(23, 4, 255));
		jButton.setActionCommand(controller.Commands.SAVE_BOTANIC.name());
		jButton.addActionListener(control);
		add(jButton);

		foto = new JLabel();
		imageIcon = new ImageIcon(getClass().getResource("/images/usuario.png"));
		foto.setBounds(500, 30, 250, 250);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING));
		foto.setIcon(icon);

		this.add(foto);
	}

	public KindBotanic getjCBCostsCategory() {
		return jCBCostsCategory.getPrototypeDisplayValue();
	}

	public void fillCBintitu(ArrayList<Institution> listInstitu) {
		for (Institution institucion : listInstitu) {
			jCBInstitu.addItem(institucion.getNombreInstitucion());
		}
	}

	public String getInstitu() {
		return jCBInstitu.getSelectedItem().toString();
	}

	public String getCorreo() {
		return correo.getText();
	}

	public String getNameBotanic() {
		return name.getText();
	}

	public String getPassword() {
		return password.getText();
	}
	
	public void changeLanguage() {
		jLabel.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.NAME_BOTANIC));
		jLabel2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.EMAIL));
		jLabel3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.PASSWORD ));
		jCBCostsCategory.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.KIND_BOTANIC)));
		jCBInstitu.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.INSTITUTION)));
		jButton.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.CREATE));

	}


}
