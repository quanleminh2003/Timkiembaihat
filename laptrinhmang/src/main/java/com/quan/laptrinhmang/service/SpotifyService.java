package com.quan.laptrinhmang.service;

import com.quan.laptrinhmang.SpotifyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SpotifyService {

    @Autowired
    private SpotifyConfig spotifyConfig;

    public Map<String, Object> searchTracksAndArtists(String keyword) {
        RestTemplate restTemplate = new RestTemplate();

        // Lấy access token từ Spotify
        String accessToken = getAccessToken();

        // URL gọi API Spotify
//        String url = "https://api.spotify.com/v1/search?q=" + keyword + "&type=track,artist,album,playlist&limit=10";
// URL gọi API Spotify với nhiều loại tìm kiếm
        String url = "https://api.spotify.com/v1/search?q=" + URLEncoder.encode(keyword, StandardCharsets.UTF_8) + "&type=track,artist,album,playlist&limit=10";

        // Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);

        // Request
        HttpEntity<Void> request = new HttpEntity<>(headers);

        // Gửi request đến Spotify API
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);

        // Trả về kết quả
        return response.getBody();
    }

    private String getAccessToken() {
        RestTemplate restTemplate = new RestTemplate();

        // Header cho API lấy access token
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(spotifyConfig.getClientId(), spotifyConfig.getClientSecret());

        // Body
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        // Request
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);

        // Gửi request lấy token
        ResponseEntity<Map> response = restTemplate.postForEntity(spotifyConfig.getTokenUrl(), request, Map.class);

        // Lấy access token từ response
        return response.getBody().get("access_token").toString();
    }
}
