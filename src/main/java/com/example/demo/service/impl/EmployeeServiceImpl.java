package com.example.demo.service.impl;

import com.example.demo.exceptions.EmployeeNotFountException;
import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.dto.request.EmployeeRequest;
import com.example.demo.model.dto.response.EmployeeResponse;
import com.example.demo.model.dto.response.EmployeesResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import com.example.demo.utils.Messages;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<EmployeesResponse> findAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDto> employeeDtos = employees.stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());

        EmployeesResponse employeesResponse = EmployeesResponse.builder()
                .employeeDtoList(employeeDtos)
                .build();

        return new ResponseEntity<>(employeesResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EmployeeResponse> findOneEmployee(long id){

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFountException(id));

        EmployeeDto employeeDto = mapper.map(employee,EmployeeDto.class);

        EmployeeResponse employeeResponse = EmployeeResponse.builder()
                .employeeDto(employeeDto).build();

        return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
    }
    @Override
    public String saveEmployee(EmployeeRequest employeeRequest){


        EmployeeDto employeeDto = employeeRequest.getEmployeeDto();

        Employee employee = mapper.map(employeeDto,Employee.class);
        System.out.printf(employee.getLastName());

        employeeRepository.save(employee);

        return Messages.SAVED;
    }
    @Override
    public String replaceEmployee(EmployeeDto employeeDto, long id){

        Employee newEmployee = mapper.map(employeeDto, Employee.class);

        Employee employee = employeeRepository.findById(id).map( emp -> {
            emp.setName(newEmployee.getName());
            emp.setAge(newEmployee.getAge());
            emp.setRole(newEmployee.getRole());
            emp.setLastName(newEmployee.getLastName());
            return emp;
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return newEmployee;
        });

        employeeRepository.save(employee);

        return Messages.REPLACED;

    }
    @Override
    public Void deleteEmployee(long id){

        employeeRepository.deleteById(id);
        return null;

    }
}
