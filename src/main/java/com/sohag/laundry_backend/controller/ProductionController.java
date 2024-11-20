package com.sohag.laundry_backend.controller;

import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/production")
public class ProductionController {
    private final ProductionService productionService;

    public ProductionController(ProductionService productionService) {
        this.productionService = productionService;
    }

    @GetMapping
    public String production() {
        return "views/production";
    }

    @PostMapping
    public String addProduction(@RequestBody ProductionDto dto) {
        dto = productionService.doSave(dto);
        return "redirect:/customer";
    }
}