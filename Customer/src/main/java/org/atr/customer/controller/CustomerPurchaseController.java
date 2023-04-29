package org.atr.customer.controller;

import org.atr.customer.dto.CustomerDTO;
import org.atr.customer.dto.PurchaseDTO;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customer/purchase")
public class CustomerPurchaseController {

    @GetMapping("/list/all")
    public ResponseEntity<List<PurchaseDTO>> selectAllPurchases(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/list/all/{month}")
    public ResponseEntity<List<PurchaseDTO>> selectAllPurchasesOfMonth(@PathVariable final Integer month){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/list")
    public ResponseEntity<CustomerDTO> selectAllPurchasesOfCustomer(@RequestBody final CustomerDTO customerDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/add")
    public ResponseEntity<PurchaseDTO> addPurchase(PurchaseDTO purchaseDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<PurchaseDTO> deletePurchase(PurchaseDTO purchaseDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
