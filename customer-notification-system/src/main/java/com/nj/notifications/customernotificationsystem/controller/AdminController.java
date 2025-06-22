package com.nj.notifications.customernotificationsystem.controller;

import com.nj.notifications.customernotificationsystem.model.Admin;
import com.nj.notifications.customernotificationsystem.model.Customer;
import com.nj.notifications.customernotificationsystem.service.AdminService;
import com.nj.notifications.customernotificationsystem.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    PasswordEncoder passwordEncoder;

    //displays the admin dashboard page after successful login
    @GetMapping("/dashboard")
    public String dashboard(){
        return "admin/dashboard";
    }

    //shows the admin registration form
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("admin", new Admin());
        return "admin/register";
    }

    //handles form submission for registering a new admin
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "invalid input data");
            return "admin/register";
        }
        try {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin.setActive(true);
            if (admin.getRole() == null) admin.setRole(Admin.Role.ADMIN);
            adminService.registerAdmin(admin);
            redirectAttributes.addFlashAttribute("message", "Admin registered successfully");
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Registration failed: " + e.getMessage());
            return "redirect:/admin/register";
        }
    }

    //shows the user registration form
    @GetMapping("/registerUser")
    public String registerUserForm(Model model){
        model.addAttribute("admin", new Admin());
        return "admin/registerUser";
    }

    //handles form submission for regstering a new user
    @PostMapping("/registerUser")
    public String registerUserByAdmin(@Valid @ModelAttribute("admin") Admin admin, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "invalid input data");
            return "admin/registerUser";
        }
        try {
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            admin.setActive(true);
            if (admin.getRole() == null) admin.setRole(Admin.Role.USER);
            adminService.registerAdmin(admin);
            redirectAttributes.addFlashAttribute("message", "User registered successfully");
            return "redirect:/admin/dashboard";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Registration failed: " + e.getMessage());
            return "redirect:/admin/registerUser";
        }
    }

    //displays the customer list
    @GetMapping("/customerList")
    public String customerList(@RequestParam(value = "search", required = false) String search, Model model) {
        if (search != null && !search.trim().isEmpty()) {
            model.addAttribute("customers", customerService.searchCustomers(search));
        }else{
            model.addAttribute("customers", customerService.getAllCustomers());
        }
        return "admin/customerList";
    }

    //loads the edit form for a specific customer serached by its id
    @GetMapping("/customerEdit/{id}")
    public String editCustomer(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Customer customer = customerService.findByID(id);
            if(customer == null) throw new Exception("Customer not found");
            model.addAttribute("customer", customer);
            return "admin/customerEdit";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/admin/customerList";
        }
    }

    //handles form submission for updating an existing customer
    @PostMapping("/customerEdit")
    public String updateCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("error", "invalid customer data");
            return "admin/customerEdit";
        }
        try {
            customerService.updateCustomer(customer.getId(), customer);
            redirectAttributes.addFlashAttribute("message", "Customer updated successfully");
            return "redirect:/admin/customerList";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Update failed: " + e.getMessage());
            return "redirect:/admin/customerEdit/" + customer.getId();
        }
    }

    //deletes a customer by ID and redirects back to the list
    @PostMapping("/customerDelete/{id}")
    public String deleteCustomer(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            customerService.deleteCustomer(id);
            redirectAttributes.addFlashAttribute("message", "Customer deleted successfully");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Deletion failed: " + e.getMessage());
        }
        return "redirect:/admin/customerList";
    }
}