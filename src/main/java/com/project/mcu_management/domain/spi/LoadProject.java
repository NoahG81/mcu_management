package com.project.mcu_management.domain.spi;

import com.project.mcu_management.domain.object.Project;

import java.util.List;
import java.util.Optional;

public interface LoadProject {
    Optional<Project> loadById(Long id);

    List<Project> loadAll();
}
