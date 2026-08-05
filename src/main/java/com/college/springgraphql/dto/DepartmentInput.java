package com.college.springgraphql.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DepartmentInput {
    @NotBlank(message = "Department name cannot be empty")
    private String name;

    @NotBlank(message = "HOD cannot be empty")
    private String hod;

    @NotBlank(message = "Building cannot be empty")
    private String building;
}
