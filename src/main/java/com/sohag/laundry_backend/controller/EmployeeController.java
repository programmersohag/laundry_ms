package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @PostMapping
    public String addEmployee(Model model, @ModelAttribute EmployeeDto dto) {
        try {
            employeeService.doSave(dto);
            model.addAttribute("path", "employee");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            return "views/notifications/insert_failed";
        }
    }

    @PostMapping("/edit")
    public String editEmployee(Model model, @ModelAttribute EmployeeDto dto) {
        try {
            employeeService.doUpdate(dto);
            model.addAttribute("path", "employee");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            return "views/notifications/insert_failed";
        }
    }

    @GetMapping("/delete/{empCode}")
    public String removeEmployee(Model model, @PathVariable String empCode) {
        try {
            employeeService.removeById(empCode);
            model.addAttribute("path", "employee");
            return "views/notifications/delete_success";
        } catch (Exception e) {
            return "views/notifications/delete_failed";
        }
    }

    @GetMapping("/report-filter")
    public String reportFilter() {
        return "views/report/report_filter_employee";
    }

    @PostMapping("/report-filter")
    @ResponseBody
    public ResponseEntity<List<EmployeeDto>> reportData(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date to) {
        List<EmployeeDto> list = employeeService.findAllByDateRange(from, to);
        return ResponseEntity.ok(list);
    }
}