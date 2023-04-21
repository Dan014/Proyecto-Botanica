package fileManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.w3c.dom.DOMException;

import models.Institution;
import models.Specie;

//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;

//import co.edu.uptc.model.Persona;

public class FileJason implements GenericDAO {

	@Override
	public void escribir(ArrayList<Specie> WritinglistEspecies, String url) {
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

       try (FileWriter file = new FileWriter(url)) {
           file.write(EspecieJson.toJson());
           file.flush();
       } catch (IOException e) {
           e.printStackTrace();       
       }

	}

	@Override
	public void escribirXML(ArrayList<Specie> WritinglistEspecies, String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirJsonInstitution(ArrayList<Institution> WritinglistEspecies, String url) {
		   JsonArray json = new JsonArray();
           JsonArray EspecieJson = new JsonArray();
           
           for (Institution especie : WritinglistEspecies) {
               JsonObject especieWrite = new JsonObject();
               especieWrite.put("LUGAR", especie.getLugarIstitucion());
               especieWrite.put("NAME", especie.getNombreInstitucion());
               especieWrite.put("TIPO DE INSTITUCION", especie.getTipoIstitucion());
      
               EspecieJson.add(especieWrite);
           }

       json.add(EspecieJson);

       try (FileWriter file = new FileWriter(url)) {
           file.write(EspecieJson.toJson());
           file.flush();
       } catch (IOException e) {
           e.printStackTrace();       
       }				
	}

	@Override
	public void escribirXMLInstitution(ArrayList<Institution> WritinglistEspecies, String url)
			throws TransformerConfigurationException, TransformerFactoryConfigurationError, DOMException,
			ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
	}

	

}
