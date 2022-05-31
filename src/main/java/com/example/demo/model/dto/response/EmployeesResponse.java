
package com.example.demo.model.dto.response;

import com.example.demo.model.dto.EmployeeDto;
import lombok.*;

import java.util.List;

@Getter
@Builder
public class EmployeesResponse {

    private List<EmployeeDto> employeeDtoList;





}

