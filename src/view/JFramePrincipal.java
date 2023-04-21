package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import controller.Control;
import models.Specie;

public class JFramePrincipal extends JFrame {
	private JPanelPrincipal jPanelPrincipal;
	private JPanleOptionMenu jPanleOptionMenu;
	private JPanelPrincipalEstadistic jPanelPrincipalEstadisticas;
	private JPanelPrincipalTable jPanelPrincipalTable;
	private JPanelPrincipalTableInstitution jPanelPrincipalTableInstitucion;
	private JPanelPrincipalLogin jPanelPrincipalLogin;
	private JPanelPrincipalCard jPanelPrincipalCard;
	private JPanelPrincipalPlant jPanelPrincipalPlant;
	private JDialogCreateBotanic jDialogCreateBotanic;
	private JPanelSouth jPanelSouth;
	private JScrollPane jScrollPane;
	private MainPanel mainPanel;
	Icon icon;

	public JFramePrincipal(Control control) {
		this.jPanelPrincipalTableInstitucion = new JPanelPrincipalTableInstitution(control);
		this.jPanelPrincipalEstadisticas = new JPanelPrincipalEstadistic(control);
		this.jPanelPrincipalPlant = new JPanelPrincipalPlant();
		this.jPanelPrincipalCard = new JPanelPrincipalCard();
		this.jPanelPrincipalTable = new JPanelPrincipalTable(control);
		this.jPanelPrincipalLogin = new JPanelPrincipalLogin(control);
		this.jPanelPrincipal = new JPanelPrincipal(control);
		this.jPanleOptionMenu = new JPanleOptionMenu(control);
		this.jPanelSouth = new JPanelSouth();
		this.jScrollPane = new JScrollPane();
		this.mainPanel = new MainPanel(control);
		 setIconImage(new
		 ImageIcon(getClass().getResource("/images/logo.png")).getImage());
		init(control);
	}

	private void init(Control control) {
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setTitle("Botanic Solution");
		jScrollPane.setViewportView(jPanelPrincipal);
		this.add(jScrollPane, BorderLayout.CENTER);
		this.add(jPanleOptionMenu, BorderLayout.NORTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void showHome() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(mainPanel, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void showEstadisticas() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(jPanelPrincipalEstadisticas, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void showTable() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(jPanelPrincipalTable, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	public void showTableInstitucion() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(jPanelPrincipalTableInstitucion, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void showLogin() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(jPanelPrincipalLogin, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public void showContribution() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(jPanelPrincipalCard, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
    public JPanelPrincipalEstadistic getjPanelPrincipalEstadisticas() {
        return jPanelPrincipalEstadisticas;
    }
	public void showPlantTable() {
		jPanelPrincipal.removeAll();
		jPanelPrincipal.add(jPanelPrincipalPlant, BorderLayout.CENTER);
		repaint();
		revalidate();
	}

	public JPanelPrincipalTable getjPanelPrincipalTable() {
		return jPanelPrincipalTable;
	}
	
	public JPanelPrincipalTableInstitution getjPanelPrincipalTableInstitucion() {
		return jPanelPrincipalTableInstitucion;
	}

	 public JPanelPrincipalCard getjPanelPrincipalCard() {
	        return jPanelPrincipalCard;
	    }
	 
	public void changeLanguage() {
		jPanleOptionMenu.changeLanguage();
		jPanelPrincipalTable.getjPanelCenter().getjPanelTableMostrar().changeLanguageTable();
		jPanelPrincipalTable.getjPanelCenter().getjPanleFilterTable().changeLanguage();
		jPanelPrincipalTable.getjPanelCenter().getJPanelNorthButonTable().getJPanelNorthButonTable().changeLanguage();

	}

	public int mygetWidht() {
		return this.getWidth();

	}
	
	public void showPlantTable(Specie especie) {
		jPanelPrincipal.removeAll();
                jPanelPrincipalPlant.getjPanelCenter().getjPanelCenterPlant().getjPanelInfoPlant().getjPanelInfoPlantTxx().setEspecie(especie);
		jPanelPrincipal.add(jPanelPrincipalPlant, BorderLayout.CENTER);
                
		repaint();
		revalidate();
	}
	  public JPanelPrincipalLogin getjPanelPrincipalLogin() {
	        return jPanelPrincipalLogin;
	    }
	    
	public void addElementToTable(Object[] vectorElement) {
		// jpTableElements.addElementToTable( vectorElement );
	}

}
