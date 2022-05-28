/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author tomas
 */
@ControllerAdvice
public class EmployeeNotFoundController {
    
 @ResponseBody
 @ExceptionHandler(EmployeeNotFountException.class)
 @ResponseStatus(HttpStatus.NOT_FOUND)
 public String employeeNotFoundHandler(EmployeeNotFountException e){
     return e.getMessage();
 }
    
}
