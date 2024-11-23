package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerCode;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
}