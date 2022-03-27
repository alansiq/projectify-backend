package com.alansiqueira.projectify.service;

import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public String hello() {
        return "Hello world";
    }

    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }

}
