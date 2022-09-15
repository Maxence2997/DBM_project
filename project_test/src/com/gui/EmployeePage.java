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
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeePage
{
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
		Frame.containerPanel.add(panel, PageConstant.EMPLOYEE);
		panel.setLayout(null);
		
		setShowIdLabel();
		
		setIdLabel();
		setIdTextField();
		
		setFirstNameLabel();
		setFirstNameTextField();
		
		setLastNameLabel();
		setLastNameTextField();
		
		setAddressLabel();
		setAddressTextField();
		
		setPhoneLabel();
		setPhoneTextField();
		
		setSupervIdLabel();
		setSupervIdTextField();
		
		setPerfLabel();
		setPerfComboBox();
		
		setInfoLabel();
		
		setTable();
		
		setScrollpane();
		
		setClearBtn();
		
		setActionComboBox();
		
		setCheckIdBtn();
		
		setExecuteBtn();
		
		setShowMoreBtn();
	}
	
	public void setActionComboBox()
	{
		String[] action = { "Show & Adjust", "Add Employee", "Delete Employee" };
		actionComboBox = new JComboBox();
		actionComboBox.setBounds(414, 36, 160, 27);
		actionComboBox.setModel(new DefaultComboBoxModel(action));
		actionComboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				clearLabelAndField();
				String actionOfComboBox = ((String) actionComboBox.getSelectedItem()).toLowerCase();
				
				switch (actionOfComboBox)
				{
					case "show & adjust":
						setShowAndAdjustUI();
						break;
					
					case "add employee":
						setAddEmpUI(HomePage.userIsSuperv);
						break;
					
					case "delete employee":
						setDeleteUI(HomePage.userIsSuperv);
						break;
				}
			}
		});
		panel.add(actionComboBox);
	}
	
	private void setFirstNameLabel()
	{
		firstNameLabel = new JLabel("First Name :");
		firstNameLabel.setBounds(271, 103, 76, 16);
		firstNameLabel.setVisible(false);
		panel.add(firstNameLabel);
	}
	
	private void setFirstNameTextField()
	{
		firstNameTextField = new JTextField();
		firstNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameTextField.setBounds(393, 97, 202, 26);
		firstNameTextField.setVisible(false);
		panel.add(firstNameTextField);
		firstNameTextField.setColumns(16);
	}
	
	private void setLastNameLabel()
	{
		lastNameLabel = new JLabel("Last Name :");
		lastNameLabel.setBounds(271, 129, 74, 16);
		lastNameLabel.setVisible(false);
		panel.add(lastNameLabel);
	}
	
	private void setLastNameTextField()
	{
		lastNameTextField = new JTextField();
		lastNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameTextField.setBounds(393, 123, 202, 26);
		lastNameTextField.setVisible(false);
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(16);
	}
	
	private void setAddressLabel()
	{
		addressLabel = new JLabel("Address :");
		addressLabel.setBounds(271, 155, 59, 16);
		addressLabel.setVisible(false);
		panel.add(addressLabel);
	}
	
	private void setAddressTextField()
	{
		addressTextField = new JTextField();
		addressTextField.setHorizontalAlignment(SwingConstants.CENTER);
		addressTextField.setBounds(393, 149, 202, 26);
		addressTextField.setVisible(false);
		addressTextField.setColumns(16);
		panel.add(addressTextField);
	}
	
	private void setPhoneLabel()
	{
		phoneLabel = new JLabel("Phone Number :");
		phoneLabel.setBounds(271, 181, 100, 16);
		phoneLabel.setVisible(false);
		panel.add(phoneLabel);
	}
	
	private void setPhoneTextField()
	{
		phoneTextField = new JTextField();
		phoneTextField.setHorizontalAlignment(SwingConstants.CENTER);
		phoneTextField.setBounds(393, 175, 202, 26);
		phoneTextField.setVisible(false);
		phoneTextField.setColumns(16);
		panel.add(phoneTextField);
	}
	
	private void setSupervIdLabel()
	{
		supervIdLabel = new JLabel("Supervisor ID :");
		supervIdLabel.setBounds(271, 207, 92, 16);
		supervIdLabel.setVisible(false);
		panel.add(supervIdLabel);
	}
	
	private void setSupervIdTextField()
	{
		supervIdTextField = new JTextField();
		supervIdTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supervIdTextField.setBounds(393, 201, 202, 26);
		supervIdTextField.setVisible(false);
		supervIdTextField.setColumns(16);
		panel.add(supervIdTextField);
	}
	
	private void setPerfLabel()
	{
		perfLabel = new JLabel("Performance :");
		perfLabel.setBounds(271, 236, 86, 16);
		perfLabel.setVisible(false);
		panel.add(perfLabel);
	}
	
	private void setPerfComboBox()
	{
		perfComboBox = new JComboBox();
		perfComboBox.setBounds(393, 230, 65, 27);
		perfComboBox.setForeground(Color.BLACK);
		perfComboBox.setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C" }));
		perfComboBox.setVisible(false);
		panel.add(perfComboBox);
	}
	
	private void setCheckIdBtn()
	{
		checkIdBtn = new JButton("Check Id");
		checkIdBtn.setBounds(623, 68, 95, 29);
		checkIdBtn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// query employee details by service
				// and display the details on the UI
			}
		});
		panel.add(checkIdBtn);
	}
	
	private void setExecuteBtn()
	{
		executeBtn = new JButton();
		executeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				execute();
			}
		});
		executeBtn.setBounds(605, 236, 114, 29);
		executeBtn.setVisible(false);
		panel.add(executeBtn);
	}
	
	private void setShowIdLabel()
	{
		showIdLabel = new JLabel("");
		showIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		showIdLabel.setBounds(393, 75, 202, 16);
		showIdLabel.setVisible(false);
		panel.add(showIdLabel);
	}
	
	private void setInfoLabel()
	{
		infoLabel = new JLabel("Message of execute result");
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		infoLabel.setBounds(178, 302, 650, 16);
		infoLabel.setVisible(false);
		panel.add(infoLabel);
	}
	
	private void setIdLabel()
	{
		idLabel = new JLabel("Employee ID :");
		idLabel.setBounds(271, 75, 86, 16);
		panel.add(idLabel);
	}
	
	private void setIdTextField()
	{
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.CENTER);
		idTextField.setBounds(393, 68, 202, 26);
		panel.add(idTextField);
		idTextField.setColumns(16);
	}
	
	private void setTable()
	{
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
	}
	
	private void setScrollpane()
	{
		scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(178, 330, 650, 80);
		scrollpane.setVisible(false);
		// scrollpane.setPreferredSize(new Dimension(563, 50)); //whole scrollpane and
		// table will disapear
		panel.add(scrollpane);
	}
	
	private void setShowMoreBtn()
	{
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
	
	private void setClearBtn()
	{
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				clearLabelAndField();
				
				if (actionComboBox.getSelectedItem().equals("Delete Employee")
						|| actionComboBox.getSelectedItem().equals("Show & Adjust"))
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
	
	private void setShowAndAdjustUI()
	{
		executeBtn.setText("Save Change");
		setElementsVisible(false);
		infoLabel.setVisible(false);
		idLabel.setVisible(true);
		showIdLabel.setVisible(false);
		idTextField.setVisible(true);
		checkIdBtn.setVisible(true);
		clearBtn.setVisible(false);
		showIdLabel.setVisible(false);
		idTextField.setVisible(true);
		checkIdBtn.setVisible(true);
		clearBtn.setVisible(false);
	}
	
	private void setAddEmpUI(boolean isSuperv)
	{
		executeBtn.setText("Add");
		
		idTextField.setVisible(false);
		checkIdBtn.setVisible(false);
		
		if (isSuperv)
		{
			setElementsVisible(true);
			table.setVisible(false);
			scrollpane.setVisible(false);
			showMoreBtn.setVisible(false);
			infoLabel.setVisible(false);
			idLabel.setVisible(true);
			showIdLabel.setText("");
			showIdLabel.setVisible(true);
			clearBtn.setVisible(true);
		}
		else
		{
			setElementsVisible(false);
			
			idLabel.setVisible(false);
			sendMsgByInfoLabel("Sorry, this function is only for supervisor.");
			showIdLabel.setVisible(false);
			clearBtn.setVisible(false);
		}
	}
	
	private void setDeleteUI(boolean isSuperv)
	{
		executeBtn.setText("Delete");
		
		setElementsVisible(false);
		
		clearBtn.setVisible(false);
		showIdLabel.setVisible(false);
		
		if (isSuperv)
		{
			idLabel.setVisible(true);
			infoLabel.setVisible(false);
			idTextField.setVisible(true);
			checkIdBtn.setVisible(true);
		}
		else
		{
			idLabel.setVisible(false);
			sendMsgByInfoLabel("Sorry, this function is only for supervisor.");
			idTextField.setVisible(false);
			checkIdBtn.setVisible(false);
		}
	}
	
	private void sendMsgByInfoLabel(String msg)
	{
		infoLabel.setText(msg);
		infoLabel.setVisible(true);
	}
	
	private void saveChange()
	{
		
		try
		{
			// update at DB by service
			
			sendMsgByInfoLabel("Modification succeed");
		}
		catch (Exception e)
		{
			sendMsgByInfoLabel("Modification failed");
			e.printStackTrace();
		}
	}
	
	private boolean verifySuperv()
	{
		String supervId = supervIdLabel.getText();
		boolean supervBlank = supervId.isBlank();
		
		boolean supervExists = false;
		
		if (!supervBlank)
		{
			supervExists = true;
		}
		// query DB by service to verify the supervisor id
		
		return (supervBlank || supervExists);
	}
	
	private void execute()
	{
		String action = executeBtn.getText().toLowerCase();
		String firstName = firstNameTextField.getText();
		String lastName = lastNameTextField.getText();
		boolean textFieldsvalid = true;
		boolean supervValid = true;
		
		if (action.equals("save change") || action.equals("add"))
		{
			textFieldsvalid = (!firstName.isBlank() && !lastName.isBlank());
			
			String msg = "";
			
			if (!textFieldsvalid)
			{
				msg += "Employee infos cannot be blank.";
			}
			supervValid = verifySuperv();
			
			if (!supervValid)
			{
				msg += "\nSupervisor ID is not in Employee table or format invalid.";
			}
			sendMsgByInfoLabel(msg);
		}
		
		if (textFieldsvalid && supervValid)
		{
			
			switch (action)
			{
				case "save change":
					saveChange();
					break;
				
				case "add":
					addEmployee();
					break;
				
				case "delete":
					deleteEmployee();
					break;
			}
		}
	}
	
	private void deleteEmployee()
	{
		
		try
		{
			// delete data into DB by service
			
			setDeleteUI(true);
			
			clearLabelAndField();
			sendMsgByInfoLabel("Request succeed");
		}
		catch (Exception e)
		{
			sendMsgByInfoLabel("Request failed");
			e.printStackTrace();
		}
	}
	
	private void addEmployee()
	{
		
		try
		{
			// insert data into DB by service
			// show new empId on the UI
			
			String newId = "EP000001";
			showIdLabel.setText(newId);
			showIdLabel.setVisible(true);
			sendMsgByInfoLabel("Employee added");
		}
		catch (Exception e)
		{
			sendMsgByInfoLabel("Request failed");
			e.printStackTrace();
		}
	}
}
