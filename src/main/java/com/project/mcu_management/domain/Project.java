package com.project.mcu_management.domain;

public record Project(String titre, Integer ordreVisionnage, Integer dureeMinutes, String dateSortie,
                      MediaType typeMedia, Long phaseId, byte[] affiche) {
}
