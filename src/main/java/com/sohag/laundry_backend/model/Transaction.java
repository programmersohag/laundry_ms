package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private String id;
    private String employeeId;
    private String customerId;
    private String weight;
    private Integer total;
    private Date dateOfOrder;
    private Date dateOfDelivery;
    @Transient
    private String employeeName;
    @Transient
    private String customerName;
}
