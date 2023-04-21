/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManager;

//import com.sun.xml.internal.ws.encoding.soap.DeserializationException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import models.ConstantsBotanic;
import models.HistoricalContribution;
import models.Botanic;
import models.Specie;
import models.Institution;
import models.KindBotanic;


import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

public class FileManager {

    private ArrayList<Institution>listinstituciones;


    public FileManager() {
        listinstituciones = new ArrayList<>();

    }

    public ArrayList<Institution> getListinstituciones() {
        return listinstituciones;
    }
       
    public String formateDate(Calendar cal){
       
        String strdate = null;

            if (cal != null) {
            strdate = ConstantsBotanic.FORMATE_DATE_STANDAR.format(cal.getTime());
            }
        
        return strdate;
    }
    
     public Calendar verificateDate(String dateString){  
        Calendar newDate = Calendar.getInstance();
        try {
            Calendar cal = Calendar.getInstance();
            
            cal.setTime(ConstantsBotanic.FORMATE_DATE_STANDAR.parse(dateString));
            newDate = cal;
            
            //setVisible(false);
        } catch (ParseException e) {
            e.printStackTrace();
            ConstantsBotanic.launchwarnigMessage();
        }
        return newDate;
    }
    
    public void writeAportes(ArrayList<HistoricalContribution>writeListInstituciones){
        JsonArray json = new JsonArray();
            JsonArray aportesJson = new JsonArray();
            
        for (HistoricalContribution aporte : writeListInstituciones) {
            JsonObject aporteWrite = new JsonObject();
            
            aporteWrite.put("id_aporte", aporte.getIdAporte());
            aporteWrite.put("id_botanico", aporte.getIdUsuario());
            aporteWrite.put("id_especie", aporte.getIdEspecie());
            aporteWrite.put("detalles_aporte", aporte.getDetalles());
            aporteWrite.put("ubicacion_aporte", aporte.getUbicacionAporte());
            
            
            //este escribe raro : 12/\05/\2019
            aporteWrite.put("fecha_aporte", formateDate(aporte.getDateAporte()) );
            
            aportesJson.add(aporteWrite);
        }
        
        try (FileWriter file = new FileWriter("data/ListAportes.json")) {
            file.write(aportesJson.toJson());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();       
        }
        
        
    
    }
    
    public void writeInstituciones(ArrayList<Institution>writeListInstituciones){
        JsonArray json = new JsonArray();
            JsonArray institucioneJson = new JsonArray();
        
        for (Institution intitucion : writeListInstituciones) {
            JsonObject intitucionWrite = new JsonObject();
            
            intitucionWrite.put("id_institucion", intitucion.getIdInstitucion());
            intitucionWrite.put("nombre_institucion", intitucion.getNombreInstitucion());
            intitucionWrite.put("tipo_institucion", intitucion.getTipoIstitucion().toString());
            
            institucioneJson.add(intitucionWrite);
        }
        
        try (FileWriter file = new FileWriter("data/ListInstituciones.json")) {
            file.write(institucioneJson.toJson());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();       
        }
    }
    
    public void writeBotanicos(ArrayList<Botanic>writingListbotanicos){
         JsonArray json = new JsonArray();
            JsonArray BotanicosJson = new JsonArray();
            
            for (Botanic botanico : writingListbotanicos) {
                JsonObject botanicoWrite = new JsonObject();
                
                botanicoWrite.put("id_botanic", botanico.getIdBotanico());
                botanicoWrite.put("id_institucion", botanico.getIdInstitucion());
                botanicoWrite.put("mail_botanico", botanico.getMailBotanico());
                botanicoWrite.put("name_botanico", botanico.getNameBotanico());
                botanicoWrite.put("password", botanico.getPassword());
                botanicoWrite.put("tipo_botanico", botanico.getTipobotanico());
                botanicoWrite.put("isActived", botanico.getActive());
                
                BotanicosJson.add(botanicoWrite);
            
            }
        json.add(BotanicosJson);

        try (FileWriter file = new FileWriter("data/ListBotanics.json")) {
            file.write(BotanicosJson.toJson());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();       
        }
        
    }
    
