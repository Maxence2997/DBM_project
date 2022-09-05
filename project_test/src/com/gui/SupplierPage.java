package com.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class SupplierPage
{
	public static final String SUPPLIER = "supplier";
	
	private JPanel supplierPanel;
	
	public static JTextField supIdTextField;
	
	public static JTextField supNameTextField;
	
	private JTable supTable;
	
	private JScrollPane scrollpane;
	
	// supplier panel variables needed for comboBox actionListener
	private String supplierFunction;
	
	private JLabel supAddressLabel;
	
	private JLabel supContactLabel;
	
	private JLabel supMobileLabel;
	
	private JLabel supMailLabel;
	
	public static JComboBox supComboBox;
	
	private JButton btn_sup_1;
	
	private JButton btn_sup_2;
	
	public static JTextField supAddressTextField;
	
	public static JTextField supContactTextField;
	
	public static JTextField supMobileTextField;
	
	public static JTextField supMailTextField;
	
	private JLabel supIdLabel;
	
	private JLabel supNameLabel;
	
	public static JLabel resultLabel;
	
	public static JLabel supIDShowLabel;
	
	private JButton clearBtn;
	
	private JButton showMoreBtn;
	
	public SupplierPage()
	{
		supplierPanel = new JPanel();
		supplierPanel.setBounds(0, 26, 1000, 450);
		supplierPanel.setLayout(null);
		Frame.containerPanel.add(supplierPanel, SUPPLIER);
		
		setSupIdLabel();
		setSupIdTextField();
		setSupIDShowLabel();
		
		setSupNameLabel();
		setSupNameTextField();
		
		setSupAddressLabel();
		setSupAddressTextField();
		
		setSupContactLabel();
		setSupContactTextField();
		
		setSupMobileLabel();
		setSupMobileTextField();
		
		setSupMailLabel();
		setSupMailTextField();
		
		setResultLabel();
		
		setShowMoreBtn();
		
		setSupTable();
		setScrollpane();
		
		setComboBox();
		
		setSupBtn1();
		
		setSupBtn2();
		
		setClearBtn();
	}
	
	private void setSupBtn2()
	{
		btn_sup_2 = new JButton("");
		btn_sup_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		btn_sup_2.setBounds(672, 219, 104, 29);
		btn_sup_2.setVisible(false);
		supplierPanel.add(btn_sup_2);
	}
	
	private void setSupBtn1()
	{
		btn_sup_1 = new JButton("");
		btn_sup_1.setBounds(616, 90, 88, 26);
		btn_sup_1.setVisible(true);
		btn_sup_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			}
		});
		supplierPanel.add(btn_sup_1);
	}
	
	private void setClearBtn()
	{
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				clearLabelAndField();
			}
		});
		clearBtn.setBounds(616, 133, 88, 29);
		clearBtn.setVisible(false);
		supplierPanel.add(clearBtn);
	}
	
	private void setComboBox()
	{
		supComboBox = new JComboBox();
		supComboBox.setBounds(447, 43, 135, 27);
		supComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "Inquire", "Add Supplier", "Add Product", "Delete" }));
		supplierFunction = (String) supComboBox.getSelectedItem();
		supComboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		supComboBox.setVisible(true);
		supplierPanel.add(supComboBox);
	}
	
	private void setScrollpane()
	{
		scrollpane = new JScrollPane(supTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(229, 287, 563, 81);
		scrollpane.setVisible(false);
		// scrollpane.setPreferredSize(new Dimension(563, 50)); //whole scrollpane and
		// table will disapear
		supplierPanel.add(scrollpane);
	}
	
	private void setSupTable()
	{
		supTable = new JTable()
		{
			@Override
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}// uneditable
		};
		supTable.setFillsViewportHeight(true);
		// sup_table.setBounds(48,288,563,30);
		supTable.setVisible(false);
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
		showMoreBtn.setBounds(675, 386, 117, 29);
		showMoreBtn.setVisible(false);
		
		supplierPanel.add(showMoreBtn);
	}
	
	private void setResultLabel()
	{
		resultLabel = new JLabel("");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(229, 258, 560, 16);
		resultLabel.setVisible(false);
		supplierPanel.add(resultLabel);
	}
	
	private void setSupMailTextField()
	{
		supMailTextField = new JTextField();
		supMailTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supMailTextField.setBounds(426, 220, 178, 26);
		supMailTextField.setVisible(false);
		supplierPanel.add(supMailTextField);
		supMailTextField.setColumns(14);
	}
	
	private void setSupMailLabel()
	{
		supMailLabel = new JLabel("Mail :");
		supMailLabel.setBounds(384, 225, 34, 16);
		supMailLabel.setVisible(false);
		supplierPanel.add(supMailLabel);
	}
	
	private void setSupMobileTextField()
	{
		supMobileTextField = new JTextField();
		supMobileTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supMobileTextField.setBounds(426, 193, 178, 26);
		supMobileTextField.setVisible(false);
		supMobileTextField.setColumns(14);
		supplierPanel.add(supMobileTextField);
	}
	
	private void setSupMobileLabel()
	{
		supMobileLabel = new JLabel("Mobile :");
		supMobileLabel.setBounds(368, 198, 50, 16);
		supMobileLabel.setVisible(false);
		supplierPanel.add(supMobileLabel);
	}
	
	private void setSupContactTextField()
	{
		supContactTextField = new JTextField();
		supContactTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supContactTextField.setBounds(426, 167, 178, 26);
		supContactTextField.setVisible(false);
		supContactTextField.setColumns(14);
		supplierPanel.add(supContactTextField);
	}
	
	private void setSupContactLabel()
	{
		supContactLabel = new JLabel("Contact :");
		supContactLabel.setBounds(361, 172, 57, 16);
		supContactLabel.setVisible(false);
		supplierPanel.add(supContactLabel);
	}
	
	private void setSupAddressTextField()
	{
		supAddressTextField = new JTextField();
		supAddressTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supAddressTextField.setBounds(426, 141, 178, 26);
		supAddressTextField.setColumns(14);
		supAddressTextField.setVisible(false);
		supplierPanel.add(supAddressTextField);
	}
	
	private void setSupAddressLabel()
	{
		supAddressLabel = new JLabel("");
		supAddressLabel.setBounds(359, 146, 59, 16);
		supAddressLabel.setVisible(false);
		supplierPanel.add(supAddressLabel);
	}
	
	private void setSupNameTextField()
	{
		supNameTextField = new JTextField();
		supNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supNameTextField.setBounds(426, 115, 178, 26);
		supplierPanel.add(supNameTextField);
		supNameTextField.setColumns(14);
	}
	
	private void setSupNameLabel()
	{
		supNameLabel = new JLabel("Name :");
		supNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		supNameLabel.setBounds(319, 120, 99, 16);
		supplierPanel.add(supNameLabel);
	}
	
	private void setSupIDShowLabel()
	{
		supIDShowLabel = new JLabel("");
		supIDShowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supIDShowLabel.setBounds(430, 94, 174, 16);
		supIDShowLabel.setVisible(false);
		supplierPanel.add(supIDShowLabel);
	}
	
	private void setSupIdTextField()
	{
		supIdTextField = new JTextField();
		supIdTextField.setHorizontalAlignment(SwingConstants.CENTER);
		supIdTextField.setBounds(426, 89, 178, 26);
		supplierPanel.add(supIdTextField);
		supIdTextField.setColumns(14);
	}
	
	private void setSupIdLabel()
	{
		supIdLabel = new JLabel("Supplier ID :");
		supIdLabel.setBounds(341, 94, 77, 16);
		supIdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		supplierPanel.add(supIdLabel);
	}
	
	public static void clearLabelAndField()
	{
		supIdTextField.setText("");
		supNameTextField.setText("");
		supAddressTextField.setText("");
		supContactTextField.setText("");
		supMobileTextField.setText("");
		supMailTextField.setText("");
		supIDShowLabel.setText("");
		resultLabel.setText("");
	}
}
