package com.example.RegistrationData.controllers;


import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.ORMEntity.Customer;
import com.example.RegistrationData.facades.facadeInterface.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class ORMCustomerController {
    @Autowired
    private CustomerFacade customerFacade;

    @PostMapping
    public String addCustomer(@RequestBody CustomerDTO customer) {

        customerFacade.registerCustomer(customer);
        return "done";
    }

    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        return customerFacade.getAllCustomer();
    }

}
