package imane;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.fabric.xmlrpc.base.Data;



public class pJava {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Autentification	window = new Autentification(); 
						
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			
			}
		});
		
		
		
	}
}	