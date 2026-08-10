package com.college.springgraphql.service.impl;

import com.college.springgraphql.dto.StudentInput;
import com.college.springgraphql.dto.StudentPage;
import com.college.springgraphql.entity.Department;
import com.college.springgraphql.entity.Student;
import com.college.springgraphql.enums.SortDirection;
import com.college.springgraphql.enums.StudentSortField;
import com.college.springgraphql.exception.DepartmentNotFoundException;
import com.college.springgraphql.exception.EmailAlreadyExistsException;
import com.college.springgraphql.exception.StudentNotFoundException;
import com.college.springgraphql.repository.DepartmentRepository;
import com.college.springgraphql.repository.StudentRepository;
import com.college.springgraphql.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public Student createStudent(StudentInput studentInput) {
        Student student = new Student();

        student.setName(studentInput.getName());
        student.setAge(studentInput.getAge());
        student.setEmail(studentInput.getEmail());
        student.setCgpa(studentInput.getCgpa());

        if (studentInput.getDepartmentId() != null) {

            Department department = departmentRepository.findById(
                    studentInput.getDepartmentId()
            ).orElseThrow(
                    () -> new DepartmentNotFoundException("Department not found")
            );

            student.setDepartment(department);
        }

        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                ()->new StudentNotFoundException("Student not found"));

    }

    @Override
    public StudentPage getAllStudents(
            int page,
            int size,
            StudentSortField sortBy,
            SortDirection direction
    ) {

        Sort.Direction springDirection =
                Sort.Direction.valueOf(direction.name());

        Sort sort = Sort.by(
                springDirection,
                sortBy.getFieldName()
        );

        Pageable pageable = PageRequest.of(
                page,
                size,
                sort
        );

        Page<Student> students = studentRepository.findAll(pageable);

        return StudentPage.builder()
                .content(students.getContent())
                .totalElements(students.getTotalElements())
                .totalPages(students.getTotalPages())
                .pageNumber(students.getNumber())
                .pageSize(students.getSize())
                .first(students.isFirst())
                .last(students.isLast())
                .build();
    }

    @Override
    public Student updateStudent(Long id, StudentInput studentInput) {

        Student studentBefore = studentRepository.findById(id)
                .orElseThrow(
                        () -> new StudentNotFoundException("Student not found")
                );

        if (!studentBefore.getEmail().equals(studentInput.getEmail())) {

            Student studentAfter =
                    studentRepository.findByEmail(studentInput.getEmail());

            if (studentAfter != null) {
                throw new EmailAlreadyExistsException("Email already exists");
            }
        }

        studentBefore.setName(studentInput.getName());
        studentBefore.setAge(studentInput.getAge());
        studentBefore.setEmail(studentInput.getEmail());
        studentBefore.setCgpa(studentInput.getCgpa());

        if (studentInput.getDepartmentId() != null) {

            Department department = departmentRepository.findById(
                    studentInput.getDepartmentId()
            ).orElseThrow(
                    () -> new DepartmentNotFoundException("Department not found")
            );

            studentBefore.setDepartment(department);
        }

        return studentRepository.save(studentBefore);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
        return true;
    }
}
