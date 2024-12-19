package com.example.RegistrationData.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private List<PurchaseDTO> purchases;

    // Constructor
    public CustomerDTO(Integer customerId, String customerName, String customerAddress, String customerPhone, String customerEmail, List<PurchaseDTO> purchases) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.purchases = purchases;
    }

}


