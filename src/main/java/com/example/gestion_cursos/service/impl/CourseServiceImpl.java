package com.example.gestion_cursos.service.impl;

import com.example.gestion_cursos.model.Course;
import com.example.gestion_cursos.repositories.CourseRepo;
import com.example.gestion_cursos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    @Override
    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
    @Override
    public Course saveCourse(Course course){
        return courseRepo.save(course);
    }
    @Override
    public Course getCourseById(Integer id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(Integer id, Course courseDetails) {
        Course course = getCourseById(id);
        if (course != null) {
            course.setCourseName(courseDetails.getCourseName());
            course.setDescription(courseDetails.getDescription());
            course.setCredits(courseDetails.getCredits());
            return courseRepo.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepo.deleteById(id);
    }

}
