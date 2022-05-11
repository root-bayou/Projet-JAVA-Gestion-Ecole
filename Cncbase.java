package imane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import java.sql.Date;


public class Cncbase {
	
	
	public Connection conn ; 

	public void connect() {
		String url = "jdbc:mysql://localhost:3308/test";
		String user = "root";
		String passwd = "";
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(url, user, passwd); }
		catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur");
		    System.exit(0);}
		
	}
	
	public boolean recherche(String nom , char[] mp , int d)  {
		boolean exist = false ;
		String motDePasse = String.valueOf(mp) ;
		String url = "jdbc:mysql://localhost:3308/test";
		String user = "root";
		String passwd = "";
		try {
		    Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(url, user, passwd);
		    Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery("SELECT * FROM utilisateur");
		    				while(result.next()){
		    					if(nom.intern() == result.getString("nom").intern() && motDePasse.intern() == result.getString("mp").intern() && d == result.getInt("droit")) {
		    						System.out.println(result.getString("nom") + nom.intern());
		    						System.out.println(result.getString("mp") + motDePasse.intern());
		    						exist = true ; 
		    						break;
		    					
		    					} 
		    					else {
		    						continue;
		    					}
		    					
		    					} 
		    					result.close();
		    					state.close();
		    System.out.println("Connecter"); 
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur");
		    System.exit(0);
		}
		return exist;
		
		
		
		
		
	}
	public void ajouterUtilisateur(String nom , String mp , int d , int mat) {
		try {
			
		    Statement state = conn.createStatement();
		    PreparedStatement p = conn.prepareStatement("insert into utilisateur values (default,? , ? , ?, ?, ?)");
		    if (d == 2) {
		    	
		    	 p.setInt(1, 0);
		    	 p.setInt(2, mat);
			}
		    else if (d == 3) {

		    	 p.setInt(1, mat);
		    	 p.setInt(2, 0);
			}
		    else {

		    	 p.setInt(1, 0);
		    	 p.setInt(2, 0);
			}
            p.setString(3, nom);
            p.setString(4, mp);
            p.setInt(5, d);
            p.executeUpdate();
            p.close();
            state.close();
		    System.out.println("Connecter"); 
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur");
		    System.exit(0);
		}
	}
	public void ajouterEtudiants(String nomEtu , String preEtu ,String numEtu , String addrMailEtu, String addEtu , String dateN , String ldnEtu , String dateI , String nvxEtu , String spEtu , int op , String id , String mp) {
			
			try {
			Statement state = conn.createStatement();
			if(op == 1) {
		    PreparedStatement p = conn.prepareStatement("insert into etudiants values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            p.setString(1, nomEtu);
            p.setString(2, preEtu);
            p.setString(3, addEtu);
            p.setString(4, numEtu);
            p.setString(5, addrMailEtu);
            p.setString(6,  dateN); 
            p.setString(7, ldnEtu);
            p.setString(8, dateI);
            p.setString(9, nvxEtu);
            p.setString(10, spEtu );
            p.executeUpdate();
            p.close();
            state.close(); }
			else { 
			  
				PreparedStatement p = conn.prepareStatement("UPDATE etudiants SET nom = ? , prenom = ? , adrr = ? , numtele = ? , adrrmail = ? , ddn = ? , ldn = ? , adi = ? , nvx = ? , specialite = ? WHERE id = "+id) ;
				   p.setString(1, nomEtu);
		            p.setString(2, preEtu);
		            p.setString(3, addEtu);
		            p.setString(4, numEtu);
		            p.setString(5, addrMailEtu);
		            p.setString(6,  dateN); 
		            p.setString(7, ldnEtu);
		            p.setString(8, dateI);
		            p.setString(9, nvxEtu);
		            p.setString(10, spEtu );
		            p.executeUpdate();
		            p.close(); 
		            PreparedStatement p1 = conn.prepareStatement("UPDATE utilisateur SET mp = ? WHERE mate = ? AND droit = 3") ; 
		        	p1.setString(1, mp);
					p1.setString(2, id);
					p1.executeUpdate() ;
		            state.close();
		            JOptionPane.showMessageDialog(null, "Mise a Jour Ok ", "Ok",
		            		JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (Exception e){
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
		    		JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	public void ajouterPro(String nomPro , String prePro ,String numPro , String addrMailPro, String addPro ,  String spPro , String dateN , int op , String id , String mp ) {
		
		try {
		
	    Statement state = conn.createStatement();
	    if(op == 1 ) {
	    PreparedStatement p = conn.prepareStatement("insert into prof values (default, ?, ?, ?, ?, ?, ?, ?)");
        p.setString(1, nomPro);
        p.setString(2, prePro);
        p.setString(3, addrMailPro);
        p.setString(4, numPro);
        p.setString(5, addPro);
        p.setString(6,  dateN); 
        p.setString(7, spPro);
        p.executeUpdate();
        p.close();
        state.close(); } 
	    else { 
	    	
	    	PreparedStatement p = conn.prepareStatement("UPDATE prof SET nom = ? , prenom = ? , mail = ? , num = ? , adr = ? , ddn = ? , spe = ? WHERE id = "+id);
	    	 p.setString(1, nomPro);
	         p.setString(2, prePro);
	         p.setString(3, addrMailPro);
	         p.setString(4, numPro);
	         p.setString(5, addPro);
	         p.setString(6,  dateN); 
	         p.setString(7, spPro);
	         p.executeUpdate();
	         p.close();
	         state.close();
	         PreparedStatement p1 = conn.prepareStatement("UPDATE utilisateur SET mp = ? WHERE matp = ? AND droit = 2") ; 
	        	p1.setString(1, mp);
				p1.setString(2, id);
				p1.executeUpdate() ;
	            state.close();
	            JOptionPane.showMessageDialog(null, "Mise a Jour Ok ", "Ok",
	            		JOptionPane.INFORMATION_MESSAGE);
	    	
	    }
	    
	} catch (Exception e){
	    e.printStackTrace();
		JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
		JOptionPane.ERROR_MESSAGE);
	  
	}
	
	
		
		
}	
	public boolean exiEm(int id) {
		boolean ex = false ;
		try {
			
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT id FROM emplois"); 
			while (rs.next()) {
				if (rs.getInt("id") == id) { 
					
					ex = true ;
					break ;
					
				}
				
			}
			
		    
	    
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur-aj");
		    System.exit(0);
		}
		
		return ex ; 
	}
	
	
	public void ajouterEmplois(int id , String[] tab) { 
		int k = 2;
		
		try {
			
			Statement state = conn.createStatement();
				PreparedStatement p = conn.prepareStatement("insert into emplois values (?, ?, ?, ?, ?, ?, ?, ?)"); 
		    	p.setInt(1, id); 
			    for (int j = 0; j < 7 ; j++) { 
			    	
			    	if (tab[j].isEmpty()) {
			    		
			    		tab[j] = "LIBRE" ; 
						
					}
			    
			    	p.setString(k, tab[j]);
				    k=k+1 ; 
					
					}
				p.executeUpdate();
			    p.close();
			    state.close(); 

	    
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur-aj");
		    System.exit(0);
		}
		
	}
	public void supEmplois(int id ) {
		
		try {
			
			Statement state = conn.createStatement(); 
			 String sql = "DELETE FROM emplois WHERE id ="+String.valueOf(id); 
			 state.executeUpdate(sql);
				
			
	    	
			
			
			
		    
	    
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur-aj");
		    System.exit(0);
		}
		
		
	}
	
	@SuppressWarnings("null")
	public String[][] getEmplois(int id) {
		
		
		String tab [][] = {
				{"//" , "//" , "//", "//", "//", "//" , "//"},
				{"//" , "//" , "//", "//", "//", "//" , "//"},
				{"//" , "//" , "//", "//", "//", "//" , "//"},
				{"//" ,"//" , "EMPLOIS" , "DU", "TEMPS", "VIDE", "//"  },
				{"//" , "//" , "//", "//", "//", "//" , "//"},
				{"//" , "//" , "//", "//", "//", "//" , "//"},
				{"//" , "//" , "//", "//", "//", "//" , "//"},
	}; 
		int k = 2 , i = 0;
		try {
		  Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery("SELECT * FROM emplois WHERE id ="+String.valueOf(id));
		    				while(result.next()){
		    					
		    					
									for (int j = 0; j < 7 ; j++) {
										tab[i][j] = result.getObject(k).toString() ;
										k++ ;
									}
									k = 2 ;
									i++ ;
		    					
		    					} 
		    					result.close();
		    					state.close();
		    System.out.println("Connecter"); 
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur");
		    System.exit(0);
		}
		
		return tab;
		
	} 
	public String [] getMde(String id) {
		connect();
		boolean existe = true ;
		String[] tab = new String[11];
		
		try {
			
			 
			 Statement state = conn.createStatement();
			 ResultSet result1 = state.executeQuery("SELECT mp FROM utilisateur WHERE mate ="+id);
				while(result1.next()){
					tab[0] = result1.getString("mp") ;
				}
			 ResultSet result = state.executeQuery("SELECT * FROM etudiants WHERE id ="+id);
			    				while(result.next()){
									tab[1] = result.getString("nom") ; 
									tab[2] = result.getString("prenom");
									tab[3] = result.getString("adrrmail");
									tab[4] = result.getString("numtele");
									tab[5] = result.getString("adrr");
									tab[6] = result.getString("ddn") ; 
									tab[7] = result.getString("ldn") ; 
									tab[8] = result.getString("adi");
									tab[9] = result.getString("nvx"); 
									tab[10] = result.getString("specialite"); }

			    				result.close();
			    				state.close();
			 
			
		} catch (Exception e) {
			 e.printStackTrace();
			    
		}
		return tab ;}
	
	
	
	public void getCompteEtu(String id) {
		connect();
		boolean existe = true ;
		try {
		    Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery("SELECT * FROM etudiants WHERE id ="+id);
		    				while(result.next()){
		    					existe = false ;
			    				JOptionPane.showMessageDialog(null, 
			    											"Matricule : "+result.getInt("id") + "\n" +
			    											"Nom : "+result.getString("nom")+ "\n" +
			    											"Prenom : " +result.getString("prenom") + "\n" + 
			    											"Mail : "+result.getString("adrrmail")+ "\n" + 
			    											"Mobile : "+result.getString("numtele")+"\n" + 
			    											"Adresse : "+result.getString("adrr")+ "\n" + 
			    											"Date De Naissance : "+result.getString("ddn")+ "\n" + 
			    											"Lieux De Naissance :"+result.getString("ldn")+ "\n" + 
			    											"Année D'inscription :"+result.getString("adi")+ "\n" +  
			    											"niveaux : "+result.getString("nvx")+ "\n" + 
			    											"Spécialité : "+result.getString("specialite")+ "\n" 
			    						, " "+result.getInt("id") +":"+result.getString("nom") ,
			    				JOptionPane.INFORMATION_MESSAGE); }
		    			
		    				
		    				result.close();
		    				state.close();
		    				if(existe) {
		    					  JOptionPane.showMessageDialog(null, "Matricule Incorrecte", "Erreur",
		    								JOptionPane.ERROR_MESSAGE);
		    				}
		} catch (Exception e){
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Matricule Incorrecte", "Erreur",
					JOptionPane.ERROR_MESSAGE);
		}
	
	} 	
	public void getCompteprof(String id) {
		connect();
		boolean existe = true ; 
		try {
		    Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery("SELECT * FROM prof WHERE id ="+id);
		    				while(result.next()){
		    					existe = false ;
			    				JOptionPane.showMessageDialog(null, 
			    											"Matricule : "+result.getInt("id") + "\n" +
			    											"Nom : "+result.getString("nom")+ "\n" +
			    											"Prenom : " +result.getString("prenom") + "\n" + 
			    											"Mail : "+result.getString("mail")+ "\n" + 
			    											"Mobile : "+result.getString("num")+"\n" + 
			    											"Adresse : "+result.getString("adr")+ "\n" + 
			    											"Date De Naissance : "+result.getString("ddn")+ "\n" +  
			    											"Spécialité : "+result.getString("spe")+ "\n" 
			    						, " "+result.getInt("id")+":"+result.getString("nom") ,
			    				JOptionPane.INFORMATION_MESSAGE); }
		    			
		    				
		    				result.close();
		    				state.close();
		    				if(existe) {
		    					  JOptionPane.showMessageDialog(null, "Matricule Incorrecte", "Erreur",
		    							  JOptionPane.ERROR_MESSAGE);
		    				}
		} catch (Exception e){
		    e.printStackTrace();
		    JOptionPane.showMessageDialog(null, "Matricule Incorrecte", "Erreur",
					JOptionPane.ERROR_MESSAGE);
		} 
	} 
	public String [] getMdf(String id) {
		connect();
		boolean existe = true ;
		String[] tab = new String[8];
		
		try {
			
			 
			 Statement state = conn.createStatement();
			 ResultSet result1 = state.executeQuery("SELECT mp FROM utilisateur WHERE matp ="+id);
				while(result1.next()){
					tab[0] = result1.getString("mp") ;
				}
			 ResultSet result = state.executeQuery("SELECT * FROM prof WHERE id ="+id);
			    				while(result.next()){
									tab[1] = result.getString("nom") ; 
									tab[2] = result.getString("prenom");
									tab[3] = result.getString("mail");
									tab[4] = result.getString("num");
									tab[5] = result.getString("adr");
									tab[6] = result.getString("ddn") ;  
									tab[7] = result.getString("spe"); }

			    				result.close();
			    				state.close();
			 
			
		} catch (Exception e) {
			 e.printStackTrace();
			    
		}
		
		
		
		
		
		
		
		
		
		return tab ;}
	
	public int getMat(String nom , String table) {
		
	
		int r = 0 ; 
		connect();
		try {
			
		  
		    Statement state = conn.createStatement();
		    PreparedStatement st = conn.prepareStatement("SELECT * FROM "+table+" WHERE nom=?");
		    st.setString(1,nom);
		    ResultSet result = st.executeQuery() ;
		    				while(result.next()){
		    					
		    						r = result.getInt("id") ;
		    					
		    					
		    					
		    					}
		    				
		    				
		    				result.close();
		    				state.close();
		} catch (Exception e){ 
		    e.printStackTrace();
		    System.out.println("Erreur getmat");
		    System.exit(0);
		} 
		
		return r;
		
		
	}
	
	public boolean supAdm(String nom , int droit ) { 
		boolean ex = false ; 
		connect();
		
		try {
			int id = 0 ;
		  
		    Statement state = conn.createStatement();
		    ResultSet result = state.executeQuery("SELECT * FROM utilisateur");
		    				while(result.next()){
		    					if (nom.intern() == result.getNString("nom").intern() && result.getInt("droit") == droit) {
		    						id  = result.getInt("id") ; 
		    						 ex = true ; 
		    						 break ; 
								} 
		    					else { 
		    						ex = false ; 
		    						continue ;
		    					}
		    				}
		    				
		    				if(ex) {
		    				 String sql = "DELETE FROM utilisateur WHERE id ="+String.valueOf(id); 
    						 state.executeUpdate(sql); 
    						 }
		    				
		    				
		    				result.close();
		    				state.close();
		} catch (Exception e){
		    e.printStackTrace();
		    System.out.println("Erreur");
		    System.exit(0);
		} 
		
		
		
		
		return ex;
	}
	public void supEtuPro(String mat , String tab) {
				connect();
				boolean r = false ; 
			  try {
				  Statement state = conn.createStatement() ; 
				  ResultSet result = state.executeQuery("SELECT * FROM "+tab);
				  while (result.next()) {
					
					  if (String.valueOf(result.getInt("id")).intern() == mat.intern() ) { 
						  r = true ; 
						  break ;
						
					}
					
				}
				  if (r) {
					  String sql1 ;
					  String sql = "DELETE FROM "+tab+" WHERE id ="+String.valueOf(mat); 
					  if(tab == "etudiants" ) {
						  sql1 = "DELETE FROM utilisateur WHERE mate ="+String.valueOf(mat); }
					  else {
						  sql1 = "DELETE FROM utilisateur WHERE matp ="+String.valueOf(mat);
					}
					  
					  int rep = JOptionPane.showConfirmDialog(null, "Voulez vous continuez ?", "information",
								JOptionPane.OK_CANCEL_OPTION);
					  if (rep == 0) {
						  state.executeUpdate(sql);
						  state.executeUpdate(sql1);
						  JOptionPane.showMessageDialog(null, "D'accord compte supprimer :) ", "information",
									JOptionPane.INFORMATION_MESSAGE);
					}
					  else {
							JOptionPane.showMessageDialog(null, "D'accord :) ", "information",
									JOptionPane.INFORMATION_MESSAGE);
					}
				}
				  else {
					   JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				  }
				 
				
			} catch (Exception e) {
			    e.printStackTrace();
			    JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
			    JOptionPane.ERROR_MESSAGE);
			}
			
			
		}
	public void modiferAdm(char[] mp , String nom , int droit) { 
		String mp1 = String.valueOf(mp);
		connect();
		try {
			PreparedStatement state = conn.prepareStatement("UPDATE utilisateur SET mp = ? WHERE nom = ? AND droit = "+String.valueOf(droit)) ;
			state.setString(1, mp1);
			state.setString(2, nom);
			state.executeUpdate() ; 
			state.close();
			JOptionPane.showMessageDialog(null, "OK :) ", "information",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			  JOptionPane.showMessageDialog(null, "iformation inccorect", "Erreur",
					  JOptionPane.ERROR_MESSAGE);
		}
	}
	
}