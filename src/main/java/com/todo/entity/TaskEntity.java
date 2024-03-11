package com.todo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "task", schema = "todo")
public class TaskEntity {
    @Id
    private String id;
    private boolean active;
    private String name;
    private String status;
    private String categoryCode;
    private String userId;
    private String imageId;
    private String reminderDateTime;
    private String repeatTask;
    private String note;
    private String dueDate;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private boolean isImportant;

    public TaskEntity() {
    }

    public TaskEntity(String id,
                      boolean active,
                      String name,
                      String status,
                      String categoryCode,
                      String userId,
                      String imageId,
                      String reminderDateTime,
                      String repeatTask,
                      String note,
                      String dueDate,
                      LocalDateTime createdOn,
                      LocalDateTime modifiedOn,
                      boolean isImportant) {
        this.id = id;
        this.active = active;
        this.name = name;
        this.status = status;
        this.categoryCode = categoryCode;
        this.userId = userId;
        this.imageId = imageId;
        this.reminderDateTime = reminderDateTime;
        this.repeatTask = repeatTask;
        this.note = note;
        this.dueDate = dueDate;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
        this.isImportant = isImportant;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(String reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public String getRepeatTask() {
        return repeatTask;
    }

    public void setRepeatTask(String repeatTask) {
        this.repeatTask = repeatTask;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(LocalDateTime modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        isImportant = important;
    }
}
