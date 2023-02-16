package service;

import entity.Product;

public interface ProductService {

    Product saveProduct(Product product);
    Product selectProductById(Integer id);
    Boolean deleteProductById(Integer id);
    Product updateProductById(Integer id);

}
