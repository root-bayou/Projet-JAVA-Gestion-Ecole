package imane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JEditorPane;
import javax.swing.JDesktopPane;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.Font;


public class Admin extends JFrame implements ActionListener  {

	private JFrame frame;
	private JFrame frameAjouter; 
	private JMenuItem Exit ,ajAdm ,ajEtu ,ajProf , ajEmp ; 
	private String nomAdmin ; 
	private String mpAdmin ; 
	private JTextField nomEtu;
	private JTextField preEtu;
	private JTextField matEtu;
	private JTextField mobEtu;
	private JTextField mailEtu;
	private JMenuItem sCompteAdministrateur , sCompteEnseignant ,sCompteEtudiant , sEmploisDuTemps , cCompteEtudiant , cCompteEnseignant , cEmploisDuTemps , note , mdCompteAdministrateur,mdCompteEnseignant,mdCompteEtudiant , mdEmploisDuTemps   ; 
	private Cncbase c = new Cncbase();
	private String nom ;
	protected String[] tab = {"Mathématiques-Appliquées.01", "Mathématiques Génèrale.02", "Informatique-Génèrale.03", "Intélligence-Artificielle.04","Sytéme-Embarqué.05","Réseau-Télécom.06","Mathématiques.08", "Informatique.09", "Electronique.10", "Automatique.11","Mathématiques-informatique.12", "Science-Technologie.13"};
	private JLabel lblNewLabel_2;
	
	

	

