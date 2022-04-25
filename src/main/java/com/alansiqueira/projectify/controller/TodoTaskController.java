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
@RequestMapping("/task")
public class TodoTaskController {
    private final TodoTaskService todoTaskService;
    private final TodoTaskFactory todoTaskFactory;

    @GetMapping
    public ResponseEntity<List<TodoTaskDto>> readAllTasks() {
        List<TodoTask> todoTaskList =  todoTaskService.getAllTasks();
        List<TodoTaskDto> resultTodoTaskList = TodoTaskDto.convert(todoTaskList);
        return ResponseEntity.ok().body(resultTodoTaskList);
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<TodoTaskDto> readTaskByTitle(@PathVariable Long id) {
        TodoTask todoTask = todoTaskService.getSingleTask(id);
        if (todoTask == null) {
            return ResponseEntity.notFound().build();
        }
        TodoTaskDto response = TodoTaskDto.convert(todoTask);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<TodoTaskDto> createTask(@RequestBody NewTodoTaskDto todoTask) {
        TodoTask createdTask = todoTaskFactory.create(todoTask);

        if (createdTask == null) {
            return ResponseEntity.badRequest().build();
        }

        TodoTaskDto responseTask = TodoTaskDto.convert(createdTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseTask);
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<TodoTaskDto> deleteTask(@PathVariable Long id) {
        TodoTask deletedTask = todoTaskService.deleteTaskFromId(id);
        if (deletedTask == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(TodoTaskDto.convert(deletedTask));
    }
}
