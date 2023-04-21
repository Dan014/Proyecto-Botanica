package viewMoblie;

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
import models.SuitableCyty;
import models.KindBotanic;

public class JPanleFilterCreatePlantMobile extends JPanel {

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

	public JPanleFilterCreatePlantMobile(Control control) {
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
		jLabelCountry.setText(countriessaved);
		repaint();
		revalidate();

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

		jtfNameProd = new JTextField("Nombre Cientifico");
		jtfNameProd.setBackground(new Color(244, 244, 244));
		jtfNameProd.setPreferredSize(new Dimension(200, 60));
		add(jtfNameProd);
		createEspacio();

		jTextFieldSecondName = new JTextField("Familia");
		jTextFieldSecondName.setBackground(new Color(244, 244, 244));
		jTextFieldSecondName.setPreferredSize(new Dimension(200, 60));
		add(jTextFieldSecondName);
		createEspacio();

		jCBCostsCategory = new JComboBox<>();
		jCBCostsCategory.setBorder(BorderFactory.createTitledBorder("PAIS:"));
		jCBCostsCategory.setBackground(Color.WHITE);
		add(jCBCostsCategory);
		createEspacio();

		buttonaddCountry = new JButton("ADD COUNTRY");
		buttonaddCountry.setBackground(Color.decode("#337ab7"));
		buttonaddCountry.setForeground(Color.WHITE);
		buttonaddCountry.setActionCommand(Commands.ADD_COUNTRY_MOBILE.name());
		buttonaddCountry.addActionListener(control);
		add(buttonaddCountry);

		jLabelCountry = new JLabel("PAISES: " + countriessaved);
		add(jLabelCountry);

		jCBCostsCategory2 = new JComboBox<>(SuitableCyty.values());
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder("APTO PARA CIUDAD:"));
		jCBCostsCategory2.setBackground(Color.WHITE);
		add(jCBCostsCategory2);
		createEspacio();

		jTextArea = new JTextArea();
		jTextArea.setBackground(Color.WHITE);
		jTextArea.setLineWrap(true);
		jTextArea.setWrapStyleWord(true);
		add(jTextArea);

		btnCreateProd = new JButton("CREAR MOBILE");
		btnCreateProd.setBackground(Color.decode("#337ab7"));
		btnCreateProd.setForeground(Color.WHITE);
		btnCreateProd.setActionCommand(Commands.CREATE_PLANT_MOBILE.name());
		btnCreateProd.addActionListener(control);
		add(btnCreateProd);

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 20));
		this.add(jLabel);
		return jLabel;

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