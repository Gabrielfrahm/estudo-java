package com.auto.task.out.persistence.task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryJpa extends JpaRepository<TaskJpaEntity, String> {
}
