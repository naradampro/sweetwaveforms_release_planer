package com.sweetwaveforms.releaseplanner.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "song_requests")
public class SongRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "youtube_link")
    private String youtubeLink;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SongRequestStatus status = SongRequestStatus.PENDING;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public SongRequest() {

    }

    public SongRequest(String title, String artistName, String youtubeLink) {
        this.title = title;
        this.artistName = artistName;
        this.youtubeLink = youtubeLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public SongRequestStatus getStatus() {
        return status;
    }

    public void setStatus(SongRequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}