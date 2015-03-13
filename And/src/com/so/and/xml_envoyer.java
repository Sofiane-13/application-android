package com.so.and;
 
import java.io.File;
 


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
 
 
public class xml_envoyer extends MainActivity {
 
    public static void lance() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            //add elements to Document
            Element rootElement =
                doc.createElementNS("http://www.journaldev.com/application", "application");
            //append root element to document
            doc.appendChild(rootElement);
          //append first child element to root element
            rootElement.appendChild(getSerElements(doc, rootElement, "name", ism));
 
            //append first child element to root element
            rootElement.appendChild(getService(doc, "1", "calendrier", cale));
 
            //append second child
            rootElement.appendChild(getService(doc, "2", "message", m));
            //append truism  child
            rootElement.appendChild(getService(doc, "3", "repertoire", re));
            //append second child
            rootElement.appendChild(getService(doc, "4", "calculatrice", ca));
 
            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
 
            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("/data/data/com.so.and/versserveur.xml"));
 
            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static Node getSerElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
 
    private static Node getService(Document doc, String id, String name, String choisie) {
        Element Service = doc.createElement("Service");
 
        //set id attribute
        Service.setAttribute("id", id);
 
        //create name element
        Service.appendChild(getServiceElements(doc, Service, "name", name));
 
        //create age element
        Service.appendChild(getServiceElements(doc, Service, "choisie", choisie));
 
       
       
 
        return Service;
    }
 
 
    //utility method to create text node
    private static Node getServiceElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
    
 
}