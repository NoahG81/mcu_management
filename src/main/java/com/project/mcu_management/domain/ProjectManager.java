package com.project.mcu_management.domain;

import com.project.mcu_management.domain.api.ManageProject;
import com.project.mcu_management.domain.spi.InsertProject;
import com.project.mcu_management.domain.spi.LoadProject;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectManager implements ManageProject {
    private final InsertProject insertProject;
    private final LoadProject loadProject;

    public ProjectManager(InsertProject insertProject, LoadProject loadProject) {
        this.insertProject = insertProject;
        this.loadProject = loadProject;
    }

    @Override
    public void insert(Project project) {
        insertProject.insert(project);
    }

    @Override
    public Optional<Project> getById(Long id) {
        return loadProject.loadById(id);
    }
}
