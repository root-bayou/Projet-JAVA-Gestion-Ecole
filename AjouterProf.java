package imane;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class AjouterProf implements ActionListener{
	
	private JButton ajPro ;
	private JFrame frame;
	private JTextField nomPro;
	private JTextField prePro;
	private JTextField mailPro;
	private JTextField mobPro;
	private JComboBox<String> spePro;
	private JPanel panel_5 ;
	private String[] tab = {"Mathématiques-Appliquées", "Mathématiques Génèrale", "Informatique-Génèrale", "Intélligence-Artificielle","Sytéme-Embarqué","Réseau-Télécom","Mathématiques", "Informatique", "Electronique", "Automatique","Mathématiques-informatique", "Science-Technologie"};
	private JTextField addPro;
	private JDatePickerImpl datePicker2 ;
	private Validation v = new Validation() ; 
	private Cncbase c = new Cncbase() ;
	private  String da = null ;
	
	public AjouterProf(String nom) {
		initialize(nom);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nom) {
		frame = new JFrame();
		
		frame.setSize(510,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setTitle("Administrateur-"+nom);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Prenom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Mail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Numero De Telephone", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Adresse", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Specialite", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Date de Naissance", TitledBorder.LEADING, TitledBorder.TOP, null, null)); 
		
		spePro = new JComboBox<String>();
		panel_5.add(spePro);
		for(String str : tab) 
			spePro.addItem(str);
		
		ajPro = new JButton("Ajouter");
		ajPro.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(ajPro, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))))))
					.addGap(22))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(ajPro)
					.addGap(107))
		);
		
		addPro = new JTextField();
		addPro.setColumns(10);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(addPro, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addComponent(addPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		
		mobPro = new JTextField();
		mobPro.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(mobPro, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(mobPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		mailPro = new JTextField();
		mailPro.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(mailPro, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(5)
					.addComponent(mailPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		prePro = new JTextField();
		prePro.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(prePro, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(prePro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		nomPro = new JTextField();
		nomPro.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nomPro, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(nomPro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout); 
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker2 = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker2.getJFormattedTextField().setText("2020-12-12");
		datePicker2.getJFormattedTextField().setForeground(Color.BLACK);
		panel_6.add(datePicker2);
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajPro) { 
			
			  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			  Date d =  (Date) datePicker2.getModel().getValue();
			  da = dateFormat.format(d);
			  System.out.print(da);
			  
			if(nomPro.getText().isBlank() == false && prePro.getText().isBlank() == false && v.isValidEmail(mailPro.getText()) && v.isValidnum(mobPro.getText()) && spePro.getSelectedItem().toString().isBlank() == false) {
				c.connect();
				String mpEtu = nomPro.getText().replaceAll("\\s", "")+"."+prePro.getText().replaceAll("\\s", "") ; 
				c.ajouterPro(nomPro.getText(), prePro.getText(), mobPro.getText(), mailPro.getText(), addPro.getText(), spePro.getSelectedItem().toString(), da , 1 , null , null); 
				int mat = c.getMat(nomPro.getText(),"prof") ;
				c.ajouterUtilisateur(nomPro.getText(), mpEtu, 2 , mat);
    			JOptionPane.showMessageDialog(null, nomPro.getText() + "\n" + prePro.getText() + "\n" + mobPro.getText() + "\n" + mailPro.getText() + "\n" + addPro.getText() + "\n" + da + "\n" + spePro.getSelectedItem().toString(), "Information",
    			JOptionPane.INFORMATION_MESSAGE);
    			frame.dispose();
				
			} 
			else {
				JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
				JOptionPane.ERROR_MESSAGE);
			}
			
			
			
		}
		
	}
}
