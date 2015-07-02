package principal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		add(new JScrollPane(listeIncidents), BorderLayout.CENTER);
		listeIncidents.addListSelectionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	// pour la liste
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JOptionPane.showMessageDialog(null, "selection de " + listeIncidents.getSelectedValue());
		
	}
	
	
	
}
