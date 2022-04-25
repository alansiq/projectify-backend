package com.alansiqueira.projectify.dto;

import com.alansiqueira.projectify.entity.Project;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private List<NoProjectTodoTaskDto> todoTaskList;

    public static ProjectDto convert(Project project) {
        return ProjectDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .todoTaskList(project.getTaskList() != null ? NoProjectTodoTaskDto.convert(project.getTaskList()): null)
                .build();
    }

    public static List<ProjectDto> convert(List<Project> projectList) {
        return projectList.stream().map(ProjectDto::convert).collect(Collectors.toList());
    }
}
