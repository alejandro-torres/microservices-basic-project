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
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OperationDTO {

    @JsonProperty("operationId")
    private Integer id;

    @JsonProperty("operationDescription")
    private String description;

    @JsonProperty("operationTotalAmount")
    private BigDecimal totalAmount;

    @JsonProperty("operationDate")
    private Date date;

}
