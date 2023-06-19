package org.atr.product.repository;

import org.atr.product.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest(
        properties = {
                "spring.jpa.properties.javax.persistence.validation.mode=none"
        }
)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;


    @Test
    void itShouldSaveNewProduct() {
        //Given
        BigDecimal value = BigDecimal.valueOf(23);
        String name = "ExorcismoPremium";

        Product product = Product.builder()
                .name(name)
                .value(value)
                .build();

        //When
        underTest.save(product);

        //Then
        Optional<Product> optionalProduct = underTest.findById(product.getId());
        assertThat(optionalProduct)
                .isPresent()
                .hasValueSatisfying(p -> {
                   assertThat(p).isEqualTo(product);
                });
    }
}