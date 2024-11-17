package com.sohag.laundry_backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private Double monthlySalary;
    private Date joiningDate;
    private Date quitDate;
    private Boolean isActive;
}
