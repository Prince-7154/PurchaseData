package com.example.RegistrationData.facades.facadesImplementation;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.ORMEntity.Customer;
import com.example.RegistrationData.Services.serviceInterface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerFacade implements com.example.RegistrationData.facades.facadeInterface.CustomerFacade {
    @Autowired
    private CustomerService customerService;



    @Override
    public void registerCustomer(CustomerDTO customer) {
        customerService.createCustomerWithPurchase(customer);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return customerService.getAllCustomers();
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerService.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }
}
