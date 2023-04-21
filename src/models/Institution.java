
package models;

public class Institution {
    
    private int idInstitucion;
    private static int idCount;
    private String nameInstitution;
    private String kindInstitution;
    private String placeInstitution;

    public Institution( String nameInstitution, String kindInstitution, String placeInstitution) {
        idCount++;
        idInstitucion = idCount;
        this.idInstitucion = idInstitucion;
        this.nameInstitution = nameInstitution;
        this.kindInstitution = kindInstitution;
        this.placeInstitution = placeInstitution;
    }

    public int getIdInstitucion() {
        return idInstitucion;
    }

    public String getLugarIstitucion() {
        return placeInstitution;
    }
    
    public static int getIdCount() {
        return idCount;
    }

    public String getNombreInstitucion() {
        return nameInstitution;
    }

    public void setIdInstitucion(int idInstitucion) {
        this.idInstitucion = idInstitucion;
    }

    public String getTipoIstitucion() {
        return kindInstitution;
    }
    
    
    
    
    
    
}
