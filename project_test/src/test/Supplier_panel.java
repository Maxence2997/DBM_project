package test;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import javax.swing.table.TableColumnModel;
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
		
		
		private DefaultTableModel sup_table_model;
		private JLabel lbl_result;
	
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
				
//				String [][] temp = {{"SP0000002", "Q-TIP", "Taoyuan", "Smith", "(02)25450002", 
//													"supplier002@gmail.com"}};  // for testing without connection
				
				String[] column_names = { "SupplierID", "Name", "Address", "Contact", "Mobile",
											"Email"};
				String [][] temp = inquire(text_sup_supID,text_sup_name);					//if want to test table without DB, mark from this line until whole if-else

				if (temp.length == 0){ // found data match
					scrollpane.setVisible(false);
					lbl_result.setVisible(false);
					lbl_result.setVisible(true);
					lbl_result.setText("No found");
					
				}else {
					sup_table_model = new DefaultTableModel(temp,column_names);

					sup_table.setModel(sup_table_model);
					
					TableColumnModel column_model = sup_table.getColumnModel();
					column_model.getColumn(0).setPreferredWidth(50);
					column_model.getColumn(1).setPreferredWidth(50);
					column_model.getColumn(2).setPreferredWidth(50);
					column_model.getColumn(3).setPreferredWidth(40);
					column_model.getColumn(4).setPreferredWidth(60);
					column_model.getColumn(5).setPreferredWidth(120);
					
					sup_table.setVisible(true); 
					scrollpane.setVisible(true);
					lbl_result.setVisible(true);
					lbl_result.setText("Data Loaded");
					
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
				if (add_()==1) {
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
		
		sup_table = new JTable(){ 
			@Override
			public boolean isCellEditable(int row, int column)
            {
                                  return false;}//uneditable    
		};
		
		
		sup_table.setFillsViewportHeight(true);
		//sup_table.setBounds(48,288,563,30);
		sup_table.setVisible(true);
		
		
		scrollpane = new JScrollPane(sup_table,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(48,288,563,40);
		//scrollpane.setPreferredSize(new Dimension(563, 50));   //whole scrollpane and table will disapear
		supplier_panel.add(scrollpane);
		
		lbl_result = new JLabel("");
		lbl_result.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_result.setBounds(116, 243, 463, 16);
		lbl_result.setVisible(false);
		supplier_panel.add(lbl_result);

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
	
	
	private String[][] inquire(JTextField sup_ID, JTextField sup_name) {
		/** 
		 * @Author jyun-an
		 *  @since 06/01/2021, 06/03/2021 fixed
		 *  
		 *  to inquire data in SUPPLIER table 
		 **/
		
		ArrayList<String[]> temp = new ArrayList();
		switch(Term_project_main.lib.check_text_fields(sup_ID, sup_name)) {
		
			case "11":

				try {
					ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM SUPPLIER WHERE (Supplier_ID=\'" + 
							sup_ID.getText()+"\' AND Supplier_name=\'" +sup_name.getText()+"\')");
					
					while(resultSet.next()) {
						String [] temp_array = new String[6];
						for(int i = 1; i<7; i++) {
							temp_array[i-1]= resultSet.getString(i);
						}
						temp.add(temp_array);
					}
					break;
				}catch (SQLException e) {
					
				// TODO Auto-generated catch block
					//e.printStackTrace();
					break;
					}
			case "10":
					
				
				try {
					ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM SUPPLIER WHERE Supplier_ID=\'" 
													+ text_sup_supID.getText() +"\'");
					
					while(resultSet.next()) {
						String [] temp_array = new String[6];
						for(int i = 1; i<7; i++) {
							temp_array[i-1]= resultSet.getString(i);
						}
						temp.add(temp_array);
					}
					break;
				}catch (SQLException e) {
					
				// TODO Auto-generated catch block
					//e.printStackTrace();
					break;
					}
		
			default:
				
				try {
					ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM SUPPLIER WHERE Supplier_name=\'" + 
													text_sup_name.getText()+"\'");
					
					while(resultSet.next()) {
						String [] temp_array = new String[6];
						for(int i = 1; i<7; i++) {
							temp_array[i-1]= resultSet.getString(i);
						}
						temp.add(temp_array);
					}
					break;
				}catch (SQLException e) {
					
				// TODO Auto-generated catch block
					//e.printStackTrace();
					break;
					}
		}
		
		String[][] result_array = new String[temp.size()][6];
		int i=0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		        }
		return result_array;
		
	}
		
		
	
	
	
	private int add_() {
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
