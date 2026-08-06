package com.college.springgraphql.service;

import com.college.springgraphql.dto.DepartmentInput;
import com.college.springgraphql.dto.DepartmentResponse;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentInput departmentInput);
    DepartmentResponse getDepartmentById(Long id);
    List<DepartmentResponse> getAllDepartments();
    DepartmentResponse updateDepartment(Long id, DepartmentInput departmentInput);
    boolean deleteDepartmentById(Long id);
}
