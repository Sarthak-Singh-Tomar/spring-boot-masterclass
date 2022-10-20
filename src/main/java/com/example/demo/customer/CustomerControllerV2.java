package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "api/v2/customer")
public class CustomerControllerV2 {

    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "all")
    public List<Customer> getCustomer(){
        return Collections.singletonList(
                new Customer(0L, "v2", "v2password")
        );
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
