package com.example.RegistrationData.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseDTO {
    private Integer purchaseId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
    private Integer customerId;

    // Constructor
    public PurchaseDTO(Integer purchaseId, String productName, BigDecimal price, Integer quantity, Integer customerId) {
        this.purchaseId = purchaseId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.customerId = customerId;
    }
}
