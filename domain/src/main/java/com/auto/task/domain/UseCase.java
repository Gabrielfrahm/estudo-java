package com.auto.task.domain;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
