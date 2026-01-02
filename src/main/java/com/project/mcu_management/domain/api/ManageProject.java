package com.project.mcu_management.domain.api;

import com.project.mcu_management.domain.object.Project;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ManageProject {
    void insert(Project project);

    Optional<Project> getById(Long id);

    Map<String, List<Project>> getAllProjects();
}
