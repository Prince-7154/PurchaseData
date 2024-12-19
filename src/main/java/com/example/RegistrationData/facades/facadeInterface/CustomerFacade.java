package com.example.RegistrationData.facades.facadeInterface;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.ORMEntity.Customer;

import java.util.List;

public interface CustomerFacade {
    public void registerCustomer(CustomerDTO customer);
    public List<CustomerDTO> getAllCustomer();
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Integer id);
}
