package com.example.learnSphere.service;

	
	import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.learnSphere.entity.Course;
import com.example.learnSphere.entity.Lesson;
import com.example.learnSphere.repository.CourseRepository;
import com.example.learnSphere.repository.LessonRepository;
	
	@Service
	public class TrainerServiceImplementation implements TrainerService{
		
			@Autowired
			CourseRepository courseRepo;
			@Autowired
			LessonRepository lessonRepo;

			

			// for Adding course
			public String addCourse(Course course) {
				// TODO Auto-generated method stub
				courseRepo.save(course);
				return "Course added successfully";
			}
			
			
			
			@Override
			public List<Course> courseList() {
				return courseRepo.findAll();
			}
			
		
		    
			 //for Adding lesson
   		
			
			


			



			@Override
			public String addLesson(Lesson lesson) {
				// TODO Auto-generated method stub
				lessonRepo.save(lesson);
				return "Lesson added successfully";
			}



			

			@Override
			public Course getCourse(int courseId) {
				return courseRepo.findById(courseId).get();
				
			}



			@Override
			public Course getCourse(Integer courseId) {
				// TODO Auto-generated method stub
				return null;
			}



			
	}


