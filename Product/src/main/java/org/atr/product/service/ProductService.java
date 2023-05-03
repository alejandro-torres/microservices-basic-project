package org.atr.product.service;

import org.atr.product.DTO.ProductDTO;
import org.atr.product.entity.Product;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> saveProduct(String name, BigDecimal value, Date purchaseDate);
    Optional<Product> selectProductById(Integer id);

    List<Product> selectAllProducts();
    Boolean deleteProductById(Integer id);

    Optional<Product> updateProduct(Integer id ,String name, BigDecimal value, Date purchaseDate);

}
