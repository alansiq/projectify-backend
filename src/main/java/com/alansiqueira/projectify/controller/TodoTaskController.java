package com.alansiqueira.projectify.controller;

import com.alansiqueira.projectify.dto.TodoTaskDto;
import com.alansiqueira.projectify.entity.TodoTask;
import com.alansiqueira.projectify.service.TodoTaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TodoTask> createTask(@RequestBody TodoTaskDto todoTask) {
        System.out.println(todoTask);
        return todoTaskService.createNewTask();
    }

    @DeleteMapping(value = {"/task/{id}"})
    public ResponseEntity<TodoTask> deleteTask(@PathVariable Long id) {
        return todoTaskService.deleteTaskFromId(id);
    }
}
