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
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class Progect_test {

	private JFrame frame;
	
	private JPanel loginPanel;
	private JPanel empPanel;
	private JPanel superVPanel;
	private CardLayout cardLayout;
	private JLabel label_empID;
	private JTextField field_empID;
	private JLabel label_id;
	private JTextField text_orfer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	
	
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
		frame.setBounds(100, 100, 666, 466);
		
		cardLayout = new CardLayout();
		
		frame.getContentPane().setLayout(cardLayout);
		
		
		loginPanel();
		empPanel();
		superVPanel();
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		private boolean verification(JTextField field_empID2) {
			/** To Verify if the ID inputed by user is registered in EMPLOYEE or not
			 **/
			
				
			
			return false;
		}
		
		private void loginPanel() {
			
			
			loginPanel = new JPanel();
			frame.getContentPane().add(loginPanel,"login");
			loginPanel.setLayout(null);
			
			
			label_empID = new JLabel("Employee ID :");
			label_empID.setBounds(100, 191, 104, 16);
			loginPanel.add(label_empID);
			
			field_empID = new JTextField();
			field_empID.setBounds(229, 186, 163, 26);
			loginPanel.add(field_empID);
			field_empID.setColumns(10);
			
			JLabel login_result = new JLabel("");
			login_result.setBounds(201, 245, 245, 26);
			loginPanel.add(login_result);
			
			
			JButton button_login = new JButton("Log-in");
			button_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					if (verification(field_empID) == false){
						
						login_result.setText("Employee ID is invalid, please refill it.");
					}
					else {
						cardLayout.show(frame.getContentPane(), "employee");
					}
				}
				
				
			});
			button_login.setBounds(421, 186, 117, 29);
			loginPanel.add(button_login);
			
			
		}
		
		
		private void empPanel() {
			
			empPanel = new JPanel();
			frame.getContentPane().add(empPanel, "employee");
			empPanel.setLayout(null);
			
			label_id = new JLabel("Employee ID: " + field_empID.getText());
			label_id.setBounds(6, 6, 168, 16);
			empPanel.add(label_id);
			
			
			JButton btn_logout = new JButton("Log-out");
			btn_logout.setBounds(6, 403, 96, 29);
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(frame.getContentPane(),"login");
				}
			});
			
			empPanel.add(btn_logout);
			
			JButton button_order = new JButton("Order Management");
			button_order.setBounds(63, 73, 154, 29);
			empPanel.add(button_order);
			
			JButton btnSupplier = new JButton("Supplier");
			btnSupplier.setBounds(63, 138, 154, 29);
			empPanel.add(btnSupplier);
			
			JButton btnInventory = new JButton("Inventory");
			btnInventory.setBounds(63, 214, 154, 29);
			empPanel.add(btnInventory);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(63, 283, 154, 29);
			empPanel.add(btnNewButton);
			
			text_orfer = new JTextField();
			text_orfer.setBounds(265, 67, 331, 38);
			empPanel.add(text_orfer);
			text_orfer.setColumns(10);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(265, 132, 331, 38);
			empPanel.add(textField);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(265, 205, 331, 38);
			empPanel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(265, 274, 331, 38);
			empPanel.add(textField_2);
		}
		
		private void superVPanel() {
			
			superVPanel = new JPanel();
			frame.getContentPane().add(superVPanel,"supervisor");
			superVPanel.setLayout(null);
			
			label_id = new JLabel("Employee ID: " + field_empID.getText());
			label_id.setBounds(6, 10, 86, 16);
			superVPanel.add(label_id);
			
			
			JButton btn_logout = new JButton("Log-out");
			btn_logout.setBounds(6, 403, 96, 29);
			btn_logout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cardLayout.show(frame.getContentPane(),"login");
				}
			});
			
			superVPanel.add(btn_logout);
			
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(257, 271, 331, 38);
			superVPanel.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(257, 202, 331, 38);
			superVPanel.add(textField_4);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(257, 129, 331, 38);
			superVPanel.add(textField_5);
			
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(257, 64, 331, 38);
			superVPanel.add(textField_6);
			
			JButton button_order = new JButton("Order Management");
			button_order.setBounds(55, 70, 154, 29);
			superVPanel.add(button_order);
			
			JButton btnSupplier = new JButton("Supplier");
			btnSupplier.setBounds(55, 135, 154, 29);
			superVPanel.add(btnSupplier);
			
			JButton btnInventory = new JButton("Inventory");
			btnInventory.setBounds(55, 211, 154, 29);
			superVPanel.add(btnInventory);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(55, 280, 154, 29);
			superVPanel.add(btnNewButton);
			
		}
}
