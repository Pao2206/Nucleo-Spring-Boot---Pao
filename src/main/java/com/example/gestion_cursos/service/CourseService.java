package com.example.gestion_cursos.service;

import com.example.gestion_cursos.model.Course;
import com.example.gestion_cursos.model.Student;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course saveCourse(Course course);

    Course getCourseById(Integer courseId);

    Course updateCourse(Integer id, Course CourseDetails);

    void deleteCourse(Integer courseId);
}
