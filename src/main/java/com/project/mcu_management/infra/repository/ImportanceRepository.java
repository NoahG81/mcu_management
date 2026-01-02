package com.project.mcu_management.infra.repository;

import com.project.mcu_management.infra.entity.ImportanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImportanceRepository extends JpaRepository<ImportanceEntity, Long> {
}
