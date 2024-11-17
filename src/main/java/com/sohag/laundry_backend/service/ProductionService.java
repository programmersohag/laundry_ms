package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.repository.ProductionRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductionService {

    private final ProductionRepository productionRepository;

    public ProductionService(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    public ProductionDto doSave(ProductionDto dto) {
        return null;
    }
}
