package com.auto.task.controllers;

import com.auto.task.domain.task.entities.Task;
import com.auto.task.domain.task.usecases.SaveTaskUseCase;
import in.task.SaveTaskServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks")
public class TaskController {

    private final SaveTaskServicePort saveTaskService;
    public TaskController(SaveTaskServicePort saveTaskService) {
        this.saveTaskService = saveTaskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDto) {
        SaveTaskUseCase.CreateCommand command = convertToCommand(taskDto);

        Task savedTask = saveTaskService.saveTask(command);

        return ResponseEntity.ok(savedTask);
    }

    private SaveTaskUseCase.CreateCommand convertToCommand(TaskDTO taskDto) {
        return new SaveTaskUseCase.CreateCommand(taskDto.getName(), taskDto.getDescription(), taskDto.getDone());
    }

}
