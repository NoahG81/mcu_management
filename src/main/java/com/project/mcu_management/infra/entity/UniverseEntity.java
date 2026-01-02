package com.project.mcu_management.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "universe")
public class UniverseEntity {
    @Id
    private String code;
    @Column(name = "sort_order")
    private int sortOrder;

    public UniverseEntity() {

    }

    public String getCode() {
        return code;
    }

    public int getSortOrder() {
        return sortOrder;
    }
}
