package com.quan.laptrinhmang.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "songs") // Đặt tên bảng trong cơ sở dữ liệu
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động sinh giá trị ID
    private Long id; // Trường khóa chính

    private String title; // Tên bài hát
    private String artist; // Nghệ sĩ
    private String genre; // Thể loại
    private LocalDate releaseDate; // Ngày phát hành
    private String link; // Đường dẫn bài hát (nếu có)

    // Constructor không tham số (bắt buộc với Hibernate)
    public Song() {}

    // Constructor có tham số
    public Song(String title, String artist, String genre, LocalDate releaseDate, String link) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.link = link;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
