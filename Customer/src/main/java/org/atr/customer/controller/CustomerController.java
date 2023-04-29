package org.atr.customer.controller;

import org.atr.customer.dto.CustomerDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody final CustomerDTO customerDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> readCustomerById(@PathVariable final Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody final CustomerDTO customerDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomerById(@PathVariable final Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }



}
