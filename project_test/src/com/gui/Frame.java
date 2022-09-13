package com.gui;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame
{
	public static JFrame frame;
	
	public static CardLayout cardLayout;
	
	public static JPanel containerPanel;
	
	@SuppressWarnings(value = { "unused" })
	public static void initialize()
	{
		Frame frame = new Frame();
	}
	
	private Frame()
	{
		setFrame();
		setContainerPanel();
	}
	
	private void setFrame()
	{
		frame = new JFrame("Supply Chain System");
		frame.setBounds(100, 100, 1000, 550);
		// frame.setBounds(100, 100, 666, 466);
		cardLayout = new CardLayout();
		frame.getContentPane().setLayout(cardLayout);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setContainerPanel()
	{
		containerPanel = new JPanel();
		containerPanel.setBounds(0, 26, 1000, 450);
		containerPanel.setBackground(Color.CYAN);
	}
}
