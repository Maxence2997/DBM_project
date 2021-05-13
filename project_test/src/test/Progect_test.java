package test;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Progect_test {

	private JFrame frame;
	
	private JPanel loginPanel;
	private JPanel empPanel;
	private JPanel superVPanel;
	//private CardLayout cardLayout;
	private JLabel label_empID;
	private JTextField field_empID;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Progect_test window = new Progect_test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Progect_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("System");
		frame.setBounds(100, 100, 450, 300);
		
		loginPanel = new JPanel();
		superVPanel = new JPanel();
		//cardLayout = new CardLayout();
		
		
		frame.getContentPane().setLayout(new CardLayout());
		
	
		
		frame.getContentPane().add(loginPanel,"login");
		loginPanel.setLayout(null);
		
		label_empID = new JLabel("Employee ID :");
		label_empID.setBounds(47, 114, 104, 16);
		loginPanel.add(label_empID);
		
		field_empID = new JTextField();
		field_empID.setBounds(148, 109, 130, 26);
		loginPanel.add(field_empID);
		field_empID.setColumns(10);
		
		JButton button_login = new JButton("Lon-in");
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
			/** To Verify if the ID inputed by user is registered in EMPLOYEE or not
			 **/
			
		});
		button_login.setBounds(286, 109, 117, 29);
		loginPanel.add(button_login);
		empPanel = new JPanel();
		
		frame.getContentPane().add(empPanel, "employee");
		frame.getContentPane().add(superVPanel,"supervisor");
		//cardLayout.show(loginPanel,"login");

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
}
