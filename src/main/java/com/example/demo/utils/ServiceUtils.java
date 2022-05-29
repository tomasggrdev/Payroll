package com.example.demo.utils;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;

public class ServiceUtils {

    public EmployeeDto EmployeeToEmployeeDto(Employee employee){
        return  new EmployeeDto();
    }

}
