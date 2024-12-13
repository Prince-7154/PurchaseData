package com.example.RegistrationData.repositories.OrmRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.RegistrationData.ORMEntity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface ORMCustomerRepository extends JpaRepository<Customer, Integer> {
}
