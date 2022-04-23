package com.alansiqueira.projectify;

import com.alansiqueira.projectify.entity.Project;
import com.alansiqueira.projectify.entity.TodoTask;
import com.alansiqueira.projectify.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
