package com.sohag.laundry_backend.enums;

public enum Gender {
    MALE(1), FEMALE(2), OTHERS(3);

    private final int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
