package com.BasicSpringBootProject2.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Integer id;

    @NotEmpty(message = "Name can't be empty!,")
    private String name;

    @NotEmpty(message = "E-mail can't be empty")
    @Email
    private String email;

    @NotNull(message = "Salary can't be empty!,")
    private Double salary;
}
