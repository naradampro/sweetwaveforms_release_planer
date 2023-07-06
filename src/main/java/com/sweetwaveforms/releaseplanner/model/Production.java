package com.sweetwaveforms.releaseplanner.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "files")
public class Production {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "liveLink",length = 800)
    private String liveLink;

    @Column(name = "release_id")
    private long releaseId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FileType type;

    @Column(name = "created_date_time")
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    public Production(){

    }

    public Production(Long id, String liveLink,long releaseId , FileType type) {
        this.id = id;
        this.liveLink = liveLink;
        this.releaseId = releaseId;
        this.type = type;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(long releaseId) {
        this.releaseId = releaseId;
    }


    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
}

