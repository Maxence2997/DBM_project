package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Project_panels {
		

	private JPanel project_panel;
	
	private Maintenance_panel pj_subpanels; //project subpanels 
	
	private Sheets_panel sheets_panel;  // sheets panels
	private Progress_panel prog_panel;
	
	public Project_panels() {
		
		panels();
	}
	
	
	
	
	private void panels() {
		
		project_panel = new JPanel();
		Term_project_main.container_panel.add(project_panel,"project");
		project_panel.setLayout(null);
		
		JButton btn_maint = new JButton("Maintenance");
		btn_maint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pj_subpanels.get_comboBox_project().setSelectedIndex(0);
				 Term_project_main.cl_home.show(Term_project_main.container_panel,"maintenance");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_maint.setBounds(130, 98, 123, 29);
		project_panel.add(btn_maint);
		
		JLabel lbl_project2 = new JLabel("Project Inquiring, Modifying...");
		lbl_project2.setBounds(315, 104, 187, 16);
		project_panel.add(lbl_project2);
		
		JButton btn_progress= new JButton("Progress ");
		btn_progress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Term_project_main.cl_home.show(Term_project_main.container_panel,"progress");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_progress.setBounds(130, 192, 123, 29);
		project_panel.add(btn_progress);
		
		JLabel lbl_progess = new JLabel("Project Progess Inquiring");
		lbl_progess.setBounds(315, 198, 187, 16);
		project_panel.add(lbl_progess);
		
		JButton btn_sheet = new JButton("Sheets");
		btn_sheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 sheets_panel.get_comboBox_sheets().setSelectedIndex(0);
				 Term_project_main.cl_home.show(Term_project_main.container_panel,"sheets");
				 //btn_back2Project.setVisible(true);
			}
		});
		btn_sheet.setBounds(130, 286, 123, 29);
		project_panel.add(btn_sheet);
		
		JLabel lbl_sheet = new JLabel("Sheets' Maintenance");
		lbl_sheet.setBounds(315, 292, 187, 16);
		project_panel.add(lbl_sheet);
		
		JLabel lbl_project = new JLabel("Project");
		lbl_project.setBounds(6, 6, 61, 16);
		project_panel.add(lbl_project);
		
		pj_subpanels = new Maintenance_panel();
		sheets_panel = new Sheets_panel();
		prog_panel = new Progress_panel();
	}
}
