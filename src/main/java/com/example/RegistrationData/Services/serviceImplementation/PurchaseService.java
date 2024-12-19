package com.example.RegistrationData.Services.serviceImplementation;

import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Purchase;
import com.example.RegistrationData.facades.facadesImplementation.PurchaseFacade;
import com.example.RegistrationData.repositories.OrmRepositories.ORMCustomerRepository;
import com.example.RegistrationData.repositories.OrmRepositories.ORMPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService implements com.example.RegistrationData.Services.serviceInterface.PurchaseService {

    @Autowired
    private ORMPurchaseRepository purchaseRepository;


    // Create a new purchase associated with a customer
//    public Purchase createPurchase(Integer customerId, Purchase purchase) {
//        Customer customer = customerRepository.findById(customerId)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//        purchase.setCustomer(customer);
//        return purchaseRepository.save(purchase);
//    }

    // Retrieve all purchases
    public List<PurchaseDTO> getAllPurchases() {
        return purchaseRepository.findAllPurchasesWithCustomerId();
    }

    // Retrieve a specific purchase by ID
    public Optional<Purchase> getPurchaseById(Integer id) {
        return purchaseRepository.findById(id);
    }

    // Update an existing purchase
    public Purchase updatePurchase(Purchase purchase) {
        if (!purchaseRepository.existsById(purchase.getPurchaseId())) {
            throw new RuntimeException("Purchase not found");
        }
        return purchaseRepository.save(purchase);
    }

    // Delete a purchase by ID
    public void deletePurchase(Integer id) {
        if (!purchaseRepository.existsById(id)) {
            throw new RuntimeException("Purchase not found");
        }
        purchaseRepository.deleteById(id);
    }

    // Retrieve purchases by customer ID
//    public List<Purchase> findPurchasesByCustomerId(Integer customerId) {
//        return purchaseRepository.findByCustomerId(customerId);
//    }
}

