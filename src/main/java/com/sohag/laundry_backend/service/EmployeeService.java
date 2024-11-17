package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto doSave(EmployeeDto dto) {
        return null;
    }
}
