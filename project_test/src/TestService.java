import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entities.Employee;
import com.service.EmployeeServiceInterface;

public class TestService
{
	public static void main(String[] args)
	{
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		EmployeeServiceInterface employeeService = context.getBean("EmployeeService", EmployeeServiceInterface.class);
		Employee emp = employeeService.getEmployee(1);

		System.out.println(emp);
	}
}
