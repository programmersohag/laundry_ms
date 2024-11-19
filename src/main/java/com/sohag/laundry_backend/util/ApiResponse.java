package com.sohag.laundry_backend.util;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponse<T> {

    private boolean success;
    private String message;
    private T data;
    private List<String> errors;
}
