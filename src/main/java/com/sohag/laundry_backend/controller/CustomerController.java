package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.model.Customer;
import com.sohag.laundry_backend.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String addCustomer(@RequestBody CustomerDto dto) {
        dto = customerService.doSave(dto);
        return "redirect:/customer";
    }
}