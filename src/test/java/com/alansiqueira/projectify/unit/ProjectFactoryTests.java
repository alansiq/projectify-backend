package com.alansiqueira.projectify.unit;

import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.factory.ProjectFactory;
import com.alansiqueira.projectify.service.ProjectService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ProjectFactoryTests {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectFactory projectFactory;


    @Test
    @DisplayName("It should return a list of projects")
    public void getProjectList() {
        // arrange
        Project project = Project.builder().build();
        List<Project> projectList = Arrays.asList(project, project);

        // exec
        Mockito.when(projectService.getProjectList()).thenReturn(projectList);
        List<Project> result = projectFactory.getProject();

        // assert
        assertEquals(projectList, result);
    }

    @Test
    @DisplayName("It should return a single project")
    public void getProject() {
        // arrange
        Project project = Project.builder().build();

        // exec
        Mockito.when(projectService.getProject(any())).thenReturn(project);
        Project result = projectFactory.getProject(1L);

        // assert
        assertEquals(project, result);
    }
}
