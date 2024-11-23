package com.sohag.laundry_backend.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductionDto {
    private Long id;
    private String employeeId;
    private String details;
    private Integer total;
    private Date dateOfIssue;

    public ProductionDto() {

    }

    public ProductionDto(Long id, String employeeId, String details, Integer total, Date dateOfIssue) {
        this.id = id;
        this.employeeId = employeeId;
        this.details = details;
        this.total = total;
        this.dateOfIssue = dateOfIssue;
    }
}
