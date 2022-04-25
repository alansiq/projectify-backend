package com.alansiqueira.projectify.repository;

import com.alansiqueira.projectify.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
