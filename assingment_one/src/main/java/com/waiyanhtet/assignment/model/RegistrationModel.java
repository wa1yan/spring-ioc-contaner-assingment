package com.waiyanhtet.assignment.model;

import java.util.List;

import com.waiyanhtet.assignment.domain.Registration;

public interface RegistrationModel {

	List<Registration> findByCourseIdAndClassId(int courseId, int classId);

	void register(Registration registration);
}
