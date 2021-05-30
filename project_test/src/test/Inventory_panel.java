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
	
	private JTable inv_table;
	
	public Inventory_panel() {
		
		
		panel();
		
	}
	
	
	private void panel() {
		
		inventory_panel = new JPanel();
		Term_project_main.container_panel.add(inventory_panel,"inventory");
		inventory_panel.setLayout(null);
		
		JLabel lbl_inv_stockID = new JLabel("Stock ID :");
		lbl_inv_stockID.setBounds(111, 40, 61, 16);
		lbl_inv_stockID.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_stockID);
		
		JTextField text_inv_stockID = new JTextField();
		text_inv_stockID.setBounds(176, 35, 108, 26);
		inventory_panel.add(text_inv_stockID);
		text_inv_stockID.setColumns(10);
		
		JLabel lbl_inv_item = new JLabel("Item Type :");
		lbl_inv_item.setBounds(364, 40, 70, 16);
		lbl_inv_item.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_item);
		
		JTextField text_inv_item = new JTextField();
		text_inv_item.setBounds(438, 35, 112, 26);
		inventory_panel.add(text_inv_item);
		text_inv_item.setColumns(10);
		
		JLabel lbl_inv_product = new JLabel("Product Module : ");
		lbl_inv_product.setBounds(62, 102, 110, 16);
		lbl_inv_product.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_product);
		
		JTextField text_inv_product = new JTextField();
		text_inv_product.setBounds(176, 97, 108, 26);
		inventory_panel.add(text_inv_product);
		text_inv_product.setColumns(10);
		
		JLabel lbl_inv_date = new JLabel("Receive Date : ");
		lbl_inv_date.setBounds(342, 102, 92, 16);
		lbl_inv_date.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_date);
		
		JTextField text_inv_date = new JTextField();
		text_inv_date.setBounds(438, 97, 112, 26);
		inventory_panel.add(text_inv_date);
		text_inv_date.setColumns(10);
		
		JButton btn_inv_inquire = new JButton("Inquire");
		btn_inv_inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//library.btn_inquire_invent();
				inv_table.setVisible(true);
			}
		});
		btn_inv_inquire.setBounds(554, 160, 88, 29);
		inventory_panel.add(btn_inv_inquire);
		
		inv_table = new JTable();
		inv_table.setBounds(33, 194, 609, 189);
		inventory_panel.add(inv_table);
		inv_table.setVisible(false);		
	}
}
