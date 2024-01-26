package com.auto.task;

import com.auto.task.domain.UseCase;
import com.auto.task.domain.task.entities.Task;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;
import in.task.SaveTaskServicePort;

public class SaveTaskService implements SaveTaskServicePort {
    private final UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> saveTaskUseCase;
    public SaveTaskService(UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> saveTaskUseCase){
        this.saveTaskUseCase = saveTaskUseCase;
    }
    @Override
    public Task saveTask(com.auto.task.domain.task.usecases.SaveTaskUseCase.CreateCommand createCommand) {
        return this.saveTaskUseCase.execute(createCommand).task();
    }
}
