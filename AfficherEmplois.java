package imane;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

public class AfficherEmplois extends AjouterEmplois {

	private JFrame frame; 
	private Cncbase cm = new Cncbase();
	

	
	public AfficherEmplois(String nom , String spec , int u) {
		super(nom , null , 1) ;
		initialize(nom);
		cm.connect();
		String id = (String) spec.subSequence(spec.length() - 2, spec.length());
		int i1 = Integer.valueOf(id).intValue();
		String[][] tab = cm.getEmplois(i1) ; 
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(tab[i][j]+"\t");
			}
			System.out.println();
		}
		lblNewLabel_8.setText(" ");
		
		System.out.println(spe.getSelectedIndex());
		
		
		if (u == 1 ) {
			
			spe.removeAllItems();
			spe.addItem(spec);
			spe.setEditable(false);
			
		
			btnAjouter.removeAll();
			btnAjouter.setText(null);
			btnAjouter.removeActionListener(this);

			textField.setText(tab[0][1]);
			textField.setDisabledTextColor(Color.BLACK);
			textField.setEditable(false);
			
			textField_1.setText(tab[0][2]);
			textField_1.setDisabledTextColor(Color.BLACK);
			textField_1.setEditable(false);
			
			textField_2.setText(tab[0][3]);
			textField_2.setDisabledTextColor(Color.BLACK);
			textField_2.setEditable(false);
			
			textField_3.setText(tab[0][4]);
			textField_3.setDisabledTextColor(Color.BLACK);
			textField_3.setEditable(false);
			
			textField_4.setText(tab[0][5]);
			textField_4.setDisabledTextColor(Color.BLACK);
			textField_4.setEditable(false);
			
			textField_5.setText(tab[0][6]);
			textField_5.setDisabledTextColor(Color.BLACK);
			textField_5.setEditable(false);
			
			textField_6.setText(tab[1][1]);
			textField_6.setDisabledTextColor(Color.BLACK);
			textField_6.setEditable(false);
			
			textField_7.setText(tab[1][2]);
			textField_7.setDisabledTextColor(Color.BLACK);
			textField_7.setEditable(false);
			
			textField_8.setText(tab[1][3]);
			textField_8.setDisabledTextColor(Color.BLACK);
			textField_8.setEditable(false);
			
			textField_9.setText(tab[1][4]);
			textField_9.setDisabledTextColor(Color.BLACK);
			textField_9.setEditable(false);
			
			textField_10.setText(tab[1][5]);
			textField_10.setDisabledTextColor(Color.BLACK);
			textField_10.setEditable(false);
			
			textField_11.setText(tab[1][6]);
			textField_11.setDisabledTextColor(Color.BLACK);
			textField_11.setEditable(false);
			
			textField_12.setText(tab[2][1]);
			textField_12.setDisabledTextColor(Color.BLACK);
			textField_12.setEditable(false);
			
			textField_13.setText(tab[2][2]);
			textField_13.setDisabledTextColor(Color.BLACK);
			textField_13.setEditable(false);
			
			textField_14.setText(tab[2][3]);
			textField_14.setDisabledTextColor(Color.BLACK);
			textField_14.setEditable(false);
			
			textField_15.setText(tab[2][4]);
			textField_15.setDisabledTextColor(Color.BLACK);
			textField_15.setEditable(false);
			
			textField_16.setText(tab[2][5]);
			textField_16.setDisabledTextColor(Color.BLACK);
			textField_16.setEditable(false);
			
			textField_17.setText(tab[2][6]);
			textField_17.setDisabledTextColor(Color.BLACK);
			textField_17.setEditable(false);
			
			textField_18.setText(tab[3][1]);
			textField_18.setDisabledTextColor(Color.BLACK);
			textField_18.setEditable(false);
			
			textField_19.setText(tab[3][2]);
			textField_19.setDisabledTextColor(Color.BLACK);
			textField_19.setEditable(false);
			
			textField_20.setText(tab[3][3]);
			textField_20.setDisabledTextColor(Color.BLACK);
			textField_20.setEditable(false);
			
		
			
			textField_21.setText(tab[3][4]);
			textField_21.setDisabledTextColor(Color.BLACK);
			textField_21.setEditable(false);
			
			textField_22.setText(tab[3][5]);
			textField_22.setDisabledTextColor(Color.BLACK);
			textField_22.setEditable(false);
			
			textField_23.setText(tab[3][6]);
			textField_23.setDisabledTextColor(Color.BLACK);
			textField_23.setEditable(false);
			
			textField_24.setText(tab[4][1]);
			textField_24.setDisabledTextColor(Color.BLACK);
			textField_24.setEditable(false);
			
			textField_25.setText(tab[4][2]);
			textField_25.setDisabledTextColor(Color.BLACK);
			textField_25.setEditable(false);
			
			textField_26.setText(tab[4][3]);
			textField_26.setDisabledTextColor(Color.BLACK);
			textField_26.setEditable(false);
			
			textField_27.setText(tab[4][4]);
			textField_27.setDisabledTextColor(Color.BLACK);
			textField_27.setEditable(false);
			
			textField_28.setText(tab[4][5]);
			textField_28.setDisabledTextColor(Color.BLACK);
			textField_28.setEditable(false);
			
			textField_29.setText(tab[4][6]);
			textField_29.setDisabledTextColor(Color.BLACK);
			textField_29.setEditable(false);
			
			textField_30.setText(tab[5][1]);
			textField_30.setDisabledTextColor(Color.BLACK);
			textField_30.setEditable(false);
			
			textField_31.setText(tab[5][2]);
			textField_31.setDisabledTextColor(Color.BLACK);
			textField_31.setEditable(false);
			
			textField_32.setText(tab[5][3]);
			textField_32.setDisabledTextColor(Color.BLACK);
			textField_32.setEditable(false);
			
			textField_33.setText(tab[5][4]);
			textField_33.setDisabledTextColor(Color.BLACK);
			textField_33.setEditable(false);
			
			textField_34.setText(tab[5][5]);
			textField_34.setDisabledTextColor(Color.BLACK);
			textField_34.setEditable(false);
			
			textField_35.setText(tab[5][6]);
			textField_35.setDisabledTextColor(Color.BLACK);
			textField_35.setEditable(false);
			
			textField_36.setText(tab[6][1]);
			textField_36.setDisabledTextColor(Color.BLACK);
			textField_36.setEditable(false);
			
			textField_37.setText(tab[6][2]);
			textField_37.setDisabledTextColor(Color.BLACK);
			textField_37.setEditable(false);
			
			textField_38.setText(tab[6][3]);
			textField_38.setDisabledTextColor(Color.BLACK);
			textField_38.setEditable(false);
			
			textField_39.setText(tab[6][4]);
			textField_39.setDisabledTextColor(Color.BLACK);
			textField_39.setEditable(false);
			
			textField_40.setText(tab[6][5]);
			textField_40.setDisabledTextColor(Color.BLACK);
			textField_40.setEditable(false);
			
			textField_41.setText(tab[6][6]);
			textField_41.setDisabledTextColor(Color.BLACK);
			textField_41.setEditable(false); 
		}
		else {
			spe.removeAllItems();
			spe.addItem(spec);
			spe.setEditable(false);
			
		
			btnAjouter.setText("Mise A Jour");
		

			textField.setText(tab[0][1]);
			textField.setDisabledTextColor(Color.BLACK);
			
			
			textField_1.setText(tab[0][2]);
			textField_1.setDisabledTextColor(Color.BLACK);
	
			
			textField_2.setText(tab[0][3]);
			textField_2.setDisabledTextColor(Color.BLACK);
		
			
			textField_3.setText(tab[0][4]);
			textField_3.setDisabledTextColor(Color.BLACK);
		
			
			textField_4.setText(tab[0][5]);
			textField_4.setDisabledTextColor(Color.BLACK);
	
			
			textField_5.setText(tab[0][6]);
			textField_5.setDisabledTextColor(Color.BLACK);
		
			
			textField_6.setText(tab[1][1]);
			textField_6.setDisabledTextColor(Color.BLACK);
		
			
			textField_7.setText(tab[1][2]);
			textField_7.setDisabledTextColor(Color.BLACK);
		
			
			textField_8.setText(tab[1][3]);
			textField_8.setDisabledTextColor(Color.BLACK);
		
			
			textField_9.setText(tab[1][4]);
			textField_9.setDisabledTextColor(Color.BLACK);
		
			
			textField_10.setText(tab[1][5]);
			textField_10.setDisabledTextColor(Color.BLACK);
		
			
			textField_11.setText(tab[1][6]);
			textField_11.setDisabledTextColor(Color.BLACK);
		
			
			textField_12.setText(tab[2][1]);
			textField_12.setDisabledTextColor(Color.BLACK);
			
			
			textField_13.setText(tab[2][2]);
			textField_13.setDisabledTextColor(Color.BLACK);

			
			textField_14.setText(tab[2][3]);
			textField_14.setDisabledTextColor(Color.BLACK);
		
			
			textField_15.setText(tab[2][4]);
			textField_15.setDisabledTextColor(Color.BLACK);
		
			
			textField_16.setText(tab[2][5]);
			textField_16.setDisabledTextColor(Color.BLACK);
		
			
			textField_17.setText(tab[2][6]);
			textField_17.setDisabledTextColor(Color.BLACK);
		
			
			textField_18.setText(tab[3][1]);
			textField_18.setDisabledTextColor(Color.BLACK);
		
			
			textField_19.setText(tab[3][2]);
			textField_19.setDisabledTextColor(Color.BLACK);
	
			
			textField_20.setText(tab[3][3]);
			textField_20.setDisabledTextColor(Color.BLACK);
	
			
		
			
			textField_21.setText(tab[3][4]);
			textField_21.setDisabledTextColor(Color.BLACK);
		
			
			textField_22.setText(tab[3][5]);
			textField_22.setDisabledTextColor(Color.BLACK);
	
			
			textField_23.setText(tab[3][6]);
			textField_23.setDisabledTextColor(Color.BLACK);
		
			
			textField_24.setText(tab[4][1]);
			textField_24.setDisabledTextColor(Color.BLACK);
	
			
			textField_25.setText(tab[4][2]);
			textField_25.setDisabledTextColor(Color.BLACK);
		
			
			textField_26.setText(tab[4][3]);
			textField_26.setDisabledTextColor(Color.BLACK);
	
			
			textField_27.setText(tab[4][4]);
			textField_27.setDisabledTextColor(Color.BLACK);
	
			
			textField_28.setText(tab[4][5]);
			textField_28.setDisabledTextColor(Color.BLACK);

			
			textField_29.setText(tab[4][6]);
			textField_29.setDisabledTextColor(Color.BLACK);
			
			
			textField_30.setText(tab[5][1]);
			textField_30.setDisabledTextColor(Color.BLACK);
		
			
			textField_31.setText(tab[5][2]);
			textField_31.setDisabledTextColor(Color.BLACK);
		
			
			textField_32.setText(tab[5][3]);
			textField_32.setDisabledTextColor(Color.BLACK);
		
			
			textField_33.setText(tab[5][4]);
			textField_33.setDisabledTextColor(Color.BLACK);
	
			textField_34.setText(tab[5][5]);
			textField_34.setDisabledTextColor(Color.BLACK);
		
			
			textField_35.setText(tab[5][6]);
			textField_35.setDisabledTextColor(Color.BLACK);
		
			
			textField_36.setText(tab[6][1]);
			textField_36.setDisabledTextColor(Color.BLACK);
		
			
			textField_37.setText(tab[6][2]);
			textField_37.setDisabledTextColor(Color.BLACK);
	
			
			textField_38.setText(tab[6][3]);
			textField_38.setDisabledTextColor(Color.BLACK);
		
			
			textField_39.setText(tab[6][4]);
			textField_39.setDisabledTextColor(Color.BLACK);
		
			
			textField_40.setText(tab[6][5]);
			textField_40.setDisabledTextColor(Color.BLACK);
		
			
			textField_41.setText(tab[6][6]);
			textField_41.setDisabledTextColor(Color.BLACK);
		
		}
	}

	private void initialize(String nom) {
		
	
	}

}
