package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.dto.response.EmployeeResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<EmployeeResponse> findAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());

        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .employeeDtoList(employeeDtos)
                .build();

        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
}
