package com.auto.task.out.persistence.task;


import com.auto.task.domain.task.entities.Task;
import jakarta.persistence.*;


import java.time.Instant;
@Entity(name = "Task")
@Table(name = "tasks")
public class TaskJpaEntity {

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "description", length = 4000, nullable = true)
    private String description;

    @Column(name = "done", nullable = false)
    private boolean done;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public TaskJpaEntity(){}
    private TaskJpaEntity(
            final String id,
            final String name,
            final String description,
            final boolean done,
            final Instant createdAt,
            final Instant updatedAt
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.done = done;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static TaskJpaEntity from (final Task task) {
        return  new TaskJpaEntity(
                task.getId(),
                task.getName(),
                task.getDescription(),
                task.getDone(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }

    public Task domainTask() {
        return new Task.Builder()
                .withId(getId())
                .withName(getName())
                .withDescription(getDescription())
                .withDone(isDone())
                .withCreatedAt(getCreatedAt())
                .withUpdatedAt(getUpdatedAt())
                .build();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean active) {
        this.done = active;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}