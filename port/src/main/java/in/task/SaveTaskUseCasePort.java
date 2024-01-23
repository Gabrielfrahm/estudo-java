package in.task;

import com.auto.task.domain.task.Task;
import in.UseCase;



public abstract class SaveTaskUseCasePort implements UseCase<SaveTaskUseCasePort.CreateCommand, SaveTaskUseCasePort.TaskResult> {
    public abstract TaskResult execute(CreateCommand command);

    // dado de entrada
    public static class CreateCommand {
        private String name;
        private String description;
        private Boolean done;
    }

    // dado de saida
    public static class TaskResult {
        public Task task;
    }
}
