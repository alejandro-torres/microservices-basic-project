package org.atr.product.service.impl;

import org.atr.product.DTO.ProductDTO;
import org.atr.product.entity.Product;
import org.atr.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.atr.product.service.ProductService;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public Optional<Product> saveProduct(String name, BigDecimal value, Date purchaseDate) {
        return Optional.empty();
    }

    @Override
    public Optional<Product> selectProductById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Product> selectAllProducts() {
        return null;
    }

    @Override
    public Boolean deleteProductById(Integer id) {
        return null;
    }

    @Override
    public Optional<Product> updateProduct(Integer id, String name, BigDecimal value, Date purchaseDate) {
        return Optional.empty();
    }
}
