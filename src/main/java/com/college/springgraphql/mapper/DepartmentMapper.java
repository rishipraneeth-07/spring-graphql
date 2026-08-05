package com.college.springgraphql.mapper;

import com.college.springgraphql.dto.DepartmentResponse;
import com.college.springgraphql.entity.Department;

public class DepartmentMapper {
    public static DepartmentResponse toResponse(Department department) {
        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .hod(department.getHod())
                .building(department.getBuilding())
                .build();
    }
}
