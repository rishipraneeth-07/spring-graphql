package com.college.springgraphql.controller;

import com.college.springgraphql.dto.StudentInput;
import com.college.springgraphql.entity.Student;
import com.college.springgraphql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @QueryMapping(name = "student")
    public Student getStudentById(@Argument("id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @QueryMapping(name = "students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @MutationMapping(name = "createStudent")
    public Student createStudent(@Argument StudentInput  student) {
        return studentService.createStudent(student);
    }
}
