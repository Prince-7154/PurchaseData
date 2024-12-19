package com.example.RegistrationData.ORMEntity;


import com.example.RegistrationData.ORMEntity.Customer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer purchaseId;

    private String productName;
    private BigDecimal price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;


    public int getCustomerId() {
        return customer.getCustomerId();
    }
}
