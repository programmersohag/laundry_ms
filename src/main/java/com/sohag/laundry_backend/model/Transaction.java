package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer employeeId;
    private Integer customerId;
    private String weight;
    private Integer total;
    private Date dateOfOrder;
    private Date dateOfDelivery;
}
