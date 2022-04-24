package com.alansiqueira.projectify.service;

import com.alansiqueira.projectify.entity.TodoTask;
import com.alansiqueira.projectify.repository.TodoTaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoTaskService {
    private final TodoTaskRepository todoTaskRepository;

    public List<TodoTask> getAllTasks() {
        return todoTaskRepository.findAll();
    }

    public ResponseEntity<TodoTask> getSingleTask(Long id) {
        Optional<TodoTask> foundTask = todoTaskRepository.findById(id);

        return foundTask
                .map(todoTask -> ResponseEntity.ok().body(todoTask))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public TodoTask createNewTask(TodoTask todoTask) {
        return todoTaskRepository.save(todoTask);
    }

    public ResponseEntity<TodoTask> deleteTaskFromId(Long id) {
        Optional<TodoTask> foundTask = todoTaskRepository.findById(id);

        if (foundTask.isPresent()) {
            todoTaskRepository.delete(foundTask.get());
            return ResponseEntity.ok().body(foundTask.get());
        }

        return ResponseEntity.notFound().build();
    }
}
