package com.example.RegistrationData.controllers;

import java.util.List;

import com.example.RegistrationData.model.Customer;
import com.example.RegistrationData.model.Purchase;
import com.example.RegistrationData.repositories.CustomerRepository;
import com.example.RegistrationData.repositories.PurchaseRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/raw")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;
    private final CustomerRepository customerRepository;

    public PurchaseController(PurchaseRepository purchaseRepository, CustomerRepository customerRepository) {
        this.purchaseRepository = purchaseRepository;
        this.customerRepository = customerRepository;
    }


    @PostMapping("/purchase")
    public void storePurchase(@RequestBody Purchase purchase){
        purchaseRepository.storePurchase(purchase);
    }

    @PostMapping("/updatePurchase")
    public void updatePurchase(@RequestBody Purchase purchase){
        purchaseRepository.updatePurchase(purchase);
    }

    @PostMapping("/deletePurchase")
    public void deletePurchase(@RequestBody Purchase purchase){
        purchaseRepository.deletePurchase(purchase);
    }


    @GetMapping("/purchase")
    public List<Purchase> findPurchases(){
        return purchaseRepository.findAllPurchases();
    }

    @GetMapping("/customerPurchase")
    public List<Purchase> findPurchasesByCustomerName(@RequestBody Customer customer){
        return purchaseRepository.findAllPurchasesByCustomerName(customer.getCustomerName());
    }



}
