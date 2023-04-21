package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import controller.Control;

public class JPanelCenterTableInstitution extends JPanel {

	private JPanelTitleTableInstitution jPanelTitle;
	private JTableMostrarInstitucion jPanelCenterContent;
	private JPanel jPanleFilterTable;
	private JPanel jPanelEast, jPanelSouth;

	public JPanelCenterTableInstitution(Control control) {
		
		this.jPanelCenterContent = new JTableMostrarInstitucion();
		this.jPanelTitle = new JPanelTitleTableInstitution(control);
		this.jPanleFilterTable = new JPanel();
		jPanleFilterTable.setPreferredSize(new Dimension(100, 100));
		jPanleFilterTable.setOpaque(false);
		this.jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(100, 100));
		jPanelEast.setOpaque(false);
		this.jPanelSouth = new JPanel();
		jPanelSouth.setOpaque(false);

		init();
	}

	private void init() {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(100, 900));
		this.add(jPanelTitle, BorderLayout.NORTH);
		this.add(jPanelCenterContent, BorderLayout.CENTER);
		this.add(jPanleFilterTable, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelSouth, BorderLayout.SOUTH);



	}
	
	 public JTableMostrarInstitucion getjPanelTableMostrar() {
	        return jPanelCenterContent;
	    }
}
