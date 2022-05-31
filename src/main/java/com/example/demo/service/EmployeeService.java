package com.example.demo.service;

import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.dto.request.EmployeeRequest;
import com.example.demo.model.dto.response.EmployeeResponse;
import com.example.demo.model.dto.response.EmployeesResponse;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface EmployeeService {

    ResponseEntity<EmployeesResponse> findAllEmployees();

    ResponseEntity<EmployeeResponse> findOneEmployee(long id);

    String saveEmployee(EmployeeRequest request);

    String replaceEmployee(EmployeeDto employeeDto, long id);

    Void deleteEmployee(long id);


}
