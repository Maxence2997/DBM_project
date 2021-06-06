package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Inventory_panel {
	
	private JPanel inventory_panel;
	private Library lib;
	private JTable inv_table;
	
	private JTextField text_invID;
	private JTextField text_inv_item;
	private JTextField text_inv_pd;
	
	private DefaultTableModel inv_table_model;
	private JScrollPane scrollpane;
	
	
	public Inventory_panel() {
		
		
		panel();
		lib = new Library();
		
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
				
				
				String[] column_names = { "Inventory_ID", "Project_ID", "Item Type", "Module Type"};
				
				String[][] temp =inquire(text_invID, text_inv_item, text_inv_pd);
//				String [][] temp = {{"27000002","90000001","CPU","C0x055"},{"27000003","90000001","CPU","C0z004"},			
//														{"27000004","90000002","CPU","C0z035"},{"27000004","90000002",
//															"CPU","C0z035"},{"27000004","90000002","CPU","C0z035"}};  //for testing without connection
//  	
	//			for(int j=0; j<temp.length;j++) {
	//				System.out.print("\n");
	//				for(int i=0;i<4;i++) {
	//					System.out.print(temp[j][i]+"\t");	
	//					}	
	//				}
				if (temp.length != 0){ // found data match
					inv_table_model = new DefaultTableModel(temp,column_names);  
					inv_table.setModel(inv_table_model);
					inv_table.setVisible(true);
					scrollpane.setVisible(true);
				
				}
			}
		});
		btn_inv_inquire.setBounds(554, 160, 88, 29);
		inventory_panel.add(btn_inv_inquire);
		
		inv_table = new JTable(){ 
			@Override
			public boolean isCellEditable(int row, int column)
            {
                                  return false;}//uneditable
            
			}; 
		inv_table.setBounds(33, 194, 604, 172);
		//inventory_panel.add(inv_table);
		inv_table.setVisible(false);

		scrollpane = new JScrollPane(inv_table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setBounds(49,241,563,87);
		scrollpane.setVisible(false);
		
		inventory_panel.add(scrollpane);

	
	}
	
	
	
	
	
	
	private String[][] inquire(JTextField InvID, JTextField item_name, JTextField module_type) {
		/** 
		 * @Author jyun-an
		 *  @since 06/03/2021
		 *  to inquire data in INVENTORY table 
		 **/
		
		ArrayList<String[]> temp = new ArrayList();
		
		switch (lib.check_text_fields(InvID, item_name, module_type)) {
		
		
				case "111":
					
					
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
													InvID.getText()+" AND Item_name=\'"+ item_name.getText()+"\' AND Module_type=\'"
												+module_type.getText()+"\')");
						while(resultSet.next()) {
							String [] temp_array = new String[4];
							for(int i = 1; i<5; i++) {
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
					
				case "110":
					
					
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
														InvID.getText()+" AND Item_name=\'"+ item_name.getText()+"\')");
						while(resultSet.next()) {
							String [] temp_array = new String[4];
							for(int i = 1; i<5; i++) {
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
					
					
				case "101":
					
					
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Inv_ID=" + 
													InvID.getText()+" AND Module_type=\'"+module_type.getText()+"\')");
						while(resultSet.next()) {
							String [] temp_array = new String[4];
							for(int i = 1; i<5; i++) {
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
					
					
				case "100":
					
					
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE Inv_ID=" + 
																						InvID.getText());
						while(resultSet.next()) {
							String [] temp_array = new String[4];
							for(int i = 1; i<5; i++) {
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
				
				case "011":
					
					
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE (Item_name=\'"+
															item_name.getText()+"\' AND Module_type=\'"+module_type.getText()+"\')");
						
						while(resultSet.next()) {
							String [] temp_array = new String[4];
							for(int i = 1; i<5; i++) {
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
						
				case "010":
					
					
//					
					try {
						ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE Item_name=\'"+
																					item_name.getText()+"\'");
						
						while(resultSet.next()) {
							String [] temp_array = new String[4];
							for(int i = 1; i<5; i++) {
								temp_array[i-1]= resultSet.getString(i);
							}
							temp.add(temp_array);
							
						}
						break;
					}catch (SQLException e) {
						
					// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					}
					
				default:
					
					
					
				try {
					ResultSet resultSet = Term_project_main.conn.st.executeQuery("SELECT * FROM INVENTORY WHERE Module_type=\'"+
																module_type.getText()+"\'");
					
					while(resultSet.next()) {
						String [] temp_array = new String[4];
						for(int i = 1; i<5; i++) {
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
				
		String[][] result_array = new String[temp.size()][4];
		int i=0;
		for (String[] array_in_temp : temp) {
			result_array[i++] = array_in_temp;
		        }
		return result_array;
				
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
