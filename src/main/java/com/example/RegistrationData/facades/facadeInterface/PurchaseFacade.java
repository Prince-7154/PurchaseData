package com.example.RegistrationData.facades.facadeInterface;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.DTO.PurchaseDTO;

import java.util.List;

public interface PurchaseFacade {
    public List<PurchaseDTO> getAllPurchase();
}