    public void writeEspecies(ArrayList<Specie>WritinglistEspecies){
        JsonArray json = new JsonArray();
            JsonArray EspecieJson = new JsonArray();
            
            for (Specie especie : WritinglistEspecies) {
                JsonObject especieWrite = new JsonObject();
                especieWrite.put("id_especie", especie.getIdEspecie());
                especieWrite.put("full_name", especie.getNombreCientifico());
                especieWrite.put("kingdom_name", especie.getReinoEspecie());
                especieWrite.put("cites_accepted", especie.getCultivoCiudad());
                especieWrite.put("full_note", especie.getNotaInformativa());
                especieWrite.put("family_name", especie.getFamiliaEspaecie());
                
                JsonArray contriesEspecie = new JsonArray();
                
                Vector vecContries = new Vector();
                for(String countri: especie.getContriesList()){
                    vecContries.add(countri);
                }  
                especieWrite.put("countries_iso_codes", vecContries);
                
                
                EspecieJson.add(especieWrite);
            }

        json.add(EspecieJson);

        try (FileWriter file = new FileWriter("data/ListEspecies.json")) {
            file.write(EspecieJson.toJson());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();       
        }
    }
    
    public ArrayList<JsonObject> readBotanicos() throws FileNotFoundException, IOException, org.json.simple.DeserializationException{
        
        Object obj = Jsoner.deserialize(new java.io.FileReader("data/ListBotanics.json"));
        JsonArray jsonObject = (JsonArray) obj;
        
        Iterator<Object> interatorEtities = jsonObject.iterator();
        
        ArrayList<JsonObject>listObj = new ArrayList<>();
        while(interatorEtities.hasNext()){
            JsonObject objectEnt = (JsonObject)interatorEtities.next();
            //int asdas =objectEnt.getInteger(("id"));
            listObj.add(objectEnt);
        }
        return listObj;
        
    }
    
    
    
    
    public ArrayList<JsonObject> readAportes() throws FileNotFoundException, IOException, org.json.simple.DeserializationException{
        Object obj = Jsoner.deserialize(new java.io.FileReader("data/ListAportes.json"));
        JsonArray jsonObject = (JsonArray) obj;
        
        Iterator<Object> interatorEtities = jsonObject.iterator();
        
        ArrayList<JsonObject>listObjects = new ArrayList<>();
        while(interatorEtities.hasNext()){
            JsonObject objectEnt = (JsonObject)interatorEtities.next();
            //int asdas =objectEnt.getInteger(("id"));
            listObjects.add(objectEnt);
        }
        return listObjects;
        
    }
    
    
    
    public void readInstitucines() throws FileNotFoundException,  IOException, org.json.simple.DeserializationException{
        Object obj = Jsoner.deserialize(new java.io.FileReader("data/ListInstituciones.json"));
        JsonArray jsonObject = (JsonArray) obj;
        Iterator<Object> interatorEtities = jsonObject.iterator();
        
        ArrayList<JsonObject>listObject = new ArrayList<>();
        
        while(interatorEtities.hasNext()){
            JsonObject objectEnt = (JsonObject)interatorEtities.next();
            //int asdas =objectEnt.getInteger(("id"));
            listinstituciones.add(assembleInstituto(objectEnt));
        }
    }
    
    public Institution assembleInstituto(JsonObject spe){
        Institution making = null;
        String nombreinst = (String)spe.get("nombre_institucion");
        String lugar = (String)spe.get("lugar");
        int idinsti = spe.getInteger("id_institucion");
        String tipoins = (String)spe.get("tipo_institucion");
        
        making = new Institution(nombreinst, tipoins,lugar );
        making.setIdInstitucion(idinsti);
        return making;
    }   

    public ArrayList<JsonObject> readEspecies() throws FileNotFoundException, IOException, org.json.simple.DeserializationException{
        Object obj = Jsoner.deserialize(new java.io.FileReader("data/ListEspecies.json"));
        JsonArray jsonObject = (JsonArray) obj;
        Iterator<Object> interatorEtities = jsonObject.iterator();
        
        ArrayList<JsonObject>listObject = new ArrayList<>();
        
        while(interatorEtities.hasNext()){
            JsonObject objectEnt = (JsonObject)interatorEtities.next();
            listObject.add(objectEnt);
        }
        
        return listObject;
    }

    
}
