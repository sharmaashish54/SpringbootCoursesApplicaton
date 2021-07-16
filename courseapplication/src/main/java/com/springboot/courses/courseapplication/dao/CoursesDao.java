package com.springboot.courses.courseapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.courses.courseapplication.entities.Course;


public interface CoursesDao extends JpaRepository<Course, Long> {

	
}
