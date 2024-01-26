package com.auto.task.domain.task.usecases;

import com.auto.task.domain.UseCase;
import com.auto.task.domain.task.entities.Task;

public class SaveTaskUseCase implements UseCase<SaveTaskUseCase.CreateCommand, SaveTaskUseCase.TaskResult> {
    @Override
    public TaskResult execute(CreateCommand createCommand) {
        final Task task = new Task.Builder()
                .withName(createCommand.name())
                .withDescription(createCommand.description())
                .withDone(createCommand.done())
                .build();

        return new TaskResult(task);
    }

    public record CreateCommand(String name, String description, Boolean done) {
        public CreateCommand {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be null or empty");
            }
        }
    }

    public record TaskResult(Task task) {
        public TaskResult {
            if (task == null) {
                throw new IllegalArgumentException("Task cannot be null");
            }
        }
    }
}
