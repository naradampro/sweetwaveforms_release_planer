package com.sweetwaveforms.releaseplanner.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "production")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "liveLink",length = 800)
    private String liveLink;

    @Column(name = "release_id")
    private long releaseId;

    @Column(name = "created_date_time")
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    public Production(){

    }

    public Production(Long id, String liveLink,long releaseId, LocalDateTime createdDateTime) {
        this.id = id;
        this.liveLink = liveLink;
        this.releaseId = releaseId;
        this.createdDateTime = createdDateTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getliveLink() {
        return liveLink;
    }

    public void setliveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }

    public LocalDateTime getCreatedDateTime() { return createdDateTime; }

    public void setCreatedDateTime(LocalDateTime createdDateTime) { this.createdDateTime = createdDateTime; }
}

