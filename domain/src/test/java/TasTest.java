import com.auto.task.domain.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


public class TasTest {
    @Test
    public void ShouldBeAbleToCreateAnTask(){
        final Task task = new Task.Builder()
                .withName("test")
                .withDescription("test description")
                .withDone(false)
                .withCreatedAt(new Date().toInstant())
                .withUpdatedAt(new Date().toInstant())
                .build();
        Assertions.assertNotNull(task.getId());
        Assertions.assertInstanceOf(Task.class,task);
    }

    @Test
    public void ShouldBeAbleToCreateAnTaskWithId(){
        final Task task = new Task.Builder()
                .withId("85ec0437-7854-4437-aeda-9f21933fa50d")
                .withName("test")
                .withDescription("test description")
                .withDone(false)
                .withCreatedAt(new Date().toInstant())
                .withUpdatedAt(new Date().toInstant())
                .build();
        Assertions.assertNotNull(task.getId());
        Assertions.assertInstanceOf(Task.class,task);
    }

    @Test
    public void ShouldBeAbleToToggleAnTask(){
        final Task task = new Task.Builder()
                .withName("test")
                .withDescription("test description")
                .withDone(false)
                .withCreatedAt(new Date().toInstant())
                .build();

        Assertions.assertEquals(task.getDone(), false);

        task.toggleDone();

        Assertions.assertEquals(task.getDone(), true);
    }

    @Test
    public void ShouldBeAbleToGetAllAttributes(){
        final Task task = new Task.Builder()
                .withId("85ec0437-7854-4437-aeda-9f21933fa50d")
                .withName("test")
                .withDescription("test description")
                .withDone(false)
                .withCreatedAt(new Date().toInstant())
                .withUpdatedAt(new Date().toInstant())
                .build();

        Assertions.assertInstanceOf(Task.class,task);
        Assertions.assertNotNull(task.getId());
        Assertions.assertEquals(task.getName(), "test");
        Assertions.assertEquals(task.getDescription(), "test description");
        Assertions.assertEquals(task.getDone(), false);
        Assertions.assertNotNull(task.getCreatedAt());
        Assertions.assertNotNull(task.getUpdatedAt());
    }
}
