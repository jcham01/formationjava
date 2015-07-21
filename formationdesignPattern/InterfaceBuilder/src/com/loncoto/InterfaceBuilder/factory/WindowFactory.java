package com.loncoto.InterfaceBuilder.factory;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class WindowFactory 
{
	private HashMap<String, Element> windows_desc;
	
	public WindowFactory(String configFile) {
		windows_desc = new HashMap<String, Element>();
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(configFile);
			
			NodeList nl = doc.getElementsByTagName("window");
			for (int i =0; i < nl.getLength(); i++) {
				if (nl.item(i) instanceof Element) {
					Element balise = (Element)nl.item(i);
					windows_desc.put(balise.getAttribute("name"), balise);
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public JFrame BuildWindow(String windowName) {
		System.out.println("building window " + windowName +
				" of type " + windows_desc.get(windowName).getAttribute("type"));
		return null;
	}
}
