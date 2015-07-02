package principal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import metier.Incident;

public class FenetreEdit extends JFrame implements ActionListener 
{
	public static final String CANCEL_COMMAND = "cancel";
	public static final String SAVE_COMMAND = "save";
	
	
	private JLabel labelDesc,labelDate,labelUrgence,labelCategorie;
	private JTextField champDesc, champDate, champUrgence, champCategorie;
	
	private JButton btCancel,btSave;
	
	private Incident incident;
	public Incident getIncident() {
		return incident;
	}
	public void setIncident(Incident incident) {
		this.incident = incident;
	}


	private FenetreManager parent;
	
	public FenetreEdit(FenetreManager parent) {
		super("edition");
		this.parent = parent;
		
		setSize(250, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		setLayout(new GridLayout(5, 2));
		
		labelDesc = new JLabel("description");
		add(labelDesc);
		champDesc = new JTextField();
		add(champDesc);

		labelDate = new JLabel("date");
		add(labelDate);
		champDate = new JTextField();
		add(champDate);

		labelUrgence = new JLabel("urgence");
		add(labelUrgence);
		champUrgence = new JTextField();
		add(champUrgence);

		labelCategorie = new JLabel("categorie");
		add(labelCategorie);
		champCategorie = new JTextField();
		add(champCategorie);

		btCancel = new JButton("annuler");
		btCancel.setActionCommand(CANCEL_COMMAND);
		btCancel.addActionListener(this);
		add(btCancel);
		
		btSave = new JButton("sauver");
		btSave.setActionCommand(SAVE_COMMAND);
		btSave.addActionListener(this);
		add(btSave);
		
	}
	
	public void refresh_window() {
		champDesc.setText(incident.getDescription());
		champDate.setText(Incident.format.format(incident.getDate()));
		champUrgence.setText(String.valueOf(incident.getUrgence()));
		champCategorie.setText(incident.getCategorie());
	}
	
	
	public void refresh_object() {
		try {
			incident.setDescription(champDesc.getText());
			incident.setDate(Incident.format.parse(champDate.getText()));
			incident.setUrgence(Integer.parseInt(champUrgence.getText()));
			incident.setCategorie(champCategorie.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case CANCEL_COMMAND:
				break;
			case SAVE_COMMAND:
				parent.save_incident();
				break;
		}

	}

}
