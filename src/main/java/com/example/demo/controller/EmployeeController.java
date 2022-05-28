
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/v1/employees/")
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository repository;
    
    @Autowired
    private EmployeeModelAssembler assembler;
    
//    @GetMapping("/")
//    public CollectionModel<EntityModel<Employee>> all(){
//        List<EntityModel<Employee>> employees = repository.findAll().stream()
//                .map(assembler::toModel).collect(Collectors.toList());
//
//
//        return CollectionModel.of(employees,linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
//    }

    @GetMapping("/")
    public CollectionModel<EntityModel<Employee>> all(){
        List<EntityModel<Employee>> employees = repository.findAll().stream()
                .map(assembler::toModel).collect(Collectors.toList());


        return CollectionModel.of(employees,linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }

    @PostMapping("/")
    public ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee){
        
        EntityModel<Employee> employee = assembler.toModel(repository.save(newEmployee));
        
        return ResponseEntity.created(employee.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(employee);
    }
    
    @GetMapping("/{id}")
    public EntityModel<Employee> one(@PathVariable Long id){
        
        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFountException(id));
    
        return assembler.toModel(employee);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> replaceEmploye(@RequestBody Employee newEmployee, @PathVariable Long id){
        
        Employee updateEmployee = repository.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setRole(newEmployee.getRole());
            employee.setLastName(newEmployee.getLastName());
            employee.setAge(newEmployee.getAge());
            return repository.save(employee);
        }).orElseGet(() -> {
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
        
        EntityModel<Employee> entityModel = assembler.toModel(updateEmployee);
        
        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmploye(@PathVariable Long id){
        
        repository.deleteById(id);
        
        return ResponseEntity.noContent().build();
    }
    
}
