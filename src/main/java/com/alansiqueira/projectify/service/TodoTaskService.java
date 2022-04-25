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

    public TodoTask getSingleTask(Long id) {
        Optional<TodoTask> foundTask = todoTaskRepository.findById(id);
        return foundTask.orElse(null);
    }

    public TodoTask createNewTask(TodoTask todoTask) {
        return todoTaskRepository.save(todoTask);
    }

    public TodoTask deleteTaskFromId(Long id) {
        Optional<TodoTask> foundTask = todoTaskRepository.findById(id);
        try {
            todoTaskRepository.deleteById(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return foundTask.orElse(null);
    }
}
