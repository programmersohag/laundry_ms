package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Customer;
import com.sohag.laundry_backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto doSave(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customer.setCustomerCode(dto.getCustomerCode());
        customer.setGender(dto.getGender());
        customer.setPhoneNo(dto.getPhoneNo());
        customerRepository.save(customer);
        return dto;
    }

    @Transactional
    public CustomerDto doUpdate(Integer id, CustomerDto dto) throws NotFoundException {
        Customer customer = findById(id);
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customerRepository.save(customer);
        return dto;
    }

    public Customer findById(Integer id) throws NotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
    }
}
