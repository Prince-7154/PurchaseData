package com.example.RegistrationData.Services.serviceInterface;

import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Purchase;

import java.util.List;

public interface PurchaseService {

    public List<PurchaseDTO> getAllPurchases();
    public Purchase updatePurchase(Purchase purchase);
    public void deletePurchase(Integer id);
}
