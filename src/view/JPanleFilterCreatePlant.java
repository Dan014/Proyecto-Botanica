package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultFormatter;

import controller.Commands;
import controller.Control;
import general.HandlerLanguage;
import models.SuitableCyty;
import models.ConstantsBotanic;
import models.KindBotanic;

public class JPanleFilterCreatePlant extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldName;
	private JComboBox<String> jCBCostsCategory;
	private JComboBox<SuitableCyty> jCBCostsCategory2;
	private List<String> country;
	private JLabel jLabel, jLabelCountry;
	private JButton jBLogin;
	private JTextArea jTextArea;
	private JTextField jtfNameProd, jTextFieldSecondName;
	private JButton btnCreateProd, buttonaddCountry;
	private String countriessaved = " ";

	public JPanleFilterCreatePlant(Control control) {
		this.country = new ArrayList<>();
		this.setLayout(new GridLayout(12, 1));
		setSize(350, 600);
		initComponents(control);
		fillListConties();

	}

	public String getCountrySelected() {

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
		}

		String paisCode = countries.get(jCBCostsCategory.getSelectedItem().toString());

		return paisCode;
	}

	public void addCountryVerificated() {
		boolean coincidence = false;
		for (String count : country) {
			if (count.equals(getCountrySelected())) {
				coincidence = true;

			}
		}

		if (coincidence == false) {
			country.add(getCountrySelected());
			countriessaved += jCBCostsCategory.getSelectedItem().toString() + ",";
		}
		repaint();
		revalidate();
		jLabelCountry.setText(countriessaved+= " ");


	}

	public void fillListConties() {

		// List<String>listCountries = new ArrayList<>();

		Map<String, String> countries = new HashMap<>();
		for (String iso : Locale.getISOCountries()) {
			Locale countri = new Locale("", iso);
			countries.put(countri.getDisplayCountry(), iso);
			jCBCostsCategory.addItem(countri.getDisplayCountry());
			// listCountries.add(countri.getDisplayCountry());
		}
	}

	private void initComponents(Control control) {

		this.setBackground(Color.WHITE);

		jtfNameProd = new JTextField(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_NAMEPLANT));
		jtfNameProd.setBackground(new Color(244, 244, 244));
		jtfNameProd.setPreferredSize(new Dimension(200, 60));
		add(jtfNameProd);
		createEspacio();

		jTextFieldSecondName = new JTextField(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT));
		jTextFieldSecondName.setBackground(new Color(244, 244, 244));
		jTextFieldSecondName.setPreferredSize(new Dimension(200, 60));
		add(jTextFieldSecondName);
		createEspacio();

		jCBCostsCategory = new JComboBox<>();
		jCBCostsCategory.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT)));
		jCBCostsCategory.setBackground(Color.WHITE);
		add(jCBCostsCategory);
		createEspacio();

		buttonaddCountry = new JButton("ADD COUNTRY");
		buttonaddCountry.setBackground(Color.decode("#337ab7"));
		buttonaddCountry.setForeground(Color.WHITE);
		buttonaddCountry.setActionCommand(Commands.ADD_COUNTRY.name());
		buttonaddCountry.addActionListener(control);
		add(buttonaddCountry);

		jLabelCountry = new JLabel("PAISES: " + countriessaved);
		add(jLabelCountry);

		jCBCostsCategory2 = new JComboBox<>(SuitableCyty.values());
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT)));
		jCBCostsCategory2.setBackground(Color.WHITE);
		add(jCBCostsCategory2);
		createEspacio();

		jTextArea = new JTextArea();
		jTextArea.setBackground(Color.white);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		add(jTextArea);

		btnCreateProd = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.CREATE));
		btnCreateProd.setBackground(Color.decode("#337ab7"));
		btnCreateProd.setForeground(Color.WHITE);
		btnCreateProd.setActionCommand(Commands.ADDPLANTNEW.name());
		btnCreateProd.addActionListener(control);
		add(btnCreateProd);

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 20));
		this.add(jLabel);
		return jLabel;

	}

	public void changeLanguage() {
		jtfNameProd.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_NAMEPLANT));
		jTextFieldSecondName.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT));
		jCBCostsCategory.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT)));
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT)));
		btnCreateProd.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.CREATE));


	}
	
	public String getName() {
		return jtfNameProd.getText();
	}

	public String getTextArea() {
		return jTextFieldSecondName.getText();
	}

	public String getfamily() {
		return jTextFieldSecondName.getText();
	}

	public List<String> getCountry() {
		return country;
	}

	public Boolean getSuitable() {

		if (jCBCostsCategory2.getSelectedItem().toString().equals("SI ")) {
			return true;
		} else {
			return false;
		}
	}

}