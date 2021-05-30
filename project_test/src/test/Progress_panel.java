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
	private JTextField text_prog_pjID;
	private JTextField text_prog_empID;
	private JTable prog_table;
	
	
	
	public Progress_panel() {
		
		panel();
	}
	
	
	private void panel() {
		
		progress_panel = new JPanel();
		Term_project_main.container_panel.add(progress_panel,"progress");
		progress_panel.setLayout(null);
		
		JLabel lbl_prog = new JLabel("Progress");
		lbl_prog.setBounds(48, 12, 54, 16);
		progress_panel.add(lbl_prog);
		
		JLabel lbl_prog_pjID = new JLabel("Project ID :");
		lbl_prog_pjID.setBounds(73, 85, 69, 29);
		progress_panel.add(lbl_prog_pjID);
		
		text_prog_pjID = new JTextField();
		text_prog_pjID.setBounds(146, 86, 119, 26);
		progress_panel.add(text_prog_pjID);
		text_prog_pjID.setColumns(10);
		
		JButton btn_prog_inquire = new JButton("Inquire");
		btn_prog_inquire.setBounds(501, 85, 88, 29);
		progress_panel.add(btn_prog_inquire);
		
		JLabel lbl_prog_empID = new JLabel("Employee ID :");
		lbl_prog_empID.setBounds(56, 139, 86, 33);
		progress_panel.add(lbl_prog_empID);
		
		text_prog_empID = new JTextField();
		text_prog_empID.setBounds(146, 142, 119, 26);
		progress_panel.add(text_prog_empID);
		text_prog_empID.setColumns(10);
		
		JButton btn_prog_last20 = new JButton("Last 20");
		btn_prog_last20.setBounds(501, 141, 90, 29);
		progress_panel.add(btn_prog_last20);
		
		prog_table = new JTable();
		prog_table.setBounds(40, 229, 580, 156);
		progress_panel.add(prog_table);
		
		JButton btn_back2pj = new JButton("");
		btn_back2pj.setBounds(4, 5, 34, 32);
		btn_back2pj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Term_project_main.cl_home.show(Term_project_main.container_panel, "project");
			}
		});
		Image go_back = new ImageIcon(this.getClass().getResource("/go_back.jpeg")).getImage();
		go_back = go_back.getScaledInstance(21, 21,  java.awt.Image.SCALE_AREA_AVERAGING) ;
		btn_back2pj.setIcon(new ImageIcon(go_back));
		progress_panel.add(btn_back2pj);
	}
}
