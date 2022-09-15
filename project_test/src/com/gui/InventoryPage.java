package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class InventoryPage
{
	private JPanel panel;
	
	private static JTable table;
	
	private static JTextField idTextField;
	
	private JLabel projectIdLabel;
	
	private static JTextField projectTextField;
	
	private JLabel productIdLabel;
	
	private static JTextField productIdTextField;
	
	private static JScrollPane scrollpane;
	
	private static JLabel msgLabel;
	
	private JButton clearBtn;
	
	private JLabel idLabel;
	
	private JButton inquireBtn;
	
	public static void initialize()
	{
		InventoryPage page = new InventoryPage();
	}
	
	private InventoryPage()
	{
		panel = new JPanel();
		panel.setBounds(0, 26, 1000, 450);
		Frame.containerPanel.add(panel, PageConstant.INVENTORY);
		panel.setLayout(null);
		
		setIdLabel();
		setIdTextField();
		
		setProjectIdLabel();
		setProjectTextField();
		
		setProductIdLabel();
		setProductIdTextField();
		
		setInquireBtn();
		
		setTable();
		
		setScrollpane();
		
		setMsgLabel();
		
		setClearBtn();
	}
	
	private void setClearBtn()
	{
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				resetPageUI();
			}
		});
		clearBtn.setBounds(643, 177, 76, 29);
		panel.add(clearBtn);
	}
	
	private void setMsgLabel()
	{
		msgLabel = new JLabel("");
		msgLabel.setBounds(253, 230, 492, 16);
		msgLabel.setVisible(false);
		panel.add(msgLabel);
	}
	
	private void setScrollpane()
	{
		scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setBounds(245, 271, 508, 150);
		scrollpane.setVisible(false);
		panel.add(scrollpane);
	}
	
	private void setInquireBtn()
	{
		inquireBtn = new JButton("Inquire");
		inquireBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		inquireBtn.setBounds(554, 177, 88, 29);
		panel.add(inquireBtn);
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
		table.setBounds(33, 194, 604, 172);
		// inventory_panel.add(inv_table);
		table.setVisible(false);
	}
	
	private void setIdLabel()
	{
		idLabel = new JLabel("Inventory ID :");
		idLabel.setBounds(281, 62, 88, 16);
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(idLabel);
	}
	
	private void setProjectTextField()
	{
		projectTextField = new JTextField();
		projectTextField.setHorizontalAlignment(SwingConstants.CENTER);
		projectTextField.setBounds(386, 116, 112, 26);
		projectTextField.setColumns(10);
		panel.add(projectTextField);
	}
	
	private void setIdTextField()
	{
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.CENTER);
		idTextField.setBounds(386, 60, 108, 26);
		idTextField.setColumns(10);
		panel.add(idTextField);
	}
	
	private void setProjectIdLabel()
	{
		projectIdLabel = new JLabel("Project ID :");
		projectIdLabel.setBounds(281, 118, 88, 16);
		projectIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(projectIdLabel);
	}
	
	private void setProductIdLabel()
	{
		productIdLabel = new JLabel("Product ID :");
		productIdLabel.setBounds(259, 179, 110, 16);
		productIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(productIdLabel);
	}
	
	private void setProductIdTextField()
	{
		productIdTextField = new JTextField();
		productIdTextField.setHorizontalAlignment(SwingConstants.CENTER);
		productIdTextField.setBounds(386, 177, 108, 26);
		productIdTextField.setColumns(10);
		panel.add(productIdTextField);
	}
	
	public static void resetPageUI()
	{
		idTextField.setText("");
		projectTextField.setText("");
		productIdTextField.setText("");
		msgLabel.setText("");
		
		table.setVisible(false);
		scrollpane.setVisible(false);
	}
}
