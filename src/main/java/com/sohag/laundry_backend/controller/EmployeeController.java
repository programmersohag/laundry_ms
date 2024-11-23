package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public String employee(Model model) {
        List<EmployeeDto> list = employeeService.findAll();
        model.addAttribute("employees", list);
        model.addAttribute("code", employeeService.getCode(list));
        return "views/employee";
    }

    @GetMapping("/report")
    public String report() {
        return "views/report/report_employee";
    }

    @PostMapping
    public String addEmployee(@RequestBody EmployeeDto dto) {
        dto = employeeService.doSave(dto);
        return "redirect:/customer";
    }
}