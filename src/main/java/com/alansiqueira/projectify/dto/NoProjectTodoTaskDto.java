package com.alansiqueira.projectify.dto;

import com.alansiqueira.projectify.entity.TodoTask;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class NoProjectTodoTaskDto {
    private Long id;
    private String title;
    private String description;
    private boolean isComplete;

    public static NoProjectTodoTaskDto convert(TodoTask todoTask) {
        return NoProjectTodoTaskDto.builder()
                .id(todoTask.getId())
                .title(todoTask.getTitle())
                .description(todoTask.getDescription())
                .isComplete(todoTask.isComplete())
                .build();
    }

    public static List<NoProjectTodoTaskDto> convert(List<TodoTask> todoTaskList) {
        return todoTaskList.stream().map(NoProjectTodoTaskDto::convert).collect(Collectors.toList());
    }
}

