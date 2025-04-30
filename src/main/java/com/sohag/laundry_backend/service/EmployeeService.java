package com.sohag.laundry_backend.service;

import com.sohag.laundry_backend.dto.EmployeeDto;
import com.sohag.laundry_backend.enums.Status;
import com.sohag.laundry_backend.exception.NotFoundException;
import com.sohag.laundry_backend.model.Employee;
import com.sohag.laundry_backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDto doSave(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setAddress(dto.getAddress());
        employee.setGender(dto.getGender());
        employee.setMonthlySalary(dto.getMonthlySalary());
        employee.setPhoneNo(dto.getPhoneNo());
        employee.setJoiningDate(dto.getJoiningDate());
        employee.setQuitDate(dto.getQuitDate());
        employee.setEmployeeStatus(Status.ACTIVE);
        employeeRepository.save(employee);
        return dto;
    }

    public EmployeeDto doUpdate(EmployeeDto dto) throws NotFoundException {
        Employee employee = findById(dto.getId());
        employee.setName(dto.getName());
        employee.setAddress(dto.getAddress());
        employee.setGender(dto.getGender());
        employee.setMonthlySalary(dto.getMonthlySalary());
        employee.setJoiningDate(dto.getJoiningDate());
        employee.setQuitDate(dto.getQuitDate());
        employeeRepository.save(employee);
        return dto;
    }
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAllEmployees();
    }

    public Employee findById(String id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
    }
    public void removeById(String id) throws NotFoundException {
        Employee employee = findById(id);
        employee.setEmployeeStatus(Status.INACTIVE);
        employeeRepository.save(employee);
    }

    public String getCode(List<EmployeeDto> employees) {
        String code;
        int len = employees.size();
        if (len == 0) {
            code = "K000";
        } else {
            int last_id = Integer.parseInt(employees.get(len - 1).getId().substring(1, 4));
            code = "K00" + (last_id + 2);
        }
        return code;
    }

    public List<EmployeeDto> findAllByDateRange(Date from, Date to) {
        return employeeRepository.findAllByDateBetween(from, to);
    }
}
