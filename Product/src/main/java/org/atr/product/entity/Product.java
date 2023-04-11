package org.atr.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

@Entity
@Data
@Accessors
@Table(name = "product")
@NoArgsConstructor(force = true)
public class Product {

    @Id
    @Column(name = "product_id")
    @NonNull
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_value")
    private Integer value;

}
