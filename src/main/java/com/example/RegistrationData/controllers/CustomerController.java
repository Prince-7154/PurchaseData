package com.example.RegistrationData.controllers;

import com.example.RegistrationData.model.Customer;
import com.example.RegistrationData.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer) {
        customerRepository.storeCustomer(customer);
    }

    @PostMapping("/deleteCustomer")
    public void deleteCustomer(@RequestBody Customer customer) {
        customerRepository.deleteCustomer(customer);
    }

    @PostMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        customerRepository.storeCustomer(customer);
    }
}
