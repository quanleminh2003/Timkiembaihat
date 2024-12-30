package com.quan.laptrinhmang;

import org.springframework.beans.factory.annotation.Value;



import org.springframework.context.annotation.Configuration;

@Configuration
public class SpotifyConfig {
    @Value("${spotify.client.id}")
    private String clientId;

    @Value("${spotify.client.secret}")
    private String clientSecret;

    @Value("${spotify.api.base.url}")
    private String apiBaseUrl;

    @Value("${spotify.token.url}")
    private String tokenUrl;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }
}

