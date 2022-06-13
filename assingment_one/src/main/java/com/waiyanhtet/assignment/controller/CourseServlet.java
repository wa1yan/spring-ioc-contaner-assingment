package com.waiyanhtet.assignment.controller;

import java.io.IOException;
import com.waiyanhtet.assignment.domain.Course;
import com.waiyanhtet.assignment.model.CourseModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/", "/courses", "/course-edit", "/course-save" })
public class CourseServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var page = switch (req.getServletPath()) {
		case "/course-edit" -> "/course-edit.jsp";
		default -> {
			// load course and set result to request scope
			var courses = getBean("courseModel", CourseModel.class).getAll();
			req.setAttribute("courses", courses);
			yield "/index.jsp";
		}
		};

		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// create course object
		Course course = new Course();
		course.setName(req.getParameter("name"));
		course.setFees(Integer.parseInt(req.getParameter("fees")));
		course.setDuration(Integer.parseInt(req.getParameter("duration")));
		course.setDescription(req.getParameter("description"));

		// save to db
		getBean("courseModel", CourseModel.class).save(course);

		// redirect to top page
		resp.sendRedirect("/");
	}

}