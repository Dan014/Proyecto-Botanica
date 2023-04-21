package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import controller.Control;

public class JPanelCenterTable extends JPanel {

	private JPanelTitleTable jPanelTitle;
	private JTableMostrar jPanelCenterContent;
	private JPanleFilterTable jPanleFilterTable;
	private JPanel jPanelEast, jPanelSouth;

	public JPanelCenterTable(Control control) {
		this.jPanelCenterContent = new JTableMostrar();
		this.jPanelTitle = new JPanelTitleTable(control);
		this.jPanleFilterTable = new JPanleFilterTable(control);
		this.jPanelEast = new JPanel();
		jPanelEast.setOpaque(false);
		this.jPanelSouth = new JPanel();
		jPanelSouth.setOpaque(false);
		init();
	}

	private void init() {
		this.setOpaque(false);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(100, 900));
		this.add(jPanelTitle, BorderLayout.NORTH);
		this.add(jPanelCenterContent, BorderLayout.CENTER);
		this.add(jPanleFilterTable, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelSouth, BorderLayout.SOUTH);





	}
	
	public JPanelTitleTable getJPanelNorthButonTable() {
		return jPanelTitle;

	}
	
	 public JTableMostrar getjPanelTableMostrar() {
	        return jPanelCenterContent;
	    }
	 public JPanleFilterTable getjPanleFilterTable() {
	        return jPanleFilterTable;
	    }
	 
	 
	 
	
	        
	        
}
