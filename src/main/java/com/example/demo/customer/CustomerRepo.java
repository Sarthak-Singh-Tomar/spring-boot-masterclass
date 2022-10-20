package com.example.demo.customer;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepo {

    public List<Customer> getCustomer();
}
