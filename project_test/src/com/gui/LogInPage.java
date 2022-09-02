package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInPage
{
	public static final String LOGIN = "login";
	
	private JPanel loginPanel;
	
	private JLabel empIdLabel;
	
	private JLabel resultLabel;
	
	private JTextField empIdTextField;
	
	private JButton loginBtn;
	
	private String tempAccount = "A005759";
	
	public LogInPage()
	{
		// JPanel containerPanel = frame.getContainerPanel();
		
		loginPanel = new JPanel();
		Frame.frame.getContentPane().add(loginPanel, LOGIN);
		loginPanel.setLayout(null);
		
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
				
				if (empIdTextField.getText().equals(tempAccount))
				{
					Frame.cardLayout.show(Frame.frame.getContentPane(), HomePage.HOME);
					HomePage.homeCardLayout.show(Frame.containerPanel, HomePage.HOME);
				}
				else
				{
					resultLabel.setText("Employee ID is invalid, please refill it.");
				}
			}
		});
		loginBtn.setBounds(607, 187, 117, 29);
		loginPanel.add(loginBtn);
	}
	
	private void setEmpIdTextField()
	{
		empIdTextField = new JTextField();
		empIdTextField.setBounds(415, 187, 163, 26);
		loginPanel.add(empIdTextField);
		empIdTextField.setColumns(10);
		empIdTextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
	}
	
	private void setResultLabel()
	{
		resultLabel = new JLabel("");
		resultLabel.setBounds(286, 246, 438, 26);
		loginPanel.add(resultLabel);
	}
	
	private void setEmpIdLabel()
	{
		empIdLabel = new JLabel("Employee ID :");
		empIdLabel.setBounds(286, 192, 104, 16);
		loginPanel.add(empIdLabel);
	}
}
