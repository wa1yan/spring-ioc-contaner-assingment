package com.waiyanhtet.assignment.model;

import java.util.List;

import com.waiyanhtet.assignment.domain.OpenClass;

public interface OpenClassModel {

	OpenClass findById(int id);

	OpenClass findByCourseIdAndClassId(int courseId, int classId);

	List<OpenClass> findByCourse(int courseId);

	void create(OpenClass openclass);

}
