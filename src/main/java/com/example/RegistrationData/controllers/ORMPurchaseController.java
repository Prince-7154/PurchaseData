package com.example.RegistrationData.controllers;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Customer;
import com.example.RegistrationData.Services.serviceImplementation.CustomerService;
import com.example.RegistrationData.Services.serviceImplementation.PurchaseService;
import com.example.RegistrationData.facades.facadeInterface.CustomerFacade;
import com.example.RegistrationData.facades.facadeInterface.PurchaseFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ORM/customer")
public class ORMPurchaseController {

    @Autowired
    private PurchaseFacade purchaseFacade;

    @GetMapping
    public List<PurchaseDTO> getAllPurchases() {
        return purchaseFacade.getAllPurchase();
    }

}
