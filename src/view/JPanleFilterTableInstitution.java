package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatter;

import models.Institution;
import models.SuitableCyty;
import models.KindBotanic;

public class JPanleFilterTableInstitution extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jTextFieldName;
	private JComboBox<String> jCBCostsCategory;
	private JComboBox<SuitableCyty> jCBCostsCategory2;
	private DefaultTableModel dtmElements;

	private JLabel jLabel, jLabelCheck;
	private JButton jBLogin;
	private JSpinner jtKilos, jtPriceProd;
	private JPanel jPanelContent, jPanelWest, jPanelEast;

	private JTextField jtfNameProd;
	private JButton btnCreateProd;

	public JPanleFilterTableInstitution() {

		this.jPanelContent = new JPanel();
		jPanelContent.setOpaque(false);
		jPanelContent.setLayout(new GridLayout(12, 1));
		this.jPanelWest = new JPanel();
		jPanelWest.setOpaque(false);
		this.jPanelEast = new JPanel();
		jPanelEast.setOpaque(false);

		this.add(jPanelContent, BorderLayout.CENTER);
		this.add(jPanelWest, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);

		this.setOpaque(false);
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

	public void fillTableEspecie(ArrayList<Institution> EspeList) {
		dtmElements.setRowCount(0);
		for (Institution espe : EspeList) {

			String contries = "";

			dtmElements.addRow(new Object[] { espe.getIdInstitucion(), espe.getNombreInstitucion(),
					espe.getLugarIstitucion(), espe.getTipoIstitucion().toString() });
			// UserModel.addRow(new Object[] {dialog.getId(),dialog.getTimeStart(),
			// dialog.getTimeEnd(), dialog.getDialog())};
		}

		System.out.println("view.JTableMostrar.fillTableEspecie()");
		repaint();
		revalidate();
	}

	private void initComponents() {

		this.setBackground(Color.WHITE);

		jCBCostsCategory = new JComboBox<>();
		jCBCostsCategory.setBorder(BorderFactory.createTitledBorder("PAIS:"));
		jCBCostsCategory.setBackground(Color.WHITE);
		jPanelContent.add(jCBCostsCategory);
		createEspacio();

		jCBCostsCategory2 = new JComboBox<>(SuitableCyty.values());
		jCBCostsCategory2.setBorder(BorderFactory.createTitledBorder("APTO PARA CIUDAD:"));
		jCBCostsCategory2.setBackground(Color.WHITE);
		jPanelContent.add(jCBCostsCategory2);
		createEspacio();

		jtfNameProd = new JTextField("Nombre planta");
		jtfNameProd.setBackground(new Color(244, 244, 244));
		jtfNameProd.setPreferredSize(new Dimension(200, 60));
		jPanelContent.add(jtfNameProd);

		createEspacio();

		btnCreateProd = new JButton("Buscar");
		btnCreateProd.setBackground(Color.decode("#337ab7"));
		btnCreateProd.setForeground(Color.WHITE);
		// btnCreateProd.setActionCommand(Commands.C_CREATE_COST.name());
		// btnCreateProd.addActionListener(controllerApp);
		jPanelContent.add(btnCreateProd);

	}

	public JLabel createEspacio() {
		jLabel = new JLabel();
		jLabel.setPreferredSize(new Dimension(0, 20));
		jPanelContent.add(jLabel);
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