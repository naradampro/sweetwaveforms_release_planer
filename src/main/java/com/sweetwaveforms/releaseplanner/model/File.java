package com.sweetwaveforms.releaseplanner.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cloud_store_link",length = 800)
    private String cloudStoreLink;

    @Column(name = "creator_id")
    private long creatorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private FileType type;

    @Column(name = "created_date_time")
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    public File(){

    }

    public File(String name, String cloudStoreLink, long creatorId, FileType type) {
        this.name = name;
        this.cloudStoreLink = cloudStoreLink;
        this.creatorId = creatorId;
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

    public String getCloudStoreLink() {
        return cloudStoreLink;
    }

    public void setCloudStoreLink(String cloudStoreLink) {
        this.cloudStoreLink = cloudStoreLink;
    }

    public long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(long creatorId) {
        this.creatorId = creatorId;
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
