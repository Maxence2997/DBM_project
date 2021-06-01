package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Inventory_panel {
	
	private JPanel inventory_panel;
	
	private JTable inv_table;
	
	private JTextField text_invID;
	private JTextField text_inv_item;
	private JTextField text_inv_pd;
	
	public Inventory_panel() {
		
		
		panel();
		
	}
	
	
	private void panel() {
		
		inventory_panel = new JPanel();
		Term_project_main.container_panel.add(inventory_panel,"inventory");
		inventory_panel.setLayout(null);
		
		JLabel lbl_inv_ID = new JLabel("Inventory ID :");
		lbl_inv_ID.setBounds(84, 40, 88, 16);
		lbl_inv_ID.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_ID);
		
		text_invID = new JTextField();
		text_invID.setBounds(176, 35, 108, 26);
		inventory_panel.add(text_invID);
		text_invID.setColumns(10);
		
		JLabel lbl_inv_item_name = new JLabel("Item Name :");
		lbl_inv_item_name.setBounds(346, 40, 88, 16);
		lbl_inv_item_name.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_item_name);
		
		text_inv_item = new JTextField();
		text_inv_item.setBounds(438, 35, 112, 26);
		inventory_panel.add(text_inv_item);
		text_inv_item.setColumns(10);
		
		JLabel lbl_inv_module = new JLabel("Module  Type : ");
		lbl_inv_module.setBounds(62, 102, 110, 16);
		lbl_inv_module.setHorizontalAlignment(SwingConstants.RIGHT);
		inventory_panel.add(lbl_inv_module);
		
		text_inv_pd = new JTextField();
		text_inv_pd.setBounds(176, 97, 108, 26);
		inventory_panel.add(text_inv_pd);
		text_inv_pd.setColumns(10);
		
		JButton btn_inv_inquire = new JButton("Inquire");
		btn_inv_inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inquire();
				
				//library.btn_inquire_invent();
				inv_table.setVisible(true);
			}
		});
		btn_inv_inquire.setBounds(554, 160, 88, 29);
		inventory_panel.add(btn_inv_inquire);
		
		inv_table = new JTable();
		inv_table.setBounds(33, 194, 604, 172);
		inventory_panel.add(inv_table);
		inv_table.setVisible(false);		
	}
	
	private String[][] inquire() {
		/** 
		 * @Author jyun-an
		 *  @since 06/01
		 *  to inquire data in SUPPLIER table 
		 **/

		String [][] temp;
		
		if (!(text_invID.getText().isEmpty())){
			System.out.println("IN 1");
			
			temp = new String[1][4];
			
				if(!(text_inv_item.getText().isEmpty())) {
					System.out.println("IN 1-1");
					if(!(text_inv_pd.getText().isEmpty())) {
						System.out.println("IN 1-1-1");
					
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
													text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
													+text_inv_pd.getText()+"\')");
							if(resultSet.next()) {

//								System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//								text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
//								+text_inv_pd.getText()+"\')");
								
								for(int i = 1; i<5; i++) {
									temp[0][i-1]= resultSet.getString(i);
								}
								return temp;
							}
							return temp;
					
					
						}catch (SQLException e) {
							
						// TODO Auto-generated catch block
							e.printStackTrace();
							return temp;
							}
					}else {
						System.out.println("IN 1-1-0");
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
													text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\')");
							if(resultSet.next()) {

//								System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//								text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\')");
								
								for(int i = 1; i<5; i++) {
									temp[0][i-1]= resultSet.getString(i);
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
				}else if(!(text_inv_pd.getText().isEmpty())) {
						System.out.println("IN 1-0-1");
						
						try {
							ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
														text_invID.getText()+" AND Module_type=\'"+text_inv_pd.getText()+"\')");
							if(resultSet.next()) {

//								System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//								text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
//								+text_inv_pd.getText()+"\')");
									
								for(int i = 1; i<5; i++) {
									temp[0][i-1]= resultSet.getString(i);
								}
								return temp;
							}
							return temp;
						
						}catch (SQLException e) {
								
						// TODO Auto-generated catch block
							e.printStackTrace();
							return temp;
							}
						
				}else {
					System.out.println("IN 1-0-0");
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE Inv_ID=" + 
													text_invID.getText());
						if(resultSet.next()) {

//							System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//							text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
//							+text_inv_pd.getText()+"\')");
								
							for(int i = 1; i<5; i++) {
								temp[0][i-1]= resultSet.getString(i);
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
	
		}else if(!(text_inv_item.getText().isEmpty())) {
				System.out.println("IN 0-1");
				if(!(text_inv_pd.getText().isEmpty())) {
					System.out.println("IN 0-1-1");
					temp = new String[1][4];
						
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Item_name=\'"+
														text_inv_item.getText()+"\' AND Module_type=\'"+text_inv_pd.getText()+"\')");
						if(resultSet.next()) {

//							System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//							text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
//							+text_inv_pd.getText()+"\')");
									
							for(int i = 1; i<5; i++) {
								temp[0][i-1]= resultSet.getString(i);
							}
							return temp;
						}
						return temp;
						
						
					}catch (SQLException e) {
								
						//TODO Auto-generated catch block
						e.printStackTrace();
						return temp;
						}
							
				}else {
					temp = new String[36][4];
					System.out.println("IN 0-1-0");
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE Item_name=\'"+
															text_inv_item.getText()+"\'");
						int k=0;
						while(resultSet.next()) {

//							System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//							text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
//							+text_inv_pd.getText()+"\')");
										
							for(int i = 1; i<5; i++) {
								temp[k][i-1]= resultSet.getString(i);
								}
								k++;
							}return temp;
							
							
						}catch (SQLException e) {
									
							// TODO Auto-generated catch block
							e.printStackTrace();
								return temp;
							}
						}
						
		}else {
			System.out.println("IN 0-0-1");
			temp = new String[10][4];
				
			try {
				ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE Module_type=\'"+
											text_inv_pd.getText()+"\'");
				int k=0;
				while(resultSet.next()) {
//					System.out.println("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
//					text_invID.getText()+" AND Item_name=\'"+ text_inv_item.getText()+"\' AND Module_type=\'"
//					+text_inv_pd.getText()+"\')");
						
					for(int i = 1; i<5; i++) {
						temp[k][i-1]= resultSet.getString(i);
					}
					k++;
				}return temp;
			
			
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return temp;
				}
			}
			
		}
				
	
	
	
	public JTextField get_text_invID() {
		
		return text_invID;
	}
	
	
	public JTextField get_text_inv_item() {
		
		return text_inv_item;
	}
	
	
	public JTextField get_text_inv_pd() {
		
		return text_inv_pd;
	}
}
