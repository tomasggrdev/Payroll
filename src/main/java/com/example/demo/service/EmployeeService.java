package com.example.demo.service;

import com.example.demo.model.dto.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<EmployeeResponse> findAllEmployees();
}
