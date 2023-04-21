package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import controller.Control;

public class JPanelCenterEstadistic extends JPanel {

	private JPanelCenterContentEstadistic jPanelCenterContent;

	public JPanelCenterEstadistic(Control control) {
		this.jPanelCenterContent = new JPanelCenterContentEstadistic(control);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		init();
	}

    public JPanelCenterContentEstadistic getjPanelCenterContent() {
        return jPanelCenterContent;
    }
        
        

	private void init() {

		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(0, 500));
		this.add(jPanelCenterContent, BorderLayout.CENTER);


	}
}
