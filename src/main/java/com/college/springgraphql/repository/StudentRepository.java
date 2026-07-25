package com.college.springgraphql.repository;

import com.college.springgraphql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByEmail(String email);
}
