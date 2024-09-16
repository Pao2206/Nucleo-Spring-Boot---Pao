package com.example.gestion_cursos.controller;

import com.example.gestion_cursos.model.Course;
import com.example.gestion_cursos.model.Student;
import com.example.gestion_cursos.service.CourseService;
import com.example.gestion_cursos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping("/todos")
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }
    @PostMapping("/crear")
    public Course saveCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    @PutMapping("/editar/{id}")
    public Course updateCourse(@RequestBody Course courseDetails, @PathVariable Integer id) {
        return service.updateCourse(id, courseDetails);
    }
    @DeleteMapping("eliminar/{id}")
    public void deleteCourse(@PathVariable Integer id) {
        service.deleteCourse(id);
    }
}