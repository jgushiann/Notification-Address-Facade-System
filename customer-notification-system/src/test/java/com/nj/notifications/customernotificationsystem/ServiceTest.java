package com.nj.notifications.customernotificationsystem;

import com.nj.notifications.customernotificationsystem.model.Customer;
import com.nj.notifications.customernotificationsystem.repository.CustomerRepository;
import com.nj.notifications.customernotificationsystem.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;
    private Customer updatedCustomer;

    //setting up samples of customers needed for tests
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setId(1L);
        customer.setName("Nini Jgushia");
        customer.setEmail("nini@example.com");
        customer.setPhone("123456789");
        customer.setNotificationPreference("EMAIL");

        updatedCustomer = new Customer();
        updatedCustomer.setName("Nini Jgushia");
        updatedCustomer.setEmail("nini@example.com");
        updatedCustomer.setPhone("123456789");
        updatedCustomer.setNotificationPreference("SMS");
    }

    //tests that getting all customers works correctly
    @Test
    void returnAllCustomersTest() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        assertEquals(1, customerService.getAllCustomers().size());
        assertEquals("Nini Jgushia", customerService.getAllCustomers().get(0).getName());
    }

    //tests that adding a new customer calls the save method once
    @Test
    void addCustomerTest() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        customerService.addCustomer(customer);
        verify(customerRepository, times(1)).save(customer);
    }

    //tests that getting a customer by its id returns the correct customer
    @Test
    void getCustomerByIdTest() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        Customer found = customerService.getCustomerById(1L);
        assertNotNull(found);
        assertEquals("EMAIL", found.getNotificationPreference());
    }
}