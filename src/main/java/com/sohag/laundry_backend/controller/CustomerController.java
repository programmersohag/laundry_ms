package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.service.CustomerService;
import com.sohag.laundry_backend.util.ApiResponse;
import com.sohag.laundry_backend.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CustomerDto>> editCustomer(@PathVariable Integer id, @RequestBody CustomerDto dto) {
        try {
            dto = customerService.doUpdate(id, dto);
            return ResponseUtil.success(dto, "");
        } catch (NotFoundException e) {
            return ResponseUtil.badRequest(null, e.getMessage());
        }
    }
}