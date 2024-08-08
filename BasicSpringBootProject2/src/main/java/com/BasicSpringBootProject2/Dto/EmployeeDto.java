package com.BasicSpringBootProject2.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(
        description = "Employee Dto management Information"
)
public class EmployeeDto {

    private Integer id;

    @NotEmpty(message = "Name can't be empty!,")
    @Schema(
            description = "Employee name"
    )
    private String name;

    @NotEmpty(message = "E-mail can't be empty")
    @Email
    @Schema(
            description = "Employee email"
    )
    private String email;

    @NotNull(message = "Salary can't be empty!,")
    @Schema(
            description = "Employee salary"
    )
    private Double salary;
}
