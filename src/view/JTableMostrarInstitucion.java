package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Specie;
import models.Institution;

//import model.Vehicle;


public class JTableMostrarInstitucion extends JPanel{
	
	private JTable jtablePrincipal;
	private DefaultTableModel dtmElements;
	private JScrollPane jscrollTable;
	
	public JTableMostrarInstitucion() {
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		this.setOpaque(false);
		setLayout(new BorderLayout());
		initComponents();
	}

	private void initComponents() {
		dtmElements=new DefaultTableModel();
		changeLanguageTable();
		
		Font fontHeader=new Font(("Franklin Gothic Demi"),Font.ITALIC,16);
		
		jtablePrincipal = new JTable();
		jtablePrincipal.setModel(dtmElements);
		jtablePrincipal.getTableHeader().setReorderingAllowed(false);
		jtablePrincipal.getTableHeader().setBackground(new Color(48, 48, 48));
		jtablePrincipal.getTableHeader().setPreferredSize(new Dimension(50, 50));
		jtablePrincipal.getTableHeader().setForeground(Color.WHITE);
		jtablePrincipal.getTableHeader().setFont(fontHeader);
		
		jtablePrincipal.setFont(new Font(("Arial"), Font.PLAIN, 16));
		jtablePrincipal.setEnabled(false);
		jtablePrincipal.setOpaque(false);
		jtablePrincipal.setFillsViewportHeight(true);
		jtablePrincipal.setBorder(null);
		
		jscrollTable=new JScrollPane(jtablePrincipal);
		jscrollTable.setForeground(Color.WHITE);
		jscrollTable.setBorder(null);
		jscrollTable.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.add(jscrollTable,BorderLayout.CENTER);
		this.setBorder(null);
	
	}

	
	
	public DefaultTableModel getDtmElements() {
		return dtmElements;
	}

	public void setDtmElements(DefaultTableModel dtmElements) {
		this.dtmElements = dtmElements;
	}

	public void addElementToTable(Object[] vector) {
		dtmElements.addRow(vector);
	}
	

	   public void fillTableInstitucion(ArrayList<Institution> EspeList) {
        dtmElements.setRowCount(0);
        for (Institution espe : EspeList) {
            
            String contries = "";
           
            dtmElements.addRow(new Object[] {espe.getIdInstitucion(),espe.getNombreInstitucion(),
                espe.getLugarIstitucion(), espe.getTipoIstitucion().toString()});
            //UserModel.addRow(new Object[] {dialog.getId(),dialog.getTimeStart(), dialog.getTimeEnd(), dialog.getDialog())};
        }
        
        System.out.println("view.JTableMostrar.fillTableEspecie()");
        repaint();
        revalidate();
    }


	public void changeLanguageTable() {
		
	
		String[] headers={"ID","INSTITUCION","DEPARTAMENTO","TIPO"};
		dtmElements.setColumnIdentifiers(headers);
		revalidate();
		repaint();
	}

	

}
