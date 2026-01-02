package com.project.mcu_management.infra.entity.type;

import org.apache.logging.log4j.util.Strings;

public enum MediaTypeEntity {
    FILM("film"),
    SERIE("serie");

    private final String value;

    MediaTypeEntity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MediaTypeEntity getMediaTypeEntity(String mediaName) {
        return MediaTypeEntity.valueOf(Strings.toRootUpperCase(mediaName));
    }
}
