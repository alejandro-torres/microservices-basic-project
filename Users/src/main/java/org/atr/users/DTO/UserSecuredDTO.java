package org.atr.users.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserSecuredDTO {

    @JsonProperty("userName")
    private String name;

    @JsonProperty("userEmail")
    private String email;

    @JsonProperty("userPassword")
    private String password;

    @JsonProperty("userDNI")
    private String dni;

}
