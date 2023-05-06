package org.atr.user.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.math.BigDecimal;

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {

    @JsonProperty("userId")
    private Integer id;

    @JsonProperty("userName")
    private BigDecimal name;

    @JsonProperty("userEmail")
    private String email;

    @JsonProperty("userPassword")
    private char[] password;
}
