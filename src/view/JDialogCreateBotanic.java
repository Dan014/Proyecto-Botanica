package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;

import controller.Control;


public class JDialogCreateBotanic extends JDialog {
	JPanelPrincipalCreateBotanic centerEmpleado;
//	JpanelNorte jpanelNorte;

	public JDialogCreateBotanic(Control control) {
		this.centerEmpleado =  new JPanelPrincipalCreateBotanic(control);
//		this.jpanelNorte =  new JpanelNorte();
		init();
	}

	private void init() {
		this.setResizable(false);
		setSize(800, 400);
		this.setLocationRelativeTo(null);

//		this.add(jpanelNorte, BorderLayout.NORTH);
		this.add(centerEmpleado, BorderLayout.CENTER);

//		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
	}
	
	public JPanelPrincipalCreateBotanic getJPanelPrincipalCreateBotanico() {
		return centerEmpleado;

	}
	
	   public JPanelPrincipalCreateBotanic getCenterEmpleado() {
           return centerEmpleado;
       }

	public void changeLanguage() {
		centerEmpleado.changeLanguage();
		
	}

}
