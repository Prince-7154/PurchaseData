package com.example.RegistrationData.facades.facadesImplementation;

import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.Services.serviceInterface.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseFacade implements com.example.RegistrationData.facades.facadeInterface.PurchaseFacade {
    @Autowired
    private PurchaseService purchaseService;


    @Override
    public List<PurchaseDTO> getAllPurchase() {
       return purchaseService.getAllPurchases();
    }

}
