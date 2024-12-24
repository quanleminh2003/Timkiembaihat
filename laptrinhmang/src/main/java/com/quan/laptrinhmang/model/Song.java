package com.quan.laptrinhmang.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String composer;

    @Lob
    private String lyrics;

    @Column(name = "audio_link")
    private String audioLink;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany(mappedBy = "songs")
    private Set<Artist> artists = new HashSet<>();

    // Constructors, Getters, and Setters
    public Song() {
    }

    public Song(String name, String composer, String lyrics, String audioLink) {
        this.name = name;
        this.composer = composer;
        this.lyrics = lyrics;
        this.audioLink = audioLink;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Other Getters and Setters
}
