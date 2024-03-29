package org.atr.product.service.impl;


import org.atr.product.entity.Product;
import org.atr.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.atr.product.service.ProductService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public List<Product> selectAllProductsById(List<Integer> productIdList) {
        List<Product> infoProductList = productRepository.findAllById(productIdList);
        List<Product> response = new ArrayList<>();

        for (Integer productId: productIdList) {
            response.add(infoProductList.stream()
                            .filter(productInfo -> productInfo.getId() == productId)
                            .findFirst()
                            .orElse(null));
        }

        return response;
    }

    @Override
    public boolean deleteProductById(Integer id) {
        try{
            productRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.SEVERE, e.getMessage());
            return false;
        }
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
