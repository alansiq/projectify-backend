package com.alansiqueira.projectify.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoTaskDto {
    private String title;
    private Long projectId;
    private String description;
    private Boolean isComplete;
}
