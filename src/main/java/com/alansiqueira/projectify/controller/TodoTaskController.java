package com.alansiqueira.projectify.controller;

import com.alansiqueira.projectify.dto.NewTodoTaskDto;
import com.alansiqueira.projectify.dto.TodoTaskDto;
import com.alansiqueira.projectify.entity.TodoTask;
import com.alansiqueira.projectify.factory.TodoTaskFactory;
import com.alansiqueira.projectify.service.TodoTaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
public class TodoTaskController {
    private final TodoTaskService todoTaskService;
    private final TodoTaskFactory todoTaskFactory;

    @GetMapping("/tasks")
    public ResponseEntity<List<TodoTaskDto>> readAllTasks() {
        List<TodoTask> todoTaskList =  todoTaskService.getAllTasks();
        List<TodoTaskDto> resultTodoTaskList = TodoTaskDto.convertList(todoTaskList);
        return ResponseEntity.ok().body(resultTodoTaskList);
    }

    @GetMapping(value = {"/tasks/{id}"})
    public ResponseEntity<TodoTask> readTaskByTitle(@PathVariable Long id) {
        return todoTaskService.getSingleTask(id);
    }

    @PostMapping("/task")
    public ResponseEntity<TodoTaskDto> createTask(@RequestBody NewTodoTaskDto todoTask) {
        // TODO: 24/04/22 Create ResponseEntity at Controller level 
        // TODO: 24/04/22 Convert to ResponseTodoTaskDto 
        TodoTask createdTask = todoTaskFactory.create(todoTask);
        TodoTaskDto responseTask = TodoTaskDto.convert(createdTask);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseTask);
    }

    @DeleteMapping(value = {"/task/{id}"})
    public ResponseEntity<TodoTask> deleteTask(@PathVariable Long id) {
        return todoTaskService.deleteTaskFromId(id);
    }
}
