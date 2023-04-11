package org.atr.product.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonIgnore(value = true)
public class ProductDTO {

    private Integer id;

    private String name;

    private Integer value;

}
