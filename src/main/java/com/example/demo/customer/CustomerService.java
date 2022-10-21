package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getCustomers(){
        return customerRepo.getCustomer();
    }

    Customer getCustomer(Long id) {
        return getCustomers().stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("customer not found"));
    }

//    public void saveCustomer(Customer customer) {
//        if(customer.getName()!=null && customer.getPassword()!=null) {
//            System.out.println(customer);
//        }
//        else {
//            throw new IllegalStateException("no name and password given");
//        }
//    }
}
