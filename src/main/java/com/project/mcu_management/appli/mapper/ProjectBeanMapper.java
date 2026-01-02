package com.project.mcu_management.appli.mapper;

import com.project.mcu_management.appli.bean.MediaTypeBean;
import com.project.mcu_management.appli.bean.ProjectBean;
import com.project.mcu_management.domain.MediaType;
import com.project.mcu_management.domain.Project;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public record ProjectBeanMapper() {
    public Project mapToDomain(ProjectBean media) {
        return new Project(media.titre(), media.ordreVisionnage(), media.dureeMinutes(),
                media.dateSortie().toString(), mapMediaTypetoDomain(media.typeMedia()), media.phaseId(),
                media.affiche());
    }

    public ProjectBean map(Project media) {
        return new ProjectBean(media.titre(), media.ordreVisionnage(), media.dureeMinutes(),
                LocalDate.parse(media.dateSortie()), mapMediaType(media.typeMedia()), media.phaseId(),
                media.affiche());
    }

    private MediaTypeBean mapMediaType(MediaType mediaType) {
        return switch (mediaType) {
            case FILM -> MediaTypeBean.FILM;
            case SERIE -> MediaTypeBean.SERIE;
        };
    }

    private MediaType mapMediaTypetoDomain(MediaTypeBean mediaTypeBean) {
        return switch (mediaTypeBean) {
            case FILM -> MediaType.FILM;
            case SERIE -> MediaType.SERIE;
        };
    }
}
