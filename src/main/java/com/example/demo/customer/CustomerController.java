package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/customer")
@Deprecated
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping
    void createCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST..");
        System.out.println(customer);
    }

    @PutMapping("{customerId}")
    void updateCustomer(@PathVariable("customerId") Long id) {
        System.out.println("UPDATE REQUEST FOR CUSTOMER ID: " + id);
    }

    @DeleteMapping("{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER ID: " + id);
    }
}
