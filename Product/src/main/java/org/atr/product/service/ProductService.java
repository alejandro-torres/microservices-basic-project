package org.atr.product.service;

import org.atr.product.DTO.ProductDTO;
import org.atr.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(ProductDTO product);
    Optional<Product> selectProductById(Integer id);

    List<Product> selectAllProducts();
    Boolean deleteProductById(Integer id);
    Product updateProductById(Integer id);

}
