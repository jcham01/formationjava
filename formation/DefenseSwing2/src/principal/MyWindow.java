package principal;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class MyWindow extends JFrame implements ActionListener, DocumentListener
{
	public static final String ADD_COMMAND = "add";
	public static final String CLEAR_COMMAND = "clear";
	
	
	
	private JButton bt1, bt2;
	private JTextField champTexte;
	private JTextArea champDocument;
	private DefaultListModel<String> listeData;
	private JList<String> listeChoix;
	
	
	public MyWindow() {
		super("ma super fenetre");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		// je place un panel au nord de ma fenetre
		JPanel panelHaut = new JPanel();
		add(panelHaut, BorderLayout.NORTH);
	
		// le contenu de mon panel sera aligné horizontalement 
		BoxLayout bl = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(bl);
		champTexte = new JTextField(30);
		panelHaut.add(champTexte);
		
		bt1 = new JButton("ajouter");
		panelHaut.add(bt1);
		bt1.setActionCommand(ADD_COMMAND);
		bt1.addActionListener(this);
		
		bt2 = new JButton("vider");
		panelHaut.add(bt2);
		bt2.setActionCommand(CLEAR_COMMAND);
		bt2.addActionListener(this);
		
		listeData = new DefaultListModel<String>();
		// je m'occupe de la zone ouest
		listeChoix = new JList<String>(listeData);
		// j'encapsule la jliste dans un jscrollPane qui gereras
		// les barres de défilement automatiquement
		add(new JScrollPane(listeChoix), BorderLayout.WEST);
		
		
		
		// et enfin la zone centrale
		champDocument = new JTextArea();
		add(new JScrollPane(champDocument), BorderLayout.CENTER);
		
		champTexte.getDocument().addDocumentListener(this);
	/*	JTextField jt2 = new JTextField();
		jt2.setDocument(champTexte.getDocument());
		panelHaut.add(jt2);
		*/
		
		// ajout d'un menu
		JMenuBar barre = new JMenuBar();
		JMenu menu1 = new JMenu("file");
		barre.add(menu1);
		
		menu1.add("open");
		//menu1.add("save");
		JMenu sousmenu1 = new JMenu("save");
		menu1.add(sousmenu1);
		menu1.add("close");
		
		sousmenu1.add("save as texte");
		sousmenu1.add("save as xml");
		
		JMenu menu2 =new JMenu("liste");
		JMenuItem item1 = new JMenuItem("add");
		menu2.add(item1);
		item1.addActionListener(this);
		item1.setActionCommand(ADD_COMMAND);
		
		JMenuItem item2 = new JMenuItem("clear");
		menu2.add(item2);
		item2.addActionListener(this);
		item2.setActionCommand(CLEAR_COMMAND);
		
		barre.add(menu2);
		
		setJMenuBar(barre);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case ADD_COMMAND:
				listeData.addElement(champTexte.getText());
				break;
			case CLEAR_COMMAND:
				listeData.clear();
				break;
		}
		
	}


	private void docChanged(DocumentEvent e) {
		
		if (champTexte.getText().length() < 3 || champTexte.getText().length() > 10)
		{
			bt1.setEnabled(false);
		}
		else
		{
			bt1.setEnabled(true);
		}
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {docChanged(e);}
	@Override
	public void insertUpdate(DocumentEvent e) {docChanged(e);}
	@Override
	public void removeUpdate(DocumentEvent e) {docChanged(e);}

}
