package com.example.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.learnSphere.entity.Course;
import com.example.learnSphere.entity.Lesson;
import com.example.learnSphere.entity.Users;
import com.example.learnSphere.service.TrainerService;
@Controller
public class TrainerController {
	    @Autowired
	   TrainerService tservice;

	    @PostMapping("/addCourse")
	    public String addCourse(@RequestParam("courseId") Integer courseId,
	                          @RequestParam("courseName") String courseName,
	                          @RequestParam("coursePrice") Integer coursePrice)
	                          {

	       Course course = new Course();
	       
	       course.setCourseId(courseId);
	       course.setCourseName(courseName);
	       course.setCoursePrice(coursePrice);
	       tservice.addCourse(course);
	       return "home";
	                          }
	    

	    
	    
	    
	    @PostMapping("/lesson")
	    public String lesson(@RequestParam("courseId") int courseId,
	                         @RequestParam("lessonId") int lessonId,
	                         @RequestParam("lessonName") String lessonName,
	                         @RequestParam("lessonTopics") String lessonTopics,
	                         @RequestParam("link") String link) {
	        Course course = tservice.getCourse(courseId);
	        Lesson lesson = new Lesson(lessonId, lessonName, lessonTopics, link, course);
	        tservice.addLesson(lesson);
	        course.getLessons().add(lesson);
	        return "home";
	    }
		                          
	    @GetMapping("/showCourses")
		public String showCourses(Model model) {
			List<Course> courseList=tservice.courseList();
			model.addAttribute("courseList",courseList);
			//System.out.println(courseList);
			return "courses";
		}

}
    

	       
	            
	            
