package com.gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomePage
{
	public static final String HOME = "home";
	
	private JPanel homePanel;
	
	public static CardLayout homeCardLayout;
	
	private JPanel coreHomePanel;
	
	private JButton homeBtn;
	
	private JButton logoutBtn;
	
	private JButton reminderBtn;
	
	private JButton projectBtn;
	
	private JButton inventoryBtn;
	
	private JButton supplierBtn;
	
	private JButton employeeBtn;
	
	private JLabel empIdLabel;
	
	private JLabel prjBtnDescriptionLabel;
	
	private JLabel invBtnDescriptionLabel;
	
	private JLabel supBtnDescriptionLabel;
	
	private JLabel empBtnDescriptionLabel;
	
	public HomePage()
	{
		// home panel which contains only EMPID, button log-out, btn_reminder and button
		
		homePanel = new JPanel();
		Frame.frame.getContentPane().add(homePanel, HOME);
		homePanel.setLayout(null);
		
		setLogoutBtn();
		setEmpIdLabel();
		setReminderBtn();
		setHomeBtn(Frame.containerPanel);
		
		homeCardLayout = new CardLayout();
		Frame.containerPanel.setLayout(homeCardLayout);
		homePanel.add(Frame.containerPanel);
		
		coreHomePanel = new JPanel();
		Frame.containerPanel.add(coreHomePanel, "home");
		
		setProjectBtn();
		setPrjBtnDescriptionLabel();
		
		setInventoryBtn();
		setInvBtnDescriptionLabel();
		
		setSupplierBtn();
		setSupBtnDescriptionLabel();
		
		setEmployeeBtn();
		setEmpBtnDescriptionLabel();
	}
	
	private void setHomeBtn(JPanel containerPanel)
	{
		homeBtn = new JButton("Home");
		homeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				homeCardLayout.show(containerPanel, HOME);
			}
		});
		homeBtn.setBounds(913, 488, 81, 29);
		homePanel.add(homeBtn);
	}
	
	private void setEmployeeBtn()
	{
		employeeBtn = new JButton("Employee");
		employeeBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		employeeBtn.setBounds(334, 346, 103, 29);
		coreHomePanel.add(employeeBtn);
	}
	
	private void setSupBtnDescriptionLabel()
	{
		supBtnDescriptionLabel = new JLabel("Suppliers' information maintenance");
		supBtnDescriptionLabel.setBounds(470, 260, 385, 16);
		coreHomePanel.add(supBtnDescriptionLabel);
	}
	
	private void setSupplierBtn()
	{
		supplierBtn = new JButton("Supplier");
		supplierBtn.setBounds(334, 254, 103, 29);
		supplierBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				SupplierPage.supComboBox.setSelectedIndex(0);
				SupplierPage.clearText();
				homeCardLayout.show(Frame.containerPanel, SupplierPage.SUPPLIER);
			}
		});
		coreHomePanel.add(supplierBtn);
	}
	
	private void setInvBtnDescriptionLabel()
	{
		invBtnDescriptionLabel = new JLabel("Inquire the vol. of Inventory");
		invBtnDescriptionLabel.setBounds(470, 169, 385, 16);
		coreHomePanel.add(invBtnDescriptionLabel);
	}
	
	private void setInventoryBtn()
	{
		inventoryBtn = new JButton("Inventory");
		inventoryBtn.setBounds(334, 163, 103, 29);
		inventoryBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// /**
				// * @editor: jyun an
				// *
				// * @since: 06/09/2021
				// */
				// inv_panel.clear();
				// cl_home.show(container_panel, "inventory");
			}
		});
		coreHomePanel.add(inventoryBtn);
	}
	
	private void setEmpBtnDescriptionLabel()
	{
		empBtnDescriptionLabel = new JLabel("Employees' information maintenance");
		empBtnDescriptionLabel.setBounds(470, 353, 385, 16);
		coreHomePanel.add(empBtnDescriptionLabel);
	}
	
	private void setLogoutBtn()
	{
		logoutBtn = new JButton("Log-out");
		logoutBtn.setBounds(0, 488, 96, 29);
		logoutBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int option = JOptionPane.showConfirmDialog(coreHomePanel, "Sure to logout?",
						"Logout", JOptionPane.YES_NO_OPTION);
				
				if (option == JOptionPane.YES_OPTION)
				{
					Frame.cardLayout.show(Frame.frame.getContentPane(), LogInPage.LOGIN);
				}
			}
		});
		homePanel.add(logoutBtn);
	}
	
	private void setReminderBtn()
	{
		reminderBtn = new JButton("Reminder");
		reminderBtn.setBounds(891, 0, 109, 26);
		reminderBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		homePanel.add(reminderBtn);
	}
	
	private void setEmpIdLabel()
	{
		empIdLabel = new JLabel();
		empIdLabel.setBounds(0, 5, 179, 16);
		homePanel.add(empIdLabel);
	}
	
	private void setProjectBtn()
	{
		projectBtn = new JButton("Project");
		projectBtn.setBounds(334, 71, 103, 29);
		projectBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// cl_home.show(container_panel, "project");
			}
		});
		coreHomePanel.setLayout(null);
		coreHomePanel.add(projectBtn);
	}
	
	private void setPrjBtnDescriptionLabel()
	{
		prjBtnDescriptionLabel = new JLabel("Project management ");
		prjBtnDescriptionLabel.setBounds(470, 77, 385, 16);
		coreHomePanel.add(prjBtnDescriptionLabel);
	}
}
