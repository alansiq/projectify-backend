package com.alansiqueira.projectify.factory;

import com.alansiqueira.projectify.dto.NewTodoTaskDto;
import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.entity.TodoTask;
import com.alansiqueira.projectify.service.ProjectService;
import com.alansiqueira.projectify.service.TodoTaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TodoTaskFactory {
    private final TodoTaskService todoTaskService;
    private final ProjectService projectService;

    public TodoTask create(NewTodoTaskDto newTodoTask) {

        Project project = projectService.getProject(newTodoTask.getProjectId());
        if (project == null) return null;

        TodoTask task = TodoTask
                .builder()
                .title(newTodoTask.getTitle())
                .description(newTodoTask.getDescription())
                .isComplete(newTodoTask.getIsComplete())
                .project(project)
                .build();

        return this.todoTaskService.createNewTask(task);

    }
}
