package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import controller.Commands;
import controller.Control;
import general.HandlerLanguage;
import models.ConstantsBotanic;

public class JPanelNorthButonTableInstitution extends JPanel  {

	JPanel jPanelNorth;
	JButton jButton, jButton2, jButton3, jButton4;
	ImageIcon imageIcon;
	Icon icon;
//        JDialogAddCost jDialogAddCost;
	public JPanelNorthButonTableInstitution(Control control) {
		this.setOpaque(false);
		jPanelNorth = new JPanel();
		jPanelNorth.setOpaque(false);
		jPanelNorth.setPreferredSize(new Dimension(100, 100));

		init(control);
	}

	private void init(Control control) {

		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setPreferredSize(new Dimension(800, 100));

//                jDialogAddCost = new JDialogAddCost(action);
                
//		jPanelNorth.add(create("Ingresar Producto", "/images/dieta.png", Commands.C_ADDPRODUCT.name()));
//		jPanelNorth.add(create("Eliminar Producto", "/images/basura.png", Commands.C_AVERAGE.name()));
//		jPanelNorth.add(create("Buscar Producto", "/images/busqueda.png", Commands.C_AVERAGE.name()));

		
	
		
		jButton2 = new JButton(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.EXPORTJSON));
		jButton2.setBounds(0, 0, 200, 100);
		jButton2.setActionCommand(Commands.SAVE_JSON_INSTITUTION.name());
		jButton2.addActionListener(control);
		jButton2.setBackground(new Color(48, 48, 48));
		jButton2.setForeground(new Color(255, 255, 255));// blanco
		imageIcon = new ImageIcon(getClass().getResource("/images/exportar.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
		jButton2.setIcon(icon);
		jPanelNorth.add(jButton2);
		
		
		jButton4 = new JButton("EXPORT XML");
		jButton4.setBounds(0, 0, 200, 100);
		jButton4.setActionCommand(Commands.SAVEXMLINSTITUTION.name());
		jButton4.addActionListener(control);
		jButton4.setBackground(new Color(48, 48, 48));
		jButton4.setForeground(new Color(255, 255, 255));// blanco
		imageIcon = new ImageIcon(getClass().getResource("/images/exportar.png"));
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
		jButton4.setIcon(icon);
		jPanelNorth.add(jButton4);
		

		
		this.add(jPanelNorth, BorderLayout.NORTH);

	}

	public void changeLanguage() {
		jButton2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.EXPORTJSON));
		jButton3.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.CHANGEDPALNT));

	}

//    public JDialogAddCost getjDialogAddCost() {
//        return jDialogAddCost;
//    }


}
