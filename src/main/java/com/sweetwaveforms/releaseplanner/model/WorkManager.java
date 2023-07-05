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

    public WorkManager() {

    }

    public WorkManager(String status, String approvedBy, WorkType workType) {
        this.status = status;
        this.approvedBy = approvedBy;
        this.workType = workType;
    }

    public long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(long assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public WorkType getWorkType() {
        return workType;
    }

    public void setWorkType(WorkType workType) {
        this.workType = workType;
    }

    public LocalDateTime getAssignedDateTime() {
        return assignedDateTime;
    }

    public void setAssignedDateTime(LocalDateTime assignedDateTime) {
        this.assignedDateTime = assignedDateTime;
    }

    public LocalDateTime getDeadlineDateTime() {
        return deadlineDateTime;
    }

    public void setDeadlineDateTime(LocalDateTime deadlineDateTime) {
        this.deadlineDateTime = deadlineDateTime;
    }

    public LocalDateTime getApprovedDateTime() {
        return approvedDateTime;
    }

    public void setApprovedDateTime(LocalDateTime approvedDateTime) {
        this.approvedDateTime = approvedDateTime;
    }
}
