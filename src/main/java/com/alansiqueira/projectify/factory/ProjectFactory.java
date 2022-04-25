package com.alansiqueira.projectify.factory;

import com.alansiqueira.projectify.dto.NewProjectDto;
import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProjectFactory {
    private final ProjectService projectService;

    public List<Project> getProject() {
        return projectService.getProjectList();
    }

    public Project getProject(Long id) {
        return projectService.getProject(id);
    }

    public Project create(NewProjectDto newProjectDto) {
        Project convertedProject = Project.builder()
                            .title(newProjectDto.getTitle())
                            .description(newProjectDto.getDescription())
                            .build();

        return projectService.create(convertedProject);
    }

    public Project remove(Long projectId) {
        Project project = this.getProject(projectId);
        if (project == null) return null;
        try {
            projectService.remove(project);
            return project;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
