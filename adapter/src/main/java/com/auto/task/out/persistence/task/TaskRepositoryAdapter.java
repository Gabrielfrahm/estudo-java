package com.auto.task.out.persistence.task;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import out.persistence.task.SearchTaskParams;
import out.persistence.task.TaskRepositoryPort;
import com.auto.task.domain.task.entities.Task;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepositoryJpa taskRepositoryJpa;

    @Autowired
    public TaskRepositoryAdapter(TaskRepositoryJpa taskRepositoryJpa) {
        this.taskRepositoryJpa = taskRepositoryJpa;
    }

    @Override
    public List<Task> findAll(SearchTaskParams params) {
        List<TaskJpaEntity> taskEntities = taskRepositoryJpa.findAll();
        return taskEntities.stream()
                .map(TaskJpaEntity::domainTask)
                .collect(Collectors.toList());
    }

    @Override
    public Task create(Task entity) {
        TaskJpaEntity taskEntity = TaskJpaEntity.from(entity);
        TaskJpaEntity savedEntity = taskRepositoryJpa.save(taskEntity);
        return savedEntity.domainTask();
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }
}
