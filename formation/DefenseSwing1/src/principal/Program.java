package principal;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program {

	public static void main(String[] args) {
		
		JFrame fen1 = new JFrame("ma premiere fenetre");
		// choisir la taille de la fenetre
		fen1.setSize(400, 200);
		// centrer le fenetre
		fen1.setLocationRelativeTo(null);
		// terminer l'application quand on ferme la fenetre
		fen1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// ajouter un bouton
		JButton bouton = new JButton("clickez moi!");
		fen1.add(bouton);
		
		bouton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "votre compte est bien débité!");
			}
		});
		
		// rendre visible
		fen1.setVisible(true);
		
		
		
		
	}

}
