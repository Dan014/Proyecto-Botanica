package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.DefaultFormatter;

import controller.Control;
import general.HandlerLanguage;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

import models.ConstantsBotanic;
import models.Institution;
import models.SuitableCyty;
import models.KindBotanic;




public class JPanelPrincipalDeleteBotanic extends JPanel {
	ImageIcon imageIcon;
	Icon icon;
	JButton jButton;
	JLabel jLabel, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, jLabel9, foto;
	JTextField name, correo, password;
	JPasswordField jPasswordField;
	JComboBox<KindBotanic> jCBCostsCategory;	
        JComboBox<String> jCBInstitu;


	public JPanelPrincipalDeleteBotanic(Control control) {

		init(control);
	}
        


	public void init(Control control) {

		this.setLayout(null);
		this.setBackground(Color.white);

		jLabel = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.EMAIL));
		jLabel.setBounds(20, 10, 300, 25);
		jLabel.setFont(new Font("Andale Mono", 3, 15));
		jLabel.setForeground(new Color(23, 4, 255));
		jLabel.setBackground(Color.BLUE);
		add(jLabel);

		name = new JTextField("");
		name.setBounds(20, 40, 320, 25);
		name.setBackground(new java.awt.Color(224, 224, 224));
		name.setFont(new java.awt.Font("Andale Mono", 1, 14));
		name.setForeground(new java.awt.Color(255, 0, 0));
		add(name);

		jLabel2 = new JLabel(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.PASSWORD));
		jLabel2.setBounds(20, 85, 200, 25);
		jLabel2.setFont(new Font("Andale Mono", 3, 15));
		jLabel2.setForeground(new Color(23, 4, 255));
		jLabel2.setBackground(Color.BLUE);
		add(jLabel2);

		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(20, 115, 320, 25);
		jPasswordField.setBackground(new java.awt.Color(224, 224, 224));
		jPasswordField.setFont(new java.awt.Font("Andale Mono", 1, 14));
		jPasswordField.setForeground(new java.awt.Color(255, 0, 0));
		add(jPasswordField);

		
                
                
//		createEspacio();

		
		jButton = new JButton("ELIMINAR");
		jButton.setBounds(250, 340, 200, 25);
		jButton.setFont(new Font("Andale Mono", 3, 15));
		jButton.setForeground(new Color(23, 4, 255));
		jButton.setActionCommand(controller.Commands.DELETE_BOTANIC_BUTONPRINCIPAL.name());
		jButton.addActionListener(control);
		add(jButton);

		
				
		foto = new JLabel();
		imageIcon = new ImageIcon(getClass().getResource("/images/usuario.png"));
		foto.setBounds(500, 30, 250, 250);
		icon = new ImageIcon(imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING));
		foto.setIcon(icon);
		this.add(foto);	
	}

  
	public void changeLanguage() {
		jLabel.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.EMAIL));
		jLabel2.setText(HandlerLanguage.languageProperties.getProperty(ConstantsBotanic.PASSWORD));
	}
    
        
    public String getCorreo() {
        return name.getText();
    }
    

    public String getPassword() {
        return String.valueOf(jPasswordField.getPassword());
    }

}
