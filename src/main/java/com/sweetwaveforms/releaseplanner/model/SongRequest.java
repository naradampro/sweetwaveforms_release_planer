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
}