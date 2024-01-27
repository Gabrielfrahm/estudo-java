package com.auto.task;

import com.auto.task.domain.UseCase;
import com.auto.task.domain.task.entities.Task;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;
import in.task.SaveTaskServicePort;
import out.persistence.task.TaskRepositoryPort;

public class SaveTaskService implements SaveTaskServicePort {
    private final UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> saveTaskUseCase;
    private final TaskRepositoryPort taskRepository;
    public SaveTaskService(
            UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> saveTaskUseCase,
            TaskRepositoryPort taskRepository
    ){
        this.saveTaskUseCase = saveTaskUseCase;
        this.taskRepository = taskRepository;
    }
    @Override
    public Task saveTask(com.auto.task.domain.task.usecases.SaveTaskUseCase.CreateCommand createCommand) {
        final Task task = this.saveTaskUseCase.execute(createCommand).task();
        return taskRepository.create(task);
    }
}
