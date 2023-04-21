package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.Control;


public class JDialogCreatePlant extends JDialog {
	JPanleFilterCreatePlant centerPlant;
//	JpanelNorte jpanelNorte;

	public JDialogCreatePlant(Control control) {
		this.centerPlant =  new JPanleFilterCreatePlant(control);
//		this.jpanelNorte =  new JpanelNorte();
		init();
	}

	private void init() {
		this.setResizable(false);
		setSize(400, 700);
		this.setLocationRelativeTo(null);

//		this.add(jpanelNorte, BorderLayout.NORTH);
		this.add(centerPlant, BorderLayout.CENTER);

//		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	public JPanleFilterCreatePlant getPlant() {
		return centerPlant;

	}

	public void changeLanguage() {
		centerPlant.changeLanguage();
	}
	
//	public Sellerplazz createPeople() {
//		return centerEmpleado.createPeople();
//
//	}

}
