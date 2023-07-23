package org.klozevitz.test_menu.config.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    //окен предназначен для входа
    @JsonProperty("access_token")
    private String accessToken;
    //Этот токен используем для смены токена для входа
    @JsonProperty("refresh_token")
    private String refreshToken;
}
