package com.sweetwaveforms.releaseplanner.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "workManager")
public class WorkManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long assigneeId;

    @Column(name = "status")
    private String status;

    @Column(name = "approved_by")
    private String approvedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "work_type")
    private WorkType workType;

    @Column(name = "assigned_date_time")
    @CreationTimestamp
    private LocalDateTime assignedDateTime;

    @Column(name = "deadline_date_time")
    @CreationTimestamp
    private LocalDateTime deadlineDateTime;

    @Column(name = "approved_date_time")
    @CreationTimestamp
    private LocalDateTime approvedDateTime;




}
