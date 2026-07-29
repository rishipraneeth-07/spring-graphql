package com.college.springgraphql.service.impl;

import com.college.springgraphql.dto.StudentInput;
import com.college.springgraphql.entity.Student;
import com.college.springgraphql.exception.EmailAlreadyExistsException;
import com.college.springgraphql.exception.StudentNotFoundException;
import com.college.springgraphql.repository.StudentRepository;
import com.college.springgraphql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student createStudent(StudentInput studentInput) {
        Student existingStudent = studentRepository.findByEmail(studentInput.getEmail());

        if (existingStudent != null) {
            throw new EmailAlreadyExistsException(
                    "Email already exists: " + studentInput.getEmail());
        }
        Student student = new Student();
        student.setName(studentInput.getName());
        student.setAge(studentInput.getAge());
        student.setEmail(studentInput.getEmail());
        student.setCgpa(studentInput.getCgpa());
        Student savedStudent=studentRepository.save(student);
        return  savedStudent;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                ()->new StudentNotFoundException("Student not found"));

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Long id, StudentInput studentInput) {

        Student student = getStudentById(id);

        if (!student.getEmail().equals(studentInput.getEmail())) {

            Student existingStudent = studentRepository.findByEmail(studentInput.getEmail());

            if (existingStudent != null) {
                throw new EmailAlreadyExistsException(
                        "Email already exists: " + studentInput.getEmail());
            }

            student.setEmail(studentInput.getEmail());
        }

        student.setName(studentInput.getName());
        student.setAge(studentInput.getAge());
        student.setCgpa(studentInput.getCgpa());

        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return true;
    }
}
