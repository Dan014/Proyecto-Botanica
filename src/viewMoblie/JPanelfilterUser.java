package viewMoblie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
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

public class JPanelfilterUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldName;
	private JComboBox<String> jCBCostsCategory;
	
	private JLabel jLabel, jLabel2;

	private JTextField jtfNameProd, jTextFieldSecondName;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelfilterUser() {

		this.setLayout(new GridLayout(6, 1));
		setSize(350, 600);
		initComponents();
	}
	public void fillListConties() {
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
		createEspacio();
		jtfNameProd = new JTextField("Nombre");
		jtfNameProd.setEditable(false);
		jtfNameProd.setBackground(new Color(244, 244, 244));
		jtfNameProd.setPreferredSize(new Dimension(200, 60));
		add(jtfNameProd);
		createEspacio();

		jTextFieldSecondName = new JTextField("Correo");
		jTextFieldSecondName.setEditable(false);
		jTextFieldSecondName.setBackground(new Color(244, 244, 244));
		jTextFieldSecondName.setPreferredSize(new Dimension(200, 60));
		add(jTextFieldSecondName);
		createEspacio();

		

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 20));
		this.add(jLabel);
		return jLabel;

	}



}