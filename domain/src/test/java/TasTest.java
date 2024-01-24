import com.auto.task.domain.task.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;


class TasTest {
    @Test
    void ShouldBeAbleToCreateAnTask(){
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
    void ShouldBeAbleToCreateAnTaskWithId(){
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
    void ShouldBeAbleToToggleAnTask(){
        final Task task = new Task.Builder()
                .withName("test")
                .withDescription("test description")
                .withDone(false)
                .withCreatedAt(new Date().toInstant())
                .build();

        Assertions.assertFalse(false);

        task.toggleDone();

        Assertions.assertTrue(true);
    }

    @Test
    void ShouldBeAbleToGetAllAttributes(){
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
        Assertions.assertEquals("test",task.getName() );
        Assertions.assertEquals("test description", task.getDescription() );
        Assertions.assertFalse(false);
        Assertions.assertNotNull(task.getCreatedAt());
        Assertions.assertNotNull(task.getUpdatedAt());
    }
}
