package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.enums.Gender;
import com.sohag.laundry_backend.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String customer(Model model) {
        List<CustomerDto> list = customerService.findAll();
        model.addAttribute("customers", list);
        model.addAttribute("code", customerService.getCode(list));
        return "views/customer";
    }

    @PostMapping("/add")
    public String addCustomer(Model model, @ModelAttribute CustomerDto dto) {
        try {
            customerService.doSave(dto);
            model.addAttribute("path", "customer");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            return "views/notifications/insert_failed";
        }
    }

    @PostMapping("/edit")
    public String editCustomer(Model model, @ModelAttribute CustomerDto dto, RedirectAttributes redirect) {
        try {
            customerService.doUpdate(dto);
            model.addAttribute("path", "customer");
            return "views/notifications/insert_success";
        } catch (Exception e) {
            return "views/notifications/insert_failed";
        }
    }

    @GetMapping("/delete/{customerCode}")
    public String removeCustomer(Model model, @PathVariable String customerCode) {
        try {
            customerService.doRemove(customerCode);
            model.addAttribute("path", "customer");
            return "views/notifications/delete_success";
        } catch (Exception e) {
            return "views/notifications/delete_failed";
        }
    }

    @GetMapping("/report-filter")
    public String reportFilter() {
        return "views/report/report_filter_customer";
    }

    @PostMapping("/report-filter")
    @ResponseBody
    public ResponseEntity<List<CustomerDto>> reportData(@RequestParam(required = false) Gender gender) {
        List<CustomerDto> list = customerService.findAllByGender(gender);
        return ResponseEntity.ok(list);
    }
}