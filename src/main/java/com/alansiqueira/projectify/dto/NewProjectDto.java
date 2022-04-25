package com.alansiqueira.projectify.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewProjectDto {
    @NotNull
    private String title;
    private String description;
}
