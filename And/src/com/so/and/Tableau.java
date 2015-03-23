package com.so.and;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Tableau extends Act2 {
	static String application[][] = new String[1000][6];
	public static void lance(){
		
		int i=0;
		
		 try {
			 
				File fXmlFile = new File("/data/data/com.so.and/historique.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
			 
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				NodeList nList = doc.getElementsByTagName("application");
			 
				System.out.println("----------------------------");
 
					while (i < nList.getLength())

					{
						for (int temp = 0; temp < nList.getLength(); temp++) {
							

					 
					 
					Node nNode = nList.item(temp);
			 
					System.out.println("\nCurrent Element :" + nNode.getNodeName());
			 
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			 
						Element eElement = (Element) nNode;
						application[i][0]= eElement.getElementsByTagName("nom").item(0).getTextContent();
						appliList.add(createapplication("application", application[i][0]));
						
						System.out.println(application[i][0]);
						application[i][1]= eElement.getElementsByTagName("messagerie").item(0).getTextContent();
						System.out.println(application[i][1]);

						application[i][2]=eElement.getElementsByTagName("repertoire").item(0).getTextContent();
						System.out.println(application[i][2]);

						
						application[i][3]= eElement.getElementsByTagName("calculatrice").item(0).getTextContent();
						System.out.println(application[i][3]);

						application[i][4]= eElement.getElementsByTagName("calendrier").item(0).getTextContent();
						System.out.println(application[i][4]);
						
						application[i][5]= eElement.getElementsByTagName("API").item(0).getTextContent();
						System.out.println(application[i][5]);
					
					  }
					  i++;}
				}
			    } catch (Exception e) {
				e.printStackTrace();
			    }
	}  
		
	public static String getnom(int position){
		return application[position][0];
	}
	public static String getmessage(int position){
		return application[position][1];
	}
	public static String getrepertoire(int position){
		return application[position][2];
	}
	public static String getcalculatrice(int position){
		return application[position][3];
	}
	public static String getcalendrier(int position){
		return application[position][4];
	}
	
	public static String getAPI(int position){
		return application[position][5];
	}
		
		
		
	}

