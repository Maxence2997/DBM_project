package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;



abstract class Sheets {
	
	/**@author maxence2997
	 * @since 07/16/2021
	 * abstract class for sheets
	 */
	
	protected int sheet_ID;
	protected String type;
	protected int project_ID;
	protected String module;
	protected Date date;
	protected int vol;
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet result = null;
	
	Sheets(int sheet_ID, String type, int project_ID, String module, Date date, int vol) {
		super();
		this.sheet_ID = sheet_ID;
		this.type = type;
		this.project_ID = project_ID;
		this.vol=vol;
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
