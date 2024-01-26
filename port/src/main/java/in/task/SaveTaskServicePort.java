package in.task;

import com.auto.task.domain.task.entities.Task;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;

public interface SaveTaskServicePort {
    Task saveTask(SaveTaskUseCase.CreateCommand createCommand);
}
