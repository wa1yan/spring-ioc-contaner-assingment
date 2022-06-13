package com.waiyanhtet.assignment.model;

import java.util.List;

import com.waiyanhtet.assignment.domain.Course;

public interface CourseModel {

	Course findById(int id);

	List<Course> getAll();

	void save(Course course);

}