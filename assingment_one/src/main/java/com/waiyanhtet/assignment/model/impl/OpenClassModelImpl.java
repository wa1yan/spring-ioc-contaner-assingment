package com.waiyanhtet.assignment.model.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.waiyanhtet.assignment.domain.Course;
import com.waiyanhtet.assignment.domain.OpenClass;
import com.waiyanhtet.assignment.model.OpenClassModel;

public class OpenClassModelImpl implements OpenClassModel {

	private static final String INSERT_COURSE = "insert into open_class(course_id, start, teacher) values (?,?,?)";
	
	private static final String SELECT_COURSE = """			
											select oc.id, oc.start, oc.teacher,
											c.id courseId, c.name name, c.fees, c.duration, c.description
											from open_class oc
											join course c
											on oc.course_id = c.id
											where c.id = ?
											 """;
	
	private static final String SELECT_CLASS = """			
											select oc.id, oc.start, oc.teacher,
											c.id courseId, c.name name, c.fees, c.duration, c.description
											from open_class oc
											join course c
											on oc.course_id = c.id
											where oc.id = ?
											 """;
	
	private static final String SELECT_ONE_BY_COURSEID_AND_CLASSID = """			
											select oc.id, oc.start, oc.teacher,
											c.id courseId, c.name name, c.fees, c.duration, c.description
											from open_class oc
											join course c
											on oc.course_id = c.id
											where c.id = ? and oc.id = ?
											 """;
			
	private DataSource dataSource;
	
	public OpenClassModelImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	@Override
	public OpenClass findById(int classId) {
		var openClass = new OpenClass();
		
		try(var connection = dataSource.getConnection();
				var stmt = connection.prepareStatement(SELECT_CLASS)) {			
			
			stmt.setInt(1, classId);			
			var result = stmt.executeQuery();
			while(result.next()) {
				var course = new Course();
				course.setId(result.getInt("courseId"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));
				
				openClass.setId(result.getInt("id"));				
				openClass.setCourse(course);				
				openClass.setStartDate(result.getDate("start").toLocalDate());
				openClass.setTeacher(result.getString("teacher"));				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return openClass;
	}
	
	@Override
	public OpenClass findByCourseIdAndClassId(int courseId, int classId) {
		var openClass = new OpenClass();
		var course = new Course();
		try(var connection = dataSource.getConnection();
				var stmt = connection.prepareStatement(SELECT_ONE_BY_COURSEID_AND_CLASSID)) {
			
			stmt.setInt(1, courseId);
			stmt.setInt(2, classId);
			
			var result = stmt.executeQuery();

			while(result.next()) {

				course.setId(result.getInt("courseId"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));
				
				openClass.setId(result.getInt("id"));				
				openClass.setCourse(course);				
				openClass.setStartDate(result.getDate("start").toLocalDate());
				openClass.setTeacher(result.getString("teacher"));								
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return openClass;
	}
	
	@Override
	public List<OpenClass> findByCourse(int courseId) {
		
		var classList = new ArrayList<OpenClass>();
		
		try(var connection = dataSource.getConnection();
				var stmt = connection.prepareStatement(SELECT_COURSE)) {
			
			stmt.setInt(1, courseId);			
			var result = stmt.executeQuery();

			while(result.next()) {
				var course = new Course();
				var openClass = new OpenClass();

				course.setId(result.getInt("courseId"));
				course.setName(result.getString("name"));
				course.setFees(result.getInt("fees"));
				course.setDuration(result.getInt("duration"));
				course.setDescription(result.getString("description"));
				
				openClass.setId(result.getInt("id"));				
				openClass.setCourse(course);				
				openClass.setStartDate(result.getDate("start").toLocalDate());
				openClass.setTeacher(result.getString("teacher"));				
				
				classList.add(openClass);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return classList;
	}

	@Override
	public void create(OpenClass openclass) {
		try (var connection = dataSource.getConnection();
				var stmt = connection.prepareStatement(INSERT_COURSE)) {

			stmt.setInt(1, openclass.getCourse().getId());
			stmt.setDate(2, Date.valueOf(openclass.getStartDate()));
			stmt.setString(3, openclass.getTeacher());
			
			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
