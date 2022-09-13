package com.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class EmployeePage
{
	public static final String EMPLOYEE = "employee";
	
	public static JComboBox actionComboBox;
	
	private JPanel panel;
	
	private JLabel firstNameLabel;
	
	private JTextField firstNameTextField;
	
	private JLabel lastNameLabel;
	
	private JTextField lastNameTextField;
	
	private JLabel addressLabel;
	
	private JTextField addressTextField;
	
	private JLabel phoneLabel;
	
	private JTextField phoneTextField;
	
	private JLabel supervIdLabel;
	
	private JTextField supervIdTextField;
	
	private JLabel perfLabel;
	
	private JComboBox perfComboBox;
	
	private JButton checkIdBtn;
	
	private JButton executeBtn;
	
	private JLabel showIdLabel;
	
	private JLabel infoLabel;
	
	private JLabel idLabel;
	
	private JTextField idTextField;
	
	private JTable table;
	
	private JScrollPane scrollpane;
	
	private JButton showMoreBtn;
	
	private JButton clearBtn;
	
	public static void initialize()
	{
		EmployeePage page = new EmployeePage();
	}
	
	private EmployeePage()
	{
		panel = new JPanel();
		panel.setBounds(0, 26, 1000, 450);
		Frame.containerPanel.add(panel, EMPLOYEE);
		panel.setLayout(null);
		
		showIdLabel = new JLabel("");
		showIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		showIdLabel.setBounds(393, 75, 202, 16);
		showIdLabel.setVisible(false);
		panel.add(showIdLabel);
		
		idLabel = new JLabel("Employee ID :");
		idLabel.setBounds(271, 75, 86, 16);
		panel.add(idLabel);
		
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.CENTER);
		idTextField.setBounds(393, 68, 202, 26);
		panel.add(idTextField);
		idTextField.setColumns(16);
		
		firstNameLabel = new JLabel("First Name :");
		firstNameLabel.setBounds(271, 103, 76, 16);
		firstNameLabel.setVisible(false);
		panel.add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameTextField.setBounds(393, 97, 202, 26);
		firstNameTextField.setVisible(false);
		panel.add(firstNameTextField);
		firstNameTextField.setColumns(16);
		
		lastNameLabel = new JLabel("Last Name :");
		lastNameLabel.setBounds(271, 129, 74, 16);
		lastNameLabel.setVisible(false);
		panel.add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameTextField.setBounds(393, 123, 202, 26);
		lastNameTextField.setVisible(false);
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(16);
		
		addressTextField = new JTextField();
		addressTextField.setHorizontalAlignment(SwingConstants.CENTER);
		addressTextField.setBounds(393, 149, 202, 26);
		addressTextField.setVisible(false);
		
		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(271, 155, 59, 16);
		addressLabel.setVisible(false);
		panel.add(addressLabel);
		panel.add(addressTextField);
		addressTextField.setColumns(16);
		
		phoneLabel = new JLabel("Phone Number :");
		phoneLabel.setBounds(271, 181, 100, 16);
		phoneLabel.setVisible(false);
		panel.add(phoneLabel);
		
		phoneTextField = new JTextField();
		phoneTextField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTextField.setBounds(393, 175, 202, 26);
		phoneTextField.setVisible(false);
		panel.add(phoneTextField);
		phoneTextField.setColumns(16);
		
		supervIdLabel = new JLabel("Supervisor ID :");
		supervIdLabel.setBounds(271, 207, 92, 16);
		supervIdLabel.setVisible(false);
		panel.add(supervIdLabel);
		
		supervIdTextField = new JTextField();
		supervIdTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supervIdTextField.setBounds(393, 201, 202, 26);
		supervIdTextField.setVisible(false);
		panel.add(supervIdTextField);
		supervIdTextField.setColumns(16);
		
		perfLabel = new JLabel("Performance :");
		perfLabel.setBounds(271, 236, 86, 16);
		perfLabel.setVisible(false);
		panel.add(perfLabel);
		
		infoLabel = new JLabel("Message of execute result");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(178, 302, 650, 16);
		infoLabel.setVisible(false);
		panel.add(infoLabel);
		
		table = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}// uneditable
		};
		table.setFillsViewportHeight(true);
		// emp_table.setBounds(48,288,563,30);
		table.setVisible(false);
		
		scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(178, 330, 650, 80);
		scrollpane.setVisible(false);
		// scrollpane.setPreferredSize(new Dimension(563, 50)); //whole scrollpane and
		// table will disapear
		panel.add(scrollpane);
		
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				clearLabelAndField();
				
				if (actionComboBox.getSelectedItem().equals("Delete Employee")
						| actionComboBox.getSelectedItem().equals("Show & Adjust"))
				{
					clearBtn.setVisible(false);
					
					infoLabel.setVisible(false);
					showIdLabel.setVisible(false);
					idTextField.setVisible(true);
					
					setElementsVisible(false);
				}
			}
		});
		clearBtn.setBounds(623, 115, 95, 29);
		panel.add(clearBtn);
		
		perfComboBox = new JComboBox();
		perfComboBox.setBounds(393, 230, 65, 27);
		perfComboBox.setForeground(Color.BLACK);
		perfComboBox.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C" }));
		perfComboBox.setVisible(false);
		panel.add(perfComboBox);
		
		actionComboBox = new JComboBox();
		actionComboBox.setBounds(414, 36, 160, 27);
		actionComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Show & Adjust", "Add Employee", "Delete Employee" }));
		actionComboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String actionOfComboBox = ((String) actionComboBox.getSelectedItem()).toLowerCase();
			}
		});
		panel.add(actionComboBox);
		
		checkIdBtn = new JButton("Confirm");
		checkIdBtn.setBounds(623, 68, 95, 29);
		checkIdBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		panel.add(checkIdBtn);
		
		executeBtn = new JButton(); // btn_save_change. btn_add and btn_delete
		executeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		executeBtn.setBounds(605, 236, 114, 29);
		executeBtn.setVisible(false);
		panel.add(executeBtn);
		
		showMoreBtn = new JButton("Show more");
		showMoreBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		});
		showMoreBtn.setBounds(734, 264, 100, 29);
		panel.add(showMoreBtn);
	}
	
	private void clearLabelAndField()
	{
		idTextField.setText("");
		firstNameTextField.setText("");
		lastNameTextField.setText("");
		addressTextField.setText("");
		phoneTextField.setText("");
		supervIdTextField.setText("");
		perfComboBox.setSelectedIndex(0);
		showIdLabel.setText("");
		infoLabel.setText("");
	}
	
	private void setElementsVisible(boolean bl)
	{
		firstNameLabel.setVisible(bl);
		firstNameTextField.setVisible(bl);
		
		lastNameLabel.setVisible(bl);
		lastNameTextField.setVisible(bl);
		
		addressLabel.setVisible(bl);
		addressTextField.setVisible(bl);
		
		phoneLabel.setVisible(bl);
		phoneTextField.setVisible(bl);
		
		supervIdLabel.setVisible(bl);
		supervIdTextField.setVisible(bl);
		
		perfLabel.setVisible(bl);
		perfComboBox.setVisible(bl);
		
		executeBtn.setVisible(bl);
		
		table.setVisible(bl);
		scrollpane.setVisible(bl);
		showMoreBtn.setVisible(bl);
	}
}
