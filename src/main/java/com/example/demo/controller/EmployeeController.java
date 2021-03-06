
package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.dto.EmployeeDto;
import com.example.demo.model.dto.request.EmployeeRequest;
import com.example.demo.model.dto.response.EmployeeResponse;
import com.example.demo.model.dto.response.EmployeesResponse;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees/")
@RequiredArgsConstructor
public class EmployeeController {
    

    private final EmployeeModelAssembler assembler;
    private final EmployeeService employeeService;

    @GetMapping("/")
    public ResponseEntity<EmployeesResponse> all(){
        return employeeService.findAllEmployees();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> one(@PathVariable long id){
        return employeeService.findOneEmployee(id);
    }

    @PostMapping("/")
    public String save(@RequestBody EmployeeRequest request){
        return employeeService.saveEmployee(request);
    }

    @PutMapping("/{id}")
    public String replace(@RequestBody EmployeeRequest employeeRequest,@PathVariable long id){
        return employeeService.replaceEmployee(employeeRequest.getEmployeeDto(),id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        employeeService.deleteEmployee(id);
    }


//    }
//        return assembler.toModel(employee);
//
//        Employee employee = repository.findById(id).orElseThrow(() -> new EmployeeNotFountException(id));
//
//    public EntityModel<Employee> one(@PathVariable Long id){
//    @GetMapping("/{id}")
    /*    @PostMapping("/")
        public ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee){

            EntityModel<Employee> employee = assembler.toModel(repository.save(newEmployee));

            return ResponseEntity.created(employee.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(employee);
        }*/
//    @GetMapping("/")
//    public CollectionModel<EntityModel<Employee>> all(){
//        List<EntityModel<Employee>> employees = repository.findAll().stream()
//                .map(assembler::toModel).collect(Collectors.toList());
//
//
//        return CollectionModel.of(employees,linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> replaceEmploye(@RequestBody Employee newEmployee,  @PathVariable Long id){
//
//        Employee updateEmployee = repository.findById(id).map(employee -> {
//            employee.setName(newEmployee.getName());
//            employee.setRole(newEmployee.getRole());
//            employee.setLastName(newEmployee.getLastName());
//            employee.setAge(newEmployee.getAge());
//            return repository.save(employee);
//        }).orElseGet(() -> {
//            newEmployee.setId(id);
//            return repository.save(newEmployee);
//        });
//
//        EntityModel<Employee> entityModel = assembler.toModel(updateEmployee);
//
//        return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
//    }
    
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteEmploye(@PathVariable Long id){
//
//        repository.deleteById(id);
//
//        return ResponseEntity.noContent().build();
//    }
    
}
