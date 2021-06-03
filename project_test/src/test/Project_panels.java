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
		
		JButton btn_pj_maint = new JButton("Maintenance");
		btn_pj_maint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pj_subpanels.get_comboBox_project().setSelectedIndex(0);
				 Term_project_main.cl_home.show(Term_project_main.container_panel,"maintenance");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_pj_maint.setBounds(130, 98, 123, 29);
		project_panel.add(btn_pj_maint);
		
		JLabel lbl_pj_maint = new JLabel("Project Inquiring, Modifying...");
		lbl_pj_maint.setBounds(315, 104, 187, 16);
		project_panel.add(lbl_pj_maint);
		
		JButton btn_pj_prog= new JButton("Progress ");
		btn_pj_prog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Term_project_main.cl_home.show(Term_project_main.container_panel,"progress");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_pj_prog.setBounds(130, 192, 123, 29);
		project_panel.add(btn_pj_prog);
		
		JLabel lbl_pj_prog = new JLabel("Project Progess Inquiring");
		lbl_pj_prog.setBounds(315, 198, 187, 16);
		project_panel.add(lbl_pj_prog);
		
		JButton btn_pj_sheet = new JButton("Sheets");
		btn_pj_sheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 sheets_panel.get_comboBox_sheets().setSelectedIndex(0);
				 Term_project_main.cl_home.show(Term_project_main.container_panel,"sheets");
				 //btn_back2Project.setVisible(true);
			}
		});
		btn_pj_sheet.setBounds(130, 286, 123, 29);
		project_panel.add(btn_pj_sheet);
		
		JLabel lbl_pj_sheet = new JLabel("Sheets' Maintenance");
		lbl_pj_sheet.setBounds(315, 292, 187, 16);
		project_panel.add(lbl_pj_sheet);
		
		JLabel lbl_pj = new JLabel("Project");
		lbl_pj.setBounds(6, 6, 61, 16);
		project_panel.add(lbl_pj);
		
		pj_subpanels = new Maintenance_panel("panel");
		sheets_panel = new Sheets_panel();
		prog_panel = new Progress_panel();
	}
}
