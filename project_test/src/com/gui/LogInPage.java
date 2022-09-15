package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInPage
{
	private JPanel panel;
	
	private JLabel empIdLabel;
	
	private JLabel resultLabel;
	
	public static JTextField empIdTextField;
	
	private JButton loginBtn;
	
	private String tempAccount = "A005759";
	
	@SuppressWarnings(value = { "unused" })
	public static void initialize()
	{
		LogInPage page = new LogInPage();
	}
	
	private LogInPage()
	{
		// JPanel containerPanel = frame.getContainerPanel();
		
		panel = new JPanel();
		Frame.frame.getContentPane().add(panel, PageConstant.LOGIN);
		panel.setLayout(null);
		
		setEmpIdLabel();
		setResultLabel();
		setEmpIdTextField();
		setLoginBtn();
	}
	
	private void setLoginBtn()
	{
		loginBtn = new JButton("Log-in");
		loginBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				logInAction();
			}
		});
		loginBtn.setBounds(607, 187, 117, 29);
		panel.add(loginBtn);
	}
	
	private void setEmpIdTextField()
	{
		empIdTextField = new JTextField();
		empIdTextField.setBounds(415, 187, 163, 26);
		panel.add(empIdTextField);
		empIdTextField.setColumns(10);
		empIdTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				logInAction();
			}
		});
	}
	
	private void logInAction()
	{
		// query DB by service
		String empId = empIdTextField.getText();
		
		if (empId.equals(tempAccount))
		{
			Frame.cardLayout.show(Frame.frame.getContentPane(), PageConstant.HOME);
			HomePage.homeCardLayout.show(Frame.containerPanel, PageConstant.HOME);
			HomePage.empIdLabel.setText(empId);
			// query DB by service to check the user is supervisor or not.
			HomePage.userIsSuperv = true;
		}
		else
		{
			resultLabel.setText("Employee ID is invalid, please refill it.");
		}
	}
	
	private void setResultLabel()
	{
		resultLabel = new JLabel("");
		resultLabel.setBounds(286, 246, 438, 26);
		panel.add(resultLabel);
	}
	
	private void setEmpIdLabel()
	{
		empIdLabel = new JLabel("Employee ID :");
		empIdLabel.setBounds(286, 192, 104, 16);
		panel.add(empIdLabel);
	}
	
	public static void clearTextField()
	{
		empIdTextField.setText("");
	}
}
