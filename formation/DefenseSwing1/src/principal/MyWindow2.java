package principal;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MyWindow2 extends JFrame implements ActionListener
{
	public static final String COPY_TEXT = "copy";
	public static final String CLEAR_TEXT = "clear";
	
	
	public static void main(String[] args) {
		MyWindow2 fenetre2 = new MyWindow2();
		// etc etc..
	}
	
	
	private JTextField champTexte;
	private JButton bouton1;
	private JLabel label1;
	private JButton bouton2;
	
	public MyWindow2() {
		super("ma deuxieme fenetre");
		
		// je choisi le layoutmanager de ma fenetre
		// celui-ci placera/dimensionera mes composants
		setLayout(new FlowLayout());
		
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		// champ de saisie texte uniligne
		champTexte = new JTextField(30);
		add(champTexte);
		
		bouton1 = new JButton("cliquez ici");
		bouton1.setActionCommand(COPY_TEXT);
		add(bouton1);
		
		// texte pour affichage
		label1 = new JLabel("rien pour l'instant...");
		add(label1);
		
		bouton2 = new JButton("vider label");
		bouton2.setActionCommand(CLEAR_TEXT);
		add(bouton2);

		// evenements
		
		// ma fenetre implemente actionListener
		// je l'ajoute comme ecouteur du click de ce bouton
		// sa méthode "actionPerformed" sera appelée lors d'un click
		bouton1.addActionListener(this);
		bouton2.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()){
			case COPY_TEXT:
				String texte = champTexte.getText();
				label1.setText(texte);
				break;
			case CLEAR_TEXT:
				label1.setText("");
				break;
		}
	}

}
