package com.investec.investec.assesment.model;

import lombok.Data;

public enum AddressType {
    BUSINESS_ADDRESS("5","Business Address"),
    PHYSICAL_ADDRESS("1","Physical Address"),
    POSTAL_ADDRESS("2","Postal Address");
    private String description;
    private String code;

    AddressType(String description,String code) {
        this.description=description;
        this.code=code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
