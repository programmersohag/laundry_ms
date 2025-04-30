package com.sohag.laundry_backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDto {
    private String trxId;
    private String employeeId;
    private String customerId;
    private String weight;
    private Integer total;
    private Date dateOfOrder;
    private Date dateOfDelivery;
}
