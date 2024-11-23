package com.sohag.laundry_backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    private Long id;
    private String employeeId;
    private Integer customerId;
    private String weight;
    private Integer total;
    private Date dateOfOrder;
    private Date dateOfDelivery;
}
