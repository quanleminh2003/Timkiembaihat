package com.quan.laptrinhmang.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    private String hometown;

    @Lob
    private String biography;

    @Column(name = "famous_songs")
    private String famousSongs;

    @Column(name = "youtube_link")
    private String youtubeLink;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(
            name = "song_artist",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Set<Song> songs = new HashSet<>();

    // Constructors, Getters, and Setters
    public Artist() {
    }

    public Artist(String name, LocalDate birthDate, String hometown, String biography, String famousSongs, String youtubeLink) {
        this.name = name;
        this.birthDate = birthDate;
        this.hometown = hometown;
        this.biography = biography;
        this.famousSongs = famousSongs;
        this.youtubeLink = youtubeLink;
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
