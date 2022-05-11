package imane;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Rectangle;
import javax.swing.JButton;


public class AjouterEtu implements ActionListener {
	
	protected Cncbase connexionB = new Cncbase();
	protected Validation v = new Validation();

	protected JFrame frameAjouter;
	protected JTextField nomEtu;
	protected JTextField preEtu;
	protected JTextField mobEtu;
	protected JTextField mailEtu;
	protected JTextField ldnEtu;
	protected JTextField adrEtu;
	protected JComboBox<String> nvxEtu;
	protected JComboBox<String> speEtu;
	protected String[] tab1 = {"Mathématiques-informatique.12", "Science-Technologie.13"};
	protected String[] tab2 = {"Mathématiques.08","Informatique.09","Electronique.10", "Automatique.11"};
	protected String[] tab3 = {"Mathématiques-Appliquées.01", "Mathématiques Génèrale.02", "Informatique-Génèrale.03", "Intélligence-Artificielle.04","Sytéme-Embarqué.05","Réseau-Télécom.06"};
	protected JPanel panel_10 ;
	protected JButton ajEtu ; 
	protected JDatePickerImpl datePicker ;
	protected JDatePickerImpl datePicker1;
	
	
	
	
	/**
	 * Create the application.
	 */
	public AjouterEtu(String nom) {
		initialize(nom);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String nom) {
		frameAjouter = new JFrame() ;
		frameAjouter.setSize(510,500);
		frameAjouter.setLocationRelativeTo(null);
		frameAjouter.setVisible(true);
		frameAjouter.setTitle("Administrateur-"+nom);
		frameAjouter.setResizable(false);
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Nom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Prenom", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Mobile", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Mail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Date de Naissance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Année D'inscription", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "lieu de Naissance", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		ldnEtu = new JTextField();
		ldnEtu.setColumns(10);
		ldnEtu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Adresse", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		adrEtu = new JTextField();
		adrEtu.setColumns(10);
		adrEtu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Niveau", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		
		panel_10 = new JPanel();
		panel_10.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sp\u00E9cialit\u00E9 ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 51, 51)));
		speEtu = new JComboBox<String>();
		panel_10.add(speEtu);
		
		ajEtu = new JButton("Ajouter");
		ajEtu.addActionListener(this);
		
		
		GroupLayout groupLayout = new GroupLayout(frameAjouter.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(ajEtu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_5, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_10, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_6, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_10, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_7, GroupLayout.PREFERRED_SIZE, 57, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(51)
					.addComponent(ajEtu)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addContainerGap()
					.addComponent(adrEtu, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addGap(5)
					.addComponent(adrEtu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_8.setLayout(gl_panel_8);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(ldnEtu, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGap(5)
					.addComponent(ldnEtu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		nvxEtu = new JComboBox<String>();
		nvxEtu.addItem("Licence-1");
		nvxEtu.addItem("Licence-2");
		nvxEtu.addItem("Licence-3");
		nvxEtu.addItem("Master-1");
		nvxEtu.addItem("Master-2");
		nvxEtu.addActionListener(this);
		panel_9.add(nvxEtu);
		
		mailEtu = new JTextField();
		mailEtu.setColumns(10);
		mailEtu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(mailEtu, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(5)
					.addComponent(mailEtu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		mobEtu = new JTextField();
		mobEtu.setColumns(10);
		mobEtu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(mobEtu, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(mobEtu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		preEtu = new JTextField();
		preEtu.setColumns(10);
		preEtu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(preEtu, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(preEtu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		nomEtu = new JTextField();
		nomEtu.setBounds(new Rectangle(0, 0, 50, 0));
		nomEtu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nomEtu.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nomEtu, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(nomEtu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setText("2020-12-12");
		datePicker.getJFormattedTextField().setForeground(Color.BLACK);
		panel_5.add(datePicker);
		
		UtilDateModel model1 = new UtilDateModel();
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		datePicker1.getJFormattedTextField().setText("2020-12-12");
		panel_6.add(datePicker1);
		
		
		frameAjouter.getContentPane().setLayout(groupLayout);
	}

	public void actionPerformed(ActionEvent e) { 
	
		if(e.getSource() == nvxEtu) { 
			
					
					
					if(nvxEtu.getSelectedItem() == "Licence-1") {
						speEtu.removeAllItems();
						for(String str : tab1) 
							speEtu.addItem(str);	
					}
					if(nvxEtu.getSelectedItem() == "Licence-2" || nvxEtu.getSelectedItem() == "Licence-3" ) {
						speEtu.removeAllItems();
						for(String str : tab2) 
							
							speEtu.addItem(str);	
					}
					if(nvxEtu.getSelectedItem() == "Master-1" || nvxEtu.getSelectedItem() == "Master-2" ) {
						speEtu.removeAllItems();			
						for(String str : tab3) 
				
							speEtu.addItem(str);	
					}
		}
		if(e.getSource() == ajEtu) {
			String da = "2020-12-12";
			String da1 = "2020-12-12";
		   DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		   Date d = (Date) datePicker.getModel().getValue();
		   da = dateFormat.format(d);
		   Date d1 =  (Date) datePicker1.getModel().getValue();
		   da1 = dateFormat.format(d1);
		   String nom = nomEtu.getText() ; 
		   String pre = preEtu.getText() ; 
		   String mail = mailEtu.getText(); 
		   String mob = mobEtu.getText() ; 
		   String add = adrEtu.getText() ; 
		   String nvx = (String) nvxEtu.getSelectedItem() ;
		   String sp  = (String) speEtu.getSelectedItem(); 
           String ld = ldnEtu.getText();
		   if(nomEtu.getText().isBlank() == false && preEtu.getText().isBlank() == false && da.isBlank() == false && da1.isBlank() == false && mobEtu.getText().isBlank() == false && mailEtu.getText().isBlank() == false  && adrEtu.getText().isBlank()==false && ldnEtu.getText().isBlank() == false && nvxEtu.getSelectedItem().toString().isBlank() == false && speEtu.getSelectedItem().toString().isBlank() == false ) {
		    	connexionB.connect();
		    	
		    	if (v.isValidEmail(mail) == false || v.isValidnum(mob) == false || nom.length() < 4 || pre.length() < 4 || add.length() < 4 || ld.length() < 4) {
		    		
		    		JOptionPane.showMessageDialog(null, "Mail ou Num invalide / les donnés sont incorrects", "Erreur",
					JOptionPane.ERROR_MESSAGE);
					
				}
		    	else { 	
		    			
		    		
		    			int rep = JOptionPane.showConfirmDialog(null, nom + "\n" + pre + "\n" + mob + "\n" + mail + "\n" + add + "\n" + da + "\n" + ld + "\n" + da1 + "\n" + nvx + "--" + sp, "Information",
		    					JOptionPane.OK_CANCEL_OPTION);
		    			if(rep == 0) {
		    			int mat ; 
		    			String mpEtu = nom.replaceAll("\\s", "")+"."+pre.replaceAll("\\s", "") ; 
		    			connexionB.ajouterEtudiants(nom , pre, mob, mail, add , da, ld, da1 , nvx , sp , 1 , null , null);
		    			mat = connexionB.getMat(nom,"etudiants") ; 
		    			connexionB.ajouterUtilisateur(nom, mpEtu, 3 , mat);
		    			frameAjouter.dispose();	}
		    			else {
		    				JOptionPane.showMessageDialog(null, "D'accord", "Ok",
		    						JOptionPane.INFORMATION_MESSAGE);
						}
				}
			
			}
			else {
				JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
				JOptionPane.ERROR_MESSAGE);
			} 
			
		
			
		}
		
	
} 
   
	    
	 

	
	}
