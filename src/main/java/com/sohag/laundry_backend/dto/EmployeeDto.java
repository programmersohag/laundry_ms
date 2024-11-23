package com.sohag.laundry_backend.dto;

import com.sohag.laundry_backend.enums.EmployeeType;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private String id;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private Double monthlySalary;
    private Date joiningDate;
    private Date quitDate;
    private EmployeeType employeeType;

    public EmployeeDto(String id, String name, String gender, String address, String phoneNo, Double monthlySalary, Date joiningDate, Date quitDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
        this.monthlySalary = monthlySalary;
        this.joiningDate = joiningDate;
        this.quitDate = quitDate;
    }
}
