package com.project.mcu_management.infra;

import com.project.mcu_management.domain.object.Universes;
import com.project.mcu_management.domain.spi.LoadUniverses;
import com.project.mcu_management.infra.mapper.UniverseMapper;
import com.project.mcu_management.infra.repository.UniversesRepository;
import org.springframework.stereotype.Component;

@Component
public class UniversesLoader implements LoadUniverses {
    private final UniversesRepository universesRepository;
    private final UniverseMapper universesMapper;

    public UniversesLoader(UniversesRepository universesRepository, UniverseMapper universesMapper) {
        this.universesRepository = universesRepository;
        this.universesMapper = universesMapper;
    }

    @Override
    public Universes loadAll() {
        var universes = universesRepository.findAll();
        return universesMapper.map(universes);
    }
}
