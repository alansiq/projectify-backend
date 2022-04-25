package com.alansiqueira.projectify.dto;

import com.alansiqueira.projectify.entity.TodoTask;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoTaskDto {
    private Long id;
    private String title;
    private String description;
    private ProjectDto project;
    private boolean isComplete;

    public static TodoTaskDto convert(TodoTask todoTask) {
        return TodoTaskDto.builder()
                .id(todoTask.getId())
                .title(todoTask.getTitle())
                .description(todoTask.getDescription())
                .project(ProjectDto.convert(todoTask.getProject()))
                .isComplete(todoTask.isComplete())
                .build();
    }

    public static List<TodoTaskDto> convert(List<TodoTask> todoTaskList) {
        return todoTaskList.stream().map(TodoTaskDto::convert).collect(Collectors.toList());
    }
}
