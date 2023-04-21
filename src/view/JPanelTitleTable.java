package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.Control;

public class JPanelTitleTable extends JPanel {

	private JPanelNorthButonTable jPanelNorthButonTable;

	public JPanelTitleTable(Control control) {
		this.jPanelNorthButonTable = new JPanelNorthButonTable(control);
		init();
	}

	private void init() {

		this.add(jPanelNorthButonTable);
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(0, 100));

	}

	public JPanelNorthButonTable getJPanelNorthButonTable() {
		return jPanelNorthButonTable;

	}
}
