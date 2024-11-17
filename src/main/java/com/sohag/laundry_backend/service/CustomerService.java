package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto doSave(CustomerDto dto) {
        return null;
    }
}
