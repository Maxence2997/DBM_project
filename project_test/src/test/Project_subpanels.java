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

public class Project_subpanels  {
	
	/**
     * @autohr Jyun-An
     * @ver. 1.2.2 05/28   
     * Seperated from Project_test
     **/
	
		public JPanel core_maint_panel;
		private JPanel maint_container_panel;
		private JComboBox comboBox_project;
		
		private JPanel default_panel2;
		
		private JPanel inq_panel2;
		
		private JPanel mod_panel2;
		
		private JPanel append_panel2;
		
		private JPanel remove_panel2;
		private JLabel lbl_confirm;
		private JTextField text_confirm;
		private JButton btn_confirm;
		private JTable table;
		
		private JTable inq_table2;
		
		private JTable mod_table2;
		
		private JTable remove_table2;
		
		private JTextField text_projectID;
		private JTextField text_empID;
		private JTable maint_table;
		private JTextField textField_4;
		
		public JPanel progress_panel;
		
		private CardLayout cl_maint;
		
		
		
		
		
		public Project_subpanels() {
			proj_maintc_panels();
			proj_progress();
			
			
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
			
			
			comboBox_project = new JComboBox();
			comboBox_project.setBounds(52, 6, 126, 27);
			comboBox_project.addItem("--------");
			comboBox_project.addItem("Inquire");
			comboBox_project.addItem("Modify");
			comboBox_project.addItem("Append");
			comboBox_project.addItem("Remove");
			
			
			
			comboBox_project.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	String function = (String) comboBox_project.getSelectedItem(); //get the selected item
		
		                
		            	cl_maint.show(maint_container_panel, function);		                   
		            }
		        });
		
			core_maint_panel.add(comboBox_project);
			
			JButton btn_back2project = new JButton("");
			btn_back2project.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
				}
			});
			Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
			go_back = go_back.getScaledInstance( 20, 20,  java.awt.Image.SCALE_AREA_AVERAGING) ;
			btn_back2project.setIcon(new ImageIcon(go_back));
			btn_back2project.setBounds(16, 4, 30, 30);
			core_maint_panel.add(btn_back2project);
		}
		
		
		
		
		//default panel2
		private void add_default_panel() {
			default_panel2 = new JPanel();
			default_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(default_panel2, "--------");
			default_panel2.setLayout(null);
		}
		
		//first panel - Inquire 
		private void add_inquire_panel() {
			
			inq_panel2 = new JPanel();
			inq_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(inq_panel2, "Inquire");
			inq_panel2.setLayout(null);
			
					
			JLabel lbl_projectID = new JLabel("project ID :");
			lbl_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_projectID.setBounds(50, 11, 86, 16);
			inq_panel2.add(lbl_projectID);
					
			JTextField text_projectID = new JTextField();
			text_projectID.setBounds(136, 6, 141, 26);
			inq_panel2.add(text_projectID);
			text_projectID.setColumns(10);
					
			JLabel lbl_date = new JLabel("Est. Date :");
			lbl_date.setBounds(310, 11, 106, 16);
			lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
			inq_panel2.add(lbl_date);
					
			JTextField text_date = new JTextField();
			text_date.setBounds(416, 6, 105, 26);
			inq_panel2.add(text_date);
			text_date.setColumns(10);
					
			JButton btn_inquire = new JButton("Inquire");
			btn_inquire.setBounds(554, 5, 87, 29);
			btn_inquire.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//library.btn_inquire();
					inq_panel2.setVisible(true);
				}
			});
			inq_panel2.add(btn_inquire);
					
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(50, 45, 86, 16);
			inq_panel2.add(lbl_empID);
					
			JTextField text_empID = new JTextField();
			text_empID.setBounds(136, 40, 141, 26);
			inq_panel2.add(text_empID);
			text_empID.setColumns(10);
					
			
					
			JButton btn_last20 = new JButton("Last 20");
			btn_last20.setBounds(554, 39, 87, 29);
			btn_last20.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//library.btn_inquire();
					inq_panel2.setVisible(true);
				}
			});
			inq_panel2.add(btn_last20);
					
			JLabel lbl_note = new JLabel("Note : To inquire project, at least one of project ID and Employee ID must be filled in  ");
			lbl_note.setBounds(29, 73, 529, 16);
			inq_panel2.add(lbl_note);
					
			inq_table2 = new JTable();
			inq_table2.setBounds(29, 94, 612, 254);
			inq_panel2.add(inq_table2);
			inq_table2.setVisible(false);
		}
		
		//Second panel - Modify 
		private void add_modify_panel() {
			
			mod_panel2 = new JPanel();
			mod_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(mod_panel2, "Modify");
			mod_panel2.setLayout(null);
			
			JLabel lbl_projectID = new JLabel("*project ID :");
			lbl_projectID.setHorizontalAlignment(SwingConstants.RIGHT);
			lbl_projectID.setBounds(53, 41, 86, 16);
			mod_panel2.add(lbl_projectID);
			
			JTextField text_projectID = new JTextField();
			text_projectID.setBounds(143, 36, 115, 26);
			mod_panel2.add(text_projectID);
			text_projectID.setColumns(10);
			
			
			JButton btn_modify = new JButton("Modify");
			btn_modify.setBounds(539, 35, 87, 29);
			mod_panel2.add(btn_modify);
			
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(53, 104, 86, 16);
			mod_panel2.add(lbl_empID);
			
			JTextField textField = new JTextField();
			textField.setBounds(143, 99, 115, 26);
			mod_panel2.add(textField);
			textField.setColumns(10);
			
			JLabel lbl_date = new JLabel("Est. Date :");
			lbl_date.setBounds(288, 41, 88, 16);
			lbl_date.setHorizontalAlignment(SwingConstants.RIGHT);
			mod_panel2.add(lbl_date);
			
			JTextField text_date = new JTextField();
			text_date.setBounds(388, 36, 115, 26);
			mod_panel2.add(text_date);
			text_date.setColumns(10);
			
			mod_table2 = new JTable();
			mod_table2.setBounds(33, 252, 593, 66);
			mod_panel2.add(mod_table2);
		}
		
		//third panel - Append 
		private void add_append_panel() {
			
			append_panel2 = new JPanel();
			append_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(append_panel2, "Append");
			append_panel2.setLayout(null);
			
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(62, 101, 86, 16);
			append_panel2.add(lbl_empID);
			
			textField_4 = new JTextField();
			textField_4.setBounds(148, 96, 116, 26);
			append_panel2.add(textField_4);
			textField_4.setColumns(10);
			
			JButton btn_append = new JButton("Append");
			btn_append.setBounds(471, 95, 92, 29);
			append_panel2.add(btn_append);
			
			JLabel lbl_error = new JLabel("Employee ID inputed is invalid, please verify it.");
			lbl_error.setBounds(62, 159, 318, 16);
			append_panel2.add(lbl_error);
			lbl_error.setVisible(false);
			
			table = new JTable();
			table.setBounds(58, 205, 563, 39);
			append_panel2.add(table);
			
			
			
		}
		
		//forth panel - Remove 
		private void add_remove_panel() {
					
			remove_panel2 = new JPanel();
			remove_panel2.setBounds(0, 0, 666, 348);
			maint_container_panel.add(remove_panel2, "Remove");
			remove_panel2.setLayout(null);
			
			JLabel lbl_projectID = new JLabel("*project ID :");
			lbl_projectID.setBounds(81, 41, 86, 16);
			remove_panel2.add(lbl_projectID);
			
			JTextField text_projectID = new JTextField();
			text_projectID.setBounds(167, 36, 146, 26);
			remove_panel2.add(text_projectID);
			text_projectID.setColumns(10);
			
			JButton btn_remove = new JButton("Remove");
			btn_remove.setBounds(494, 35, 93, 29);
			btn_remove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//library.btn_remove();
					remove_table2.setVisible(true);
					lbl_confirm.setVisible(true);
					text_confirm.setVisible(true);
					btn_confirm.setVisible(true);
				}
			});
			remove_panel2.add(btn_remove);
			
			remove_table2 = new JTable();
			remove_table2.setBounds(81, 159, 506, 25);
			remove_panel2.add(remove_table2);
			remove_table2.setVisible(false);
			
			lbl_confirm = new JLabel("Please write down \"I'm PRETTY SURE that I would like to remove this sheet.\"");
			lbl_confirm.setBounds(81, 189, 506, 16);
			remove_panel2.add(lbl_confirm);
			lbl_confirm.setVisible(false);
			
			text_confirm = new JTextField();
			text_confirm.setBounds(81, 210, 506, 26);
			remove_panel2.add(text_confirm);
			text_confirm.setColumns(10);
			text_confirm.setVisible(false);
			
			btn_confirm = new JButton("Confirm");
			btn_confirm.setBounds(494, 301, 93, 29);
			remove_panel2.add(btn_confirm);
			btn_confirm.setVisible(false);
		
			}
		
		
		
		private void proj_progress() {
			
			progress_panel = new JPanel();
			Term_project_main.container_panel.add(progress_panel,"progress");
			progress_panel.setLayout(null);
			
			JLabel lbl_progress = new JLabel("Progress");
			lbl_progress.setBounds(4, 5, 58, 16);
			progress_panel.add(lbl_progress);
			
			JLabel lbl_projectID = new JLabel("Project ID :");
			lbl_projectID.setBounds(79, 26, 69, 33);
			progress_panel.add(lbl_projectID);
			
			text_projectID = new JTextField();
			text_projectID.setBounds(152, 29, 119, 26);
			progress_panel.add(text_projectID);
			text_projectID.setColumns(10);
			
			JButton btn_proj_inquire = new JButton("Inquire");
			btn_proj_inquire.setBounds(507, 28, 88, 29);
			progress_panel.add(btn_proj_inquire);
			
			JLabel lbl_empID = new JLabel("Employee ID :");
			lbl_empID.setBounds(62, 94, 86, 33);
			progress_panel.add(lbl_empID);
			
			text_empID = new JTextField();
			text_empID.setBounds(152, 97, 119, 26);
			progress_panel.add(text_empID);
			text_empID.setColumns(10);
			
			JButton btn_proj_last20 = new JButton("Last 20");
			btn_proj_last20.setBounds(507, 96, 90, 29);
			progress_panel.add(btn_proj_last20);
			
			maint_table = new JTable();
			maint_table.setBounds(62, 162, 622, 191);
			progress_panel.add(maint_table);
		}
		
		
		
		public JComboBox get_comboBox_project() {
			
			return comboBox_project;
		}
}
