package org.atr.product.service.impl;

import org.atr.product.DTO.ProductDTO;
import org.atr.product.entity.Product;
import org.atr.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.atr.product.service.ProductService;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;



    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setValue(productDTO.getValue());
        product = productRepository.save(product);
        return product;
    }

    @Override
    public Optional<Product> selectProductById(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        return null;
    }

    @Override
    public Optional<Product> updateProduct(ProductDTO productDTO) {
        if (productRepository.findById(productDTO.getId()).isEmpty()){
            return Optional.empty();
        }else{
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setValue(productDTO.getValue());
            return Optional.of(productRepository.save(product));
        }
    }
}
