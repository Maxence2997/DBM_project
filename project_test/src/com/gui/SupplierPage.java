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
	
	private JPanel panel;
	
	private JTextField idTextField;
	
	private JTextField nameTextField;
	
	private JTable table;
	
	private JScrollPane scrollpane;
	
	private JLabel addressLabel;
	
	private JLabel contactLabel;
	
	private JLabel mobileLabel;
	
	private JLabel mailLabel;
	
	public static JComboBox actionComboBox;
	
	private JButton btn1;
	
	private JButton btn2;
	
	private JTextField addressTextField;
	
	private JTextField contactTextField;
	
	private JTextField mobileTextField;
	
	private JTextField mailTextField;
	
	private JLabel idLabel;
	
	private JLabel nameLabel;
	
	private JLabel resultLabel;
	
	private JLabel idShowLabel;
	
	private JButton clearBtn;
	
	private JButton showMoreBtn;
	
	@SuppressWarnings(value = { "unused" })
	public static void initialize()
	{
		SupplierPage page = new SupplierPage();
	}
	
	public SupplierPage()
	{
		panel = new JPanel();
		panel.setBounds(0, 26, 1000, 450);
		panel.setLayout(null);
		Frame.containerPanel.add(panel, SUPPLIER);
		
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
		panel.add(btn2);
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
				String actionOfComboBox = ((String) actionComboBox.getSelectedItem()).toLowerCase();
				
				switch (function)
				{
					case "check":
						boolean checkForDeleting = actionOfComboBox.equals("delete");
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
		panel.add(btn1);
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
		panel.add(clearBtn);
	}
	
	private void setComboBox()
	{
		String[] function = { "Inquire", "Add Supplier", "Add Product", "Delete" };
		actionComboBox = new JComboBox();
		actionComboBox.setBounds(447, 43, 135, 27);
		actionComboBox.setModel(new DefaultComboBoxModel(function));
		// supplierFunction = (String) supComboBox.getSelectedItem();
		actionComboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String actionOfComboBox = ((String) actionComboBox.getSelectedItem()).toLowerCase();
				
				setElementsByComboBox(actionOfComboBox);
			}
		});
		actionComboBox.setVisible(true);
		panel.add(actionComboBox);
	}
	
	private void setScrollpane()
	{
		scrollpane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollpane.setBounds(229, 287, 563, 81);
		scrollpane.setVisible(false);
		// scrollpane.setPreferredSize(new Dimension(563, 50)); //whole scrollpane and
		// table will disapear
		panel.add(scrollpane);
	}
	
	private void setSupTable()
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
		// supTable.setBounds(48,288,563,30);
		table.setVisible(false);
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
		
		panel.add(showMoreBtn);
	}
	
	private void setResultLabel()
	{
		resultLabel = new JLabel("");
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultLabel.setBounds(229, 258, 560, 16);
		resultLabel.setVisible(false);
		panel.add(resultLabel);
	}
	
	private void setSupMailTextField()
	{
		mailTextField = new JTextField();
		mailTextField.setHorizontalAlignment(SwingConstants.CENTER);
		mailTextField.setBounds(426, 220, 178, 26);
		mailTextField.setVisible(false);
		panel.add(mailTextField);
		mailTextField.setColumns(14);
	}
	
	private void setSupMailLabel()
	{
		mailLabel = new JLabel("Mail :");
		mailLabel.setBounds(384, 225, 34, 16);
		mailLabel.setVisible(false);
		panel.add(mailLabel);
	}
	
	private void setSupMobileTextField()
	{
		mobileTextField = new JTextField();
		mobileTextField.setHorizontalAlignment(SwingConstants.CENTER);
		mobileTextField.setBounds(426, 193, 178, 26);
		mobileTextField.setVisible(false);
		mobileTextField.setColumns(14);
		panel.add(mobileTextField);
	}
	
	private void setSupMobileLabel()
	{
		mobileLabel = new JLabel("Mobile :");
		mobileLabel.setBounds(368, 198, 50, 16);
		mobileLabel.setVisible(false);
		panel.add(mobileLabel);
	}
	
	private void setSupContactTextField()
	{
		contactTextField = new JTextField();
		contactTextField.setHorizontalAlignment(SwingConstants.CENTER);
		contactTextField.setBounds(426, 167, 178, 26);
		contactTextField.setVisible(false);
		contactTextField.setColumns(14);
		panel.add(contactTextField);
	}
	
	private void setSupContactLabel()
	{
		contactLabel = new JLabel("Contact :");
		contactLabel.setBounds(361, 172, 57, 16);
		contactLabel.setVisible(false);
		panel.add(contactLabel);
	}
	
	private void setSupAddressTextField()
	{
		addressTextField = new JTextField();
		addressTextField.setHorizontalAlignment(SwingConstants.CENTER);
		addressTextField.setBounds(426, 141, 178, 26);
		addressTextField.setColumns(14);
		addressTextField.setVisible(false);
		panel.add(addressTextField);
	}
	
	private void setSupAddressLabel()
	{
		addressLabel = new JLabel("");
		addressLabel.setBounds(359, 146, 59, 16);
		addressLabel.setVisible(false);
		panel.add(addressLabel);
	}
	
	private void setSupNameTextField()
	{
		nameTextField = new JTextField();
		nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		nameTextField.setBounds(426, 115, 178, 26);
		panel.add(nameTextField);
		nameTextField.setColumns(14);
	}
	
	private void setSupNameLabel()
	{
		nameLabel = new JLabel("Name :");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(319, 120, 99, 16);
		panel.add(nameLabel);
	}
	
	private void setSupIdShowLabel()
	{
		idShowLabel = new JLabel("");
		idShowLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idShowLabel.setBounds(430, 94, 174, 16);
		idShowLabel.setVisible(false);
		panel.add(idShowLabel);
	}
	
	private void setSupIdTextField()
	{
		idTextField = new JTextField();
		idTextField.setHorizontalAlignment(SwingConstants.CENTER);
		idTextField.setBounds(426, 89, 178, 26);
		panel.add(idTextField);
		idTextField.setColumns(14);
	}
	
	private void setSupIdLabel()
	{
		idLabel = new JLabel("Supplier ID :");
		idLabel.setBounds(341, 94, 77, 16);
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(idLabel);
	}
	
	private void clearLabelAndField()
	{
		idTextField.setText("");
		nameTextField.setText("");
		addressTextField.setText("");
		contactTextField.setText("");
		mobileTextField.setText("");
		mailTextField.setText("");
		idShowLabel.setText("");
		resultLabel.setText("");
	}
	
	private void setElementsByComboBox(String function)
	{
		clearLabelAndField();
		
		switch (function)
		{
			case "add supplier":
				idLabel.setVisible(true);
				idTextField.setVisible(false);
				idShowLabel.setVisible(true);
				
				nameLabel.setVisible(true);
				nameTextField.setVisible(true);
				
				addressLabel.setText("Address :");
				addressLabel.setVisible(true);
				addressTextField.setVisible(true);
				
				contactLabel.setVisible(true);
				contactTextField.setVisible(true);
				
				mobileLabel.setVisible(true);
				mobileTextField.setVisible(true);
				
				mailLabel.setVisible(true);
				mailTextField.setVisible(true);
				
				table.setVisible(false);
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
				
				idTextField.setVisible(true);
				
				addressLabel.setText("Module :");
				addressLabel.setVisible(false);
				addressTextField.setVisible(false);
				
				contactLabel.setVisible(false);
				contactTextField.setVisible(false);
				
				mobileLabel.setVisible(false);
				mobileTextField.setVisible(false);
				
				mailLabel.setVisible(false);
				mailTextField.setVisible(false);
				
				nameLabel.setVisible(false);
				nameTextField.setVisible(false);
				
				table.setVisible(false);
				scrollpane.setVisible(false);
				showMoreBtn.setVisible(false);
				
				idTextField.setVisible(true);
				
				idShowLabel.setVisible(false);
				break;
			
			case "delete":
				btn1.setText("Check");
				btn1.setVisible(true);
				
				btn2.setText("Delete");
				btn2.setVisible(false);
				
				clearBtn.setVisible(false);
				
				idTextField.setVisible(true);
				
				addressLabel.setText("Address :");
				addressLabel.setVisible(false);
				addressTextField.setVisible(false);
				
				contactLabel.setVisible(false);
				contactTextField.setVisible(false);
				
				mobileLabel.setVisible(false);
				mobileTextField.setVisible(false);
				
				mailLabel.setVisible(false);
				mailTextField.setVisible(false);
				
				nameLabel.setVisible(false);
				nameTextField.setVisible(false);
				
				table.setVisible(false);
				scrollpane.setVisible(false);
				
				showMoreBtn.setVisible(false);
				
				idTextField.setVisible(true);
				idShowLabel.setVisible(false);
				break;
			
			default:
			case "inquire":
				
				idLabel.setVisible(true);
				idTextField.setVisible(true);
				idShowLabel.setVisible(false);
				
				nameLabel.setVisible(true);
				nameTextField.setVisible(true);
				
				addressLabel.setText("Address :");
				addressLabel.setVisible(false);
				addressTextField.setVisible(false);
				
				contactLabel.setVisible(false);
				contactTextField.setVisible(false);
				
				mobileLabel.setVisible(false);
				mobileTextField.setVisible(false);
				
				mailLabel.setVisible(false);
				mailTextField.setVisible(false);
				
				table.setVisible(false);
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
		
		addressTextField.setVisible(true);
		addressLabel.setVisible(false);
		addressTextField.setVisible(false);
		
		contactLabel.setVisible(false);
		contactTextField.setVisible(false);
		
		mobileLabel.setVisible(false);
		mobileTextField.setVisible(false);
		
		mailLabel.setVisible(false);
		mailTextField.setVisible(false);
		
		table.setVisible(false);
		scrollpane.setVisible(false);
		showMoreBtn.setVisible(false);
		
		nameLabel.setVisible(false);
		nameTextField.setVisible(false);
		
		idTextField.setVisible(true);
		
		idShowLabel.setVisible(false);
		
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
		idShowLabel.setVisible(false);
		idTextField.setVisible(true);
		
		addressLabel.setVisible(false);
		addressTextField.setVisible(false);
		
		contactLabel.setVisible(false);
		contactTextField.setVisible(false);
		
		mobileLabel.setVisible(false);
		mobileTextField.setVisible(false);
		mailLabel.setVisible(false);
		mailTextField.setVisible(false);
		
		nameLabel.setVisible(false);
		nameTextField.setVisible(false);
		
		idTextField.setVisible(true);
		
		table.setVisible(false);
		scrollpane.setVisible(false);
		showMoreBtn.setVisible(false);
	}
}
