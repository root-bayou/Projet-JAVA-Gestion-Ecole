package imane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Etudiant implements ActionListener {

	protected JFrame frmEtudiant;
	protected String mat ;
	protected String nomEtu ; 
	protected String preEtu ; 
	protected String mailEtu ; 
	protected String mobEtu ; 
	protected String addEtu ; 
	protected String ddnEtu ; 
	protected String ldnEtu ; 
	protected String adiEtu ; 
	protected String nvxEtu ; 
	protected String speEtu ;
	private JMenuItem mntmExitAlt , mntmMotDePasse , mntmProfile , mntmProfile_1 , mntmNote , mntmEmploisDuTemps ;
	private Cncbase c = new Cncbase();
	
	private String [] tab ;

	
	
	public Etudiant(String string , String tabl[] , String id  ) {
		initialize(string , tabl , id);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nom , String [] tabl ,String id) {
		frmEtudiant = new JFrame();
		frmEtudiant.setSize(600 , 400);
		frmEtudiant.setTitle("Etudiant-" + nom);
		frmEtudiant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEtudiant.setLocationRelativeTo(null);
		frmEtudiant.setResizable(false);
		frmEtudiant.setVisible(true);
		nomEtu = nom ;
		mat = id ; 
		tab = tabl ;
		JLabel lblNom = new JLabel("Nom : "+tabl[1]);
		lblNom.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblPrenom = new JLabel("Prenom : "+tabl[2]);
		lblPrenom.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblMatricule = new JLabel("Matricule : "+id);
		lblMatricule.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblNiveau = new JLabel("Niveau : "+tabl[9]);
		lblNiveau.setFont(new Font("Dialog", Font.BOLD, 15));
		
		JLabel lblSpcialit = new JLabel("Spécialité : "+tabl[10]);
		speEtu = tabl[10];
		lblSpcialit.setFont(new Font("Dialog", Font.BOLD, 15));
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String date1 = format.format(date);
		JLabel lblNewLabel = new JLabel("Date De Connexion : "+date1);
		GroupLayout groupLayout = new GroupLayout(frmEtudiant.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNiveau, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblSpcialit, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNom, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMatricule, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNom)
						.addComponent(lblPrenom, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatricule, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNiveau, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSpcialit, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		frmEtudiant.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmEtudiant.setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		mntmExitAlt = new JMenuItem("EXIT ALT + F4");
		mnFichier.add(mntmExitAlt);
		mntmExitAlt.addActionListener(this); 
		
		JMenu mnModifer = new JMenu("Modifer");
		menuBar.add(mnModifer);
		
		mntmMotDePasse = new JMenuItem("Mot De Passe");
		mnModifer.add(mntmMotDePasse);
		mntmMotDePasse.addActionListener(this);
		
		mntmProfile = new JMenuItem("Profile ");
		mnModifer.add(mntmProfile);
		mntmProfile.addActionListener(this);
		
		JMenu mnCondulter = new JMenu("Consulter");
		menuBar.add(mnCondulter);
		
		mntmProfile_1 = new JMenuItem("Profile ");
		mnCondulter.add(mntmProfile_1);
		mntmProfile_1.addActionListener(this); 
		
		mntmEmploisDuTemps = new JMenuItem("Emplois du Temps");
		mnCondulter.add(mntmEmploisDuTemps); 
		mntmEmploisDuTemps.addActionListener(this);
		
		mntmNote = new JMenuItem("Note");
		mnCondulter.add(mntmNote);
		
		
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == mntmProfile) {
			
			ModifierEtu m = new ModifierEtu(tab , mat , nomEtu , 1 ); 
		}
		if (arg0.getSource() == mntmMotDePasse) {
			ModiferAdmin m = new ModiferAdmin(nomEtu, 3) ; 
			
		} 
		if(arg0.getSource() == mntmProfile_1) {
			c.getCompteEtu(mat);
		}
		if(arg0.getSource() == mntmEmploisDuTemps) {
			AfficherEmplois af = new AfficherEmplois(nomEtu, speEtu , 1) ;
		}
		if (arg0.getSource() == mntmExitAlt) {
			frmEtudiant.dispose();
		}
	}
}
