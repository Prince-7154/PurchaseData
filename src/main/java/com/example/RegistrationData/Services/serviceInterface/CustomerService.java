package com.example.RegistrationData.Services.serviceInterface;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.ORMEntity.Customer;

import java.util.List;

public interface CustomerService {
    public void createCustomerWithPurchase(CustomerDTO customer);
    public List<CustomerDTO> getAllCustomers();
    public void deleteCustomer(Integer id);
    public void updateCustomer(Customer customer);

}
