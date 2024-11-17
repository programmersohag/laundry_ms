package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "production")
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer employeeId;
    private String details;
    private Integer total;
    private Date dateOfIssue;
}
