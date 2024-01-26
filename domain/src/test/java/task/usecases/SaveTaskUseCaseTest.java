package task.usecases;

import com.auto.task.domain.task.entities.Task;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SaveTaskUseCaseTest {

    @Test
    public void ShouldBeAbleCallUseCaseAndCreateAnTask(){
        SaveTaskUseCase saveTaskUseCase = new SaveTaskUseCase();
        String expectedName = "Test";
        String expectedDescription = "description test";
        boolean expectedDone = false;
        SaveTaskUseCase.CreateCommand createCommand = new SaveTaskUseCase.CreateCommand(expectedName, expectedDescription, expectedDone);
        SaveTaskUseCase.TaskResult taskResult = saveTaskUseCase.execute(createCommand);
        Assertions.assertInstanceOf(Task.class, taskResult.task());
    }
}
