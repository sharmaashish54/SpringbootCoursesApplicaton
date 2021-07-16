package com.springboot.courses.courseapplication.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.courses.courseapplication.entities.Course;
import com.springboot.courses.courseapplication.service.CourseService;

@RestController
public class CoursesController {
	
	/*
	 * @Autowired CoursesService coursesService;
	 */
	
	@Autowired
	CourseService coursesService;
	
	@GetMapping("/home")
	public String home(){
		return "welcome";
		
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return coursesService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable long courseId){
		return coursesService.getCourse(courseId);
	}
	
	@PostMapping("/course")
	public String addCourse(@RequestBody Course course){
		return coursesService.addCourse(course);
	}
	
	@PutMapping("/course/{courseId}")
	public boolean updateCourse(@RequestBody Course course,@PathVariable int courseId){
		return coursesService.updateCourse(course, courseId);
	}
	
	@DeleteMapping("/course/{courseId}")
	public String deleteCourse(@RequestBody Course course,@PathVariable int courseId){
		return coursesService.deleteCourse(courseId);
	}
	

}
