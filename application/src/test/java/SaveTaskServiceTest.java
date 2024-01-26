import com.auto.task.SaveTaskService;
import com.auto.task.domain.task.entities.Task;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SaveTaskServiceTest {

    @Mock
    private SaveTaskUseCase saveTaskUseCase;

    @InjectMocks
    private SaveTaskService saveTaskService;

    private SaveTaskServiceTest() {
    }
    

    @Test
    public void shouldBeAbleCallSaveTaskServiceAndReturnAnTask(){
      SaveTaskUseCase.CreateCommand command = new SaveTaskUseCase.CreateCommand("Test", "Test", false);
      Task expectedTask = new Task.Builder().withName(command.name()).withDescription(command.description()).withDone(command.done()).build();
      Mockito.when(saveTaskUseCase.execute(command)).thenReturn(new SaveTaskUseCase.TaskResult(expectedTask));
      Task result = saveTaskService.saveTask(command);

      Assertions.assertNotNull(result);
      Assertions.assertEquals(result, expectedTask);
    }

}
