package fr.cesi.contractor.Controllers;

import fr.cesi.contractor.Models.Customer;
import fr.cesi.contractor.Models.Quote;
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

    /**
     * Create quote
     *
     * @param customer
     * @return
     */
    @PostMapping("/customer")
    public Customer createCustomer(@Validated @RequestBody Customer customer)
    {
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
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Integer customerId, @Validated @RequestBody Customer customerDetail) throws ResourceNotFoundException
    {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Quote " + customerId + " not found"));

        customer.set_v(customerDetail.get_v());
        customer.setCreated_at(customerDetail.getCreated_at());
        customer.setUpdated_at(new Date());

        final Customer updatedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updatedCustomer);
    }


    /**
     * Delete the selected quote
     *
     * @param customerID
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") Integer customerID)
    {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " + customerID + " not found"));

        customer.setDeleted(true);

        customerRepository.save(customer);
        return ResponseEntity.ok("Customer successfully deleted");
    }
}
