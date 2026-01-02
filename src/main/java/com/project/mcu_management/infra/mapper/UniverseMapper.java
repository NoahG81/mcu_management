package com.project.mcu_management.infra.mapper;

import com.project.mcu_management.domain.object.Universe;
import com.project.mcu_management.domain.object.Universes;
import com.project.mcu_management.infra.entity.UniverseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniverseMapper {

    public Universes map(List<UniverseEntity> universes) {
        return new Universes(universes.stream()
                .map(universeEntity -> new Universe(universeEntity.getCode(), universeEntity.getSortOrder()))
                .toList());
    }
}
