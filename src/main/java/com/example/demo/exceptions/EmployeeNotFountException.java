
package com.example.demo.exceptions;


import lombok.Data;

import java.util.function.Supplier;

public class EmployeeNotFountException extends RuntimeException {

    public EmployeeNotFountException(Long id) {
        super("could no find employe " + id);
    }
    
}
