package com.alansiqueira.projectify.repository;

import com.alansiqueira.projectify.model.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {

    TodoTask findByDescription(String description);

    TodoTask findByTitle(String title);
}
