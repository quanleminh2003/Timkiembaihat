//package com.quan.laptrinhmang.controller;
//
//import com.quan.laptrinhmang.model.Song;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.ResponseEntity;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/spotify")
//public class SpotifyController {
//
//    @Autowired
//    private SpotifyAuthService spotifyAuthService;
//
//    @Autowired
//    private SpotifySearchService spotifySearchService;
//
//    @GetMapping("/access-token")
//    public String getAccessToken() {
//        try {
//            return spotifyAuthService.getAccessToken();
//        } catch (Exception e) {
//            return "Error: " + e.getMessage(); // Thông báo lỗi nếu không lấy được access token
//        }
//    }
//
//    @GetMapping("/search")
//    public ResponseEntity<List<Song>> search(@RequestParam String query) {
//        try {
//            // Lấy access token
//            String accessToken = spotifyAuthService.getAccessToken();
//            // Tìm kiếm bài hát từ Spotify
//            List<Song> songs = spotifySearchService.searchTracks(accessToken, query);
//            if (songs.isEmpty()) {
//                return ResponseEntity.noContent().build();  // Trả về mã 204 nếu không tìm thấy bài hát
//            }
//            return ResponseEntity.ok(songs);  // Trả về danh sách bài hát nếu tìm thấy
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(null);  // Trả về mã 500 nếu có lỗi
//        }
//    }
//}
