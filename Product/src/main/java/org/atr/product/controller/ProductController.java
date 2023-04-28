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

    @GetMapping("/select/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable final Integer id){

        Optional<Product> product;
        ProductDTO productDTO = new ProductDTO();

        try {
            product = productService.selectProductById(id);
            if (product.isEmpty()){
                return new ResponseEntity<>(productDTO,HttpStatus.NO_CONTENT);
            }
            productDTO.setId(product.get().getId());
            productDTO.setName(product.get().getName());
            productDTO.setValue(product.get().getValue());

            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        }catch (Exception e){
            final Logger logger = Logger.getLogger(this.getClass().toString());
            logger.log(Level.SEVERE,this.getClass().toString() + " getProduct() " + HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/select/all")
    public ResponseEntity<List<ProductDTO>> selectAllProducts(){
        List<ProductDTO> productDTOList =  new ArrayList<>();
        Product product;
        try{
            List<Product> productsList = productService.selectAllProducts();
            if (productsList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                Iterator<Product> iterator = productsList.iterator();
                while (iterator.hasNext()){
                    product = iterator.next();

                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setId(product.getId());
                    productDTO.setName(product.getName());
                    productDTO.setValue(product.getValue());
                    productDTOList.add(productDTO);
                }
                return new ResponseEntity<>(productDTOList, HttpStatus.OK);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody final ProductDTO productDTO){
        try {
            Product product = productService.saveProduct(productDTO);
            productDTO.setId(product.getId());

            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        }catch (Exception e){
            final Logger logger = Logger.getLogger(this.getClass().toString());
            logger.log(Level.SEVERE, this.getClass().toString() + " saveProduct() " + HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
