package com.loncoto.SingletonProject.graphic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.loncoto.SingletonProject.config.ConfigurationManager;

public class FenetrePrincipale extends JFrame implements ActionListener
{
	
	private JLabel label1;
	private JLabel label2;
	private JTextField champ1;
	private JTextField champ2;
	private JButton boutonsave;
	private JButton boutonOpen;
	
	
	public FenetrePrincipale(){
		super(ConfigurationManager.getInstance().getApplicationName() + " : " + "principale");
		
		label1 = new JLabel("nom application");
		label2 = new JLabel("version application");
		champ1 = new JTextField();
		champ2 = new JTextField();
		
		setLayout(new FlowLayout());
		setSize(400, 300);
		setLocationRelativeTo(null);
		
		add(label1);
		add(champ1);
		add(label2);
		add(champ2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		champ1.setText(ConfigurationManager.getInstance().getApplicationName());
		champ2.setText(ConfigurationManager.getInstance().getApplicationVersion());
		
		boutonsave = new JButton("save config");
		boutonsave.addActionListener(this);
		
		boutonOpen = new JButton("nouvelle fenetre");
		boutonOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FenetrePrincipale f = new FenetrePrincipale();
				f.setVisible(true);
			}
		});
		add(boutonsave);
		add(boutonOpen);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		ConfigurationManager cm = ConfigurationManager.getInstance();
		cm.setApplicationName(champ1.getText());
		cm.setApplicationVersion(champ2.getText());
	}
	
}
