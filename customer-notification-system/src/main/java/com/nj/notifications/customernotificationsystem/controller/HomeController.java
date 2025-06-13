package com.nj.notifications.customernotificationsystem.controller;

import com.nj.notifications.customernotificationsystem.model.Customer;
import com.nj.notifications.customernotificationsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @Autowired
    private CustomerService customerService;

    //redirects root url to the login page
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    //shows the main homepage
    @GetMapping("/home")
    public String home() {
        return "homepage";
    }

    //shows the logged in in admin's dashboard page
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    //shows the list of all customers on the page
    @GetMapping("/home/customers")
    public String viewCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers/list";
    }

    //shows the form to add a new customer on the page
    @GetMapping("/customers/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/add";
    }

    //handles form submission for adding a customer
    @PostMapping("/customers/add")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/home/customers";
    }

    //shows the form to edit an existing customer ont he page
    @GetMapping("/customers/edit")
    public String editCustomer(@RequestParam("id") Long customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customers/edit";
        }
        return "redirect:/home/customers?error=CustomerNotFound";
    }

    //handles form submission for updating an existing customer
    @PostMapping("/customers/edit")
    public String updateCustomer(@ModelAttribute Customer customer) {
        customerService.updateCustomer(customer.getId(), customer);
        return "redirect:/home/customers";
    }
}