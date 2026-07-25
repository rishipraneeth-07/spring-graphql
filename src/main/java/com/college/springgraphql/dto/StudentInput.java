package com.college.springgraphql.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInput {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 16, message = "Age must be at least 16")
    @Max(value = 100, message = "Age must not exceed 100")
    private Integer age;

    @NotBlank(message = "Email is required")
    @Email(message = "Email format is invalid")
    private String email;

    @Min(value = 0, message = "CGPA cannot be negative")
    @Max(value = 10, message = "CGPA cannot be greater than 10")
    private Double cgpa;
}
