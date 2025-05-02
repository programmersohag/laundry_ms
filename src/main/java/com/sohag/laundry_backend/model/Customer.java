package com.sohag.laundry_backend.model;

import com.sohag.laundry_backend.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private Gender gender;
    private String address;
    private String phoneNo;

    public Customer() {
    }
    public Customer(String id) {
        this.id = id;
    }
}