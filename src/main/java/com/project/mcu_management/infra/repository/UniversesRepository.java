package com.project.mcu_management.infra.repository;

import com.project.mcu_management.infra.entity.UniverseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversesRepository extends JpaRepository<UniverseEntity, String> {
}
