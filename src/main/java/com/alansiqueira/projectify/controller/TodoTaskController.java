package com.alansiqueira.projectify.controller;

import com.alansiqueira.projectify.model.TodoTask;
import com.alansiqueira.projectify.repository.TodoTaskRepository;
import com.alansiqueira.projectify.service.TodoTaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@AllArgsConstructor
public class TodoTaskController {
    private final TodoTaskService todoTaskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TodoTask>> readAllTasks() {
        return todoTaskService.getAllTasks();
    }

    @GetMapping(value = {"/tasks/{id}"})
    public ResponseEntity<TodoTask> readTaskByTitle(@PathVariable Long id) {
        return todoTaskService.getSingleTask(id);
    }

    @PostMapping("/task")
    public ResponseEntity<TodoTask> createTask(@RequestBody TodoTask todoTask) {
        return todoTaskService.createNewTask(todoTask);
    }

    @DeleteMapping(value = {"/task/{id}"})
    public ResponseEntity<TodoTask> deleteTask(@PathVariable Long id) {
        return todoTaskService.deleteTaskFromId(id);
    }
 }
