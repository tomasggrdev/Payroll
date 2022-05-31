package com.example.demo.model.dto.response;


import com.example.demo.model.dto.EmployeeDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeResponse {

    private EmployeeDto employeeDto;
}
