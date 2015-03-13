package com.so.and;

import java.io.File;
import java.io.IOException;
 








import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 








import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.content.Context;
import android.os.Environment;
public class ModifyXMLDOM extends MainActivity {
	public static void lance(){
		
		
		
		
		
	 String filePath = "/data/data/com.so.and/historique.xml";
	        File xmlFile = new File(filePath);
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            Document doc = dBuilder.parse(xmlFile);
	            doc.getDocumentElement().normalize();
	           
	             
	            //add new element
	            addElement(doc);
	             
	            //write the updated document to file or console
	            doc.getDocumentElement().normalize();
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(new File("/data/data/com.so.and/historique.xml"));
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	            transformer.transform(source, result);
	            System.out.println("XML file updated successfully");
	             
	        } catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
	            e1.printStackTrace();
	        }
		
	}
	
	private static void addElement(Document doc) {
        NodeList employees = doc.getElementsByTagName("Applications");
        Element emp = null;
         
        //loop for each employee
      
            emp = (Element) employees.item(0);
            Element appliElement = doc.createElement("application");
            Element serviceElement1 = doc.createElement("nom");
            Element serviceElement2 = doc.createElement("messagerie");
            Element serviceElement3 = doc.createElement("repertoire");
            Element serviceElement4 = doc.createElement("calculatrice");
            Element serviceElement5 = doc.createElement("calendrier");
            
            serviceElement1.appendChild(doc.createTextNode(ism));
            serviceElement2.appendChild(doc.createTextNode(m));
            serviceElement3.appendChild(doc.createTextNode(re));
            serviceElement4.appendChild(doc.createTextNode(ca));
            serviceElement5.appendChild(doc.createTextNode(cale));
            
            appliElement.appendChild(serviceElement1);
            appliElement.appendChild(serviceElement2);
            appliElement.appendChild(serviceElement3);
            appliElement.appendChild(serviceElement4);
            appliElement.appendChild(serviceElement5);
            
            emp.appendChild(appliElement);
        }

}
