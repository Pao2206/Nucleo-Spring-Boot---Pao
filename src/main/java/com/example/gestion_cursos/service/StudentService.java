package com.example.gestion_cursos.service;

import com.example.gestion_cursos.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student saveStudent(Student student);

    Student getStudentById(Integer studentId);

    Student updateStudent(Integer id, Student studentDetails);

    void deleteStudent(Integer studentId);
}
