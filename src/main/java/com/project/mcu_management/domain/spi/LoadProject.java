package com.project.mcu_management.domain.spi;

import com.project.mcu_management.domain.Project;

import java.util.Optional;

public interface LoadProject {
    Optional<Project> loadById(Long id);
}
