package com.waiyanhtet.assignment.controller;

import java.io.IOException;

import com.waiyanhtet.assignment.model.CourseModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/", "/courses", "/course-edit", "/course-save" })
public class CourseServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;
	
	private CourseModel model;
	
	@Override
	public void init() throws ServletException {
		var message = getBean("message", String.class);
		System.out.println(message);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var page = switch (req.getServletPath()) {
		case "/course-edit" -> "/course-edit.jsp";
		default -> {
			// load course and set result to request scope
			yield "/index.jsp";
		}
		};

		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}