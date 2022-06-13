package com.waiyanhtet.assignment.controller;

import java.io.IOException;
import java.sql.Date;
import com.waiyanhtet.assignment.domain.OpenClass;
import com.waiyanhtet.assignment.model.CourseModel;
import com.waiyanhtet.assignment.model.OpenClassModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/classes", "/class-edit" })
public class OpenClassServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var courseId = Integer.parseInt(req.getParameter("courseId"));

		var course = getBean("courseModel", CourseModel.class).findById(courseId);
		req.setAttribute("course", course);

		var page = switch (req.getServletPath()) {
		case "/class-edit" -> "/class-edit.jsp";
		default -> {

			var classes = getBean("openClassModel", OpenClassModel.class).findByCourse(courseId);
			req.setAttribute("classes", classes);

			yield "/classes.jsp";
		}
		};

		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var courseId = Integer.parseInt(req.getParameter("courseId"));

		var course = getBean("courseModel", CourseModel.class).findById(courseId);

		var openClass = new OpenClass();
		openClass.setStartDate(Date.valueOf(req.getParameter("start")).toLocalDate());
		openClass.setTeacher(req.getParameter("teacher"));
		openClass.setCourse(course);

		getBean("openClassModel", OpenClassModel.class).create(openClass);
		resp.sendRedirect("/classes?courseId=" + courseId);

	}

}
