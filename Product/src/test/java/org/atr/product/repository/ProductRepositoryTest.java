package org.atr.product.repository;

import org.atr.product.entity.Product;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
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

    static List<Product> unorderedProductList;
    static List<Product> orderedAndFilteredProductList;



    @BeforeAll
    static void setUp(){
        unorderedProductList = Arrays.asList(
                Product.builder().name("SaltSplash").value(BigDecimal.valueOf(2)).build(),
                Product.builder().name("SaltSplash").value(BigDecimal.valueOf(3)).build(),
                Product.builder().name("SaltSplash").value(BigDecimal.valueOf(-2)).build(),
                Product.builder().name("SaltSplash").value(BigDecimal.valueOf(7)).build(),
                Product.builder().name("SaltSplash").value(BigDecimal.valueOf(500)).build(),
                Product.builder().name("Salt").value(BigDecimal.valueOf(23)).build()
        );
        orderedAndFilteredProductList = Arrays.asList(
                Product.builder().id(6).name("SaltSplash").value(BigDecimal.valueOf(500)).build(),
                Product.builder().id(5).name("SaltSplash").value(BigDecimal.valueOf(7)).build(),
                Product.builder().id(3).name("SaltSplash").value(BigDecimal.valueOf(3)).build(),
                Product.builder().id(2).name("SaltSplash").value(BigDecimal.valueOf(2)).build(),
                Product.builder().id(4).name("SaltSplash").value(BigDecimal.valueOf(-2)).build()
        );
    }

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
        Product productSaved = underTest.save(product);

        //Then
        Optional<Product> optionalProduct = underTest.findById(product.getId());
        assertThat(optionalProduct)
                .isPresent()
                .hasValueSatisfying(p -> {
                    //assertThat(p).isEqualTo(product);
                    assertThat(p.getId()).isEqualTo(product.getId());
                    assertThat(p.getName()).isEqualTo(product.getName());
                    assertThat(p.getValue()).isEqualTo(product.getValue());
                });
    }

    @Test
    void itShouldGetProductByNameOrderByValueDesc() {
        // Given a product name
        String name = "SaltSplash";

        // ... a list of Products
        underTest.saveAll(unorderedProductList);

        //When
        List<Product> productList = underTest.getProductByNameOrderByValueDesc(name);

        //Then
        assertThat(productList).isEqualTo(orderedAndFilteredProductList);
    }


}