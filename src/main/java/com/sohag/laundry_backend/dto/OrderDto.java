package com.sohag.laundry_backend.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderDto {
    private String trxId;
    private String employeeId;
    private String employeeName;
    private String customerId;
    private String customerName;
    private Integer weight;
    private Integer total;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfOrder;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfDelivery;

    public OrderDto(String trxId, String employeeId, String employeeName, String customerId, String customerName, Integer weight, Integer total, Date dateOfOrder, Date dateOfDelivery) {
        this.trxId = trxId;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.customerId = customerId;
        this.customerName = customerName;
        this.weight = weight;
        this.total = total;
        this.dateOfOrder = dateOfOrder;
        this.dateOfDelivery = dateOfDelivery;
    }
}
