package com.waiyanhtet.assignment.model.impl;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.waiyanhtet.assignment.domain.Course;
import com.waiyanhtet.assignment.domain.OpenClass;
import com.waiyanhtet.assignment.domain.Registration;
import com.waiyanhtet.assignment.model.RegistrationModel;

public class RegistrationModelImpl implements RegistrationModel {

	private static final String SELECT_ALL = """
												select r.id, r.student, r.phone, r.email,
												c.name, c.fees, c.duration, c.description,
												oc.teacher, oc.start
												from registration r
												join open_class oc
												on oc.id = r.open_class_id
												join course c
												on c.id = oc.course_id and
												c.id = ? and oc.id = ?
											 """;

	private static final String INSERT_REGISTRATION = "insert into registration(open_class_id, student, phone, email) values (?,?,?,?)";

	private DataSource dataSource;

	public RegistrationModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<Registration> findByCourseIdAndClassId(int courseId, int classId) {

		var registrationList = new ArrayList<Registration>();
		try (var connection = dataSource.getConnection(); var stmt = connection.prepareStatement(SELECT_ALL)) {

			stmt.setInt(1, courseId);
			stmt.setInt(2, classId);

			var result = stmt.executeQuery();

			while (result.next()) {
				var course = new Course();
				course.setId(courseId);
				course.setName(result.getString("name"));
				course.setFees(Integer.parseInt(result.getString("fees")));
				course.setDuration(Integer.parseInt(result.getString("duration")));
				course.setDescription(result.getString("description"));

				var openClass = new OpenClass();
				openClass.setId(classId);
				openClass.setTeacher(result.getString("teacher"));
				openClass.setCourse(course);
				openClass.setStartDate(result.getDate("start").toLocalDate());

				var registration = new Registration();

				registration.setId(result.getInt("id"));
				registration.setOpenClass(openClass);
				registration.setStudent(result.getString("student"));
				registration.setPhone(result.getString("phone"));
				registration.setEmail(result.getString("email"));

				registrationList.add(registration);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return registrationList;

	}

	@Override
	public void register(Registration registration) {

		try (var connection = dataSource.getConnection(); var stmt = connection.prepareStatement(INSERT_REGISTRATION)) {

			stmt.setInt(1, registration.getOpenClass().getId());
			stmt.setString(2, registration.getStudent());
			stmt.setString(3, registration.getPhone());
			stmt.setString(4, registration.getEmail());

			int a = stmt.executeUpdate();
			System.out.println(a);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
