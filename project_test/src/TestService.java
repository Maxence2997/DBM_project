import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Employee;
import com.service.EmpServiceInterface;

public class TestService
{
	public static void main(String[] args)
	{
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		EmpServiceInterface employeeService = context.getBean("employeeService", EmpServiceInterface.class);
		employeeService.createEmployee("DaDa", "Xi");
		
		System.out.println();
	}
}
