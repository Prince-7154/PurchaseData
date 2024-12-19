package com.example.RegistrationData.Services.serviceImplementation;

import com.example.RegistrationData.DTO.CustomerDTO;
import com.example.RegistrationData.DTO.PurchaseDTO;
import com.example.RegistrationData.ORMEntity.Customer;
import com.example.RegistrationData.ORMEntity.Purchase;
import com.example.RegistrationData.repositories.OrmRepositories.ORMCustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements com.example.RegistrationData.Services.serviceInterface.CustomerService {
    @Autowired
    private ORMCustomerRepository customerRepository;


    @Autowired
    private ModelMapper modelMapper;

    public void  createCustomerWithPurchase(CustomerDTO customerDTO) {
//        Customer c = new Customer();
//        c.setCustomerId(customer.getCustomerId());
//        c.setCustomerName(customer.getCustomerName());
//        c.setCustomerAddress(customer.getCustomerAddress());
//        c.setCustomerPhone(customer.getCustomerPhone());
//        c.setCustomerEmail(customer.getCustomerEmail());
        // Map CustomerDTO to Customer entity
        Customer customer = modelMapper.map(customerDTO, Customer.class);

        customer.getPurchases().stream().forEach(p -> p.setCustomer(customer));

//

        customerRepository.save(customer);
    }


    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customerList) {
            // Map Purchases to DTO
            List<PurchaseDTO> purchaseDTOs = customer.getPurchases().stream()
                    .map(purchase -> new PurchaseDTO(
                            purchase.getPurchaseId(),
                            purchase.getProductName(),
                            purchase.getPrice(),
                            purchase.getQuantity(),
                            customer.getCustomerId()
                    ))
                    .toList();

            // Create and return CustomerDTO
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerPhone(),
                    customer.getCustomerEmail(),
                    purchaseDTOs);

            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
//
//    public Optional<Customer> getCustomerById(Integer id) {
//        return customerRepository.findById(id);
//    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
