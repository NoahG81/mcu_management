package com.project.mcu_management.infra.mapper;

import com.project.mcu_management.domain.MediaType;
import com.project.mcu_management.domain.Project;
import com.project.mcu_management.infra.entity.ProjectEntity;
import com.project.mcu_management.infra.entity.type.MediaTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    public ProjectEntity map(Project media) {
        var projectEntity = new ProjectEntity();
        projectEntity.setTitre(media.titre());
        projectEntity.setAffiche(media.affiche());
        projectEntity.setDateSortie(media.dateSortie());
        projectEntity.setDureeMinute(media.dureeMinutes());
        projectEntity.setOrdreVisionnage(media.ordreVisionnage());
        projectEntity.setTypeMedia(mapMediaType(media.typeMedia()).getValue());
        projectEntity.setIdPhase(media.phaseId());
        return projectEntity;
    }

    private MediaTypeEntity mapMediaType(MediaType mediaTypeBean) {
        return switch (mediaTypeBean) {
            case FILM -> MediaTypeEntity.FILM;
            case SERIE -> MediaTypeEntity.SERIE;
        };
    }

    public Project mapToDomain(ProjectEntity media) {
        return new Project(media.getTitre(), media.getOrdreVisionnage(), media.getDureeMinute(),
                media.getDateSortie(),
                mapMediaTypeToDomain(MediaTypeEntity.getMediaTypeEntity(media.getTypeMedia())),
                media.getIdPhase(), media.getAffiche());
    }

    private MediaType mapMediaTypeToDomain(MediaTypeEntity mediaTypeBean) {
        return switch (mediaTypeBean) {
            case FILM -> MediaType.FILM;
            case SERIE -> MediaType.SERIE;
        };
    }
}
