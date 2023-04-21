package viewMoblie;

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



public class JFramePrincipalMobile extends JFrame {
	private JPanelPrincipal jPanelPrincipal;
	private JPanelPrincipalAddPlant jPanelPrincipal2;
	private JPanelPrincipalMultitarea jPanelPrincipalMultitarea;
	private JPanelPrincipalShowInfoPlant jPanelPrincipalShowInfoPlant;
	private JPanelPrincipalUser jPanelPrincipalUser;
	private JPanelPrincipalConfi jPanelPrincipalConfi;
	private JPanelPrincipalInfo jPanelPrincipalInfo;
	private MainPanelMobile jMainPanelMobile;

	private JScrollPane jScrollPane;
	Icon icon;

	public JFramePrincipalMobile(Control control) {
		this.setUndecorated(true);
		this.jPanelPrincipal = new JPanelPrincipal(control);
		this.jPanelPrincipalInfo = new JPanelPrincipalInfo(control);
		this.jPanelPrincipalShowInfoPlant = new JPanelPrincipalShowInfoPlant(control);
		this.jPanelPrincipal2 = new JPanelPrincipalAddPlant(control);
		this.jPanelPrincipalUser = new JPanelPrincipalUser(control);
		this.jMainPanelMobile = new MainPanelMobile(control);
		this.jPanelPrincipalMultitarea = new JPanelPrincipalMultitarea(control);
		this.jPanelPrincipalConfi = new JPanelPrincipalConfi(control);
		
		this.jScrollPane = new JScrollPane();

//		setIconImage(new ImageIcon(getClass().getResource("/images/WSO.png")).getImage());
		init();
	}

	private void init() {
		this.setResizable(true);
		this.setLayout(new BorderLayout());
		this.setSize(390, 700);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Botanica");
		jScrollPane.setViewportView(jPanelPrincipal);
		this.add(jScrollPane, BorderLayout.CENTER);
//		this.add(jPanleOptionMenu, BorderLayout.NORTH);
//		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
	
	
	   public void showJPanelAddPlant(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jPanelPrincipal2,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   public void showHomeMobile(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jMainPanelMobile,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   public void showMultitarea(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jPanelPrincipalMultitarea,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   
	   public void showInfoPlant(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jPanelPrincipalShowInfoPlant,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   public void showUser(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jPanelPrincipalUser,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   public void showConfi(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jPanelPrincipalConfi,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   public void showInfo(){
		   jPanelPrincipal.removeAll();
		   jPanelPrincipal.add(jPanelPrincipalInfo,BorderLayout.CENTER);
		   repaint();
		   revalidate();
	    }
	   
	   public JPanelPrincipalAddPlant getcreatePlantMobile() {
		return jPanelPrincipal2;
		   
	   }
	

	  
	
	public void changeLanguage(){
		jPanelPrincipal.getJPanelCenterHome().getJPanelHome().changeLanguage();
		
	}
	public int mygetWidht() {
		return this.getWidth();
		
	}
	public void addElementToTable(Object[] vectorElement) {
//		jpTableElements.addElementToTable( vectorElement );
	}

}
