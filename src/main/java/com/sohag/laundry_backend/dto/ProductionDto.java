package com.sohag.laundry_backend.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ProductionDto {
    private Long id;
    private String employeeId;
    private String employeeName;
    private String details;
    private Integer total;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfIssue;

    public ProductionDto() {

    }

    public ProductionDto(Long id, String employeeId, String employeeName, String details, Integer total, Date dateOfIssue) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.details = details;
        this.total = total;
        this.dateOfIssue = dateOfIssue;
    }
}
