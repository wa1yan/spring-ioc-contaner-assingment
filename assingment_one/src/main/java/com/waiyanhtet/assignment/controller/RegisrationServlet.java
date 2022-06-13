package com.waiyanhtet.assignment.controller;

import java.io.IOException;
import com.waiyanhtet.assignment.domain.Registration;
import com.waiyanhtet.assignment.model.CourseModel;
import com.waiyanhtet.assignment.model.OpenClassModel;
import com.waiyanhtet.assignment.model.RegistrationModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/registration", "/registration-edit" })
public class RegisrationServlet extends AbstractBeanFactoryServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var courseId = Integer.parseInt(req.getParameter("courseId"));
		var classId = Integer.parseInt(req.getParameter("classId"));

		var course = getBean("courseModel", CourseModel.class).findById(courseId);
		req.setAttribute("course", course);

		var openClass = getBean("openClassModel", OpenClassModel.class).findByCourseIdAndClassId(courseId, classId);
		req.setAttribute("openClass", openClass);

		req.setAttribute("classId", classId);

		var page = switch (req.getServletPath()) {
		case "/registration-edit" -> "/registration-edit.jsp";
		default -> {

			var registration = getBean("registrationModel", RegistrationModel.class).findByCourseIdAndClassId(courseId,
					classId);
			req.setAttribute("registration", registration);

			yield "/registration.jsp";
		}
		};

		getServletContext().getRequestDispatcher(page).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		var classId = Integer.parseInt(req.getParameter("classId"));
		var courseId = Integer.parseInt(req.getParameter("courseId"));

		var openClass = getBean("openClassModel", OpenClassModel.class).findById(classId);

		var registration = new Registration();
		registration.setOpenClass(openClass);
		registration.setStudent(req.getParameter("student"));
		registration.setPhone(req.getParameter("phone"));
		registration.setEmail(req.getParameter("email"));

		getBean("registrationModel", RegistrationModel.class).register(registration);

		resp.sendRedirect("/registration?courseId=%d&classId=%d".formatted(courseId, classId));
	}

}
