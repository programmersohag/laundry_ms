package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Query("select new com.sohag.laundry_backend.dto.CustomerDto(c.customerCode, c.name, c.gender, c.address, c.phoneNo) from Customer c order by c.customerCode")
    List<CustomerDto> findAllCustomer();

    Optional<Customer> findByCustomerCode(String code);
}
