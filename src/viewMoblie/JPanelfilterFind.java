package viewMoblie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
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
import javax.swing.text.DefaultFormatter;
import models.SuitableCyty;
import models.KindBotanic;

public class JPanelfilterFind extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldName;
	private JComboBox<String> jCBCostsCategory;
	private JComboBox<SuitableCyty> jCBCostsCategory2;

	private JLabel jLabel, jLabelCheck;
	private JButton jBLogin;
	private JSpinner jtKilos, jtPriceProd;

	private JTextField jtfNameProd, jTextFieldSecondName;
	private JButton btnCreateProd;

	public JPanelfilterFind() {

		this.setLayout(new GridLayout(9, 1));
		setSize(350, 600);
		initComponents();
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
	private void initComponents() {

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

		jCBCostsCategory2 = new JComboBox<>(SuitableCyty.values());
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder("APTO PARA CIUDAD:"));
		jCBCostsCategory2.setBackground(Color.WHITE);
		add(jCBCostsCategory2);
		createEspacio();

		btnCreateProd = new JButton("BUSCAR");
		btnCreateProd.setBackground(Color.decode("#337ab7"));
		btnCreateProd.setForeground(Color.WHITE);
		// btnCreateProd.setActionCommand(Commands.C_CREATE_COST.name());
		// btnCreateProd.addActionListener(controllerApp);
		add(btnCreateProd);

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 20));
		this.add(jLabel);
		return jLabel;

	}

	public JTextField createJTextField(String name, Color color, int largo, int ancho) {
		jTextFieldName = new JTextField(name);
		jTextFieldName.setBackground(color);
		jTextFieldName.setPreferredSize(new Dimension(largo, ancho));
		this.add(jTextFieldName);
		return jTextFieldName;

	}

}