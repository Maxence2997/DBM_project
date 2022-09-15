package main;

import com.gui.EmployeePage;
import com.gui.Frame;
import com.gui.HomePage;
import com.gui.InventoryPage;
import com.gui.LogInPage;
import com.gui.SupplierPage;

public class Main
{
	public static void main(String[] args)
	{
//		Config.initialize();
		Frame.initialize();
		LogInPage.initialize();
		HomePage.initialize();
		SupplierPage.initialize();
		EmployeePage.initialize();
		InventoryPage.initialize();
	}
}
