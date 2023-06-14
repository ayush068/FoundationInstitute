package com.example.learnSphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.learnSphere.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
