import java.util.HashMap;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Employee;
import com.service.EmpServiceInterface;
import com.util.EntitiesColumn;

public class TestService
{
	public static void main(String[] args)
	{
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// retrieve bean from spring container
		EmpServiceInterface employeeService = context.getBean("employeeService",
				EmpServiceInterface.class);
		// employeeService.createEmployee("winnie", "Xi", "Taichang", "09123445", "EP000003", "A");
		// Optional<Employee> empOpt = employeeService.getEmployee("EP000002");
		//
		// empOpt.ifPresentOrElse((a) -> System.out.println(a),
		// () -> System.out.println("There is no result"));

//		 employeeService.createEmployee("Test", "Xi", "Taichang", "09123445", "EP000003", "A");

		try
		{
			employeeService.deleteEmployee("EP000002");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.close();
	}
}
