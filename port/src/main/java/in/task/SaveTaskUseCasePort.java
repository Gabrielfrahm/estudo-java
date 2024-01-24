package in.task;


import com.auto.task.domain.task.Task;
import in.UseCase;



public abstract class SaveTaskUseCasePort implements UseCase<SaveTaskUseCasePort.CreateCommand, SaveTaskUseCasePort.TaskResult> {
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
