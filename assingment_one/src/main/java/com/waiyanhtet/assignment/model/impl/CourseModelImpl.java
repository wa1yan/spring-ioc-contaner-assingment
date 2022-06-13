package com.waiyanhtet.assignment.model.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.waiyanhtet.assignment.domain.Course;
import com.waiyanhtet.assignment.model.CourseModel;

public class CourseModelImpl implements CourseModel {

	private static final String SELECT_COURSE = "select * from course";
	private static final String INSERT_COURSE = "insert into course(name, fees, duration, description) values(?,?,?,?)";
	private static final String SELECT_ONE = "select * from course where id = ?";

	private DataSource dataSource;

	public CourseModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public Course findById(int id) {

		Course course = new Course();

		try (var connection = dataSource.getConnection(); var stmt = connection.prepareStatement(SELECT_ONE)) {

			stmt.setInt(1, id);
			var result = stmt.executeQuery();

			while (result.next()) {

				course.setId(result.getInt(1));
				course.setName(result.getString(2));
				course.setDuration(result.getInt(3));
				course.setFees(result.getInt(4));
				course.setDescription(result.getString(5));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return course;
	}

	@Override
	public List<Course> getAll() {

		var courseList = new ArrayList<Course>();

		try (var connection = dataSource.getConnection(); var stmt = connection.prepareStatement(SELECT_COURSE)) {

			var result = stmt.executeQuery();

			while (result.next()) {

				Course course = new Course();

				course.setId(result.getInt(1));
				course.setName(result.getString(2));
				course.setDuration(result.getInt(3));
				course.setFees(result.getInt(4));
				course.setDescription(result.getString(5));

				courseList.add(course);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return courseList;
	}

	@Override
	public void save(Course course) {
		try (var connection = dataSource.getConnection(); var stmt = connection.prepareStatement(INSERT_COURSE)) {

			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getDuration());
			stmt.setInt(3, course.getFees());
			stmt.setString(4, course.getDescription());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
