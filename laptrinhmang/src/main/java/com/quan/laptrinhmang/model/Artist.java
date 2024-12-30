package com.quan.laptrinhmang.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động sinh giá trị ID
    private Long id; // Thêm trường ID làm khóa chính

    private String name;
    private String dateOfBirth;
    private String hometown;

    @ElementCollection // Đánh dấu danh sách đơn giản lưu trữ trong bảng con
    private List<String> famousSongs;

    private String link;

    // Constructor không tham số (bắt buộc với Hibernate)
    public Artist() {}

    public Artist(String name, String dateOfBirth, String hometown, List<String> famousSongs, String link) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.hometown = hometown;
        this.famousSongs = famousSongs;
        this.link = link;
    }

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public List<String> getFamousSongs() {
        return famousSongs;
    }

    public void setFamousSongs(List<String> famousSongs) {
        this.famousSongs = famousSongs;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
