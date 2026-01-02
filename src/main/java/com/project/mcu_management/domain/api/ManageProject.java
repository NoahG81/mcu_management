package com.project.mcu_management.domain.api;

import com.project.mcu_management.domain.Project;

import java.util.Optional;

public interface ManageProject {
    void insert(Project project);

    Optional<Project> getById(Long id);
}
