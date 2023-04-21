
package models;

import java.util.ArrayList;
import org.json.simple.JsonObject;

public class ManagerBotanic {
    
    private ArrayList<Botanic> listbotanicos;
    private int loged;

    public ManagerBotanic() {
        loged = 0;
        listbotanicos = new ArrayList<>();
    }
    
    public Botanic getLogedBotanic(){
        return findBotanicoById(loged);
    }

    public ArrayList<Botanic> getListbotanicos() {
        return listbotanicos;
    }

    public void setListbotanicos(ArrayList<JsonObject> listObj) {
        for (JsonObject listbotanico : listObj) {
            listbotanicos.add(assembleBotanico(listbotanico));
        }
    }
    
    public static Botanic createBotanico( String nameBotanico,int idinstitu, String mailBotanico, String password, KindBotanic tipobotanico){
        return new Botanic(nameBotanico,idinstitu, mailBotanico, password, 
                tipobotanico);
    }
    
    public void addBotanico(Botanic botanico){
        listbotanicos.add(botanico);
    }
    
    public Botanic assembleBotanico(JsonObject bota){
        Botanic making = null;
        int idInstitucion = bota.getInteger("id_institucion");
        int idBotanico = bota.getInteger("id_institucion");

        String mail = (String)bota.get("mail_botanico");
        String password = (String)bota.get("password");
        String namebot = (String)bota.get("name_botanico");
        KindBotanic tipobot = KindBotanic.PROFESOR;
        Boolean isActived = (Boolean) bota.get("isActived");
        
        if(((String)bota.get("tipo_botanico")).contains("Estu")){
            tipobot = KindBotanic.ESTUDIANTE;
        }else if(((String)bota.get("tipo_botanico")).contains("onal")){
            tipobot = KindBotanic.PROFESIONAL;
        }
        making = new Botanic(namebot, idInstitucion, mail, password, tipobot);
        making.setIdBotanico(idBotanico);
        return making;
    }
    
    public void login(int id){
        loged = id;
    }
    
    public int findByName(String name){
        int id = 0;
        for (Botanic botanico : listbotanicos) {
            if (botanico.getNameBotanico().equals(name)) {
                id = botanico.getIdBotanico();
            }
        }
        
        return id;
    }
    
    public int getLogedId() {
		return loged;
		
	}
    
    public ArrayList<Botanic> findByTipoBotanico(KindBotanic tipo){
        ArrayList<Botanic> listFinded = new ArrayList<>();
        for (Botanic botanico : listbotanicos) {
            if (botanico.getTipobotanico() == tipo) {
                listFinded.add(botanico);
            }
        }
        return listFinded;
    }
    
    //este verifica si el logueo esta bien
    
    public boolean verificateLogIn(String mail, String passWord){
        boolean exist = false;
        for (Botanic botanico : listbotanicos) {
            if(botanico.getMailBotanico().equals(mail)){
                if(botanico.getPassword().equals(passWord)){
                    exist = true;
                }
                
            }
            if (botanico.getActive().equals(false)) {
                exist = false;

			}
        }
        
        return exist;
    }
    
    public boolean verificateMailOk(String mail){
        boolean isOK = true;
        if(!(mail.contains("@"))){
            isOK = false;
        }
        return isOK;
    }
    
    public boolean verificateUnicMail(String newMail){
        boolean isUnic = true;
        
        for (Botanic listbotanico : listbotanicos) {
            if(listbotanico.getMailBotanico() == newMail){
                isUnic = false;
            }
        }
        return isUnic;
    }
    
    public Botanic findBotanicoByMail(String mail){
        for (Botanic botanico : listbotanicos) {
            if(botanico.getMailBotanico().equals(mail)){
                return botanico;
            }
        }
        return null;
    }
    
    public Botanic findBotanicoById(int idFind){
        for (Botanic botanico : listbotanicos) {
            if(botanico.getIdBotanico() == idFind){
                return botanico;
            }
        }
        return null;
    }
    
    
    
    
}
