package com.example.RegistrationData.Services;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Customer;
import com.example.RegistrationData.repositories.OrmRepositories.ORMCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private ORMCustomerRepository customerRepository;
    public CustomerDTO createCustomerWithPurchases(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        // Map Purchases to DTO
        List<PurchaseDTO> purchaseDTOs = savedCustomer.getPurchases().stream()
                .map(purchase -> new PurchaseDTO(
                        purchase.getPurchaseId(),
                        purchase.getProductName(),
                        purchase.getPrice(),
                        purchase.getQuantity(),
                        savedCustomer.getCustomerId()
                ))
                .toList();

        // Create and return CustomerDTO
        return new CustomerDTO(
                savedCustomer.getCustomerId(),
                savedCustomer.getCustomerName(),
                savedCustomer.getCustomerAddress(),
                savedCustomer.getCustomerPhone(),
                savedCustomer.getCustomerEmail(),
                purchaseDTOs
        );
    }


    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

}
