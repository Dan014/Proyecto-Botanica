
package models;

import java.util.ArrayList;

public class MainManager {
    
    private ManagerBotanic managerbotancos;
    private ManagerSpecie managerespecies;
    private ManagerHistoricalContribution managerHistoricos;
    private ManagerInstitution managerinstitucion;

    public MainManager() {
        managerHistoricos = new ManagerHistoricalContribution();
        managerespecies = new ManagerSpecie();
        managerbotancos = new ManagerBotanic();
        managerinstitucion = new ManagerInstitution();
    }
    
    public Botanic findBotanicByAporteId(int idAporte){
        for (HistoricalContribution object : managerHistoricos.getListHistoricos()) {
            if(object.getIdAporte() == idAporte){
                return managerbotancos.findBotanicoById(object.getIdUsuario());
            }
        }
        return null;
    }
    
    public ArrayList<Botanic> findBotanciByTipoInstitucion(String tipo){
        ArrayList<Botanic> listFinded = new ArrayList<>();
        for (Botanic botanico : managerbotancos.getListbotanicos()) {
            for (Institution intitu : managerinstitucion.getListInstitucion()) {
                if(botanico.getIdInstitucion() == intitu.getIdInstitucion()){
                    if(intitu.getTipoIstitucion().equals(tipo)){
                        listFinded.add(botanico);
                    }
                }
            }
        }
        
        return listFinded;
    }
    
    public ArrayList<Botanic> findBotanicByIstitucion(int idisnti){
        ArrayList<Botanic> listFinded = new ArrayList<>();
        for (Botanic botanico : managerbotancos.getListbotanicos()) {
            if(botanico.getIdInstitucion() == idisnti){
                listFinded.add(botanico);
            }
        }
        return listFinded;
    }
    
    

    public ManagerBotanic getManagerbotancos() {
        return managerbotancos;
    }

    public ManagerSpecie getManagerespecies() {
        return managerespecies;
    }

    public ManagerHistoricalContribution getManagerAportesHistoricos() {
        return managerHistoricos;
    }

    public ManagerInstitution getManagerinstitucion() {
        return managerinstitucion;
    }

    
    
    
    
}
