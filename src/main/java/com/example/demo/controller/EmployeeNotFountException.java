
package com.example.demo.controller;


public class EmployeeNotFountException extends RuntimeException {

    public EmployeeNotFountException(Long id) {
        super("could no find employe " + id);
    }
    
}
