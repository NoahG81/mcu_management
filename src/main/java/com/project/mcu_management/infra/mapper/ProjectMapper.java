package com.project.mcu_management.infra.mapper;

import com.project.mcu_management.domain.object.MediaType;
import com.project.mcu_management.domain.object.Project;
import com.project.mcu_management.infra.entity.ImportanceEntity;
import com.project.mcu_management.infra.entity.ProjectEntity;
import com.project.mcu_management.infra.entity.type.MediaTypeEntity;
import org.springframework.stereotype.Component;

import java.util.List;

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
        projectEntity.setUniverse(media.universe());
        projectEntity.setImportanceId(mapImportanceToId(media.importance()));
        return projectEntity;
    }

    private Integer mapImportanceToId(String importanceLabel) {
        return switch (importanceLabel) {
            case "Crucial" -> 1;
            case "Nécessaire" -> 2;
            case "Recommandé" -> 3;
            case "Optionnel" -> 4;
            default -> throw new IllegalStateException("Unexpected value: " + importanceLabel);
        };
    }

    private MediaTypeEntity mapMediaType(MediaType mediaTypeBean) {
        return switch (mediaTypeBean) {
            case FILM -> MediaTypeEntity.FILM;
            case SERIE -> MediaTypeEntity.SERIE;
        };
    }

    public Project mapToDomain(ProjectEntity media, List<ImportanceEntity> importances) {
        return new Project(media.getTitre(), media.getOrdreVisionnage(), media.getDureeMinute(),
                media.getDateSortie(),
                mapMediaTypeToDomain(MediaTypeEntity.getMediaTypeEntity(media.getTypeMedia())),
                media.getIdPhase(), media.getAffiche(), media.getUniverse(),
                mapImportances(media.getImportanceId(), importances));
    }

    private String mapImportances(Integer importanceId, List<ImportanceEntity> importances) {
        return importances.stream()
                .filter(imp -> imp.getId().equals(importanceId))
                .map(ImportanceEntity::getLabel)
                .findFirst()
                .orElse("Optionnel");
    }

    private MediaType mapMediaTypeToDomain(MediaTypeEntity mediaTypeBean) {
        return switch (mediaTypeBean) {
            case FILM -> MediaType.FILM;
            case SERIE -> MediaType.SERIE;
        };
    }
}
