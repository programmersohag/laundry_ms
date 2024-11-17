package com.sohag.laundry_backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {
    private Integer employeeId;
    private Integer customerId;
    private String weight;
    private Integer total;
    private Date dateOfOrder;
    private Date dateOfDelivery;
}
