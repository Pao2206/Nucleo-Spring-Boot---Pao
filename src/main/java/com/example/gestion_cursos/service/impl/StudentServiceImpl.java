package com.example.gestion_cursos.service.impl;

import com.example.gestion_cursos.model.Student;
import com.example.gestion_cursos.repositories.StudentRepo;
import com.example.gestion_cursos.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }
    @Override
    public Student saveStudent(Student student){
        return studentRepo.save(student);
    }
    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
     public Student updateStudent(Integer id, Student studentDetails) {
         Student student = getStudentById(id);
         if (student != null) {
             student.setFirstName(studentDetails.getFirstName());
             student.setLastName(studentDetails.getLastName());
             student.setDateBirth(studentDetails.getDateBirth());
             student.setEmail(studentDetails.getEmail());
             return studentRepo.save(student);
         }
         return null;
     }

    @Override
    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }

}
