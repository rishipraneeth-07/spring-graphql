package com.college.springgraphql.service.impl;

import com.college.springgraphql.dto.DepartmentInput;
import com.college.springgraphql.dto.DepartmentResponse;
import com.college.springgraphql.entity.Department;
import com.college.springgraphql.exception.DepartmentAlreadyExistsException;
import com.college.springgraphql.exception.DepartmentNotFoundException;
import com.college.springgraphql.mapper.DepartmentMapper;
import com.college.springgraphql.repository.DepartmentRepository;
import com.college.springgraphql.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(DepartmentInput departmentInput) {

        if (departmentRepository.existsByName(departmentInput.getName())) {
            throw new DepartmentAlreadyExistsException("Department already exists");
        }

        Department department = Department.builder()
                .name(departmentInput.getName())
                .hod(departmentInput.getHod())
                .building(departmentInput.getBuilding())
                .build();

        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.toResponse(savedDepartment);
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found"));

        return DepartmentMapper.toResponse(department);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {

        return departmentRepository.findAll()
                .stream()
                .map(DepartmentMapper::toResponse)
                .toList();
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentInput departmentInput) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found"));

        if (!department.getName().equals(departmentInput.getName())
                && departmentRepository.existsByName(departmentInput.getName())) {

            throw new DepartmentAlreadyExistsException("Department already exists");
        }

        department.setName(departmentInput.getName());
        department.setHod(departmentInput.getHod());
        department.setBuilding(departmentInput.getBuilding());

        Department updatedDepartment = departmentRepository.save(department);

        return DepartmentMapper.toResponse(updatedDepartment);
    }

    @Override
    public boolean deleteDepartmentById(Long id) {

        Department department = departmentRepository.findById(id)
                .orElseThrow(() ->
                        new DepartmentNotFoundException("Department not found"));

        departmentRepository.delete(department);

        return true;
    }
}