package entity;

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
@Table(name = "Product")
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "id")
    @NonNull
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private Integer value;

}
