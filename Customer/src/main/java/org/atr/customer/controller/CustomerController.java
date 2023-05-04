package org.atr.customer.controller;

import org.atr.customer.dto.CustomerDTO;

import org.atr.customer.dto.PurchaseDTO;
import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;
import org.atr.customer.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody final CustomerDTO customerDTO){
        Optional<Customer> customer = customerService.createCustomer(customerDTO.getName(), customerDTO.getEmail());
        if (customer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        CustomerDTO response = CustomerDTO.builder()
                .id(customer.get().getId())
                .name(customer.get().getName())
                .email(customer.get().getEmail())
                .build();
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<CustomerDTO> readCustomerById(@PathVariable final Integer id){
        Optional<Customer> customer = customerService.selectCustomerById(id);
        if (customer.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            List<PurchaseDTO> purchaseDTOList = new ArrayList<>();
            Iterator<Purchase> iterator = customer.get().getPurchaseList().iterator();
            while (iterator.hasNext()){
                Purchase purchase = iterator.next();
                PurchaseDTO purchaseDTO = PurchaseDTO.builder()
                        .id(purchase.getId())
                        .name(purchase.getName())
                        .value(purchase.getValue())
                        .purchaseDate(purchase.getPurchaseDate())
                        .build();
                purchaseDTOList.add(purchaseDTO);
            }

            CustomerDTO response = CustomerDTO.builder()
                    .id(customer.get().getId())
                    .name(customer.get().getName())
                    .email(customer.get().getEmail())
                    .purchaseList(purchaseDTOList)
                    .build();
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody final CustomerDTO customerDTO) {

        Optional<Customer> customer = customerService.updateCustomer(customerDTO.getId(), customerDTO.getName(), customerDTO.getEmail());

        if (customer.isEmpty()) {
            Logger logger = Logger.getLogger(this.getClass().getName());
            logger.log(Level.SEVERE, "/update");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {

            List<PurchaseDTO> purchaseDTOList = new ArrayList<>();
            Iterator<Purchase> iterator = customer.get().getPurchaseList().iterator();
            while (iterator.hasNext()) {
                Purchase purchase = iterator.next();
                PurchaseDTO purchaseDTO = PurchaseDTO.builder()
                        .id(purchase.getId())
                        .name(purchase.getName())
                        .value(purchase.getValue())
                        .purchaseDate(purchase.getPurchaseDate())
                        .build();
                purchaseDTOList.add(purchaseDTO);
            }

            CustomerDTO response = CustomerDTO.builder()
                    .id(customer.get().getId())
                    .name(customer.get().getName())
                    .email(customer.get().getEmail())
                    .purchaseList(purchaseDTOList)
                    .build();

            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerDTO> deleteCustomerById(@PathVariable final Integer id){
        boolean result = customerService.deleteCustomerById(id);
        if (result){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
