
package fileManager;

//import com.sun.xml.internal.ws.encoding.soap.DeserializationException;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadInstitutions {

	public static void reasInstitu() throws IOException, ParserConfigurationException, SAXException {

//		readFile("https://www.datos.gov.co/api/views/vsvf-eyf5/rows.xml?accessType=DOWNLOAD");
		readFile("https://www.datos.gov.co/resource/iwb2-skc4.json");
                
		
	}
        
        
    public ArrayList<JsonObject> readInsti() throws FileNotFoundException,  IOException, org.json.simple.DeserializationException{
        InputStreamReader inputReader = new InputStreamReader(getHttpURLConnection(false, "https://www.datos.gov.co/resource/iwb2-skc4.json"));
            Object obj = Jsoner.deserialize(inputReader);
            JsonArray jsonObject = (JsonArray) obj;

            Iterator<Object> interatorEtities = jsonObject.iterator();
            
            ArrayList<JsonObject>listJson = new ArrayList<>();
            while(interatorEtities.hasNext()){
                JsonObject objectEnt = (JsonObject)interatorEtities.next();
                listJson.add(objectEnt);
                //System.out.println(objectEnt.get("nombreinstitucion"));
//                int asdas =objectEnt.getInteger(("codigocaracterinstitucional"));                
//                System.out.println("" + asdas);           
            }
            
            return listJson;
    }
        
        
	public static void imprimeLista(NodeList lista)
	{
		for (int index=0;index<lista.getLength();index++){
			System.out.println(lista.item(index).getNodeName()+" "+lista.item(index).getTextContent());
		}

	}

	public static void readFile(String filePath){
		try {
//			URL url = new URL( filePath );
//			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
//			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
//			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();	
//			InputStream inputStream = httpURLConnection.getInputStream();
			
			InputStream inputStream = getHttpURLConnection( false, filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputStream);
			NodeList listRow = doc.getElementsByTagName("row").item(0).getChildNodes();
			NodeList listUrls = doc.getElementsByTagName("url").item(0).getChildNodes();
			imprimeLista(listRow);
			imprimeLista(listUrls);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}


	}

	public static InputStream getHttpURLConnection(boolean isProxy, String filePath) {
		HttpURLConnection httpURLConnection;
		URL url = null;
		InputStream inputStream = null;
		try {
			url = new URL( filePath );
			if ( !isProxy ) {
				System.out.println("Sin proxy");
				httpURLConnection = (HttpURLConnection) url.openConnection();	
				inputStream = httpURLConnection.getInputStream();
			}else {
				System.out.println("Con proxy");
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
				httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
				inputStream = httpURLConnection.getInputStream();
				if(inputStream == null )
					System.out.println( "Este input no quiere funcionar" );
			}

		}catch(ConnectException connectException) {
			isProxy = true;
			return getHttpURLConnection( isProxy, filePath );
		} catch (UnknownHostException e) {
			isProxy = true;
			System.out.println( "Catch: " + e.getMessage()  );
			return getHttpURLConnection( isProxy, filePath );
		} catch (MalformedURLException e1) {
			System.out.println(  e1.getMessage()  );
			e1.printStackTrace();
		}catch (IOException e) {
			System.out.println(  e.getMessage()  );
			e.printStackTrace();
		}
		return inputStream;
	}



    
}
