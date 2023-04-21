package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import general.HandlerLanguage;
import models.ConstantsBotanic;
import models.Specie;

//import model.Vehicle;

public class JTableMostrar extends JPanel {

	private JTable jtablePrincipal;
	private DefaultTableModel dtmElements;
	private JScrollPane jscrollTable;

	public JTableMostrar() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setOpaque(false);
		setLayout(new BorderLayout());
		initComponents();
	}

	private void initComponents() {
		dtmElements = new DefaultTableModel();
		changeLanguageTable();

		Font fontHeader = new Font(("Franklin Gothic Demi"), Font.ITALIC, 16);

		jtablePrincipal = new JTable();
		jtablePrincipal.setModel(dtmElements);
		jtablePrincipal.getTableHeader().setReorderingAllowed(false);
		jtablePrincipal.getTableHeader().setBackground(new Color(48, 48, 48));
		jtablePrincipal.getTableHeader().setPreferredSize(new Dimension(50, 50));
		jtablePrincipal.getTableHeader().setForeground(Color.WHITE);
		jtablePrincipal.getTableHeader().setFont(fontHeader);
		
		jtablePrincipal.setFont(new Font(("Arial"), Font.PLAIN, 16));
		jtablePrincipal.setRowHeight(1, 20);
		jtablePrincipal.setEnabled(false);
		jtablePrincipal.setOpaque(false);
		jtablePrincipal.setRowHeight(30);
		jtablePrincipal.getColumnModel().getColumn(0).setPreferredWidth(10);
		jtablePrincipal.getColumnModel().getColumn(3).setPreferredWidth(300);
		jtablePrincipal.setFillsViewportHeight(true);
		jtablePrincipal.setBorder(null);

		jscrollTable = new JScrollPane(jtablePrincipal);
		jscrollTable.setForeground(Color.WHITE);
		jscrollTable.setBorder(null);
		jscrollTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jscrollTable, BorderLayout.CENTER);
		this.setBorder(null);

	}

	public DefaultTableModel getDtmElements() {
		return dtmElements;
	}

	public void setDtmElements(DefaultTableModel dtmElements) {
		this.dtmElements = dtmElements;
	}

	public void addElementToTable(Object[] vector) {
		dtmElements.addRow(vector);
	}

	public void fillTableEspecie(ArrayList<Specie> EspeList) {
		dtmElements.setRowCount(0);
		for (Specie espe : EspeList) {

			String contries = "";
			for (String pais : espe.getContriesList()) {

				// esta parte convierte cidigo a palabra ose : MX = mexico
				Locale l = new Locale("EN", pais);
				contries += l.getDisplayCountry() + ", ";
			}
			String avalible = "";
                        
                        if(espe.getCultivoCiudad() == true){
                            avalible = HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.AVALIBLE);
                        }else{
                            avalible = HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.NOT_AVALIBLE);
                        }
			dtmElements.addRow(new Object[] { espe.getIdEspecie(), espe.getFamiliaEspaecie(),
					espe.getNombreCientifico(), contries, avalible });
			// UserModel.addRow(new Object[] {dialog.getId(),dialog.getTimeStart(),
			// dialog.getTimeEnd(), dialog.getDialog())};
		}

		System.out.println("view.JTableMostrar.fillTableEspecie()");
		repaint();
		revalidate();
	}

	public void changeLanguageTable() {

		String[] headers = { HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_IDPLANT),
				HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_FAMILYPLANT),
				HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_NAMEPLANT),
				HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_COUNTRYPLANT),
				HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.TABLE_SUITABLEPLANT) };
		dtmElements.setColumnIdentifiers(headers);
		revalidate();
		repaint();
	}

}
