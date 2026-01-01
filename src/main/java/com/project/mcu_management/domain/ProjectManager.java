package com.project.mcu_management.domain;

import com.project.mcu_management.domain.api.ManageProject;
import com.project.mcu_management.domain.spi.InsertProject;
import org.springframework.stereotype.Component;

@Component
public class ProjectManager implements ManageProject {
    private final InsertProject insertProject;

    public ProjectManager(InsertProject insertProject) {
        this.insertProject = insertProject;
    }

    @Override
    public void insert(Project project) {
        insertProject.insert(project);
    }
}
