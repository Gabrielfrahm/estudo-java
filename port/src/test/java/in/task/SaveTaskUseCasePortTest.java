package in.task;

import com.auto.task.domain.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SaveTaskUseCasePortTest {
    private static class SaveTaskUSeCasePortTestImplement extends SaveTaskUseCasePort {
        @Override
        public TaskResult execute(CreateCommand command) {
           Task task = new Task.Builder().withName(command.name()).withDescription(command.description()).withDone(command.done()).build();
            return new TaskResult(task);
        }
    }

    @Test
    void TestExecute() {
        String expectedName = "Test";
        String expectedDescription = "description test";
        boolean expectedDone = false;
        SaveTaskUSeCasePortTestImplement saveTaskUSeCasePortTestImplement = new SaveTaskUSeCasePortTestImplement();
        SaveTaskUseCasePort.CreateCommand  createCommand = new SaveTaskUseCasePort.CreateCommand(expectedName, expectedDescription, expectedDone);

        SaveTaskUseCasePort.TaskResult taskResult = saveTaskUSeCasePortTestImplement.execute(createCommand);

        Assertions.assertNotNull(taskResult);
        Assertions.assertNotNull(taskResult.task().getId());
        Assertions.assertEquals(taskResult.task().getName(), expectedName);
        Assertions.assertEquals(taskResult.task().getDescription(), expectedDescription);
        Assertions.assertEquals(taskResult.task().getDone(), expectedDone);
    }
}
