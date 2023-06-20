package org.atr.product.repository;

import org.atr.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name = (:name) ORDER BY p.value DESC")
    List<Product> getProductByNameOrderByValueDesc(@Param("name") String name);

}