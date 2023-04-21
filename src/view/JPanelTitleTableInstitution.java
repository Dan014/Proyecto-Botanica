package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;



import javax.swing.JPanel;

import controller.Control;

public class JPanelTitleTableInstitution extends JPanel {

	private JPanelNorthButonTableInstitution jPanelNorthButonTableInstitucion;
	
	public JPanelTitleTableInstitution(Control control) {
		this.jPanelNorthButonTableInstitucion = new JPanelNorthButonTableInstitution(control);
		init();
	}

	private void init() {

//		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.add(jPanelNorthButonTableInstitucion);
		this.setBackground(Color.GREEN);
		this.setPreferredSize(new Dimension(0, 100));

	}
}
