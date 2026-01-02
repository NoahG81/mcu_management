package com.project.mcu_management.infra.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "importance")
public class ImportanceEntity {
    @Id
    private Integer id;
    private String label;

    public ImportanceEntity() {

    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
