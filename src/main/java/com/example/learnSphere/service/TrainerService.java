package com.example.learnSphere.service;

import java.util.List;


import com.example.learnSphere.controller.TrainerController;
import com.example.learnSphere.entity.Course;
import com.example.learnSphere.entity.Lesson;
import com.example.learnSphere.entity.Users;


public interface TrainerService {
	public String addCourse(Course course);

	

	public  String addLesson(Lesson lesson);

	Course getCourse(Integer courseId);

	Course getCourse(int courseId);



	public List<Course> courseList();



	



	

	
	
	
}