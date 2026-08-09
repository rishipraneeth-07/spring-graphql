package com.college.springgraphql.controller;

import com.college.springgraphql.dto.DepartmentInput;
import com.college.springgraphql.dto.DepartmentResponse;
import com.college.springgraphql.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @QueryMapping(name = "department")
    public DepartmentResponse getDepartmentById(@Argument Long id) {
        return departmentService.getDepartmentById(id);
    }

    @QueryMapping(name = "departments")
    public List<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @MutationMapping(name = "createDepartment")
    public DepartmentResponse createDepartment(
            @Argument DepartmentInput department) {

        return departmentService.createDepartment(department);
    }

    @MutationMapping(name = "updateDepartment")
    public DepartmentResponse updateDepartment(
            @Argument Long id,
            @Argument DepartmentInput department) {

        return departmentService.updateDepartment(id, department);
    }

    @MutationMapping(name = "deleteDepartment")
    public boolean deleteDepartment(@Argument Long id) {
        return departmentService.deleteDepartmentById(id);
    }
}