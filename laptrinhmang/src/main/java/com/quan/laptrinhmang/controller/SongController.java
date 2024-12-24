package com.quan.laptrinhmang.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class SongController {
    // Tìm kiếm bài hát theo tên
    @GetMapping("/songs")
    public ResponseEntity<?> getSongByName(@RequestParam String name) {
        // Đây là dữ liệu giả lập - thay bằng truy vấn cơ sở dữ liệu hoặc API thực tế
        Map<String, Object> songInfo = Map.of(
                "name", name,
                "composer", "Nhạc sĩ A",
                "lyrics", "Đây là lời bài hát cho bài hát: " + name,
                "audioLink", "https://www.youtube.com/watch?v=dQw4w9WgXcQ"
        );

        // Trả về JSON cho client
        return ResponseEntity.ok(songInfo);
    }
}
