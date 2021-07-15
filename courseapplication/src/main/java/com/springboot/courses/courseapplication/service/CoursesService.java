package com.springboot.courses.courseapplication.service;

import java.util.List;

import com.springboot.courses.courseapplication.entities.Course;

public interface CoursesService {

	public List<Course> getCourses();
	public Course getCourse(double id);
	public String addCourse(Course c);
	public boolean updateCourse(Course c, int courseId);
	public String deleteCourse(int courseId);
}
