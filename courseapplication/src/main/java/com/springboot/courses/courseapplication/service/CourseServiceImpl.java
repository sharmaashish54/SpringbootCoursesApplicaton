package com.springboot.courses.courseapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.springboot.courses.courseapplication.dao.CoursesDao;
import com.springboot.courses.courseapplication.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> courseList;

	@Autowired
	private CoursesDao coursedao;

	public CourseServiceImpl() {
		// getCourseList();
	}

	@Override
	public List<Course> getCourses() {
		return coursedao.findAll();
	}

	/*
	 * private void getCourseList() {
	 * 
	 * 
	 * courseList = new ArrayList<Course>(); courseList.add(new Course(145,
	 * "Java Courses with spring boot", "Java Spring boot")); courseList.add(new
	 * Course(245, "Java Courses with spring core", "Java Spring core"));
	 * courseList.add(new Course(345, "Java Courses with microservices",
	 * "Java Spring microservice"));
	 * 
	 * }
	 */

	@Override
	public Course getCourse(long id) {
		return coursedao.getOne(id);
	}

	@Override
	public boolean updateCourse(Course newCourse, int courseId) {
		coursedao.save(newCourse);
		return true;
	}

	@Override
	public String addCourse(Course course) {
		coursedao.save(course);
		return "Course  Added";
	}

	
	@Override
	public String deleteCourse(long courseId) {
		coursedao.deleteById(courseId);
		return "Course deleted";
	}	 

}
