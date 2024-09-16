package com.example.gestion_cursos.controller;

import com.example.gestion_cursos.model.Course;
import com.example.gestion_cursos.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("")
    public String getAllCourses(Model model) {
        List<Course> courses = service.getAllCourses();
        model.addAttribute("courses", courses);
        return "courses";
    }

    @GetMapping("/crear")
    public String createCourseForm(Model model) {
        model.addAttribute("course", new Course());
        return "newCourse";
    }

    @PostMapping("/editar/{id}")
    public String updateCourse(@PathVariable Integer id,
                               @ModelAttribute Course course) {
        Course updatedCourse = service.updateCourse(id, course);
        return "redirect:/courses";
    }
    @PostMapping("/crear")
    public String saveCourse(@ModelAttribute Course course) {
        service.saveCourse(course);
        return "redirect:/courses";
    }

    @GetMapping("/editar/{id}")
    public String editCourseForm(@PathVariable Integer id, Model model) {
        Course course = service.getCourseById(id);
        model.addAttribute("course", course);
        return "editCourse";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteCourse(@PathVariable("id") Integer id) {
        service.deleteCourse(id);
        return "redirect:/courses";
    }
}
