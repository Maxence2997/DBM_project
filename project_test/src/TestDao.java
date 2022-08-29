import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dao.EmployeeDaoInterface;
import com.entities.Employee;

public class TestDao
{
	public static void main(String[] args)
	{
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		EmployeeDaoInterface employee = context.getBean("EmployeeDao", EmployeeDaoInterface.class);
		Employee emp = employee.getEmployee(1);

		System.out.println(emp);
	}
}
