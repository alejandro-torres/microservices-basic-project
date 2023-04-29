package org.atr.product.DTO;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDTO {

    @JsonProperty("productId")
    private Integer id;

    @JsonProperty("productName")
    private String name;

    @JsonProperty("productValue")
    private BigDecimal value;

}
