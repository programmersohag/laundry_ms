package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.service.EmployeeService;
import com.sohag.laundry_backend.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/expenditure")
public class ExpenditureController {
    private final ProductionService productionService;
    private final EmployeeService employeeService;

    public ExpenditureController(ProductionService productionService, EmployeeService employeeService) {
        this.productionService = productionService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String production(Model model) {
        List<ProductionDto> list = productionService.findAll();
        model.addAttribute("expenditures", list);
        model.addAttribute("employees", employeeService.findAll());
        return "views/expenditure";
    }

    @GetMapping("/report")
    public String report() {
        return "views/report/report_expenditure";
    }

    @GetMapping("/salary")
    public String salary() {
        return "views/report/report_expenditure";
    }

    @PostMapping
    public String addProduction(@RequestBody ProductionDto dto) {
        dto = productionService.doSave(dto);
        return "redirect:/customer";
    }
}