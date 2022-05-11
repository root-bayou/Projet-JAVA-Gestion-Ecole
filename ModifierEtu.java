package imane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModifierEtu extends JFrame implements ActionListener  {

	private JPanel contentPane;
	private JButton btnMiseAJour ;
	private JTextField nom;
	private JTextField prenom;
	private JTextField mp;
	private JTextField mail;
	private JTextField num;
	private JTextField adrr;
	private JTextField ldn;
	private JTextField ddn;
	private JTextField ddi;
	private JComboBox<String> nvxEtu;
	private JComboBox<String> speEtu;
	protected String[] tab = {"Mathématiques-Appliquées.01", "Mathématiques Génèrale.02", "Informatique-Génèrale.03", "Intélligence-Artificielle.04","Sytéme-Embarqué.05","Réseau-Télécom.06","Mathématiques.08", "Informatique.09", "Electronique.10", "Automatique.11","Mathématiques-informatique.12", "Science-Technologie.13"};
	private Validation v = new Validation() ;
	private Cncbase c = new Cncbase() ; 
	private String id1 ;
	public ModifierEtu(String[] tabl , String id , String nomA , int mode ) {
		id1 = id ;
		setTitle("Administrateur-"+nomA);
		setSize(510,500); 
		this.setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "prenom", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Mot De Passe ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Mail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Num\u00E9ro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Adresse", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Lieu de Naissance ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
	
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Date de Naissance ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Date D'Inscription", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nouveau Niveau", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		nvxEtu = new JComboBox<String>();
		nvxEtu.addItem("Licence-1");
		nvxEtu.addItem("Licence-2");
		nvxEtu.addItem("Licence-3");
		nvxEtu.addItem("Master-1");
		nvxEtu.addItem("Master-2");
		panel_9.add(nvxEtu);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Nouvelle Sp\u00E9cialit\u00E9  ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		speEtu = new JComboBox<String>();
				for(String str : tab) 
					speEtu.addItem(str);
		panel_10.setLayout(new BorderLayout(0, 0));
		panel_10.add(speEtu);
		
		
		
		btnMiseAJour = new JButton("Mise A jour");
		btnMiseAJour.addActionListener(this);
		
		JLabel lblNvx = new JLabel(tabl[9]);
		lblNvx.setFont(new Font("Dialog", Font.BOLD, 14));
		
		JLabel lblSp = new JLabel(tabl[10]);
		lblSp.setFont(new Font("Dialog", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
							.addGap(12))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
							.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMiseAJour, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNvx, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSp, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNvx)
						.addComponent(lblSp))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMiseAJour)
					.addContainerGap())
		);
		panel_9.setLayout(new BorderLayout(0, 0));
		panel_9.add(nvxEtu);
		
		ddi = new JTextField();
		ddi.setColumns(10);
		ddi.setText(tabl[8]);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(ddi, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(ddi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		
		ddn = new JTextField();
		ddn.setColumns(10);
		ddn.setText(tabl[6]);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(ddn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(ddn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		ldn = new JTextField();
		ldn.setColumns(10);
		ldn.setText(tabl[7]);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(ldn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(ldn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		adrr = new JTextField();
		adrr.setColumns(10);
		adrr.setText(tabl[5]);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(adrr, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addComponent(adrr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		num = new JTextField();
		num.setColumns(10);
		num.setText(tabl[4]);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(num, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(num, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		mail = new JTextField();
		mail.setColumns(10);
		mail.setText(tabl[3]);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(mail, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(mail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		mp = new JTextField();
		mp.setColumns(10);
		mp.setText(tabl[0]);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(mp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(mp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		prenom = new JTextField();
		prenom.setColumns(10);
		prenom.setText(tabl[2]);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(prenom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		nom = new JTextField();
		nom.setColumns(10);
		nom.setText(tabl[1]);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(15, Short.MAX_VALUE)
					.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane); 
		if (mode == 1) {
			nom.setEditable(false);
			prenom.setEditable(false);
			ddi.setEditable(false);
			ddn.setEditable(false);
			adrr.setEditable(false);
			nvxEtu.setEditable(false);
			nvxEtu.removeAllItems();
			nvxEtu.addItem(tabl[9]);
			nvxEtu.setSelectedIndex(0);
			mp.setEditable(false);
			mp.setVisible(false);
			speEtu.setEditable(false);
			speEtu.removeAllItems();
			speEtu.addItem(tabl[10]);
			speEtu.setSelectedIndex(0);
			ldn.setEditable(false);
		}
	}


	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnMiseAJour) {
			
			if(nom.getText().isBlank() == false && prenom.getText().isBlank() == false && mp.getText().isBlank() == false && adrr.getText().isBlank() == false && ldn.getText().isBlank() ==false && nvxEtu.getSelectedItem().toString().isBlank() == false && speEtu.getSelectedItem().toString().isBlank() == false && v.isValidEmail(mail.getText()) && v.isValidnum(num.getText()) && v.isValideDate(ddn.getText()) && v.isValideDate(ddi.getText()) ) {
				c.connect();
				c.ajouterEtudiants(nom.getText(), prenom.getText(), num.getText(), mail.getText(), adrr.getText(), ddn.getText(), ldn.getText(), ddi.getText(), nvxEtu.getSelectedItem().toString(), speEtu.getSelectedItem().toString(), 2, id1, mp.getText());
				this.dispose();
			}
			else {
				  JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
				    		JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}
}
