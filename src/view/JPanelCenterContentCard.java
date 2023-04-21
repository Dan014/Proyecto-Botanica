package view;

import controller.Control;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import models.HistoricalContribution;
import models.Botanic;
import models.Institution;


public class JPanelCenterContentCard extends JPanel {

	private JPanelPrototipoCard jPanelPrototipo;
	
	ImageIcon imageIcon;
	Icon icon;

        public void AddAporteCard(HistoricalContribution aporte, Botanic botanco, String nombreIsntitucion,ActionListener action){
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

	public JPanelCenterContentCard() {

		init();
	}

	private void init() {
		this.setLayout(new GridLayout(4, 1, 50, 150));
		this.setPreferredSize(new Dimension(700, 2000)); 
		this.setOpaque(false);
		

		

	
	}

    public void AddAporteCard(HistoricalContribution apor, Botanic findi, Institution findInstitucionById, String nombreIsntitucion,String nameEsp, Control Contro) {
        jPanelPrototipo = new JPanelPrototipoCard(nombreIsntitucion, apor, findi, nameEsp,Contro);
            add(jPanelPrototipo);
            
    }

}
