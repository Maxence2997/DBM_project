package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Supplier_panel {
		
	/**
     * @autohr Jyun-An
     * @ver. 1.2.2 05/28   
     * Seperated from Project_test
     **/
	
	
		private JPanel supplier_panel;
		private JTextField text_supID;
		private JTextField text_sup_name;
		private JTable sup_table;
	
	//supplier panel variables needed for comboBox actionListener
		private String supplierFunction;
		private JLabel lbl_sup_address;
		private JLabel lbl_sup_contact;
		private JLabel lbl_sup_mobile;
		private JLabel lbl_sup_mail;
		private JComboBox comboBox_supplierAction;
		private JButton btn_sup_inquire;
		private JButton btn_sup_add;
		private JButton btn_sup_delete;
		private JTextField text_sup_address;
		private JTextField text_sup_contact;
		private JTextField text_sup_mobile;
		private JTextField text_sup_mail;
	
	
	public Supplier_panel() {
		
		panel();
	}
	
	
	
	
	private void panel() {
		
		/*
		 *  New version GUI by Ray
		 * 05/27/2021
		 */
		
		supplier_panel = new JPanel();
		Project_main.container_panel.add(supplier_panel,"supplier");
		
		comboBox_supplierAction = new JComboBox();
		comboBox_supplierAction.setBounds(266, 4, 135, 27);
		comboBox_supplierAction.setModel(new DefaultComboBoxModel(new String[] {"Inquire", "Maintenance"}));
		supplierFunction = (String) comboBox_supplierAction.getSelectedItem();
		comboBox_supplierAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	supplierFunction = (String) comboBox_supplierAction.getSelectedItem();
            	
            	if (supplierFunction.equals("Inquire")) {
            		btn_sup_inquire.setVisible(true);
            		btn_sup_add.setVisible(false);
            		btn_sup_delete.setVisible(false);
            		lbl_sup_address.setVisible(false);
            		text_sup_address.setVisible(false);
            		lbl_sup_contact.setVisible(false);
            		text_sup_contact.setVisible(false);
            		lbl_sup_mobile.setVisible(false);
            		text_sup_mobile.setVisible(false);
            		lbl_sup_mail.setVisible(false);
            		text_sup_mail.setVisible(false);
            		
            	}
            	else if (supplierFunction.equals("Maintenance")) {
            		btn_sup_inquire.setVisible(false);
            		btn_sup_add.setVisible(true);
            		btn_sup_delete.setVisible(true);
            		lbl_sup_address.setVisible(true);
            		text_sup_address.setVisible(true);
            		lbl_sup_contact.setVisible(true);
            		text_sup_contact.setVisible(true);
            		lbl_sup_mobile.setVisible(true);
            		text_sup_mobile.setVisible(true);
            		lbl_sup_mail.setVisible(true);
            		text_sup_mail.setVisible(true);
            	}
            }
        });
		supplier_panel.setLayout(null);
		supplier_panel.add(comboBox_supplierAction);
		
		JLabel lbl_supID = new JLabel("Supplier ID :");
		lbl_supID.setBounds(160, 55, 77, 16);
		lbl_supID.setHorizontalAlignment(SwingConstants.RIGHT);
		supplier_panel.add(lbl_supID);
		
		text_supID = new JTextField();
		text_supID.setBounds(245, 50, 178, 26);
		supplier_panel.add(text_supID);
		text_supID.setColumns(14);
		
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
				
				//library.btn_inquire_sup();
				sup_table.setVisible(true);
			}
		});
		supplier_panel.add(btn_sup_inquire);
		
		lbl_sup_address = new JLabel("Address :");
		lbl_sup_address.setBounds(178, 107, 59, 16);
		lbl_sup_address.setVisible(false);
		supplier_panel.add(lbl_sup_address);
		
		text_sup_address = new JTextField();
		text_sup_address.setBounds(245, 102, 178, 26);
		text_sup_address.setVisible(false);
		supplier_panel.add(text_sup_address);
		text_sup_address.setColumns(14);
		
		lbl_sup_contact = new JLabel("Contact :");
		lbl_sup_contact.setBounds(180, 133, 57, 16);
		lbl_sup_contact.setVisible(false);
		supplier_panel.add(lbl_sup_contact);
		
		text_sup_contact = new JTextField();
		text_sup_contact.setBounds(245, 128, 178, 26);
		text_sup_contact.setVisible(false);
		supplier_panel.add(text_sup_contact);
		text_sup_contact.setColumns(14);
		
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
		btn_sup_delete.setBounds(491, 180, 84, 29);
		btn_sup_delete.setVisible(false);
		supplier_panel.add(btn_sup_delete);
		
		sup_table = new JTable();
		sup_table.setBounds(67, 262, 563, 25);
		supplier_panel.add(sup_table);
		sup_table.setVisible(false);
	}
	
	public JComboBox get_comboBox_supplierAction() {
		
		return comboBox_supplierAction;
	}
}
