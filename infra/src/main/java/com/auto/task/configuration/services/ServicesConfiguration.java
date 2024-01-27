package com.auto.task.configuration.services;

import com.auto.task.SaveTaskService;
import com.auto.task.domain.UseCase;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;
import com.auto.task.out.persistence.task.TaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import out.persistence.task.TaskRepositoryPort;

@Configuration
public class ServicesConfiguration {
    @Bean
    public TaskRepositoryPort taskRepositoryPort(TaskRepositoryAdapter taskRepositoryAdapter) {
        return taskRepositoryAdapter;
    }

    @Bean
    public SaveTaskService saveTaskService(
            UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> saveTaskUseCase,
            TaskRepositoryPort taskRepositoryPort
    ) {
        return new SaveTaskService(saveTaskUseCase, taskRepositoryPort);
    }

    @Bean
    public UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> saveTaskUseCase() {
        return new SaveTaskUseCase();
    }
}
