package com.alansiqueira.projectify.service;

import com.alansiqueira.projectify.model.TodoTask;
import com.alansiqueira.projectify.repository.TodoTaskRepository;
import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoTaskService {
    private final TodoTaskRepository todoTaskRepository;

    public ResponseEntity<List<TodoTask>> getAllTasks() {
        return ResponseEntity.ok().body(todoTaskRepository.findAll());
    }

    // TODO: 20/03/22 ADD GET TASK BY ID 

    // TODO: 20/03/22 CREATE TASK 

    // TODO: 20/03/22 DELETE TASK FROM ID 
}
