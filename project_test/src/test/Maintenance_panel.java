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
		private JTable inq_table;
		
		private JPanel maint_panel;
		private JTextField text_maint_pjID;
		private JLabel lbl_maint_empID;
		private JTextField text_maint_empID;
		private JTextField text_maint_date;
		private JLabel lbl_maint_status;
		private JLabel lbl_maint_del_status;
		private JLabel lbl_maint_status_show;
		private JLabel lbl_maint_del_progress;
		private JLabel lbl_maint_del_progress_show;
		
		private JButton btn_maint;
		
		private JButton btn_maint_check;
		private JLabel lbl_maint_date;
		private JLabel lbl_maint_del_status_show;
		//private JTextField text_inq_pjID;
		
		
		
		private CardLayout cl_maint;
		private JTextField text_inq_empID;
		private JButton btn_refresh;
		
		
		
		
		
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
			add_maintenance_panel();
			
			
			
			comboBox_pj = new JComboBox( new String[] {"-----------","Inquire","Modify","Append", "Delete"});
			comboBox_pj.setBounds(245, 7, 159, 27);
//			comboBox_pj.addItem("--------");
//			comboBox_pj.addItem("Inquire");
//			comboBox_pj.addItem("Modify");
//			comboBox_pj.addItem("Append");
//			comboBox_pj.addItem("Remove");
			
			
			
			comboBox_pj.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox_pj.getSelectedItem(); //get the selected item
		            	
		            	switch (function){
		            	
		            		
		            		case "Modify":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Modify");
		            			
		            			btn_maint_check.setVisible(true);
		            			set_visible(false);
		            			break;
		            			
		            		case "Append":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Append");
		            			
		            			
		            			btn_maint_check.setVisible(false);
		            			set_visible(true);
		            			break;
		            			
		            		case "Delete":
		            			cl_maint.show(maint_container_panel, "Maintenance");
		            			btn_maint.setText("Delete");
		            			
		            			
		            			btn_maint_check.setVisible(true);
		            			set_visible(false);
		            			break;
		            			
		            		default:
		            			cl_maint.show(maint_container_panel, function);
		            			break;
		            		
		            	}
		            	//cl_maint.show(maint_container_panel, function);		                   
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
			default_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(default_panel, "-----------");
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
					
			text_inq_empID = new JTextField();
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
			inq_table.setBounds(29, 195, 612, 153);
			inq_panel.add(inq_table);
			inq_table.setVisible(false);
		}
		
		//Second panel - Modify 
		private void add_maintenance_panel() {
			
			maint_panel = new JPanel();
			maint_panel.setBounds(0, 0, 666, 348);
			maint_container_panel.add(maint_panel, "Maintenance");
			maint_panel.setLayout(null);
			
			JLabel lbl_maint_pjID = new JLabel("*project ID :");
			lbl_maint_pjID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_pjID.setBounds(162, 41, 86, 16);
			maint_panel.add(lbl_maint_pjID);
			
			text_maint_pjID = new JTextField();
			text_maint_pjID.setBounds(260, 36, 130, 30);
			maint_panel.add(text_maint_pjID);
			text_maint_pjID.setColumns(10);
			
			
			btn_maint = new JButton("");
			btn_maint.setBounds(490, 200, 87, 29);
			maint_panel.add(btn_maint);
			
			lbl_maint_empID = new JLabel("Employee ID :");
			lbl_maint_empID.setLabelFor(text_inq_empID);
			lbl_maint_empID.setBounds(162, 85, 86, 16);
			maint_panel.add(lbl_maint_empID);
			
			text_maint_empID = new JTextField();
			text_maint_empID.setBounds(260, 78, 130, 30);
			maint_panel.add(text_maint_empID);
			text_maint_empID.setColumns(10);
			
			lbl_maint_date = new JLabel("Est. Date :");
			lbl_maint_date.setBounds(142, 118, 108, 16);
			lbl_maint_date.setHorizontalAlignment(SwingConstants.RIGHT);
			maint_panel.add(lbl_maint_date);
			
			text_maint_date = new JTextField();
			text_maint_date.setBounds(260, 113, 130, 30);
			maint_panel.add(text_maint_date);
			text_maint_date.setColumns(10);
			
			lbl_maint_status = new JLabel("Project Status :");
			lbl_maint_status.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_status.setBounds(146, 163, 102, 16);
			maint_panel.add(lbl_maint_status);
			
			lbl_maint_del_status = new JLabel("Delivery Status :");
			lbl_maint_del_status.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_maint_del_status.setBounds(146, 213, 102, 16);
			maint_panel.add(lbl_maint_del_status);
			
			lbl_maint_del_status_show = new JLabel("NNNN");
			lbl_maint_del_status_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_del_status_show.setBounds(260, 206, 130, 30);
			maint_panel.add(lbl_maint_del_status_show);
			
			lbl_maint_status_show = new JLabel("NNNN");
			lbl_maint_status_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_status_show.setBounds(260, 163, 130, 23);
			maint_panel.add(lbl_maint_status_show);
			
			lbl_maint_del_progress = new JLabel("Delivery Progress :");
			lbl_maint_del_progress.setBounds(130, 270, 117, 16);
			maint_panel.add(lbl_maint_del_progress);
			
			lbl_maint_del_progress_show = new JLabel("NNNN");
			lbl_maint_del_progress_show.setHorizontalAlignment(SwingConstants.CENTER);
			lbl_maint_del_progress_show.setBounds(260, 270, 130, 16);
			maint_panel.add(lbl_maint_del_progress_show);
			
			btn_maint_check = new JButton("Check ");
			btn_maint_check.setBounds(402, 36, 78, 29);
			maint_panel.add(btn_maint_check);
			
			btn_refresh = new JButton("Refresh");
			btn_refresh.setBounds(481, 36, 86, 29);
			maint_panel.add(btn_refresh);
		}

		private void set_visible(boolean bl) {
			
			lbl_maint_empID.setVisible(bl);
			text_maint_empID.setVisible(bl);
			
			lbl_maint_date.setVisible(bl);
			text_maint_date.setVisible(bl);
			
			lbl_maint_status.setVisible(bl);
			lbl_maint_status_show.setVisible(bl);
			
			lbl_maint_del_progress.setVisible(bl);
			lbl_maint_del_progress_show.setVisible(bl);
			
			lbl_maint_del_status.setVisible(bl);
			lbl_maint_del_status_show.setVisible(bl);
			
			
			
			
		}
		
		public JComboBox get_comboBox_project() {
			
			return comboBox_pj;
		}
}
