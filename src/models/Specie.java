
package models;

import java.util.List;

public class Specie {
    
    private int idEspecie;
    private static int idCount;
    private String familiaEspaecie,nombreCientifico,reinoEspecie, notaInformativa;
    private List<String>contriesList;
    private Boolean cultivoCiudad;

    public Specie( String familiaEspaecie, String nombreCientifico, String reinoEspecie,
            String notaInformativa, List<String> contriesList, Boolean cultivoCiudad) {
        idCount++;
        idEspecie = idCount;
        this.idEspecie = idEspecie;
        this.familiaEspaecie = familiaEspaecie;
        this.nombreCientifico = nombreCientifico;
        this.reinoEspecie = reinoEspecie;
        this.notaInformativa = notaInformativa;
        this.contriesList = contriesList;
        this.cultivoCiudad = cultivoCiudad;
 
    }


    public int getIdEspecie() {
        return idEspecie;
    }

    public String getFamiliaEspaecie() {
        return familiaEspaecie;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public String getReinoEspecie() {
        return reinoEspecie;
    }

    public String getNotaInformativa() {
        return notaInformativa;
    }

    public List<String> getContriesList() {
        return contriesList;
    }

    public Boolean getCultivoCiudad() {
        return cultivoCiudad;
    }

  
    
    
    
}
