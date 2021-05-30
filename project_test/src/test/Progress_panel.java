package test;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;

public class Progress_panel {
	
	public JPanel progress_panel;
	private JTextField text_projectID;
	private JTextField text_empID;
	private JTable maint_table;
	
	
	
	public Progress_panel() {
		
		panel();
	}
	
	
	private void panel() {
		
		progress_panel = new JPanel();
		Term_project_main.container_panel.add(progress_panel,"progress");
		progress_panel.setLayout(null);
		
		JLabel lbl_progress = new JLabel("Progress");
		lbl_progress.setBounds(48, 12, 54, 16);
		progress_panel.add(lbl_progress);
		
		JLabel lbl_projectID = new JLabel("Project ID :");
		lbl_projectID.setBounds(73, 85, 69, 29);
		progress_panel.add(lbl_projectID);
		
		text_projectID = new JTextField();
		text_projectID.setBounds(146, 86, 119, 26);
		progress_panel.add(text_projectID);
		text_projectID.setColumns(10);
		
		JButton btn_proj_inquire = new JButton("Inquire");
		btn_proj_inquire.setBounds(501, 85, 88, 29);
		progress_panel.add(btn_proj_inquire);
		
		JLabel lbl_empID = new JLabel("Employee ID :");
		lbl_empID.setBounds(56, 139, 86, 33);
		progress_panel.add(lbl_empID);
		
		text_empID = new JTextField();
		text_empID.setBounds(146, 142, 119, 26);
		progress_panel.add(text_empID);
		text_empID.setColumns(10);
		
		JButton btn_proj_last20 = new JButton("Last 20");
		btn_proj_last20.setBounds(501, 141, 90, 29);
		progress_panel.add(btn_proj_last20);
		
		maint_table = new JTable();
		maint_table.setBounds(40, 229, 580, 156);
		progress_panel.add(maint_table);
		
		JButton btn_back2project = new JButton("");
		btn_back2project.setBounds(4, 5, 34, 32);
		btn_back2project.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
			}
		});
		Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
		go_back = go_back.getScaledInstance(21, 21,  java.awt.Image.SCALE_AREA_AVERAGING) ;
		btn_back2project.setIcon(new ImageIcon(go_back));
		progress_panel.add(btn_back2project);
	}
}