	/**
	 * Create the application.
	 * @param string 
	 */
	public Admin(String string) {
		initialize(string);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nom) {
		nomAdmin = nom ;
		frame = new JFrame();
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Administrateur-"+nom);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom : "+nom);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel.setBounds(66, 92, 256, 15);
		frame.getContentPane().add(lblNewLabel);
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String date1 = format.format(date);
		JLabel lblNewLabel_1 = new JLabel("Date de connexion : "+date1);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNewLabel_1.setBounds(66, 126, 368, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Bayou");
		lblNewLabel_2.setBounds(459, 428, 329, 15);
		frame.getContentPane().add(lblNewLabel_2);
		frame.setResizable(false);
		frame.setBackground(getBackground());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 5, 0, 5));
		frame.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		Exit = new JMenuItem("Exit   ALT+F4");
		mnFichier.add(Exit);
		Exit.addActionListener(this);
		
		JMenu mnAjouter = new JMenu("Ajouter ");
		menuBar.add(mnAjouter);
		
		ajAdm = new JMenuItem("Compte Administrateur");
		mnAjouter.add(ajAdm);
		ajAdm.addActionListener(this);
		
		ajEtu= new JMenuItem("Compte Etudiant ");
		mnAjouter.add(ajEtu);
		ajEtu.addActionListener(this);
		
		ajProf = new JMenuItem("Compte Enseignant");
		mnAjouter.add(ajProf);
		ajProf.addActionListener(this);
		
		ajEmp = new JMenuItem("Emplois du temps");
		mnAjouter.add(ajEmp);
		ajEmp.addActionListener(this);
		
		JMenu mnSuprimer = new JMenu("Supprimer");
		menuBar.add(mnSuprimer);
		
		sCompteAdministrateur = new JMenuItem("Compte Administrateur");
		mnSuprimer.add(sCompteAdministrateur);
		
		
		sCompteEnseignant = new JMenuItem("Compte Enseignant");
		mnSuprimer.add(sCompteEnseignant);
		
		sCompteEtudiant = new JMenuItem("Compte Etudiant");
		mnSuprimer.add(sCompteEtudiant);
		
		sEmploisDuTemps = new JMenuItem("Emplois du Temps ");
		mnSuprimer.add(sEmploisDuTemps); 
		
		sCompteAdministrateur.addActionListener(this);
		sCompteEnseignant.addActionListener(this); 
		sCompteEtudiant.addActionListener(this);
		sEmploisDuTemps.addActionListener(this);
		
		JMenu mnModifier = new JMenu("Modifier");
		menuBar.add(mnModifier);
		
		mdCompteAdministrateur = new JMenuItem("Compte Administrateur");
		mnModifier.add(mdCompteAdministrateur);
		
		mdCompteEnseignant = new JMenuItem("Compte Enseignant");
		mnModifier.add(mdCompteEnseignant);
		
		mdCompteEtudiant = new JMenuItem("Compte Etudiant");
		mnModifier.add(mdCompteEtudiant);
		
		mdEmploisDuTemps = new JMenuItem("Emplois du Temps ");
		mnModifier.add(mdEmploisDuTemps);
		mdCompteAdministrateur.addActionListener(this);	
		mdCompteEnseignant.addActionListener(this);
		mdCompteEtudiant.addActionListener(this);
		mdEmploisDuTemps.addActionListener(this);
		
		JMenu mnSaisir = new JMenu("Saisir");
		menuBar.add(mnSaisir);
		
		note = new JMenuItem("Saisir les notes ");
		mnSaisir.add(note);
		note.addActionListener(this);
		
		JMenu mnConsulter = new JMenu("Consulter");
		menuBar.add(mnConsulter);
		
		cCompteEtudiant = new JMenuItem("Compte Etudiant");
		mnConsulter.add(cCompteEtudiant);
		cCompteEtudiant.addActionListener(this);
		
		cCompteEnseignant = new JMenuItem("Compte Enseignant");
		mnConsulter.add(cCompteEnseignant); 
		cCompteEnseignant.addActionListener(this);
		
		cEmploisDuTemps = new JMenuItem("Emplois Du Temps");
		mnConsulter.add(cEmploisDuTemps);
		cEmploisDuTemps.addActionListener(this);
	}
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource() == ajEtu ) {
			
			AjouterEtu aj = new AjouterEtu(nomAdmin);
			
		}
		if (arg0.getSource() == ajAdm) {
			
			AjouterAdmin aj = new AjouterAdmin(nomAdmin) ; 
		}
		if (arg0.getSource() == ajProf) {
			
			AjouterProf aj = new AjouterProf(nomAdmin) ; 
		}
		if (arg0.getSource() == ajEmp) {
			AjouterEmplois aj = new AjouterEmplois(nomAdmin , null , 1) ;
		}
		if (arg0.getSource() == sCompteAdministrateur) {
			
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Nom Du Compte A Supprimer !", "Suppression d'un Compte Administrateur !",
			JOptionPane.QUESTION_MESSAGE);
			if (nom.isEmpty() == false) {
				boolean r = c.supAdm(nom , 1) ;
				
				if (r) {
					JOptionPane j = new JOptionPane() ;
					j.showMessageDialog(null, " Compte Supprimer ", "Confirmation",
					j.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Le Nom Saisie est incorrect", "Erreur",
					JOptionPane.ERROR_MESSAGE);
							
					
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Nom incorrect", "Erreur",
				JOptionPane.ERROR_MESSAGE);
				
			}
		} 
		if (arg0.getSource() == sCompteEtudiant) { 
			
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Matricule de l'etuiant a Supprimer !", "Suppression d'un Compte Etudiants!",
			JOptionPane.QUESTION_MESSAGE);
			if (nom.isEmpty() == false) {
				c.supEtuPro(nom , "etudiants");
			}
		
			
			
		}
		if (arg0.getSource() == sCompteEnseignant) { 
			
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Matricule de l'enseignant a Supprimer !", "Suppression d'un Compte enseignant!",
			JOptionPane.QUESTION_MESSAGE);
			if (nom.isEmpty() == false) {
				
				c.supEtuPro(nom , "prof");
			}
			
			
		}
		if (arg0.getSource() == sEmploisDuTemps) { 
			

			String spe = (String) JOptionPane.showInputDialog(null, "Veuillez Choisir la Spécialité !", "Consultation !",
			JOptionPane.QUESTION_MESSAGE,null,tab,tab[11]);
			String id = (String) spe.subSequence(spe.length() - 2, spe.length());
			int i = Integer.valueOf(id).intValue(); 
			 c.connect(); 
			if(c.exiEm(i)) {
			  int rep = JOptionPane.showConfirmDialog(null, "Voulez vous continuez ?", "information",
						JOptionPane.OK_CANCEL_OPTION);
			  if (rep == 0 ) {
				
				  c.supEmplois(i);
				  JOptionPane.showMessageDialog(null, "D'accord supprimer :) ", "information",
							JOptionPane.INFORMATION_MESSAGE);
			}
			  else {
					JOptionPane.showMessageDialog(null, "D'accord :) ", "information",
							JOptionPane.INFORMATION_MESSAGE);
			} 
			}
			else {
				JOptionPane.showMessageDialog(null, "l'Emplois du temps choisi n'existe pas ", "information",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if (arg0.getSource() == cCompteEtudiant) {
			 	
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Matricule de l'etuiant !", "Consultation !",
				JOptionPane.QUESTION_MESSAGE);
			
				c.getCompteEtu(nom);	
		}
		if (arg0.getSource() == cCompteEnseignant) {
		 	
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Matricule !", "Consultation !",
				JOptionPane.QUESTION_MESSAGE);
			
				c.getCompteprof(nom);	
		}
		if (arg0.getSource() == cEmploisDuTemps) {
		 	
			String spe = (String) JOptionPane.showInputDialog(null, "Veuillez Choisir la Spécialité !", "Consultation !",
				JOptionPane.QUESTION_MESSAGE,null,tab,tab[11]);
			if (spe.isEmpty() == false) {
				
				AfficherEmplois af = new AfficherEmplois(nomAdmin, spe , 1) ;
			}
		
					
		} 
		if (arg0.getSource() == mdCompteAdministrateur) {
			ModiferAdmin md = new ModiferAdmin(nomAdmin , 1) ;
		} 
		if (arg0.getSource() == mdCompteEtudiant) {
			boolean re = true ;
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Matricule !", "Modification !",
					JOptionPane.QUESTION_MESSAGE);
				String [] tab = new String[11] ;
				tab = c.getMde(nom);
				for (int j = 0; j < tab.length; j++) {
					if (tab[j] == null) { 
						re = false ; 
						
					}
				}
				if (re) {
					ModifierEtu md = new ModifierEtu(tab , nom , nomAdmin , 2);
				} 
				else {
					  JOptionPane.showMessageDialog(null, "Matricule Incorrecte 2", "Erreur",
								JOptionPane.ERROR_MESSAGE);
				}
				
			
		}
		
		if (arg0.getSource() == mdEmploisDuTemps) {
			String spe = (String) JOptionPane.showInputDialog(null, "Veuillez Choisir la Spécialité !", "Consultation !",
					JOptionPane.QUESTION_MESSAGE,null,tab,tab[11]);
		
				if (spe.isEmpty() == false  ) {
					c.connect();
					String id =  (String) spe.subSequence(spe.length() - 2, spe.length());
					int i = Integer.valueOf(id).intValue() ; 
					if(c.exiEm(i)) {
					AfficherEmplois af = new AfficherEmplois(nomAdmin, spe , 0) ; }
					else {
						int rep = JOptionPane.showConfirmDialog(null, "L'emplois du temps pour la spécialité "+spe+" N'existe pas voulez vous l'ajouter ?", "Questions",
								JOptionPane.ERROR_MESSAGE);
						if (rep == 0) {
							AjouterEmplois aE = new AjouterEmplois(nomAdmin , spe , 2) ;
						}
						  else {
								JOptionPane.showMessageDialog(null, "D'accord :) ", "information",
										JOptionPane.INFORMATION_MESSAGE);
						} 
						
					}
				}
		}
		if (arg0.getSource() == mdCompteEnseignant) {
			
			boolean re = true ;
			nom = JOptionPane.showInputDialog(null, "Veuillez Saisir le Matricule !", "Modification !",
					JOptionPane.QUESTION_MESSAGE);
				String [] tab = new String[8] ;
				tab = c.getMdf(nom);
				for (int j = 0; j < tab.length; j++) {
					if (tab[j] == null) { 
						re = false ; 
						
					}
				}
				if (re) {
					ModiferProf md = new ModiferProf(tab , nom , nomAdmin);
				} 
				else {
					  JOptionPane.showMessageDialog(null, "Matricule Incorrecte", "Erreur",
								JOptionPane.ERROR_MESSAGE);
				}
			
		} 
		if(arg0.getSource() == Exit) {
			frame.dispose();
		}
			
			
		
			
	}
}