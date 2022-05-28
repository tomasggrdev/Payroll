
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    @Column(name = "lastname")
    private String lastName;
    private String role;
    private int age;
    
    
    
    public Employee (){}

    public Employee(String name, String lastName, String role, int age) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.age = age;
    }
    
    
    
    
}
