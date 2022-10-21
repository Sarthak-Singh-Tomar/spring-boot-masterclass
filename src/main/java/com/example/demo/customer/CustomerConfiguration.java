package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class    CustomerConfiguration {

    @Value("${app.useCustomerFakeRepo:false}")
    private Boolean useCustomerFakeRepo;

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            System.out.println("Instantiated the config");
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useCustomerFakeRepo : " + useCustomerFakeRepo);
        return useCustomerFakeRepo? new CustomerFakeRepository(): new CustomerRepository();
    }
}
