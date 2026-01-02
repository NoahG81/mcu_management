package com.project.mcu_management.domain;

import com.project.mcu_management.domain.api.ManageProject;
import com.project.mcu_management.domain.object.Project;
import com.project.mcu_management.domain.spi.InsertProject;
import com.project.mcu_management.domain.spi.LoadProject;
import com.project.mcu_management.domain.spi.LoadUniverses;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class ProjectManager implements ManageProject {
    private final InsertProject insertProject;
    private final LoadProject loadProject;
    private final ProjectUpdater projectUpdater;
    private final LoadUniverses loadUniverses;

    public ProjectManager(InsertProject insertProject, LoadProject loadProject,
                          ProjectUpdater projectUpdater, LoadUniverses loadUniverses) {
        this.insertProject = insertProject;
        this.loadProject = loadProject;
        this.projectUpdater = projectUpdater;
        this.loadUniverses = loadUniverses;
    }

    @Override
    public void insert(Project project) {
        insertProject.insert(project);
    }

    @Override
    public Optional<Project> getById(Long id) {
        return loadProject.loadById(id);
    }

    @Override
    public Map<String, List<Project>> getAllProjects() {
        var projects = loadProject.loadAll();
        var universes = loadUniverses.loadAll();
        return projectUpdater.buildAllProjectAndSort(projects, universes);
    }
}
