package com.project.mcu_management.infra;

import com.project.mcu_management.domain.object.Project;
import com.project.mcu_management.domain.spi.InsertProject;
import com.project.mcu_management.infra.mapper.ProjectMapper;
import com.project.mcu_management.infra.repository.ProjectRepository;
import org.springframework.stereotype.Component;

@Component
public class ProjectInserter implements InsertProject {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    public ProjectInserter(ProjectMapper projectMapper, ProjectRepository projectRepository) {
        this.projectMapper = projectMapper;
        this.projectRepository = projectRepository;
    }

    @Override
    public void insert(Project project) {
        var projectEntity = projectMapper.map(project);
        projectRepository.save(projectEntity);
    }
}
