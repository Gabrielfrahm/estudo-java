package out.persistence.task;

import com.auto.task.domain.task.entities.Task;
import out.persistence.Repository;

import java.util.List;

public interface TaskRepositoryPort extends Repository<Task> {
    List<Task> findAll(SearchTaskParams params);
}
