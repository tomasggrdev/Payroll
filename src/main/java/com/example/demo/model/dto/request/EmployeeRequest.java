package com.example.demo.model.dto.request;

import com.example.demo.model.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

    private EmployeeDto employeeDto;
}
