package fr.cesi.Service;

import fr.cesi.bean.Customer;
import fr.cesi.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "managementCustomer")
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    public List<Customer> selectall() {
        return customerDAO.findAll();
    }

    public Customer selectOne(int id) {
        Optional<Customer> p = customerDAO.findById(id);
        return p.orElse(null);
    }

    public void delete(int id) {
        customerDAO.deleteById(id);
    }

    public void insert(Customer p) {
        customerDAO.save(p);
    }
}