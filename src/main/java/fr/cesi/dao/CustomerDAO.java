package fr.cesi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.cesi.bean.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {
}



