
package models;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.json.simple.JsonObject;

public class ManagerHistoricalContribution {
    
    private ArrayList<HistoricalContribution> listHistoricos;

    public ManagerHistoricalContribution() {
        listHistoricos = new ArrayList<>();
    }

    public void setListHistoricos(ArrayList<JsonObject> lisobj) {
        for (JsonObject listHistorico : lisobj) {
            listHistoricos.add(assembleAporte(listHistorico));
        }
    }
    
    public List<String>getYears(){
        List<String>years = new ArrayList<>();
        for (HistoricalContribution listHistorico : listHistoricos) {
            years.add(listHistorico.getDateAporte().get(Calendar.YEAR) + "");
        }
        
        return years;
    }
    
    public HistoricalContribution assembleAporte(JsonObject apor){
        HistoricalContribution making = null;
        int idAporte = apor.getInteger("id_aporte");
        int idEspecie = apor.getInteger("id_especie");
        int idUsuario = apor.getInteger("id_botanico");
        Calendar dateChange = Calendar.getInstance();
        try {
            dateChange.setTime(ConstantsBotanic.FORMATE_DATE_STANDAR.parse((String)apor.get("fecha_aporte")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String detalles = (String)apor.get("detalles_aporte");
        String ubicacion = (String)apor.get("ubicacion_aporte");
        //making 
        making = new HistoricalContribution(idEspecie, idUsuario, dateChange, detalles, ubicacion);
        making.setIdAporte(idAporte);
        return making;
    }
 
    public ArrayList<HistoricalContribution> getListHistoricos() {
        return listHistoricos;
    }
    
    public void addAporte(HistoricalContribution aporte){
        listHistoricos.add(aporte);
    }
    
    public HistoricalContribution createAporte(int idEspecie, int idUsuario, Calendar dateAporte, String Detalles, String ubicacionAporte){
        return new HistoricalContribution(idEspecie, idUsuario, dateAporte, Detalles, ubicacionAporte);
    }
    
    public HistoricalContribution findAporteById(int idFind){
        for (HistoricalContribution listHistorico : listHistoricos) {
            if(listHistorico.getIdAporte() == idFind){
                return listHistorico;
            }
        }
        return null;
    }
    
    public ArrayList<HistoricalContribution> getAporteByYear(int year){
        
        ArrayList<HistoricalContribution>listFounded = new ArrayList<>();
        for (HistoricalContribution historico : listHistoricos) {
            if(historico.getDateAporte().getInstance().get(Calendar.YEAR) == year){
                listFounded.add(historico);
            }
        }
        
        return listFounded;
    }
    
    
    
}
