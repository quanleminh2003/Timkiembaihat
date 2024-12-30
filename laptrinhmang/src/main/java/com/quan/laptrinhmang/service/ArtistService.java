package com.quan.laptrinhmang.service;

import com.quan.laptrinhmang.model.Artist;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ArtistService {

    // Dữ liệu giả lập danh sách ca sĩ
    private static final List<Artist> ARTISTS = new ArrayList<>();

    static {
        ARTISTS.add(new Artist("Adele", "05/05/1988", "London, UK", Arrays.asList("Hello", "Someone Like You", "Rolling in the Deep"), "https://example.com/adele"));
        ARTISTS.add(new Artist("Ed Sheeran", "17/02/1991", "Halifax, UK", Arrays.asList("Shape of You", "Perfect", "Thinking Out Loud"), "https://example.com/ed-sheeran"));
    }

    // Tìm kiếm ca sĩ theo từ khóa
    public List<Artist> searchArtistsByKeyword(String keyword) {
        List<Artist> results = new ArrayList<>();
        for (Artist artist : ARTISTS) {
            if (artist.getName().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(artist);
            }
        }
        return results;
    }
}

