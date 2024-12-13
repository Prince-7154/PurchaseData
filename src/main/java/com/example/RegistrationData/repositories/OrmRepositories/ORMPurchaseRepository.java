package com.example.RegistrationData.repositories.OrmRepositories;

import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ORMPurchaseRepository extends JpaRepository<Purchase, Integer> {
    @Query("SELECT new com.example.RegistrationData.DTO.PurchaseDTO(p.purchaseId, p.productName, p.price, p.quantity, p.customer.customerId) FROM Purchase p")
    List<PurchaseDTO> findAllPurchasesWithCustomerId();
}
