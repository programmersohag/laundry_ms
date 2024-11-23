package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto doSave(EmployeeDto dto) {
        return null;
    }

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAllEmployees();
    }

    public String getCode(List<EmployeeDto> employees) {
        String code;
        int len = employees.size();
        if (len == 0) {
            code = "K000";
        } else {
            int last_id = Integer.parseInt(employees.get(len - 1).getId().substring(1, 4));
            code = "K00" + (last_id + 2);
        }
        return code;
    }
}
