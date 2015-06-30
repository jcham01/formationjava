package principal;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyWindow extends JFrame implements ActionListener
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

}
