package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.service.CustomerService;
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

    @PostMapping
    public String addCustomer(@ModelAttribute CustomerDto dto, RedirectAttributes redirect) {
        try {
            dto = customerService.doSave(dto);
            redirect.addFlashAttribute("message", "Added Successfully");
        } catch (Exception e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/customer";
    }

    @PutMapping
    public String editCustomer(@ModelAttribute CustomerDto dto, RedirectAttributes redirect) {
        try {
            dto = customerService.doUpdate(dto);
            redirect.addFlashAttribute("message", "Edited Successfully");
        } catch (NotFoundException e) {
            redirect.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/customer";
    }
}