package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.CustomerDto;
import com.sohag.laundry_backend.enums.Gender;
import com.sohag.laundry_backend.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    @Query("select new com.sohag.laundry_backend.dto.CustomerDto(c.id, c.name, c.gender, c.address, c.phoneNo) from Customer c order by c.id")
    List<CustomerDto> findAllCustomer();

    @Query("select new com.sohag.laundry_backend.dto.CustomerDto(c.id, c.name, c.gender, c.address, c.phoneNo) from Customer c where (c.gender = ?1 or ?1 is null) order by c.id")
    List<CustomerDto> findAllByGender(Gender gender);

    @Query("select new com.sohag.laundry_backend.dto.CustomerDto(c.id, c.name, c.gender, c.address, c.phoneNo) from Customer c where (c.gender = ?1 or ?1 is null) order by c.id")
    Integer countBy(Gender gender);

}
