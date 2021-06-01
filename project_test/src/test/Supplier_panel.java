package test;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

public class Supplier_panel {
		
	/**
     * @autohr Jyun-An
     * @ver. 1.2.2 05/28   
     * Seperated from Project_test
     **/
	
	
		private JPanel supplier_panel;
		private JTextField text_sup_supID;
		private JTextField text_sup_name;
		private JTable sup_table;
		private JScrollPane scrollpane;
	
	//supplier panel variables needed for comboBox actionListener
		private String supplierFunction;
		private JLabel lbl_sup_addr;
		private JLabel lbl_sup_ctc;
		private JLabel lbl_sup_mobile;
		private JLabel lbl_sup_mail;
		private JComboBox comboBox_sup;
		private JButton btn_sup_inquire;
		private JButton btn_sup_add;
		private JButton btn_sup_delete;
		private JTextField text_sup_addr;
		private JTextField text_sup_ctc;
		private JTextField text_sup_mobile;
		private JTextField text_sup_mail;
		
		private DefaultTableModel table_model;
		private DefaultTableModel sup_table_model;
	
	public Supplier_panel() {
		
		panel();
	}
	
	
	
	
	private void panel() {
		
		/*
		 *  New version GUI by Ray
		 * 05/27/2021
		 */
		
		supplier_panel = new JPanel();
		Term_project_main.container_panel.add(supplier_panel,"supplier");
		
		comboBox_sup = new JComboBox();
		comboBox_sup.setBounds(266, 4, 135, 27);
		comboBox_sup.setModel(new DefaultComboBoxModel(new String[] {"Inquire", "Maintenance"}));
		supplierFunction = (String) comboBox_sup.getSelectedItem();
		comboBox_sup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	supplierFunction = (String) comboBox_sup.getSelectedItem();
            	
            	if (supplierFunction.equals("Inquire")) {
            		//visibility
            		btn_sup_inquire.setVisible(true);
            		btn_sup_add.setVisible(false);
            		btn_sup_delete.setVisible(false);
            		
            		lbl_sup_addr.setVisible(false);
            		text_sup_addr.setVisible(false);
            		
            		lbl_sup_ctc.setVisible(false);
            		text_sup_ctc.setVisible(false);
            		
            		lbl_sup_mobile.setVisible(false);
            		text_sup_mobile.setVisible(false);
            		
            		lbl_sup_mail.setVisible(false);
            		text_sup_mail.setVisible(false);
            		//textField
            		clear_text();
            	}
            	else if (supplierFunction.equals("Maintenance")) {
            		//visibility
            		btn_sup_inquire.setVisible(false);
            		btn_sup_add.setVisible(true);
            		btn_sup_delete.setVisible(true);
            		
            		lbl_sup_addr.setVisible(true);
            		text_sup_addr.setVisible(true);
            		
            		lbl_sup_ctc.setVisible(true);
            		text_sup_ctc.setVisible(true);
            		
            		lbl_sup_mobile.setVisible(true);
            		text_sup_mobile.setVisible(true);
            		
            		lbl_sup_mail.setVisible(true);
            		text_sup_mail.setVisible(true);
            		//textField
            		clear_text();
            	}
            }
        });
		supplier_panel.setLayout(null);
		supplier_panel.add(comboBox_sup);
		
		JLabel lbl_sup_supID = new JLabel("Supplier ID :");
		lbl_sup_supID.setBounds(160, 55, 77, 16);
		lbl_sup_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		supplier_panel.add(lbl_sup_supID);
		
		text_sup_supID = new JTextField();
		text_sup_supID.setBounds(245, 50, 178, 26);
		supplier_panel.add(text_sup_supID);
		text_sup_supID.setColumns(14);
		
		JLabel lbl_sup_name = new JLabel("Supplier Name :");
		lbl_sup_name.setBounds(138, 81, 99, 16);
		supplier_panel.add(lbl_sup_name);
		
		text_sup_name = new JTextField();
		text_sup_name.setBounds(245, 76, 178, 26);
		supplier_panel.add(text_sup_name);
		text_sup_name.setColumns(14);
		
		btn_sup_inquire = new JButton("Inquire");
		btn_sup_inquire.setBounds(491, 76, 88, 26);
		btn_sup_inquire.setVisible(true);
		btn_sup_inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String [] table_test_data = {"SP0000002", "Q-TIP", "Taoyuan", "Smith", "(02)25450002", "supplier002@gmail.com"};
				
				String [] temp = inquire();					//if want to test table without DB, mark from this line until whole if-else

				if (temp.length != 0){ // found data match

					sup_table_model.addRow(temp);
					sup_table.setVisible(true); 
					scrollpane.setVisible(true);
				}  											
