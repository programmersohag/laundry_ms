package com.sohag.laundry_backend.repository;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.enums.Status;
import com.sohag.laundry_backend.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {

    @Query("select new com.sohag.laundry_backend.dto.EmployeeDto(e.id, e.name, e.gender, e.address, e.phoneNo, e.monthlySalary, e.joiningDate, e.quitDate) from Employee e where e.employeeStatus = com.sohag.laundry_backend.enums.Status.ACTIVE order by e.id")
    List<EmployeeDto> findAllEmployees();

    @Query("select new com.sohag.laundry_backend.dto.EmployeeDto(e.id, e.name, e.gender, e.address, e.phoneNo, e.monthlySalary, e.joiningDate, e.quitDate) from Employee e where cast(e.joiningDate as date) between ?1 and ?2 order by e.id")
    List<EmployeeDto> findAllByDateBetween(Date from, Date to);

    Long countByEmployeeStatus(Status status);
}
