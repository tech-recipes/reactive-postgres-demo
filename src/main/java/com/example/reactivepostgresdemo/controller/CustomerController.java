package com.example.reactivepostgresdemo.controller;

import com.example.reactivepostgresdemo.model.Customer;
import com.example.reactivepostgresdemo.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@RestController
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    CustomerRepository repository;

    @GetMapping
    public Flux<Customer> getCustomers(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Customer> getCustomer(@PathVariable Integer id){
        return repository.findById(id);
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
       return  repository.save(customer);
    }

//    @PostMapping("/upload")
//    public Mono<Void> uploadFile(@RequestPart("files")Flux<FilePart> filePartFlux){
//         return filePartFlux.flatMap( it -> {
//                    try {
//                       return   it.transferTo(Files.createFile(Paths.get("tmp/"+ it.filename())));
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                });
//
//    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id){
        return repository.findById(id)
                        .map((c) -> {
                            c.setName(customer.getName());
                            return c;
                        }).flatMap( c -> repository.save(c));

    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Integer id){
        return repository.deleteById(id);
    }
}
