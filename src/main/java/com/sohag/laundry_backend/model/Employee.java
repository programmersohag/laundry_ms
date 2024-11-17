package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
    private Double monthlySalary;
    private Date joiningDate;
    private Date quitDate;
    private Boolean isActive;
}
