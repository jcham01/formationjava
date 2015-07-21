package com.loncoto.InterfaceBuilder.windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class BaseWindow extends JFrame {

	protected Map<String, JComponent> dynamicComponents;
	protected List<String> componentsName;
	
	
	public BaseWindow(String name) {
		super(name);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	public void createComponents(Element windowdetails) {
		// contiendra les composants eux memes (retrouvable via leur nom
		dynamicComponents = new HashMap<String, JComponent>();
		// la liste des nom des composants dans l'ordre
		componentsName = new ArrayList<String>();
		NodeList componentElements = windowdetails.getChildNodes();
		for (int i = 0; i < componentElements.getLength(); i++) {
			// je ne m'interesse qu'au sous balise de window
			if (componentElements.item(i).getNodeType() == Node.ELEMENT_NODE) {
				//nous somme sur une des sous balise, e.g le JTextField, JButton etc.
				Element componentDetails = (Element)componentElements.item(i);
				// creation du composant
				JComponent c = createComponent(componentDetails);
				// ajout dans nos tableaux
				dynamicComponents.put(componentDetails.getAttribute("name"), c);
				componentsName.add(componentDetails.getAttribute("name"));
				// placement dans la fenetre
				placeComponent(c, componentDetails);
			}
		}
	}
	
	public JComponent createComponent(Element componentdetails) {
		switch (componentdetails.getTagName()) {
			case "JTextField":
				int column = Integer.parseInt(componentdetails.getAttribute("column"));
				return new JTextField(column);
			case "JLabel":
				return new JLabel(componentdetails.getAttribute("text"));
			case "JButton":
				return new JButton(componentdetails.getAttribute("text"));
		}
		return null;
	}
	
	public abstract void placeComponent(JComponent c, Element componentDetails); 
	
}
