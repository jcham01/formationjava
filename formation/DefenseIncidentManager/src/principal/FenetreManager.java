package principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import metier.Incident;
import metier.IncidentDAO;

public class FenetreManager extends JFrame implements ActionListener, ListSelectionListener
{
	public static final String CREATE_COMMAND = "create";
	public static final String EDIT_COMMAND = "edit";
	public static final String DELETE_COMMAND = "delete";
	public static final String RELOAD_COMMAND = "reload";
	
	private JButton btCreer, btEditer, btSupprimer, btReload;
	
	// les données de la liste
	private DefaultListModel<Incident> dataIncidents;
	// le composant graphique liste
	private JList<Incident> listeIncidents;
	private IncidentDAO incidentDAO;
	
	private FenetreEdit editWindow;
	
	public FenetreManager() {
		super("mon manager");
		setSize(500, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		JPanel panelHaut = new JPanel();
		BoxLayout bl = new BoxLayout(panelHaut, BoxLayout.X_AXIS);
		panelHaut.setLayout(bl);
		
		btCreer = new JButton("creer");
		panelHaut.add(btCreer);
		btCreer.setActionCommand(CREATE_COMMAND);
		btCreer.addActionListener(this);

		btEditer = new JButton("editer");
		panelHaut.add(btEditer);
		btEditer.setActionCommand(EDIT_COMMAND);
		btEditer.addActionListener(this);

		btSupprimer = new JButton("supprimer");
		panelHaut.add(btSupprimer);
		btSupprimer.setActionCommand(DELETE_COMMAND);
		btSupprimer.addActionListener(this);

		btReload = new JButton("rafraichir");
		panelHaut.add(btReload);
		btReload.setActionCommand(RELOAD_COMMAND);
		btReload.addActionListener(this);

		add(panelHaut, BorderLayout.NORTH);
		
		dataIncidents = new DefaultListModel<Incident>();
		listeIncidents = new JList<Incident>(dataIncidents);
	
		/*
		dataIncidents.addElement(new Incident(1,
										"panne signalisation",
										new Date(),
										3,
										"routine"));

		dataIncidents.addElement(new Incident(2,
				"voyageur malade station chatelet",
				new Date(),
				4,
				"sante"));
*/
		add(new JScrollPane(listeIncidents), BorderLayout.CENTER);
		listeIncidents.addListSelectionListener(this);
	
		// initialisation connection a la base
		incidentDAO = new IncidentDAO();
		
		// fenetre d'edition
		editWindow = new FenetreEdit(this);
		
		refresh_liste();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case CREATE_COMMAND:
				creer_incident();
				break;
			case EDIT_COMMAND:
				edit_incident();
				break;
			case DELETE_COMMAND:
				delete_incident();
				break;
			case RELOAD_COMMAND:
				refresh_liste();
				break;
		}
		
	}
	
	public void delete_incident() {
		// il faut insérer dans la base, et ajouter dans la JList
		incidentDAO.delete(listeIncidents.getSelectedValue());
		refresh_liste();
	}
	
	
	
	public void save_incident() {
		// il faut insérer dans la base, et ajouter dans la JList
		editWindow.setVisible(false);
		editWindow.refresh_object();
		incidentDAO.save(editWindow.getIncident());
		refresh_liste();
	}
	
	private void creer_incident() {
		Incident i = new Incident(0, "rien....", new Date(), 1, "defaut");
		editWindow.setIncident(i);
		editWindow.refresh_window();
		editWindow.setVisible(true);
	}
	
	private void edit_incident() {
		Incident i = listeIncidents.getSelectedValue();
		editWindow.setIncident(i);
		editWindow.refresh_window();
		editWindow.setVisible(true);
	}
	
	private void refresh_liste() {
		ArrayList<Incident> incidents = incidentDAO.findAll();
		// je vide la liste
		dataIncidents.clear();
		// je copie les incidents de la base dans la Jlist
		for (Incident i : incidents)
			dataIncidents.addElement(i);
		
		
	}

	// pour la liste
	@Override
	public void valueChanged(ListSelectionEvent e) {
		//JOptionPane.showMessageDialog(null, "selection de " + listeIncidents.getSelectedValue());
		
	}
	
	
	
}
