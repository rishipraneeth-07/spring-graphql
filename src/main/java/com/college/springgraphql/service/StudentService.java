package com.college.springgraphql.service;

import com.college.springgraphql.dto.StudentInput;
import com.college.springgraphql.dto.StudentPage;
import com.college.springgraphql.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentInput  studentInput);
    Student getStudentById(Long id);
    StudentPage getAllStudents(int page, int size);
    Student updateStudent(Long id, StudentInput studentInput);
    boolean deleteStudentById(Long id);
}
