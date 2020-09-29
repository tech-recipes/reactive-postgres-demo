package com.example.reactivepostgresdemo.repo;


import com.example.reactivepostgresdemo.model.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer,Integer> {

}
