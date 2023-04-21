package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;

import javax.swing.JPanel;

public class JPanelWorkAreaEstadistca extends JPanel {

    private List<String>listSongs;
    
    private int porcentX;
    private int porcentY;
    
    private int separationX;
    private int separationY;
    
    // IMPORTANTE
    
    private int growNumberX = 1;
    private int divitionsX = 15;
    
    //cambiar a double si hace falta
    private int growNumberY = 10;
    private int divitionsY = 25;
    
    private List<Integer>positions;
    private List<Integer>valuesPos;
    private List<String>nameValues;

    public JPanelWorkAreaEstadistca() {
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
        listSongs = new ArrayList<>();
        
        positions = new ArrayList<>();
        valuesPos = new ArrayList<>();
        nameValues = new ArrayList<>();
    }
        
    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        
        
        
        porcentX = (this.getWidth());
        porcentY = (this.getHeight());
        
        graphics.setColor(Color.red);
        paintLineX(graphics);
        paintLineY(graphics);
        paintSeparationsX(graphics);
        paintSeparationsY(graphics);
        
        drawStats(listSongs, graphics);
        
        for (int i = 0; i < positions.size(); i++) {
            drawBar(positions.get(i), valuesPos.get(i), nameValues.get(i), graphics);
        }
        //drawBar(1,7,"rock", graphics);
        //drawBar(1, 199, "prueba", graphics);
        //g.fillRoundRect (250, 270, 50, 70, 6, 6);
        //fillRect (150, 70, 50, 70);
        //drawLinePlane(1.2, 3.5, 4.0, 4.0, graphics);
    }

    //este es para el array que se va a graficar en barras, se llama en el controller
    
    public void setListSongs(List<String> listSongs) {
        divitionsX = 13;
        repaint();
        revalidate();
        positions = new ArrayList<>();
        valuesPos = new ArrayList<>();
        nameValues = new ArrayList<>();
        this.listSongs = listSongs;
    }
    
    
    
    public void paintLineX(Graphics graphics){
        int xa = porcentX*10/100;
        int ya = porcentY - porcentY*12/100;
        int xb = porcentX-xa;
        int yb = porcentY - porcentY*12/100;

        graphics.setColor(Color.red);
        graphics.drawLine(xa, ya, xb, yb);

    }
    
    public void paintLineY(Graphics graphics){
        int xa = porcentX*10/100;
        int ya = porcentY - porcentY*12/100;
        int xb = porcentX*10/100;
        int yb = porcentY - ya;

        graphics.setColor(Color.red);
        graphics.drawLine(xa, ya, xb, yb);
    }
    
    //este onta las linea de separacion
    
    public void paintSeparationsX(Graphics graphics){
        int xab = porcentX*10/100;
        int ya = porcentY - porcentY*12/100;
        
        int yb = porcentY - ya;
        
        separationX = ((porcentX-porcentX*10/100) - porcentX*10/100)/divitionsX;
        for (int i = 0; i < divitionsX; i++) {
            graphics.setColor(Color.blue);
            //graphics.drawLine(xab+(separationX*(i+1)), ya, xab+(separationX*(i+1)), yb);
            //graphics.drawString(""+ (i+1)*growNumberX, xab+(separationX*(i+1)), (porcentY - porcentY*9/100));
        }
        
    }
    
    
    
    public void paintSeparationsY(Graphics graphics){
        int xa = porcentX*10/100;
        int yab = porcentY - porcentY*12/100;
        int xb = porcentX-xa;
        
        separationY = ((porcentY - porcentY*12/100) - porcentY*12/100)/divitionsY;
        
        for (int i = 0; i < divitionsY; i++) {
            graphics.setColor(Color.GRAY);
            graphics.drawLine(xa, (yab - (separationY * (i+1))), xb, (yab - (separationY * (i+1))));
            graphics.drawString(""+ (i+1)*growNumberY, (xa - (xa/ (divitionsY)*12)), (yab - (separationY * (i+1))));
            
        }
        
    }
    
    //dibuja una linea con usando coordenasa cartecianas xa ya y xb yb
    private void drawLinePlane(double xLineA, double yLineA,double xLineB, double yLineB, Graphics graph){
        
        int unitTableX = divitionsX * growNumberX; 
        int unitTableY = divitionsY * growNumberY; 
        
        graph.setColor(Color.GREEN);
        graph.drawLine(getXPixelsGraph(xLineA), getYPixelsGraph(yLineA),
                    (getXPixelsGraph(xLineB)), getYPixelsGraph(yLineB));
        
    }
    
    
    //esto dibuja una barra sobre el plano recibe la posicion de la fila, valor en y, nombre de la barra y graphics
    private void drawBar(int xPositionBar, int ySuperiorBar,String barTag, Graphics graph){
        int baseBar = porcentY - porcentY*12/100;
        int xGraphPositionX = (getXPixelsGraph(xPositionBar)-(separationX/2)); 
        graph.setColor(Color.pink);
        graph.fillRect (xGraphPositionX, getYPixelsGraph(ySuperiorBar),
                
                //   v ancho barra
                separationX - (separationX/4), baseBar- getYPixelsGraph(ySuperiorBar));
        graph.setColor(Color.black);
        
        
        
        
        graph.drawString(barTag, xGraphPositionX , baseBar + (separationY));
        
        //drawStringVertical(barTag, xGraphPositionX, baseBar, graph);
        
    }
    
    public void drawStringVertical(String barTag,int xGraphPositionX ,int baseBar, Graphics graph){
        Graphics2D g2 = (Graphics2D) graph;
        Font font = new Font(null, Font.PLAIN, 10);    
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(45), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        g2.drawString(barTag, xGraphPositionX , baseBar + (separationY));
        g2.dispose();
    }
    
    //este metodo recibe las coordenadas en Y de y lo conviene en pixeles que dan justo en la coordenada de la tabla
    
    private int getYPixelsGraph(double yLine){
        int pixel = 0;
        pixel = (porcentY - porcentY*12/100)-(int)((yLine/(double)growNumberY)*separationY);
        
        return pixel;  
    }
    
    
    private int getXPixelsGraph(double xLine){
        int pixel = 0;
        pixel = (porcentX*10/100) + (int)((xLine/(double)growNumberX)*separationX);
        
        return pixel;  
    }
    
    
     
    
    public void drawStats(List<String>listSongs, Graphics graph){
        positions.clear();
        valuesPos.clear();
        nameValues.clear();
        if(this.listSongs.size()>2){
            growNumberY = (this.listSongs.size()/divitionsY)+1;
        }
        

        
        int positionX = 0;
            while (listSongs.size()>0) {
                int numVeces = 0;
                String val=listSongs.get(0);
                for (int y = 0; y < listSongs.size(); y++) {
                    if(val.equals(listSongs.get(y))){
                        numVeces++;
                       listSongs.remove(y);
                       y--;
                    }
                }
                positionX++;
                positions.add(positionX);
                valuesPos.add(numVeces);
                nameValues.add(val);
               System.out.println("El tipo: "+val+" se repite: "+numVeces);    
            }
            
            
            divitionsX = 15;
            
            if(positions.size()>1){
                divitionsX = positions.size();
            }
            
            
            
        
    }
}
