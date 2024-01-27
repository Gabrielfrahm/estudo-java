package com.auto.task.domain.task.entities;


import java.time.Instant;
import java.util.Objects;
import java.util.UUID;


public class Task {
    private String id;
    private String name;
    private String description;
    private Boolean done;
    private Instant createdAt;
    private Instant updatedAt;

    private Task(Builder props) {
        this.id = props.id != null ? props.id : UUID.randomUUID().toString();
        this.name = props.name;
        this.description = props.description;
        this.done = props.done != null ? props.done : false;
        this.createdAt = props.createdAt != null ? props.createdAt : Instant.now();
        this.updatedAt = props.updatedAt != null ? props.createdAt : Instant.now();
    }

    @Override
    public boolean equals(final Object o) {
        if(this == o) return true;
        if( o == null || getClass() != o.getClass()) return false;
        final Task that = (Task) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(done, that.done) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    public int hashCode() {
        return Objects.hash(id, name, description, done, createdAt, updatedAt);
    }

    public String getId() {
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public boolean getDone(){
        return this.done;
    }

    public  Instant getCreatedAt(){
        return  this.createdAt;
    }

    public  Instant getUpdatedAt(){
        return  this.updatedAt;
    }

    public void toggleDone(){
        this.done = !this.done;
    }

    // Class Builder
    public static class Builder {
        private String id;
        private String name;
        private String description;
        private Boolean done;
        private Instant createdAt;
        private Instant updatedAt;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withDone(Boolean done) {
            this.done = done;
            return this;
        }

        public Builder withCreatedAt(Instant createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder withUpdatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Task build() {
            return new Task(this);
        }
    }
}

