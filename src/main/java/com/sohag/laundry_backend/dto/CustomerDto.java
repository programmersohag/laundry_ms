package com.sohag.laundry_backend.dto;

import com.sohag.laundry_backend.enums.Gender;
import lombok.Data;

@Data
public class CustomerDto {
    private String customerCode;
    private String name;
    private Gender gender;
    private String address;
    private String phoneNo;

    public CustomerDto() {
    }

    public CustomerDto(String customerCode, String name, Gender gender, String address, String phoneNo) {
        this.customerCode = customerCode;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
    }
}