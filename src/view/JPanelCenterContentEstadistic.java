package view;

import controller.Commands;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import javax.swing.JPanel;

public class JPanelCenterContentEstadistic extends JPanel {

	private JPanelWorkAreaEstadistca jPanelWorkArea;
	private JPanel jPanelWhitheNorth, jPanelEast, jPanelWest, jPanelSouth;
	private JButton btnInstitutions, btnByYear, btnBotanico, btnAvali;

	public JPanelCenterContentEstadistic(ActionListener action) {

		jPanelWorkArea = new JPanelWorkAreaEstadistca();
		jPanelWorkArea.setPreferredSize(new Dimension(900, 0));
		jPanelWhitheNorth = new JPanel();
		jPanelWhitheNorth.setBackground(new Color(238, 238, 238));
		jPanelEast = new JPanel();
		jPanelEast.setPreferredSize(new Dimension(this.getWidth() + 400, 0));
		jPanelEast.setLayout(new GridLayout(6, 1));

		jPanelEast.add(Box.createRigidArea(new Dimension(0, 5)));

		btnInstitutions = new JButton("tipo de intutuciones");
		btnInstitutions.addActionListener(action);
		btnInstitutions.setActionCommand(Commands.SHOW_STATI_INSTI.toString());
		jPanelEast.add(btnInstitutions);

		btnByYear = new JButton("Aportes por Anio");
		btnByYear.addActionListener(action);
		btnByYear.setActionCommand(Commands.SHOW_STAT_BY_YEAR.toString());
		jPanelEast.add(btnByYear);

		btnBotanico = new JButton("Aporte por familia");
		btnBotanico.addActionListener(action);
		btnBotanico.setActionCommand(Commands.SHOW_STAT_BY_FAMILY.toString());
		jPanelEast.add(btnBotanico);
                
                btnAvali = new JButton("porcentaje plantas para ciudad");
		btnAvali.addActionListener(action);
		btnAvali.setActionCommand(Commands.SHOW_STATIC_AVALIBLE.toString());
		jPanelEast.add(btnAvali);

		jPanelWest = new JPanel();
		jPanelWest.setBackground(new Color(238, 238, 238));
		jPanelSouth = new JPanel();
		jPanelSouth.setBackground(new Color(238, 238, 238));

		init();
	}

	private void init() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(0, 600));
		this.add(jPanelWorkArea, BorderLayout.CENTER);
		this.add(jPanelWhitheNorth, BorderLayout.NORTH);
		this.add(jPanelWorkArea, BorderLayout.WEST);
		this.add(jPanelEast, BorderLayout.EAST);
		this.add(jPanelSouth, BorderLayout.SOUTH);

	}

	public JPanelWorkAreaEstadistca getjPanelWorkArea() {
		return jPanelWorkArea;
	}

}
