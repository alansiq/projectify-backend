package com.alansiqueira.projectify.controller;

import com.alansiqueira.projectify.model.TodoTask;
import com.alansiqueira.projectify.repository.TodoTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class TodoTaskController {
    private final TodoTaskRepository todoTaskRepository;

    @GetMapping("/tasks")
    public List<TodoTask> readAllTasks() {
        return todoTaskRepository.findAll();
    }

    @GetMapping(value = {"/tasks/{id}"})
    public TodoTask readTaskByTitle(@PathVariable Long id) {
        if (todoTaskRepository.findById(id).isPresent()) return todoTaskRepository.findById(id).get();
        return new TodoTask(999L, "Error", "Couldn't find any task with designated ID", false);
    }

    @PostMapping("/task")
    public TodoTask createTask(@RequestBody TodoTask todoTask) {
        return todoTaskRepository.save(todoTask);
    }

    @DeleteMapping(value = {"/task/{id}"})
    public void deleteTask(@PathVariable Long id) {
        todoTaskRepository.delete(todoTaskRepository.findById(id).get());
    }
 }
