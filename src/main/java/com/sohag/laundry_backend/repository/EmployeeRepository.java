package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.dto.ProductionDto;
import com.sohag.laundry_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("select new com.sohag.laundry_backend.dto.EmployeeDto(e.id, e.name, e.gender, e.address, e.phoneNo, e.monthlySalary, e.joiningDate, e.quitDate) from Employee e where e.empType = com.sohag.laundry_backend.enums.EmployeeType.ACTIVE order by e.id")
    List<EmployeeDto> findAllEmployees();
}
