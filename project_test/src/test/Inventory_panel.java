package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Inventory_panel {
	
	private JPanel inventory_panel;
	
	private JTable invent_table;
	
	public Inventory_panel() {
		
		
		panel();
		
	}
	
	
	private void panel() {
		
		inventory_panel = new JPanel();
		Project_main.container_panel.add(inventory_panel,"inventory");
		inventory_panel.setLayout(null);
		
		JLabel lbl_stockID = new JLabel("Stock ID :");
		lbl_stockID.setBounds(111, 40, 61, 16);
		lbl_stockID.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_stockID);
		
		JTextField text_stockID = new JTextField();
		text_stockID.setBounds(176, 35, 108, 26);
		inventory_panel.add(text_stockID);
		text_stockID.setColumns(10);
		
		JLabel lbl_item = new JLabel("Item Type :");
		lbl_item.setBounds(364, 40, 70, 16);
		lbl_item.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_item);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(438, 35, 112, 26);
		inventory_panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lbl_product = new JLabel("Product Module : ");
		lbl_product.setBounds(62, 102, 110, 16);
		lbl_product.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_product);
		
		JTextField text_item = new JTextField();
		text_item.setBounds(176, 97, 108, 26);
		inventory_panel.add(text_item);
		text_item.setColumns(10);
		
		JLabel lbl_date = new JLabel("Receive Date : ");
		lbl_date.setBounds(342, 102, 92, 16);
		lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_date);
		
		JTextField text_date = new JTextField();
		text_date.setBounds(438, 97, 112, 26);
		inventory_panel.add(text_date);
		text_date.setColumns(10);
		
		JButton btn_inquire = new JButton("Inquire");
		btn_inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//library.btn_inquire_invent();
				invent_table.setVisible(true);
			}
		});
		btn_inquire.setBounds(554, 160, 88, 29);
		inventory_panel.add(btn_inquire);
		
		invent_table = new JTable();
		invent_table.setBounds(33, 194, 609, 189);
		inventory_panel.add(invent_table);
		invent_table.setVisible(false);		
	}
}
