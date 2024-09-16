package com.example.gestion_cursos.controller;

import com.example.gestion_cursos.model.Student;
import com.example.gestion_cursos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("")
    public String getAllStudents(Model model) {
        List<Student> students = service.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/crear")
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "newStudent";
    }

    @PostMapping("/guardar")
    public String saveStudent(@ModelAttribute Student student) {
        service.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/editar/{id}")
    public String editStudent(@PathVariable Integer id, Model model) {
        Student student = service.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/editar/{id}")
    public String updateStudent(@PathVariable Integer id,@ModelAttribute Student student) {
        service.updateStudent(id, student);
        return "redirect:/students";
    }

    @PostMapping("/eliminar/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "redirect:/students";
    }
}
