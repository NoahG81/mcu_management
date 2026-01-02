package com.project.mcu_management.infra;

import com.project.mcu_management.domain.Project;
import com.project.mcu_management.domain.spi.LoadProject;
import com.project.mcu_management.infra.entity.ProjectEntity;
import com.project.mcu_management.infra.mapper.ProjectMapper;
import com.project.mcu_management.infra.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProjectLoader implements LoadProject {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectLoader(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public Optional<Project> loadById(Long id) {
        Optional<ProjectEntity> projectEntity = projectRepository.findById(id);
        return projectEntity.map(projectMapper::mapToDomain);
    }
}
