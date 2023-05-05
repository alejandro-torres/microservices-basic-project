package org.atr.product.controller;

import org.atr.product.DTO.ProductDTO;
import org.atr.product.DTO.ProductListDTO;
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
        Optional<Product> product = productService.selectProductById(id);

        if (product.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ProductDTO response =  ProductDTO.builder()
                .id(product.get().getId())
                .name(product.get().getName())
                .value(product.get().getValue())
                .build();

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<ProductDTO>> readAllProducts(){
        List<Product> productList = productService.selectAllProducts();

        if (productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Iterator<Product> iterator = productList.iterator();
        List<ProductDTO> response =  new ArrayList<>();

        while (iterator.hasNext()){
            Product product = iterator.next();
            ProductDTO productDTO =  ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .value(product.getValue())
                    .build();
            response.add(productDTO);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/read/all")
    public ResponseEntity<ProductListDTO> readAllProductsById(@RequestBody final List<Integer> productIdList){

        List<Product> productList = productService.selectAllProductsById(productIdList);

        if (productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        Iterator<Product> productIterator = productList.iterator();
        List<ProductDTO> productListDTO =  new ArrayList<>();

        while (productIterator.hasNext()){
            Product product = productIterator.next();
            ProductDTO productDTO =  ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .value(product.getValue())
                    .build();
            productListDTO.add(productDTO);
        }

        return new ResponseEntity<>(ProductListDTO.builder().productListDTO(productListDTO).build(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody final ProductDTO productDTO){

        Optional<Product> product = productService.saveProduct(productDTO.getName(), productDTO.getValue());
        if (product.isEmpty()){
            Logger logger = Logger.getLogger(this.getClass().getName());
            logger.log(Level.SEVERE, "createProduct failed");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        ProductDTO response = ProductDTO.builder()
                .id(product.get().getId())
                .name(product.get().getName())
                .value(product.get().getValue())
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody final ProductDTO productDTO){

        Optional<Product> product = productService.updateProduct(productDTO.getId(), productDTO.getName(), productDTO.getValue());
        if (product.isEmpty()){
            Logger logger = Logger.getLogger(this.getClass().getName());
            logger.log(Level.SEVERE, "Product not updated");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ProductDTO response = ProductDTO.builder()
                .id(product.get().getId())
                .name(product.get().getName())
                .value(product.get().getValue())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<ProductDTO> deleteProductById(@PathVariable final Integer id){
        if (productService.deleteProductById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
