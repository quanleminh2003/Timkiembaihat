//package com.quan.laptrinhmang.controller;
//
//import com.quan.laptrinhmang.service.SpotifyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Map;
//@Controller
//public class SearchController {
//
//    @Autowired
//    private SpotifyService spotifyService;
//
//    @GetMapping("/search")
//    public String search(@RequestParam("keyword") String keyword, Model model) {
//        // Gọi API Spotify để tìm kiếm bài hát và nghệ sĩ
//        Map<String, Object> searchResults = spotifyService.searchTracksAndArtists(keyword);
//
//        // Lấy danh sách bài hát và nghệ sĩ từ kết quả
//        List<Map<String, Object>> songs = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("tracks")).get("items");
//        List<Map<String, Object>> artists = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("artists")).get("items");
//
//        // Thêm dữ liệu vào model để hiển thị trên giao diện
//        model.addAttribute("songs", songs);
//        model.addAttribute("artists", artists);
//
//        return "search";
//    }
//}

//package com.quan.laptrinhmang.controller;
//
//import com.quan.laptrinhmang.service.SpotifyService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class SearchController {
//
//    @Autowired
//    private SpotifyService spotifyService;
//
//    @GetMapping("/search")
//    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
//        // Kiểm tra nếu không có keyword, tìm kiếm mặc định (ví dụ: tìm tất cả bài hát)
//        if (keyword == null || keyword.isEmpty()) {
//            keyword = "music";  // Từ khóa mặc định nếu không có keyword
//        }
//
//        // Gọi API Spotify để tìm kiếm bài hát và nghệ sĩ với từ khóa đã cho
//        Map<String, Object> searchResults = spotifyService.searchTracksAndArtists(keyword);
//
//        // Lấy danh sách bài hát và nghệ sĩ từ kết quả
//        List<Map<String, Object>> songs = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("tracks")).get("items");
//        List<Map<String, Object>> artists = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("artists")).get("items");
//
//        // Thêm dữ liệu vào model để hiển thị trên giao diện
//        model.addAttribute("songs", songs);
//        model.addAttribute("artists", artists);
//
//        return "search";  // Trả về tên view 'search' để hiển thị kết quả
//    }
//}
//
package com.quan.laptrinhmang.controller;

import com.quan.laptrinhmang.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class SearchController {

    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/search")
    public String search(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        // Kiểm tra nếu không có keyword, tìm kiếm mặc định (ví dụ: tìm tất cả bài hát)
        if (keyword == null || keyword.trim().isEmpty()) {
            keyword = "default"; // Gán giá trị mặc định nếu keyword bị null hoặc rỗng
        }

        // Gọi API Spotify để tìm kiếm bài hát và nghệ sĩ với từ khóa đã cho
        Map<String, Object> searchResults = spotifyService.searchTracksAndArtists(keyword);

        // Lấy danh sách bài hát và nghệ sĩ từ kết quả
        List<Map<String, Object>> songs = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("tracks")).get("items");
        List<Map<String, Object>> artists = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("artists")).get("items");
//        List<Map<String, Object>> albums = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("albums")).get("items");
//        List<Map<String, Object>> playlists = (List<Map<String, Object>>) ((Map<String, Object>) searchResults.get("playlists")).get("items");
        // Thêm dữ liệu vào model để hiển thị trên giao diện
        model.addAttribute("songs", songs);
        model.addAttribute("artists", artists);
//        model.addAttribute("albums", albums);
//        model.addAttribute("playlists", playlists);
        return "search";  // Trả về tên view 'search' để hiển thị kết quả
    }
}
