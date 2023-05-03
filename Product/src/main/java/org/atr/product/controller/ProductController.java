package org.atr.product.controller;

import org.atr.product.DTO.ProductDTO;
import org.atr.product.entity.Product;
import org.atr.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/read/{id}")
    public ResponseEntity<ProductDTO> readProduct(@PathVariable final Integer id){
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<ProductDTO>> readAllProducts(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody final ProductDTO productDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody final ProductDTO productDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable final Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    

}
