package org.atr.product.service.impl;


import org.atr.product.entity.Product;
import org.atr.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.atr.product.service.ProductService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> saveProduct(String name, BigDecimal value) {

        Product product = Product.builder()
                .name(name)
                .value(value)
                .build();

        return Optional.of(productRepository.save(product));
    }

    @Override
    public Optional<Product> selectProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> selectAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return null;
    }

    @Override
    public Optional<Product> updateProduct(Integer id, String name, BigDecimal value) {
        Product product =  Product.builder()
                .id(id)
                .name(name)
                .value(value)
                .build();

        if (productRepository.findById(id).isEmpty()){
            return Optional.empty();
        }

        return Optional.of(productRepository.save(product));
    }
}
