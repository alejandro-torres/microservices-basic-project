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
import java.util.List;

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

    @JsonProperty("productIdList")
    private List<Integer> productIdList;

    @JsonProperty("totalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("purchaseDate")
    private Date purchaseDate;

}
