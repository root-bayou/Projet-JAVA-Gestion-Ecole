package imane;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class TabeAff extends JFrame {

	private JPanel contentPane;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public TabeAff(Object[][] objects , int mode) {
		setSize(1200,1200);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Object[][] data = objects ;
		String title[] = {"MATRICULE", "NOM" , "PRENOM" , "ADRESSE" , "NUMERO DE TELEPHONE" , "ADRESSE MAIL" , "DATE DE NAISSANCE" , "LIEUX DE NAISSENCE", "ANNEE D'INSCRIPTION" ,"NIVEAU" , "SPECIALITE"};
		String title1[] = {"MATRICULE", "NOM" , "PRENOM" , "ADRESSE MAIL" , "NUMERO DE TELEPHONE" , "ADRESSE" , "DATE DE NAISSANCE" , "SPECIALITE"};
		if (mode == 1) {
			table = new JTable(data, title);
			this.getContentPane().add(new JScrollPane(table));
				
			}
			
		
		else {
			table = new JTable(data, title1);
			this.getContentPane().add(new JScrollPane(table));
			
		}
		
	}

}
