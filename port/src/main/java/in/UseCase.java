package in;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
