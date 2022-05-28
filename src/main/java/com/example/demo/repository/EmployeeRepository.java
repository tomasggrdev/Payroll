/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

/**
 *
 * @author tomas
 */
public interface EmployeeRepository extends JpaRepositoryImplementation<Employee, Long>{
    
}
