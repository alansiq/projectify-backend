package com.alansiqueira.projectify.controller;

import com.alansiqueira.projectify.dto.NewProjectDto;
import com.alansiqueira.projectify.dto.ProjectDto;
import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.factory.ProjectFactory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectFactory projectFactory;

    @GetMapping("/")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<Project> projectList = projectFactory.getProject();
        List<ProjectDto> projectDtoList = ProjectDto.convert(projectList);
        return ResponseEntity.ok(projectDtoList);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getSingleProject(@PathVariable Long projectId) {
        Project project = projectFactory.getProject(projectId);
        if (project == null) return ResponseEntity.notFound().build();
        ProjectDto projectResponse = ProjectDto.convert(project);
        return ResponseEntity.ok(projectResponse);
    }

    @PostMapping("/")
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody NewProjectDto newProjectDto) {
        Project project = projectFactory.create(newProjectDto);
        ProjectDto projectResponse = ProjectDto.convert(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectResponse);
    }

}
