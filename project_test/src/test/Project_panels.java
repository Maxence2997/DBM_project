package test;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Project_panels {

	private JPanel project_panel;

	private Maintenance_panel pj_subpanels; // project subpanels

	private Sheets_panel sheets_panel; // sheets panels
	private Progress_panel prog_panel;

	Project_panels() {

		project_panel = new JPanel();
		project_panel.setBounds(0, 26, 1000, 450);
		Term_project_main.container_panel.add(project_panel, "project");
		project_panel.setLayout(null);

		JButton btn_pj_maint = new JButton("Maintenance");
		btn_pj_maint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pj_subpanels.get_comboBox_project().setSelectedIndex(0);
				pj_subpanels.clear_inq_panel();
				Term_project_main.lib.adjust_PROJECT();
				Term_project_main.cl_home.show(Term_project_main.container_panel, "maintenance");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_pj_maint.setBounds(302, 126, 123, 29);
		project_panel.add(btn_pj_maint);

		JLabel lbl_pj_maint = new JLabel("Project Inquiring, Modifying...");
		lbl_pj_maint.setBounds(487, 132, 187, 16);
		project_panel.add(lbl_pj_maint);

		JButton btn_pj_prog = new JButton("Progress ");
		btn_pj_prog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Term_project_main.lib.adjust_PROJECT();
				prog_panel.clear();
				Term_project_main.cl_home.show(Term_project_main.container_panel, "progress");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_pj_prog.setBounds(302, 220, 123, 29);
		project_panel.add(btn_pj_prog);

		JLabel lbl_pj_prog = new JLabel("Project Progess Inquiring");
		lbl_pj_prog.setBounds(487, 226, 187, 16);
		project_panel.add(lbl_pj_prog);

		JButton btn_pj_sheet = new JButton("Sheets");
		btn_pj_sheet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Term_project_main.lib.adjust_PROJECT();
				sheets_panel.get_comboBox_sheets().setSelectedIndex(0);
				Term_project_main.cl_home.show(Term_project_main.container_panel, "sheets");
				// btn_back2Project.setVisible(true);
			}
		});
		btn_pj_sheet.setBounds(302, 314, 123, 29);
		project_panel.add(btn_pj_sheet);

		JLabel lbl_pj_sheet = new JLabel("Sheets' Maintenance");
		lbl_pj_sheet.setBounds(487, 320, 187, 16);
		project_panel.add(lbl_pj_sheet);

		JLabel lbl_pj = new JLabel("Project");
		lbl_pj.setBounds(26, 16, 61, 16);
		project_panel.add(lbl_pj);

		pj_subpanels = new Maintenance_panel();
		sheets_panel = new Sheets_panel();
		prog_panel = new Progress_panel();
	}
}
