package com.project.mcu_management.appli;

import com.project.mcu_management.appli.bean.ProjectBean;
import com.project.mcu_management.appli.mapper.ProjectBeanMapper;
import com.project.mcu_management.domain.api.ManageProject;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ProjectApplication {
    private final ManageProject projectManager;
    private final ProjectBeanMapper projectBeanMapper;

    public ProjectApplication(ManageProject projectManager, ProjectBeanMapper projectBeanMapper) {
        this.projectManager = projectManager;
        this.projectBeanMapper = projectBeanMapper;
    }

    public void insert(ProjectBean media) {
        projectManager.insert(projectBeanMapper.mapToDomain(media));
    }

    public Optional<ProjectBean> getProjectById(Long id) {
        var project = projectManager.getById(id);
        return project.map(projectBeanMapper::map);
    }

    public Map<String, List<ProjectBean>> getAllProjects() {
        var projects = projectManager.getAllProjects();

        return projects.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue()
                                .stream()
                                .map(projectBeanMapper::map)
                                .toList(),
                        (a, b) -> a,
                        LinkedHashMap::new));
    }
}
