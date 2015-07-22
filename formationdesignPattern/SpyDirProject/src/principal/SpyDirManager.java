package principal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SpyDirManager
{
	private ExecutorService service;
	ArrayList<SpyDir> spydirs;
	
	public SpyDirManager(String configFileName)
	{
		spydirs = new ArrayList<>();
		LogManager lm = new LogManager("log.txt");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File(configFileName));
			NodeList nl = doc.getElementsByTagName("rep");
			for (int i = 0; i < nl.getLength(); i++)
			{
				SpyDir sp = new SpyDir(((Element)nl.item(i)).getTextContent(), lm);
				spydirs.add(sp);
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
		service = Executors.newFixedThreadPool(spydirs.size());
	}
	
	public void startSpies()
	{
		for (SpyDir sp : spydirs)
			service.execute(sp);
	}
	
	
	public void stopSpying()
	{
		for (SpyDir sp : spydirs)
			sp.setMustStop(true);
		service.shutdown();
		try 
		{
			while(!service.awaitTermination(1000, TimeUnit.SECONDS))
			{
				System.out.println("attente....");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
