package com.sohag.laundry_backend.dto;

import com.sohag.laundry_backend.enums.Gender;
import com.sohag.laundry_backend.enums.Status;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class EmployeeDto {
    private String id;
    private String name;
    private Gender gender;
    private String address;
    private String phoneNo;
    private Double monthlySalary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date joiningDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date quitDate;
    private Status employeeType;

    public EmployeeDto(String id, String name, Gender gender, String address, String phoneNo, Double monthlySalary, Date joiningDate, Date quitDate) {
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
