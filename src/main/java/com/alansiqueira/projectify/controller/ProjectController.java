package com.alansiqueira.projectify.controller;

import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.entity.TodoTask;
import com.alansiqueira.projectify.repository.ProjectRepository;
import com.alansiqueira.projectify.repository.TodoTaskRepository;
import com.alansiqueira.projectify.service.ProjectService;
import com.alansiqueira.projectify.service.TodoTaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService projectService;
    private final ProjectRepository projectRepository;
    private final TodoTaskRepository todoTaskRepository;

    public ProjectController(ProjectService projectService, ProjectRepository projectRepository, TodoTaskRepository todoTaskRepository) {
        this.projectService = projectService;
        this.projectRepository = projectRepository;
        this.todoTaskRepository = todoTaskRepository;
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getProjectList();
    }


    @GetMapping("/a")
    public boolean teste() {

        Project project = Project
                .builder()
                .title("Projeto")
                .description("Descrição")
                .build();

        TodoTask task2 = TodoTask
                .builder()
                .title("Tarefa 2")
                .description("Descrição 2")
                .isComplete(true)
                .project(project)
                .build();

        projectRepository.save(project);
        todoTaskRepository.save(task2);


        return true;
    }
}
