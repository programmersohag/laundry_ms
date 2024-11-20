package com.sohag.laundry_backend.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private String customerCode;
    private String name;
    private String gender;
    private String address;
    private String phoneNo;

    public CustomerDto() {
    }

    public CustomerDto(String customerCode, String name, String gender, String address, String phoneNo) {
        this.customerCode = customerCode;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}