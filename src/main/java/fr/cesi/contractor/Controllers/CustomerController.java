package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.LoadDatabase;
import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Quote;
import fr.cesi.contractor.Repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class CustomerController {
    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * List of customer
     *
     * @return the list
     */
    @GetMapping("/customers")
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    /**
     * Create quote
     *
     * @param customer
     * @return
     */
    @PostMapping("/customer/create/")
    public Customer createCustomer(@Validated @RequestBody Customer customer)
    {
        customer.setCreated_at(new Date());
        customer.setUpdated_at(new Date());
        return customerRepository.save(customer);
    }

    /**
     * Update 1 customer
     *
     * @param customerId
     * @param customerDetail
     * @return
     * @throws ResourceNotFoundException
     */
    @PutMapping("/customer/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer customerId, @Validated @RequestBody Customer customerDetail) throws ResourceNotFoundException
    {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerId + " not found"));

        if (customerDetail.get_v() != null) {
            customer.set_v(customerDetail.get_v());
        }

        if (customerDetail.getNom() != null) {
            customer.setNom(customerDetail.getNom());
        }
        if (customerDetail.getFirstName() != null) {
            customer.setFirstName(customerDetail.getFirstName());
        }
        if (customerDetail.getEmail() != null) {
            customer.setEmail(customerDetail.getEmail());
        }
        if (customerDetail.getPhoneNumber() != null) {
            customer.setPhoneNumber(customerDetail.getPhoneNumber());
        }
        if (customerDetail.getSexe() != null) {
            customer.setSexe(customerDetail.getSexe());
        }
        if (customerDetail.getAddress() != null) {
            customer.setAddress(customerDetail.getAddress());
        }
        if (customerDetail.getPostCode() != null) {
            customer.setPostCode(customerDetail.getPostCode());
        }
        if (customerDetail.getCity() != null) {
            customer.setCity(customerDetail.getCity());
        }
        if (customerDetail.getTypeCustomer() != null) {
            customer.setTypeCustomer(customerDetail.getTypeCustomer());
        }
        if (customerDetail.getDeleted() != null) {
            customer.setDeleted(customerDetail.getDeleted());
        }
        log.error("LOG ERROR "+customer.toString());
        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }


    /**
     * Delete the selected quote
     *
     * @param customerID
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Integer customerID)
    {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerID + " not found"));

        customer.setDeleted(true);

        customerRepository.save(customer);
        return ResponseEntity.ok("Customer successfully deleted");
    }
}
