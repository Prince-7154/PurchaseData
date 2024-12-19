
package com.example.RegistrationData.ORMEntity;
import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Purchase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purchase> purchases = new ArrayList<>();


}
