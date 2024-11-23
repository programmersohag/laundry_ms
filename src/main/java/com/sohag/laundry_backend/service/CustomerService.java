package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Customer;
import com.sohag.laundry_backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public CustomerDto doUpdate(CustomerDto dto) throws NotFoundException {
        Customer customer = findByCode(dto.getCustomerCode());
        customer.setName(dto.getName());
        customer.setAddress(dto.getAddress());
        customerRepository.save(customer);
        return dto;
    }

    public Customer findById(Integer id) throws NotFoundException {
        return customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    public Customer findByCode(String code) throws NotFoundException {
        return customerRepository.findByCustomerCode(code).orElseThrow(() -> new NotFoundException("Customer not found"));
    }

    public List<CustomerDto> findAll() {
        return customerRepository.findAllCustomer();
    }

    public String getCode(List<CustomerDto> customers) {
        String code = "";
        int len = customers.size();
        if (len == 0) {
            code = "P000";
        } else {
            int last_id = Integer.parseInt(customers.get(len - 1).getCustomerCode().substring(1, 4));
            code = "P00" + (last_id + 2);
        }
        return code;
    }

    public void doRemove(String customerCode) throws NotFoundException {
       Customer customer = findByCode(customerCode);
       customerRepository.delete(customer);
    }
}
