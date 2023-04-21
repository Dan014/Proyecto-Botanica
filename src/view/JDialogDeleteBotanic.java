package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.Control;


public class JDialogDeleteBotanic extends JDialog {
	JPanelPrincipalDeleteBotanic centerPlant;
//	JpanelNorte jpanelNorte;

	public JDialogDeleteBotanic(Control control) {
		this.centerPlant =  new JPanelPrincipalDeleteBotanic(control);
//		this.jpanelNorte =  new JpanelNorte();
		init();
	}

	private void init() {
		this.setResizable(false);
		setSize(800, 400);
		this.setLocationRelativeTo(null);

//		this.add(jpanelNorte, BorderLayout.NORTH);
		this.add(centerPlant, BorderLayout.CENTER);

//		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void changeLanguage() {
		centerPlant.changeLanguage();
		
	}
	
	public JPanelPrincipalDeleteBotanic getdeleteBotanic() {
		return centerPlant;

	}

}
