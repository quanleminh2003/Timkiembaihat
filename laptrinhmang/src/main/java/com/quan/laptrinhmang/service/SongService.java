package com.quan.laptrinhmang.service;

import com.quan.laptrinhmang.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService {

    // Dữ liệu giả lập danh sách bài hát
    private static final List<Song> SONGS = new ArrayList<>();

    static {

    }

    // Tìm kiếm bài hát theo từ khóa
    public List<Song> searchSongsByKeyword(String keyword) {
        List<Song> results = new ArrayList<>();
        for (Song song : SONGS) {
            if (song.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    song.getArtist().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(song);
            }
        }
        return results;
    }
}

