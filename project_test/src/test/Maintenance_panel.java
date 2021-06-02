package test;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Maintenance_panel  {
	
	/**
     * @autohr Jyun-An
     * @ver. 1.2.2 05/28   
     * Seperated from Project_test
     **/
	
		public JPanel core_maint_panel;
		private JPanel maint_container_panel;
		private JComboBox comboBox_pj;
		
		private JPanel default_panel;
		
		private JPanel inq_panel;
		
		private JPanel mod_panel;
		
		private JPanel append_panel;
		
		private JPanel remove_panel;
		private JLabel lbl_remv_confirm;
		private JTextField text_remv_confirm;
		private JButton btn_remv_confirm;
		private JTable appd_table;
		
		private JTable inq_table;
		
		private JTable mod_table;
		
		private JTable rmv_table;
		
		
		private JTextField text_appd_empID;
		
		//private JTextField text_inq_pjID;
		
		
		
		private CardLayout cl_maint;
		
		
		
		
		
		public Maintenance_panel() {
			proj_maintc_panels();
			
			
			
		}
	
	
		private void proj_maintc_panels() {
			
			//core sheet panel which contains comboBox
			core_maint_panel = new JPanel();
			Term_project_main.container_panel.add(core_maint_panel,"maintenance");
			core_maint_panel.setLayout(null);
			
			//smaller panel on the core maint panel
			cl_maint = new CardLayout();
			maint_container_panel = new JPanel(cl_maint);
			
			maint_container_panel.setBounds(0, 35, 666, 348);
			maint_container_panel.setBackground(Color.CYAN);
			core_maint_panel.add(maint_container_panel);
			
			
			//add 5 sub project maintenance panels
			
			add_default_panel();
			add_inquire_panel();
			add_modify_panel();
			add_append_panel();
			add_remove_panel();
			
			
			comboBox_pj = new JComboBox( new String[] {"--------","Inquire","Modify","Append","Remove"});
			comboBox_pj.setBounds(269, 7, 126, 27);
//			comboBox_pj.addItem("--------");
//			comboBox_pj.addItem("Inquire");
//			comboBox_pj.addItem("Modify");
//			comboBox_pj.addItem("Append");
//			comboBox_pj.addItem("Remove");
			
			
			
			comboBox_pj.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox_pj.getSelectedItem(); //get the selected item
		
		                
		            	cl_maint.show(maint_container_panel, function);		                   
		            }
		        });
		
			core_maint_panel.add(comboBox_pj);
			
			JButton btn_back2pj = new JButton("");
			btn_back2pj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
				}
			});
			Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
			go_back = go_back.getScaledInstance( 21, 21,  java.awt.Image.SCALE_AREA_AVERAGING) ;
			btn_back2pj.setIcon(new ImageIcon(go_back));
			btn_back2pj.setBounds(16, 4, 30, 30);
			core_maint_panel.add(btn_back2pj);
			
			JLabel lbl_maint = new JLabel("Maintenance");
			lbl_maint.setBounds(58, 11, 87, 16);
			core_maint_panel.add(lbl_maint);
		}
		
		
		
		
		//default panel2
		private void add_default_panel() {
			default_panel = new JPanel();
			inq_panel.add(default_panel);
			default_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(inq_panel, "--------");
			default_panel.setLayout(null);
		}
		
		//first panel - Inquire 
		private void add_inquire_panel() {
			
			inq_panel = new JPanel();
			inq_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(inq_panel, "Inquire");
			inq_panel.setLayout(null);
			
					
			JLabel lbl_inq_pjID = new JLabel("project ID :");
			lbl_inq_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_inq_pjID.setBounds(50, 11, 86, 16);
			inq_panel.add(lbl_inq_pjID);
					
			JTextField text_inq_pjID = new JTextField();
			text_inq_pjID.setBounds(136, 6, 141, 26);
			inq_panel.add(text_inq_pjID);
			text_inq_pjID.setColumns(10);
					
			JLabel lbl_inq_date = new JLabel("Est. Date :");
			lbl_inq_date.setBounds(310, 11, 106, 16);
			lbl_inq_date.setHorizontalAlignment(SwingConstants.RIGHT);
			inq_panel.add(lbl_inq_date);
					
			JTextField text_inq_date = new JTextField();
			text_inq_date.setBounds(416, 6, 105, 26);
			inq_panel.add(text_inq_date);
			text_inq_date.setColumns(10);
					
			JButton btn_inq_inquire = new JButton("Inquire");
			btn_inq_inquire.setBounds(554, 5, 87, 29);
			btn_inq_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//library.btn_inquire();
					inq_panel.setVisible(true);
				}
			});
			inq_panel.add(btn_inq_inquire);
					
			JLabel lbl_inq_empID = new JLabel("Employee ID :");
			lbl_inq_empID.setBounds(50, 45, 86, 16);
			inq_panel.add(lbl_inq_empID);
					
			JTextField text_inq_empID = new JTextField();
			text_inq_empID.setBounds(136, 40, 141, 26);
			inq_panel.add(text_inq_empID);
			text_inq_empID.setColumns(10);
					
			
					
			JButton btn_inq_last20 = new JButton("Last 20");
			btn_inq_last20.setBounds(554, 39, 87, 29);
			btn_inq_last20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//library.btn_inquire();
					inq_panel.setVisible(true);
				}
			});
			inq_panel.add(btn_inq_last20);
					
			JLabel lbl_inq_note = new JLabel("Note : To inquire project, at least one of project ID and Employee ID must be filled in  ");
			lbl_inq_note.setBounds(29, 73, 529, 16);
			inq_panel.add(lbl_inq_note);
					
			inq_table = new JTable();
			inq_table.setBounds(29, 94, 612, 254);
			inq_panel.add(inq_table);
			inq_table.setVisible(false);
		}
		
		//Second panel - Modify 
		private void add_modify_panel() {
			
			mod_panel = new JPanel();
			mod_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(mod_panel, "Modify");
			mod_panel.setLayout(null);
			
			JLabel lbl_mod_pjID = new JLabel("*project ID :");
			lbl_mod_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_mod_pjID.setBounds(53, 41, 86, 16);
			mod_panel.add(lbl_mod_pjID);
			
			JTextField text_mod_pjID = new JTextField();
			text_mod_pjID.setBounds(143, 36, 115, 26);
			mod_panel.add(text_mod_pjID);
			text_mod_pjID.setColumns(10);
			
			
			JButton btn_mod_modify = new JButton("Modify");
			btn_mod_modify.setBounds(539, 35, 87, 29);
			mod_panel.add(btn_mod_modify);
			
			JLabel lbl_mod_empID = new JLabel("Employee ID :");
			lbl_mod_empID.setBounds(53, 104, 86, 16);
			mod_panel.add(lbl_mod_empID);
			
			JTextField text_mod_empID = new JTextField();
			text_mod_empID.setBounds(143, 99, 115, 26);
			mod_panel.add(text_mod_empID);
			text_mod_empID.setColumns(10);
			
			JLabel lbl_mod_date = new JLabel("Est. Date :");
			lbl_mod_date.setBounds(288, 41, 88, 16);
			lbl_mod_date.setHorizontalAlignment(SwingConstants.RIGHT);
			mod_panel.add(lbl_mod_date);
			
			JTextField text_mod_date = new JTextField();
			text_mod_date.setBounds(388, 36, 115, 26);
			mod_panel.add(text_mod_date);
			text_mod_date.setColumns(10);
			
			mod_table = new JTable();
			mod_table.setBounds(33, 252, 593, 66);
			mod_panel.add(mod_table);
		}
		
		//third panel - Append 
		private void add_append_panel() {
			
			append_panel = new JPanel();
			append_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(append_panel, "Append");
			append_panel.setLayout(null);
			
			JLabel lbl_appd_empID = new JLabel("Employee ID :");
			lbl_appd_empID.setBounds(62, 101, 86, 16);
			append_panel.add(lbl_appd_empID);
			
			text_appd_empID = new JTextField();
			text_appd_empID.setBounds(148, 96, 116, 26);
			append_panel.add(text_appd_empID);
			text_appd_empID.setColumns(10);
			
			JButton btn_appd_append = new JButton("Append");
			btn_appd_append.setBounds(471, 95, 92, 29);
			append_panel.add(btn_appd_append);
			
			JLabel lbl_appd_error = new JLabel("Employee ID inputed is invalid, please verify it.");
			lbl_appd_error.setBounds(62, 159, 318, 16);
			append_panel.add(lbl_appd_error);
			lbl_appd_error.setVisible(false);
			
			appd_table = new JTable();
			appd_table.setBounds(58, 205, 563, 39);
			append_panel.add(appd_table);
			
			
			
		}
		
		//forth panel - Remove 
		private void add_remove_panel() {
					
			remove_panel = new JPanel();
			remove_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(remove_panel, "Remove");
			remove_panel.setLayout(null);
			
			JLabel lbl_remv_pjID = new JLabel("*project ID :");
			lbl_remv_pjID.setBounds(81, 41, 86, 16);
			remove_panel.add(lbl_remv_pjID);
			
			JTextField text_remv_pjID = new JTextField();
			text_remv_pjID.setBounds(167, 36, 146, 26);
			remove_panel.add(text_remv_pjID);
			text_remv_pjID.setColumns(10);
			
			JButton btn_remv_remove = new JButton("Remove");
			btn_remv_remove.setBounds(494, 35, 93, 29);
			btn_remv_remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//library.btn_remove();
					rmv_table.setVisible(true);
					lbl_remv_confirm.setVisible(true);
					text_remv_confirm.setVisible(true);
					btn_remv_confirm.setVisible(true);
				}
			});
			remove_panel.add(btn_remv_remove);
			
			rmv_table = new JTable();
			rmv_table.setBounds(81, 159, 506, 25);
			remove_panel.add(rmv_table);
			rmv_table.setVisible(false);
			
			lbl_remv_confirm = new JLabel("Please write down \"I'm PRETTY SURE that I would like to remove this sheet.\"");
			lbl_remv_confirm.setBounds(81, 189, 506, 16);
			remove_panel.add(lbl_remv_confirm);
			lbl_remv_confirm.setVisible(false);
			
			text_remv_confirm = new JTextField();
			text_remv_confirm.setBounds(81, 210, 506, 26);
			remove_panel.add(text_remv_confirm);
			text_remv_confirm.setColumns(10);
			text_remv_confirm.setVisible(false);
			
			btn_remv_confirm = new JButton("Confirm");
			btn_remv_confirm.setBounds(494, 301, 93, 29);
			remove_panel.add(btn_remv_confirm);
			btn_remv_confirm.setVisible(false);
		
			}
		
		
		
		
		
		
		
		public JComboBox get_comboBox_project() {
			
			return comboBox_pj;
		}
		
//		public JTextField get_text_inq_pjID() {
//			
//			return text_inq_pjID;
//		}
}
