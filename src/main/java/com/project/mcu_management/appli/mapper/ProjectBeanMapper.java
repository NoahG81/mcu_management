package com.project.mcu_management.appli.mapper;

import com.project.mcu_management.appli.bean.MediaTypeBean;
import com.project.mcu_management.appli.bean.ProjectBean;
import com.project.mcu_management.domain.MediaType;
import com.project.mcu_management.domain.Project;
import org.springframework.stereotype.Component;

@Component
public record ProjectBeanMapper() {
    public Project map(ProjectBean media) {
        return new Project(media.titre(), media.ordreVisionnage(), media.dureeMinutes(),
                media.dateSortie().toString(), mapMediaType(media.typeMedia()), media.phaseId(),
                media.affiche());
    }

    private MediaType mapMediaType(MediaTypeBean mediaTypeBean) {
        return switch (mediaTypeBean) {
            case FILM -> MediaType.FILM;
            case SERIE -> MediaType.SERIE;
        };
    }
}
