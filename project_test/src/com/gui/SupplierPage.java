package com.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class SupplierPage
{
	public static final String SUPPLIER = "supplier";
	
	private JPanel supplierPanel;
	
	private JTextField supIdTextField;
	
	private JTextField supNameTextField;
	
	private JTable supTable;
	
	private JScrollPane scrollpane;
	
	private JLabel supAddressLabel;
	
	private JLabel supContactLabel;
	
	private JLabel supMobileLabel;
	
	private JLabel supMailLabel;
	
	public static JComboBox supComboBox;
	
	private JButton btn1;
	
	private JButton btn2;
	
	private JTextField supAddressTextField;
	
	private JTextField supContactTextField;
	
	private JTextField supMobileTextField;
	
	private JTextField supMailTextField;
	
	private JLabel supIdLabel;
	
	private JLabel supNameLabel;
	
	private JLabel resultLabel;
	
	private JLabel supIdShowLabel;
	
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
		setSupIdShowLabel();
		
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
		
		setBtn1();
		
		setBtn2();
		
		setClearBtn();
	}
	
	private void setBtn2()
	{
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String function = btn2.getText().toLowerCase();
				
				switch (function)
				{
					case "delete":
						// do delete by service
						break;
					
					case "add supplier":
						// add supplier by service
						break;
					
					case "add product":
						// add product by service
						break;
				}
			}
		});
		btn2.setBounds(672, 219, 104, 29);
		btn2.setVisible(false);
		supplierPanel.add(btn2);
	}
	
	private void setBtn1()
	{
		btn1 = new JButton("");
		btn1.setBounds(616, 90, 88, 26);
		btn1.setVisible(true);
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String function = btn1.getText().toLowerCase();
				String functionOfComboBox = ((String) supComboBox.getSelectedItem()).toLowerCase();
				
				switch (function)
				{
					case "check":
						boolean checkForDeleting = functionOfComboBox.equals("delete");
						if (checkForDeleting)
						{
							btn1CheckForDeleting();
						}
						else
						{
							// check for adding product- check the supplier exists or not.
							btn1CheckForAddingProduct();
						}
						break;
					
					case "inquire":
						// query by service and show on the page
						boolean found = true;
						if (found)
						{
							// show something
						}
						else
						{
							showDataNotFound();
						}
						
						break;
				}
			}
		});
		supplierPanel.add(btn1);
	}
	
	private void setClearBtn()
	{
		clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				clearLabelAndField();
				setPage();
			}
		});
		clearBtn.setBounds(616, 133, 88, 29);
		clearBtn.setVisible(false);
		supplierPanel.add(clearBtn);
	}
	
	private void setComboBox()
	{
		String[] function = { "Inquire", "Add Supplier", "Add Product", "Delete" };
		supComboBox = new JComboBox();
		supComboBox.setBounds(447, 43, 135, 27);
		supComboBox.setModel(new DefaultComboBoxModel(function));
		// supplierFunction = (String) supComboBox.getSelectedItem();
		supComboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String functionOfComboBox = ((String) supComboBox.getSelectedItem()).toLowerCase();
				
				setElementsByComboBox(functionOfComboBox);
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
		// supTable.setBounds(48,288,563,30);
		supTable.setVisible(false);
	}
	
	private void setShowMoreBtn()
	{
		showMoreBtn = new JButton("Show more");
		showMoreBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// query by service
				String[][] data = null;
				boolean found = true;
				
				if (found)
				{
					String[] column_names = { "SupplierID", "Name", "Item", "Module" };
					
					JScrollPane scrollpane = new JScrollPane();
					JTable table = new JTable()
					{
						@Override
						public boolean isCellEditable(int row, int column)
						{
							return false;
						}// uneditable
					};
					
					DefaultTableModel supplierTableModel = new DefaultTableModel(data,
							column_names);
					table.setModel(supplierTableModel);
					scrollpane.setPreferredSize(new Dimension(600, 125));
					scrollpane.setViewportView(table);
					JOptionPane.showMessageDialog(null, scrollpane, "Supplier products Info", 1);
				}
				else
				{
					// not found
					resultLabel.setVisible(true);
					resultLabel.setText("No record for the products of the supplier");
				}
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
	
	private void setSupIdShowLabel()
	{
		supIdShowLabel = new JLabel("");
		supIdShowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		supIdShowLabel.setBounds(430, 94, 174, 16);
		supIdShowLabel.setVisible(false);
		supplierPanel.add(supIdShowLabel);
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
	
	private void clearLabelAndField()
	{
		supIdTextField.setText("");
		supNameTextField.setText("");
		supAddressTextField.setText("");
		supContactTextField.setText("");
		supMobileTextField.setText("");
		supMailTextField.setText("");
		supIdShowLabel.setText("");
		resultLabel.setText("");
	}
	
	private void setElementsByComboBox(String function)
	{
		clearLabelAndField();
		
		switch (function)
		{
			case "add supplier":
				supIdLabel.setVisible(true);
				supIdTextField.setVisible(false);
				supIdShowLabel.setVisible(true);
				
				supNameLabel.setVisible(true);
				supNameTextField.setVisible(true);
				
				supAddressLabel.setText("Address :");
				supAddressLabel.setVisible(true);
				supAddressTextField.setVisible(true);
				
				supContactLabel.setVisible(true);
				supContactTextField.setVisible(true);
				
				supMobileLabel.setVisible(true);
				supMobileTextField.setVisible(true);
				
				supMailLabel.setVisible(true);
				supMailTextField.setVisible(true);
				
				supTable.setVisible(false);
				scrollpane.setVisible(false);
				showMoreBtn.setVisible(false);
				
				btn1.setText("");
				btn1.setVisible(false);
				
				btn2.setText("Add Supplier");
				btn2.setVisible(true);
				
				clearBtn.setVisible(true);
				break;
			
			case "add product":
				btn1.setText("Check");
				btn1.setVisible(true);
				
				btn2.setText("Add Product");
				btn2.setVisible(false);
				
				clearBtn.setVisible(false);
				
				supIdTextField.setVisible(true);
				
				supAddressLabel.setText("Module :");
				supAddressLabel.setVisible(false);
				supAddressTextField.setVisible(false);
				
				supContactLabel.setVisible(false);
				supContactTextField.setVisible(false);
				
				supMobileLabel.setVisible(false);
				supMobileTextField.setVisible(false);
				
				supMailLabel.setVisible(false);
				supMailTextField.setVisible(false);
				
				supNameLabel.setVisible(false);
				supNameTextField.setVisible(false);
				
				supTable.setVisible(false);
				scrollpane.setVisible(false);
				showMoreBtn.setVisible(false);
				
				supIdTextField.setVisible(true);
				
				supIdShowLabel.setVisible(false);
				break;
			
			case "delete":
				btn1.setText("Check");
				btn1.setVisible(true);
				
				btn2.setText("Delete");
				btn2.setVisible(false);
				
				clearBtn.setVisible(false);
				
				supIdTextField.setVisible(true);
				
				supAddressLabel.setText("Address :");
				supAddressLabel.setVisible(false);
				supAddressTextField.setVisible(false);
				
				supContactLabel.setVisible(false);
				supContactTextField.setVisible(false);
				
				supMobileLabel.setVisible(false);
				supMobileTextField.setVisible(false);
				
				supMailLabel.setVisible(false);
				supMailTextField.setVisible(false);
				
				supNameLabel.setVisible(false);
				supNameTextField.setVisible(false);
				
				supTable.setVisible(false);
				scrollpane.setVisible(false);
				
				showMoreBtn.setVisible(false);
				
				supIdTextField.setVisible(true);
				supIdShowLabel.setVisible(false);
				break;
			
			default:
			case "inquire":
				
				supIdLabel.setVisible(true);
				supIdTextField.setVisible(true);
				supIdShowLabel.setVisible(false);
				
				supNameLabel.setVisible(true);
				supNameTextField.setVisible(true);
				
				supAddressLabel.setText("Address :");
				supAddressLabel.setVisible(false);
				supAddressTextField.setVisible(false);
				
				supContactLabel.setVisible(false);
				supContactTextField.setVisible(false);
				
				supMobileLabel.setVisible(false);
				supMobileTextField.setVisible(false);
				
				supMailLabel.setVisible(false);
				supMailTextField.setVisible(false);
				
				supTable.setVisible(false);
				scrollpane.setVisible(false);
				showMoreBtn.setVisible(false);
				
				btn1.setText("Inquire");
				btn1.setVisible(true);
				
				btn2.setVisible(false);
				
				clearBtn.setVisible(false);
				
				resultLabel.setVisible(false);
				
				break;
		}
	}
	
	private void showDataNotFound()
	{
		btn1.setVisible(true);
		clearBtn.setVisible(false);
		btn2.setVisible(false);
		
		supAddressTextField.setVisible(true);
		supAddressLabel.setVisible(false);
		supAddressTextField.setVisible(false);
		
		supContactLabel.setVisible(false);
		supContactTextField.setVisible(false);
		
		supMobileLabel.setVisible(false);
		supMobileTextField.setVisible(false);
		
		supMailLabel.setVisible(false);
		supMailTextField.setVisible(false);
		
		supTable.setVisible(false);
		scrollpane.setVisible(false);
		showMoreBtn.setVisible(false);
		
		supNameLabel.setVisible(false);
		supNameTextField.setVisible(false);
		
		supIdTextField.setVisible(true);
		
		supIdShowLabel.setVisible(false);
		
		resultLabel.setText("Data no found");
		resultLabel.setVisible(true);
	}
	
	private void btn1CheckForDeleting()
	{
		// query by service
		boolean found = true;
		
		if (found)
		{
			// show something
		}
		else
		{
			// not found
			showDataNotFound();
		}
	}
	
	private void btn1CheckForAddingProduct()
	{
		// query by service
		boolean found = true;
		
		if (found)
		{
			// show something
		}
		else
		{
			// not found
			showDataNotFound();
		}
	}
	
	private void setPage()
	{
		btn1.setVisible(true);
		btn2.setVisible(false);
		clearBtn.setVisible(false);
		supIdShowLabel.setVisible(false);
		supIdTextField.setVisible(true);
		
		supAddressLabel.setVisible(false);
		supAddressTextField.setVisible(false);
		
		supContactLabel.setVisible(false);
		supContactTextField.setVisible(false);
		
		supMobileLabel.setVisible(false);
		supMobileTextField.setVisible(false);
		supMailLabel.setVisible(false);
		supMailTextField.setVisible(false);
		
		supNameLabel.setVisible(false);
		supNameTextField.setVisible(false);
		
		supIdTextField.setVisible(true);
		
		supTable.setVisible(false);
		scrollpane.setVisible(false);
		showMoreBtn.setVisible(false);
	}
}
