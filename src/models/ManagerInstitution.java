
package models;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JsonObject;

public class ManagerInstitution {
    
    private ArrayList<Institution>listInstitucion;

    public ManagerInstitution() {
        listInstitucion = new ArrayList<>();
    }
    
    public void addInstitucion(Institution institu){
        listInstitucion.add(institu);
    }
    
    public static Institution createInstitucion( String nombreInstitucion, String tipoIstitucion, String lugar){
        return new Institution(nombreInstitucion, tipoIstitucion, lugar); 
    }

    public ArrayList<Institution>getListInstitucion() {
        return listInstitucion;
    }

    public void setListInstitucion(ArrayList<JsonObject> listObj) {
        for (JsonObject jsonObject : listObj) {
            listInstitucion.add(assembleInstituto(jsonObject));
        }
    }
    
    public List<String> getAllUniversities(){
        List<String>listUniversities = new ArrayList<>();
        
        for (Institution University : listInstitucion) {
            listUniversities.add(University.getNombreInstitucion());
        }
        return  listUniversities;
    }
    
    public Institution assembleInstituto(JsonObject spe){
        Institution making = null;
        String nombreinst = (String)spe.get("nombreinstitucion");
        String lugar = (String)spe.get("nombredeparamento");

        String tipoins = (String)spe.get("nombreorigeninstitucional");
        
        //System.out.println(((String)spe.get("tipoinstitucion")) + "");
        making = new Institution(nombreinst, tipoins,lugar );

        return making;
    } 
    
    public Institution findInstitucionById(int id){
        for (Institution institucion : listInstitucion) {
            if(institucion.getIdInstitucion() == id){
                return institucion; 
            }
        }
        return null;
    }
    
     public List<String> getTipesSpecies(){
        List<String>listTipes = new ArrayList<>();
        
        for (Institution listTipe : listInstitucion) {
            listTipes.add(listTipe.getTipoIstitucion());
        }
        
        return listTipes;
    }
     
    
    
    
    public Institution findInstitutionByName(String nombr){
        for (Institution institucion : listInstitucion) {
            if(institucion.getNombreInstitucion().equals(nombr)){
                return institucion; 
            }
        } 
        return null;
    }
    
    
}
