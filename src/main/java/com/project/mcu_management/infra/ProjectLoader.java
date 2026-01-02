package com.project.mcu_management.infra;

import com.project.mcu_management.domain.object.Project;
import com.project.mcu_management.domain.spi.LoadProject;
import com.project.mcu_management.infra.entity.ProjectEntity;
import com.project.mcu_management.infra.mapper.ProjectMapper;
import com.project.mcu_management.infra.repository.ImportanceRepository;
import com.project.mcu_management.infra.repository.ProjectRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProjectLoader implements LoadProject {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final ImportanceRepository importanceRepository;

    public ProjectLoader(ProjectRepository projectRepository, ProjectMapper projectMapper, ImportanceRepository importanceRepository) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
        this.importanceRepository = importanceRepository;
    }

    @Override
    public Optional<Project> loadById(Long id) {
        var importances = importanceRepository.findAll();
        Optional<ProjectEntity> projectEntity = projectRepository.findById(id);
        return projectEntity.map(projectEntity1 -> projectMapper.mapToDomain(projectEntity1, importances));
    }

    @Override
    public List<Project> loadAll() {
        var importances = importanceRepository.findAll();
        var projectsEntities = projectRepository.findAll();
        return projectsEntities.stream()
                .map(projectEntity -> projectMapper.mapToDomain(projectEntity, importances))
                .toList();
    }
}
