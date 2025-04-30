package com.sohag.laundry_backend.model;

import com.sohag.laundry_backend.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private Double monthlySalary;
    private Date joiningDate;
    private Date quitDate;
    private Status employeeStatus;
}
