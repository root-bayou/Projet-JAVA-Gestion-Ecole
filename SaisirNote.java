package imane;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class SaisirNote extends JFrame implements ActionListener {
	
	private Cncbase c = new Cncbase() ; 
	private JPanel contentPane;
	private JTable table;
	private JButton conf ; 
	private Object[][] data ;
	private String title[] = {"MATRICULE", "SPECIALITE" , "NOM" , "MODULE-1" , "MODULE-2" , "MODULE-3" , "MODULE-4"};
	private boolean r = true ;
	public SaisirNote(Object[][] objects) {
		setSize(1200,1200);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		data = objects ;
		table = new JTable(data, title);
		this.getContentPane().add(new JScrollPane(table) );
		conf = new JButton("Confirmez !") ; 
		this.getContentPane().add(conf,BorderLayout.SOUTH);
		conf.addActionListener(this);
		
	}


	public void actionPerformed(ActionEvent arg0) {
		boolean r = true ; 
		for (int i = 0; i < table.getRowCount() ; i++) {
			for (int j = 3; j < table.getColumnCount() ; j++) {
				
				if (table.getValueAt(i,j).toString().isEmpty() == true ) {
					table.setValueAt("0.0", i, j);
					} 
				try {
					float n  = Float.parseFloat(table.getValueAt(i,j).toString());
					if (n > 20 || n < 0) { 
						
						throw new NumberFormatException();
						
					}
					System.out.println(n);
					} catch (NumberFormatException e) {
					    System.out.println("pb is not a number");
					    JOptionPane.showMessageDialog(null, "Valeur Incorrecte dans le "+title[j]+" de l'etudiant "+table.getValueAt(i,2).toString(), "Erreur",
								JOptionPane.ERROR_MESSAGE);
					    r = false ;
					} 
			}
		} 
		String tab [][] = new String[table.getRowCount()][table.getColumnCount()] ; 
		if(r) { 
			
			for (int i = 0; i < table.getRowCount() ; i++) {
				for (int j = 0; j < table.getColumnCount() ; j++) {
					tab[i][j] = table.getValueAt(i,j).toString() ;
				} } 
			
			for (int i = 0; i < table.getRowCount() ; i++) { 
				c.ajouterNote(tab[i]);
			} 
			
			 JOptionPane.showMessageDialog(null, "OK :) ! ", "OK",
						JOptionPane.INFORMATION_MESSAGE);
			
		}
		else { 
			
			 JOptionPane.showMessageDialog(null, "Vérfier la saisie :) ! ", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			
		}
		
		
	}

}
