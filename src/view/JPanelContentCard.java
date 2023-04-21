package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import general.HandlerLanguage;
import models.ConstantsBotanic;

public class JPanelContentCard extends JPanel {

	private JPanelPrototipo jPanelPrototipo;

	private String stringData;
	ImageIcon imageIcon;
	Icon icon;

	public JPanelContentCard() {
		this.setOpaque(false);

		init();
	}

	private void init() {
		this.setLayout(new GridLayout(1, 3, 50, 30));
		this.setPreferredSize(new Dimension(200, 200)); 
		
		this.add(jPanelPrototipo = new JPanelPrototipo(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.DATA),"/images/bosque.png"));
		this.add(jPanelPrototipo = new JPanelPrototipo("FLORA","/images/orquidea.png"));
		this.add(jPanelPrototipo = new JPanelPrototipo(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.INFORMATION),"/images/colombia.png"));

	
	}
	
	public void changeLanguage() {
		
		// jMenuItemEnglish.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_ENGLISH));
		// jMenuItemSpanish.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.T_SPANISH));

	}

}
