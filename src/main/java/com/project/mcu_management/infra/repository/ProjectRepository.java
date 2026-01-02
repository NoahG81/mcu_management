package com.project.mcu_management.infra.repository;

import com.project.mcu_management.infra.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
