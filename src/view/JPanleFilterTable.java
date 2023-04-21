package view;

import controller.Commands;
import general.HandlerLanguage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import models.ConstantsBotanic;
import models.SuitableCyty;
import models.KindBotanic;

public class JPanleFilterTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> jCBContries;
	private JComboBox<String> jCBCostsCategory2;
	private JComboBox<String> jCFamily;
	private JLabel jLabel;
	private JTextField jtfNameProd;
	private JButton jButtonFamily, jButtonSuitable, jButtonCountry, jButtonName;
	private JPanel jPanelContent, jPanelWest, jPanelEast;

	public JPanleFilterTable(ActionListener action) {

		this.jPanelContent = new JPanel();
		jPanelContent.setOpaque(false);
		jPanelContent.setLayout(new GridLayout(13, 1));
		this.jPanelWest = new JPanel();
		jPanelWest.setOpaque(false);
		this.jPanelEast = new JPanel();
		jPanelEast.setOpaque(false);

		this.add(jPanelContent, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);

		this.setOpaque(false);
		initComponents(action);
		fillListConties();
	}

	public void fillListConties() {

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
			jCBContries.addItem(countri.getDisplayCountry());
		}
	}

	private void initComponents(ActionListener action) {

		jCBContries = new JComboBox<>();
		jCBContries.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT)));
		jCBContries.setBackground(Color.WHITE);
		jPanelContent.add(jCBContries);
		
		
		jButtonCountry = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT));
		jButtonCountry.setBackground(Color.decode("#337ab7"));
		jButtonCountry.addActionListener(action);
		jButtonCountry.setForeground(Color.WHITE);
		jButtonCountry.setActionCommand(Commands.FIND_COUNTRY.toString());
		jPanelContent.add(jButtonCountry);
		createEspacio();


		jCBCostsCategory2 = new JComboBox<>();
		jCBCostsCategory2.addItem("SI");
		jCBCostsCategory2.addItem("NO");
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder(
				HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT)));
		jCBCostsCategory2.setBackground(Color.WHITE);
		jPanelContent.add(jCBCostsCategory2);
		
		jButtonSuitable = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT));
		jButtonSuitable.setBackground(Color.decode("#337ab7"));
		jButtonSuitable.addActionListener(action);
		jButtonSuitable.setForeground(Color.WHITE);
		jButtonSuitable.setActionCommand(Commands.FIND_SUITABLE.toString());
		jPanelContent.add(jButtonSuitable);
		createEspacio();


		jCFamily = new JComboBox<>();
		jCFamily.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT)));
		jCFamily.setBackground(Color.WHITE);
		jPanelContent.add(jCFamily);
		
		jButtonFamily = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT));
		jButtonFamily.setBackground(Color.decode("#337ab7"));
		jButtonFamily.addActionListener(action);
		jButtonFamily.setForeground(Color.WHITE);
		jButtonFamily.setActionCommand(Commands.FIND_BY_FAMILY.toString());
		jPanelContent.add(jButtonFamily);
		createEspacio();


		jtfNameProd = new JTextField(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_NAMEPLANT));
		jtfNameProd.setBackground(new Color(244, 244, 244));
		jtfNameProd.setPreferredSize(new Dimension(200, 60));
		jPanelContent.add(jtfNameProd);

		jButtonName = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_NAMEPLANT));
		jButtonName.setBackground(Color.decode("#337ab7"));
		jButtonName.addActionListener(action);
		jButtonName.setForeground(Color.WHITE);
		jButtonName.setActionCommand(Commands.SEARCHBY_WORD.toString());
		jPanelContent.add(jButtonName);



	}

	public void fillCBFamily(List<String> families) {
		for (String objeto : families) {
			jCFamily.addItem(objeto.toString());
		}
	}

	public String GetFamilyCB() {
		return jCFamily.getSelectedItem().toString();
	}
	
	public String getWord() {
		return jtfNameProd.getText();
	}

	public boolean getCityApt() {
		if (jCBCostsCategory2.getSelectedItem().toString().equals("SI")
				|| jCBCostsCategory2.getSelectedItem().toString().equals("YES")) {
			return true;
		} else {
			return false;
		}

	}

	public String getCountrySelected() {

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
		}

		String paisCode = countries.get(jCBContries.getSelectedItem().toString());

		return paisCode;
	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 1));
		jPanelContent.add(jLabel);
		return jLabel;

	}
	

	public void changeLanguage() {
		jCBContries.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT)));
		jButtonCountry.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT));
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT)));
		jButtonSuitable.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT));
		jCFamily.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT)));
		jButtonFamily.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT));
		jtfNameProd.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic. TABLE_NAMEPLANT));
		jButtonName.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_NAMEPLANT));

	}

}