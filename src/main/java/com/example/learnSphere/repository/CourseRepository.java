package com.example.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learnSphere.entity.Course;



public interface CourseRepository extends JpaRepository<Course, Integer>{

}
