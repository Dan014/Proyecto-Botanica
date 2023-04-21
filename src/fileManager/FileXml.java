package fileManager;

import java.io.File;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import models.Institution;
import models.Specie;

//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;

//import co.edu.uptc.model.Persona;

public class FileXml implements GenericDAO {

	@Override
	public void escribirXML(ArrayList<Specie> especie, String ruta) throws TransformerFactoryConfigurationError, DOMException, ParserConfigurationException, TransformerException  {
		File file = new File(ruta);
		Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        document = implementation.createDocument(null, "xml", null);
        document.setXmlVersion("1.0");
            
        //Elementos
        Element raiz = document.getDocumentElement();
        for(int i=0; i < especie.size(); i++){
            Element itemNode = document.createElement("Planta");     
            //Nombre
            Element name = document.createElement("name"); 
            Text nodeValueValue = document.createTextNode(especie.get(i).getNombreCientifico());                
            name.appendChild(nodeValueValue);
            //Familia
            Element familia = document.createElement("familia"); 
            Text nodeCountryValue = document.createTextNode(especie.get(i).getFamiliaEspaecie());                
            familia.appendChild(nodeCountryValue);
            //Reino
            Element reino = document.createElement("reino"); 
            Text nodeCompanyValue = document.createTextNode(especie.get(i).getReinoEspecie());                
            reino.appendChild(nodeCompanyValue);
            //Apto para ciudad
            Element city = document.createElement("aptoparaciudad"); 
            Text nodePriceValue = document.createTextNode(especie.get(i).getCultivoCiudad().toString());                
            city.appendChild(nodePriceValue);
            //Pais
            Element pais = document.createElement("pais"); 
            Text nodeCountry= document.createTextNode(especie.get(i).getContriesList().toString());                
            pais.appendChild(nodeCountry);
            //Aniadir datos
            itemNode.appendChild(name);
            itemNode.appendChild(familia);
            itemNode.appendChild(reino);
            itemNode.appendChild(city);
            itemNode.appendChild(pais);

                
            raiz.appendChild(itemNode); 
        }                
        //Generar el archivo
        Source source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, (javax.xml.transform.Result) result);
	}

	@Override
	public void escribir(ArrayList<Specie> WritinglistEspecies, String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirJsonInstitution(ArrayList<Institution> WritinglistEspecies, String url) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void escribirXMLInstitution(ArrayList<Institution> institution, String ruta)
			throws TransformerConfigurationException, TransformerFactoryConfigurationError, DOMException,
			ParserConfigurationException, TransformerException {
		File file = new File(ruta);
		Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        document = implementation.createDocument(null, "xml", null);
        document.setXmlVersion("1.0");
            
        //Elementos
        Element raiz = document.getDocumentElement();
        for(int i=0; i < institution.size(); i++){
            Element itemNode = document.createElement("Universidad");     
            //Nombre
            Element name = document.createElement("nombre"); 
            Text nodeValueValue = document.createTextNode(institution.get(i).getNombreInstitucion());                
            name.appendChild(nodeValueValue);
            //Familia
            Element familia = document.createElement("lugar"); 
            Text nodeCountryValue = document.createTextNode(institution.get(i).getLugarIstitucion());                
            familia.appendChild(nodeCountryValue);
            //Reino
            Element reino = document.createElement("tipo"); 
            Text nodeCompanyValue = document.createTextNode(institution.get(i).getTipoIstitucion());                
            reino.appendChild(nodeCompanyValue);
         
            //Aniadir datos
            itemNode.appendChild(name);
            itemNode.appendChild(familia);
            itemNode.appendChild(reino);
           
            raiz.appendChild(itemNode); 
        }                
        //Generar el archivo
        Source source = new DOMSource(document);
        StreamResult result = new StreamResult(file);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, (javax.xml.transform.Result) result);		
	}

	

}
