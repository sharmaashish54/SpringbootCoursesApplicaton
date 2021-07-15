package com.springboot.courses.courseapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.courses.courseapplication.entities.Course;

@Service
public class CoursesServiceImpl implements CoursesService {

	List<Course> courseList;

	public CoursesServiceImpl() {
		getCourseList();
	}

	@Override
	public List<Course> getCourses() {
		return courseList;
	}

	private void getCourseList() {
		courseList = new ArrayList<Course>();
		courseList.add(new Course(145, "Java Courses with spring boot", "Java Spring boot"));
		courseList.add(new Course(245, "Java Courses with spring core", "Java Spring core"));
		courseList.add(new Course(345, "Java Courses with microservices", "Java Spring microservice"));
	}

	@Override
	public Course getCourse(double id) {
		Course c = null;
		for (Course course : courseList) {
			if (id == course.getId()) {
				c = course;
				return c;
			} else {
				c = new Course(999, "Default course", "default");
			}
		}
		return c;
	}

	@Override
	public boolean updateCourse(Course newCourse, int courseId) {
		boolean isUpdated = false;
		for (Course list : courseList) {
			if (list.getId() == courseId) {
				list.setDescription(newCourse.getDescription());
				list.setTitle(newCourse.getTitle());
				isUpdated = true;
				break;
			}
		}
		return isUpdated;
	}

	@Override
	public String addCourse(Course course) {

		if (courseList.contains(course)) {
			return "Course Already Added";
		} else {
			courseList.add(course);
			return "Course  Added";
		}
	}

	@Override
	public String deleteCourse(int courseId) {
		for (int i = 0; i < courseList.size(); i++) {
			if (courseId == courseList.get(i).getId()) {
				courseList.remove(i);
				return "Course deleted";
			}
		}
		return "course not found";
	}

}
