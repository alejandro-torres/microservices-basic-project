package org.atr.customer.controller;

import org.atr.customer.dto.PurchaseDTO;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer/purchase")
public class CustomerPurchaseController {

    @GetMapping("/all")
    public ResponseEntity<List<PurchaseDTO>> selectAllPurchases(){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{month}")
    public ResponseEntity<List<PurchaseDTO>> selectAllPurchasesOfMonth(@PathVariable final Integer month){
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
