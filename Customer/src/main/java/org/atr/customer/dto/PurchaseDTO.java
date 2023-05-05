package org.atr.customer.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PurchaseDTO {


    @JsonProperty("purchaseId")
    private Integer id;

    @JsonProperty("customerId")
    private Integer customerId;

    @JsonProperty("purchaseName")
    private String name;

    @JsonProperty("purchaseValue")
    private BigDecimal value;

    @JsonProperty("purchaseDate")
    private Date purchaseDate;

}
