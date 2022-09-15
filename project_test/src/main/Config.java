package main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class Config
{
	public static ClassPathXmlApplicationContext context;
	
	public static void initialize()
	{
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
}
