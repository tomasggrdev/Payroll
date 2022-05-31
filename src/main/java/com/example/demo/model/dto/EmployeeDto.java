
package com.example.demo.model.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto implements Serializable{

    public EmployeeDto(String name, String lastName, String role, int age) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.age = age;
    }

    private long id;
    private String name;
    private String lastName;
    private String role;
    private int age;




}

