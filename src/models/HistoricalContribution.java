
package models;

import java.util.Calendar;


public class HistoricalContribution {
    
    private int idEspecie, idUsuario, idAporte;
    private static int idCount;
    private Calendar dateAporte;
    private String Detalles, ubicacionAporte;

    public HistoricalContribution(int idEspecie, int idUsuario, Calendar dateAporte, String Detalles, String ubicacionAporte) {
        idCount++;
        idAporte = idCount;
        this.idUsuario = idUsuario;
        this.idEspecie = idEspecie;
        this.dateAporte = dateAporte;
        this.Detalles = Detalles;
        this.ubicacionAporte = ubicacionAporte;
    }

    public void setIdAporte(int idAporte) {
        this.idAporte = idAporte;
    }

    public int getIdEspecie() {
        return idEspecie;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdAporte() {
        return idAporte;
    }

    public Calendar getDateAporte() {
        return dateAporte;
    }

    public String getDetalles() {
        return Detalles;
    }

    public String getUbicacionAporte() {
        return ubicacionAporte;
    }
    
    
    
}
