package com.example.gestion_cursos.controller;

import com.example.gestion_cursos.model.Student;
import com.example.gestion_cursos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class StudentController {
    @Autowired
    private StudentService service;

     @GetMapping("/todos")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }
    @PostMapping("/crear")
    public Student save(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PutMapping("/editar/{id}")
    public Student updateStudent(@RequestBody Student studentDetails, @PathVariable Integer id) {
         return service.updateStudent(id, studentDetails);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }
}