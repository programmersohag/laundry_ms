package com.sohag.laundry_backend.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderSummaryDto {
    private Double totalAmount;

    public OrderSummaryDto(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
