package org.atr.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "purchase_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer_id_fk")
    private Customer customer;

    @Column(name = "purchase_name")
    private String name;

    @Column(name = "purchase_value")
    private BigDecimal value;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date purchaseDate;
}