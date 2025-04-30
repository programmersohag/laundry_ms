package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.model.Production;
import com.sohag.laundry_backend.model.Transaction;
import com.sohag.laundry_backend.service.EmployeeService;
import com.sohag.laundry_backend.service.ProductionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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

    @GetMapping("/salary")
    public String salary() {
        return "views/report/report_expenditure";
    }

    @PostMapping
    public String addProduction(@RequestBody ProductionDto dto) {
        dto = productionService.doSave(dto);
        return "redirect:/customer";
    }

    @GetMapping("/report-filter")
    public String reportFilter() {
        return "views/report/report_filter_expenditure";
    }

    @PostMapping("/report-filter")
    @ResponseBody
    public ResponseEntity<List<ProductionDto>> reportData(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date from, @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam Date to) {
        List<ProductionDto> list = productionService.findAllByDateRange(from, to);
        return ResponseEntity.ok(list);
    }
}