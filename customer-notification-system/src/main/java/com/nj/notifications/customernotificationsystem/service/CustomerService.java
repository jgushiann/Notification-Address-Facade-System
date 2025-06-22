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

    //returns a list of all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    //returns a customer related to given id
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    //adds customer
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //updates customer
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setPhone(updatedCustomer.getPhone());
            customer.setNotificationPreference(updatedCustomer.getNotificationPreference());
            return customerRepository.save(customer);
        }
        return null;
    }

    //serches customer in the list
    public List<Customer> searchCustomers(String search) {
        if (search == null || search.trim().isEmpty()) {
            return getAllCustomers();
        }
        return customerRepository.find(search);
    }

    //finds customer with its id
    public Customer findByID(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    //deletes customer
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}