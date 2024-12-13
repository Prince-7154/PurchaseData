package com.example.RegistrationData.repositories;

import com.example.RegistrationData.model.Customer;
import com.example.RegistrationData.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    private final JdbcTemplate template;

    public CustomerRepository(JdbcTemplate template){
        this.template = template;
    }

    public void storeCustomer(Customer customer){
        String sql = "INSERT INTO customer(customerName, customerAddress, customerPhone, customerEmail) VALUES (?, ?, ?, ?)";

        template.update(sql, customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerPhone(), customer.getCustomerEmail());
    }

    public List<Customer> getCustomer(Customer customer){
        String sql = "SELECT * FROM customer WHERE customerName = ?";
        RowMapper<Customer> customerRowMapper = (r, i) -> {
            Customer rowObject = new Customer();
            rowObject.setCustomerId(r.getInt("customerId"));
            rowObject.setCustomerName(r.getString("customerName"));
            rowObject.setCustomerAddress(r.getString("customerAddress"));
            rowObject.setCustomerPhone(r.getString("customerPhone"));
            rowObject.setCustomerEmail(r.getString("customerEmail"));
            return rowObject;
        };
        return template.query(sql, new String [] {customer.getCustomerName()}, customerRowMapper);
    }

    public void deleteCustomer(Customer customer){
        String sql = "DELETE FROM customer WHERE customerId = ?";
        template.update(sql, customer.getCustomerId());
    }

    public void updateCustomer(Customer customer){
        String sql = "UPDATE customer SET customerName = ?, customerAddress = ?, customerPhone = ?, customerEmail = ? WHERE id = ? ";
        template.update(sql, customer.getCustomerName(), customer.getCustomerAddress(), customer.getCustomerPhone(), customer.getCustomerEmail(), customer.getCustomerId());
    }
}
