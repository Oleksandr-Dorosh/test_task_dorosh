package app.auth;

import app.config.BaseHttpRequest;
import app.dto.auth.AuthDto;

public class Authentication extends BaseHttpRequest {
    private static final String AUTH_URI = "auth";

    public String getToken(AuthDto dto) {
        return getRequestSpecification()
                .body(dto)
                .post(AUTH_URI)
                .jsonPath()
                .getString("token");
    }
}
