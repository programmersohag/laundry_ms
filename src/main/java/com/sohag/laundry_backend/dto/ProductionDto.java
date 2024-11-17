package com.sohag.laundry_backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductionDto {
    private Integer employeeId;
    private String details;
    private Integer total;
    private Date dateOfIssue;
}
