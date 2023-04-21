package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class JPanelCenter extends JPanel {

	private JPanelCenterImagePrincipal jPanelCenterImagePrincipal;
	private JPanelCenterContent jPanelCenterContent;

	public JPanelCenter() {
		this.jPanelCenterImagePrincipal = new JPanelCenterImagePrincipal();
		this.jPanelCenterContent = new JPanelCenterContent();
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());

		init();
	}

	private void init() {

		this.setLayout(new BorderLayout());
		this.setOpaque(false);

		this.setPreferredSize(new Dimension(0, 700));
		this.add(jPanelCenterImagePrincipal, BorderLayout.NORTH);
		this.add(jPanelCenterContent, BorderLayout.CENTER);


	}
}
