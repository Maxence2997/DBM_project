package test;

import java.awt.EventQueue;

public class Main {
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				  
				
				
				try {
					Project_test window = new Project_test();
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
