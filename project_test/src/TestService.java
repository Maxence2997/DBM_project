import java.util.Optional;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.entities.Employee;
import com.service.EmpServiceInterface;

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
		// employeeService.createEmployee("DaDa", "Xi");
		Optional<Employee> empOpt = employeeService.getEmployee("EP000002");

		empOpt.ifPresentOrElse((a) -> System.out.println(a),
				() -> System.out.println("There is no result"));
		context.close();
	}
}
