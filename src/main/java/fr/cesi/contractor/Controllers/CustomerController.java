package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * List of customer
     *
     * @return the list
     */
    @GetMapping("/index")
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

}
