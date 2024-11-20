package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public String employee() {
        return "views/employee";
    }

    @PostMapping
    public String addEmployee(@RequestBody EmployeeDto dto) {
        dto = employeeService.doSave(dto);
        return "redirect:/customer";
    }
}