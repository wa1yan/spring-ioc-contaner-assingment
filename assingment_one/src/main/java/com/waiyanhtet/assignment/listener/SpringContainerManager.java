package com.waiyanhtet.assignment.listener;

import org.springframework.context.support.GenericXmlApplicationContext;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SpringContainerManager implements ServletContextListener {

	public static String SPRING_CONTEXT = "spring.context";
	private GenericXmlApplicationContext springContext;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Initialized IOC container");

		springContext = new GenericXmlApplicationContext("classpath:application.xml");

		if (null != springContext) {
			sce.getServletContext().setAttribute(SPRING_CONTEXT, springContext);
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Closed IOC container");
		springContext.close();
	}
}