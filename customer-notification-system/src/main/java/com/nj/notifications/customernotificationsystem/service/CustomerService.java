package com.nj.notifications.customernotificationsystem.service;

import com.nj.notifications.customernotificationsystem.model.Customer;
import com.nj.notifications.customernotificationsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    //gets all the customers from the database
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //gets one specific customer based on its id from the db
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    //adds customer to the db
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //updates one specific customer's info based on its id
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            return customerRepository.save(customer);
        }
        return null;
    }

    //deletes customer from the db
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
