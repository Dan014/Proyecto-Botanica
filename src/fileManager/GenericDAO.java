package fileManager;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.w3c.dom.DOMException;

import models.Institution;
import models.Specie;


public interface GenericDAO{
	

	public void escribir(ArrayList<Specie>WritinglistEspecies,String url);
	public void escribirJsonInstitution(ArrayList<Institution>WritinglistEspecies,String url);

	public void escribirXML(ArrayList<Specie>WritinglistEspecies,String url) throws TransformerConfigurationException, TransformerFactoryConfigurationError, DOMException, ParserConfigurationException, TransformerException;
	public void escribirXMLInstitution(ArrayList<Institution>WritinglistEspecies,String url) throws TransformerConfigurationException, TransformerFactoryConfigurationError, DOMException, ParserConfigurationException, TransformerException;


	

}

