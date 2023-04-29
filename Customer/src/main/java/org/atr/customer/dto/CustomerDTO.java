package org.atr.customer.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDTO {

    @JsonProperty("customerId")
    private Integer id;

    @JsonProperty("customerName")
    private String name;

    @JsonProperty("customerEmail")
    private String email;

    @JsonProperty("customerPurchaseList")
    private List<PurchaseDTO> purchaseList;

}
