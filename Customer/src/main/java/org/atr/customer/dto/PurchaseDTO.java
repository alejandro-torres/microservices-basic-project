package org.atr.customer.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PurchaseDTO {


    @JsonProperty("purchaseId")
    private Integer id;

    @JsonProperty("purchaseName")
    private String name;

    @JsonProperty("purchaseValue")
    private BigDecimal value;

    @JsonProperty("purchaseDate")
    private Date purchaseDate;

}
