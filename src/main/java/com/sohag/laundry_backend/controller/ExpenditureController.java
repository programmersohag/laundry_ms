package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.ProductionDto;
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

    @GetMapping("/pay/salary")
    public String salary(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "views/pay-salary";
    }

    @PostMapping("/pay/salary")
    public String paySalary(Model model, @ModelAttribute ProductionDto dto) {
        try {
            productionService.paySalary(dto);
            model.addAttribute("path", "expenditure");
            model.addAttribute("employees", employeeService.findAll());
            return "views/notifications/insert_success";
        } catch (Exception e) {
            model.addAttribute("path", "expenditure");
            return "views/notifications/insert_failed";
        }
    }

    @PostMapping("/add")
    public String addProduction(Model model, @ModelAttribute ProductionDto dto) {
        try {
            productionService.doSave(dto);
            model.addAttribute("path", "expenditure");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            model.addAttribute("path", "expenditure");
            return "views/notifications/insert_failed";
        }
    }

    @PostMapping("/edit")
    public String modifyProduction(Model model, @ModelAttribute ProductionDto dto) {
        try {
            productionService.doUpdate(dto);
            model.addAttribute("path", "expenditure");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            model.addAttribute("path", "expenditure");
            return "views/notifications/insert_failed";
        }
    }

    @GetMapping("/delete/{expId}")
    public String remove(Model model, @PathVariable Long expId) {
        try {
            productionService.removeById(expId);
            model.addAttribute("path", "expenditure");
            return "views/notifications/delete_success";
        } catch (Exception e) {
            return "views/notifications/delete_failed";
        }
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