//				sup_table_model.addRow(table_test_data); //for test table
//				sup_table.setVisible(true); 
//				scrollpane.setVisible(true);
				else {
					//no found data match 
				}
			}
		});
		supplier_panel.add(btn_sup_inquire);
		
		lbl_sup_addr = new JLabel("Address :");
		lbl_sup_addr.setBounds(178, 107, 59, 16);
		lbl_sup_addr.setVisible(false);
		supplier_panel.add(lbl_sup_addr);
		
		text_sup_addr = new JTextField();
		text_sup_addr.setBounds(245, 102, 178, 26);
		text_sup_addr.setVisible(false);
		supplier_panel.add(text_sup_addr);
		text_sup_addr.setColumns(14);
		
		lbl_sup_ctc = new JLabel("Contact :");
		lbl_sup_ctc.setBounds(180, 133, 57, 16);
		lbl_sup_ctc.setVisible(false);
		supplier_panel.add(lbl_sup_ctc);
		
		text_sup_ctc = new JTextField();
		text_sup_ctc.setBounds(245, 128, 178, 26);
		text_sup_ctc.setVisible(false);
		supplier_panel.add(text_sup_ctc);
		text_sup_ctc.setColumns(14);
		
		lbl_sup_mobile = new JLabel("Mobile :");
		lbl_sup_mobile.setBounds(187, 159, 50, 16);
		lbl_sup_mobile.setVisible(false);
		supplier_panel.add(lbl_sup_mobile);
		
		text_sup_mobile = new JTextField();
		text_sup_mobile.setBounds(245, 154, 178, 26);
		text_sup_mobile.setVisible(false);
		supplier_panel.add(text_sup_mobile);
		text_sup_mobile.setColumns(14);
		
		lbl_sup_mail = new JLabel("Mail :");
		lbl_sup_mail.setBounds(203, 186, 34, 16);
		lbl_sup_mail.setVisible(false);
		
		btn_sup_add = new JButton("Add");
		btn_sup_add.setBounds(491, 154, 75, 26);
		btn_sup_add.setVisible(false);
		btn_sup_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (add()==1) {
					//set message to let user know it succeed. 
				}
				else {
					//set message to let user know it failed. 
				}
			}
		});
		supplier_panel.add(btn_sup_add);
		supplier_panel.add(lbl_sup_mail);
		
		text_sup_mail = new JTextField();
		text_sup_mail.setBounds(245, 181, 178, 26);
		text_sup_mail.setVisible(false);
		supplier_panel.add(text_sup_mail);
		text_sup_mail.setColumns(14);
		
		btn_sup_delete = new JButton("Delete");
		btn_sup_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (delete()==1) {
					//set message to let user know it succeed. 
				}
				else {
					//set message to let user know it failed. 
				}
			}
		});
		btn_sup_delete.setBounds(491, 180, 84, 29);
		btn_sup_delete.setVisible(false);
		supplier_panel.add(btn_sup_delete);
		
		String[] column_names = { "Supplier_ID", "Supplier_name", "Supplier_Address", "Contact_name", "Contact_mobile",
		"Contact_email"};
		
		sup_table_model = new DefaultTableModel();
		for(int i=0; i<6; i++) {
			sup_table_model.addColumn(column_names[i]);
		}
		
		
		sup_table = new JTable(sup_table_model){ 
			
			@Override
			public boolean isCellEditable(int row, int column)
            {
                                  return false;}//uneditable
            
			}; 
		sup_table.setBounds(48, 263, 563, 100);
		sup_table.getColumn("Contact_email").setWidth(100);;
		sup_table.setVisible(false);
		supplier_panel.add(sup_table);
		
		
		scrollpane = new JScrollPane(sup_table,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(48, 288, 563, 50);
		scrollpane.setVisible(false);
		supplier_panel.add(scrollpane);
		
		
		
		
		
	}
	
	
	private void clear_text() {
		/** @Author Ray
		 *  @since 05/31
		 *  clear all input in JTextField
		 **/
		text_sup_supID.setText("");
		text_sup_name.setText("");
		text_sup_addr.setText("");
		text_sup_ctc.setText("");
		text_sup_mobile.setText("");
		text_sup_mail.setText("");
	}
	
	private String[] inquire() {
		/** 
		 * @Author jyun-an
		 *  @since 06/01
		 *  to inquire data in SUPPLIER table 
		 **/
		
		String [] temp = new String[6];
		
		if (!(text_sup_supID.getText().isEmpty())){
//			System.out.println("IN1");
			if(!(text_sup_name.getText().isEmpty())) {
//				System.out.println("IN1-1");
				try {
					ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM SUPPLIER WHERE (Supplier_ID=\'" + 
											text_sup_supID.getText()+"\' AND Supplier_name=\'" +text_sup_name.getText()+"\')");
					if(resultSet.next()) {
						
						
//						System.out.println(resultSet.getString("Supplier_ID") + "    " + resultSet.getString(
//								"Supplier_name") + "   " + resultSet.getString("Supplier_Address") + "   " + resultSet.getString("Contact_name") 
//								+ "   " + resultSet.getString("Contact_mobile") + "   " + resultSet.getString("Contact_email"));
						
						for(int i = 1; i<7; i++) {
							temp[i-1]= resultSet.getString(i);
						}
						return temp;
					}
					return temp;
					
					
					}catch (SQLException e) {
						
					// TODO Auto-generated catch block
						e.printStackTrace();
						return temp;
					}
			}else{
//				System.out.println("IN1-2");
				try {
					ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM SUPPLIER WHERE Supplier_ID=\'" 
											+ text_sup_supID.getText() +"\'");
//					System.out.println("SELECT * FROM SUPPLIER WHERE Supplier_ID=\'" 
//							+ text_sup_supID.getText() +"\'");
					if(resultSet.next()) {
						
//						System.out.println(resultSet.getString("Supplier_ID") + "    " + resultSet.getString(
//								"Supplier_name") + "   " + resultSet.getString("Supplier_Address") + "   " + resultSet.getString("Contact_name") 
//								+ "   " + resultSet.getString("Contact_mobile") + "   " + resultSet.getString("Contact_email"));
						
						for(int i = 1; i<7; i++) {
							temp[i-1]= resultSet.getString(i);
						}
						return temp;
					}
					return temp;
				
					
					}catch (SQLException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
						return temp;
				}			
			}	
		}else if (!(text_sup_name.getText().isEmpty())){
//			System.out.println("IN2");
			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM SUPPLIER WHERE Supplier_name=\'" + 
											text_sup_name.getText()+"\'");
				if(resultSet.next()) {
					
//					System.out.println(resultSet.getString("Supplier_ID") + "    " + resultSet.getString(
//							"Supplier_name") + "   " + resultSet.getString("Supplier_Address") + "   " + resultSet.getString("Contact_name") 
//							+ "   " + resultSet.getString("Contact_mobile") + "   " + resultSet.getString("Contact_email"));
					
					for(int i = 1; i<7; i++) {
						temp[i-1]= resultSet.getString(i);
					}
					return temp;
				}
				return temp;

				}catch (SQLException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
					return temp;
				}
		}
		System.out.println("out");
		return temp;
		
	}
	
	
	
	private int add() {
		/** 
		 * @Author jyun-an
		 *  @since 06/01
		 *  to ADD data in SUPPLIER table
		 **/
		int resultSet=0;
		try {
			resultSet = Term_project_main.conn.st.executeUpdate("INSERT INTO SUPPLIER(Supplier_ID, Supplier_name, Supplier_address, "
					+ "Contact_name, Contact_mobile, Contact_email) VALUE (\'"+ get_new_supID()+"\', \'"+text_sup_name.getText()+"\', \'"+
					text_sup_addr.getText()+"\', \'"+ text_sup_ctc.getText()+"\', \'"+
					text_sup_mobile.getText()+"\', \'"+text_sup_mail.getText()+"\')");
//			System.out.print("INSERT INTO SUPPLIER(Supplier_ID, Supplier_name, Supplier_address, "
//					+ "Contact_name, Contact_mobile, Contact_email) VALUE (\'"+ get_new_supID()+"\', \'"+text_sup_name.getText()+"\', \'"+
//					text_sup_addr.getText()+"\', \'"+ text_sup_ctc.getText()+"\', \'"+
//					text_sup_mobile.getText()+"\', \'"+text_sup_mail.getText()+"\')");
			return 	resultSet;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 	resultSet;	
		}
	}
	
	private String get_new_supID() {
		/** 
		 * @Author jyun-an
		 *  @since 06/01
		 *  to get the last ID in  SUPPLIER table and product next one.
		 **/
		
		String new_ID = "";
		try {
			ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT Supplier_ID FROM SUPPLIER  ORDER  BY Supplier_ID DESC");
			if (resultSet.next()) {
				
			String previous = resultSet.getString(1);
		    new_ID = "SP" + String.format("%07d", (Integer.parseInt(previous.substring(2,previous.length()))+1));
		   // System.out.println(new_ID);
		    return new_ID;
			}
			return new_ID;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new_ID;
		}
		
	}
	
	
	private int delete() {
		/** 
		 * @Author jyun-an
		 *  @since 06/01
		 *  to delete data in  SUPPLIER table and product next one.
		 **/
		
		int resultSet=0;
		try {
			resultSet = Term_project_main.conn.st.executeUpdate("DELETE FROM SUPPLIER WHERE Supplier_ID=\'" + text_sup_supID.getText()+"\'");
//			System.out.print("INSERT INTO SUPPLIER(Supplier_ID, Supplier_name, Supplier_address, "
//					+ "Contact_name, Contact_mobile, Contact_email) VALUE (\'"+ get_new_supID()+"\', \'"+text_sup_name.getText()+"\', \'"+
//					text_sup_addr.getText()+"\', \'"+ text_sup_ctc.getText()+"\', \'"+
//					text_sup_mobile.getText()+"\', \'"+text_sup_mail.getText()+"\')");
			return 	resultSet;	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 	resultSet;	
		}
	}
	
	
	public JComboBox get_combobox_sup() {
		
		return comboBox_sup;
	}
	
	public JTextField get_text_sup_supID() {
		
		return text_sup_supID;
	}
	
	public JTextField get_text_sup_name() {
		
		return text_sup_name;
	}
	
	public JTextField get_text_sup_addr() {
		
		return text_sup_addr;
	}
	
	public JTextField get_text_sup_ctc() {
		
		return text_sup_ctc;
	}
	
	public JTextField get_text_sup_mobile() {
		
		return text_sup_mobile;
	}
	
	public JTextField get_text_sup_mail() {
		
		return text_sup_mail;
	}
	
	public JTable get_sup_table() {
		
		return sup_table;
	}
}
