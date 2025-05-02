package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "production")
public class Production {
    @Id
    private Long id;
    private String details;
    private Integer total;
    private Date dateOfIssue;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
