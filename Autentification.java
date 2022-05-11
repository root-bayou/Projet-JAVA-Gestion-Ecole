package imane;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.mysql.jdbc.Statement;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class Autentification extends JFrame implements ActionListener {
	
	private JCheckBox Admin ;
	private JCheckBox Etudiant ;
	private JCheckBox Enseignant ; 
	private JFrame frame;
	private JButton Connexion ; 
	private JPasswordField passwordField;
	private int droitAcc ;  
	public Cncbase connexionBase = new Cncbase() ; 
	private JPanel panel;
	private JPanel panel_1;
	private JTextField nom;
	
	/**
	 * Create the application.
	 */
	public Autentification() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Courier 10 Pitch", Font.PLAIN, 14));
		frame.setFont(new Font("Century Schoolbook L", Font.PLAIN, 14));
		frame.setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setTitle("Autentification");
		frame.setSize(450,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		Connexion = new JButton("connexion");
		Connexion.setBorder(new CompoundBorder());
		Connexion.setBounds(28, 219, 373, 25);
		frame.getContentPane().add(Connexion);
		Connexion.addActionListener(this);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Vous etes ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 0, 406, 53);
		frame.getContentPane().add(panel);
		Admin = new JCheckBox("Admin");
		Etudiant = new JCheckBox("Etudiant");
		Etudiant.addActionListener(this);
		Enseignant= new JCheckBox("Enseignant");
		Enseignant.addActionListener(this);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addComponent(Admin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Etudiant, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Enseignant, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Enseignant)
						.addComponent(Admin)
						.addComponent(Etudiant))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Nom d'Utilisateur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(28, 131, 178, 60);
		frame.getContentPane().add(panel_1);
		
		nom = new JTextField();
		nom.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addComponent(nom, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mot De Passe", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panel_2.setBounds(223, 131, 178, 60);
		frame.getContentPane().add(panel_2);
		passwordField = new JPasswordField();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(passwordField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		Admin.addActionListener(this);
	}

	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == Admin && Admin.isSelected() ) {
		this.droitAcc = 1 ; 
		Etudiant.setEnabled(false);
		Enseignant.setEnabled(false);
		}
		if(arg0.getSource() == Admin && Admin.isSelected() == false ) {
			Etudiant.setEnabled(true);
			Enseignant.setEnabled(true);
			}
		if(arg0.getSource() == Etudiant && Etudiant.isSelected() ) { 
			this.droitAcc = 3 ; 
			Admin.setEnabled(false);
			Enseignant.setEnabled(false);
			}
			if(arg0.getSource() == Etudiant && Etudiant.isSelected() == false ) {
				Admin.setEnabled(true);
				Enseignant.setEnabled(true);
				}
			if(arg0.getSource() == Enseignant && Enseignant.isSelected() ) { 
				this.droitAcc = 2 ;
				Etudiant.setEnabled(false);
				Admin.setEnabled(false);
				}
				if(arg0.getSource() == Enseignant && Enseignant.isSelected() == false ) {
					Etudiant.setEnabled(true);
					Admin.setEnabled(true);
					} 
				if(arg0.getSource() == Connexion) {
					
					if(connexionBase.recherche(nom.getText() , passwordField.getPassword() , this.droitAcc)) {
						
						frame.dispose();
						if(this.droitAcc == 1) {
						Admin adm = new Admin(nom.getText()); 
						//to do
						
						
						}
						else if (this.droitAcc == 3) {
							int id = connexionBase.getMat(nom.getText(), "etudiants");
							Etudiant etu = new Etudiant(nom.getText() , connexionBase.getMde(String.valueOf(id)) , String.valueOf(id));
							
							//to do 
							
						}
						else {
							
							Prof pro = new Prof();
							// to do
						}
						
											}
						else {
							
							nom.setText(" ");
							passwordField.setText("");
							Admin.setSelected(false);
							Enseignant.setSelected(false);
							Etudiant.setSelected(false);
							Etudiant.setEnabled(true);
							Admin.setEnabled(true);
							Enseignant.setEnabled(true);
							JOptionPane.showMessageDialog(null, "Identifiants incorrects", "Erreur",
							JOptionPane.ERROR_MESSAGE);
							
						}
					
				
					
					
					
				}
		
		
		} 
	public int getAffichage() {
		return this.droitAcc;
		
	}
}
