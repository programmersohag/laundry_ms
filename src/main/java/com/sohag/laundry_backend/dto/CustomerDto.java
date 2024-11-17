package com.sohag.laundry_backend.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String customerCode;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;
}