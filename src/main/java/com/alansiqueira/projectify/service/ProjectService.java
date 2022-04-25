package com.alansiqueira.projectify.service;

import com.alansiqueira.projectify.dto.NewProjectDto;
import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public List<Project> getProjectList() {
        return projectRepository.findAll();
    }

    public Project getProject(Long id) { return projectRepository.findById(id).orElse(null);}

    public Project create(Project project) {
        return projectRepository.save(project);
    }
}
