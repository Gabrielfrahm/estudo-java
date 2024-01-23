package in.task;


import com.auto.task.domain.task.Task;
import in.UseCase;



public abstract class SaveTaskUseCasePort implements UseCase<SaveTaskUseCasePort.CreateCommand, SaveTaskUseCasePort.TaskResult> {
    /**
     * Executa o caso de uso para salvar uma tarefa.
     *
     * @param command Dados de entrada para criar a tarefa.
     * @return Resultado contendo a tarefa criada.
     */
    public abstract TaskResult execute(CreateCommand command);

    // Dado de entrada
    // Construtor para inicializar campos imutáveis
        public record CreateCommand(String name, String description, Boolean done) {

            public CreateCommand {
                // Adicionar validações conforme necessário:
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be null or empty");
                }
            }
        }

    // Dado de saída
    public static class TaskResult {
        private final Task task;

        // Construtor
        public TaskResult(Task task) {
            if (task == null) {
                throw new IllegalArgumentException("Task cannot be null");
            }
            this.task = task;
        }

        // Getter
        public Task getTask() {
            return task;
        }
    }
}
