
package viewMoblie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Control;

public class MainPanelMobile extends JPanel{
	private JPanelPrincipal jPanelPrincipal;

    public MainPanelMobile(Control control) {
    	jPanelPrincipal = new JPanelPrincipal(control);
    	this.setLayout(new BorderLayout());
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.add(jPanelPrincipal, BorderLayout.CENTER);
    }
    
}
