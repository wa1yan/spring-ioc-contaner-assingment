package com.waiyanhtet.assignment.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;

import com.waiyanhtet.assignment.listener.SpringContainerManager;

import jakarta.servlet.http.HttpServlet;

public class AbstractBeanFactoryServlet extends HttpServlet implements BeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
		
		var springContext = getServletContext().getAttribute(SpringContainerManager.SPRING_CONTEXT);
		if(null != springContext && springContext instanceof BeanFactory factory) {
			return factory.getBean(name,requiredType);
		}
		
		return null;
	}


}
