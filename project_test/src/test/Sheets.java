package test;
import java.util.Date;



abstract class Sheets {
	
	/**@author maxence2997
	 * @since 07/16/2021
	 * abstract class for sheets
	 */
	
	protected int sheet_ID;
	protected String type;
	protected int project_ID;
	protected String supplier_ID;
	protected String module;
	protected Date date;
	protected String supplier_name;
	
	Sheets(int sheet_ID, String type, int project_ID, String supplier_ID, String module, Date date) {
		super();
		this.sheet_ID = sheet_ID;
		this.type = type;
		this.project_ID = project_ID;
		this.supplier_ID = supplier_ID;
		this.module = module;
		this.date = date;
	}
	
	Sheets(){
		
	}
	
	abstract String[][] inquire(String[] temp);
	
	
	
	
	abstract String[][] append();
	
	abstract int modify();
	
	
	
	abstract int remove();

}
