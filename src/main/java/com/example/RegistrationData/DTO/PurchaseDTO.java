package com.example.RegistrationData.DTO;

import java.math.BigDecimal;

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

    // Getters and Setters
    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
