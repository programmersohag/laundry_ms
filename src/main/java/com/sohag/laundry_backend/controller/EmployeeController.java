package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Transaction;
import com.sohag.laundry_backend.service.EmployeeService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String addEmployee(@ModelAttribute EmployeeDto dto) {
        dto = employeeService.doSave(dto);
        return "redirect:/employee";
    }

    @PostMapping("/edit")
    public String editEmployee(@ModelAttribute EmployeeDto dto, RedirectAttributes redirect) {
        try {
            dto = employeeService.doUpdate(dto);
            redirect.addFlashAttribute("message", "Edited Successfully");
        } catch (NotFoundException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/employee";
    }

    @GetMapping("/delete/{empCode}")
    public String removeEmployee(@PathVariable String empCode, RedirectAttributes redirect) {
        try {
            employeeService.removeById(empCode);
            redirect.addFlashAttribute("message", "Deleted Successfully");
        } catch (NotFoundException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/employee";
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