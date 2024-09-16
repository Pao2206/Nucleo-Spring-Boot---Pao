package com.example.gestion_cursos.repositories;

import com.example.gestion_cursos.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {
}
